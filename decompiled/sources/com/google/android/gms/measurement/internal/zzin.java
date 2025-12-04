package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzin implements Runnable {
    private final /* synthetic */ zzii zza;

    zzin(zzii zziiVar) {
        this.zza = zziiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzii zziiVar = this.zza;
        zziiVar.zza = zziiVar.zzh;
    }
}
