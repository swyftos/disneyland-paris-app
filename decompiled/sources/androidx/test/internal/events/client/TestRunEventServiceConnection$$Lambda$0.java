package androidx.test.internal.events.client;

import android.os.IBinder;
import android.os.IInterface;
import androidx.test.internal.events.client.TestEventServiceConnectionBase;
import androidx.test.services.events.run.ITestRunEvent;

/* loaded from: classes2.dex */
final /* synthetic */ class TestRunEventServiceConnection$$Lambda$0 implements TestEventServiceConnectionBase.ServiceFromBinder {
    static final TestEventServiceConnectionBase.ServiceFromBinder $instance = new TestRunEventServiceConnection$$Lambda$0();

    private TestRunEventServiceConnection$$Lambda$0() {
    }

    @Override // androidx.test.internal.events.client.TestEventServiceConnectionBase.ServiceFromBinder
    public IInterface asInterface(IBinder iBinder) {
        return ITestRunEvent.Stub.asInterface(iBinder);
    }
}
