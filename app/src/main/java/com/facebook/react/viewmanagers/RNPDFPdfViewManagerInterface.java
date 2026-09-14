package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNPDFPdfViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setEnableAnnotationRendering(T t, boolean z);

    void setEnableAntialiasing(T t, boolean z);

    void setEnableDoubleTapZoom(T t, boolean z);

    void setEnablePaging(T t, boolean z);

    void setEnableRTL(T t, boolean z);

    void setFitPolicy(T t, int i);

    void setHorizontal(T t, boolean z);

    void setMaxScale(T t, float f);

    void setMinScale(T t, float f);

    void setNativePage(T t, int i);

    void setPage(T t, int i);

    void setPassword(T t, @Nullable String str);

    void setPath(T t, @Nullable String str);

    void setScale(T t, float f);

    void setScrollEnabled(T t, boolean z);

    void setShowsHorizontalScrollIndicator(T t, boolean z);

    void setShowsVerticalScrollIndicator(T t, boolean z);

    void setSinglePage(T t, boolean z);

    void setSpacing(T t, int i);
}
