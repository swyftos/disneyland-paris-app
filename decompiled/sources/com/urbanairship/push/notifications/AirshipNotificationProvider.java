package com.urbanairship.push.notifications;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.NotificationIdGenerator;
import com.urbanairship.util.UAStringUtil;

/* loaded from: classes5.dex */
public class AirshipNotificationProvider implements NotificationProvider {
    public static final String DEFAULT_AIRSHIP_NOTIFICATION_ICON = "ua_default_ic_notification";
    public static final int TAG_NOTIFICATION_ID = 100;
    private int accentColor;
    private String defaultNotificationChannelId;
    private int largeIcon;
    private int smallIconId;
    private int titleId;

    @Override // com.urbanairship.push.notifications.NotificationProvider
    public void onNotificationCreated(@NonNull Context context, @NonNull Notification notification, @NonNull NotificationArguments notificationArguments) {
    }

    public void setDefaultTitle(@StringRes int i) {
        this.titleId = i;
    }

    @StringRes
    public int getDefaultTitle() {
        return this.titleId;
    }

    public void setSmallIcon(@DrawableRes int i) {
        this.smallIconId = i;
    }

    @DrawableRes
    public int getSmallIcon() {
        return this.smallIconId;
    }

    public void setLargeIcon(@DrawableRes int i) {
        this.largeIcon = i;
    }

    @DrawableRes
    public int getLargeIcon() {
        return this.largeIcon;
    }

    public void setDefaultAccentColor(@ColorInt int i) {
        this.accentColor = i;
    }

    @ColorInt
    public int getDefaultAccentColor() {
        return this.accentColor;
    }

    public void setDefaultNotificationChannelId(@NonNull String str) {
        this.defaultNotificationChannelId = str;
    }

    @NonNull
    public String getDefaultNotificationChannelId() {
        return this.defaultNotificationChannelId;
    }

    public AirshipNotificationProvider(@NonNull Context context, @NonNull AirshipConfigOptions airshipConfigOptions) {
        this.titleId = context.getApplicationInfo().labelRes;
        int i = airshipConfigOptions.notificationIcon;
        this.smallIconId = i;
        this.largeIcon = airshipConfigOptions.notificationLargeIcon;
        this.accentColor = airshipConfigOptions.notificationAccentColor;
        String str = airshipConfigOptions.notificationChannel;
        if (str != null) {
            this.defaultNotificationChannelId = str;
        } else {
            this.defaultNotificationChannelId = NotificationProvider.DEFAULT_NOTIFICATION_CHANNEL;
        }
        if (i == 0) {
            int i2 = context.getApplicationInfo().icon;
            this.smallIconId = i2;
            if (i2 == 0) {
                this.smallIconId = context.getResources().getIdentifier(DEFAULT_AIRSHIP_NOTIFICATION_ICON, "drawable", context.getPackageName());
            }
        }
        this.titleId = context.getApplicationInfo().labelRes;
    }

    @Override // com.urbanairship.push.notifications.NotificationProvider
    @NonNull
    public NotificationArguments onCreateNotificationArguments(@NonNull Context context, @NonNull PushMessage pushMessage) {
        return NotificationArguments.newBuilder(pushMessage).setNotificationChannelId(NotificationChannelUtils.getActiveChannel(pushMessage.getNotificationChannel(getDefaultNotificationChannelId()), NotificationProvider.DEFAULT_NOTIFICATION_CHANNEL)).setNotificationId(pushMessage.getNotificationTag(), getNextId(context, pushMessage)).build();
    }

    @Override // com.urbanairship.push.notifications.NotificationProvider
    @NonNull
    public NotificationResult onCreateNotification(@NonNull Context context, @NonNull NotificationArguments notificationArguments) {
        if (UAStringUtil.isEmpty(notificationArguments.getMessage().getAlert())) {
            return NotificationResult.cancel();
        }
        PushMessage message = notificationArguments.getMessage();
        NotificationCompat.Builder defaults = new NotificationCompat.Builder(context, notificationArguments.getNotificationChannelId()).setContentTitle(getTitle(context, message)).setContentText(message.getAlert()).setAutoCancel(true).setLocalOnly(message.isLocalOnly()).setColor(message.getIconColor(getDefaultAccentColor())).setSmallIcon(message.getIcon(context, getSmallIcon())).setPriority(message.getPriority()).setCategory(message.getCategory()).setVisibility(message.getVisibility()).setDefaults(-1);
        int largeIcon = getLargeIcon();
        if (largeIcon != 0) {
            defaults.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIcon));
        }
        if (message.getSummary() != null) {
            defaults.setSubText(message.getSummary());
        }
        return NotificationResult.notification(onExtendBuilder(context, defaults, notificationArguments).build());
    }

    @NonNull
    protected NotificationCompat.Builder onExtendBuilder(@NonNull Context context, @NonNull NotificationCompat.Builder builder, @NonNull NotificationArguments notificationArguments) {
        PushMessage message = notificationArguments.getMessage();
        builder.extend(new PublicNotificationExtender(context, notificationArguments).setAccentColor(getDefaultAccentColor()).setLargeIcon(getLargeIcon()).setSmallIcon(message.getIcon(context, getSmallIcon())));
        builder.extend(new WearableNotificationExtender(context, notificationArguments));
        builder.extend(new ActionsNotificationExtender(context, notificationArguments));
        builder.extend(new StyleNotificationExtender(context, message).setDefaultStyle(new NotificationCompat.BigTextStyle().bigText(notificationArguments.getMessage().getAlert())));
        return builder;
    }

    protected int getNextId(@NonNull Context context, @NonNull PushMessage pushMessage) {
        if (pushMessage.getNotificationTag() != null) {
            return 100;
        }
        return NotificationIdGenerator.nextID();
    }

    @Nullable
    protected String getTitle(@NonNull Context context, @NonNull PushMessage pushMessage) {
        if (pushMessage.getTitle() != null) {
            return pushMessage.getTitle();
        }
        int i = this.titleId;
        if (i != 0) {
            return context.getString(i);
        }
        return null;
    }
}
