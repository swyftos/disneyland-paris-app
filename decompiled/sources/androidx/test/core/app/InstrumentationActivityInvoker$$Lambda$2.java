package androidx.test.core.app;

import android.app.Activity;

/* loaded from: classes2.dex */
final /* synthetic */ class InstrumentationActivityInvoker$$Lambda$2 implements Runnable {
    private final Activity arg$1;

    private InstrumentationActivityInvoker$$Lambda$2(Activity activity) {
        this.arg$1 = activity;
    }

    static Runnable get$Lambda(Activity activity) {
        return new InstrumentationActivityInvoker$$Lambda$2(activity);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.finish();
    }
}
