package com.swmansion.rnscreens.gamma.tabs;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, m1836d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/TabScreenDelegate;", "", "onTabFocusChangedFromJS", "", "tabScreen", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;", "isFocused", "", "onMenuItemAttributesChange", "getFragmentForTabScreen", "Landroidx/fragment/app/Fragment;", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface TabScreenDelegate {
    @Nullable
    Fragment getFragmentForTabScreen(@NotNull TabScreen tabScreen);

    void onMenuItemAttributesChange(@NotNull TabScreen tabScreen);

    void onTabFocusChangedFromJS(@NotNull TabScreen tabScreen, boolean isFocused);
}
