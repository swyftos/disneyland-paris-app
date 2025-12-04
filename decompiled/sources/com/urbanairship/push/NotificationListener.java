package com.urbanairship.push;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

/* loaded from: classes5.dex */
public interface NotificationListener {
    @MainThread
    void onNotificationBackgroundAction(@NonNull NotificationInfo notificationInfo, @NonNull NotificationActionButtonInfo notificationActionButtonInfo);

    @MainThread
    void onNotificationDismissed(@NonNull NotificationInfo notificationInfo);

    @MainThread
    boolean onNotificationForegroundAction(@NonNull NotificationInfo notificationInfo, @NonNull NotificationActionButtonInfo notificationActionButtonInfo);

    @MainThread
    boolean onNotificationOpened(@NonNull NotificationInfo notificationInfo);

    @WorkerThread
    void onNotificationPosted(@NonNull NotificationInfo notificationInfo);
}
