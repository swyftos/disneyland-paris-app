package com.google.android.gms.location;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzu extends com.google.android.gms.internal.identity.zza implements zzw {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzd(LocationResult locationResult) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.location.zzw
    public final void zze(LocationAvailability locationAvailability) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzf() throws RemoteException {
        throw null;
    }
}
