package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes4.dex */
final class zzfw extends FutureTask implements Comparable {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzfv zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfw(zzfv zzfvVar, Callable callable, boolean z, String str) {
        super(callable);
        this.zzd = zzfvVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfv.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfvVar.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfw(zzfv zzfvVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzd = zzfvVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfv.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = false;
        if (andIncrement == Long.MAX_VALUE) {
            zzfvVar.zzr().zzf().zza("Tasks index overflow");
        }
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.zzd.zzr().zzf().zza(this.zzc, th);
        super.setException(th);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzfw zzfwVar = (zzfw) obj;
        boolean z = this.zza;
        if (z != zzfwVar.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzfwVar.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzr().zzg().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }
}
