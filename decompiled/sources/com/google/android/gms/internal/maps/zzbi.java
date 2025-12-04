package com.google.android.gms.internal.maps;

/* loaded from: classes3.dex */
final class zzbi extends zzbe {
    private final zzbk zza;

    zzbi(zzbk zzbkVar, int i) {
        super(zzbkVar.size(), i);
        this.zza = zzbkVar;
    }

    @Override // com.google.android.gms.internal.maps.zzbe
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
