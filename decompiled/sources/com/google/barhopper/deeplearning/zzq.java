package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* loaded from: classes4.dex */
public final class zzq extends zzeh implements zzfn {
    private static final zzq zzb;
    private zzeo zzd = zzeh.zzP();
    private zzeo zze = zzeh.zzP();

    static {
        zzq zzqVar = new zzq();
        zzb = zzqVar;
        zzeh.zzV(zzq.class, zzqVar);
    }

    private zzq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zzn.class, "zze", zzn.class});
        }
        if (i2 == 3) {
            return new zzq();
        }
        zzo zzoVar = null;
        if (i2 == 4) {
            return new zzp(zzoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
