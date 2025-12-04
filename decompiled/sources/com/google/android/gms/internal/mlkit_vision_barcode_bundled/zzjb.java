package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
public final class zzjb extends zzeh implements zzfn {
    private static final zzjb zzb;
    private int zzd;
    private String zze = "";
    private zzjh zzf;

    static {
        zzjb zzjbVar = new zzjb();
        zzb = zzjbVar;
        zzeh.zzV(zzjb.class, zzjbVar);
    }

    private zzjb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzjb();
        }
        zzhi zzhiVar = null;
        if (i2 == 4) {
            return new zzja(zzhiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
