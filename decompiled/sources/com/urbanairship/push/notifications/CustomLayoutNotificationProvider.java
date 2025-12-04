package com.urbanairship.push.notifications;

import android.R;
import android.content.Context;
import android.widget.RemoteViews;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;

/* loaded from: classes5.dex */
public class CustomLayoutNotificationProvider extends AirshipNotificationProvider {
    private final int layoutId;

    public CustomLayoutNotificationProvider(@NonNull Context context, @NonNull AirshipConfigOptions airshipConfigOptions, @LayoutRes int i) {
        super(context, airshipConfigOptions);
        this.layoutId = i;
    }

    @Override // com.urbanairship.push.notifications.AirshipNotificationProvider
    @NonNull
    protected NotificationCompat.Builder onExtendBuilder(@NonNull Context context, @NonNull NotificationCompat.Builder builder, @NonNull NotificationArguments notificationArguments) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.layoutId);
        onBindContentView(remoteViews, notificationArguments);
        return builder.setCustomContentView(remoteViews);
    }

    protected void onBindContentView(@NonNull RemoteViews remoteViews, @NonNull NotificationArguments notificationArguments) {
        PushMessage message = notificationArguments.getMessage();
        remoteViews.setTextViewText(R.id.title, message.getTitle() != null ? message.getTitle() : UAirship.getAppName());
        remoteViews.setTextViewText(R.id.message, message.getAlert());
        remoteViews.setTextViewText(R.id.summary, message.getSummary());
        remoteViews.setImageViewResource(R.id.icon, getSmallIcon());
    }
}
