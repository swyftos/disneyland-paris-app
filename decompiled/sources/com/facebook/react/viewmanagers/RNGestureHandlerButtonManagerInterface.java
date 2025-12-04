package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNGestureHandlerButtonManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setBorderColor(T t, @Nullable Integer num);

    void setBorderStyle(T t, @Nullable String str);

    void setBorderWidth(T t, float f);

    void setBorderless(T t, boolean z);

    void setEnabled(T t, boolean z);

    void setExclusive(T t, boolean z);

    void setForeground(T t, boolean z);

    void setRippleColor(T t, @Nullable Integer num);

    void setRippleRadius(T t, int i);

    void setTouchSoundDisabled(T t, boolean z);
}
