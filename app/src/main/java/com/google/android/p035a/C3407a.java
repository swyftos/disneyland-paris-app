package com.google.android.p035a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: com.google.android.a.a */
/* JADX INFO: loaded from: classes3.dex */
public class C3407a implements IInterface {

    /* JADX INFO: renamed from: a */
    private final IBinder f3448a;

    /* JADX INFO: renamed from: b */
    private final String f3449b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    protected C3407a(IBinder iBinder) {
        this.f3448a = iBinder;
    }

    /* JADX INFO: renamed from: a */
    protected final Parcel m1422a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f3449b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3448a;
    }

    /* JADX INFO: renamed from: b */
    protected final Parcel m1423b(Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f3448a.transact(1, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }
}
