package androidx.test.services.events.platform;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.runner.internal.deps.aidl.BaseProxy;
import androidx.test.runner.internal.deps.aidl.BaseStub;
import androidx.test.runner.internal.deps.aidl.Codecs;

/* loaded from: classes2.dex */
public interface ITestPlatformEvent extends IInterface {
    void send(TestPlatformEvent testPlatformEvent) throws RemoteException;

    public static abstract class Stub extends BaseStub implements ITestPlatformEvent {
        public Stub() {
            super("androidx.test.services.events.platform.ITestPlatformEvent");
        }

        public static ITestPlatformEvent asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.test.services.events.platform.ITestPlatformEvent");
            if (iInterfaceQueryLocalInterface instanceof ITestPlatformEvent) {
                return (ITestPlatformEvent) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // androidx.test.runner.internal.deps.aidl.BaseStub
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            send((TestPlatformEvent) Codecs.createParcelable(parcel, TestPlatformEvent.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        public static class Proxy extends BaseProxy implements ITestPlatformEvent {
            Proxy(IBinder iBinder) {
                super(iBinder, "androidx.test.services.events.platform.ITestPlatformEvent");
            }

            @Override // androidx.test.services.events.platform.ITestPlatformEvent
            public void send(TestPlatformEvent testPlatformEvent) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, testPlatformEvent);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }
        }
    }
}
