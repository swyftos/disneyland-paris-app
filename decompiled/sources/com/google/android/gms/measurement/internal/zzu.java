package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzcb;

/* loaded from: classes4.dex */
final class zzu extends zzv {
    private zzbt.zze zzg;
    private final /* synthetic */ zzo zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzu(zzo zzoVar, String str, int i, zzbt.zze zzeVar) {
        super(str, i);
        this.zzh = zzoVar;
        this.zzg = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    final boolean zzc() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    final int zza() {
        return this.zzg.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean zza(Long l, Long l2, zzcb.zzk zzkVar, boolean z) {
        byte b = com.google.android.gms.internal.measurement.zzki.zzb() && this.zzh.zzt().zzd(this.zza, zzaq.zzbd);
        boolean zZze = this.zzg.zze();
        boolean zZzf = this.zzg.zzf();
        boolean zZzh = this.zzg.zzh();
        byte b2 = zZze || zZzf || zZzh;
        Boolean boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        if (z && b2 == false) {
            this.zzh.zzr().zzx().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null);
            return true;
        }
        zzbt.zzc zzcVarZzd = this.zzg.zzd();
        boolean zZzf2 = zzcVarZzd.zzf();
        if (zzkVar.zzf()) {
            if (!zzcVarZzd.zzc()) {
                this.zzh.zzr().zzi().zza("No number filter for long property. property", this.zzh.zzo().zzc(zzkVar.zzc()));
            } else {
                boolZza = zzv.zza(zzv.zza(zzkVar.zzg(), zzcVarZzd.zzd()), zZzf2);
            }
        } else if (zzkVar.zzh()) {
            if (!zzcVarZzd.zzc()) {
                this.zzh.zzr().zzi().zza("No number filter for double property. property", this.zzh.zzo().zzc(zzkVar.zzc()));
            } else {
                boolZza = zzv.zza(zzv.zza(zzkVar.zzi(), zzcVarZzd.zzd()), zZzf2);
            }
        } else if (zzkVar.zzd()) {
            if (!zzcVarZzd.zza()) {
                if (!zzcVarZzd.zzc()) {
                    this.zzh.zzr().zzi().zza("No string or number filter defined. property", this.zzh.zzo().zzc(zzkVar.zzc()));
                } else if (zzkn.zza(zzkVar.zze())) {
                    boolZza = zzv.zza(zzv.zza(zzkVar.zze(), zzcVarZzd.zzd()), zZzf2);
                } else {
                    this.zzh.zzr().zzi().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzo().zzc(zzkVar.zzc()), zzkVar.zze());
                }
            } else {
                boolZza = zzv.zza(zzv.zza(zzkVar.zze(), zzcVarZzd.zzb(), this.zzh.zzr()), zZzf2);
            }
        } else {
            this.zzh.zzr().zzi().zza("User property has no value, property", this.zzh.zzo().zzc(zzkVar.zzc()));
        }
        this.zzh.zzr().zzx().zza("Property filter result", boolZza == null ? "null" : boolZza);
        if (boolZza == null) {
            return false;
        }
        this.zzc = Boolean.TRUE;
        if (zZzh && !boolZza.booleanValue()) {
            return true;
        }
        if (!z || this.zzg.zze()) {
            this.zzd = boolZza;
        }
        if (boolZza.booleanValue() && b2 != false && zzkVar.zza()) {
            long jZzb = zzkVar.zzb();
            if (l != null) {
                jZzb = l.longValue();
            }
            if (b != false && this.zzg.zze() && !this.zzg.zzf() && l2 != null) {
                jZzb = l2.longValue();
            }
            if (this.zzg.zzf()) {
                this.zzf = Long.valueOf(jZzb);
            } else {
                this.zze = Long.valueOf(jZzb);
            }
        }
        return true;
    }
}
