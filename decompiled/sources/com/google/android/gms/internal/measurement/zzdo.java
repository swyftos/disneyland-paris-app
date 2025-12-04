package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class zzdo implements zzdj {
    private volatile zzdj zza;
    private volatile boolean zzb;
    private Object zzc;

    zzdo(zzdj zzdjVar) {
        this.zza = (zzdj) zzdh.zza(zzdjVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                try {
                    if (!this.zzb) {
                        Object objZza = this.zza.zza();
                        this.zzc = objZza;
                        this.zzb = true;
                        this.zza = null;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }

    public final String toString() {
        Object string = this.zza;
        if (string == null) {
            String strValueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
