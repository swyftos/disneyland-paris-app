package com.urbanairship.push;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;

/* loaded from: classes5.dex */
public class NotificationInfo {
    private final PushMessage message;
    private final int notificationId;
    private final String notificationTag;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NotificationInfo(@NonNull PushMessage pushMessage, int i, @Nullable String str) {
        this.message = pushMessage;
        this.notificationTag = str;
        this.notificationId = i;
    }

    static NotificationInfo fromIntent(Intent intent) {
        PushMessage pushMessageFromIntent = PushMessage.fromIntent(intent);
        if (pushMessageFromIntent == null) {
            return null;
        }
        return new NotificationInfo(pushMessageFromIntent, intent.getIntExtra(PushManager.EXTRA_NOTIFICATION_ID, -1), intent.getStringExtra(PushManager.EXTRA_NOTIFICATION_TAG));
    }

    @NonNull
    public PushMessage getMessage() {
        return this.message;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    @Nullable
    public String getNotificationTag() {
        return this.notificationTag;
    }

    @NonNull
    public String toString() {
        return "NotificationInfo{alert=" + this.message.getAlert() + ", notificationId=" + this.notificationId + ", notificationTag='" + this.notificationTag + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
