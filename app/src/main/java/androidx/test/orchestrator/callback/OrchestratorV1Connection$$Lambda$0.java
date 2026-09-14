package androidx.test.orchestrator.callback;

import android.os.IBinder;
import android.os.IInterface;
import androidx.test.internal.events.client.TestEventServiceConnectionBase;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class OrchestratorV1Connection$$Lambda$0 implements TestEventServiceConnectionBase.ServiceFromBinder {
    static final TestEventServiceConnectionBase.ServiceFromBinder $instance = new OrchestratorV1Connection$$Lambda$0();

    private OrchestratorV1Connection$$Lambda$0() {
    }

    @Override // androidx.test.internal.events.client.TestEventServiceConnectionBase.ServiceFromBinder
    public IInterface asInterface(IBinder iBinder) {
        return OrchestratorCallback.Stub.asInterface(iBinder);
    }
}
