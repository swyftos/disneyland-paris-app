package com.urbanairship.analytics;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.json.JsonMap;

/* loaded from: classes4.dex */
class AppBackgroundEvent extends Event {
    AppBackgroundEvent(long j) {
        super(j);
    }

    @Override // com.urbanairship.analytics.Event
    public final EventType getType() {
        return EventType.APP_BACKGROUND;
    }

    @Override // com.urbanairship.analytics.Event
    public JsonMap getEventData(ConversionData conversionData) {
        return JsonMap.newBuilder().put(OneIDTrackerEvent.EVENT_PARAM_CONNECTION_TYPE, getConnectionType()).put("connection_subtype", getConnectionSubType()).put("push_id", conversionData.getConversionSendId()).put("metadata", conversionData.getConversionMetadata()).build();
    }
}
