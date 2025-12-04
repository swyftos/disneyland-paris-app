package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzdg extends zzdi {
    static final zzdg zza = new zzdg();

    private zzdg() {
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.android.gms.internal.measurement.zzdi
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzdi
    public final Object zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
