package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
abstract class zzkg extends zzkh {
    private boolean zzb;

    zzkg(zzkj zzkjVar) {
        super(zzkjVar);
        this.zza.zza(this);
    }

    protected abstract boolean zze();

    final boolean zzaj() {
        return this.zzb;
    }

    protected final void zzak() {
        if (!zzaj()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (this.zzb) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zze();
        this.zza.zzp();
        this.zzb = true;
    }
}
