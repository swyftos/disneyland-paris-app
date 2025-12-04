package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* loaded from: classes3.dex */
final class zzbg extends zzag.zzb {
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbg(zzag zzagVar, boolean z) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() throws RemoteException {
        this.zzd.zzm.setDataCollectionEnabled(this.zzc);
    }
}
