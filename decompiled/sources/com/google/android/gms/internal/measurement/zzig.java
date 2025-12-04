package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zzig {
    private static final zzig zza = new zzig(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public static zzig zza() {
        return zza;
    }

    static zzig zzb() {
        return new zzig();
    }

    static zzig zza(zzig zzigVar, zzig zzigVar2) {
        int i = zzigVar.zzb + zzigVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzigVar.zzc, i);
        System.arraycopy(zzigVar2.zzc, 0, iArrCopyOf, zzigVar.zzb, zzigVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzigVar.zzd, i);
        System.arraycopy(zzigVar2.zzd, 0, objArrCopyOf, zzigVar.zzb, zzigVar2.zzb);
        return new zzig(i, iArrCopyOf, objArrCopyOf, true);
    }

    private zzig() {
        this(0, new int[8], new Object[8], true);
    }

    private zzig(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzc() {
        this.zzf = false;
    }

    final void zza(zzja zzjaVar) {
        if (zzjaVar.zza() == zzfo.zzf.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzjaVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjaVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzb(zzja zzjaVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzjaVar.zza() == zzfo.zzf.zzj) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzjaVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zzjaVar);
        }
    }

    private static void zza(int i, Object obj, zzja zzjaVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjaVar.zza(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzjaVar.zzd(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzjaVar.zza(i2, (zzeg) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zzjaVar.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfw.zzf());
        }
        if (zzjaVar.zza() == zzfo.zzf.zzj) {
            zzjaVar.zza(i2);
            ((zzig) obj).zzb(zzjaVar);
            zzjaVar.zzb(i2);
        } else {
            zzjaVar.zzb(i2);
            ((zzig) obj).zzb(zzjaVar);
            zzjaVar.zza(i2);
        }
    }

    public final int zzd() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            iZzd += zzev.zzd(this.zzc[i2] >>> 3, (zzeg) this.zzd[i2]);
        }
        this.zze = iZzd;
        return iZzd;
    }

    public final int zze() {
        int iZze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZze = zzev.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                iZze = zzev.zzg(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                iZze = zzev.zzc(i5, (zzeg) this.zzd[i3]);
            } else if (i6 == 3) {
                iZze = (zzev.zze(i5) << 1) + ((zzig) this.zzd[i3]).zze();
            } else if (i6 == 5) {
                iZze = zzev.zzi(i5, ((Integer) this.zzd[i3]).intValue());
            } else {
                throw new IllegalStateException(zzfw.zzf());
            }
            i2 += iZze;
        }
        this.zze = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzig)) {
            return false;
        }
        zzig zzigVar = (zzig) obj;
        int i = this.zzb;
        if (i == zzigVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzigVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzigVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhb.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zza(int i, Object obj) {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.zzb;
        int[] iArr = this.zzc;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
        int[] iArr2 = this.zzc;
        int i4 = this.zzb;
        iArr2[i4] = i;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }
}
