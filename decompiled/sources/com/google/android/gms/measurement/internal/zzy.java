package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmd;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class zzy extends zzgs {
    private Boolean zza;
    private zzaa zzb;
    private Boolean zzc;

    zzy(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzb = zzab.zza;
    }

    final void zza(zzaa zzaaVar) {
        this.zzb = zzaaVar;
    }

    public final int zze() {
        return (com.google.android.gms.internal.measurement.zzjq.zzb() && zzt().zzd(null, zzaq.zzck) && zzp().zzj() >= 201500) ? 100 : 25;
    }

    public final int zza(@Size(min = 1) String str) {
        return zza(str, zzaq.zzah, 25, 100);
    }

    final int zzb(String str) {
        if (com.google.android.gms.internal.measurement.zzjq.zzb() && zzd(null, zzaq.zzcj)) {
            return zza(str, zzaq.zzag, 500, 2000);
        }
        return 500;
    }

    @WorkerThread
    public final int zzc(@Size(min = 1) String str) {
        return zzb(str, zzaq.zzn);
    }

    final int zzd(String str) {
        if (com.google.android.gms.internal.measurement.zzjq.zzb() && zzd(null, zzaq.zzcj)) {
            return zza(str, zzaq.zzaf, 25, 100);
        }
        return 25;
    }

    public final long zzf() {
        zzu();
        return 29000L;
    }

    public final boolean zzg() {
        if (this.zzc == null) {
            synchronized (this) {
                try {
                    if (this.zzc == null) {
                        ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                        }
                        if (this.zzc == null) {
                            this.zzc = Boolean.TRUE;
                            zzr().zzf().zza("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.zzc.booleanValue();
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzen<Long> zzenVar) {
        if (str == null) {
            return zzenVar.zza(null).longValue();
        }
        String strZza = this.zzb.zza(str, zzenVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzenVar.zza(null).longValue();
        }
        try {
            return zzenVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzenVar.zza(null).longValue();
        }
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzen<Integer> zzenVar) {
        if (str == null) {
            return zzenVar.zza(null).intValue();
        }
        String strZza = this.zzb.zza(str, zzenVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzenVar.zza(null).intValue();
        }
        try {
            return zzenVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzenVar.zza(null).intValue();
        }
    }

    private final int zza(String str, zzen zzenVar, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzenVar), i2), i);
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzen<Double> zzenVar) {
        if (str == null) {
            return zzenVar.zza(null).doubleValue();
        }
        String strZza = this.zzb.zza(str, zzenVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzenVar.zza(null).doubleValue();
        }
        try {
            return zzenVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzenVar.zza(null).doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzen<Boolean> zzenVar) {
        if (str == null) {
            return zzenVar.zza(null).booleanValue();
        }
        String strZza = this.zzb.zza(str, zzenVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzenVar.zza(null).booleanValue();
        }
        return zzenVar.zza(Boolean.valueOf(Boolean.parseBoolean(strZza))).booleanValue();
    }

    public final boolean zze(String str, zzen<Boolean> zzenVar) {
        return zzd(str, zzenVar);
    }

    public final boolean zza(zzen<Boolean> zzenVar) {
        return zzd(null, zzenVar);
    }

    private final Bundle zzz() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo == null) {
                zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    final Boolean zze(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzz = zzz();
        if (bundleZzz == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzz.containsKey(str)) {
            return Boolean.valueOf(bundleZzz.getBoolean(str));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List zzf(java.lang.String r4) throws android.content.res.Resources.NotFoundException {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzz()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.zzeu r4 = r3.zzr()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzf()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.zzn()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r3 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r3
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()
            java.lang.String r0 = "Failed to load string array from metadata: resource not found"
            r3.zza(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzf(java.lang.String):java.util.List");
    }

    public final boolean zzh() {
        zzu();
        Boolean boolZze = zze("firebase_analytics_collection_deactivated");
        return boolZze != null && boolZze.booleanValue();
    }

    public final Boolean zzi() {
        zzb();
        Boolean boolZze = zze("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(boolZze == null || boolZze.booleanValue());
    }

    public final Boolean zzj() {
        zzb();
        if (!zzmd.zzb() || !zza(zzaq.zzcb)) {
            return Boolean.TRUE;
        }
        Boolean boolZze = zze("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(boolZze == null || boolZze.booleanValue());
    }

    public static long zzk() {
        return zzaq.zzac.zza(null).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.zzf r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.zze()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = com.google.android.gms.internal.measurement.zzlm.zzb()
            if (r1 == 0) goto L2f
            com.google.android.gms.measurement.internal.zzy r1 = r5.zzt()
            java.lang.String r2 = r6.zzc()
            com.google.android.gms.measurement.internal.zzen<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzbn
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.zzg()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.zzf()
        L33:
            com.google.android.gms.measurement.internal.zzen<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzaq.zzd
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzen<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzaq.zze
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            java.lang.String r4 = "config/app/"
            if (r3 == 0) goto L5d
            java.lang.String r1 = r4.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r2 = "app_instance_id"
            java.lang.String r6 = r6.zzd()
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.zzf()
            java.lang.String r5 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "gmp_version"
            r6.appendQueryParameter(r1, r5)
            android.net.Uri r5 = r0.build()
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zza(com.google.android.gms.measurement.internal.zzf):java.lang.String");
    }

    public static long zzv() {
        return zzaq.zzc.zza(null).longValue();
    }

    public final String zzw() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzx() {
        return zza("debug.deferred.deeplink", "");
    }

    private final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            zzr().zzf().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            zzr().zzf().zza("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzr().zzf().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzr().zzf().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final boolean zzg(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzh(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzi(String str) {
        return zzd(str, zzaq.zzaj);
    }

    final String zzj(String str) {
        zzen<String> zzenVar = zzaq.zzak;
        if (str == null) {
            return zzenVar.zza(null);
        }
        return zzenVar.zza(this.zzb.zza(str, zzenVar.zza()));
    }

    final boolean zzy() {
        if (this.zza == null) {
            Boolean boolZze = zze("app_measurement_lite");
            this.zza = boolZze;
            if (boolZze == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !this.zzy.zzt();
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
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
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
}
