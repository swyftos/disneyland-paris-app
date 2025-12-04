package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSScreenManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setActivityState(T t, float f);

    void setCustomAnimationOnSwipe(T t, boolean z);

    void setFullScreenSwipeEnabled(T t, boolean z);

    void setFullScreenSwipeShadowEnabled(T t, boolean z);

    void setGestureEnabled(T t, boolean z);

    void setGestureResponseDistance(T t, @Nullable ReadableMap readableMap);

    void setHideKeyboardOnSwipe(T t, boolean z);

    void setHomeIndicatorHidden(T t, boolean z);

    void setNativeBackButtonDismissalEnabled(T t, boolean z);

    void setNavigationBarColor(T t, @Nullable Integer num);

    void setNavigationBarHidden(T t, boolean z);

    void setNavigationBarTranslucent(T t, boolean z);

    void setPreventNativeDismiss(T t, boolean z);

    void setReplaceAnimation(T t, @Nullable String str);

    void setScreenOrientation(T t, @Nullable String str);

    void setSheetAllowedDetents(T t, @Nullable ReadableArray readableArray);

    void setSheetCornerRadius(T t, float f);

    void setSheetElevation(T t, int i);

    void setSheetExpandsWhenScrolledToEdge(T t, boolean z);

    void setSheetGrabberVisible(T t, boolean z);

    void setSheetInitialDetent(T t, int i);

    void setSheetLargestUndimmedDetent(T t, int i);

    void setStackAnimation(T t, @Nullable String str);

    void setStackPresentation(T t, @Nullable String str);

    void setStatusBarAnimation(T t, @Nullable String str);

    void setStatusBarColor(T t, @Nullable Integer num);

    void setStatusBarHidden(T t, boolean z);

    void setStatusBarStyle(T t, @Nullable String str);

    void setStatusBarTranslucent(T t, boolean z);

    void setSwipeDirection(T t, @Nullable String str);

    void setTransitionDuration(T t, int i);
}
