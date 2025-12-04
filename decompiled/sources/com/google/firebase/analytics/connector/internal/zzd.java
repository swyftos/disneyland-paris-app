package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.contentsquare.android.core.utils.UriBuilder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* loaded from: classes4.dex */
final class zzd implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ zze zza;

    public zzd(zze zzeVar) {
        this.zza = zzeVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzha
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(UriBuilder.ANALYTICS_EVENT_ENDPOINT, zzb.zze(str2));
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
