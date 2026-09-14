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
import com.facebook.react.viewmanagers.RNSVGMaskManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGMaskManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGMaskManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGMaskManagerDelegate(BaseViewManager baseViewManager) {
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
            case -1274492040:
                if (str.equals(ViewProps.FILTER)) {
                    b = 0;
                }
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    b = 1;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = 2;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 3;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 4;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 5;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 6;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 7;
                }
                break;
            case -734428249:
                if (str.equals(ViewProps.FONT_WEIGHT)) {
                    b = 8;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = 9;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = 10;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    b = Ascii.f3535VT;
                }
                break;
            case -61221917:
                if (str.equals("maskUnits")) {
                    b = Ascii.f3524FF;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = Ascii.f3522CR;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = Ascii.f3532SO;
                }
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                if (str.equals("x")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = Ascii.DLE;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = 17;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = Ascii.DC2;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 19;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.DC4;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = Ascii.NAK;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = Ascii.SYN;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = Ascii.ETB;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = Ascii.CAN;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = Ascii.f3523EM;
                }
                break;
            case 275100742:
                if (str.equals("maskType")) {
                    b = Ascii.SUB;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    b = Ascii.ESC;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = Ascii.f3530RS;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = Ascii.f3534US;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = 32;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 33;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 34;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 35;
                }
                break;
            case 2037673858:
                if (str.equals("maskContentUnits")) {
                    b = 36;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGMaskManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGMaskManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGMaskManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGMaskManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGMaskManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGMaskManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 10:
                ((RNSVGMaskManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGMaskManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMaskUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 13:
                ((RNSVGMaskManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                RNSVGMaskManagerInterface rNSVGMaskManagerInterface = (RNSVGMaskManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMaskManagerInterface.setStrokeDashoffset(t, fFloatValue);
                break;
            case 15:
                ((RNSVGMaskManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGMaskManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGMaskManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGMaskManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 20:
                ((RNSVGMaskManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 21:
                RNSVGMaskManagerInterface rNSVGMaskManagerInterface2 = (RNSVGMaskManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMaskManagerInterface2.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 22:
                ((RNSVGMaskManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 23:
                ((RNSVGMaskManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 24:
                ((RNSVGMaskManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 25:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 26:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMaskType(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 27:
                ((RNSVGMaskManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 28:
                ((RNSVGMaskManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 29:
                ((RNSVGMaskManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSVGMaskManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 31:
                ((RNSVGMaskManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 32:
                ((RNSVGMaskManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 33:
                ((RNSVGMaskManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 34:
                ((RNSVGMaskManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 35:
                ((RNSVGMaskManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            case 36:
                ((RNSVGMaskManagerInterface) this.mViewManager).setMaskContentUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
