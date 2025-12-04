package com.rnmaps.fabric.event;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes4.dex */
public class OnLongPressEvent extends Event<OnLongPressEvent> {
    public static final String EVENT_NAME = "topLongPress";
    private final WritableMap payload;

    public OnLongPressEvent(int i, int i2, WritableMap writableMap) {
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
