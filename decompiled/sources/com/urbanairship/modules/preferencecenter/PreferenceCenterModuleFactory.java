package com.urbanairship.modules.preferencecenter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.modules.Module;
import com.urbanairship.remotedata.RemoteData;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface PreferenceCenterModuleFactory extends AirshipVersionInfo {
    @NonNull
    Module build(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull PrivacyManager privacyManager, @NonNull RemoteData remoteData, @NonNull AirshipInputValidation.Validator validator);
}
