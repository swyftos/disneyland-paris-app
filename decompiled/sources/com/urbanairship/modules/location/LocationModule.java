package com.urbanairship.modules.location;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipComponent;
import com.urbanairship.modules.Module;
import java.util.Collections;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class LocationModule extends Module {
    private final AirshipLocationClient locationClient;

    public LocationModule(@NonNull AirshipComponent airshipComponent, @NonNull AirshipLocationClient airshipLocationClient) {
        super(Collections.singleton(airshipComponent));
        this.locationClient = airshipLocationClient;
    }

    @NonNull
    public AirshipLocationClient getLocationClient() {
        return this.locationClient;
    }
}
