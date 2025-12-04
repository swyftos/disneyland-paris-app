package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzir extends zzg {
    private final zzji zza;
    private zzem zzb;
    private volatile Boolean zzc;
    private final zzag zzd;
    private final zzkc zze;
    private final List zzf;
    private final zzag zzg;

    protected zzir(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzf = new ArrayList();
        this.zze = new zzkc(zzfyVar.zzm());
        this.zza = new zzji(this);
        this.zzd = new zziq(this, zzfyVar);
        this.zzg = new zzja(this, zzfyVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    @WorkerThread
    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    @WorkerThread
    protected final void zzac() {
        zzd();
        zzw();
        zza(new zzjd(this, zza(true)));
    }

    final void zza(zzem zzemVar, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) {
        int size;
        List<AbstractSafeParcelable> listZza;
        zzd();
        zzb();
        zzw();
        boolean zZzaj = zzaj();
        int i = 100;
        int i2 = 0;
        while (i2 < 1001 && i == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zZzaj || (listZza = zzj().zza(100)) == null) {
                size = 0;
            } else {
                arrayList.addAll(listZza);
                size = listZza.size();
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzao) {
                    try {
                        zzemVar.zza((zzao) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e) {
                        zzr().zzf().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkq) {
                    try {
                        zzemVar.zza((zzkq) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e2) {
                        zzr().zzf().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzw) {
                    try {
                        zzemVar.zza((zzw) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e3) {
                        zzr().zzf().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i = size;
        }
    }

    @WorkerThread
    protected final void zza(zzao zzaoVar, String str) {
        Preconditions.checkNotNull(zzaoVar);
        zzd();
        zzw();
        boolean zZzaj = zzaj();
        zza(new zzjc(this, zZzaj, zZzaj && zzj().zza(zzaoVar), zzaoVar, zza(true), str));
    }

    @WorkerThread
    protected final void zza(zzw zzwVar) {
        Preconditions.checkNotNull(zzwVar);
        zzd();
        zzw();
        zzu();
        zza(new zzjf(this, true, zzj().zza(zzwVar), new zzw(zzwVar), zza(true), zzwVar));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzw>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza(new zzje(this, atomicReference, str, str2, str3, zza(false)));
    }

    @WorkerThread
    protected final void zza(com.google.android.gms.internal.measurement.zzw zzwVar, String str, String str2) {
        zzd();
        zzw();
        zza(new zzjh(this, str, str2, zza(false), zzwVar));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzkq>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza(new zzjg(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    @WorkerThread
    protected final void zza(com.google.android.gms.internal.measurement.zzw zzwVar, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza(new zzjj(this, str, str2, z, zza(false), zzwVar));
    }

    @WorkerThread
    protected final void zza(zzkq zzkqVar) {
        zzd();
        zzw();
        zza(new zzit(this, zzaj() && zzj().zza(zzkqVar), zzkqVar, zza(true)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzkq>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza(new zzis(this, atomicReference, zza(false), z));
    }

    @WorkerThread
    protected final void zzad() {
        zzd();
        zzb();
        zzw();
        zzn zznVarZza = zza(false);
        if (zzaj()) {
            zzj().zzab();
        }
        zza(new zziv(this, zznVarZza));
    }

    private final boolean zzaj() {
        zzu();
        return true;
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza(new zziu(this, atomicReference, zza(false)));
    }

    @WorkerThread
    public final void zza(com.google.android.gms.internal.measurement.zzw zzwVar) {
        zzd();
        zzw();
        zza(new zzix(this, zza(false), zzwVar));
    }

    @WorkerThread
    protected final void zzae() {
        zzd();
        zzw();
        zzn zznVarZza = zza(true);
        zzj().zzac();
        zza(new zziw(this, zznVarZza));
    }

    @WorkerThread
    protected final void zza(zzij zzijVar) {
        zzd();
        zzw();
        zza(new zziz(this, zzijVar));
    }

    @WorkerThread
    public final void zza(Bundle bundle) {
        zzd();
        zzw();
        zza(new zziy(this, bundle, zza(false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzak() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzaq.zzai.zza(null).longValue());
    }

    final void zzaf() {
        zzd();
        zzw();
        if (zzab()) {
            return;
        }
        if (zzal()) {
            this.zza.zzb();
            return;
        }
        if (zzt().zzy()) {
            return;
        }
        zzu();
        List<ResolveInfo> listQueryIntentServices = zzn().getPackageManager().queryIntentServices(new Intent().setClassName(zzn(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context contextZzn = zzn();
            zzu();
            intent.setComponent(new ComponentName(contextZzn, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        zzr().zzf().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    final Boolean zzag() {
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzal() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzir.zzal():boolean");
    }

    @VisibleForTesting
    @WorkerThread
    protected final void zza(zzem zzemVar) {
        zzd();
        Preconditions.checkNotNull(zzemVar);
        this.zzb = zzemVar;
        zzak();
        zzan();
    }

    @WorkerThread
    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzam() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    private final void zza(Runnable runnable) {
        zzd();
        if (zzab()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzr().zzf().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzaf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzan() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    private final zzn zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    @WorkerThread
    public final void zza(com.google.android.gms.internal.measurement.zzw zzwVar, zzao zzaoVar, String str) {
        zzd();
        zzw();
        if (zzp().zza(12451000) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzwVar, new byte[0]);
        } else {
            zza(new zzjb(this, zzaoVar, str, zzwVar));
        }
    }

    final boolean zzai() {
        zzd();
        zzw();
        return !zzal() || zzp().zzj() >= 200900;
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhc zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzer zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzeq zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjv zzk() {
        return super.zzk();
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

    static /* synthetic */ zzem zza(zzir zzirVar, zzem zzemVar) {
        zzirVar.zzb = null;
        return null;
    }
}
