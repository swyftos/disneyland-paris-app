package com.google.android.gms.internal.measurement;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
final class zzhl {
    private static final zzhl zza = new zzhl();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzho zzb = new zzgn();

    public static zzhl zza() {
        return zza;
    }

    public final zzhp zza(Class cls) {
        zzfr.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzhp zzhpVar = (zzhp) this.zzc.get(cls);
        if (zzhpVar != null) {
            return zzhpVar;
        }
        zzhp zzhpVarZza = this.zzb.zza(cls);
        zzfr.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzfr.zza((Object) zzhpVarZza, "schema");
        zzhp zzhpVar2 = (zzhp) this.zzc.putIfAbsent(cls, zzhpVarZza);
        return zzhpVar2 != null ? zzhpVar2 : zzhpVarZza;
    }

    public final zzhp zza(Object obj) {
        return zza((Class) obj.getClass());
    }

    private zzhl() {
    }
}
