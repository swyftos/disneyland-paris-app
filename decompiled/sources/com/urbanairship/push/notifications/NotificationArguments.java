package com.urbanairship.push.notifications;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.push.PushMessage;

/* loaded from: classes5.dex */
public class NotificationArguments {
    private final boolean longRunningTask;
    private final PushMessage message;
    private final String notificationChannelId;
    private final int notificationId;
    private final String notificationTag;

    private NotificationArguments(Builder builder) {
        this.notificationId = builder.notificationId;
        this.notificationChannelId = builder.notificationChannelId;
        this.longRunningTask = builder.longRunningTask;
        this.message = builder.message;
        this.notificationTag = builder.notificationTag;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    @Nullable
    public String getNotificationTag() {
        return this.notificationTag;
    }

    @NonNull
    public String getNotificationChannelId() {
        return this.notificationChannelId;
    }

    public boolean getRequiresLongRunningTask() {
        return this.longRunningTask;
    }

    @NonNull
    public PushMessage getMessage() {
        return this.message;
    }

    @NonNull
    public static Builder newBuilder(@NonNull PushMessage pushMessage) {
        return new Builder(pushMessage);
    }

    public static class Builder {
        private boolean longRunningTask;
        private final PushMessage message;
        private String notificationChannelId;
        private int notificationId;
        private String notificationTag;

        private Builder(PushMessage pushMessage) {
            this.notificationId = -1;
            this.notificationChannelId = NotificationProvider.DEFAULT_NOTIFICATION_CHANNEL;
            this.message = pushMessage;
        }

        @NonNull
        public Builder setNotificationId(@Nullable String str, int i) {
            this.notificationTag = str;
            this.notificationId = i;
            return this;
        }

        @NonNull
        public Builder setNotificationChannelId(@NonNull String str) {
            this.notificationChannelId = str;
            return this;
        }

        @NonNull
        public Builder setRequiresLongRunningTask(boolean z) {
            this.longRunningTask = z;
            return this;
        }

        @NonNull
        public NotificationArguments build() {
            return new NotificationArguments(this);
        }
    }
}
