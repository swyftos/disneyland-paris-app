package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* loaded from: classes4.dex */
public final class zzt extends zzeh implements zzfn {
    private static final zzt zzb;

    static {
        zzt zztVar = new zzt();
        zzb = zztVar;
        zzeh.zzV(zzt.class, zztVar);
    }

    private zzt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzr zzrVar = null;
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzt();
        }
        if (i2 == 4) {
            return new zzs(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
