package com.urbanairship.push;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.RemoteInput;
import ch.qos.logback.core.CoreConstants;

/* loaded from: classes5.dex */
public class NotificationActionButtonInfo {
    private final String buttonId;
    private final String description;
    private final boolean isForeground;
    private final Bundle remoteInput;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public NotificationActionButtonInfo(@NonNull String str, boolean z, @Nullable Bundle bundle, @Nullable String str2) {
        this.buttonId = str;
        this.isForeground = z;
        this.remoteInput = bundle;
        this.description = str2;
    }

    static NotificationActionButtonInfo fromIntent(Intent intent) {
        String stringExtra = intent.getStringExtra(PushManager.EXTRA_NOTIFICATION_BUTTON_ID);
        if (stringExtra == null) {
            return null;
        }
        return new NotificationActionButtonInfo(stringExtra, intent.getBooleanExtra(PushManager.EXTRA_NOTIFICATION_BUTTON_FOREGROUND, true), RemoteInput.getResultsFromIntent(intent), intent.getStringExtra(PushManager.EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION));
    }

    @NonNull
    public String getButtonId() {
        return this.buttonId;
    }

    public boolean isForeground() {
        return this.isForeground;
    }

    @Nullable
    public Bundle getRemoteInput() {
        return this.remoteInput;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @NonNull
    public String toString() {
        return "NotificationActionButtonInfo{buttonId='" + this.buttonId + CoreConstants.SINGLE_QUOTE_CHAR + ", isForeground=" + this.isForeground + ", remoteInput=" + this.remoteInput + ", description='" + this.description + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
