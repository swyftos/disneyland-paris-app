package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzeo {
    private final zzev zza;
    private final byte[] zzb;

    private zzeo(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzev.zza(bArr);
    }

    public final zzeg zza() {
        this.zza.zzb();
        return new zzeq(this.zzb);
    }

    public final zzev zzb() {
        return this.zza;
    }

    /* synthetic */ zzeo(int i, zzef zzefVar) {
        this(i);
    }
}
