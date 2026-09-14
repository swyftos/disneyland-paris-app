package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes3.dex */
final class zzg implements Runnable {
    final /* synthetic */ zzh zza;

    zzg(zzh zzhVar) {
        this.zza = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzb) {
            try {
                zzh zzhVar = this.zza;
                if (zzhVar.zzc != null) {
                    zzhVar.zzc.onCanceled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
