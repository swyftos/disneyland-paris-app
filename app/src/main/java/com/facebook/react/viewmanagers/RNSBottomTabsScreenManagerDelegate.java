package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSBottomTabsScreenManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSBottomTabsScreenManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSBottomTabsScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1770963447:
                if (str.equals("specialEffects")) {
                    b = 0;
                }
                break;
            case -1559978286:
                if (str.equals("iconResourceName")) {
                    b = 1;
                }
                break;
            case -1439500848:
                if (str.equals("orientation")) {
                    b = 2;
                }
                break;
            case -1270820115:
                if (str.equals("isFocused")) {
                    b = 3;
                }
                break;
            case -1186468415:
                if (str.equals("overrideScrollViewContentInsetAdjustmentBehavior")) {
                    b = 4;
                }
                break;
            case -881409398:
                if (str.equals("tabKey")) {
                    b = 5;
                }
                break;
            case -776576227:
                if (str.equals("iconImageSource")) {
                    b = 6;
                }
                break;
            case -737911981:
                if (str.equals("iconType")) {
                    b = 7;
                }
                break;
            case -569869622:
                if (str.equals("selectedIconSfSymbolName")) {
                    b = 8;
                }
                break;
            case -270334418:
                if (str.equals("scrollEdgeAppearance")) {
                    b = 9;
                }
                break;
            case 28389121:
                if (str.equals("standardAppearance")) {
                    b = 10;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    b = Ascii.f3535VT;
                }
                break;
            case 143186447:
                if (str.equals("iconSfSymbolName")) {
                    b = Ascii.f3524FF;
                }
                break;
            case 642560482:
                if (str.equals("systemItem")) {
                    b = Ascii.f3522CR;
                }
                break;
            case 1001537282:
                if (str.equals("selectedIconImageSource")) {
                    b = Ascii.f3532SO;
                }
                break;
            case 1072026510:
                if (str.equals("badgeValue")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 1293147047:
                if (str.equals("iconResource")) {
                    b = Ascii.DLE;
                }
                break;
            case 1519110851:
                if (str.equals("tabBarItemBadgeBackgroundColor")) {
                    b = 17;
                }
                break;
            case 1595935908:
                if (str.equals("tabBarItemBadgeTextColor")) {
                    b = Ascii.DC2;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setSpecialEffects(t, (ReadableMap) obj);
                break;
            case 1:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconResourceName(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setOrientation(t, (String) obj);
                break;
            case 3:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIsFocused(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setOverrideScrollViewContentInsetAdjustmentBehavior(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 5:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabKey(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconImageSource(t, (ReadableMap) obj);
                break;
            case 7:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconType(t, (String) obj);
                break;
            case 8:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setSelectedIconSfSymbolName(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setScrollEdgeAppearance(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setStandardAppearance(t, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTitle(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconSfSymbolName(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setSystemItem(t, (String) obj);
                break;
            case 14:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setSelectedIconImageSource(t, (ReadableMap) obj);
                break;
            case 15:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setBadgeValue(t, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconResource(t, (ReadableMap) obj);
                break;
            case 17:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemBadgeBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 18:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemBadgeTextColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
