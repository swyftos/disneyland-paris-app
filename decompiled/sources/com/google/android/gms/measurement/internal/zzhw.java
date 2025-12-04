package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzhw implements Runnable {
    private final /* synthetic */ zzhc zza;

    zzhw(zzhc zzhcVar) {
        this.zza = zzhcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
