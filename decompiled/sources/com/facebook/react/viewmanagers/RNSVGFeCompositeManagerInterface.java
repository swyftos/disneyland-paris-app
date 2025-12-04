package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSVGFeCompositeManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setHeight(T t, Dynamic dynamic);

    void setIn1(T t, @Nullable String str);

    void setIn2(T t, @Nullable String str);

    void setK1(T t, float f);

    void setK2(T t, float f);

    void setK3(T t, float f);

    void setK4(T t, float f);

    void setOperator1(T t, @Nullable String str);

    void setResult(T t, @Nullable String str);

    void setWidth(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
