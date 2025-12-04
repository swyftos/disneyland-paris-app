package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
abstract class zzgv {
    private static final zzgt zza = zzc();
    private static final zzgt zzb = new zzgs();

    static zzgt zza() {
        return zza;
    }

    static zzgt zzb() {
        return zzb;
    }

    private static zzgt zzc() {
        try {
            return (zzgt) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
