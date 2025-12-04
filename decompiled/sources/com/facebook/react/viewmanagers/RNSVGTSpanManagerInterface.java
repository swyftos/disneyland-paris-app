package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSVGTSpanManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setAlignmentBaseline(T t, @Nullable String str);

    void setBaselineShift(T t, Dynamic dynamic);

    void setClipPath(T t, @Nullable String str);

    void setClipRule(T t, int i);

    void setColor(T t, @Nullable Integer num);

    void setContent(T t, @Nullable String str);

    void setDisplay(T t, @Nullable String str);

    void setDx(T t, Dynamic dynamic);

    void setDy(T t, Dynamic dynamic);

    void setFill(T t, Dynamic dynamic);

    void setFillOpacity(T t, float f);

    void setFillRule(T t, int i);

    void setFilter(T t, @Nullable String str);

    void setFont(T t, Dynamic dynamic);

    void setFontSize(T t, Dynamic dynamic);

    void setFontWeight(T t, Dynamic dynamic);

    void setInlineSize(T t, Dynamic dynamic);

    void setLengthAdjust(T t, @Nullable String str);

    void setMarkerEnd(T t, @Nullable String str);

    void setMarkerMid(T t, @Nullable String str);

    void setMarkerStart(T t, @Nullable String str);

    void setMask(T t, @Nullable String str);

    void setMatrix(T t, @Nullable ReadableArray readableArray);

    void setName(T t, @Nullable String str);

    void setOpacity(T t, float f);

    void setPointerEvents(T t, @Nullable String str);

    void setPropList(T t, @Nullable ReadableArray readableArray);

    void setResponsible(T t, boolean z);

    void setRotate(T t, Dynamic dynamic);

    void setStroke(T t, Dynamic dynamic);

    void setStrokeDasharray(T t, Dynamic dynamic);

    void setStrokeDashoffset(T t, float f);

    void setStrokeLinecap(T t, int i);

    void setStrokeLinejoin(T t, int i);

    void setStrokeMiterlimit(T t, float f);

    void setStrokeOpacity(T t, float f);

    void setStrokeWidth(T t, Dynamic dynamic);

    void setTextLength(T t, Dynamic dynamic);

    void setVectorEffect(T t, int i);

    void setVerticalAlign(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
