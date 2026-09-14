package androidx.test.core.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class PointerPropertiesBuilder {

    /* JADX INFO: renamed from: id */
    private int f159id;
    private int toolType;

    private PointerPropertiesBuilder() {
    }

    public PointerPropertiesBuilder setId(int i) {
        this.f159id = i;
        return this;
    }

    public PointerPropertiesBuilder setToolType(int i) {
        this.toolType = i;
        return this;
    }

    public MotionEvent.PointerProperties build() {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = this.f159id;
        pointerProperties.toolType = this.toolType;
        return pointerProperties;
    }

    public static PointerPropertiesBuilder newBuilder() {
        return new PointerPropertiesBuilder();
    }
}
