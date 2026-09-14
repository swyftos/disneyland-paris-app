package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSSearchBarManagerInterface;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.common.base.Ascii;
import com.reactcommunity.rndatetimepicker.Common;

/* JADX INFO: loaded from: classes3.dex */
public class RNSSearchBarManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSSearchBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSSearchBarManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1619312835:
                if (str.equals("hideNavigationBar")) {
                    b = 0;
                }
                break;
            case -1465798051:
                if (str.equals("headerIconColor")) {
                    b = 1;
                }
                break;
            case -1339545093:
                if (str.equals("autoCapitalize")) {
                    b = 2;
                }
                break;
            case -1063571914:
                if (str.equals(Common.TEXT_COLOR)) {
                    b = 3;
                }
                break;
            case -336520619:
                if (str.equals("barTintColor")) {
                    b = 4;
                }
                break;
            case -256845969:
                if (str.equals("hintTextColor")) {
                    b = 5;
                }
                break;
            case -186579527:
                if (str.equals("hideWhenScrolling")) {
                    b = 6;
                }
                break;
            case -146361959:
                if (str.equals("cancelButtonText")) {
                    b = 7;
                }
                break;
            case -109380883:
                if (str.equals("disableBackButtonOverride")) {
                    b = 8;
                }
                break;
            case -39414888:
                if (str.equals("shouldShowHintSearchIcon")) {
                    b = 9;
                }
                break;
            case 598246771:
                if (str.equals(ReactTextInputShadowNode.PROP_PLACEHOLDER)) {
                    b = 10;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    b = Ascii.f3535VT;
                }
                break;
            case 1584806451:
                if (str.equals("obscureBackground")) {
                    b = Ascii.f3524FF;
                }
                break;
            case 1706976804:
                if (str.equals("inputType")) {
                    b = Ascii.f3522CR;
                }
                break;
            case 1792938725:
                if (str.equals("placement")) {
                    b = Ascii.f3532SO;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHideNavigationBar(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHeaderIconColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 2:
                ((RNSSearchBarManagerInterface) this.mViewManager).setAutoCapitalize(t, (String) obj);
                break;
            case 3:
                ((RNSSearchBarManagerInterface) this.mViewManager).setTextColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 4:
                ((RNSSearchBarManagerInterface) this.mViewManager).setBarTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 5:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHintTextColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 6:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHideWhenScrolling(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNSSearchBarManagerInterface) this.mViewManager).setCancelButtonText(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSSearchBarManagerInterface) this.mViewManager).setDisableBackButtonOverride(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 9:
                ((RNSSearchBarManagerInterface) this.mViewManager).setShouldShowHintSearchIcon(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 10:
                ((RNSSearchBarManagerInterface) this.mViewManager).setPlaceholder(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSSearchBarManagerInterface) this.mViewManager).setTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 12:
                ((RNSSearchBarManagerInterface) this.mViewManager).setObscureBackground(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((RNSSearchBarManagerInterface) this.mViewManager).setInputType(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSSearchBarManagerInterface) this.mViewManager).setPlacement(t, (String) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "cancelSearch":
                ((RNSSearchBarManagerInterface) this.mViewManager).cancelSearch(t);
                break;
            case "clearText":
                ((RNSSearchBarManagerInterface) this.mViewManager).clearText(t);
                break;
            case "toggleCancelButton":
                ((RNSSearchBarManagerInterface) this.mViewManager).toggleCancelButton(t, readableArray.getBoolean(0));
                break;
            case "blur":
                ((RNSSearchBarManagerInterface) this.mViewManager).blur(t);
                break;
            case "focus":
                ((RNSSearchBarManagerInterface) this.mViewManager).focus(t);
                break;
            case "setText":
                ((RNSSearchBarManagerInterface) this.mViewManager).setText(t, readableArray.getString(0));
                break;
        }
    }
}
