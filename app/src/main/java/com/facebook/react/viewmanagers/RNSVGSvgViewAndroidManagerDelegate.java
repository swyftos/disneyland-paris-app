package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGSvgViewAndroidManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGSvgViewAndroidManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGSvgViewAndroidManagerDelegate(BaseViewManager baseViewManager) {
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
            case -2064426617:
                if (str.equals("bbHeight")) {
                    b = 0;
                }
                break;
            case -1989576717:
                if (str.equals(ViewProps.BORDER_RIGHT_COLOR)) {
                    b = 1;
                }
                break;
            case -1697814026:
                if (str.equals("backfaceVisibility")) {
                    b = 2;
                }
                break;
            case -1567958285:
                if (str.equals("vbHeight")) {
                    b = 3;
                }
                break;
            case -1470826662:
                if (str.equals(ViewProps.BORDER_TOP_COLOR)) {
                    b = 4;
                }
                break;
            case -1308858324:
                if (str.equals(ViewProps.BORDER_BOTTOM_COLOR)) {
                    b = 5;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = 6;
                }
                break;
            case -1141400650:
                if (str.equals("accessible")) {
                    b = 7;
                }
                break;
            case -1122140597:
                if (str.equals(ViewProps.BORDER_TOP_START_RADIUS)) {
                    b = 8;
                }
                break;
            case -867333731:
                if (str.equals(ViewProps.BORDER_BOTTOM_START_RADIUS)) {
                    b = 9;
                }
                break;
            case -679581037:
                if (str.equals("hasTVPreferredFocus")) {
                    b = 10;
                }
                break;
            case -631506969:
                if (str.equals("nextFocusDown")) {
                    b = Ascii.f3535VT;
                }
                break;
            case -631278772:
                if (str.equals("nextFocusLeft")) {
                    b = Ascii.f3524FF;
                }
                break;
            case -483490364:
                if (str.equals(ViewProps.BORDER_TOP_END_RADIUS)) {
                    b = Ascii.f3522CR;
                }
                break;
            case -329721498:
                if (str.equals("bbWidth")) {
                    b = Ascii.f3532SO;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    b = Ascii.f3531SI;
                }
                break;
            case -252105751:
                if (str.equals(ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS)) {
                    b = Ascii.DLE;
                }
                break;
            case -242276144:
                if (str.equals(ViewProps.BORDER_LEFT_COLOR)) {
                    b = 17;
                }
                break;
            case -223134121:
                if (str.equals(ViewProps.BORDER_START_END_RADIUS)) {
                    b = Ascii.DC2;
                }
                break;
            case -148030058:
                if (str.equals(ViewProps.BORDER_BOTTOM_END_RADIUS)) {
                    b = 19;
                }
                break;
            case -109689771:
                if (str.equals("nativeForegroundAndroid")) {
                    b = Ascii.DC4;
                }
                break;
            case -27894242:
                if (str.equals(ViewProps.BORDER_START_START_RADIUS)) {
                    b = Ascii.NAK;
                }
                break;
            case 3351622:
                if (str.equals("minX")) {
                    b = Ascii.SYN;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
                    b = Ascii.ETB;
                }
                break;
            case 92903173:
                if (str.equals("align")) {
                    b = Ascii.CAN;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = Ascii.f3523EM;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    b = Ascii.SUB;
                }
                break;
            case 306963138:
                if (str.equals(ViewProps.BORDER_BLOCK_START_COLOR)) {
                    b = Ascii.ESC;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 503397728:
                if (str.equals("nextFocusForward")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = Ascii.f3530RS;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = Ascii.f3534US;
                }
                break;
            case 660795168:
                if (str.equals("nextFocusUp")) {
                    b = 32;
                }
                break;
            case 684610594:
                if (str.equals(ViewProps.BORDER_BLOCK_COLOR)) {
                    b = 33;
                }
                break;
            case 722830999:
                if (str.equals(ViewProps.BORDER_COLOR)) {
                    b = 34;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 35;
                }
                break;
            case 762983977:
                if (str.equals(ViewProps.BORDER_BLOCK_END_COLOR)) {
                    b = 36;
                }
                break;
            case 910681861:
                if (str.equals(ViewProps.BORDER_END_START_RADIUS)) {
                    b = 37;
                }
                break;
            case 926871597:
                if (str.equals("hitSlop")) {
                    b = 38;
                }
                break;
            case 1220735892:
                if (str.equals(ViewProps.BORDER_END_COLOR)) {
                    b = 39;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 40;
                }
                break;
            case 1629011506:
                if (str.equals("focusable")) {
                    b = 41;
                }
                break;
            case 1667773924:
                if (str.equals(ViewProps.NEEDS_OFFSCREEN_ALPHA_COMPOSITING)) {
                    b = 42;
                }
                break;
            case 1735382270:
                if (str.equals(ViewProps.BORDER_END_END_RADIUS)) {
                    b = 43;
                }
                break;
            case 1747724810:
                if (str.equals("nativeBackgroundAndroid")) {
                    b = 44;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    b = 45;
                }
                break;
            case 1910855543:
                if (str.equals("nextFocusRight")) {
                    b = 46;
                }
                break;
            case 2119889261:
                if (str.equals(ViewProps.BORDER_START_COLOR)) {
                    b = 47;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBbHeight(t, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderRightColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 2:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBackfaceVisibility(t, obj != null ? (String) obj : null);
                break;
            case 3:
                RNSVGSvgViewAndroidManagerInterface rNSVGSvgViewAndroidManagerInterface = (RNSVGSvgViewAndroidManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSvgViewAndroidManagerInterface.setVbHeight(t, fFloatValue);
                break;
            case 4:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 5:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 6:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopLeftRadius(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setAccessible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 8:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopStartRadius(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomStartRadius(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setHasTVPreferredFocus(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 11:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusDown(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 12:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusLeft(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 13:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopEndRadius(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBbWidth(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setRemoveClippedSubviews(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderLeftColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 18:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStartEndRadius(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomEndRadius(t, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNativeForegroundAndroid(t, (ReadableMap) obj);
                break;
            case 21:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStartStartRadius(t, new DynamicFromObject(obj));
                break;
            case 22:
                RNSVGSvgViewAndroidManagerInterface rNSVGSvgViewAndroidManagerInterface2 = (RNSVGSvgViewAndroidManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSvgViewAndroidManagerInterface2.setMinX(t, fFloatValue);
                break;
            case 23:
                RNSVGSvgViewAndroidManagerInterface rNSVGSvgViewAndroidManagerInterface3 = (RNSVGSvgViewAndroidManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSvgViewAndroidManagerInterface3.setMinY(t, fFloatValue);
                break;
            case 24:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setAlign(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 26:
                RNSVGSvgViewAndroidManagerInterface rNSVGSvgViewAndroidManagerInterface4 = (RNSVGSvgViewAndroidManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSvgViewAndroidManagerInterface4.setVbWidth(t, fFloatValue);
                break;
            case 27:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBlockStartColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 28:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopRightRadius(t, new DynamicFromObject(obj));
                break;
            case 29:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusForward(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 30:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomLeftRadius(t, new DynamicFromObject(obj));
                break;
            case 31:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomRightRadius(t, new DynamicFromObject(obj));
                break;
            case 32:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusUp(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 33:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBlockColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 34:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 35:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStyle(t, obj != null ? (String) obj : null);
                break;
            case 36:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBlockEndColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 37:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderEndStartRadius(t, new DynamicFromObject(obj));
                break;
            case 38:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setHitSlop(t, new DynamicFromObject(obj));
                break;
            case 39:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderEndColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 40:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderRadius(t, new DynamicFromObject(obj));
                break;
            case 41:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setFocusable(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 42:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNeedsOffscreenAlphaCompositing(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 43:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderEndEndRadius(t, new DynamicFromObject(obj));
                break;
            case 44:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNativeBackgroundAndroid(t, (ReadableMap) obj);
                break;
            case 45:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setMeetOrSlice(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 46:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusRight(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 47:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStartColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
