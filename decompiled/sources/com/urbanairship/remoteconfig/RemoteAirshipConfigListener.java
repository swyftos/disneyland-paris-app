package com.urbanairship.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface RemoteAirshipConfigListener {
    void onRemoteConfigUpdated(@NonNull RemoteAirshipConfig remoteAirshipConfig);
}
