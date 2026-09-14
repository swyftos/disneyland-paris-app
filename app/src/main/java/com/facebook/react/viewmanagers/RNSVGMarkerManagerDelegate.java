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
import com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGMarkerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGMarkerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGMarkerManagerDelegate(BaseViewManager baseViewManager) {
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
            case -1008621499:
                if (str.equals("orient")) {
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
            case 3143043:
                if (str.equals("fill")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = Ascii.DLE;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 17;
                }
                break;
            case 3351622:
                if (str.equals("minX")) {
                    b = Ascii.DC2;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
                    b = 19;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.DC4;
                }
                break;
            case 3496485:
                if (str.equals("refX")) {
                    b = Ascii.NAK;
                }
                break;
            case 3496486:
                if (str.equals("refY")) {
                    b = Ascii.SYN;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
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
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = Ascii.SUB;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = Ascii.ESC;
                }
                break;
            case 218785621:
                if (str.equals("markerUnits")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 220478892:
                if (str.equals("markerWidth")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    b = Ascii.f3530RS;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    b = Ascii.f3534US;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = 32;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 33;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 34;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 35;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = 36;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 37;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 38;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    b = 39;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 40;
                }
                break;
            case 2106883585:
                if (str.equals("markerHeight")) {
                    b = 41;
                }
                break;
        }
        switch (b) {
            case 0:
                RNSVGMarkerManagerInterface rNSVGMarkerManagerInterface = (RNSVGMarkerManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMarkerManagerInterface.setVbHeight(t, fFloatValue);
                break;
            case 1:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setOrient(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 11:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 12:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                RNSVGMarkerManagerInterface rNSVGMarkerManagerInterface2 = (RNSVGMarkerManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMarkerManagerInterface2.setStrokeDashoffset(t, fFloatValue);
                break;
            case 15:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 18:
                RNSVGMarkerManagerInterface rNSVGMarkerManagerInterface3 = (RNSVGMarkerManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMarkerManagerInterface3.setMinX(t, fFloatValue);
                break;
            case 19:
                RNSVGMarkerManagerInterface rNSVGMarkerManagerInterface4 = (RNSVGMarkerManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMarkerManagerInterface4.setMinY(t, fFloatValue);
                break;
            case 20:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setRefX(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setRefY(t, new DynamicFromObject(obj));
                break;
            case 23:
                RNSVGMarkerManagerInterface rNSVGMarkerManagerInterface5 = (RNSVGMarkerManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMarkerManagerInterface5.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 24:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setAlign(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 26:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 27:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerUnits(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerWidth(t, new DynamicFromObject(obj));
                break;
            case 30:
                RNSVGMarkerManagerInterface rNSVGMarkerManagerInterface6 = (RNSVGMarkerManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGMarkerManagerInterface6.setVbWidth(t, fFloatValue);
                break;
            case 31:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 32:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 35:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 36:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 37:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 38:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 39:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMeetOrSlice(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            case 41:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerHeight(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
