package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* loaded from: classes4.dex */
public final class zzaf extends zzeh implements zzfn {
    private static final zzaf zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        zzaf zzafVar = new zzaf();
        zzb = zzafVar;
        zzeh.zzV(zzaf.class, zzafVar);
    }

    private zzaf() {
    }

    public static zzae zzc() {
        return (zzae) zzb.zzG();
    }

    static /* synthetic */ void zze(zzaf zzafVar, int i) {
        zzafVar.zzd |= 1;
        zzafVar.zze = i;
    }

    static /* synthetic */ void zzf(zzaf zzafVar, int i) {
        zzafVar.zzd |= 2;
        zzafVar.zzf = i;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaf();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzae(zzaVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
