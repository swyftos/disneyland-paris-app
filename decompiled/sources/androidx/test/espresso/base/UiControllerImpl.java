package androidx.test.espresso.base;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingPolicy;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.base.Interrogator;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.inject.Provider;

/* loaded from: classes2.dex */
final class UiControllerImpl implements InterruptableUiController, Handler.Callback, IdlingUiController {
    private static final Callable NO_OP = new Callable<Void>() { // from class: androidx.test.espresso.base.UiControllerImpl.1
        @Override // java.util.concurrent.Callable
        public Void call() {
            return null;
        }
    };
    private static final String TAG = "UiControllerImpl";
    private IdleNotifier asyncIdle;
    private IdleNotifier compatIdle;
    private Handler controllerHandler;
    private Provider dynamicIdleProvider;
    private final EventInjector eventInjector;
    private final IdlingResourceRegistry idlingResourceRegistry;
    private MainThreadInterrogation interrogation;
    private final Looper mainLooper;
    private final ExecutorService keyEventExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("Espresso Key Event #%d").build());
    private int generation = 0;
    private final BitSet conditionSet = IdleCondition.createConditionSet();

    /* renamed from: androidx.test.espresso.base.UiControllerImpl$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$espresso$base$UiControllerImpl$IdleCondition;

        static {
            int[] iArr = new int[IdleCondition.values().length];
            $SwitchMap$androidx$test$espresso$base$UiControllerImpl$IdleCondition = iArr;
            try {
                iArr[IdleCondition.ASYNC_TASKS_HAVE_IDLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$espresso$base$UiControllerImpl$IdleCondition[IdleCondition.COMPAT_TASKS_HAVE_IDLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$espresso$base$UiControllerImpl$IdleCondition[IdleCondition.DYNAMIC_TASKS_HAVE_IDLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    enum IdleCondition {
        DELAY_HAS_PAST,
        ASYNC_TASKS_HAVE_IDLED,
        COMPAT_TASKS_HAVE_IDLED,
        KEY_INJECT_HAS_COMPLETED,
        MOTION_INJECTION_HAS_COMPLETED,
        DYNAMIC_TASKS_HAVE_IDLED;

        public static BitSet createConditionSet() {
            return new BitSet(values().length);
        }

        public static boolean handleMessage(Message message, BitSet bitSet, int i) {
            IdleCondition[] idleConditionArrValues = values();
            int i2 = message.what;
            if (i2 < 0 || i2 >= idleConditionArrValues.length) {
                return false;
            }
            IdleCondition idleCondition = idleConditionArrValues[i2];
            if (message.arg1 == i) {
                idleCondition.signal(bitSet);
                return true;
            }
            String str = UiControllerImpl.TAG;
            String strValueOf = String.valueOf(idleCondition);
            int i3 = message.arg1;
            StringBuilder sb = new StringBuilder(strValueOf.length() + 90);
            sb.append("ignoring signal of: ");
            sb.append(strValueOf);
            sb.append(" from previous generation: ");
            sb.append(i3);
            sb.append(" current generation: ");
            sb.append(i);
            Log.w(str, sb.toString());
            return true;
        }

        public Message createSignal(Handler handler, int i) {
            return Message.obtain(handler, ordinal(), i, 0, null);
        }

        public boolean isSignaled(BitSet bitSet) {
            return bitSet.get(ordinal());
        }

        public void reset(BitSet bitSet) {
            bitSet.set(ordinal(), false);
        }

        protected void signal(BitSet bitSet) {
            bitSet.set(ordinal());
        }
    }

    private enum InterrogationStatus {
        TIMED_OUT,
        COMPLETED,
        INTERRUPTED
    }

    private static final class MainThreadInterrogation implements Interrogator.InterrogationHandler<InterrogationStatus> {
        private final BitSet conditionSet;
        private final EnumSet conditions;
        private final long giveUpAtMs;
        private String lastMessage;
        private InterrogationStatus status = InterrogationStatus.COMPLETED;
        private int execCount = 0;

        MainThreadInterrogation(EnumSet enumSet, BitSet bitSet, long j) {
            this.conditions = enumSet;
            this.conditionSet = bitSet;
            this.giveUpAtMs = j;
        }

        private boolean conditionsMet() {
            boolean z = true;
            if (InterrogationStatus.INTERRUPTED == this.status) {
                return true;
            }
            int i = this.execCount;
            boolean z2 = i > 0 && i % 100 == 0;
            Iterator it = this.conditions.iterator();
            while (it.hasNext()) {
                IdleCondition idleCondition = (IdleCondition) it.next();
                if (!idleCondition.isSignaled(this.conditionSet)) {
                    if (!z2) {
                        return false;
                    }
                    String str = UiControllerImpl.TAG;
                    String strName = idleCondition.name();
                    int i2 = this.execCount;
                    StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 41);
                    sb.append("Waiting for: ");
                    sb.append(strName);
                    sb.append(" for ");
                    sb.append(i2);
                    sb.append(" iterations.");
                    Log.w(str, sb.toString());
                    z = false;
                }
            }
            return z;
        }

        private boolean continueOrTimeout() {
            if (InterrogationStatus.INTERRUPTED == this.status) {
                return false;
            }
            if (SystemClock.uptimeMillis() < this.giveUpAtMs) {
                return true;
            }
            this.status = InterrogationStatus.TIMED_OUT;
            return false;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean barrierUp() {
            return continueOrTimeout();
        }

        @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
        public boolean beforeTaskDispatch() {
            this.execCount++;
            return continueOrTimeout();
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public InterrogationStatus get() {
            return this.status;
        }

        public String getMessage() {
            return this.lastMessage;
        }

        void interruptInterrogation() {
            this.status = InterrogationStatus.INTERRUPTED;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean queueEmpty() {
            return !conditionsMet();
        }

        @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
        public void quitting() {
        }

        @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
        public void setMessage(Message message) {
            try {
                this.lastMessage = message.toString();
            } catch (NullPointerException e) {
                String strValueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
                sb.append("NPE calling message toString(): ");
                sb.append(strValueOf);
                this.lastMessage = sb.toString();
            }
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean taskDueLong() {
            return !conditionsMet();
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean taskDueSoon() {
            return continueOrTimeout();
        }
    }

    private class SignalingTask<T> extends FutureTask<T> {
        private final IdleCondition condition;
        private final int myGeneration;

        public SignalingTask(Callable callable, IdleCondition idleCondition, int i) {
            super(callable);
            this.condition = (IdleCondition) Preconditions.checkNotNull(idleCondition);
            this.myGeneration = i;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            UiControllerImpl.this.controllerHandler.sendMessage(this.condition.createSignal(UiControllerImpl.this.controllerHandler, this.myGeneration));
        }
    }

    UiControllerImpl(EventInjector eventInjector, IdleNotifier idleNotifier, IdleNotifier idleNotifier2, Provider provider, Looper looper, IdlingResourceRegistry idlingResourceRegistry) {
        this.eventInjector = (EventInjector) Preconditions.checkNotNull(eventInjector);
        this.asyncIdle = (IdleNotifier) Preconditions.checkNotNull(idleNotifier);
        this.compatIdle = (IdleNotifier) Preconditions.checkNotNull(idleNotifier2);
        this.dynamicIdleProvider = (Provider) Preconditions.checkNotNull(provider);
        this.mainLooper = (Looper) Preconditions.checkNotNull(looper);
        this.idlingResourceRegistry = (IdlingResourceRegistry) Preconditions.checkNotNull(idlingResourceRegistry);
    }

    private void initialize() {
        if (this.controllerHandler == null) {
            this.controllerHandler = new Handler(this);
        }
    }

    private void loopUntil(IdleCondition idleCondition, IdleNotifier idleNotifier) {
        loopUntil(EnumSet.of(idleCondition), idleNotifier);
    }

    @Override // androidx.test.espresso.base.IdlingUiController
    public IdlingResourceRegistry getIdlingResourceRegistry() {
        return this.idlingResourceRegistry;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (IdleCondition.handleMessage(message, this.conditionSet, this.generation)) {
            return true;
        }
        String str = TAG;
        String strValueOf = String.valueOf(message);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Unknown message type: ");
        sb.append(strValueOf);
        Log.i(str, sb.toString());
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.test.espresso.UiController
    public boolean injectKeyEvent(final KeyEvent keyEvent) throws InjectEventSecurityException {
        Preconditions.checkNotNull(keyEvent);
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        loopMainThreadUntilIdle();
        Callable<Boolean> callable = new Callable<Boolean>() { // from class: androidx.test.espresso.base.UiControllerImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                return Boolean.valueOf(UiControllerImpl.this.eventInjector.injectKeyEvent(keyEvent));
            }
        };
        IdleCondition idleCondition = IdleCondition.KEY_INJECT_HAS_COMPLETED;
        SignalingTask signalingTask = new SignalingTask(callable, idleCondition, this.generation);
        this.keyEventExecutor.submit(signalingTask);
        loopUntil(idleCondition, (IdleNotifier) this.dynamicIdleProvider.get2());
        try {
            Preconditions.checkState(signalingTask.isDone(), "Key injection was signaled - but it wasnt done.");
            return ((Boolean) signalingTask.get()).booleanValue();
        } catch (InterruptedException e) {
            throw new RuntimeException("impossible.", e);
        } catch (ExecutionException e2) {
            if (e2.getCause() instanceof InjectEventSecurityException) {
                throw ((InjectEventSecurityException) e2.getCause());
            }
            throw new RuntimeException(e2.getCause());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.test.espresso.UiController
    public boolean injectMotionEvent(final MotionEvent motionEvent) {
        Preconditions.checkNotNull(motionEvent);
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        Callable<Boolean> callable = new Callable<Boolean>() { // from class: androidx.test.espresso.base.UiControllerImpl.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                return Boolean.valueOf(UiControllerImpl.this.eventInjector.injectMotionEvent(motionEvent));
            }
        };
        IdleCondition idleCondition = IdleCondition.MOTION_INJECTION_HAS_COMPLETED;
        SignalingTask signalingTask = new SignalingTask(callable, idleCondition, this.generation);
        this.keyEventExecutor.submit(signalingTask);
        loopUntil(idleCondition, (IdleNotifier) this.dynamicIdleProvider.get2());
        try {
            try {
                Preconditions.checkState(signalingTask.isDone(), "Motion event injection was signaled - but it wasnt done.");
                return ((Boolean) signalingTask.get()).booleanValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e2) {
                e = e2;
                if (e.getCause() instanceof InjectEventSecurityException) {
                    throw ((InjectEventSecurityException) e.getCause());
                }
                Throwables.throwIfUnchecked(e.getCause() != null ? e.getCause() : e);
                if (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new RuntimeException(e);
            }
        } finally {
            loopMainThreadUntilIdle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.test.espresso.UiController
    public boolean injectMotionEventSequence(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkState(!Iterables.isEmpty(iterable), "Expecting non-empty events to inject");
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        final Iterator it = iterable.iterator();
        final long jUptimeMillis = SystemClock.uptimeMillis() - ((MotionEvent) Iterables.getFirst(iterable, null)).getEventTime();
        Callable<Boolean> callable = new Callable<Boolean>() { // from class: androidx.test.espresso.base.UiControllerImpl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                boolean zInjectMotionEventAsync = true;
                while (it.hasNext()) {
                    MotionEvent motionEvent = (MotionEvent) it.next();
                    long eventTime = (motionEvent.getEventTime() + jUptimeMillis) - SystemClock.uptimeMillis();
                    if (eventTime > 10) {
                        SystemClock.sleep(eventTime);
                    }
                    zInjectMotionEventAsync &= it.hasNext() ? UiControllerImpl.this.eventInjector.injectMotionEventAsync(motionEvent) : UiControllerImpl.this.eventInjector.injectMotionEvent(motionEvent);
                }
                return Boolean.valueOf(zInjectMotionEventAsync);
            }
        };
        IdleCondition idleCondition = IdleCondition.MOTION_INJECTION_HAS_COMPLETED;
        SignalingTask signalingTask = new SignalingTask(callable, idleCondition, this.generation);
        this.keyEventExecutor.submit(signalingTask);
        loopUntil(idleCondition, (IdleNotifier) this.dynamicIdleProvider.get2());
        try {
            try {
                Preconditions.checkState(signalingTask.isDone(), "MotionEvents injection was signaled - but it wasnt done.");
                return ((Boolean) signalingTask.get()).booleanValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e2) {
                e = e2;
                if (e.getCause() instanceof InjectEventSecurityException) {
                    throw ((InjectEventSecurityException) e.getCause());
                }
                Throwables.throwIfUnchecked(e.getCause() != null ? e.getCause() : e);
                if (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new RuntimeException(e);
            }
        } finally {
            loopMainThreadUntilIdle();
        }
    }

    @Override // androidx.test.espresso.UiController
    public boolean injectString(String str) throws InjectEventSecurityException {
        Preconditions.checkNotNull(str);
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        if (str.isEmpty()) {
            Log.w(TAG, "Supplied string is empty resulting in no-op (nothing is typed).");
            return true;
        }
        KeyEvent[] events = getKeyCharacterMap().getEvents(str.toCharArray());
        if (events == null) {
            throw new RuntimeException(String.format(Locale.ROOT, "Failed to get key events for string %s (i.e. current IME does not understand how to translate the string into key events). As a workaround, you can use replaceText action to set the text directly in the EditText field.", str));
        }
        Log.d(TAG, String.format(Locale.ROOT, "Injecting string: \"%s\"", str));
        int length = events.length;
        int i = 0;
        boolean zInjectKeyEvent = false;
        while (true) {
            if (i >= length) {
                break;
            }
            KeyEvent keyEvent = events[i];
            Preconditions.checkNotNull(keyEvent, String.format(Locale.ROOT, "Failed to get event for character (%c) with key code (%s)", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getUnicodeChar())));
            KeyEvent keyEventChangeTimeRepeat = keyEvent;
            zInjectKeyEvent = false;
            for (int i2 = 0; !zInjectKeyEvent && i2 < 4; i2++) {
                keyEventChangeTimeRepeat = KeyEvent.changeTimeRepeat(keyEventChangeTimeRepeat, SystemClock.uptimeMillis(), 0);
                zInjectKeyEvent = injectKeyEvent(keyEventChangeTimeRepeat);
            }
            if (!zInjectKeyEvent) {
                Log.e(TAG, String.format(Locale.ROOT, "Failed to inject event for character (%c) with key code (%s)", Integer.valueOf(keyEventChangeTimeRepeat.getUnicodeChar()), Integer.valueOf(keyEventChangeTimeRepeat.getKeyCode())));
                break;
            }
            i++;
        }
        return zInjectKeyEvent;
    }

    @Override // androidx.test.espresso.base.InterruptableUiController
    public void interruptEspressoTasks() {
        initialize();
        this.controllerHandler.post(new Runnable() { // from class: androidx.test.espresso.base.UiControllerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                if (UiControllerImpl.this.interrogation != null) {
                    UiControllerImpl.this.interrogation.interruptInterrogation();
                    UiControllerImpl.this.controllerHandler.removeCallbacksAndMessages(Integer.valueOf(UiControllerImpl.this.generation));
                }
            }
        });
    }

    @Override // androidx.test.espresso.UiController
    public void loopMainThreadForAtLeast(long j) {
        initialize();
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        IdleCondition idleCondition = IdleCondition.DELAY_HAS_PAST;
        Preconditions.checkState(!idleCondition.isSignaled(this.conditionSet), "recursion detected!");
        Preconditions.checkArgument(j > 0);
        this.controllerHandler.postAtTime(new SignalingTask(NO_OP, idleCondition, this.generation), Integer.valueOf(this.generation), SystemClock.uptimeMillis() + j);
        loopUntil(idleCondition, (IdleNotifier) this.dynamicIdleProvider.get2());
        loopMainThreadUntilIdle();
    }

    @Override // androidx.test.espresso.UiController
    public void loopMainThreadUntilIdle() {
        initialize();
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        IdleNotifier idleNotifierLoopUntil = (IdleNotifier) this.dynamicIdleProvider.get2();
        while (true) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(IdleCondition.class);
            if (!this.asyncIdle.isIdleNow()) {
                IdleNotifier idleNotifier = this.asyncIdle;
                Callable callable = NO_OP;
                IdleCondition idleCondition = IdleCondition.ASYNC_TASKS_HAVE_IDLED;
                idleNotifier.registerNotificationCallback(new SignalingTask(callable, idleCondition, this.generation));
                enumSetNoneOf.add(idleCondition);
            }
            if (!this.compatIdle.isIdleNow()) {
                IdleNotifier idleNotifier2 = this.compatIdle;
                Callable callable2 = NO_OP;
                IdleCondition idleCondition2 = IdleCondition.COMPAT_TASKS_HAVE_IDLED;
                idleNotifier2.registerNotificationCallback(new SignalingTask(callable2, idleCondition2, this.generation));
                enumSetNoneOf.add(idleCondition2);
            }
            if (!idleNotifierLoopUntil.isIdleNow()) {
                final IdlingPolicy dynamicIdlingResourceWarningPolicy = IdlingPolicies.getDynamicIdlingResourceWarningPolicy();
                final IdlingPolicy dynamicIdlingResourceErrorPolicy = IdlingPolicies.getDynamicIdlingResourceErrorPolicy();
                Callable callable3 = NO_OP;
                IdleCondition idleCondition3 = IdleCondition.DYNAMIC_TASKS_HAVE_IDLED;
                final SignalingTask signalingTask = new SignalingTask(callable3, idleCondition3, this.generation);
                idleNotifierLoopUntil.registerNotificationCallback(new IdlingResourceRegistry.IdleNotificationCallback() { // from class: androidx.test.espresso.base.UiControllerImpl.5
                    @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
                    public void allResourcesIdle() {
                        UiControllerImpl.this.controllerHandler.post(signalingTask);
                    }

                    @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
                    public void resourcesHaveTimedOut(List list) {
                        dynamicIdlingResourceErrorPolicy.handleTimeout(list, "IdlingResources have timed out!");
                        UiControllerImpl.this.controllerHandler.post(signalingTask);
                    }

                    @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
                    public void resourcesStillBusyWarning(List list) {
                        dynamicIdlingResourceWarningPolicy.handleTimeout(list, "IdlingResources are still busy!");
                    }
                });
                enumSetNoneOf.add(idleCondition3);
            }
            try {
                idleNotifierLoopUntil = loopUntil(enumSetNoneOf, idleNotifierLoopUntil);
                this.asyncIdle.cancelCallback();
                this.compatIdle.cancelCallback();
                idleNotifierLoopUntil.cancelCallback();
                if (this.asyncIdle.isIdleNow() && this.compatIdle.isIdleNow() && idleNotifierLoopUntil.isIdleNow()) {
                    return;
                }
            } catch (Throwable th) {
                this.asyncIdle.cancelCallback();
                this.compatIdle.cancelCallback();
                idleNotifierLoopUntil.cancelCallback();
                throw th;
            }
        }
    }

    public static KeyCharacterMap getKeyCharacterMap() {
        return KeyCharacterMap.load(-1);
    }

    private IdleNotifier loopUntil(EnumSet enumSet, IdleNotifier idleNotifier) {
        IdlingPolicy masterIdlingPolicy = IdlingPolicies.getMasterIdlingPolicy();
        IdlingPolicy dynamicIdlingResourceErrorPolicy = IdlingPolicies.getDynamicIdlingResourceErrorPolicy();
        try {
            MainThreadInterrogation mainThreadInterrogation = new MainThreadInterrogation(enumSet, this.conditionSet, SystemClock.uptimeMillis() + masterIdlingPolicy.getIdleTimeoutUnit().toMillis(masterIdlingPolicy.getIdleTimeout()));
            this.interrogation = mainThreadInterrogation;
            InterrogationStatus interrogationStatus = (InterrogationStatus) Interrogator.loopAndInterrogate(mainThreadInterrogation);
            if (InterrogationStatus.COMPLETED == interrogationStatus) {
                this.generation++;
                Iterator it = enumSet.iterator();
                while (it.hasNext()) {
                    ((IdleCondition) it.next()).reset(this.conditionSet);
                }
                this.interrogation = null;
                return idleNotifier;
            }
            if (InterrogationStatus.INTERRUPTED == interrogationStatus) {
                Log.w(TAG, "Espresso interrogation of the main thread is interrupted");
                throw new RuntimeException("Espresso interrogation of the main thread is interrupted");
            }
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            Iterator it2 = enumSet.iterator();
            while (it2.hasNext()) {
                IdleCondition idleCondition = (IdleCondition) it2.next();
                if (!idleCondition.isSignaled(this.conditionSet)) {
                    arrayListNewArrayList.add(idleCondition.name());
                    int i = AnonymousClass7.$SwitchMap$androidx$test$espresso$base$UiControllerImpl$IdleCondition[idleCondition.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 && (dynamicIdlingResourceErrorPolicy.getDisableOnTimeout() || (!masterIdlingPolicy.getTimeoutIfDebuggerAttached() && Debug.isDebuggerConnected()))) {
                                idleNotifier.cancelCallback();
                                NoopIdleNotificationCallbackIdleNotifierProvider noopIdleNotificationCallbackIdleNotifierProvider = new NoopIdleNotificationCallbackIdleNotifierProvider();
                                this.dynamicIdleProvider = noopIdleNotificationCallbackIdleNotifierProvider;
                                idleNotifier = (IdleNotifier) noopIdleNotificationCallbackIdleNotifierProvider.get2();
                            }
                        } else if (masterIdlingPolicy.getDisableOnTimeout() || (!masterIdlingPolicy.getTimeoutIfDebuggerAttached() && Debug.isDebuggerConnected())) {
                            this.compatIdle.cancelCallback();
                            this.compatIdle = new NoopRunnableIdleNotifier();
                        }
                    } else if (masterIdlingPolicy.getDisableOnTimeout() || (!masterIdlingPolicy.getTimeoutIfDebuggerAttached() && Debug.isDebuggerConnected())) {
                        this.asyncIdle.cancelCallback();
                        this.asyncIdle = new NoopRunnableIdleNotifier();
                    }
                }
            }
            if (arrayListNewArrayList.isEmpty()) {
                String message = this.interrogation.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 37);
                sb.append("MAIN_LOOPER_HAS_IDLED(last message: ");
                sb.append(message);
                sb.append(")");
                arrayListNewArrayList.add(sb.toString());
            }
            masterIdlingPolicy.handleTimeout(arrayListNewArrayList, String.format(Locale.ROOT, "Looped for %s iterations over %s %s.", Integer.valueOf(this.interrogation.execCount), Long.valueOf(masterIdlingPolicy.getIdleTimeout()), masterIdlingPolicy.getIdleTimeoutUnit().name()));
            this.generation++;
            Iterator it3 = enumSet.iterator();
            while (it3.hasNext()) {
                ((IdleCondition) it3.next()).reset(this.conditionSet);
            }
            this.interrogation = null;
            return idleNotifier;
        } catch (Throwable th) {
            this.generation++;
            Iterator it4 = enumSet.iterator();
            while (it4.hasNext()) {
                ((IdleCondition) it4.next()).reset(this.conditionSet);
            }
            this.interrogation = null;
            throw th;
        }
    }
}
