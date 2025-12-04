package com.urbanairship.iam.analytics.events;

import androidx.annotation.VisibleForTesting;
import com.urbanairship.analytics.EventType;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppPageViewEvent;", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "eventData", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;)V", "data", "Lcom/urbanairship/json/JsonSerializable;", "(Lcom/urbanairship/json/JsonSerializable;)V", "getData", "()Lcom/urbanairship/json/JsonSerializable;", "eventType", "Lcom/urbanairship/analytics/EventType;", "getEventType", "()Lcom/urbanairship/analytics/EventType;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppPageViewEvent implements InAppEvent {
    private final JsonSerializable data;
    private final EventType eventType;

    @VisibleForTesting
    public InAppPageViewEvent(@NotNull JsonSerializable data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.eventType = EventType.IN_APP_PAGE_VIEW;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public JsonSerializable getData() {
        return this.data;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public EventType getEventType() {
        return this.eventType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppPageViewEvent(@NotNull ReportingEvent.PageViewData eventData) {
        this((JsonSerializable) eventData);
        Intrinsics.checkNotNullParameter(eventData, "eventData");
    }
}
