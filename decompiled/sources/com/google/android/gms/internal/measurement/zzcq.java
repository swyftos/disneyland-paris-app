package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;

/* loaded from: classes3.dex */
final class zzcq implements zzcl {
    private static zzcq zza;
    private final Context zzb;
    private final ContentObserver zzc;

    static zzcq zza(Context context) {
        zzcq zzcqVar;
        synchronized (zzcq.class) {
            try {
                if (zza == null) {
                    zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcq(context) : new zzcq();
                }
                zzcqVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzcqVar;
    }

    private zzcq(Context context) {
        this.zzb = context;
        zzcs zzcsVar = new zzcs(this, null);
        this.zzc = zzcsVar;
        context.getContentResolver().registerContentObserver(zzcg.zza, true, zzcsVar);
    }

    private zzcq() {
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcl
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzco.zza(new zzcn(this, str) { // from class: com.google.android.gms.internal.measurement.zzcp
                private final zzcq zza;
                private final String zzb;

                {
                    this.zza = this;
                    this.zzb = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzcn
                public final Object zza() {
                    return this.zza.zzb(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zza() {
        Context context;
        try {
            zzcq zzcqVar = zza;
            if (zzcqVar != null && (context = zzcqVar.zzb) != null && zzcqVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    final /* synthetic */ String zzb(String str) {
        return zzcg.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
