package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
public final class zzia extends zzeh implements zzfn {
    private static final zzia zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzeo zzg = zzeh.zzP();
    private int zzh;

    static {
        zzia zziaVar = new zzia();
        zzb = zziaVar;
        zzeh.zzV(zzia.class, zziaVar);
    }

    private zzia() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002င\u0001\u0003\u001a\u0004င\u0002", new Object[]{"zzd", "zze", zzhz.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzia();
        }
        zzhi zzhiVar = null;
        if (i2 == 4) {
            return new zzhy(zzhiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
