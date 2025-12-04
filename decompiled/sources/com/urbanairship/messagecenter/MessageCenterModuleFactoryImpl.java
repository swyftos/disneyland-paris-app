package com.urbanairship.messagecenter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.messagecenter.MessageCenterModuleFactory;
import com.urbanairship.push.PushManager;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class MessageCenterModuleFactoryImpl implements MessageCenterModuleFactory {
    @Override // com.urbanairship.modules.messagecenter.MessageCenterModuleFactory
    @NonNull
    public Module build(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PushManager pushManager) {
        return Module.singleComponent(new MessageCenter(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, airshipChannel, pushManager), R.xml.ua_message_center_actions);
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NonNull
    public String getAirshipVersion() {
        return "19.9.1";
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NonNull
    public String getPackageVersion() {
        return BuildConfig.SDK_VERSION;
    }
}
