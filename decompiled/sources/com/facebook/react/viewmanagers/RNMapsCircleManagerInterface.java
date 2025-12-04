package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
public interface RNMapsCircleManagerInterface<T extends View> {
    void setCenter(T t, @Nullable ReadableMap readableMap);

    void setFillColor(T t, @Nullable Integer num);

    void setRadius(T t, double d);

    void setStrokeColor(T t, @Nullable Integer num);

    void setStrokeWidth(T t, float f);

    void setTappable(T t, boolean z);
}
