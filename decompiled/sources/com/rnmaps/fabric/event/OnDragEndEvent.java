package com.rnmaps.fabric.event;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes4.dex */
public class OnDragEndEvent extends Event<OnDragEndEvent> {
    public static final String EVENT_NAME = "topDragEnd";
    private final WritableMap payload;

    public OnDragEndEvent(int i, int i2, WritableMap writableMap) {
        super(i, i2);
        this.payload = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    @NonNull
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return this.payload;
    }
}
