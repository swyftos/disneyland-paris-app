package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
class zzeq extends zzen {
    protected final byte[] zzb;

    zzeq(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final zzeg zza(int i, int i2) {
        int iZzb = zzeg.zzb(0, i2, zza());
        if (iZzb == 0) {
            return zzeg.zza;
        }
        return new zzej(this.zzb, zze(), iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    final void zza(zzed zzedVar) throws IOException {
        zzedVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean zzc() {
        int iZze = zze();
        return zzip.zza(this.zzb, iZze, zza() + iZze);
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeg) || zza() != ((zzeg) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (obj instanceof zzeq) {
            zzeq zzeqVar = (zzeq) obj;
            int iZzd = zzd();
            int iZzd2 = zzeqVar.zzd();
            if (iZzd == 0 || iZzd2 == 0 || iZzd == iZzd2) {
                return zza(zzeqVar, 0, zza());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzen
    final boolean zza(zzeg zzegVar, int i, int i2) {
        if (i2 > zzegVar.zza()) {
            int iZza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iZza);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzegVar.zza()) {
            int iZza2 = zzegVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iZza2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzegVar instanceof zzeq) {
            zzeq zzeqVar = (zzeq) zzegVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzeqVar.zzb;
            int iZze = zze() + i2;
            int iZze2 = zze();
            int iZze3 = zzeqVar.zze();
            while (iZze2 < iZze) {
                if (bArr[iZze2] != bArr2[iZze3]) {
                    return false;
                }
                iZze2++;
                iZze3++;
            }
            return true;
        }
        return zzegVar.zza(0, i2).equals(zza(0, i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    protected final int zza(int i, int i2, int i3) {
        return zzfr.zza(i, this.zzb, zze(), i3);
    }
}
