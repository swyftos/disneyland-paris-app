package com.swmansion.rnscreens.gamma.tabs;

import android.view.Menu;
import android.view.MenuItem;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, m1836d2 = {"getOrCreateMenuItem", "Landroid/view/MenuItem;", "Landroid/view/Menu;", ArrayContainsMatcher.INDEX_KEY, "", "tabScreen", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;", "react-native-screens_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class TabsHostAppearanceCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MenuItem getOrCreateMenuItem(Menu menu, int i, TabScreen tabScreen) {
        MenuItem menuItemFindItem = menu.findItem(i);
        if (menuItemFindItem != null) {
            return menuItemFindItem;
        }
        MenuItem menuItemAdd = menu.add(0, i, 0, tabScreen.getTabTitle());
        Intrinsics.checkNotNullExpressionValue(menuItemAdd, "add(...)");
        return menuItemAdd;
    }
}
