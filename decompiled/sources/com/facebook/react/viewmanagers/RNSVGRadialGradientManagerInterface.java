package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSVGRadialGradientManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setClipPath(T t, @Nullable String str);

    void setClipRule(T t, int i);

    void setCx(T t, Dynamic dynamic);

    void setCy(T t, Dynamic dynamic);

    void setDisplay(T t, @Nullable String str);

    void setFx(T t, Dynamic dynamic);

    void setFy(T t, Dynamic dynamic);

    void setGradient(T t, @Nullable ReadableArray readableArray);

    void setGradientTransform(T t, @Nullable ReadableArray readableArray);

    void setGradientUnits(T t, int i);

    void setMarkerEnd(T t, @Nullable String str);

    void setMarkerMid(T t, @Nullable String str);

    void setMarkerStart(T t, @Nullable String str);

    void setMask(T t, @Nullable String str);

    void setMatrix(T t, @Nullable ReadableArray readableArray);

    void setName(T t, @Nullable String str);

    void setOpacity(T t, float f);

    void setPointerEvents(T t, @Nullable String str);

    void setResponsible(T t, boolean z);

    void setRx(T t, Dynamic dynamic);

    void setRy(T t, Dynamic dynamic);
}
