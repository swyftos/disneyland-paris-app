package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import ch.qos.logback.core.spi.ComponentTracker;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes4.dex */
final class zzfg extends zzgv {
    static final Pair zza = new Pair("", 0L);
    private String zzaa;
    private boolean zzab;
    private long zzac;
    public zzfn zzb;
    public final zzfk zzc;
    public final zzfk zzd;
    public final zzfk zze;
    public final zzfk zzf;
    public final zzfk zzg;
    public final zzfk zzh;
    public final zzfk zzi;
    public final zzfm zzj;
    public final zzfk zzk;
    public final zzfk zzl;
    public final zzfi zzm;
    public final zzfm zzn;
    public final zzfi zzo;
    public final zzfk zzp;
    public boolean zzq;
    public zzfi zzr;
    public zzfi zzs;
    public zzfk zzt;
    public final zzfm zzu;
    public final zzfm zzv;
    public final zzfk zzw;
    public final zzfl zzx;
    private SharedPreferences zzz;

    final Pair zza(String str) {
        zzd();
        long jElapsedRealtime = zzm().elapsedRealtime();
        if (this.zzaa != null && jElapsedRealtime < this.zzac) {
            return new Pair(this.zzaa, Boolean.valueOf(this.zzab));
        }
        this.zzac = jElapsedRealtime + zzt().zza(str, zzaq.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzaa = advertisingIdInfo.getId();
                this.zzab = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzaa == null) {
                this.zzaa = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzaa = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.zzaa, Boolean.valueOf(this.zzab));
    }

    @Override // com.google.android.gms.measurement.internal.zzgv
    protected final boolean zze() {
        return true;
    }

    final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest messageDigestZzi = zzkr.zzi();
        if (messageDigestZzi == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzi.digest(str2.getBytes())));
    }

    zzfg(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzc = new zzfk(this, "last_upload", 0L);
        this.zzd = new zzfk(this, "last_upload_attempt", 0L);
        this.zze = new zzfk(this, "backoff", 0L);
        this.zzf = new zzfk(this, "last_delete_stale", 0L);
        this.zzk = new zzfk(this, "time_before_start", 10000L);
        this.zzl = new zzfk(this, "session_timeout", ComponentTracker.DEFAULT_TIMEOUT);
        this.zzm = new zzfi(this, "start_new_session", true);
        this.zzp = new zzfk(this, "last_pause_time", 0L);
        this.zzn = new zzfm(this, "non_personalized_ads", null);
        this.zzo = new zzfi(this, "allow_remote_dynamite", false);
        this.zzg = new zzfk(this, "midnight_offset", 0L);
        this.zzh = new zzfk(this, "first_open_time", 0L);
        this.zzi = new zzfk(this, "app_install_time", 0L);
        this.zzj = new zzfm(this, "app_instance_id", null);
        this.zzr = new zzfi(this, "app_backgrounded", false);
        this.zzs = new zzfi(this, "deep_link_retrieval_complete", false);
        this.zzt = new zzfk(this, "deep_link_retrieval_attempts", 0L);
        this.zzu = new zzfm(this, "firebase_feature_rollouts", null);
        this.zzv = new zzfm(this, "deferred_attribution_cache", null);
        this.zzw = new zzfk(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzx = new zzfl(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzgv
    protected final void f_() {
        SharedPreferences sharedPreferences = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzz = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzq = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.zzz.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.zzb = new zzfn(this, "health_monitor", Math.max(0L, zzaq.zzb.zza(null).longValue()));
    }

    protected final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzz;
    }

    final void zzc(String str) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", null);
    }

    final void zzd(String str) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", null);
    }

    final Boolean zzj() {
        zzd();
        if (zzg().contains("use_service")) {
            return Boolean.valueOf(zzg().getBoolean("use_service", false));
        }
        return null;
    }

    final void zza(boolean z) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    final void zzk() {
        zzd();
        Boolean boolZzv = zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolZzv != null) {
            zzb(boolZzv.booleanValue());
        }
    }

    final void zzb(boolean z) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("measurement_enabled", z);
        editorEdit.apply();
    }

    final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    protected final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = zzg().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    final boolean zzx() {
        return this.zzz.contains("deferred_analytics_collection");
    }

    final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzp.zza();
    }
}
