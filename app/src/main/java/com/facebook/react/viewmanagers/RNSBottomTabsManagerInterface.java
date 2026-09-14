package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSBottomTabsManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setControlNavigationStateInJS(T t, boolean z);

    void setTabBarBackgroundColor(T t, @Nullable Integer num);

    void setTabBarItemActiveIndicatorColor(T t, @Nullable Integer num);

    void setTabBarItemActiveIndicatorEnabled(T t, boolean z);

    void setTabBarItemIconColor(T t, @Nullable Integer num);

    void setTabBarItemIconColorActive(T t, @Nullable Integer num);

    void setTabBarItemLabelVisibilityMode(T t, @Nullable String str);

    void setTabBarItemRippleColor(T t, @Nullable Integer num);

    void setTabBarItemTitleFontColor(T t, @Nullable Integer num);

    void setTabBarItemTitleFontColorActive(T t, @Nullable Integer num);

    void setTabBarItemTitleFontFamily(T t, @Nullable String str);

    void setTabBarItemTitleFontSize(T t, float f);

    void setTabBarItemTitleFontSizeActive(T t, float f);

    void setTabBarItemTitleFontStyle(T t, @Nullable String str);

    void setTabBarItemTitleFontWeight(T t, @Nullable String str);

    void setTabBarMinimizeBehavior(T t, @Nullable String str);

    void setTabBarTintColor(T t, @Nullable Integer num);
}
