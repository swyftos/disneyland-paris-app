package com.urbanairship.analytics;

import android.app.NotificationChannelGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationManagerCompat;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonMap;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.notifications.NotificationChannelCompat;
import com.urbanairship.util.UAStringUtil;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class PushArrivedEvent extends Event {
    private final PushMessage message;
    private final NotificationChannelCompat notificationChannel;

    public PushArrivedEvent(@NonNull PushMessage pushMessage) {
        this(pushMessage, null);
    }

    public PushArrivedEvent(@NonNull PushMessage pushMessage, @Nullable NotificationChannelCompat notificationChannelCompat) {
        this.message = pushMessage;
        this.notificationChannel = notificationChannelCompat;
    }

    private String importanceString(int i) {
        if (i == 0) {
            return "NONE";
        }
        if (i == 1) {
            return "MIN";
        }
        if (i == 2) {
            return "LOW";
        }
        if (i == 3) {
            return "DEFAULT";
        }
        if (i == 4) {
            return "HIGH";
        }
        if (i == 5) {
            return "MAX";
        }
        return "UNKNOWN";
    }

    private void addNotificationChannelData(JsonMap.Builder builder) {
        JsonMap jsonMapBuild;
        String strImportanceString = importanceString(this.notificationChannel.getImportance());
        String group = this.notificationChannel.getGroup();
        if (group != null) {
            NotificationChannelGroup notificationChannelGroup = NotificationManagerCompat.from(UAirship.getApplicationContext()).getNotificationChannelGroup(group);
            jsonMapBuild = JsonMap.newBuilder().put("group", JsonMap.newBuilder().putOpt("blocked", String.valueOf(notificationChannelGroup != null && notificationChannelGroup.isBlocked())).build()).build();
        } else {
            jsonMapBuild = null;
        }
        builder.put("notification_channel", JsonMap.newBuilder().put("identifier", this.notificationChannel.getId()).put("importance", strImportanceString).putOpt("group", jsonMapBuild).build());
    }

    @Override // com.urbanairship.analytics.Event
    @NonNull
    public EventType getType() {
        return EventType.PUSH_ARRIVED;
    }

    @Override // com.urbanairship.analytics.Event
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final JsonMap getEventData(@NonNull ConversionData conversionData) {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("push_id", !UAStringUtil.isEmpty(this.message.getSendId()) ? this.message.getSendId() : "MISSING_SEND_ID").put("metadata", this.message.getMetadata()).put(OneIDTrackerEvent.EVENT_PARAM_CONNECTION_TYPE, getConnectionType()).put("connection_subtype", getConnectionSubType()).put("carrier", getCarrier());
        if (this.notificationChannel != null) {
            addNotificationChannelData(builderPut);
        }
        return builderPut.build();
    }
}
