package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
abstract class zzgv extends zzgs {
    private boolean zza;

    zzgv(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzy.zza(this);
    }

    protected void f_() {
    }

    protected abstract boolean zze();

    final boolean zzz() {
        return this.zza;
    }

    protected final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zze()) {
            return;
        }
        this.zzy.zzaf();
        this.zza = true;
    }

    public final void zzac() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        f_();
        this.zzy.zzaf();
        this.zza = true;
    }
}
