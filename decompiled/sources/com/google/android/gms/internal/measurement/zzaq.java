package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* loaded from: classes3.dex */
final class zzaq extends zzag.zzb {
    private final /* synthetic */ long zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaq(zzag zzagVar, long j) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() throws RemoteException {
        this.zzd.zzm.setSessionTimeoutDuration(this.zzc);
    }
}
