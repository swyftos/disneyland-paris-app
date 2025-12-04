package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* loaded from: classes4.dex */
public final class zzv extends zzeh implements zzfn {
    private static final zzv zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzv zzvVar = new zzv();
        zzb = zzvVar;
        zzeh.zzV(zzv.class, zzvVar);
    }

    private zzv() {
    }

    public static zzv zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final String zze() {
        return this.zzg;
    }

    public final int zzf() {
        int iZza = zzu.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", zzt.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzv();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzs(zzaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
