package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzip implements Runnable {
    private final /* synthetic */ zzij zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzii zzc;

    zzip(zzii zziiVar, zzij zzijVar, long j) {
        this.zzc = zziiVar;
        this.zza = zzijVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzii zziiVar = this.zzc;
        zziiVar.zza = null;
        zziiVar.zzh().zza((zzij) null);
    }
}
