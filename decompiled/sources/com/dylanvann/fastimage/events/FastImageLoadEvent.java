package com.dylanvann.fastimage.events;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
public class FastImageLoadEvent extends Event<FastImageLoadEvent> {
    private final int height;
    private final int width;

    public FastImageLoadEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.width = i3;
        this.height = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    @NonNull
    public String getEventName() {
        return "onFastImageLoad";
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("width", this.width);
        writableMapCreateMap.putInt("height", this.height);
        return writableMapCreateMap;
    }
}
