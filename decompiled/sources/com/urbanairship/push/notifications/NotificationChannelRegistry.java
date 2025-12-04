package com.urbanairship.push.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.annotation.XmlRes;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.PendingResult;
import com.urbanairship.R;
import com.urbanairship.UALog;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class NotificationChannelRegistry {
    private final Context context;
    private final NotificationChannelRegistryDataManager dataManager;
    private final Executor executor;
    private final NotificationManager notificationManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NotificationChannelRegistry(@NonNull Context context, @NonNull AirshipConfigOptions airshipConfigOptions) {
        this(context, new NotificationChannelRegistryDataManager(context, airshipConfigOptions.appKey, "ua_notification_channel_registry.db"), AirshipExecutors.newSerialExecutor());
    }

    NotificationChannelRegistry(Context context, NotificationChannelRegistryDataManager notificationChannelRegistryDataManager, Executor executor) {
        this.context = context;
        this.dataManager = notificationChannelRegistryDataManager;
        this.executor = executor;
        this.notificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    @NonNull
    public PendingResult<NotificationChannelCompat> getNotificationChannel(@NonNull final String str) {
        final PendingResult<NotificationChannelCompat> pendingResult = new PendingResult<>();
        this.executor.execute(new Runnable() { // from class: com.urbanairship.push.notifications.NotificationChannelRegistry.1
            @Override // java.lang.Runnable
            public void run() {
                NotificationChannelCompat notificationChannelCompat;
                NotificationChannel notificationChannel = NotificationChannelRegistry.this.notificationManager.getNotificationChannel(str);
                if (notificationChannel == null) {
                    NotificationChannelCompat channel = NotificationChannelRegistry.this.dataManager.getChannel(str);
                    if (channel == null) {
                        channel = NotificationChannelRegistry.this.getAndCreateDefaultChannel(str);
                    }
                    notificationChannelCompat = channel;
                    if (notificationChannelCompat != null) {
                        NotificationChannelRegistry.this.notificationManager.createNotificationChannel(notificationChannelCompat.toNotificationChannel());
                    }
                } else {
                    notificationChannelCompat = new NotificationChannelCompat(notificationChannel);
                }
                pendingResult.setResult(notificationChannelCompat);
            }
        });
        return pendingResult;
    }

    @Nullable
    @WorkerThread
    public NotificationChannelCompat getNotificationChannelSync(@NonNull String str) {
        try {
            return getNotificationChannel(str).get();
        } catch (InterruptedException e) {
            UALog.e(e, "Failed to get notification channel.", new Object[0]);
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            UALog.e(e2, "Failed to get notification channel.", new Object[0]);
            return null;
        }
    }

    public void deleteNotificationChannel(@NonNull final String str) {
        this.executor.execute(new Runnable() { // from class: com.urbanairship.push.notifications.NotificationChannelRegistry.2
            @Override // java.lang.Runnable
            public void run() {
                NotificationChannelRegistry.this.notificationManager.deleteNotificationChannel(str);
                NotificationChannelRegistry.this.dataManager.deleteChannel(str);
            }
        });
    }

    public void createNotificationChannel(@NonNull final NotificationChannelCompat notificationChannelCompat) {
        this.executor.execute(new Runnable() { // from class: com.urbanairship.push.notifications.NotificationChannelRegistry.3
            @Override // java.lang.Runnable
            public void run() {
                NotificationChannelRegistry.this.notificationManager.createNotificationChannel(notificationChannelCompat.toNotificationChannel());
                NotificationChannelRegistry.this.dataManager.createChannel(notificationChannelCompat);
            }
        });
    }

    public void createDeferredNotificationChannel(@NonNull final NotificationChannelCompat notificationChannelCompat) {
        this.executor.execute(new Runnable() { // from class: com.urbanairship.push.notifications.NotificationChannelRegistry.4
            @Override // java.lang.Runnable
            public void run() {
                NotificationChannelRegistry.this.dataManager.createChannel(notificationChannelCompat);
            }
        });
    }

    public void createNotificationChannels(@XmlRes final int i) {
        this.executor.execute(new Runnable() { // from class: com.urbanairship.push.notifications.NotificationChannelRegistry.5
            @Override // java.lang.Runnable
            public void run() {
                for (NotificationChannelCompat notificationChannelCompat : NotificationChannelCompat.fromXml(NotificationChannelRegistry.this.context, i)) {
                    NotificationChannelRegistry.this.notificationManager.createNotificationChannel(notificationChannelCompat.toNotificationChannel());
                    NotificationChannelRegistry.this.dataManager.createChannel(notificationChannelCompat);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NotificationChannelCompat getAndCreateDefaultChannel(String str) {
        for (NotificationChannelCompat notificationChannelCompat : NotificationChannelCompat.fromXml(this.context, R.xml.ua_default_channels)) {
            if (str.equals(notificationChannelCompat.getId())) {
                this.dataManager.createChannel(notificationChannelCompat);
                return notificationChannelCompat;
            }
        }
        return null;
    }
}
