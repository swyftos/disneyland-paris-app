package com.urbanairship.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.media3.exoplayer.offline.DownloadService;
import com.urbanairship.json.JsonMap;
import com.urbanairship.push.NotificationActionButtonInfo;
import com.urbanairship.push.NotificationInfo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class InteractiveNotificationEvent extends Event {
    private final String buttonDescription;
    private final String buttonGroupId;
    private final String buttonId;
    private final boolean isForeground;
    private final Bundle remoteInput;
    private final String sendId;

    public InteractiveNotificationEvent(@NonNull NotificationInfo notificationInfo, @NonNull NotificationActionButtonInfo notificationActionButtonInfo) {
        this.sendId = notificationInfo.getMessage().getSendId();
        this.buttonGroupId = notificationInfo.getMessage().getInteractiveNotificationType();
        this.buttonId = notificationActionButtonInfo.getButtonId();
        this.buttonDescription = notificationActionButtonInfo.getDescription();
        this.isForeground = notificationActionButtonInfo.isForeground();
        this.remoteInput = notificationActionButtonInfo.getRemoteInput();
    }

    @Override // com.urbanairship.analytics.Event
    @NonNull
    public EventType getType() {
        return EventType.INTERACTIVE_NOTIFICATION_ACTION;
    }

    @Override // com.urbanairship.analytics.Event
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public JsonMap getEventData(@NonNull ConversionData conversionData) {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("send_id", this.sendId).put("button_group", this.buttonGroupId).put("button_id", this.buttonId).put("button_description", this.buttonDescription).put(DownloadService.KEY_FOREGROUND, this.isForeground);
        Bundle bundle = this.remoteInput;
        if (bundle != null && !bundle.isEmpty()) {
            JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
            for (String str : this.remoteInput.keySet()) {
                builderNewBuilder.put(str, this.remoteInput.getString(str));
            }
            builderPut.put("user_input", builderNewBuilder.build());
        }
        return builderPut.build();
    }
}
