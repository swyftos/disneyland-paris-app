package androidx.test.core.view;

import android.view.MotionEvent;

/* loaded from: classes2.dex */
public class PointerPropertiesBuilder {
    private int id;
    private int toolType;

    private PointerPropertiesBuilder() {
    }

    public PointerPropertiesBuilder setId(int i) {
        this.id = i;
        return this;
    }

    public PointerPropertiesBuilder setToolType(int i) {
        this.toolType = i;
        return this;
    }

    public MotionEvent.PointerProperties build() {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = this.id;
        pointerProperties.toolType = this.toolType;
        return pointerProperties;
    }

    public static PointerPropertiesBuilder newBuilder() {
        return new PointerPropertiesBuilder();
    }
}
