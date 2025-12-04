package com.urbanairship.push;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationManagerCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface AirshipNotificationManager {

    public enum PromptSupport {
        NOT_SUPPORTED,
        COMPAT,
        SUPPORTED
    }

    boolean areChannelsCreated();

    boolean areNotificationsEnabled();

    @NonNull
    PromptSupport getPromptSupport();

    static AirshipNotificationManager from(@NonNull Context context) {
        final NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        final int i = context.getApplicationInfo().targetSdkVersion;
        return new AirshipNotificationManager() { // from class: com.urbanairship.push.AirshipNotificationManager.1
            @Override // com.urbanairship.push.AirshipNotificationManager
            public boolean areNotificationsEnabled() {
                return notificationManagerCompatFrom.areNotificationsEnabled();
            }

            @Override // com.urbanairship.push.AirshipNotificationManager
            public boolean areChannelsCreated() {
                return !notificationManagerCompatFrom.getNotificationChannelsCompat().isEmpty();
            }

            @Override // com.urbanairship.push.AirshipNotificationManager
            public PromptSupport getPromptSupport() {
                if (Build.VERSION.SDK_INT >= 33) {
                    if (i >= 33) {
                        return PromptSupport.SUPPORTED;
                    }
                    return PromptSupport.COMPAT;
                }
                return PromptSupport.NOT_SUPPORTED;
            }
        };
    }
}
