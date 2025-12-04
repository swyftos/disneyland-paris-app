package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
abstract class zzih {
    zzih() {
    }

    abstract Object zza();

    abstract Object zza(Object obj);

    abstract void zza(Object obj, int i, int i2);

    abstract void zza(Object obj, int i, long j);

    abstract void zza(Object obj, int i, zzeg zzegVar);

    abstract void zza(Object obj, int i, Object obj2);

    abstract void zza(Object obj, zzja zzjaVar);

    abstract void zza(Object obj, Object obj2);

    abstract boolean zza(zzhm zzhmVar);

    abstract Object zzb(Object obj);

    abstract void zzb(Object obj, int i, long j);

    abstract void zzb(Object obj, zzja zzjaVar);

    abstract void zzb(Object obj, Object obj2);

    abstract Object zzc(Object obj);

    abstract Object zzc(Object obj, Object obj2);

    abstract void zzd(Object obj);

    abstract int zze(Object obj);

    abstract int zzf(Object obj);

    final boolean zza(Object obj, zzhm zzhmVar) throws zzfw {
        int iZzb = zzhmVar.zzb();
        int i = iZzb >>> 3;
        int i2 = iZzb & 7;
        if (i2 == 0) {
            zza(obj, i, zzhmVar.zzg());
            return true;
        }
        if (i2 == 1) {
            zzb(obj, i, zzhmVar.zzi());
            return true;
        }
        if (i2 == 2) {
            zza(obj, i, zzhmVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzfw.zzf();
            }
            zza(obj, i, zzhmVar.zzj());
            return true;
        }
        Object objZza = zza();
        int i3 = 4 | (i << 3);
        while (zzhmVar.zza() != Integer.MAX_VALUE && zza(objZza, zzhmVar)) {
        }
        if (i3 != zzhmVar.zzb()) {
            throw zzfw.zze();
        }
        zza(obj, i, zza(objZza));
        return true;
    }
}
