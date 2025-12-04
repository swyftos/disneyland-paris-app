package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class zzag {
    private static volatile zzag zzb = null;
    private static Boolean zzh = null;
    private static String zzi = "allow_remote_dynamite";
    protected final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private List zzf;
    private int zzg;
    private boolean zzk;
    private String zzl;
    private zzv zzm;

    class zzc implements Application.ActivityLifecycleCallbacks {
        zzc() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzag.this.zza(new zzbn(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzag.this.zza(new zzbm(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzag.this.zza(new zzbp(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzag.this.zza(new zzbo(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzag.this.zza(new zzbr(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzt zztVar = new zzt();
            zzag.this.zza(new zzbq(this, activity, zztVar));
            Bundle bundleZzb = zztVar.zzb(50L);
            if (bundleZzb != null) {
                bundle.putAll(bundleZzb);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzag.this.zza(new zzbs(this, activity));
        }
    }

    public static zzag zza(@NonNull Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    private static boolean zzk() {
        return true;
    }

    abstract class zzb implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zzb(zzag zzagVar) {
            this(true);
        }

        abstract void zza();

        protected void zzb() {
        }

        zzb(boolean z) {
            this.zza = zzag.this.zza.currentTimeMillis();
            this.zzb = zzag.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzag.this.zzk) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzag.this.zza(e, false, this.zzc);
                zzb();
            }
        }
    }

    public static zzag zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzag.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzag(context, str, str2, str3, bundle);
                    }
                } finally {
                }
            }
        }
        return zzb;
    }

    static class zza extends zzaa {
        private final com.google.android.gms.measurement.internal.zzhb zza;

        zza(com.google.android.gms.measurement.internal.zzhb zzhbVar) {
            this.zza = zzhbVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    static class zzd extends zzaa {
        private final com.google.android.gms.measurement.internal.zzha zza;

        zzd(com.google.android.gms.measurement.internal.zzha zzhaVar) {
            this.zza = zzhaVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    public final AppMeasurementSdk zza() {
        return this.zze;
    }

    private zzag(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzi.zza().zza(new zzas(this), zzr.zza);
        this.zze = new AppMeasurementSdk(this);
        if (zze(context) && !zzk()) {
            this.zzl = null;
            this.zzk = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzl = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzl = str2;
        }
        zza(new zzaj(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    private static boolean zze(Context context) {
        return new StringResourceValueReader(context).getString("google_app_id") != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        this.zzd.execute(zzbVar);
    }

    protected final zzv zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        try {
            if (z) {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } else {
                versionPolicy = DynamiteModule.PREFER_LOCAL;
            }
            return zzu.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            this.zza((Exception) e, true, false);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzf(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzg(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzk |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    public final void zza(com.google.android.gms.measurement.internal.zzhb zzhbVar) {
        zza(new zzbf(this, zzhbVar));
    }

    public final void zza(com.google.android.gms.measurement.internal.zzha zzhaVar) {
        Preconditions.checkNotNull(zzhaVar);
        zza(new zzbj(this, zzhaVar));
    }

    public final void zzb(com.google.android.gms.measurement.internal.zzha zzhaVar) {
        Preconditions.checkNotNull(zzhaVar);
        zza(new zzbi(this, zzhaVar));
    }

    public final void zza(@NonNull String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new zzbl(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zza(new zzbk(this, str, str2, obj, z));
    }

    public final void zza(Bundle bundle) {
        zza(new zzai(this, bundle));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(new zzal(this, str, str2, bundle));
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzt zztVar = new zzt();
        zza(new zzak(this, str, str2, zztVar));
        List<Bundle> list = (List) zzt.zza(zztVar.zzb(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zza(String str) {
        zza(new zzan(this, str));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza(new zzam(this, activity, str, str2));
    }

    public final void zza(boolean z) {
        zza(new zzap(this, z));
    }

    public final void zzb() {
        zza(new zzao(this));
    }

    public final void zza(long j) {
        zza(new zzar(this, j));
    }

    public final void zzb(long j) {
        zza(new zzaq(this, j));
    }

    public final void zzb(String str) {
        zza(new zzat(this, str));
    }

    public final void zzc(String str) {
        zza(new zzav(this, str));
    }

    public final String zzc() {
        zzt zztVar = new zzt();
        zza(new zzau(this, zztVar));
        return zztVar.zza(500L);
    }

    public final String zzd() {
        zzt zztVar = new zzt();
        zza(new zzax(this, zztVar));
        return zztVar.zza(50L);
    }

    public final long zze() {
        zzt zztVar = new zzt();
        zza(new zzaw(this, zztVar));
        Long l = (Long) zzt.zza(zztVar.zzb(500L), Long.class);
        if (l == null) {
            long jNextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i = this.zzg + 1;
            this.zzg = i;
            return jNextLong + i;
        }
        return l.longValue();
    }

    public final String zzf() {
        zzt zztVar = new zzt();
        zza(new zzaz(this, zztVar));
        return zztVar.zza(500L);
    }

    public final String zzg() {
        zzt zztVar = new zzt();
        zza(new zzay(this, zztVar));
        return zztVar.zza(500L);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzt zztVar = new zzt();
        zza(new zzbb(this, str, str2, z, zztVar));
        Bundle bundleZzb = zztVar.zzb(5000L);
        if (bundleZzb == null || bundleZzb.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleZzb.size());
        for (String str3 : bundleZzb.keySet()) {
            Object obj = bundleZzb.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzba(this, false, 5, str, obj, null, null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzt zztVar = new zzt();
        zza(new zzbd(this, bundle, zztVar));
        if (z) {
            return zztVar.zzb(5000L);
        }
        return null;
    }

    public final int zzd(String str) {
        zzt zztVar = new zzt();
        zza(new zzbc(this, str, zztVar));
        Integer num = (Integer) zzt.zza(zztVar.zzb(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @WorkerThread
    public final String zzh() {
        zzt zztVar = new zzt();
        zza(new zzbe(this, zztVar));
        return zztVar.zza(120000L);
    }

    public final String zzi() {
        return this.zzl;
    }

    public final Object zza(int i) {
        zzt zztVar = new zzt();
        zza(new zzbh(this, zztVar, i));
        return zzt.zza(zztVar.zzb(15000L), Object.class);
    }

    public final void zzb(boolean z) {
        zza(new zzbg(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzh(Context context) {
        synchronized (zzag.class) {
            try {
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzh = Boolean.FALSE;
            }
            if (zzh != null) {
                return;
            }
            if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                zzh = Boolean.FALSE;
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
            zzh = Boolean.valueOf(sharedPreferences.getBoolean(zzi, false));
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(zzi);
            editorEdit.apply();
        }
    }

    private static boolean zza(Context context, String str) {
        Bundle bundle;
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
