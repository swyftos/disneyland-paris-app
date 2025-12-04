package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.internal.util.Checks;
import androidx.test.runner.MonitoringInstrumentation;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public class ActivityFinisherRunListener extends RunListener {
    private final MonitoringInstrumentation.ActivityFinisher activityFinisher;
    private final Instrumentation instrumentation;
    private final Runnable waitForActivitiesToFinishRunnable;

    public ActivityFinisherRunListener(Instrumentation instrumentation, MonitoringInstrumentation.ActivityFinisher activityFinisher, Runnable runnable) {
        this.instrumentation = (Instrumentation) Checks.checkNotNull(instrumentation);
        this.activityFinisher = (MonitoringInstrumentation.ActivityFinisher) Checks.checkNotNull(activityFinisher);
        this.waitForActivitiesToFinishRunnable = (Runnable) Checks.checkNotNull(runnable);
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) throws Exception {
        this.instrumentation.runOnMainSync(this.activityFinisher);
        this.waitForActivitiesToFinishRunnable.run();
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFinished(Description description) throws Exception {
        InstrumentationConnection.getInstance().requestRemoteInstancesActivityCleanup();
        this.instrumentation.runOnMainSync(this.activityFinisher);
        this.waitForActivitiesToFinishRunnable.run();
    }
}
