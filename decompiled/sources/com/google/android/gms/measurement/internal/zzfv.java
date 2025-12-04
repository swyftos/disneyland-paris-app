package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzfv extends zzgv {
    private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    private zzfz zza;
    private zzfz zzb;
    private final PriorityBlockingQueue zzc;
    private final BlockingQueue zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;
    private volatile boolean zzi;

    zzfv(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzg = new Object();
        this.zzh = new Semaphore(2);
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new LinkedBlockingQueue();
        this.zze = new zzfx(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = new zzfx(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzgv
    protected final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void zzd() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void zzc() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.zza;
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzfw zzfwVar = new zzfw(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                zzr().zzi().zza("Callable skipped the worker queue.");
            }
            zzfwVar.run();
        } else {
            zza(zzfwVar);
        }
        return zzfwVar;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzfw zzfwVar = new zzfw(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzfwVar.run();
        } else {
            zza(zzfwVar);
        }
        return zzfwVar;
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zza(new zzfw(this, runnable, false, "Task exception on worker thread"));
    }

    final Object zza(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzq().zza(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzew zzewVarZzi = zzr().zzi();
                String strValueOf = String.valueOf(str);
                zzewVarZzi.zza(strValueOf.length() != 0 ? "Interrupted waiting for ".concat(strValueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            zzew zzewVarZzi2 = zzr().zzi();
            String strValueOf2 = String.valueOf(str);
            zzewVarZzi2.zza(strValueOf2.length() != 0 ? "Timed out waiting for ".concat(strValueOf2) : new String("Timed out waiting for "));
        }
        return obj;
    }

    private final void zza(zzfw zzfwVar) {
        synchronized (this.zzg) {
            try {
                this.zzc.add(zzfwVar);
                zzfz zzfzVar = this.zza;
                if (zzfzVar == null) {
                    zzfz zzfzVar2 = new zzfz(this, "Measurement Worker", this.zzc);
                    this.zza = zzfzVar2;
                    zzfzVar2.setUncaughtExceptionHandler(this.zze);
                    this.zza.start();
                } else {
                    zzfzVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zzfw zzfwVar = new zzfw(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            try {
                this.zzd.add(zzfwVar);
                zzfz zzfzVar = this.zzb;
                if (zzfzVar == null) {
                    zzfz zzfzVar2 = new zzfz(this, "Measurement Network", this.zzd);
                    this.zzb = zzfzVar2;
                    zzfzVar2.setUncaughtExceptionHandler(this.zzf);
                    this.zzb.start();
                } else {
                    zzfzVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzes zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzkr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzfv zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzeu zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzfg zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    static /* synthetic */ zzfz zza(zzfv zzfvVar, zzfz zzfzVar) {
        zzfvVar.zza = null;
        return null;
    }

    static /* synthetic */ zzfz zzb(zzfv zzfvVar, zzfz zzfzVar) {
        zzfvVar.zzb = null;
        return null;
    }
}
