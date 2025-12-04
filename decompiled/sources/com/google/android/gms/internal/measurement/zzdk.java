package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzdk extends zzdi {
    private final Object zza;

    zzdk(Object obj) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzdi
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzdi
    public final Object zzb() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdk) {
            return this.zza.equals(((zzdk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
