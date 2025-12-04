package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.ReactConstants;

/* loaded from: classes3.dex */
public class DynamicFromObject implements Dynamic {

    @Nullable
    private Object mObject;

    @Override // com.facebook.react.bridge.Dynamic
    public void recycle() {
    }

    public DynamicFromObject(@Nullable Object obj) {
        this.mObject = obj;
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean isNull() {
        return this.mObject == null;
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean asBoolean() {
        return ((Boolean) this.mObject).booleanValue();
    }

    @Override // com.facebook.react.bridge.Dynamic
    public double asDouble() {
        return ((Double) this.mObject).doubleValue();
    }

    @Override // com.facebook.react.bridge.Dynamic
    public int asInt() {
        return ((Double) this.mObject).intValue();
    }

    @Override // com.facebook.react.bridge.Dynamic
    public String asString() {
        return (String) this.mObject;
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableArray asArray() {
        return (ReadableArray) this.mObject;
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableMap asMap() {
        return (ReadableMap) this.mObject;
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableType getType() {
        if (isNull()) {
            return ReadableType.Null;
        }
        Object obj = this.mObject;
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof Number) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unmapped object type ");
        Object obj2 = this.mObject;
        sb.append(obj2 == null ? "<NULL object>" : obj2.getClass().getName());
        FLog.e(ReactConstants.TAG, sb.toString());
        return ReadableType.Null;
    }
}
