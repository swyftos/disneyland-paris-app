package androidx.test.internal.events.client;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.platform.ITestPlatformEvent;
import androidx.test.services.events.platform.TestPlatformEvent;

/* loaded from: classes2.dex */
public class TestPlatformEventServiceConnection extends TestEventServiceConnectionBase<ITestPlatformEvent> implements TestPlatformEventService {
    TestPlatformEventServiceConnection(String str, TestEventClientConnectListener testEventClientConnectListener) {
        super(str, TestPlatformEventServiceConnection$$Lambda$0.$instance, testEventClientConnectListener);
    }

    @Override // androidx.test.internal.events.client.TestPlatformEventService
    public void send(@NonNull TestPlatformEvent testPlatformEvent) throws TestEventClientException {
        Checks.checkNotNull(testPlatformEvent, "testPlatformEvent cannot be null");
        T t = this.service;
        if (t == 0) {
            throw new TestEventClientException("Can't send test platform event, service not connected");
        }
        try {
            ((ITestPlatformEvent) t).send(testPlatformEvent);
        } catch (RemoteException e) {
            throw new TestEventClientException("Failed to send test platform event", e);
        }
    }
}
