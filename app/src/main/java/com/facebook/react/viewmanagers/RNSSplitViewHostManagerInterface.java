package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSSplitViewHostManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setColumnMetrics(T t, @Nullable ReadableMap readableMap);

    void setDisplayModeButtonVisibility(T t, @Nullable String str);

    void setOrientation(T t, @Nullable String str);

    void setPreferredDisplayMode(T t, @Nullable String str);

    void setPreferredSplitBehavior(T t, @Nullable String str);

    void setPresentsWithGesture(T t, boolean z);

    void setPrimaryEdge(T t, @Nullable String str);

    void setShowInspector(T t, boolean z);

    void setShowSecondaryToggleButton(T t, boolean z);
}
