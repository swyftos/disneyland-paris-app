package androidx.test.internal.events.client;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.run.ITestRunEvent;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public class TestRunEventServiceConnection extends TestEventServiceConnectionBase<ITestRunEvent> implements TestRunEventService {
    TestRunEventServiceConnection(String str, TestEventClientConnectListener testEventClientConnectListener) {
        super(str, TestRunEventServiceConnection$$Lambda$0.$instance, testEventClientConnectListener);
    }

    @Override // androidx.test.internal.events.client.TestRunEventService
    public void send(@NonNull TestRunEvent testRunEvent) throws TestEventClientException {
        Checks.checkNotNull(testRunEvent, "testRunEvent cannot be null");
        T t = this.service;
        if (t == 0) {
            throw new TestEventClientException("Can't send test run event, service not connected");
        }
        try {
            ((ITestRunEvent) t).send(testRunEvent);
        } catch (RemoteException e) {
            throw new TestEventClientException("Failed to send test run event", e);
        }
    }
}
