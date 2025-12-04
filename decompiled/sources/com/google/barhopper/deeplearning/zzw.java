package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhk;

/* loaded from: classes4.dex */
public final class zzw extends zzeh implements zzfn {
    private static final zzw zzb;
    private int zzd;
    private zzhk zzf;
    private zzdf zze = zzdf.zzb;
    private int zzg = 1;
    private float zzh = 0.75f;
    private boolean zzi = true;

    static {
        zzw zzwVar = new zzw();
        zzb = zzwVar;
        zzeh.zzV(zzw.class, zzwVar);
    }

    private zzw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ည\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzw();
        }
        zzu zzuVar = null;
        if (i2 == 4) {
            return new zzv(zzuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
