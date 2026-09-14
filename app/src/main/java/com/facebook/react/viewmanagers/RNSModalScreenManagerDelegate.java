package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSModalScreenManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSModalScreenManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSModalScreenManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSModalScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str.hashCode()) {
            case -1937389126:
                b = !str.equals("homeIndicatorHidden") ? (byte) -1 : (byte) 0;
                break;
            case -1853558344:
                b = !str.equals("gestureEnabled") ? (byte) -1 : (byte) 1;
                break;
            case -1734097646:
                b = !str.equals("hideKeyboardOnSwipe") ? (byte) -1 : (byte) 2;
                break;
            case -1349152186:
                b = !str.equals("sheetCornerRadius") ? (byte) -1 : (byte) 3;
                break;
            case -1322084375:
                b = !str.equals("navigationBarHidden") ? (byte) -1 : (byte) 4;
                break;
            case -1156137512:
                b = !str.equals("statusBarTranslucent") ? (byte) -1 : (byte) 5;
                break;
            case -1150711358:
                b = !str.equals("stackPresentation") ? (byte) -1 : (byte) 6;
                break;
            case -1047235902:
                b = !str.equals("activityState") ? (byte) -1 : (byte) 7;
                break;
            case -973702878:
                b = !str.equals("statusBarColor") ? (byte) -1 : (byte) 8;
                break;
            case -958765200:
                b = !str.equals("statusBarStyle") ? (byte) -1 : (byte) 9;
                break;
            case -952227806:
                b = !str.equals("fullScreenSwipeShadowEnabled") ? (byte) -1 : (byte) 10;
                break;
            case -577711652:
                b = !str.equals("stackAnimation") ? (byte) -1 : Ascii.f3535VT;
                break;
            case -462720700:
                b = !str.equals("navigationBarColor") ? (byte) -1 : Ascii.f3524FF;
                break;
            case -411607385:
                b = !str.equals("screenId") ? (byte) -1 : Ascii.f3522CR;
                break;
            case -381571779:
                b = !str.equals("sheetInitialDetent") ? (byte) -1 : Ascii.f3532SO;
                break;
            case -274098190:
                b = !str.equals("sheetAllowedDetents") ? (byte) -1 : Ascii.f3531SI;
                break;
            case -257141968:
                b = !str.equals("replaceAnimation") ? (byte) -1 : Ascii.DLE;
                break;
            case -166356101:
                b = !str.equals("preventNativeDismiss") ? (byte) -1 : (byte) 17;
                break;
            case 17337291:
                b = !str.equals("statusBarHidden") ? (byte) -1 : Ascii.DC2;
                break;
            case 129956386:
                b = !str.equals("fullScreenSwipeEnabled") ? (byte) -1 : (byte) 19;
                break;
            case 187703999:
                b = !str.equals("gestureResponseDistance") ? (byte) -1 : Ascii.DC4;
                break;
            case 227582404:
                b = !str.equals("screenOrientation") ? (byte) -1 : Ascii.NAK;
                break;
            case 241896530:
                b = !str.equals("sheetLargestUndimmedDetent") ? (byte) -1 : Ascii.SYN;
                break;
            case 425064969:
                b = !str.equals("transitionDuration") ? (byte) -1 : Ascii.ETB;
                break;
            case 1082157413:
                b = !str.equals("swipeDirection") ? (byte) -1 : (byte) 24;
                break;
            case 1110843912:
                b = !str.equals("customAnimationOnSwipe") ? (byte) -1 : Ascii.f3523EM;
                break;
            case 1116050554:
                b = !str.equals("navigationBarTranslucent") ? (byte) -1 : Ascii.SUB;
                break;
            case 1269009342:
                b = !str.equals("sheetElevation") ? (byte) -1 : Ascii.ESC;
                break;
            case 1357942638:
                b = !str.equals("sheetGrabberVisible") ? (byte) -1 : Ascii.f3525FS;
                break;
            case 1387359683:
                b = !str.equals("statusBarAnimation") ? (byte) -1 : Ascii.f3526GS;
                break;
            case 1729091548:
                b = !str.equals("nativeBackButtonDismissalEnabled") ? (byte) -1 : Ascii.f3530RS;
                break;
            case 2097450072:
                b = !str.equals("sheetExpandsWhenScrolledToEdge") ? (byte) -1 : Ascii.f3534US;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSModalScreenManagerInterface) this.mViewManager).setHomeIndicatorHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSModalScreenManagerInterface) this.mViewManager).setGestureEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 2:
                ((RNSModalScreenManagerInterface) this.mViewManager).setHideKeyboardOnSwipe(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetCornerRadius(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 4:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNavigationBarHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarTranslucent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStackPresentation(t, (String) obj);
                break;
            case 7:
                ((RNSModalScreenManagerInterface) this.mViewManager).setActivityState(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 8:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 9:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarStyle(t, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSModalScreenManagerInterface) this.mViewManager).setFullScreenSwipeShadowEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 11:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStackAnimation(t, (String) obj);
                break;
            case 12:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNavigationBarColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 13:
                ((RNSModalScreenManagerInterface) this.mViewManager).setScreenId(t, obj == null ? "" : (String) obj);
                break;
            case 14:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetInitialDetent(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 15:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetAllowedDetents(t, (ReadableArray) obj);
                break;
            case 16:
                ((RNSModalScreenManagerInterface) this.mViewManager).setReplaceAnimation(t, (String) obj);
                break;
            case 17:
                ((RNSModalScreenManagerInterface) this.mViewManager).setPreventNativeDismiss(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 18:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 19:
                ((RNSModalScreenManagerInterface) this.mViewManager).setFullScreenSwipeEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 20:
                ((RNSModalScreenManagerInterface) this.mViewManager).setGestureResponseDistance(t, (ReadableMap) obj);
                break;
            case 21:
                ((RNSModalScreenManagerInterface) this.mViewManager).setScreenOrientation(t, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetLargestUndimmedDetent(t, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case 23:
                ((RNSModalScreenManagerInterface) this.mViewManager).setTransitionDuration(t, obj == null ? 500 : ((Double) obj).intValue());
                break;
            case 24:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSwipeDirection(t, (String) obj);
                break;
            case 25:
                ((RNSModalScreenManagerInterface) this.mViewManager).setCustomAnimationOnSwipe(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 26:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNavigationBarTranslucent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 27:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetElevation(t, obj != null ? ((Double) obj).intValue() : 24);
                break;
            case 28:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetGrabberVisible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarAnimation(t, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNativeBackButtonDismissalEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 31:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetExpandsWhenScrolledToEdge(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
