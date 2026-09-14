package com.urbanairship.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface RemoteAirshipConfigListener {
    void onRemoteConfigUpdated(@NonNull RemoteAirshipConfig remoteAirshipConfig);
}
