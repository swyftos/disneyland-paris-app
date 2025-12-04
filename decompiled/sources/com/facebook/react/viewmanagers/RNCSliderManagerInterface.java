package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNCSliderManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setAccessibilityIncrements(T t, @Nullable ReadableArray readableArray);

    void setAccessibilityUnits(T t, @Nullable String str);

    void setDisabled(T t, boolean z);

    void setInverted(T t, boolean z);

    void setLowerLimit(T t, float f);

    void setMaximumTrackImage(T t, @Nullable ReadableMap readableMap);

    void setMaximumTrackTintColor(T t, @Nullable Integer num);

    void setMaximumValue(T t, double d);

    void setMinimumTrackImage(T t, @Nullable ReadableMap readableMap);

    void setMinimumTrackTintColor(T t, @Nullable Integer num);

    void setMinimumValue(T t, double d);

    void setStep(T t, double d);

    void setTapToSeek(T t, boolean z);

    void setTestID(T t, @Nullable String str);

    void setThumbImage(T t, @Nullable ReadableMap readableMap);

    void setThumbTintColor(T t, @Nullable Integer num);

    void setTrackImage(T t, @Nullable ReadableMap readableMap);

    void setUpperLimit(T t, float f);

    void setValue(T t, float f);

    void setVertical(T t, boolean z);
}
