package com.urbanairship.android.framework.proxy.events;

import com.urbanairship.actions.RateAppAction;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/framework/proxy/events/MessageCenterUpdatedEvent;", "Lcom/urbanairship/android/framework/proxy/Event;", "unreadCount", "", "count", "(II)V", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "getBody", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/framework/proxy/EventType;", "getType", "()Lcom/urbanairship/android/framework/proxy/EventType;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MessageCenterUpdatedEvent implements Event {
    private final JsonMap body;
    private final EventType type = EventType.MESSAGE_CENTER_UPDATED;

    public MessageCenterUpdatedEvent(int i, int i2) {
        this.body = JsonExtensionsKt.jsonMapOf(TuplesKt.to("messageUnreadCount", Integer.valueOf(i)), TuplesKt.to("messageCount", Integer.valueOf(i2)));
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
