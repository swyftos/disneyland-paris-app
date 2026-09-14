package org.wonday.pdf.events;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes7.dex */
public class TopChangeEvent extends Event<TopChangeEvent> {
    private WritableMap eventData;

    public TopChangeEvent(int i, int i2, WritableMap writableMap) {
        super(i, i2);
        this.eventData = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    @Nullable
    protected WritableMap getEventData() {
        return this.eventData;
    }
}
