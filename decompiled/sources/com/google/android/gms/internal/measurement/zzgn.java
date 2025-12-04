package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;

/* loaded from: classes3.dex */
final class zzgn implements zzho {
    private static final zzgx zzb = new zzgm();
    private final zzgx zza;

    public zzgn() {
        this(new zzgp(zzfm.zza(), zza()));
    }

    private zzgn(zzgx zzgxVar) {
        this.zza = (zzgx) zzfr.zza((Object) zzgxVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.measurement.zzho
    public final zzhp zza(Class cls) {
        zzhr.zza(cls);
        zzgu zzguVarZzb = this.zza.zzb(cls);
        if (zzguVarZzb.zzb()) {
            if (zzfo.class.isAssignableFrom(cls)) {
                return zzhc.zza(zzhr.zzc(), zzff.zza(), zzguVarZzb.zzc());
            }
            return zzhc.zza(zzhr.zza(), zzff.zzb(), zzguVarZzb.zzc());
        }
        if (zzfo.class.isAssignableFrom(cls)) {
            if (zza(zzguVarZzb)) {
                return zzha.zza(cls, zzguVarZzb, zzhg.zzb(), zzgg.zzb(), zzhr.zzc(), zzff.zza(), zzgv.zzb());
            }
            return zzha.zza(cls, zzguVarZzb, zzhg.zzb(), zzgg.zzb(), zzhr.zzc(), (zzfd) null, zzgv.zzb());
        }
        if (zza(zzguVarZzb)) {
            return zzha.zza(cls, zzguVarZzb, zzhg.zza(), zzgg.zza(), zzhr.zza(), zzff.zzb(), zzgv.zza());
        }
        return zzha.zza(cls, zzguVarZzb, zzhg.zza(), zzgg.zza(), zzhr.zzb(), (zzfd) null, zzgv.zza());
    }

    private static boolean zza(zzgu zzguVar) {
        return zzguVar.zza() == zzfo.zzf.zzh;
    }

    private static zzgx zza() {
        try {
            return (zzgx) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
