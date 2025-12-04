package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
abstract class zzkh extends zzgs implements zzgu {
    protected final zzkj zza;

    zzkh(zzkj zzkjVar) {
        super(zzkjVar.zzs());
        Preconditions.checkNotNull(zzkjVar);
        this.zza = zzkjVar;
    }

    public zzfs zzj() {
        return this.zza.zzc();
    }

    public zzad zzi() {
        return this.zza.zze();
    }

    public zzo e_() {
        return this.zza.zzf();
    }

    public zzkn zzg() {
        return this.zza.zzh();
    }
}
