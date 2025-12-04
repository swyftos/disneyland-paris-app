package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzhx implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhc zzb;

    zzhx(zzhc zzhcVar, boolean z) {
        this.zzb = zzhcVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        boolean zZzab = this.zzb.zzy.zzab();
        boolean zZzaa = this.zzb.zzy.zzaa();
        this.zzb.zzy.zza(this.zza);
        if (zZzaa == this.zza) {
            this.zzb.zzy.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzy.zzab() == zZzab || this.zzb.zzy.zzab() != this.zzb.zzy.zzaa()) {
            this.zzb.zzy.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zZzab));
        }
        this.zzb.zzam();
    }
}
