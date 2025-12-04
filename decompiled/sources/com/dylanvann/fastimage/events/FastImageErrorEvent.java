package com.dylanvann.fastimage.events;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
public class FastImageErrorEvent extends Event<FastImageErrorEvent> {

    @Nullable
    private final ReadableMap mSource;

    public FastImageErrorEvent(int i, int i2, @Nullable ReadableMap readableMap) {
        super(i, i2);
        this.mSource = readableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    @NonNull
    public String getEventName() {
        return "onFastImageError";
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (this.mSource != null) {
            writableMapCreateMap.putString("message", "Invalid source prop:" + this.mSource);
        }
        return writableMapCreateMap;
    }
}
