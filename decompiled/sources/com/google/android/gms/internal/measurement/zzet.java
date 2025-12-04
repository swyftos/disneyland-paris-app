package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzet implements zzhm {
    private final zzes zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public static zzet zza(zzes zzesVar) {
        zzet zzetVar = zzesVar.zzc;
        return zzetVar != null ? zzetVar : new zzet(zzesVar);
    }

    private zzet(zzes zzesVar) {
        zzes zzesVar2 = (zzes) zzfr.zza((Object) zzesVar, "input");
        this.zza = zzesVar2;
        zzesVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zza() {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zza();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final boolean zzc() {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzb(i);
    }

    private final void zza(int i) throws zzfz {
        if ((this.zzb & 7) != i) {
            throw zzfw.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final double zzd() throws zzfz {
        zza(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final float zze() throws zzfz {
        zza(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final long zzf() throws zzfz {
        zza(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final long zzg() throws zzfz {
        zza(0);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zzh() throws zzfz {
        zza(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final long zzi() throws zzfz {
        zza(1);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zzj() throws zzfz {
        zza(5);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final boolean zzk() throws zzfz {
        zza(0);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final String zzl() throws zzfz {
        zza(2);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final String zzm() throws zzfz {
        zza(2);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final Object zza(zzhp zzhpVar, zzfb zzfbVar) throws zzfz {
        zza(2);
        return zzc(zzhpVar, zzfbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final Object zzb(zzhp zzhpVar, zzfb zzfbVar) throws zzfz {
        zza(3);
        return zzd(zzhpVar, zzfbVar);
    }

    private final Object zzc(zzhp zzhpVar, zzfb zzfbVar) throws IOException {
        int iZzm = this.zza.zzm();
        zzes zzesVar = this.zza;
        if (zzesVar.zza >= zzesVar.zzb) {
            throw new zzfw("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzc = zzesVar.zzc(iZzm);
        Object objZza = zzhpVar.zza();
        this.zza.zza++;
        zzhpVar.zza(objZza, this, zzfbVar);
        zzhpVar.zzc(objZza);
        this.zza.zza(0);
        r4.zza--;
        this.zza.zzd(iZzc);
        return objZza;
    }

    private final Object zzd(zzhp zzhpVar, zzfb zzfbVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            Object objZza = zzhpVar.zza();
            zzhpVar.zza(objZza, this, zzfbVar);
            zzhpVar.zzc(objZza);
            if (this.zzb == this.zzc) {
                return objZza;
            }
            throw zzfw.zzg();
        } finally {
            this.zzc = i;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final zzeg zzn() throws zzfz {
        zza(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zzo() throws zzfz {
        zza(0);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zzp() throws zzfz {
        zza(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zzq() throws zzfz {
        zza(5);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final long zzr() throws zzfz {
        zza(1);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final int zzs() throws zzfz {
        zza(0);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final long zzt() throws zzfz {
        zza(0);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zza(List list) throws IOException {
        int iZza;
        int i = this.zzb & 7;
        if (i == 1) {
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i == 2) {
            int iZzm = this.zza.zzm();
            zzb(iZzm);
            int iZzu = this.zza.zzu() + iZzm;
            do {
                list.add(Double.valueOf(this.zza.zzb()));
            } while (this.zza.zzu() < iZzu);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzb(List list) throws IOException {
        int iZza;
        int i = this.zzb & 7;
        if (i == 2) {
            int iZzm = this.zza.zzm();
            zzc(iZzm);
            int iZzu = this.zza.zzu() + iZzm;
            do {
                list.add(Float.valueOf(this.zza.zzc()));
            } while (this.zza.zzu() < iZzu);
            return;
        }
        if (i == 5) {
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzc(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgkVar.zza(this.zza.zzd());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgkVar.zza(this.zza.zzd());
                } while (this.zza.zzu() < iZzu);
                zzd(iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzd()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Long.valueOf(this.zza.zzd()));
            } while (this.zza.zzu() < iZzu2);
            zzd(iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzd(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgkVar.zza(this.zza.zze());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgkVar.zza(this.zza.zze());
                } while (this.zza.zzu() < iZzu);
                zzd(iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Long.valueOf(this.zza.zze()));
            } while (this.zza.zzu() < iZzu2);
            zzd(iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zze(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfpVar.zzd(this.zza.zzf());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfpVar.zzd(this.zza.zzf());
                } while (this.zza.zzu() < iZzu);
                zzd(iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzu() < iZzu2);
            zzd(iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzf(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgkVar.zza(this.zza.zzg());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzm = this.zza.zzm();
                zzb(iZzm);
                int iZzu = this.zza.zzu() + iZzm;
                do {
                    zzgkVar.zza(this.zza.zzg());
                } while (this.zza.zzu() < iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzm2 = this.zza.zzm();
            zzb(iZzm2);
            int iZzu2 = this.zza.zzu() + iZzm2;
            do {
                list.add(Long.valueOf(this.zza.zzg()));
            } while (this.zza.zzu() < iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzg(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzm = this.zza.zzm();
                zzc(iZzm);
                int iZzu = this.zza.zzu() + iZzm;
                do {
                    zzfpVar.zzd(this.zza.zzh());
                } while (this.zza.zzu() < iZzu);
                return;
            }
            if (i == 5) {
                do {
                    zzfpVar.zzd(this.zza.zzh());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzm2 = this.zza.zzm();
            zzc(iZzm2);
            int iZzu2 = this.zza.zzu() + iZzm2;
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzu() < iZzu2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzh(List list) throws IOException {
        int iZza;
        int i = this.zzb & 7;
        if (i == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzi()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i == 2) {
            int iZzu = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Boolean.valueOf(this.zza.zzi()));
            } while (this.zza.zzu() < iZzu);
            zzd(iZzu);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzi(List list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzj(List list) throws IOException {
        zza(list, true);
    }

    private final void zza(List list, boolean z) throws IOException {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            throw zzfw.zzf();
        }
        if ((list instanceof zzgh) && !z) {
            zzgh zzghVar = (zzgh) list;
            do {
                zzghVar.zza(zzn());
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
            this.zzd = iZza2;
            return;
        }
        do {
            list.add(z ? zzm() : zzl());
            if (this.zza.zzt()) {
                return;
            } else {
                iZza = this.zza.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zza(List list, zzhp zzhpVar, zzfb zzfbVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzfw.zzf();
        }
        do {
            list.add(zzc(zzhpVar, zzfbVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZza = this.zza.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzb(List list, zzhp zzhpVar, zzfb zzfbVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzfw.zzf();
        }
        do {
            list.add(zzd(zzhpVar, zzfbVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZza = this.zza.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzk(List list) throws IOException {
        int iZza;
        if ((this.zzb & 7) != 2) {
            throw zzfw.zzf();
        }
        do {
            list.add(zzn());
            if (this.zza.zzt()) {
                return;
            } else {
                iZza = this.zza.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzl(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfpVar.zzd(this.zza.zzm());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfpVar.zzd(this.zza.zzm());
                } while (this.zza.zzu() < iZzu);
                zzd(iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzm()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzm()));
            } while (this.zza.zzu() < iZzu2);
            zzd(iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzm(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfpVar.zzd(this.zza.zzn());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfpVar.zzd(this.zza.zzn());
                } while (this.zza.zzu() < iZzu);
                zzd(iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
            } while (this.zza.zzu() < iZzu2);
            zzd(iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzn(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzm = this.zza.zzm();
                zzc(iZzm);
                int iZzu = this.zza.zzu() + iZzm;
                do {
                    zzfpVar.zzd(this.zza.zzo());
                } while (this.zza.zzu() < iZzu);
                return;
            }
            if (i == 5) {
                do {
                    zzfpVar.zzd(this.zza.zzo());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzm2 = this.zza.zzm();
            zzc(iZzm2);
            int iZzu2 = this.zza.zzu() + iZzm2;
            do {
                list.add(Integer.valueOf(this.zza.zzo()));
            } while (this.zza.zzu() < iZzu2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzo()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzo(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgkVar.zza(this.zza.zzp());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzm = this.zza.zzm();
                zzb(iZzm);
                int iZzu = this.zza.zzu() + iZzm;
                do {
                    zzgkVar.zza(this.zza.zzp());
                } while (this.zza.zzu() < iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzm2 = this.zza.zzm();
            zzb(iZzm2);
            int iZzu2 = this.zza.zzu() + iZzm2;
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzu() < iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzp(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfpVar.zzd(this.zza.zzq());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfpVar.zzd(this.zza.zzq());
                } while (this.zza.zzu() < iZzu);
                zzd(iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzq()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzq()));
            } while (this.zza.zzu() < iZzu2);
            zzd(iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zzq(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgkVar.zza(this.zza.zzr());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZza2 = this.zza.zza();
                    }
                } while (iZza2 == this.zzb);
                this.zzd = iZza2;
                return;
            }
            if (i == 2) {
                int iZzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgkVar.zza(this.zza.zzr());
                } while (this.zza.zzu() < iZzu);
                zzd(iZzu);
                return;
            }
            throw zzfw.zzf();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzr()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i2 == 2) {
            int iZzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Long.valueOf(this.zza.zzr()));
            } while (this.zza.zzu() < iZzu2);
            zzd(iZzu2);
            return;
        }
        throw zzfw.zzf();
    }

    private static void zzb(int i) throws zzfw {
        if ((i & 7) != 0) {
            throw zzfw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhm
    public final void zza(Map map, zzgr zzgrVar, zzfb zzfbVar) throws IOException {
        zza(2);
        this.zza.zzc(this.zza.zzm());
        throw null;
    }

    private static void zzc(int i) throws zzfw {
        if ((i & 3) != 0) {
            throw zzfw.zzg();
        }
    }

    private final void zzd(int i) throws zzfw {
        if (this.zza.zzu() != i) {
            throw zzfw.zza();
        }
    }
}
