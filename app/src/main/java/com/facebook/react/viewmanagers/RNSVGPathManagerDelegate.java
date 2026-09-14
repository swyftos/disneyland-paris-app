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
import com.facebook.react.viewmanagers.RNSVGPathManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGPathManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGPathManagerDelegate(BaseViewManager baseViewManager) {
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
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 2;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 3;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 4;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 5;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 6;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = 7;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = 8;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    b = 9;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = 10;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = Ascii.f3535VT;
                }
                break;
            case 100:
                if (str.equals("d")) {
                    b = Ascii.f3524FF;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = Ascii.f3522CR;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = Ascii.f3532SO;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = Ascii.DLE;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 17;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = Ascii.DC2;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 19;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = Ascii.DC4;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = Ascii.NAK;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = Ascii.SYN;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = Ascii.ETB;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = Ascii.CAN;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = Ascii.f3523EM;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = Ascii.SUB;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = Ascii.ESC;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGPathManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGPathManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGPathManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGPathManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGPathManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGPathManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGPathManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 8:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 9:
                ((RNSVGPathManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSVGPathManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                RNSVGPathManagerInterface rNSVGPathManagerInterface = (RNSVGPathManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPathManagerInterface.setStrokeDashoffset(t, fFloatValue);
                break;
            case 12:
                ((RNSVGPathManagerInterface) this.mViewManager).setD(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGPathManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGPathManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSVGPathManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 16:
                RNSVGPathManagerInterface rNSVGPathManagerInterface2 = (RNSVGPathManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGPathManagerInterface2.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 17:
                ((RNSVGPathManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 18:
                ((RNSVGPathManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 19:
                ((RNSVGPathManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 20:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGPathManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSVGPathManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 23:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 24:
                ((RNSVGPathManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 26:
                ((RNSVGPathManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 27:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
