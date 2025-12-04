package com.google.android.gms.internal.mlkit_common;

/* loaded from: classes3.dex */
final class zzad extends zzv {
    private final zzaf zza;

    zzad(zzaf zzafVar, int i) {
        super(zzafVar.size(), i);
        this.zza = zzafVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzv
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
