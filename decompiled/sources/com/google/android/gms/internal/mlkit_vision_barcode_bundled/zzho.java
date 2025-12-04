package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
public final class zzho extends zzeh implements zzfn {
    private static final zzho zzb;
    private int zzd;
    private int zze = -1;

    static {
        zzho zzhoVar = new zzho();
        zzb = zzhoVar;
        zzeh.zzV(zzho.class, zzhoVar);
    }

    private zzho() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzho();
        }
        zzhi zzhiVar = null;
        if (i2 == 4) {
            return new zzhn(zzhiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
