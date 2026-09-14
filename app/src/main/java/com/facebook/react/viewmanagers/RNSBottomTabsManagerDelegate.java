package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSBottomTabsManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSBottomTabsManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSBottomTabsManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        float fFloatValue = BitmapDescriptorFactory.HUE_RED;
        byte b = -1;
        switch (str.hashCode()) {
            case -1873119606:
                if (str.equals("tabBarTintColor")) {
                    b = 0;
                }
                break;
            case -1716883528:
                if (str.equals("tabBarItemLabelVisibilityMode")) {
                    b = 1;
                }
                break;
            case -1167805191:
                if (str.equals("tabBarItemIconColor")) {
                    b = 2;
                }
                break;
            case -1140765365:
                if (str.equals("tabBarItemActiveIndicatorColor")) {
                    b = 3;
                }
                break;
            case -727132909:
                if (str.equals("tabBarItemTitleFontColorActive")) {
                    b = 4;
                }
                break;
            case -149697865:
                if (str.equals("tabBarBackgroundColor")) {
                    b = 5;
                }
                break;
            case -141083017:
                if (str.equals("tabBarItemTitleFontSize")) {
                    b = 6;
                }
                break;
            case -93216851:
                if (str.equals("tabBarItemTitleFontColor")) {
                    b = 7;
                }
                break;
            case -78279173:
                if (str.equals("tabBarItemTitleFontStyle")) {
                    b = 8;
                }
                break;
            case 144476014:
                if (str.equals("tabBarMinimizeBehavior")) {
                    b = 9;
                }
                break;
            case 676974377:
                if (str.equals("tabBarItemActiveIndicatorEnabled")) {
                    b = 10;
                }
                break;
            case 697418079:
                if (str.equals("tabBarItemIconColorActive")) {
                    b = Ascii.f3535VT;
                }
                break;
            case 1458977038:
                if (str.equals("controlNavigationStateInJS")) {
                    b = Ascii.f3524FF;
                }
                break;
            case 1478227034:
                if (str.equals("tabBarItemTitleFontFamily")) {
                    b = Ascii.f3522CR;
                }
                break;
            case 1935822306:
                if (str.equals("tabBarItemRippleColor")) {
                    b = Ascii.f3532SO;
                }
                break;
            case 1968495470:
                if (str.equals("tabBarItemTitleFontWeight")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 2018161757:
                if (str.equals("tabBarItemTitleFontSizeActive")) {
                    b = Ascii.DLE;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 1:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemLabelVisibilityMode(t, (String) obj);
                break;
            case 2:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemIconColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 3:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemActiveIndicatorColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 4:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontColorActive(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 5:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 6:
                RNSBottomTabsManagerInterface rNSBottomTabsManagerInterface = (RNSBottomTabsManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSBottomTabsManagerInterface.setTabBarItemTitleFontSize(t, fFloatValue);
                break;
            case 7:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 8:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontStyle(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarMinimizeBehavior(t, (String) obj);
                break;
            case 10:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemActiveIndicatorEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 11:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemIconColorActive(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 12:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setControlNavigationStateInJS(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontFamily(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemRippleColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 15:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontWeight(t, obj != null ? (String) obj : null);
                break;
            case 16:
                RNSBottomTabsManagerInterface rNSBottomTabsManagerInterface2 = (RNSBottomTabsManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSBottomTabsManagerInterface2.setTabBarItemTitleFontSizeActive(t, fFloatValue);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
