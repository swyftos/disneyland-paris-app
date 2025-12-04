package com.disney.id.android.tracker;

import android.content.Context;
import android.os.Build;
import com.disney.id.android.Connectivity;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.OneIDEventQueue;
import com.disney.id.android.tracker.OneIDEventQueue.SenderThread;
import com.disney.id.android.tracker.Sender;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0016\b\u0000\u0018\u0000 52\u00020\u0001:\u000256B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\bH\u0016J\u0010\u00104\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\n \f*\u0004\u0018\u00010+0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/disney/id/android/tracker/OneIDEventQueue;", "Lcom/disney/id/android/tracker/EventQueue;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "baseParameters", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "connectivity", "Lcom/disney/id/android/Connectivity;", "getConnectivity$OneID_release", "()Lcom/disney/id/android/Connectivity;", "setConnectivity$OneID_release", "(Lcom/disney/id/android/Connectivity;)V", "delayAfterSuccessfulLogAttempt", "", "eventQueueConnectivityListener", "com/disney/id/android/tracker/OneIDEventQueue$eventQueueConnectivityListener$1", "Lcom/disney/id/android/tracker/OneIDEventQueue$eventQueueConnectivityListener$1;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "mThread", "Ljava/lang/Thread;", "requestQueue", "Lcom/disney/id/android/tracker/CircularEventTrackingQueue;", "sender", "Lcom/disney/id/android/tracker/Sender;", "getSender$OneID_release", "()Lcom/disney/id/android/tracker/Sender;", "setSender$OneID_release", "(Lcom/disney/id/android/tracker/Sender;)V", "serialExecutor", "Ljava/util/concurrent/ExecutorService;", "timeToWaitAfterFailure", "addEventToQueue", "", "event", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "addToBaseParameters", "key", "value", "enqueue", "Companion", "SenderThread", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneIDEventQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDEventQueue.kt\ncom/disney/id/android/tracker/OneIDEventQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1#2:173\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDEventQueue implements EventQueue {
    private static final String TAG = OneIDEventQueue.class.getSimpleName();
    private final HashMap baseParameters;
    private final Condition condition;

    @Inject
    public Connectivity connectivity;
    private final long delayAfterSuccessfulLogAttempt;
    private final OneIDEventQueue$eventQueueConnectivityListener$1 eventQueueConnectivityListener;
    private final ReentrantLock lock;

    @Inject
    public Logger logger;
    private Thread mThread;
    private CircularEventTrackingQueue requestQueue;

    @Inject
    public Sender sender;
    private final ExecutorService serialExecutor;
    private final long timeToWaitAfterFailure;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.disney.id.android.Connectivity$Listener, com.disney.id.android.tracker.OneIDEventQueue$eventQueueConnectivityListener$1] */
    public OneIDEventQueue(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        HashMap map = new HashMap();
        this.baseParameters = map;
        this.delayAfterSuccessfulLogAttempt = TimeUnit.SECONDS.toMillis(2L);
        this.timeToWaitAfterFailure = TimeUnit.MINUTES.toMillis(1L);
        this.serialExecutor = Executors.newFixedThreadPool(1);
        this.requestQueue = new CircularEventTrackingQueue(appContext, "tracking_event");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        ?? r5 = new Connectivity.Listener() { // from class: com.disney.id.android.tracker.OneIDEventQueue$eventQueueConnectivityListener$1
            @Override // com.disney.id.android.Connectivity.Listener
            public void onConnected() {
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDEventQueue.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Received onConnect", null, 4, null);
                ReentrantLock reentrantLock2 = this.this$0.lock;
                OneIDEventQueue oneIDEventQueue = this.this$0;
                reentrantLock2.lock();
                try {
                    if (oneIDEventQueue.requestQueue.size() > 0) {
                        if (oneIDEventQueue.mThread == null) {
                            oneIDEventQueue.mThread = oneIDEventQueue.new SenderThread();
                            Thread thread = oneIDEventQueue.mThread;
                            Intrinsics.checkNotNull(thread, "null cannot be cast to non-null type com.disney.id.android.tracker.OneIDEventQueue.SenderThread");
                            ((OneIDEventQueue.SenderThread) thread).start();
                        }
                        oneIDEventQueue.condition.signal();
                    }
                    Unit unit = Unit.INSTANCE;
                    reentrantLock2.unlock();
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            }

            @Override // com.disney.id.android.Connectivity.Listener
            public void onDisconnected() {
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDEventQueue.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Received onDisconnect", null, 4, null);
            }
        };
        this.eventQueueConnectivityListener = r5;
        OneIDDagger.getComponent().inject(this);
        map.put(OneIDTrackerEvent.EVENT_PARAM_MAKE_MODEL, Build.MANUFACTURER + " " + Build.MODEL);
        map.put("os", "Android " + Build.VERSION.RELEASE);
        map.put(OneIDTrackerEvent.EVENT_PARAM_SDK_VERSION, "Android 4.12.5");
        getConnectivity$OneID_release().addListener(r5);
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final Sender getSender$OneID_release() {
        Sender sender = this.sender;
        if (sender != null) {
            return sender;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sender");
        return null;
    }

    public final void setSender$OneID_release(@NotNull Sender sender) {
        Intrinsics.checkNotNullParameter(sender, "<set-?>");
        this.sender = sender;
    }

    @NotNull
    public final Connectivity getConnectivity$OneID_release() {
        Connectivity connectivity = this.connectivity;
        if (connectivity != null) {
            return connectivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectivity");
        return null;
    }

    public final void setConnectivity$OneID_release(@NotNull Connectivity connectivity) {
        Intrinsics.checkNotNullParameter(connectivity, "<set-?>");
        this.connectivity = connectivity;
    }

    @Override // com.disney.id.android.tracker.EventQueue
    public void addToBaseParameters(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.baseParameters.put(key, value);
    }

    @Override // com.disney.id.android.tracker.EventQueue
    public void enqueue(@NotNull OneIDTrackerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        for (String str : this.baseParameters.keySet()) {
            Object obj = this.baseParameters.get(str);
            if (obj != null) {
                Intrinsics.checkNotNull(str);
                event.setParameter$OneID_release(str, (String) obj);
            }
        }
        addEventToQueue(event);
    }

    private final void addEventToQueue(final OneIDTrackerEvent event) {
        this.serialExecutor.execute(new Runnable() { // from class: com.disney.id.android.tracker.OneIDEventQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OneIDEventQueue.addEventToQueue$lambda$2(this.f$0, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventToQueue$lambda$2(OneIDEventQueue this$0, OneIDTrackerEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.requestQueue.add(event);
        ReentrantLock reentrantLock = this$0.lock;
        reentrantLock.lock();
        try {
            if (this$0.getConnectivity$OneID_release().isConnected()) {
                if (this$0.mThread == null) {
                    SenderThread senderThread = this$0.new SenderThread();
                    this$0.mThread = senderThread;
                    Intrinsics.checkNotNull(senderThread, "null cannot be cast to non-null type com.disney.id.android.tracker.OneIDEventQueue.SenderThread");
                    senderThread.start();
                }
                this$0.condition.signal();
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/disney/id/android/tracker/OneIDEventQueue$SenderThread;", "Ljava/lang/Thread;", "(Lcom/disney/id/android/tracker/OneIDEventQueue;)V", "run", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nOneIDEventQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDEventQueue.kt\ncom/disney/id/android/tracker/OneIDEventQueue$SenderThread\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1#2:173\n*E\n"})
    public final class SenderThread extends Thread {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Sender.SenderResponse.values().length];
                try {
                    iArr[Sender.SenderResponse.SUCCESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Sender.SenderResponse.FAILURE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Sender.SenderResponse.FAILURE_PERMANENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public SenderThread() {
            super("EventQueueThread");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v3, types: [T, com.disney.id.android.tracker.OneIDTrackerEvent] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLock;
            ReentrantLock reentrantLock2;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    try {
                        try {
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            reentrantLock = OneIDEventQueue.this.lock;
                            OneIDEventQueue oneIDEventQueue = OneIDEventQueue.this;
                            reentrantLock.lock();
                            try {
                                if (oneIDEventQueue.getConnectivity$OneID_release().isConnected() && oneIDEventQueue.requestQueue.size() != 0) {
                                    objectRef.element = oneIDEventQueue.requestQueue.peek();
                                    Unit unit = Unit.INSTANCE;
                                    reentrantLock.unlock();
                                    OneIDTrackerEvent oneIDTrackerEvent = (OneIDTrackerEvent) objectRef.element;
                                    Sender.SenderResponse senderResponseSend = oneIDTrackerEvent != null ? OneIDEventQueue.this.getSender$OneID_release().send(oneIDTrackerEvent) : null;
                                    int i = senderResponseSend == null ? -1 : WhenMappings.$EnumSwitchMapping$0[senderResponseSend.ordinal()];
                                    if (i == 1) {
                                        OneIDEventQueue.this.requestQueue.loggingAttemptSuccessful();
                                    } else if (i != 2) {
                                        if (i != 3) {
                                            Logger logger$OneID_release = OneIDEventQueue.this.getLogger$OneID_release();
                                            String str = OneIDEventQueue.TAG;
                                            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                                            Logger.DefaultImpls.e$default(logger$OneID_release, str, "SenderThread: response case not found", null, 4, null);
                                        } else {
                                            OneIDEventQueue.this.requestQueue.loggingAttemptUnexpectedFailure();
                                        }
                                    }
                                    Thread.sleep(senderResponseSend == Sender.SenderResponse.SUCCESS ? OneIDEventQueue.this.delayAfterSuccessfulLogAttempt : OneIDEventQueue.this.timeToWaitAfterFailure);
                                }
                                reentrantLock = OneIDEventQueue.this.lock;
                                OneIDEventQueue oneIDEventQueue2 = OneIDEventQueue.this;
                                reentrantLock.lock();
                                oneIDEventQueue2.mThread = null;
                                Unit unit2 = Unit.INSTANCE;
                                return;
                            } finally {
                            }
                        } catch (Exception e) {
                            Logger logger$OneID_release2 = OneIDEventQueue.this.getLogger$OneID_release();
                            String str2 = OneIDEventQueue.TAG;
                            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                            Logger.DefaultImpls.e$default(logger$OneID_release2, str2, e.toString(), null, 4, null);
                            reentrantLock = OneIDEventQueue.this.lock;
                            OneIDEventQueue oneIDEventQueue3 = OneIDEventQueue.this;
                            reentrantLock.lock();
                            try {
                                oneIDEventQueue3.mThread = null;
                                Unit unit3 = Unit.INSTANCE;
                            } finally {
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        reentrantLock = OneIDEventQueue.this.lock;
                        OneIDEventQueue oneIDEventQueue4 = OneIDEventQueue.this;
                        reentrantLock.lock();
                        try {
                            oneIDEventQueue4.mThread = null;
                            Unit unit4 = Unit.INSTANCE;
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    reentrantLock = OneIDEventQueue.this.lock;
                    OneIDEventQueue oneIDEventQueue5 = OneIDEventQueue.this;
                    reentrantLock.lock();
                    try {
                        oneIDEventQueue5.mThread = null;
                        Unit unit5 = Unit.INSTANCE;
                        throw th;
                    } finally {
                    }
                }
            }
            reentrantLock = OneIDEventQueue.this.lock;
            OneIDEventQueue oneIDEventQueue6 = OneIDEventQueue.this;
            reentrantLock.lock();
            try {
                oneIDEventQueue6.mThread = null;
                Unit unit6 = Unit.INSTANCE;
                reentrantLock2.unlock();
            } finally {
            }
        }
    }
}
