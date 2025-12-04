package androidx.test.espresso.remote;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.espresso.core.internal.deps.aidl.BaseProxy;
import androidx.test.espresso.core.internal.deps.aidl.BaseStub;
import androidx.test.espresso.core.internal.deps.aidl.Codecs;

/* loaded from: classes2.dex */
public interface IInteractionExecutionStatus extends IInterface {

    public static abstract class Stub extends BaseStub implements IInteractionExecutionStatus {

        public static class Proxy extends BaseProxy implements IInteractionExecutionStatus {
            Proxy(IBinder iBinder) {
                super(iBinder, "androidx.test.espresso.remote.IInteractionExecutionStatus");
            }

            @Override // androidx.test.espresso.remote.IInteractionExecutionStatus
            public boolean canExecute() throws RemoteException {
                Parcel parcelTransactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                boolean zCreateBoolean = Codecs.createBoolean(parcelTransactAndReadException);
                parcelTransactAndReadException.recycle();
                return zCreateBoolean;
            }
        }

        public Stub() {
            super("androidx.test.espresso.remote.IInteractionExecutionStatus");
        }

        public static IInteractionExecutionStatus asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.test.espresso.remote.IInteractionExecutionStatus");
            return iInterfaceQueryLocalInterface instanceof IInteractionExecutionStatus ? (IInteractionExecutionStatus) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // androidx.test.espresso.core.internal.deps.aidl.BaseStub
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            boolean zCanExecute = canExecute();
            parcel2.writeNoException();
            Codecs.writeBoolean(parcel2, zCanExecute);
            return true;
        }
    }

    boolean canExecute() throws RemoteException;
}
