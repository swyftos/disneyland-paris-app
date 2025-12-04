package com.urbanairship.iam.analytics.events;

import com.urbanairship.analytics.EventType;
import com.urbanairship.android.layout.event.ReportingEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppFormDisplayEvent;", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplayData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplayData;)V", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplayData;", "eventType", "Lcom/urbanairship/analytics/EventType;", "getEventType", "()Lcom/urbanairship/analytics/EventType;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppFormDisplayEvent implements InAppEvent {
    private final ReportingEvent.FormDisplayData data;
    private final EventType eventType;

    public InAppFormDisplayEvent(@NotNull ReportingEvent.FormDisplayData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.eventType = EventType.IN_APP_FORM_DISPLAY;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public ReportingEvent.FormDisplayData getData() {
        return this.data;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public EventType getEventType() {
        return this.eventType;
    }
}
