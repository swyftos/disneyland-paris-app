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
import com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGForeignObjectManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGForeignObjectManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGForeignObjectManagerDelegate(BaseViewManager baseViewManager) {
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
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = Ascii.f3524FF;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = Ascii.f3522CR;
                }
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                if (str.equals("x")) {
                    b = Ascii.f3532SO;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = Ascii.DLE;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = 17;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = Ascii.DC2;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 19;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = Ascii.DC4;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = Ascii.NAK;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = Ascii.SYN;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = Ascii.ETB;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = Ascii.CAN;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    b = Ascii.f3523EM;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = Ascii.SUB;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = Ascii.ESC;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = Ascii.f3530RS;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = Ascii.f3534US;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 32;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 33;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 10:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 13:
                RNSVGForeignObjectManagerInterface rNSVGForeignObjectManagerInterface = (RNSVGForeignObjectManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGForeignObjectManagerInterface.setStrokeDashoffset(t, fFloatValue);
                break;
            case 14:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 20:
                RNSVGForeignObjectManagerInterface rNSVGForeignObjectManagerInterface2 = (RNSVGForeignObjectManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGForeignObjectManagerInterface2.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 21:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 22:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 23:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 24:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 27:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 30:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 31:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 32:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 33:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
