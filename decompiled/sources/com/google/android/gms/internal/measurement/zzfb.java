package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public class zzfb {
    private static volatile zzfb zzc;
    private static volatile zzfb zzd;
    private static final zzfb zze = new zzfb(true);
    private final Map zzf = Collections.emptyMap();

    public static zzfb zza() {
        zzfb zzfbVar = zzc;
        if (zzfbVar == null) {
            synchronized (zzfb.class) {
                try {
                    zzfbVar = zzc;
                    if (zzfbVar == null) {
                        zzfbVar = zze;
                        zzc = zzfbVar;
                    }
                } finally {
                }
            }
        }
        return zzfbVar;
    }

    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    public static zzfb zzb() {
        zzfb zzfbVar = zzd;
        if (zzfbVar != null) {
            return zzfbVar;
        }
        synchronized (zzfb.class) {
            try {
                zzfb zzfbVar2 = zzd;
                if (zzfbVar2 != null) {
                    return zzfbVar2;
                }
                zzfb zzfbVarZza = zzfn.zza(zzfb.class);
                zzd = zzfbVarZza;
                return zzfbVarZza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <ContainingType extends zzgw> zzfo.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzfo.zzd) this.zzf.get(new zza(containingtype, i));
    }

    private zzfb(boolean z) {
    }
}
