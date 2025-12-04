package androidx.test.services.events.run;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.runner.internal.deps.aidl.BaseProxy;
import androidx.test.runner.internal.deps.aidl.BaseStub;
import androidx.test.runner.internal.deps.aidl.Codecs;

/* loaded from: classes2.dex */
public interface ITestRunEvent extends IInterface {
    void send(TestRunEvent testRunEvent) throws RemoteException;

    public static abstract class Stub extends BaseStub implements ITestRunEvent {
        public Stub() {
            super("androidx.test.services.events.run.ITestRunEvent");
        }

        public static ITestRunEvent asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.test.services.events.run.ITestRunEvent");
            if (iInterfaceQueryLocalInterface instanceof ITestRunEvent) {
                return (ITestRunEvent) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // androidx.test.runner.internal.deps.aidl.BaseStub
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            send((TestRunEvent) Codecs.createParcelable(parcel, TestRunEvent.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        public static class Proxy extends BaseProxy implements ITestRunEvent {
            Proxy(IBinder iBinder) {
                super(iBinder, "androidx.test.services.events.run.ITestRunEvent");
            }

            @Override // androidx.test.services.events.run.ITestRunEvent
            public void send(TestRunEvent testRunEvent) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, testRunEvent);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }
        }
    }
}
