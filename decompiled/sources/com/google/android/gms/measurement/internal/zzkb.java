package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzkt;
import com.google.android.gms.internal.measurement.zzla;
import com.google.android.gms.internal.measurement.zzlf;

/* loaded from: classes4.dex */
final class zzkb {
    private long zza;
    private long zzb;
    private final zzag zzc;
    private final /* synthetic */ zzjv zzd;

    public zzkb(zzjv zzjvVar) {
        this.zzd = zzjvVar;
        this.zzc = new zzka(this, zzjvVar.zzy);
        long jElapsedRealtime = zzjvVar.zzm().elapsedRealtime();
        this.zza = jElapsedRealtime;
        this.zzb = jElapsedRealtime;
    }

    final void zza(long j) {
        this.zzd.zzd();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = j;
    }

    final void zzb(long j) {
        this.zzc.zzc();
    }

    final void zza() {
        this.zzc.zzc();
        this.zza = 0L;
        this.zzb = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false, this.zzd.zzm().elapsedRealtime());
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzd();
        this.zzd.zzw();
        if (!zzkt.zzb() || !this.zzd.zzt().zza(zzaq.zzbz)) {
            j = this.zzd.zzm().elapsedRealtime();
        }
        if (!zzla.zzb() || !this.zzd.zzt().zza(zzaq.zzbv) || this.zzd.zzy.zzab()) {
            this.zzd.zzs().zzp.zza(this.zzd.zzm().currentTimeMillis());
        }
        long jZzc = j - this.zza;
        if (!z && jZzc < 1000) {
            this.zzd.zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jZzc));
            return false;
        }
        if (this.zzd.zzt().zza(zzaq.zzat) && !z2) {
            jZzc = (zzlf.zzb() && this.zzd.zzt().zza(zzaq.zzav) && zzkt.zzb() && this.zzd.zzt().zza(zzaq.zzbz)) ? zzc(j) : zzb();
        }
        this.zzd.zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(jZzc));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jZzc);
        zzii.zza(this.zzd.zzi().zza(!this.zzd.zzt().zzj().booleanValue()), bundle, true);
        if (this.zzd.zzt().zza(zzaq.zzat) && !this.zzd.zzt().zza(zzaq.zzau) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.zzd.zzt().zza(zzaq.zzau) || !z2) {
            this.zzd.zzf().zza("auto", "_e", bundle);
        }
        this.zza = j;
        this.zzc.zzc();
        this.zzc.zza(3600000L);
        return true;
    }

    final long zzb() {
        long jElapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = jElapsedRealtime - this.zzb;
        this.zzb = jElapsedRealtime;
        return j;
    }

    final long zzc(long j) {
        long j2 = j - this.zzb;
        this.zzb = j;
        return j2;
    }
}
