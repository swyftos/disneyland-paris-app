package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface ActivityIndicatorViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setAnimating(T t, boolean z);

    void setColor(T t, @Nullable Integer num);

    void setHidesWhenStopped(T t, boolean z);

    void setSize(T t, @Nullable String str);
}
