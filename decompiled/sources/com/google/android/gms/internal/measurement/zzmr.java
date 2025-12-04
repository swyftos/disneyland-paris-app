package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmr implements zzmo {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;
    private static final zzcv zzd;
    private static final zzcv zze;

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final boolean zza() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final double zzb() {
        return ((Double) zzb.zzc()).doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final long zzc() {
        return ((Long) zzc.zzc()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final long zzd() {
        return ((Long) zzd.zzc()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final String zze() {
        return (String) zze.zzc();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.test.boolean_flag", false);
        zzb = zzdbVar.zza("measurement.test.double_flag", -3.0d);
        zzc = zzdbVar.zza("measurement.test.int_flag", -2L);
        zzd = zzdbVar.zza("measurement.test.long_flag", -1L);
        zze = zzdbVar.zza("measurement.test.string_flag", "---");
    }
}
