package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
abstract class zzir {
    zzir() {
    }

    abstract int zza(int i, byte[] bArr, int i2, int i3);

    abstract int zza(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract String zza(byte[] bArr, int i, int i2);

    final boolean zzb(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
