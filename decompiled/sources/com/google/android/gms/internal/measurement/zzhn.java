package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;

/* loaded from: classes3.dex */
final class zzhn implements zzgu {
    private final zzgw zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzhn(zzgw zzgwVar, String str, Object[] objArr) {
        this.zza = zzgwVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzgu
    public final zzgw zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgu
    public final int zza() {
        return (this.zzd & 1) == 1 ? zzfo.zzf.zzh : zzfo.zzf.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzgu
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }
}
