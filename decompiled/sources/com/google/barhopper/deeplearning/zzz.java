package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* loaded from: classes4.dex */
public final class zzz extends zzeh implements zzfn {
    private static final zzz zzb;

    static {
        zzz zzzVar = new zzz();
        zzb = zzzVar;
        zzeh.zzV(zzz.class, zzzVar);
    }

    private zzz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzx zzxVar = null;
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzz();
        }
        if (i2 == 4) {
            return new zzy(zzxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
