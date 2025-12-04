package com.urbanairship.push.notifications;

import android.app.Notification;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.urbanairship.push.PushMessage;

/* loaded from: classes5.dex */
public interface NotificationProvider {

    @NonNull
    public static final String DEFAULT_NOTIFICATION_CHANNEL = "com.urbanairship.default";

    @NonNull
    @WorkerThread
    NotificationResult onCreateNotification(@NonNull Context context, @NonNull NotificationArguments notificationArguments);

    @NonNull
    @WorkerThread
    NotificationArguments onCreateNotificationArguments(@NonNull Context context, @NonNull PushMessage pushMessage);

    @WorkerThread
    void onNotificationCreated(@NonNull Context context, @NonNull Notification notification, @NonNull NotificationArguments notificationArguments);
}
