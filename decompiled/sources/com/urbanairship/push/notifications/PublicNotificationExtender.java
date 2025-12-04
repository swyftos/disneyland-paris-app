package com.urbanairship.push.notifications;

import android.content.Context;
import android.graphics.BitmapFactory;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import org.bouncycastle.i18n.ErrorBundle;

/* loaded from: classes5.dex */
public class PublicNotificationExtender implements NotificationCompat.Extender {
    private int accentColor;
    private final NotificationArguments arguments;
    private final Context context;
    private int largeIconId;
    private int smallIconId;

    public PublicNotificationExtender(@NonNull Context context, @NonNull NotificationArguments notificationArguments) {
        this.context = context;
        this.arguments = notificationArguments;
        this.smallIconId = context.getApplicationInfo().icon;
    }

    @NonNull
    public PublicNotificationExtender setAccentColor(@ColorInt int i) {
        this.accentColor = i;
        return this;
    }

    @NonNull
    public PublicNotificationExtender setSmallIcon(@DrawableRes int i) {
        this.smallIconId = i;
        return this;
    }

    @NonNull
    public PublicNotificationExtender setLargeIcon(@DrawableRes int i) {
        this.largeIconId = i;
        return this;
    }

    @Override // androidx.core.app.NotificationCompat.Extender
    @NonNull
    public NotificationCompat.Builder extend(@NonNull NotificationCompat.Builder builder) {
        if (UAStringUtil.isEmpty(this.arguments.getMessage().getPublicNotificationPayload())) {
            return builder;
        }
        try {
            JsonMap jsonMapOptMap = JsonValue.parseString(this.arguments.getMessage().getPublicNotificationPayload()).optMap();
            NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this.context, this.arguments.getNotificationChannelId()).setContentTitle(jsonMapOptMap.opt("title").optString()).setContentText(jsonMapOptMap.opt("alert").optString()).setColor(this.accentColor).setAutoCancel(true).setSmallIcon(this.smallIconId);
            if (this.largeIconId != 0) {
                smallIcon.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), this.largeIconId));
            }
            if (jsonMapOptMap.containsKey(ErrorBundle.SUMMARY_ENTRY)) {
                smallIcon.setSubText(jsonMapOptMap.opt(ErrorBundle.SUMMARY_ENTRY).optString());
            }
            builder.setPublicVersion(smallIcon.build());
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse public notification.", new Object[0]);
        }
        return builder;
    }
}
