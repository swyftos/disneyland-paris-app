package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes4.dex */
final class zzfz extends Thread {
    private final Object zza;
    private final BlockingQueue zzb;
    private boolean zzc = false;
    private final /* synthetic */ zzfv zzd;

    public zzfz(zzfv zzfvVar, String str, BlockingQueue blockingQueue) {
        this.zzd = zzfvVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zza = new Object();
        this.zzb = blockingQueue;
        setName(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z = false;
        while (!z) {
            try {
                this.zzd.zzh.acquire();
                z = true;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfw zzfwVar = (zzfw) this.zzb.poll();
                if (zzfwVar != null) {
                    Process.setThreadPriority(zzfwVar.zza ? threadPriority : 10);
                    zzfwVar.run();
                } else {
                    synchronized (this.zza) {
                        if (this.zzb.peek() == null && !this.zzd.zzi) {
                            try {
                                this.zza.wait(30000L);
                            } catch (InterruptedException e2) {
                                zza(e2);
                            }
                        }
                    }
                    synchronized (this.zzd.zzg) {
                        try {
                            if (this.zzb.peek() == null) {
                                break;
                            }
                        } finally {
                        }
                    }
                }
            }
            if (this.zzd.zzt().zza(zzaq.zzbx)) {
                zzb();
            }
            zzb();
        } catch (Throwable th) {
            zzb();
            throw th;
        }
    }

    private final void zzb() {
        synchronized (this.zzd.zzg) {
            try {
                if (!this.zzc) {
                    this.zzd.zzh.release();
                    this.zzd.zzg.notifyAll();
                    if (this == this.zzd.zza) {
                        zzfv.zza(this.zzd, null);
                    } else if (this == this.zzd.zzb) {
                        zzfv.zzb(this.zzd, null);
                    } else {
                        this.zzd.zzr().zzf().zza("Current scheduler thread is neither worker nor network");
                    }
                    this.zzc = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.notifyAll();
        }
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzd.zzr().zzi().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
