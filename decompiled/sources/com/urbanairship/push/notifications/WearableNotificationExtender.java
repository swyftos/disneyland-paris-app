package com.urbanairship.push.notifications;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;

/* loaded from: classes5.dex */
public class WearableNotificationExtender implements NotificationCompat.Extender {
    private final NotificationArguments arguments;
    private final Context context;

    public WearableNotificationExtender(@NonNull Context context, @NonNull NotificationArguments notificationArguments) {
        this.context = context.getApplicationContext();
        this.arguments = notificationArguments;
    }

    @Override // androidx.core.app.NotificationCompat.Extender
    @NonNull
    public NotificationCompat.Builder extend(@NonNull NotificationCompat.Builder builder) {
        NotificationActionButtonGroup notificationActionGroup;
        String wearablePayload = this.arguments.getMessage().getWearablePayload();
        if (wearablePayload == null) {
            return builder;
        }
        try {
            JsonMap jsonMapOptMap = JsonValue.parseString(wearablePayload).optMap();
            NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
            String string = jsonMapOptMap.opt("interactive_type").getString();
            String string2 = jsonMapOptMap.opt("interactive_actions").toString();
            if (UAStringUtil.isEmpty(string2)) {
                string2 = this.arguments.getMessage().getInteractiveActionsPayload();
            }
            if (!UAStringUtil.isEmpty(string) && (notificationActionGroup = UAirship.shared().getPushManager().getNotificationActionGroup(string)) != null) {
                wearableExtender.addActions(notificationActionGroup.createAndroidActions(this.context, this.arguments, string2));
            }
            builder.extend(wearableExtender);
            return builder;
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse wearable payload.", new Object[0]);
            return builder;
        }
    }
}
