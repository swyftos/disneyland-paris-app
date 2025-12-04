package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* loaded from: classes3.dex */
final class zzbf extends zzag.zzb {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzhb zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbf(zzag zzagVar, com.google.android.gms.measurement.internal.zzhb zzhbVar) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = zzhbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() throws RemoteException {
        this.zzd.zzm.setEventInterceptor(new zzag.zza(this.zzc));
    }
}
