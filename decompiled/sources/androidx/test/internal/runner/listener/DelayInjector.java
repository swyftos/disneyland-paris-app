package androidx.test.internal.runner.listener;

import android.util.Log;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public class DelayInjector extends RunListener {
    private final int delayMsec;

    public DelayInjector(int i) {
        this.delayMsec = i;
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunStarted(Description description) throws Exception {
        delay();
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFinished(Description description) throws Exception {
        delay();
    }

    private void delay() throws InterruptedException {
        try {
            Thread.sleep(this.delayMsec);
        } catch (InterruptedException e) {
            Log.e("DelayInjector", "interrupted", e);
        }
    }
}
