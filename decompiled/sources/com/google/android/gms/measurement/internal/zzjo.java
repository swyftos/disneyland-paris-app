package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjs;

/* loaded from: classes4.dex */
public final class zzjo<T extends Context & zzjs> {
    private final Context zza;

    public zzjo(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    @MainThread
    public final void zza() {
        zzfy zzfyVarZza = zzfy.zza(this.zza, null, null);
        zzeu zzeuVarZzr = zzfyVarZza.zzr();
        zzfyVarZza.zzu();
        zzeuVarZzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void zzb() {
        zzfy zzfyVarZza = zzfy.zza(this.zza, null, null);
        zzeu zzeuVarZzr = zzfyVarZza.zzr();
        zzfyVarZza.zzu();
        zzeuVarZzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final int zza(final Intent intent, int i, final int i2) throws IllegalStateException {
        zzfy zzfyVarZza = zzfy.zza(this.zza, null, null);
        final zzeu zzeuVarZzr = zzfyVarZza.zzr();
        if (intent == null) {
            zzeuVarZzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzfyVarZza.zzu();
        zzeuVarZzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new Runnable(this, i2, zzeuVarZzr, intent) { // from class: com.google.android.gms.measurement.internal.zzjr
                private final zzjo zza;
                private final int zzb;
                private final zzeu zzc;
                private final Intent zzd;

                {
                    this.zza = this;
                    this.zzb = i2;
                    this.zzc = zzeuVarZzr;
                    this.zzd = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc, this.zzd);
                }
            });
        }
        return 2;
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzkj zzkjVarZza = zzkj.zza(this.zza);
        zzkjVarZza.zzq().zza(new zzjt(this, zzkjVarZza, runnable));
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgd(zzkj.zza(this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(final JobParameters jobParameters) throws IllegalStateException {
        zzfy zzfyVarZza = zzfy.zza(this.zza, null, null);
        final zzeu zzeuVarZzr = zzfyVarZza.zzr();
        String string = jobParameters.getExtras().getString("action");
        zzfyVarZza.zzu();
        zzeuVarZzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new Runnable(this, zzeuVarZzr, jobParameters) { // from class: com.google.android.gms.measurement.internal.zzjq
            private final zzjo zza;
            private final zzeu zzb;
            private final JobParameters zzc;

            {
                this.zza = this;
                this.zzb = zzeuVarZzr;
                this.zzc = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc);
            }
        });
        return true;
    }

    @MainThread
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
        } else {
            zzc().zzx().zza("onRebind called. action", intent.getAction());
        }
    }

    private final zzeu zzc() {
        return zzfy.zza(this.zza, null, null).zzr();
    }

    final /* synthetic */ void zza(zzeu zzeuVar, JobParameters jobParameters) {
        zzeuVar.zzx().zza("AppMeasurementJobService processed last upload request.");
        ((zzjs) this.zza).zza(jobParameters, false);
    }

    final /* synthetic */ void zza(int i, zzeu zzeuVar, Intent intent) {
        if (((zzjs) this.zza).zza(i)) {
            zzeuVar.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            ((zzjs) this.zza).zza(intent);
        }
    }
}
