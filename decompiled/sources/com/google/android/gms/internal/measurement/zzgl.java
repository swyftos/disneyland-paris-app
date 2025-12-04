package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes3.dex */
final class zzgl extends zzgg {
    private zzgl() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final List zza(Object obj, long j) {
        zzfx zzfxVarZzc = zzc(obj, j);
        if (zzfxVarZzc.zza()) {
            return zzfxVarZzc;
        }
        int size = zzfxVarZzc.size();
        zzfx zzfxVarZza = zzfxVarZzc.zza(size == 0 ? 10 : size << 1);
        zzin.zza(obj, j, zzfxVarZza);
        return zzfxVarZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final void zza(Object obj, Object obj2, long j) {
        zzfx zzfxVarZzc = zzc(obj, j);
        zzfx zzfxVarZzc2 = zzc(obj2, j);
        int size = zzfxVarZzc.size();
        int size2 = zzfxVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzfxVarZzc.zza()) {
                zzfxVarZzc = zzfxVarZzc.zza(size2 + size);
            }
            zzfxVarZzc.addAll(zzfxVarZzc2);
        }
        if (size > 0) {
            zzfxVarZzc2 = zzfxVarZzc;
        }
        zzin.zza(obj, j, zzfxVarZzc2);
    }

    private static zzfx zzc(Object obj, long j) {
        return (zzfx) zzin.zzf(obj, j);
    }
}
