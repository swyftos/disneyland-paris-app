package com.urbanairship.android.framework.proxy.events;

import com.urbanairship.actions.RateAppAction;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.android.framework.proxy.Utils;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.push.NotificationActionButtonInfo;
import com.urbanairship.push.NotificationInfo;
import com.urbanairship.push.PushMessage;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/framework/proxy/events/NotificationResponseEvent;", "Lcom/urbanairship/android/framework/proxy/Event;", "notificationInfo", "Lcom/urbanairship/push/NotificationInfo;", "actionButtonInfo", "Lcom/urbanairship/push/NotificationActionButtonInfo;", "(Lcom/urbanairship/push/NotificationInfo;Lcom/urbanairship/push/NotificationActionButtonInfo;)V", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "getBody", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/framework/proxy/EventType;", "getType", "()Lcom/urbanairship/android/framework/proxy/EventType;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NotificationResponseEvent implements Event {
    private final JsonMap body;
    private final EventType type;

    public NotificationResponseEvent(@NotNull NotificationInfo notificationInfo, @Nullable NotificationActionButtonInfo notificationActionButtonInfo) {
        EventType eventType;
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        if (notificationActionButtonInfo != null && !notificationActionButtonInfo.isForeground()) {
            eventType = EventType.BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED;
        } else {
            eventType = EventType.FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED;
        }
        this.type = eventType;
        Utils utils = Utils.INSTANCE;
        PushMessage message = notificationInfo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        this.body = JsonExtensionsKt.jsonMapOf(TuplesKt.to("pushPayload", utils.notificationMap(message, Integer.valueOf(notificationInfo.getNotificationId()), notificationInfo.getNotificationTag())), TuplesKt.to("isForeground", Boolean.valueOf(getType() == EventType.FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED)), TuplesKt.to("actionId", notificationActionButtonInfo != null ? notificationActionButtonInfo.getButtonId() : null));
    }

    @Override // com.urbanairship.android.framework.proxy.Event
    @NotNull
    public EventType getType() {
        return this.type;
    }

    @Override // com.urbanairship.android.framework.proxy.Event
    @NotNull
    public JsonMap getBody() {
        return this.body;
    }
}
