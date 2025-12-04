package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzdt extends zzdp {
    private final zzds zza = new zzds();

    zzdt() {
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.zza.zza(th, true).add(th2);
    }
}
