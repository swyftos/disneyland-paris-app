package androidx.test.core.view;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MotionEventBuilder {
    private long downTime = 0;
    private long eventTime = SystemClock.uptimeMillis();
    private int action = 0;
    private int actionIndex = -1;
    private List pointerPropertiesList = new ArrayList();
    private List pointerCoordsList = new ArrayList();
    private int metaState = 0;
    private int buttonState = 0;
    private float xPrecision = BitmapDescriptorFactory.HUE_RED;
    private float yPrecision = BitmapDescriptorFactory.HUE_RED;
    private int deviceId = 0;
    private int edgeFlags = 0;
    private int source = 0;
    private int flags = 0;

    private MotionEventBuilder() {
    }

    public static MotionEventBuilder newBuilder() {
        return new MotionEventBuilder();
    }

    public MotionEventBuilder setDownTime(long j) {
        this.downTime = j;
        return this;
    }

    public MotionEventBuilder setEventTime(long j) {
        this.eventTime = j;
        return this;
    }

    public MotionEventBuilder setAction(int i) {
        this.action = i;
        return this;
    }

    public MotionEventBuilder setActionIndex(int i) {
        checkState(i <= 255, "pointerIndex must be less than 0xff");
        this.actionIndex = i;
        return this;
    }

    public MotionEventBuilder setMetaState(int i) {
        this.metaState = i;
        return this;
    }

    public MotionEventBuilder setButtonState(int i) {
        this.buttonState = i;
        return this;
    }

    public MotionEventBuilder setXPrecision(float f) {
        this.xPrecision = f;
        return this;
    }

    public MotionEventBuilder setYPrecision(float f) {
        this.yPrecision = f;
        return this;
    }

    public MotionEventBuilder setDeviceId(int i) {
        this.deviceId = i;
        return this;
    }

    public MotionEventBuilder setEdgeFlags(int i) {
        this.edgeFlags = i;
        return this;
    }

    public MotionEventBuilder setSource(int i) {
        this.source = i;
        return this;
    }

    public MotionEventBuilder setFlags(int i) {
        this.flags = i;
        return this;
    }

    public MotionEventBuilder setPointer(float f, float f2) {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = this.pointerPropertiesList.size();
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = f;
        pointerCoords.y = f2;
        return setPointer(pointerProperties, pointerCoords);
    }

    public MotionEventBuilder setPointer(MotionEvent.PointerProperties pointerProperties, MotionEvent.PointerCoords pointerCoords) {
        this.pointerPropertiesList.add(pointerProperties);
        this.pointerCoordsList.add(pointerCoords);
        return this;
    }

    public MotionEvent build() {
        if (this.pointerPropertiesList.size() == 0) {
            setPointer(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        }
        int i = this.actionIndex;
        if (i != -1) {
            this.action = (i << 8) | this.action;
        }
        long j = this.downTime;
        long j2 = this.eventTime;
        int i2 = this.action;
        int size = this.pointerPropertiesList.size();
        List list = this.pointerPropertiesList;
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) list.toArray(new MotionEvent.PointerProperties[list.size()]);
        List list2 = this.pointerCoordsList;
        return MotionEvent.obtain(j, j2, i2, size, pointerPropertiesArr, (MotionEvent.PointerCoords[]) list2.toArray(new MotionEvent.PointerCoords[list2.size()]), this.metaState, this.buttonState, this.xPrecision, this.yPrecision, this.deviceId, this.edgeFlags, this.source, this.flags);
    }

    private static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }
}
