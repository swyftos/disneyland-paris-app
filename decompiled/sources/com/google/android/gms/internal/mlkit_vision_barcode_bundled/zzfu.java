package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
final class zzfu {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzfu zzb = new zzfu();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzgf zzc = new zzfe();

    private zzfu() {
    }

    public static zzfu zza() {
        return zzb;
    }

    public final zzge zzb(Class cls) {
        zzep.zzc(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzge zzgeVarZza = (zzge) this.zzd.get(cls);
        if (zzgeVarZza == null) {
            zzgeVarZza = this.zzc.zza(cls);
            zzep.zzc(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzge zzgeVar = (zzge) this.zzd.putIfAbsent(cls, zzgeVarZza);
            if (zzgeVar != null) {
                return zzgeVar;
            }
        }
        return zzgeVarZza;
    }
}
