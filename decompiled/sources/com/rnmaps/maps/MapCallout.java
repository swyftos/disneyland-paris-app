package com.rnmaps.maps;

import android.content.Context;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.views.view.ReactViewGroup;
import com.rnmaps.fabric.event.OnPressEvent;
import java.util.Map;

/* loaded from: classes4.dex */
public class MapCallout extends ReactViewGroup {
    public int height;
    private boolean tooltip;
    public int width;

    public MapCallout(Context context) {
        super(context);
        this.tooltip = false;
    }

    public void setTooltip(boolean z) {
        this.tooltip = z;
    }

    public boolean getTooltip() {
        return this.tooltip;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.width = i3 - i;
        this.height = i4 - i2;
    }

    public static Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnPressEvent.EVENT_NAME));
        return builder.build();
    }
}
