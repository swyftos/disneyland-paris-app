package androidx.test.orchestrator.callback;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.runner.internal.deps.aidl.BaseProxy;
import androidx.test.runner.internal.deps.aidl.BaseStub;
import androidx.test.runner.internal.deps.aidl.Codecs;

/* loaded from: classes2.dex */
public interface OrchestratorCallback extends IInterface {
    void addTest(String str) throws RemoteException;

    void sendTestNotification(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends BaseStub implements OrchestratorCallback {
        public Stub() {
            super("androidx.test.orchestrator.callback.OrchestratorCallback");
        }

        public static OrchestratorCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.test.orchestrator.callback.OrchestratorCallback");
            if (iInterfaceQueryLocalInterface instanceof OrchestratorCallback) {
                return (OrchestratorCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // androidx.test.runner.internal.deps.aidl.BaseStub
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                addTest(parcel.readString());
            } else {
                if (i != 2) {
                    return false;
                }
                sendTestNotification((Bundle) Codecs.createParcelable(parcel, Bundle.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }

        public static class Proxy extends BaseProxy implements OrchestratorCallback {
            Proxy(IBinder iBinder) {
                super(iBinder, "androidx.test.orchestrator.callback.OrchestratorCallback");
            }

            @Override // androidx.test.orchestrator.callback.OrchestratorCallback
            public void addTest(String str) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeString(str);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }

            @Override // androidx.test.orchestrator.callback.OrchestratorCallback
            public void sendTestNotification(Bundle bundle) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, bundle);
                transactAndReadExceptionReturnVoid(2, parcelObtainAndWriteInterfaceToken);
            }
        }
    }
}
