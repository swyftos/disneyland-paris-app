package com.urbanairship.analytics;

import com.urbanairship.json.JsonMap;

/* loaded from: classes4.dex */
class InstallAttributionEvent extends Event {
    private final String referrer;

    public InstallAttributionEvent(String str) {
        this.referrer = str;
    }

    @Override // com.urbanairship.analytics.Event
    public EventType getType() {
        return EventType.INSTALL_ATTRIBUTION;
    }

    @Override // com.urbanairship.analytics.Event
    public JsonMap getEventData(ConversionData conversionData) {
        return JsonMap.newBuilder().put("google_play_referrer", this.referrer).build();
    }
}
