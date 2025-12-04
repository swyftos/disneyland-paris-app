package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class zzfq {
    private final zzft zza;

    public zzfq(zzft zzftVar) {
        Preconditions.checkNotNull(zzftVar);
        this.zza = zzftVar;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @MainThread
    public final void zza(Context context, Intent intent) {
        zzfy zzfyVarZza = zzfy.zza(context, null, null);
        zzeu zzeuVarZzr = zzfyVarZza.zzr();
        if (intent == null) {
            zzeuVarZzr.zzi().zza("Receiver called with null intent");
            return;
        }
        zzfyVarZza.zzu();
        String action = intent.getAction();
        zzeuVarZzr.zzx().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzeuVarZzr.zzx().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzeuVarZzr.zzi().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
