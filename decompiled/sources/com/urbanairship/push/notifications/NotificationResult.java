package com.urbanairship.push.notifications;

import android.app.Notification;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class NotificationResult {
    public static final int CANCEL = 2;
    public static final int OK = 0;
    public static final int RETRY = 1;
    private final Notification notification;
    private final int status;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    private NotificationResult(Notification notification, int i) {
        this.notification = notification;
        if (notification == null && i == 0) {
            this.status = 2;
        } else {
            this.status = i;
        }
    }

    @NonNull
    public static NotificationResult notification(@NonNull Notification notification) {
        return new NotificationResult(notification, 0);
    }

    @NonNull
    public static NotificationResult cancel() {
        return new NotificationResult(null, 2);
    }

    @NonNull
    public static NotificationResult retry() {
        return new NotificationResult(null, 1);
    }

    @Nullable
    public Notification getNotification() {
        return this.notification;
    }

    public int getStatus() {
        return this.status;
    }
}
