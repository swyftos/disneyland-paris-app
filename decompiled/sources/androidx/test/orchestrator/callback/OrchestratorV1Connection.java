package androidx.test.orchestrator.callback;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.test.internal.events.client.TestDiscoveryEventService;
import androidx.test.internal.events.client.TestEventClientConnectListener;
import androidx.test.internal.events.client.TestEventClientException;
import androidx.test.internal.events.client.TestEventServiceConnectionBase;
import androidx.test.internal.events.client.TestRunEventService;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.discovery.TestDiscoveryEvent;
import androidx.test.services.events.discovery.TestFoundEvent;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public final class OrchestratorV1Connection extends TestEventServiceConnectionBase<OrchestratorCallback> implements TestRunEventService, TestDiscoveryEventService {
    public OrchestratorV1Connection(@NonNull TestEventClientConnectListener testEventClientConnectListener) {
        super("androidx.test.orchestrator/.OrchestratorService", OrchestratorV1Connection$$Lambda$0.$instance, testEventClientConnectListener);
    }

    @Override // androidx.test.internal.events.client.TestRunEventService
    public void send(@NonNull TestRunEvent testRunEvent) throws TestEventClientException {
        Checks.checkNotNull(testRunEvent, "event cannot be null");
        T t = this.service;
        if (t == 0) {
            throw new TestEventClientException("Unable to send notification, Orchestrator callback is null");
        }
        try {
            ((OrchestratorCallback) t).sendTestNotification(BundleConverter.getBundleFromTestRunEvent(testRunEvent));
        } catch (RemoteException e) {
            String strValueOf = String.valueOf(testRunEvent.getClass());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Unable to send test run event [");
            sb.append(strValueOf);
            sb.append("]");
            throw new TestEventClientException(sb.toString(), e);
        }
    }

    @Override // androidx.test.internal.events.client.TestDiscoveryEventService
    public void send(@NonNull TestDiscoveryEvent testDiscoveryEvent) throws TestEventClientException {
        Checks.checkNotNull(testDiscoveryEvent, "event cannot be null");
        if (this.service == 0) {
            throw new TestEventClientException("Unable to add test, Orchestrator callback is null");
        }
        if (testDiscoveryEvent instanceof TestFoundEvent) {
            String classAndMethodName = ((TestFoundEvent) testDiscoveryEvent).testCase.getClassAndMethodName();
            try {
                ((OrchestratorCallback) this.service).addTest(classAndMethodName);
            } catch (RemoteException e) {
                StringBuilder sb = new StringBuilder(String.valueOf(classAndMethodName).length() + 21);
                sb.append("Failed to add test [");
                sb.append(classAndMethodName);
                sb.append("]");
                throw new TestEventClientException(sb.toString(), e);
            }
        }
    }
}
