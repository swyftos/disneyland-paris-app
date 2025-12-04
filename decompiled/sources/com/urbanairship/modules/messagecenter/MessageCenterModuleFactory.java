package com.urbanairship.modules.messagecenter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.modules.Module;
import com.urbanairship.push.PushManager;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface MessageCenterModuleFactory extends AirshipVersionInfo {
    @NonNull
    Module build(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PushManager pushManager);
}
