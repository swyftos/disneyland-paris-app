package com.dylanvann.fastimage.events;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
public class FastImageLoadStartEvent extends Event<FastImageLoadStartEvent> {
    public FastImageLoadStartEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    @NonNull
    public String getEventName() {
        return "onFastImageLoadStart";
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        return Arguments.createMap();
    }
}
