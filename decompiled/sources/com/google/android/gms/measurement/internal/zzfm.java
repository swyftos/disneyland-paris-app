package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class zzfm {
    private final String zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzfg zze;

    public zzfm(zzfg zzfgVar, String str, String str2) {
        this.zze = zzfgVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = null;
    }

    @WorkerThread
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getString(this.zza, null);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(String str) {
        if (this.zze.zzt().zza(zzaq.zzbw) || !zzkr.zzc(str, this.zzd)) {
            SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
            editorEdit.putString(this.zza, str);
            editorEdit.apply();
            this.zzd = str;
        }
    }
}
