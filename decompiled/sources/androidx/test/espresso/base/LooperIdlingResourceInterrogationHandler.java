package androidx.test.espresso.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.base.Interrogator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
class LooperIdlingResourceInterrogationHandler implements Interrogator.InterrogationHandler<Void>, IdlingResource {
    private static final ConcurrentHashMap insts = new ConcurrentHashMap();
    private final String name;
    private final Interrogator.QueueInterrogationHandler queueHasNewTasks = new Interrogator.QueueInterrogationHandler<Boolean>(this) { // from class: androidx.test.espresso.base.LooperIdlingResourceInterrogationHandler.1
        private Boolean hasTasks = Boolean.FALSE;

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean barrierUp() {
            this.hasTasks = Boolean.TRUE;
            return false;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public Boolean get() {
            return this.hasTasks;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean queueEmpty() {
            this.hasTasks = Boolean.FALSE;
            return false;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean taskDueLong() {
            this.hasTasks = Boolean.FALSE;
            return false;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean taskDueSoon() {
            this.hasTasks = Boolean.TRUE;
            return false;
        }
    };
    private volatile boolean started = false;
    private volatile MessageQueue queue = null;
    private volatile boolean idle = true;
    private volatile IdlingResource.ResourceCallback cb = null;

    private LooperIdlingResourceInterrogationHandler(String str) {
        this.name = str;
    }

    static LooperIdlingResourceInterrogationHandler forLooper(Looper looper) {
        String str = String.format(Locale.ROOT, "LooperIdlingResource-%s-%s", Long.valueOf(looper.getThread().getId()), looper.getThread().getName());
        LooperIdlingResourceInterrogationHandler looperIdlingResourceInterrogationHandler = new LooperIdlingResourceInterrogationHandler(str);
        LooperIdlingResourceInterrogationHandler looperIdlingResourceInterrogationHandler2 = (LooperIdlingResourceInterrogationHandler) insts.putIfAbsent(str, looperIdlingResourceInterrogationHandler);
        if (looperIdlingResourceInterrogationHandler2 != null) {
            return looperIdlingResourceInterrogationHandler2;
        }
        new Handler(looper).post(new Runnable() { // from class: androidx.test.espresso.base.LooperIdlingResourceInterrogationHandler.2
            @Override // java.lang.Runnable
            public void run() {
                LooperIdlingResourceInterrogationHandler.this.queue = Looper.myQueue();
                LooperIdlingResourceInterrogationHandler.this.started = true;
                Interrogator.loopAndInterrogate(LooperIdlingResourceInterrogationHandler.this);
            }
        });
        return looperIdlingResourceInterrogationHandler;
    }

    private void transitionToIdle() {
        this.idle = true;
        if (this.cb != null) {
            this.cb.onTransitionToIdle();
        }
    }

    @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
    public boolean barrierUp() {
        this.idle = false;
        return true;
    }

    @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
    public boolean beforeTaskDispatch() {
        this.idle = false;
        return true;
    }

    @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
    public Void get() {
        return null;
    }

    @Override // androidx.test.espresso.IdlingResource
    public String getName() {
        return this.name;
    }

    @Override // androidx.test.espresso.IdlingResource
    public boolean isIdleNow() {
        if (this.started && this.idle) {
            return Boolean.FALSE.equals(Interrogator.peekAtQueueState(this.queue, this.queueHasNewTasks));
        }
        return false;
    }

    @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
    public boolean queueEmpty() {
        transitionToIdle();
        return true;
    }

    @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
    public void quitting() {
        transitionToIdle();
    }

    @Override // androidx.test.espresso.IdlingResource
    public void registerIdleTransitionCallback(IdlingResource.ResourceCallback resourceCallback) {
        this.cb = resourceCallback;
    }

    @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
    public void setMessage(Message message) {
    }

    @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
    public boolean taskDueLong() {
        transitionToIdle();
        return true;
    }

    @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
    public boolean taskDueSoon() {
        this.idle = false;
        return true;
    }
}
