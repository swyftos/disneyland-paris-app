package com.urbanairship.android.framework.proxy.events;

import com.urbanairship.actions.RateAppAction;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.android.framework.proxy.Utils;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.push.NotificationInfo;
import com.urbanairship.push.PushMessage;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/framework/proxy/events/PushReceivedEvent;", "Lcom/urbanairship/android/framework/proxy/Event;", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "isForeground", "", "(Lcom/urbanairship/json/JsonMap;Z)V", "message", "Lcom/urbanairship/push/PushMessage;", "(Lcom/urbanairship/push/PushMessage;Z)V", "notificationInfo", "Lcom/urbanairship/push/NotificationInfo;", "(Lcom/urbanairship/push/NotificationInfo;Z)V", "getBody", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/framework/proxy/EventType;", "getType", "()Lcom/urbanairship/android/framework/proxy/EventType;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushReceivedEvent implements Event {
    private final JsonMap body;
    private final EventType type;

    @Override // com.urbanairship.android.framework.proxy.Event
    @NotNull
    public JsonMap getBody() {
        return this.body;
    }

    @Override // com.urbanairship.android.framework.proxy.Event
    @NotNull
    public EventType getType() {
        return this.type;
    }

    public PushReceivedEvent(@NotNull JsonMap body, boolean z) {
        EventType eventType;
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
        if (z) {
            eventType = EventType.FOREGROUND_PUSH_RECEIVED;
        } else {
            eventType = EventType.BACKGROUND_PUSH_RECEIVED;
        }
        this.type = eventType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushReceivedEvent(@NotNull PushMessage message, boolean z) {
        this(JsonExtensionsKt.jsonMapOf(TuplesKt.to("pushPayload", Utils.notificationMap$default(Utils.INSTANCE, message, null, null, 6, null)), TuplesKt.to("isForeground", Boolean.valueOf(z))), z);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PushReceivedEvent(@NotNull NotificationInfo notificationInfo, boolean z) {
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        Utils utils = Utils.INSTANCE;
        PushMessage message = notificationInfo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        this(JsonExtensionsKt.jsonMapOf(TuplesKt.to("pushPayload", utils.notificationMap(message, Integer.valueOf(notificationInfo.getNotificationId()), notificationInfo.getNotificationTag())), TuplesKt.to("isForeground", Boolean.valueOf(z))), z);
    }
}
