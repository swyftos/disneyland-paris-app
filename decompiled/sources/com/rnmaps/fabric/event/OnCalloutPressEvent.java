package com.rnmaps.fabric.event;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes4.dex */
public class OnCalloutPressEvent extends Event<OnCalloutPressEvent> {
    public static final String EVENT_NAME = "topCalloutPress";
    private final WritableMap payload;

    public OnCalloutPressEvent(int i, int i2, WritableMap writableMap) {
        super(i, i2);
        this.payload = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return this.payload;
    }
}
