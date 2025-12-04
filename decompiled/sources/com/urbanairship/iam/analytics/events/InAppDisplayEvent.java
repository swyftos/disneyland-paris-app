package com.urbanairship.iam.analytics.events;

import com.urbanairship.analytics.EventType;
import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppDisplayEvent;", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "()V", "data", "Lcom/urbanairship/json/JsonSerializable;", "getData", "()Lcom/urbanairship/json/JsonSerializable;", "eventType", "Lcom/urbanairship/analytics/EventType;", "getEventType", "()Lcom/urbanairship/analytics/EventType;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppDisplayEvent implements InAppEvent {
    private final JsonSerializable data;
    private final EventType eventType = EventType.IN_APP_DISPLAY;

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public EventType getEventType() {
        return this.eventType;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @Nullable
    public JsonSerializable getData() {
        return this.data;
    }
}
