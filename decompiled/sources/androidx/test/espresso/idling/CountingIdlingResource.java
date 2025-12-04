package androidx.test.espresso.idling;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.test.espresso.IdlingResource;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class CountingIdlingResource implements IdlingResource {
    private volatile long becameBusyAt;
    private volatile long becameIdleAt;
    private final AtomicInteger counter;
    private final boolean debugCounting;
    private volatile IdlingResource.ResourceCallback resourceCallback;
    private final String resourceName;

    public CountingIdlingResource(String str) {
        this(str, false);
    }

    public CountingIdlingResource(String str, boolean z) {
        this.counter = new AtomicInteger(0);
        this.becameBusyAt = 0L;
        this.becameIdleAt = 0L;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resourceName cannot be empty or null!");
        }
        this.resourceName = str;
        this.debugCounting = z;
    }

    @Override // androidx.test.espresso.IdlingResource
    public String getName() {
        return this.resourceName;
    }

    @Override // androidx.test.espresso.IdlingResource
    public boolean isIdleNow() {
        return this.counter.get() == 0;
    }

    @Override // androidx.test.espresso.IdlingResource
    public void registerIdleTransitionCallback(IdlingResource.ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    public void increment() {
        int andIncrement = this.counter.getAndIncrement();
        if (andIncrement == 0) {
            this.becameBusyAt = SystemClock.uptimeMillis();
        }
        if (this.debugCounting) {
            String str = this.resourceName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
            sb.append("Resource: ");
            sb.append(str);
            sb.append(" in-use-count incremented to: ");
            sb.append(andIncrement + 1);
            Log.i("CountingIdlingResource", sb.toString());
        }
    }

    public void decrement() {
        int iDecrementAndGet = this.counter.decrementAndGet();
        if (iDecrementAndGet == 0) {
            if (this.resourceCallback != null) {
                this.resourceCallback.onTransitionToIdle();
            }
            this.becameIdleAt = SystemClock.uptimeMillis();
        }
        if (this.debugCounting) {
            if (iDecrementAndGet == 0) {
                String str = this.resourceName;
                long j = this.becameIdleAt - this.becameBusyAt;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                sb.append("Resource: ");
                sb.append(str);
                sb.append(" went idle! (Time spent not idle: ");
                sb.append(j);
                sb.append(")");
                Log.i("CountingIdlingResource", sb.toString());
            } else {
                String str2 = this.resourceName;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 51);
                sb2.append("Resource: ");
                sb2.append(str2);
                sb2.append(" in-use-count decremented to: ");
                sb2.append(iDecrementAndGet);
                Log.i("CountingIdlingResource", sb2.toString());
            }
        }
        if (iDecrementAndGet > -1) {
            return;
        }
        StringBuilder sb3 = new StringBuilder(50);
        sb3.append("Counter has been corrupted! counterVal=");
        sb3.append(iDecrementAndGet);
        throw new IllegalStateException(sb3.toString());
    }

    public void dumpStateToLogs() {
        StringBuilder sb = new StringBuilder("Resource: ");
        sb.append(this.resourceName);
        sb.append(" inflight transaction count: ");
        sb.append(this.counter.get());
        if (0 == this.becameBusyAt) {
            sb.append(" and has never been busy!");
            Log.i("CountingIdlingResource", sb.toString());
            return;
        }
        sb.append(" and was last busy at: ");
        sb.append(this.becameBusyAt);
        if (0 == this.becameIdleAt) {
            sb.append(" AND NEVER WENT IDLE!");
            Log.w("CountingIdlingResource", sb.toString());
        } else {
            sb.append(" and last went idle at: ");
            sb.append(this.becameIdleAt);
            Log.i("CountingIdlingResource", sb.toString());
        }
    }
}
