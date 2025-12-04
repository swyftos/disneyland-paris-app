package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzdu extends zzdp {
    zzdu() {
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
