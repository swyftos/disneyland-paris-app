package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSVGFeFloodManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setFloodColor(T t, Dynamic dynamic);

    void setFloodOpacity(T t, float f);

    void setHeight(T t, Dynamic dynamic);

    void setResult(T t, @Nullable String str);

    void setWidth(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
