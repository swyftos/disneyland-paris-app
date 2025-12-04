package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.camera.video.AudioStats;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zzfy implements zzgu {
    private static volatile zzfy zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private int zzaf;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzx zzh;
    private final zzy zzi;
    private final zzfg zzj;
    private final zzeu zzk;
    private final zzfv zzl;
    private final zzjv zzm;
    private final zzkr zzn;
    private final zzes zzo;
    private final Clock zzp;
    private final zzii zzq;
    private final zzhc zzr;
    private final zza zzs;
    private final zzid zzt;
    private zzeq zzu;
    private zzir zzv;
    private zzai zzw;
    private zzer zzx;
    private zzfp zzy;
    private boolean zzz = false;
    private AtomicInteger zzag = new AtomicInteger(0);

    private zzfy(zzhd zzhdVar) throws IllegalStateException {
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzhdVar);
        zzx zzxVar = new zzx(zzhdVar.zza);
        this.zzh = zzxVar;
        zzek.zza = zzxVar;
        Context context = zzhdVar.zza;
        this.zzc = context;
        this.zzd = zzhdVar.zzb;
        this.zze = zzhdVar.zzc;
        this.zzf = zzhdVar.zzd;
        this.zzg = zzhdVar.zzh;
        this.zzac = zzhdVar.zze;
        com.google.android.gms.internal.measurement.zzae zzaeVar = zzhdVar.zzg;
        if (zzaeVar != null && (bundle = zzaeVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzaeVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzcv.zza(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        Long l = zzhdVar.zzi;
        this.zza = l != null ? l.longValue() : defaultClock.currentTimeMillis();
        this.zzi = new zzy(this);
        zzfg zzfgVar = new zzfg(this);
        zzfgVar.zzab();
        this.zzj = zzfgVar;
        zzeu zzeuVar = new zzeu(this);
        zzeuVar.zzab();
        this.zzk = zzeuVar;
        zzkr zzkrVar = new zzkr(this);
        zzkrVar.zzab();
        this.zzn = zzkrVar;
        zzes zzesVar = new zzes(this);
        zzesVar.zzab();
        this.zzo = zzesVar;
        this.zzs = new zza(this);
        zzii zziiVar = new zzii(this);
        zziiVar.zzx();
        this.zzq = zziiVar;
        zzhc zzhcVar = new zzhc(this);
        zzhcVar.zzx();
        this.zzr = zzhcVar;
        zzjv zzjvVar = new zzjv(this);
        zzjvVar.zzx();
        this.zzm = zzjvVar;
        zzid zzidVar = new zzid(this);
        zzidVar.zzab();
        this.zzt = zzidVar;
        zzfv zzfvVar = new zzfv(this);
        zzfvVar.zzab();
        this.zzl = zzfvVar;
        com.google.android.gms.internal.measurement.zzae zzaeVar2 = zzhdVar.zzg;
        if (zzaeVar2 != null && zzaeVar2.zzb != 0) {
            z = true;
        }
        if (context.getApplicationContext() instanceof Application) {
            zzhc zzhcVarZzh = zzh();
            if (zzhcVarZzh.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzhcVarZzh.zzn().getApplicationContext();
                if (zzhcVarZzh.zza == null) {
                    zzhcVarZzh.zza = new zzhy(zzhcVarZzh, null);
                }
                if (!z) {
                    application.unregisterActivityLifecycleCallbacks(zzhcVarZzh.zza);
                    application.registerActivityLifecycleCallbacks(zzhcVarZzh.zza);
                    zzhcVarZzh.zzr().zzx().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzr().zzi().zza("Application context is not an Application");
        }
        zzfvVar.zza(new zzga(this, zzhdVar));
    }

    final void zzad() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzhd zzhdVar) {
        String strConcat;
        zzew zzewVarZzv;
        zzq().zzd();
        zzai zzaiVar = new zzai(this);
        zzaiVar.zzab();
        this.zzw = zzaiVar;
        zzer zzerVar = new zzer(this, zzhdVar.zzf);
        zzerVar.zzx();
        this.zzx = zzerVar;
        zzeq zzeqVar = new zzeq(this);
        zzeqVar.zzx();
        this.zzu = zzeqVar;
        zzir zzirVar = new zzir(this);
        zzirVar.zzx();
        this.zzv = zzirVar;
        this.zzn.zzac();
        this.zzj.zzac();
        this.zzy = new zzfp(this);
        this.zzx.zzy();
        zzr().zzv().zza("App measurement initialized, version", Long.valueOf(this.zzi.zzf()));
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzab = zzerVar.zzab();
        if (TextUtils.isEmpty(this.zzd)) {
            if (zzi().zzf(strZzab)) {
                zzewVarZzv = zzr().zzv();
                strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzew zzewVarZzv2 = zzr().zzv();
                String strValueOf = String.valueOf(strZzab);
                strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzewVarZzv = zzewVarZzv2;
            }
            zzewVarZzv.zza(strConcat);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzaf != this.zzag.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzaf), Integer.valueOf(this.zzag.get()));
        }
        this.zzz = true;
    }

    @WorkerThread
    protected final void zza() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzp.currentTimeMillis());
        }
        if (zzc().zzh.zza() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zza));
            zzc().zzh.zza(this.zza);
        }
        if (this.zzi.zza(zzaq.zzcq)) {
            zzh().zzb.zzb();
        }
        if (!zzag()) {
            if (zzab()) {
                if (!zzi().zzd("android.permission.INTERNET")) {
                    zzr().zzf().zza("App is missing INTERNET permission");
                }
                if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                    zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!Wrappers.packageManager(this.zzc).isCallerInstantApp() && !this.zzi.zzy()) {
                    if (!zzfq.zza(this.zzc)) {
                        zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzkr.zza(this.zzc, false)) {
                        zzr().zzf().zza("AppMeasurementService not registered/enabled");
                    }
                }
                zzr().zzf().zza("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzkr.zza(zzy().zzac(), zzc().zzh(), zzy().zzad(), zzc().zzi())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzk();
                    zzk().zzab();
                    this.zzv.zzah();
                    this.zzv.zzaf();
                    zzc().zzh.zza(this.zza);
                    zzc().zzj.zza(null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            if (com.google.android.gms.internal.measurement.zzkh.zzb() && this.zzi.zza(zzaq.zzbu) && !zzi().zzv() && !TextUtils.isEmpty(zzc().zzu.zza())) {
                zzr().zzi().zza("Remote config removed with active feature rollouts");
                zzc().zzu.zza(null);
            }
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zZzab = zzab();
                if (!zzc().zzx() && !this.zzi.zzh()) {
                    zzc().zzc(!zZzab);
                }
                if (zZzab) {
                    zzh().zzai();
                }
                zze().zza.zza();
                zzw().zza(new AtomicReference<>());
                if (zzlr.zzb() && this.zzi.zza(zzaq.zzcm)) {
                    zzw().zza(zzc().zzx.zza());
                }
            }
        }
        zzc().zzo.zza(this.zzi.zza(zzaq.zzaz));
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzx zzu() {
        return this.zzh;
    }

    public final zzy zzb() {
        return this.zzi;
    }

    public final zzfg zzc() {
        zza((zzgs) this.zzj);
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzeu zzr() {
        zzb(this.zzk);
        return this.zzk;
    }

    public final zzeu zzd() {
        zzeu zzeuVar = this.zzk;
        if (zzeuVar == null || !zzeuVar.zzz()) {
            return null;
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzfv zzq() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzjv zze() {
        zzb(this.zzm);
        return this.zzm;
    }

    public final zzfp zzf() {
        return this.zzy;
    }

    final zzfv zzg() {
        return this.zzl;
    }

    public final zzhc zzh() {
        zzb(this.zzr);
        return this.zzr;
    }

    public final zzkr zzi() {
        zza((zzgs) this.zzn);
        return this.zzn;
    }

    public final zzes zzj() {
        zza((zzgs) this.zzo);
        return this.zzo;
    }

    public final zzeq zzk() {
        zzb(this.zzu);
        return this.zzu;
    }

    private final zzid zzai() {
        zzb(this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final Context zzn() {
        return this.zzc;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzd);
    }

    public final String zzo() {
        return this.zzd;
    }

    public final String zzp() {
        return this.zze;
    }

    public final String zzs() {
        return this.zzf;
    }

    public final boolean zzt() {
        return this.zzg;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final Clock zzm() {
        return this.zzp;
    }

    public final zzii zzv() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzir zzw() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzai zzx() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzer zzy() {
        zzb(this.zzx);
        return this.zzx;
    }

    public final zza zzz() {
        zza zzaVar = this.zzs;
        if (zzaVar != null) {
            return zzaVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzfy zza(Context context, com.google.android.gms.internal.measurement.zzae zzaeVar, Long l) {
        Bundle bundle;
        if (zzaeVar != null && (zzaeVar.zze == null || zzaeVar.zzf == null)) {
            zzaeVar = new com.google.android.gms.internal.measurement.zzae(zzaeVar.zza, zzaeVar.zzb, zzaeVar.zzc, zzaeVar.zzd, null, null, zzaeVar.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzfy.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzfy(new zzhd(context, zzaeVar, l));
                    }
                } finally {
                }
            }
        } else if (zzaeVar != null && (bundle = zzaeVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            zzb.zza(zzaeVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzb;
    }

    private static void zzb(zzgv zzgvVar) {
        if (zzgvVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzgvVar.zzz()) {
            return;
        }
        String strValueOf = String.valueOf(zzgvVar.getClass());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void zzb(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzgVar.zzv()) {
            return;
        }
        String strValueOf = String.valueOf(zzgVar.getClass());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void zza(zzgs zzgsVar) {
        if (zzgsVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    @WorkerThread
    public final boolean zzaa() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    @WorkerThread
    public final boolean zzab() {
        return zzac() == 0;
    }

    @WorkerThread
    public final int zzac() {
        zzq().zzd();
        if (this.zzi.zzh()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean boolZzv = zzc().zzv();
        if (boolZzv != null) {
            return boolZzv.booleanValue() ? 0 : 3;
        }
        zzy zzyVar = this.zzi;
        zzyVar.zzu();
        Boolean boolZze = zzyVar.zze("firebase_analytics_collection_enabled");
        if (boolZze != null) {
            return boolZze.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzad;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return 6;
        }
        return (!this.zzi.zza(zzaq.zzas) || this.zzac == null || this.zzac.booleanValue()) ? 0 : 7;
    }

    final void zzae() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zza(zzgv zzgvVar) {
        this.zzaf++;
    }

    final void zza(zzg zzgVar) {
        this.zzaf++;
    }

    final void zzaf() {
        this.zzag.incrementAndGet();
    }

    @WorkerThread
    protected final boolean zzag() {
        if (!this.zzz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzq().zzd();
        Boolean bool = this.zzaa;
        if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
            this.zzab = this.zzp.elapsedRealtime();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzy() || (zzfq.zza(this.zzc) && zzkr.zza(this.zzc, false))));
            this.zzaa = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!zzi().zza(zzy().zzac(), zzy().zzad(), zzy().zzae()) && TextUtils.isEmpty(zzy().zzad())) {
                    z = false;
                }
                this.zzaa = Boolean.valueOf(z);
            }
        }
        return this.zzaa.booleanValue();
    }

    @WorkerThread
    public final void zzah() throws IllegalStateException {
        zzq().zzd();
        zzb(zzai());
        String strZzab = zzy().zzab();
        Pair pairZza = zzc().zza(strZzab);
        if (!this.zzi.zzi().booleanValue() || ((Boolean) pairZza.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZza.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!zzai().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        URL urlZza = zzi().zza(zzy().zzt().zzf(), strZzab, (String) pairZza.first, zzc().zzt.zza() - 1);
        zzid zzidVarZzai = zzai();
        zzic zzicVar = new zzic(this) { // from class: com.google.android.gms.measurement.internal.zzgb
            private final zzfy zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.measurement.internal.zzic
            public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zza(str, i, th, bArr, map);
            }
        };
        zzidVarZzai.zzd();
        zzidVarZzai.zzaa();
        Preconditions.checkNotNull(urlZza);
        Preconditions.checkNotNull(zzicVar);
        zzidVarZzai.zzq().zzb(new zzif(zzidVarZzai, strZzab, urlZza, null, null, zzicVar));
    }

    final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> listQueryIntentActivities;
        if ((i != 200 && i != 204 && i != 304) || th != null) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzs.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString("deeplink", "");
            String strOptString2 = jSONObject.optString("gclid", "");
            double dOptDouble = jSONObject.optDouble("timestamp", AudioStats.AUDIO_AMPLITUDE_NONE);
            if (TextUtils.isEmpty(strOptString)) {
                zzr().zzw().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkr zzkrVarZzi = zzi();
            zzkrVarZzi.zzb();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = zzkrVarZzi.zzn().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
            zzkr zzkrVarZzi2 = zzi();
            if (TextUtils.isEmpty(strOptString) || !zzkrVarZzi2.zza(strOptString, dOptDouble)) {
                return;
            }
            zzkrVarZzi2.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
