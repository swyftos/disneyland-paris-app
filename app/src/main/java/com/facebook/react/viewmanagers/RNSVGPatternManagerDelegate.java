package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSVGPatternManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGPatternManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGPatternManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGPatternManagerDelegate(BaseViewManager baseViewManager) {
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
            case -1567958285:
                if (str.equals("vbHeight")) {
                    b = 0;
                }
                break;
            case -1274492040:
                if (str.equals(ViewProps.FILTER)) {
                    b = 1;
                }
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    b = 2;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = 3;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 4;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 5;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 6;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 7;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 8;
                }
                break;
            case -734428249:
                if (str.equals(ViewProps.FONT_WEIGHT)) {
                    b = 9;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = 10;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = Ascii.f3535VT;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    b = Ascii.f3524FF;
                }
                break;
            case -207800897:
                if (str.equals("patternUnits")) {
                    b = Ascii.f3522CR;
                }
                break;
            case -128680410:
                if (str.equals("patternContentUnits")) {
                    b = Ascii.f3532SO;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = Ascii.f3531SI;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = Ascii.DLE;
                }
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                if (str.equals("x")) {
                    b = 17;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = Ascii.DC2;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = 19;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = Ascii.DC4;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
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
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.CAN;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = Ascii.f3523EM;
                }
                break;
            case 92903173:
                if (str.equals("align")) {
                    b = Ascii.SUB;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = Ascii.ESC;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = Ascii.f3530RS;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    b = Ascii.f3534US;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    b = 32;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = 33;
                }
                break;
            case 746561980:
                if (str.equals("patternTransform")) {
                    b = 34;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 35;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 36;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 37;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = 38;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 39;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 40;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    b = 41;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 42;
                }
                break;
        }
        switch (b) {
            case 0:
                RNSVGPatternManagerInterface rNSVGPatternManagerInterface = (RNSVGPatternManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPatternManagerInterface.setVbHeight(t, fFloatValue);
                break;
            case 1:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGPatternManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 11:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 12:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPatternUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 14:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPatternContentUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 15:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 16:
                RNSVGPatternManagerInterface rNSVGPatternManagerInterface2 = (RNSVGPatternManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPatternManagerInterface2.setStrokeDashoffset(t, fFloatValue);
                break;
            case 17:
                ((RNSVGPatternManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGPatternManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 22:
                RNSVGPatternManagerInterface rNSVGPatternManagerInterface3 = (RNSVGPatternManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPatternManagerInterface3.setMinX(t, fFloatValue);
                break;
            case 23:
                RNSVGPatternManagerInterface rNSVGPatternManagerInterface4 = (RNSVGPatternManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPatternManagerInterface4.setMinY(t, fFloatValue);
                break;
            case 24:
                ((RNSVGPatternManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 25:
                RNSVGPatternManagerInterface rNSVGPatternManagerInterface5 = (RNSVGPatternManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPatternManagerInterface5.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 26:
                ((RNSVGPatternManagerInterface) this.mViewManager).setAlign(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGPatternManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 28:
                ((RNSVGPatternManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSVGPatternManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 31:
                RNSVGPatternManagerInterface rNSVGPatternManagerInterface6 = (RNSVGPatternManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPatternManagerInterface6.setVbWidth(t, fFloatValue);
                break;
            case 32:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 34:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPatternTransform(t, (ReadableArray) obj);
                break;
            case 35:
                ((RNSVGPatternManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 36:
                ((RNSVGPatternManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 37:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 38:
                ((RNSVGPatternManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 39:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGPatternManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 41:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMeetOrSlice(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 42:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
