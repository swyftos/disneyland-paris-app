package com.urbanairship.modules.location;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface AirshipLocationClient {
    boolean isBackgroundLocationAllowed();

    boolean isLocationUpdatesEnabled();

    boolean isOptIn();

    void setBackgroundLocationAllowed(boolean z);

    void setLocationUpdatesEnabled(boolean z);
}
