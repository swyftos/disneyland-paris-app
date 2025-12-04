package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzgp implements zzgx {
    private zzgx[] zza;

    zzgp(zzgx... zzgxVarArr) {
        this.zza = zzgxVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgx
    public final boolean zza(Class cls) {
        for (zzgx zzgxVar : this.zza) {
            if (zzgxVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgx
    public final zzgu zzb(Class cls) {
        for (zzgx zzgxVar : this.zza) {
            if (zzgxVar.zza(cls)) {
                return zzgxVar.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
