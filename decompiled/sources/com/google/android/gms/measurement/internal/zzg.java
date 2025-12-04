package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
abstract class zzg extends zzd {
    private boolean zza;

    zzg(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzy.zza(this);
    }

    protected void zzaa() {
    }

    protected abstract boolean zzz();

    final boolean zzv() {
        return this.zza;
    }

    protected final void zzw() {
        if (!zzv()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzz()) {
            return;
        }
        this.zzy.zzaf();
        this.zza = true;
    }

    public final void zzy() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaa();
        this.zzy.zzaf();
        this.zza = true;
    }
}
