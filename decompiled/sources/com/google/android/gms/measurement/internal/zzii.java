package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzkt;
import com.google.android.gms.internal.measurement.zzlf;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzii extends zzg {

    @VisibleForTesting
    protected zzij zza;
    private volatile zzij zzb;
    private zzij zzc;
    private final Map zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzij zzg;
    private zzij zzh;
    private boolean zzi;
    private final Object zzj;
    private zzij zzk;
    private String zzl;

    public zzii(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    @WorkerThread
    public final zzij zza(boolean z) {
        zzw();
        zzd();
        if (!zzt().zza(zzaq.zzcc) || !z) {
            return this.zza;
        }
        zzij zzijVar = this.zza;
        return zzijVar != null ? zzijVar : this.zzh;
    }

    public final void zza(Bundle bundle) {
        String strZza;
        String str;
        if (!zzt().zza(zzaq.zzcc)) {
            zzr().zzk().zza("Manual screen reporting is disabled.");
            return;
        }
        synchronized (this.zzj) {
            try {
                if (!this.zzi) {
                    zzr().zzk().zza("Cannot log screen view event when the app is in the background.");
                    return;
                }
                if (bundle != null) {
                    String string = bundle.getString("screen_name");
                    if (string != null && (string.length() <= 0 || string.length() > 100)) {
                        zzr().zzk().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                        return;
                    }
                    String string2 = bundle.getString("screen_class");
                    if (string2 != null && (string2.length() <= 0 || string2.length() > 100)) {
                        zzr().zzk().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                        return;
                    } else {
                        str = string;
                        strZza = string2;
                    }
                } else {
                    strZza = null;
                    str = null;
                }
                if (strZza == null) {
                    Activity activity = this.zze;
                    if (activity != null) {
                        strZza = zza(activity.getClass().getCanonicalName());
                    } else {
                        strZza = "Activity";
                    }
                }
                String str2 = strZza;
                if (this.zzf && this.zzb != null) {
                    this.zzf = false;
                    boolean zZzc = zzkr.zzc(this.zzb.zzb, str2);
                    boolean zZzc2 = zzkr.zzc(this.zzb.zza, str);
                    if (zZzc && zZzc2) {
                        zzr().zzk().zza("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                zzr().zzx().zza("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
                zzij zzijVar = this.zzb == null ? this.zzc : this.zzb;
                zzij zzijVar2 = new zzij(str, str2, zzp().zzg(), true);
                this.zzb = zzijVar2;
                this.zzc = zzijVar;
                this.zzg = zzijVar2;
                zzq().zza(new zzil(this, bundle, zzijVar2, zzijVar, zzm().elapsedRealtime()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Bundle bundle, zzij zzijVar, zzij zzijVar2, long j) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        zza(zzijVar, zzijVar2, j, true, zzp().zza((String) null, "screen_view", bundle, (List) null, true, true));
    }

    @MainThread
    public final void zza(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) throws IllegalStateException {
        if (!zzt().zzj().booleanValue()) {
            zzr().zzk().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass().getCanonicalName());
        }
        boolean zZzc = zzkr.zzc(this.zzb.zzb, str2);
        boolean zZzc2 = zzkr.zzc(this.zzb.zza, str);
        if (zZzc && zZzc2) {
            zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzr().zzx().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzij zzijVar = new zzij(str, str2, zzp().zzg());
        this.zzd.put(activity, zzijVar);
        zza(activity, zzijVar, true);
    }

    public final zzij zzab() {
        zzb();
        return this.zzb;
    }

    private final void zza(Activity activity, zzij zzijVar, boolean z) throws IllegalStateException {
        zzij zzijVar2;
        zzij zzijVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzijVar.zzb == null) {
            zzijVar2 = new zzij(zzijVar.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzijVar.zzc, zzijVar.zze);
        } else {
            zzijVar2 = zzijVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzijVar2;
        zzq().zza(new zzik(this, zzijVar2, zzijVar3, zzm().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzij zzijVar, zzij zzijVar2, long j, boolean z, Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzij zzijVar3;
        long jZzb;
        zzd();
        boolean z2 = false;
        if (zzt().zza(zzaq.zzat)) {
            if (z && this.zza != null) {
                z2 = true;
            }
            if (z2) {
                zza(this.zza, true, j);
            }
        } else if (z && (zzijVar3 = this.zza) != null) {
            zza(zzijVar3, true, j);
        }
        if (zzijVar2 == null || zzijVar2.zzc != zzijVar.zzc || !zzkr.zzc(zzijVar2.zzb, zzijVar.zzb) || !zzkr.zzc(zzijVar2.zza, zzijVar.zza)) {
            Bundle bundle2 = new Bundle();
            if (zzt().zza(zzaq.zzcc)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            zza(zzijVar, bundle2, true);
            if (zzijVar2 != null) {
                String str = zzijVar2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zzijVar2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zzijVar2.zzc);
            }
            if (zzt().zza(zzaq.zzat) && z2) {
                if (zzlf.zzb() && zzt().zza(zzaq.zzav) && zzkt.zzb() && zzt().zza(zzaq.zzbz)) {
                    jZzb = zzk().zza(j);
                } else {
                    jZzb = zzk().zzb.zzb();
                }
                if (jZzb > 0) {
                    zzp().zza(bundle2, jZzb);
                }
            }
            String str3 = "auto";
            if (zzt().zza(zzaq.zzcc)) {
                if (!zzt().zzj().booleanValue()) {
                    bundle2.putLong("_mt", 1L);
                }
                if (zzijVar.zze) {
                    str3 = TCEventPropertiesNames.TCA_APP;
                }
            }
            zzf().zzb(str3, "_vs", bundle2);
        }
        this.zza = zzijVar;
        if (zzt().zza(zzaq.zzcc) && zzijVar.zze) {
            this.zzh = zzijVar;
        }
        zzh().zza(zzijVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzij zzijVar, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (!zzk().zza(zzijVar != null && zzijVar.zzd, z, j) || zzijVar == null) {
            return;
        }
        zzijVar.zzd = false;
    }

    public static void zza(zzij zzijVar, Bundle bundle, boolean z) {
        if (bundle == null || zzijVar == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zzijVar == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = zzijVar.zza;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = zzijVar.zzb;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zzijVar.zzc);
    }

    @WorkerThread
    public final void zza(String str, zzij zzijVar) {
        zzd();
        synchronized (this) {
            try {
                String str2 = this.zzl;
                if (str2 == null || str2.equals(str) || zzijVar != null) {
                    this.zzl = str;
                    this.zzk = zzijVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String zza(String str) {
        String str2;
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length > 0) {
            str2 = strArrSplit[strArrSplit.length - 1];
        } else {
            str2 = "";
        }
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzij zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzij zzijVar = (zzij) this.zzd.get(activity);
        if (zzijVar == null) {
            zzij zzijVar2 = new zzij(null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
            this.zzd.put(activity, zzijVar2);
            zzijVar = zzijVar2;
        }
        return (zzt().zza(zzaq.zzcc) && this.zzg != null) ? this.zzg : zzijVar;
    }

    @MainThread
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zzt().zzj().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzij(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    @MainThread
    public final void zza(Activity activity) throws IllegalStateException {
        if (zzt().zza(zzaq.zzcc)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (zzt().zza(zzaq.zzcb) && zzt().zzj().booleanValue()) {
                        this.zzg = null;
                        zzq().zza(new zzio(this));
                    }
                }
            }
        }
        if (zzt().zza(zzaq.zzcb) && !zzt().zzj().booleanValue()) {
            this.zzb = this.zzg;
            zzq().zza(new zzin(this));
        } else {
            zza(activity, zzd(activity), false);
            zza zzaVarZze = zze();
            zzaVarZze.zzq().zza(new zze(zzaVarZze, zzaVarZze.zzm().elapsedRealtime()));
        }
    }

    @MainThread
    public final void zzb(Activity activity) throws IllegalStateException {
        if (zzt().zza(zzaq.zzcc)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long jElapsedRealtime = zzm().elapsedRealtime();
        if (zzt().zza(zzaq.zzcb) && !zzt().zzj().booleanValue()) {
            this.zzb = null;
            zzq().zza(new zzim(this, jElapsedRealtime));
        } else {
            zzij zzijVarZzd = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzq().zza(new zzip(this, zzijVarZzd, jElapsedRealtime));
        }
    }

    @MainThread
    public final void zzb(Activity activity, Bundle bundle) {
        zzij zzijVar;
        if (!zzt().zzj().booleanValue() || bundle == null || (zzijVar = (zzij) this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzijVar.zzc);
        bundle2.putString("name", zzijVar.zza);
        bundle2.putString("referrer_name", zzijVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @MainThread
    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            try {
                if (activity == this.zze) {
                    this.zze = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzt().zzj().booleanValue()) {
            this.zzd.remove(activity);
        }
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

    static /* synthetic */ zzij zza(zzii zziiVar, zzij zzijVar) {
        zziiVar.zzh = null;
        return null;
    }
}
