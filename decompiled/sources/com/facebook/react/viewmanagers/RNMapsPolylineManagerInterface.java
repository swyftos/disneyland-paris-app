package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;

/* loaded from: classes3.dex */
public interface RNMapsPolylineManagerInterface<T extends View> {
    void setCoordinates(T t, @Nullable ReadableArray readableArray);

    void setGeodesic(T t, boolean z);

    void setLineCap(T t, @Nullable String str);

    void setLineDashPattern(T t, @Nullable ReadableArray readableArray);

    void setLineJoin(T t, @Nullable String str);

    void setStrokeColor(T t, @Nullable Integer num);

    void setStrokeColors(T t, @Nullable ReadableArray readableArray);

    void setStrokeWidth(T t, float f);

    void setTappable(T t, boolean z);
}
