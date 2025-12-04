package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzkl implements zzfd {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkj zzb;

    zzkl(zzkj zzkjVar, String str) {
        this.zzb = zzkjVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzfd
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
