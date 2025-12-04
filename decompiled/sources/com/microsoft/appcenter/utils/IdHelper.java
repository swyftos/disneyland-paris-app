package com.microsoft.appcenter.utils;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.UUID;

/* loaded from: classes4.dex */
public class IdHelper {
    @NonNull
    public static UUID getInstallId() {
        try {
            return UUID.fromString(SharedPreferencesManager.getString(PrefStorageConstants.KEY_INSTALL_ID, ""));
        } catch (Exception unused) {
            AppCenterLog.warn("AppCenter", "Unable to get installID from Shared Preferences");
            UUID uuidRandomUUID = UUID.randomUUID();
            SharedPreferencesManager.putString(PrefStorageConstants.KEY_INSTALL_ID, uuidRandomUUID.toString());
            return uuidRandomUUID;
        }
    }
}
