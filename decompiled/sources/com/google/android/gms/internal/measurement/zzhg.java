package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
abstract class zzhg {
    private static final zzhe zza = zzc();
    private static final zzhe zzb = new zzhh();

    static zzhe zza() {
        return zza;
    }

    static zzhe zzb() {
        return zzb;
    }

    private static zzhe zzc() {
        try {
            return (zzhe) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
