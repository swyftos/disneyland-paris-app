package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGSymbolManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGSymbolManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGSymbolManagerDelegate(BaseViewManager baseViewManager) {
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
            case 3143043:
                if (str.equals("fill")) {
                    b = Ascii.f3532SO;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = Ascii.DLE;
                }
                break;
            case 3351622:
                if (str.equals("minX")) {
                    b = 17;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
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
            case 92903173:
                if (str.equals("align")) {
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
            case 217109576:
                if (str.equals("markerStart")) {
                    b = Ascii.CAN;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    b = Ascii.f3523EM;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    b = Ascii.SUB;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = Ascii.ESC;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = Ascii.f3530RS;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = Ascii.f3534US;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 32;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 33;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    b = 34;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 35;
                }
                break;
        }
        switch (b) {
            case 0:
                RNSVGSymbolManagerInterface rNSVGSymbolManagerInterface = (RNSVGSymbolManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSymbolManagerInterface.setVbHeight(t, fFloatValue);
                break;
            case 1:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 10:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 13:
                RNSVGSymbolManagerInterface rNSVGSymbolManagerInterface2 = (RNSVGSymbolManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSymbolManagerInterface2.setStrokeDashoffset(t, fFloatValue);
                break;
            case 14:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 17:
                RNSVGSymbolManagerInterface rNSVGSymbolManagerInterface3 = (RNSVGSymbolManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSymbolManagerInterface3.setMinX(t, fFloatValue);
                break;
            case 18:
                RNSVGSymbolManagerInterface rNSVGSymbolManagerInterface4 = (RNSVGSymbolManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSymbolManagerInterface4.setMinY(t, fFloatValue);
                break;
            case 19:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 20:
                RNSVGSymbolManagerInterface rNSVGSymbolManagerInterface5 = (RNSVGSymbolManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSymbolManagerInterface5.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 21:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setAlign(t, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 23:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 24:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 25:
                RNSVGSymbolManagerInterface rNSVGSymbolManagerInterface6 = (RNSVGSymbolManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGSymbolManagerInterface6.setVbWidth(t, fFloatValue);
                break;
            case 26:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 27:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 28:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 30:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 31:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 32:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 33:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 34:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setMeetOrSlice(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 35:
                ((RNSVGSymbolManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
