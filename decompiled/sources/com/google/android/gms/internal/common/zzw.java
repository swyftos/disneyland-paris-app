package com.google.android.gms.internal.common;

/* loaded from: classes3.dex */
abstract class zzw extends zzj {
    final CharSequence zzb;
    final zzo zzc;
    final boolean zzd;
    int zze = 0;
    int zzf = Integer.MAX_VALUE;

    protected zzw(zzx zzxVar, CharSequence charSequence) {
        this.zzc = zzxVar.zza;
        this.zzd = zzxVar.zzb;
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.common.zzj
    protected final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int iZzc;
        int i = this.zze;
        while (true) {
            int i2 = this.zze;
            if (i2 == -1) {
                zzb();
                return null;
            }
            iZzd = zzd(i2);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zze = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zze = iZzc;
            }
            if (iZzc == i) {
                int i3 = iZzc + 1;
                this.zze = i3;
                if (i3 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i < iZzd) {
                    this.zzb.charAt(i);
                }
                if (i < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                if (!this.zzd || i != iZzd) {
                    break;
                }
                i = this.zze;
            }
        }
        int i4 = this.zzf;
        if (i4 == 1) {
            iZzd = this.zzb.length();
            this.zze = -1;
            if (iZzd > i) {
                this.zzb.charAt(iZzd - 1);
            }
        } else {
            this.zzf = i4 - 1;
        }
        return this.zzb.subSequence(i, iZzd).toString();
    }

    abstract int zzc(int i);

    abstract int zzd(int i);
}
