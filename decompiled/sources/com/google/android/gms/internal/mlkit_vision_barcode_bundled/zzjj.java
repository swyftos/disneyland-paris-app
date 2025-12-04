package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
public final class zzjj extends zzeh implements zzfn {
    private static final zzjj zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;
    private int zzi;
    private zzil zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;

    static {
        zzjj zzjjVar = new zzjj();
        zzb = zzjjVar;
        zzeh.zzV(zzjj.class, zzjjVar);
    }

    private zzjj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003\u0005င\u0004\u0006ဉ\u0005\u0007ဇ\u0006\b᠌\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဂ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzjk.zza, "zzi", "zzj", "zzk", "zzl", zzjl.zza, "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzjj();
        }
        zzhi zzhiVar = null;
        if (i2 == 4) {
            return new zzji(zzhiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
