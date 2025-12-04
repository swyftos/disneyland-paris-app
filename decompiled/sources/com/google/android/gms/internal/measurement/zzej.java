package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzej extends zzeq {
    private final int zzc;
    private final int zzd;

    zzej(byte[] bArr, int i, int i2) {
        super(bArr);
        zzeg.zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq, com.google.android.gms.internal.measurement.zzeg
    public final byte zza(int i) {
        int iZza = zza();
        if (((iZza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(iZza);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzeq, com.google.android.gms.internal.measurement.zzeg
    final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.measurement.zzeq, com.google.android.gms.internal.measurement.zzeg
    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    protected final int zze() {
        return this.zzc;
    }
}
