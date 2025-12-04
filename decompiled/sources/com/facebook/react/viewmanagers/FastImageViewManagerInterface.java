package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface FastImageViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setDefaultSource(T t, @Nullable String str);

    void setResizeMode(T t, @Nullable String str);

    void setSource(T t, @Nullable ReadableMap readableMap);

    void setTintColor(T t, @Nullable Integer num);
}
