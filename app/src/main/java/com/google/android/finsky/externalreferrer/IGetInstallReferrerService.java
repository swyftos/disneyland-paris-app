package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p035a.BinderC3408b;
import com.google.android.p035a.C3407a;
import com.google.android.p035a.C3409c;

/* JADX INFO: loaded from: classes3.dex */
public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends BinderC3408b implements IGetInstallReferrerService {

        public static class Proxy extends C3407a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            /* JADX INFO: renamed from: c */
            public final Bundle mo1437c(Bundle bundle) throws RemoteException {
                Parcel parcelM1422a = m1422a();
                C3409c.m1426b(parcelM1422a, bundle);
                Parcel parcelM1423b = m1423b(parcelM1422a);
                Bundle bundle2 = (Bundle) C3409c.m1425a(parcelM1423b, Bundle.CREATOR);
                parcelM1423b.recycle();
                return bundle2;
            }
        }

        /* JADX INFO: renamed from: b */
        public static IGetInstallReferrerService m1438b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return iInterfaceQueryLocalInterface instanceof IGetInstallReferrerService ? (IGetInstallReferrerService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.p035a.BinderC3408b
        /* JADX INFO: renamed from: a */
        protected final boolean mo1424a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            Bundle bundleMo1437c = mo1437c((Bundle) C3409c.m1425a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            C3409c.m1427c(parcel2, bundleMo1437c);
            return true;
        }
    }

    /* JADX INFO: renamed from: c */
    Bundle mo1437c(Bundle bundle) throws RemoteException;
}
