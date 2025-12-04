package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* loaded from: classes3.dex */
final class zzao extends zzag.zzb {
    private final /* synthetic */ zzag zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzao(zzag zzagVar) {
        super(zzagVar);
        this.zzc = zzagVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() throws RemoteException {
        this.zzc.zzm.resetAnalyticsData(this.zza);
    }
}
