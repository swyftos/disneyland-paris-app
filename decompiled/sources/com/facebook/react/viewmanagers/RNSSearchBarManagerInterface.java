package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNSSearchBarManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void blur(T t);

    void cancelSearch(T t);

    void clearText(T t);

    void focus(T t);

    void setAutoCapitalize(T t, @Nullable String str);

    void setBarTintColor(T t, @Nullable Integer num);

    void setCancelButtonText(T t, @Nullable String str);

    void setDisableBackButtonOverride(T t, boolean z);

    void setHeaderIconColor(T t, @Nullable Integer num);

    void setHideNavigationBar(T t, boolean z);

    void setHideWhenScrolling(T t, boolean z);

    void setHintTextColor(T t, @Nullable Integer num);

    void setInputType(T t, @Nullable String str);

    void setObscureBackground(T t, boolean z);

    void setPlaceholder(T t, @Nullable String str);

    void setPlacement(T t, @Nullable String str);

    void setShouldShowHintSearchIcon(T t, boolean z);

    void setText(T t, String str);

    void setTextColor(T t, @Nullable Integer num);

    void setTintColor(T t, @Nullable Integer num);

    void toggleCancelButton(T t, boolean z);
}
