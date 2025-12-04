package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
public final class zzco extends zzeh implements zzfn {
    private static final zzco zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzco zzcoVar = new zzco();
        zzb = zzcoVar;
        zzeh.zzV(zzco.class, zzcoVar);
    }

    private zzco() {
    }

    public static zzco zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final int zzd() {
        int iZza = zzcn.zza(this.zze);
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
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzcm.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzco();
        }
        zzce zzceVar = null;
        if (i2 == 4) {
            return new zzcl(zzceVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
