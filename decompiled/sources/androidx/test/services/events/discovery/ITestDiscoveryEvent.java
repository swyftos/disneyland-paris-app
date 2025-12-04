package androidx.test.services.events.discovery;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.runner.internal.deps.aidl.BaseProxy;
import androidx.test.runner.internal.deps.aidl.BaseStub;
import androidx.test.runner.internal.deps.aidl.Codecs;

/* loaded from: classes2.dex */
public interface ITestDiscoveryEvent extends IInterface {
    void send(TestDiscoveryEvent testDiscoveryEvent) throws RemoteException;

    public static abstract class Stub extends BaseStub implements ITestDiscoveryEvent {
        public Stub() {
            super("androidx.test.services.events.discovery.ITestDiscoveryEvent");
        }

        public static ITestDiscoveryEvent asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.test.services.events.discovery.ITestDiscoveryEvent");
            if (iInterfaceQueryLocalInterface instanceof ITestDiscoveryEvent) {
                return (ITestDiscoveryEvent) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // androidx.test.runner.internal.deps.aidl.BaseStub
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            send((TestDiscoveryEvent) Codecs.createParcelable(parcel, TestDiscoveryEvent.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        public static class Proxy extends BaseProxy implements ITestDiscoveryEvent {
            Proxy(IBinder iBinder) {
                super(iBinder, "androidx.test.services.events.discovery.ITestDiscoveryEvent");
            }

            @Override // androidx.test.services.events.discovery.ITestDiscoveryEvent
            public void send(TestDiscoveryEvent testDiscoveryEvent) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, testDiscoveryEvent);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }
        }
    }
}
