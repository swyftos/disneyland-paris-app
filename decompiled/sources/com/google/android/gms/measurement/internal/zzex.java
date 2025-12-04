package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes4.dex */
final class zzex implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzeu zzf;

    zzex(zzeu zzeuVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeuVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfg zzfgVarZzc = this.zzf.zzy.zzc();
        if (!zzfgVarZzc.zzz()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zzt().zzg()) {
                zzeu zzeuVar = this.zzf;
                zzeuVar.zzu();
                zzeuVar.zza = 'C';
            } else {
                zzeu zzeuVar2 = this.zzf;
                zzeuVar2.zzu();
                zzeuVar2.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            zzeu zzeuVar3 = this.zzf;
            zzeuVar3.zzb = zzeuVar3.zzt().zzf();
        }
        char cCharAt = "01VDIWEA?".charAt(this.zza);
        char c = this.zzf.zza;
        long j = this.zzf.zzb;
        String strZza = zzeu.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 24);
        sb.append(ExifInterface.GPS_MEASUREMENT_2D);
        sb.append(cCharAt);
        sb.append(c);
        sb.append(j);
        sb.append(":");
        sb.append(strZza);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = this.zzb.substring(0, 1024);
        }
        zzfgVarZzc.zzb.zza(string, 1L);
    }
}
