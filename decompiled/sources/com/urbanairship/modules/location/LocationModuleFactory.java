package com.urbanairship.modules.location;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.permission.PermissionsManager;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface LocationModuleFactory extends AirshipVersionInfo {
    @NonNull
    LocationModule build(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PermissionsManager permissionsManager);
}
