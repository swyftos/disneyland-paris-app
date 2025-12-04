package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;

/* loaded from: classes3.dex */
final class zzfm implements zzgx {
    private static final zzfm zza = new zzfm();

    private zzfm() {
    }

    public static zzfm zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgx
    public final boolean zza(Class cls) {
        return zzfo.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzgx
    public final zzgu zzb(Class cls) {
        if (!zzfo.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzgu) zzfo.zza(cls.asSubclass(zzfo.class)).zza(zzfo.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
