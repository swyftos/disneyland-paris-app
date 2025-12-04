package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzlr;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.Map;
import org.json.JSONException;

@DynamiteApi
/* loaded from: classes4.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzu {
    zzfy zza = null;
    private Map zzb = new ArrayMap();

    class zza implements zzha {
        private com.google.android.gms.internal.measurement.zzab zza;

        zza(com.google.android.gms.internal.measurement.zzab zzabVar) {
            this.zza = zzabVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzha
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    class zzb implements zzhb {
        private com.google.android.gms.internal.measurement.zzab zza;

        zzb(com.google.android.gms.internal.measurement.zzab zzabVar) {
            this.zza = zzabVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzhb
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzae zzaeVar, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfy zzfyVar = this.zza;
        if (zzfyVar == null) {
            this.zza = zzfy.zza(context, zzaeVar, Long.valueOf(j));
        } else {
            zzfyVar.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws IllegalStateException, SecurityException, RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setUserId(String str, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzh().zza(null, "_id", str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setMeasurementEnabled(boolean z, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void resetAnalyticsData(long j) throws IllegalStateException, RemoteException {
        zza();
        zzhc zzhcVarZzh = this.zza.zzh();
        zzhcVarZzh.zza((String) null);
        zzhcVarZzh.zzq().zza(new zzhk(zzhcVarZzh, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setMinimumSessionDuration(long j) throws IllegalStateException, RemoteException {
        zza();
        zzhc zzhcVarZzh = this.zza.zzh();
        zzhcVarZzh.zzb();
        zzhcVarZzh.zzq().zza(new zzhz(zzhcVarZzh, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setSessionTimeoutDuration(long j) throws IllegalStateException, RemoteException {
        zza();
        zzhc zzhcVarZzh = this.zza.zzh();
        zzhcVarZzh.zzb();
        zzhcVarZzh.zzq().zza(new zzhg(zzhcVarZzh, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzwVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzh().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzh().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzh().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzw zzwVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzq().zza(new zzh(this, zzwVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzh().zzal());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void generateEventId(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzwVar, this.zza.zzi().zzg());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void beginAdUnitExposure(String str, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void endAdUnitExposure(String str, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzw zzwVar, long j) throws IllegalStateException, RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", TCEventPropertiesNames.TCA_APP);
        this.zza.zzq().zza(new zzj(this, zzwVar, new zzao(str2, new zzan(bundle), TCEventPropertiesNames.TCA_APP, j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzh().zza;
        if (zzhyVar != null) {
            this.zza.zzh().zzab();
            zzhyVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzh().zza;
        if (zzhyVar != null) {
            this.zza.zzh().zzab();
            zzhyVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzh().zza;
        if (zzhyVar != null) {
            this.zza.zzh().zzab();
            zzhyVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzh().zza;
        if (zzhyVar != null) {
            this.zza.zzh().zzab();
            zzhyVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzh().zza;
        if (zzhyVar != null) {
            this.zza.zzh().zzab();
            zzhyVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzh().zza;
        if (zzhyVar != null) {
            this.zza.zzh().zzab();
            zzhyVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzw zzwVar, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzhyVar != null) {
            this.zza.zzh().zzab();
            zzhyVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzwVar.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzw zzwVar, long j) throws RemoteException {
        zza();
        zzwVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzw zzwVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzq().zza(new zzi(this, zzwVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        this.zza.zzr().zza(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzab zzabVar) throws IllegalStateException, RemoteException {
        zza();
        zzhc zzhcVarZzh = this.zza.zzh();
        zzb zzbVar = new zzb(zzabVar);
        zzhcVarZzh.zzb();
        zzhcVarZzh.zzw();
        zzhcVarZzh.zzq().zza(new zzhn(zzhcVarZzh, zzbVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzab zzabVar) throws RemoteException {
        zza();
        zzha zzaVar = (zzha) this.zzb.get(Integer.valueOf(zzabVar.zza()));
        if (zzaVar == null) {
            zzaVar = new zza(zzabVar);
            this.zzb.put(Integer.valueOf(zzabVar.zza()), zzaVar);
        }
        this.zza.zzh().zza(zzaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzab zzabVar) throws RemoteException {
        zza();
        zzha zzaVar = (zzha) this.zzb.remove(Integer.valueOf(zzabVar.zza()));
        if (zzaVar == null) {
            zzaVar = new zza(zzabVar);
        }
        this.zza.zzh().zzb(zzaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzac zzacVar) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setConditionalUserProperty(Bundle bundle, long j) throws IllegalStateException, RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzw zzwVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzq().zza(new zzl(this, zzwVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getTestFlag(com.google.android.gms.internal.measurement.zzw zzwVar, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzwVar, this.zza.zzh().zzad());
            return;
        }
        if (i == 1) {
            this.zza.zzi().zza(zzwVar, this.zza.zzh().zzae().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzi().zza(zzwVar, this.zza.zzh().zzaf().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzi().zza(zzwVar, this.zza.zzh().zzac().booleanValue());
                return;
            }
        }
        zzkr zzkrVarZzi = this.zza.zzi();
        double dDoubleValue = this.zza.zzh().zzag().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzwVar.zza(bundle);
        } catch (RemoteException e) {
            zzkrVarZzi.zzy.zzr().zzi().zza("Error returning double value to wrapper", e);
        }
    }

    private final void zza(com.google.android.gms.internal.measurement.zzw zzwVar, String str) {
        this.zza.zzi().zza(zzwVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setDataCollectionEnabled(boolean z) throws IllegalStateException, RemoteException {
        zza();
        zzhc zzhcVarZzh = this.zza.zzh();
        zzhcVarZzh.zzw();
        zzhcVarZzh.zzb();
        zzhcVarZzh.zzq().zza(new zzhx(zzhcVarZzh, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzw zzwVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzq().zza(new zzk(this, zzwVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setDefaultEventParameters(Bundle bundle) throws IllegalStateException {
        zza();
        final zzhc zzhcVarZzh = this.zza.zzh();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzhcVarZzh.zzq().zza(new Runnable(zzhcVarZzh, bundle2) { // from class: com.google.android.gms.measurement.internal.zzhf
            private final zzhc zza;
            private final Bundle zzb;

            {
                this.zza = zzhcVarZzh;
                this.zzb = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                zzhc zzhcVar = this.zza;
                Bundle bundle3 = this.zzb;
                if (zzlr.zzb() && zzhcVar.zzt().zza(zzaq.zzcm)) {
                    if (bundle3 == null) {
                        zzhcVar.zzs().zzx.zza(new Bundle());
                        return;
                    }
                    Bundle bundleZza = zzhcVar.zzs().zzx.zza();
                    for (String str : bundle3.keySet()) {
                        Object obj = bundle3.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            zzhcVar.zzp();
                            if (zzkr.zza(obj)) {
                                zzhcVar.zzp().zza(27, (String) null, (String) null, 0);
                            }
                            zzhcVar.zzr().zzk().zza("Invalid default event parameter type. Name, value", str, obj);
                        } else if (zzkr.zze(str)) {
                            zzhcVar.zzr().zzk().zza("Invalid default event parameter name. Name", str);
                        } else if (obj == null) {
                            bundleZza.remove(str);
                        } else if (zzhcVar.zzp().zza("param", str, 100, obj)) {
                            zzhcVar.zzp().zza(bundleZza, str, obj);
                        }
                    }
                    zzhcVar.zzp();
                    if (zzkr.zza(bundleZza, zzhcVar.zzt().zze())) {
                        zzhcVar.zzp().zza(26, (String) null, (String) null, 0);
                        zzhcVar.zzr().zzk().zza("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                    zzhcVar.zzs().zzx.zza(bundleZza);
                    zzhcVar.zzh().zza(bundleZza);
                }
            }
        });
    }
}
