package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;

/* loaded from: classes3.dex */
public interface RNMapsGooglePolygonManagerInterface<T extends View> {
    void setCoordinates(T t, @Nullable ReadableArray readableArray);

    void setFillColor(T t, @Nullable Integer num);

    void setGeodesic(T t, boolean z);

    void setHoles(T t, @Nullable ReadableArray readableArray);

    void setStrokeColor(T t, @Nullable Integer num);

    void setTappable(T t, boolean z);
}
