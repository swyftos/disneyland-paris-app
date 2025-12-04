package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzen<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzel zzb;
    private final Object zzc;
    private final Object zzd;
    private final Object zze;
    private volatile Object zzg;
    private volatile Object zzh;

    private zzen(String str, Object obj, Object obj2, zzel zzelVar) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zzb = zzelVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zza(@Nullable V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzek.zza == null) {
            return (V) this.zzc;
        }
        synchronized (zzf) {
            try {
                if (zzx.zza()) {
                    return this.zzh == null ? (V) this.zzc : (V) this.zzh;
                }
                try {
                    for (zzen zzenVar : zzaq.zzct) {
                        if (zzx.zza()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objZza = null;
                        try {
                            zzel zzelVar = zzenVar.zzb;
                            if (zzelVar != null) {
                                objZza = zzelVar.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (zzf) {
                            zzenVar.zzh = objZza;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                zzel zzelVar2 = this.zzb;
                if (zzelVar2 == null) {
                    return (V) this.zzc;
                }
                try {
                    return (V) zzelVar2.zza();
                } catch (IllegalStateException unused3) {
                    return (V) this.zzc;
                } catch (SecurityException unused4) {
                    return (V) this.zzc;
                }
            } finally {
            }
        }
    }
}
