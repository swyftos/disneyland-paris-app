package com.facebook.react.modules.core;

import android.util.SparseArray;
import android.view.Choreographer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.modules.core.JavaTimerManager;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0005?@ABCB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020#H\u0016J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J \u00101\u001a\u00020#2\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u001dH\u0017J(\u00106\u001a\u00020#2\u0006\u00102\u001a\u00020(2\u0006\u00107\u001a\u00020(2\u0006\u00108\u001a\u0002092\u0006\u00105\u001a\u00020\u001dH\u0016J\u0010\u0010:\u001a\u00020#2\u0006\u00102\u001a\u00020(H\u0017J\u0010\u0010;\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001dH\u0017J\u0015\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u000204H\u0000¢\u0006\u0002\b>R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0018\u00010\u001bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/facebook/react/modules/core/JavaTimerManager;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "javaScriptTimerExecutor", "Lcom/facebook/react/modules/core/JavaScriptTimerExecutor;", "reactChoreographer", "Lcom/facebook/react/modules/core/ReactChoreographer;", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/modules/core/JavaScriptTimerExecutor;Lcom/facebook/react/modules/core/ReactChoreographer;Lcom/facebook/react/devsupport/interfaces/DevSupportManager;)V", "timerGuard", "", "idleCallbackGuard", "timerIdsToTimers", "Landroid/util/SparseArray;", "Lcom/facebook/react/modules/core/JavaTimerManager$Timer;", "isPaused", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunningTasks", "timerFrameCallback", "Lcom/facebook/react/modules/core/JavaTimerManager$TimerFrameCallback;", "idleFrameCallback", "Lcom/facebook/react/modules/core/JavaTimerManager$IdleFrameCallback;", "currentIdleCallbackRunnable", "Lcom/facebook/react/modules/core/JavaTimerManager$IdleCallbackRunnable;", "frameCallbackPosted", "", "frameIdleCallbackPosted", "sendIdleEvents", "timers", "Ljava/util/PriorityQueue;", "onHostPause", "", "onHostDestroy", "onHostResume", "onHeadlessJsTaskStart", "taskId", "", "onHeadlessJsTaskFinish", "onInstanceDestroy", "maybeSetChoreographerIdleCallback", "maybeIdleCallback", "setChoreographerCallback", "clearFrameCallback", "setChoreographerIdleCallback", "clearChoreographerIdleCallback", "createTimer", "timerId", "delay", "", "repeat", "createAndMaybeCallTimer", TypedValues.TransitionType.S_DURATION, "jsSchedulingTime", "", "deleteTimer", "setSendIdleEvents", "hasActiveTimersInRange", "rangeMs", "hasActiveTimersInRange$ReactAndroid_release", "Timer", "TimerFrameCallback", "IdleFrameCallback", "IdleCallbackRunnable", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJavaTimerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTimerManager.kt\ncom/facebook/react/modules/core/JavaTimerManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,366:1\n1#2:367\n*E\n"})
/* loaded from: classes3.dex */
public class JavaTimerManager implements LifecycleEventListener, HeadlessJsTaskEventListener {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private static final float FRAME_DURATION_MS = 16.666666f;
    private static final float IDLE_CALLBACK_FRAME_DEADLINE_MS = 1.0f;
    private static final int TIMER_QUEUE_CAPACITY = 11;

    @Nullable
    private IdleCallbackRunnable currentIdleCallbackRunnable;

    @NotNull
    private final DevSupportManager devSupportManager;
    private boolean frameCallbackPosted;
    private boolean frameIdleCallbackPosted;

    @NotNull
    private final Object idleCallbackGuard;

    @NotNull
    private final IdleFrameCallback idleFrameCallback;

    @NotNull
    private final AtomicBoolean isPaused;

    @NotNull
    private final AtomicBoolean isRunningTasks;

    @NotNull
    private final JavaScriptTimerExecutor javaScriptTimerExecutor;

    @NotNull
    private final ReactApplicationContext reactApplicationContext;

    @NotNull
    private final ReactChoreographer reactChoreographer;
    private boolean sendIdleEvents;

    @NotNull
    private final TimerFrameCallback timerFrameCallback;

    @NotNull
    private final Object timerGuard;

    @NotNull
    private final SparseArray<Timer> timerIdsToTimers;

    @NotNull
    private final PriorityQueue<Timer> timers;

    public JavaTimerManager(@NotNull ReactApplicationContext reactApplicationContext, @NotNull JavaScriptTimerExecutor javaScriptTimerExecutor, @NotNull ReactChoreographer reactChoreographer, @NotNull DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(javaScriptTimerExecutor, "javaScriptTimerExecutor");
        Intrinsics.checkNotNullParameter(reactChoreographer, "reactChoreographer");
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.reactApplicationContext = reactApplicationContext;
        this.javaScriptTimerExecutor = javaScriptTimerExecutor;
        this.reactChoreographer = reactChoreographer;
        this.devSupportManager = devSupportManager;
        this.timerGuard = new Object();
        this.idleCallbackGuard = new Object();
        this.timerIdsToTimers = new SparseArray<>();
        this.isPaused = new AtomicBoolean(true);
        this.isRunningTasks = new AtomicBoolean(false);
        this.timerFrameCallback = new TimerFrameCallback();
        this.idleFrameCallback = new IdleFrameCallback();
        final Function2 function2 = new Function2() { // from class: com.facebook.react.modules.core.JavaTimerManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(JavaTimerManager.timers$lambda$0((JavaTimerManager.Timer) obj, (JavaTimerManager.Timer) obj2));
            }
        };
        this.timers = new PriorityQueue<>(11, new Comparator() { // from class: com.facebook.react.modules.core.JavaTimerManager$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return JavaTimerManager.timers$lambda$1(function2, obj, obj2);
            }
        });
        reactApplicationContext.addLifecycleEventListener(this);
        HeadlessJsTaskContext.INSTANCE.getInstance(reactApplicationContext).addTaskEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/modules/core/JavaTimerManager$Timer;", "", "timerId", "", "targetTime", "", "interval", "repeat", "", "<init>", "(IJIZ)V", "getTimerId", "()I", "getTargetTime", "()J", "setTargetTime", "(J)V", "getInterval", "getRepeat", "()Z", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class Timer {
        private final int interval;
        private final boolean repeat;
        private long targetTime;
        private final int timerId;

        public Timer(int i, long j, int i2, boolean z) {
            this.timerId = i;
            this.targetTime = j;
            this.interval = i2;
            this.repeat = z;
        }

        public final int getTimerId() {
            return this.timerId;
        }

        public final long getTargetTime() {
            return this.targetTime;
        }

        public final void setTargetTime(long j) {
            this.targetTime = j;
        }

        public final int getInterval() {
            return this.interval;
        }

        public final boolean getRepeat() {
            return this.repeat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int timers$lambda$0(Timer timer, Timer timer2) {
        return MathKt.getSign(timer.getTargetTime() - timer2.getTargetTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int timers$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.isPaused.set(true);
        clearFrameCallback();
        maybeIdleCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        clearFrameCallback();
        maybeIdleCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.isPaused.set(false);
        setChoreographerCallback();
        maybeSetChoreographerIdleCallback();
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int taskId) {
        if (this.isRunningTasks.getAndSet(true)) {
            return;
        }
        setChoreographerCallback();
        maybeSetChoreographerIdleCallback();
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int taskId) {
        if (HeadlessJsTaskContext.INSTANCE.getInstance(this.reactApplicationContext).hasActiveTasks()) {
            return;
        }
        this.isRunningTasks.set(false);
        clearFrameCallback();
        maybeIdleCallback();
    }

    public void onInstanceDestroy() {
        HeadlessJsTaskContext.INSTANCE.getInstance(this.reactApplicationContext).removeTaskEventListener(this);
        this.reactApplicationContext.removeLifecycleEventListener(this);
        clearFrameCallback();
        clearChoreographerIdleCallback();
    }

    private final void maybeSetChoreographerIdleCallback() {
        synchronized (this.idleCallbackGuard) {
            try {
                if (this.sendIdleEvents) {
                    setChoreographerIdleCallback();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void maybeIdleCallback() {
        if (!this.isPaused.get() || this.isRunningTasks.get()) {
            return;
        }
        clearFrameCallback();
    }

    private final void setChoreographerCallback() {
        if (this.frameCallbackPosted) {
            return;
        }
        this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.timerFrameCallback);
        this.frameCallbackPosted = true;
    }

    private final void clearFrameCallback() {
        HeadlessJsTaskContext companion = HeadlessJsTaskContext.INSTANCE.getInstance(this.reactApplicationContext);
        if (this.frameCallbackPosted && this.isPaused.get() && !companion.hasActiveTasks()) {
            this.reactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.timerFrameCallback);
            this.frameCallbackPosted = false;
        }
    }

    private final void setChoreographerIdleCallback() {
        if (this.frameIdleCallbackPosted) {
            return;
        }
        this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.idleFrameCallback);
        this.frameIdleCallbackPosted = true;
    }

    private final void clearChoreographerIdleCallback() {
        if (this.frameIdleCallbackPosted) {
            this.reactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.idleFrameCallback);
            this.frameIdleCallbackPosted = false;
        }
    }

    @DoNotStrip
    public void createTimer(int timerId, long delay, boolean repeat) {
        Timer timer = new Timer(timerId, (SystemClock.nanoTime() / 1000000) + delay, (int) delay, repeat);
        synchronized (this.timerGuard) {
            this.timers.add(timer);
            this.timerIdsToTimers.put(timerId, timer);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void createAndMaybeCallTimer(int timerId, int duration, double jsSchedulingTime, boolean repeat) {
        long jCurrentTimeMillis = SystemClock.currentTimeMillis();
        long j = (long) jsSchedulingTime;
        if (this.devSupportManager.getDevSupportEnabled() && Math.abs(j - jCurrentTimeMillis) > 60000) {
            this.javaScriptTimerExecutor.emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        long jMax = Math.max(0L, (j - jCurrentTimeMillis) + duration);
        if (duration == 0 && !repeat) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            writableArrayCreateArray.pushInt(timerId);
            JavaScriptTimerExecutor javaScriptTimerExecutor = this.javaScriptTimerExecutor;
            Intrinsics.checkNotNull(writableArrayCreateArray);
            javaScriptTimerExecutor.callTimers(writableArrayCreateArray);
            return;
        }
        createTimer(timerId, jMax, repeat);
    }

    @DoNotStrip
    public void deleteTimer(int timerId) {
        synchronized (this.timerGuard) {
            Timer timer = this.timerIdsToTimers.get(timerId);
            if (timer == null) {
                return;
            }
            this.timerIdsToTimers.remove(timerId);
            this.timers.remove(timer);
        }
    }

    @DoNotStrip
    public void setSendIdleEvents(final boolean sendIdleEvents) {
        synchronized (this.idleCallbackGuard) {
            this.sendIdleEvents = sendIdleEvents;
            Unit unit = Unit.INSTANCE;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.core.JavaTimerManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                JavaTimerManager.setSendIdleEvents$lambda$7(this.f$0, sendIdleEvents);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSendIdleEvents$lambda$7(JavaTimerManager javaTimerManager, boolean z) {
        synchronized (javaTimerManager.idleCallbackGuard) {
            try {
                if (z) {
                    javaTimerManager.setChoreographerIdleCallback();
                } else {
                    javaTimerManager.clearChoreographerIdleCallback();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean hasActiveTimersInRange$ReactAndroid_release(long rangeMs) {
        synchronized (this.timerGuard) {
            Timer timerPeek = this.timers.peek();
            if (timerPeek == null) {
                return false;
            }
            if (Companion.isTimerInRange(timerPeek, rangeMs)) {
                return true;
            }
            Iterator<Timer> it = this.timers.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Timer next = it.next();
                Companion companion = Companion;
                Intrinsics.checkNotNull(next);
                if (companion.isTimerInRange(next, rangeMs)) {
                    return true;
                }
            }
            Unit unit = Unit.INSTANCE;
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/react/modules/core/JavaTimerManager$TimerFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "<init>", "(Lcom/facebook/react/modules/core/JavaTimerManager;)V", "timersToCall", "Lcom/facebook/react/bridge/WritableArray;", "doFrame", "", "frameTimeNanos", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class TimerFrameCallback implements Choreographer.FrameCallback {

        @Nullable
        private WritableArray timersToCall;

        public TimerFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            Timer timer;
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                long j = frameTimeNanos / 1000000;
                Object obj = JavaTimerManager.this.timerGuard;
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                synchronized (obj) {
                    while (!javaTimerManager.timers.isEmpty()) {
                        try {
                            Object objPeek = javaTimerManager.timers.peek();
                            Intrinsics.checkNotNull(objPeek);
                            if (((Timer) objPeek).getTargetTime() >= j || (timer = (Timer) javaTimerManager.timers.poll()) == null) {
                                break;
                            }
                            if (this.timersToCall == null) {
                                this.timersToCall = Arguments.createArray();
                            }
                            WritableArray writableArray = this.timersToCall;
                            if (writableArray != null) {
                                writableArray.pushInt(timer.getTimerId());
                            }
                            if (!timer.getRepeat()) {
                                javaTimerManager.timerIdsToTimers.remove(timer.getTimerId());
                            } else {
                                timer.setTargetTime(timer.getInterval() + j);
                                javaTimerManager.timers.add(timer);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                WritableArray writableArray2 = this.timersToCall;
                if (writableArray2 != null) {
                    JavaTimerManager.this.javaScriptTimerExecutor.callTimers(writableArray2);
                    this.timersToCall = null;
                }
                JavaTimerManager.this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/facebook/react/modules/core/JavaTimerManager$IdleFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "<init>", "(Lcom/facebook/react/modules/core/JavaTimerManager;)V", "doFrame", "", "frameTimeNanos", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class IdleFrameCallback implements Choreographer.FrameCallback {
        public IdleFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                IdleCallbackRunnable idleCallbackRunnable = JavaTimerManager.this.currentIdleCallbackRunnable;
                if (idleCallbackRunnable != null) {
                    idleCallbackRunnable.cancel();
                }
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                javaTimerManager.currentIdleCallbackRunnable = javaTimerManager.new IdleCallbackRunnable(frameTimeNanos);
                JavaTimerManager.this.reactApplicationContext.runOnJSQueueThread(JavaTimerManager.this.currentIdleCallbackRunnable);
                JavaTimerManager.this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/modules/core/JavaTimerManager$IdleCallbackRunnable;", "Ljava/lang/Runnable;", "frameStartTime", "", "<init>", "(Lcom/facebook/react/modules/core/JavaTimerManager;J)V", "isCancelled", "", "run", "", "cancel", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nJavaTimerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTimerManager.kt\ncom/facebook/react/modules/core/JavaTimerManager$IdleCallbackRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,366:1\n1#2:367\n*E\n"})
    private final class IdleCallbackRunnable implements Runnable {
        private final long frameStartTime;
        private volatile boolean isCancelled;

        public IdleCallbackRunnable(long j) {
            this.frameStartTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (this.isCancelled) {
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - (this.frameStartTime / 1000000);
            long jCurrentTimeMillis = SystemClock.currentTimeMillis() - jUptimeMillis;
            if (JavaTimerManager.FRAME_DURATION_MS - jUptimeMillis < 1.0f) {
                return;
            }
            Object obj = JavaTimerManager.this.idleCallbackGuard;
            JavaTimerManager javaTimerManager = JavaTimerManager.this;
            synchronized (obj) {
                z = javaTimerManager.sendIdleEvents;
                Unit unit = Unit.INSTANCE;
            }
            if (z) {
                JavaTimerManager.this.javaScriptTimerExecutor.callIdleCallbacks(jCurrentTimeMillis);
            }
            JavaTimerManager.this.currentIdleCallbackRunnable = null;
        }

        public final void cancel() {
            this.isCancelled = true;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/modules/core/JavaTimerManager$Companion;", "", "<init>", "()V", "IDLE_CALLBACK_FRAME_DEADLINE_MS", "", "FRAME_DURATION_MS", "TIMER_QUEUE_CAPACITY", "", "isTimerInRange", "", "timer", "Lcom/facebook/react/modules/core/JavaTimerManager$Timer;", "rangeMs", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isTimerInRange(Timer timer, long rangeMs) {
            return !timer.getRepeat() && ((long) timer.getInterval()) < rangeMs;
        }
    }
}
