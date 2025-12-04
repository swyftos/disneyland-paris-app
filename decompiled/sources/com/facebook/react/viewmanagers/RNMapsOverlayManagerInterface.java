package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
public interface RNMapsOverlayManagerInterface<T extends View> {
    void setBearing(T t, float f);

    void setBounds(T t, @Nullable ReadableMap readableMap);

    void setImage(T t, @Nullable ReadableMap readableMap);

    void setOpacity(T t, float f);

    void setTappable(T t, boolean z);
}
