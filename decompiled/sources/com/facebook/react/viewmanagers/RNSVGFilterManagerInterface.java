package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSVGFilterManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setFilterUnits(T t, @Nullable String str);

    void setHeight(T t, Dynamic dynamic);

    void setName(T t, @Nullable String str);

    void setPrimitiveUnits(T t, @Nullable String str);

    void setWidth(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
