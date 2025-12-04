package androidx.test.internal.events.client;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.discovery.ITestDiscoveryEvent;
import androidx.test.services.events.discovery.TestDiscoveryEvent;

/* loaded from: classes2.dex */
public class TestDiscoveryEventServiceConnection extends TestEventServiceConnectionBase<ITestDiscoveryEvent> implements TestDiscoveryEventService {
    TestDiscoveryEventServiceConnection(String str, TestEventClientConnectListener testEventClientConnectListener) {
        super(str, TestDiscoveryEventServiceConnection$$Lambda$0.$instance, testEventClientConnectListener);
    }

    @Override // androidx.test.internal.events.client.TestDiscoveryEventService
    public void send(@NonNull TestDiscoveryEvent testDiscoveryEvent) throws TestEventClientException {
        Checks.checkNotNull(testDiscoveryEvent, "testDiscoveryEvent cannot be null");
        T t = this.service;
        if (t == 0) {
            throw new TestEventClientException("Can't add test, service not connected");
        }
        try {
            ((ITestDiscoveryEvent) t).send(testDiscoveryEvent);
        } catch (RemoteException e) {
            throw new TestEventClientException("Failed to send test case", e);
        }
    }
}
