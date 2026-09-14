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
import com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGTSpanManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGTSpanManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGTSpanManagerDelegate(BaseViewManager baseViewManager) {
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
            case -1603134955:
                if (str.equals("lengthAdjust")) {
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
            case -1171891896:
                if (str.equals("alignmentBaseline")) {
                    b = 3;
                }
                break;
            case -1139902161:
                if (str.equals("verticalAlign")) {
                    b = 4;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 5;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 6;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 7;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 8;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = 9;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 10;
                }
                break;
            case -734428249:
                if (str.equals(ViewProps.FONT_WEIGHT)) {
                    b = Ascii.f3535VT;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = Ascii.f3524FF;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = Ascii.f3522CR;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
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
            case 3220:
                if (str.equals("dx")) {
                    b = 19;
                }
                break;
            case 3221:
                if (str.equals("dy")) {
                    b = Ascii.DC4;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = Ascii.NAK;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = Ascii.SYN;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
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
            case 94842723:
                if (str.equals("color")) {
                    b = Ascii.SUB;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = Ascii.ESC;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 275888445:
                if (str.equals("baselineShift")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    b = Ascii.f3530RS;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = Ascii.f3534US;
                }
                break;
            case 778043962:
                if (str.equals("inlineSize")) {
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
            case 951530617:
                if (str.equals("content")) {
                    b = 35;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 36;
                }
                break;
            case 1637488243:
                if (str.equals("textLength")) {
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
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 41;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setLengthAdjust(t, obj != null ? (String) obj : null);
                break;
            case 1:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setAlignmentBaseline(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setVerticalAlign(t, new DynamicFromObject(obj));
                break;
            case 5:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 7:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setRotate(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 12:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 13:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 16:
                RNSVGTSpanManagerInterface rNSVGTSpanManagerInterface = (RNSVGTSpanManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGTSpanManagerInterface.setStrokeDashoffset(t, fFloatValue);
                break;
            case 17:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setDx(t, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setDy(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 25:
                RNSVGTSpanManagerInterface rNSVGTSpanManagerInterface2 = (RNSVGTSpanManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGTSpanManagerInterface2.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 26:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 27:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setBaselineShift(t, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 31:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 32:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setInlineSize(t, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 35:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setContent(t, obj != null ? (String) obj : null);
                break;
            case 36:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 37:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setTextLength(t, new DynamicFromObject(obj));
                break;
            case 38:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 39:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 41:
                ((RNSVGTSpanManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
