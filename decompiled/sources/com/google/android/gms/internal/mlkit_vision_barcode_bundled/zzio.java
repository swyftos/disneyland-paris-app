package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
public final class zzio extends zzeh implements zzfn {
    private static final zzio zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        zzio zzioVar = new zzio();
        zzb = zzioVar;
        zzeh.zzV(zzio.class, zzioVar);
    }

    private zzio() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzel zzelVar = zziq.zza;
            zzel zzelVar2 = zzim.zza;
            zzel zzelVar3 = zzip.zza;
            return zzeh.zzS(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", zzelVar, "zzg", "zzh", zzelVar2, "zzi", zzelVar3, "zzj", zzelVar3, "zzk", zzelVar3, "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzio();
        }
        zzhi zzhiVar = null;
        if (i2 == 4) {
            return new zzin(zzhiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
