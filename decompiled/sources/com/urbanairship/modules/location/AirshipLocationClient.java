package com.urbanairship.modules.location;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface AirshipLocationClient {
    boolean isBackgroundLocationAllowed();

    boolean isLocationUpdatesEnabled();

    boolean isOptIn();

    void setBackgroundLocationAllowed(boolean z);

    void setLocationUpdatesEnabled(boolean z);
}
