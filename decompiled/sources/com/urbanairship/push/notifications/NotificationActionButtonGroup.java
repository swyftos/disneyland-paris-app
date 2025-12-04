package com.urbanairship.push.notifications;

import android.content.Context;
import androidx.annotation.NonNull;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class NotificationActionButtonGroup {
    private final List actionButtons;

    private NotificationActionButtonGroup(List list) {
        this.actionButtons = new ArrayList(list);
    }

    @NonNull
    public List<NotificationActionButton> getNotificationActionButtons() {
        return new ArrayList(this.actionButtons);
    }

    List createAndroidActions(Context context, NotificationArguments notificationArguments, String str) {
        JsonMap jsonMapOptMap;
        ArrayList arrayList = new ArrayList();
        if (UAStringUtil.isEmpty(str)) {
            jsonMapOptMap = null;
        } else {
            try {
                jsonMapOptMap = JsonValue.parseString(str).optMap();
            } catch (JsonException e) {
                UALog.e(e, "Failed to parse notification actions payload: %s", str);
            }
        }
        for (NotificationActionButton notificationActionButton : getNotificationActionButtons()) {
            arrayList.add(notificationActionButton.createAndroidNotificationAction(context, jsonMapOptMap == null ? null : jsonMapOptMap.opt(notificationActionButton.getId()).toString(), notificationArguments));
        }
        return arrayList;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final List actionButtons = new ArrayList();

        @NonNull
        public Builder addNotificationActionButton(@NonNull NotificationActionButton notificationActionButton) {
            this.actionButtons.add(notificationActionButton);
            return this;
        }

        @NonNull
        public NotificationActionButtonGroup build() {
            return new NotificationActionButtonGroup(this.actionButtons);
        }
    }
}
