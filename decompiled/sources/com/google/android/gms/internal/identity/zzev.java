package com.google.android.gms.internal.identity;

/* loaded from: classes3.dex */
final class zzev extends zzet {
    private final zzex zza;

    zzev(zzex zzexVar, int i) {
        super(zzexVar.size(), i);
        this.zza = zzexVar;
    }

    @Override // com.google.android.gms.internal.identity.zzet
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
