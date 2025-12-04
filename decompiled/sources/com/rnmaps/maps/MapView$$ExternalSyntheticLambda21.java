package com.rnmaps.maps;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.rnmaps.fabric.event.OnPressEvent;
import com.rnmaps.maps.MapView;

/* loaded from: classes4.dex */
public final /* synthetic */ class MapView$$ExternalSyntheticLambda21 implements MapView.EventCreator {
    @Override // com.rnmaps.maps.MapView.EventCreator
    public final Event create(int i, int i2, WritableMap writableMap) {
        return new OnPressEvent(i, i2, writableMap);
    }
}
