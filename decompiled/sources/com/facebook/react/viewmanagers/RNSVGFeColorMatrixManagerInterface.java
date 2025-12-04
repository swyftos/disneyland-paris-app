package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSVGFeColorMatrixManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setHeight(T t, Dynamic dynamic);

    void setIn1(T t, @Nullable String str);

    void setResult(T t, @Nullable String str);

    void setType(T t, @Nullable String str);

    void setValues(T t, @Nullable ReadableArray readableArray);

    void setWidth(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
