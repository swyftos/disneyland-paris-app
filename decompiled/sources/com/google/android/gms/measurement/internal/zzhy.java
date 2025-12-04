package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;

/* loaded from: classes4.dex */
final class zzhy implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhc zza;

    private zzhy(zzhc zzhcVar) {
        this.zza = zzhcVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        try {
            try {
                this.zza.zzr().zzx().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    this.zza.zzi().zza(activity, bundle);
                    return;
                }
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    this.zza.zzp();
                    if (zzkr.zza(intent)) {
                        str = "gs";
                    } else {
                        str = "auto";
                    }
                    this.zza.zzq().zza(new zzib(this, bundle == null, data, str, data.getQueryParameter(TCEventPropertiesNames.TCE_REFERRER)));
                    this.zza.zzi().zza(activity, bundle);
                }
            } catch (Exception e) {
                this.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e);
                this.zza.zzi().zza(activity, bundle);
            }
        } finally {
            this.zza.zzi().zza(activity, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(boolean z, Uri uri, String str, String str2) {
        Bundle bundleZza;
        Bundle bundleZza2;
        this.zza.zzd();
        try {
            if (this.zza.zzt().zza(zzaq.zzbh) || this.zza.zzt().zza(zzaq.zzbj) || this.zza.zzt().zza(zzaq.zzbi)) {
                zzkr zzkrVarZzp = this.zza.zzp();
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.contains("gclid") && !str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium")) {
                        zzkrVarZzp.zzr().zzw().zza("Activity created with data 'referrer' without required params");
                    } else {
                        bundleZza = zzkrVarZzp.zza(Uri.parse(str2.length() != 0 ? "https://google.com/search?".concat(str2) : new String("https://google.com/search?")));
                        if (bundleZza != null) {
                            bundleZza.putString("_cis", TCEventPropertiesNames.TCE_REFERRER);
                        }
                    }
                }
                bundleZza = null;
            } else {
                bundleZza = null;
            }
            if (z) {
                bundleZza2 = this.zza.zzp().zza(uri);
                if (bundleZza2 != null) {
                    bundleZza2.putString("_cis", "intent");
                    if (this.zza.zzt().zza(zzaq.zzbh) && !bundleZza2.containsKey("gclid") && bundleZza != null && bundleZza.containsKey("gclid")) {
                        bundleZza2.putString("_cer", String.format("gclid=%s", bundleZza.getString("gclid")));
                    }
                    this.zza.zza(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza2);
                    if (this.zza.zzt().zza(zzaq.zzcq)) {
                        this.zza.zzb.zza(str, bundleZza2);
                    }
                }
            } else {
                bundleZza2 = null;
            }
            if (this.zza.zzt().zza(zzaq.zzbj) && !this.zza.zzt().zza(zzaq.zzbi) && bundleZza != null && bundleZza.containsKey("gclid") && (bundleZza2 == null || !bundleZza2.containsKey("gclid"))) {
                this.zza.zza("auto", "_lgclid", (Object) bundleZza.getString("gclid"), true);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.zza.zzr().zzw().zza("Activity created with referrer", str2);
            if (this.zza.zzt().zza(zzaq.zzbi)) {
                if (bundleZza != null) {
                    this.zza.zza(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza);
                    if (this.zza.zzt().zza(zzaq.zzcq)) {
                        this.zza.zzb.zza(str, bundleZza);
                    }
                } else {
                    this.zza.zzr().zzw().zza("Referrer does not contain valid parameters", str2);
                }
                this.zza.zza("auto", "_ldl", (Object) null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                this.zza.zzr().zzw().zza("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.zza.zza("auto", "_ldl", (Object) str2, true);
            }
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) throws IllegalStateException {
        this.zza.zzi().zzb(activity);
        zzjv zzjvVarZzk = this.zza.zzk();
        zzjvVarZzk.zzq().zza(new zzjx(zzjvVarZzk, zzjvVarZzk.zzm().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) throws IllegalStateException {
        zzjv zzjvVarZzk = this.zza.zzk();
        zzjvVarZzk.zzq().zza(new zzju(zzjvVarZzk, zzjvVarZzk.zzm().elapsedRealtime()));
        this.zza.zzi().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    /* synthetic */ zzhy(zzhc zzhcVar, zzhh zzhhVar) {
        this(zzhcVar);
    }
}
