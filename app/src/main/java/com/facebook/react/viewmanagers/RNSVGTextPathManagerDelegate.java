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
import com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGTextPathManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGTextPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGTextPathManagerDelegate(BaseViewManager baseViewManager) {
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
            case -2012158909:
                if (str.equals("spacing")) {
                    b = 0;
                }
                break;
            case -1993948267:
                if (str.equals("startOffset")) {
                    b = 1;
                }
                break;
            case -1603134955:
                if (str.equals("lengthAdjust")) {
                    b = 2;
                }
                break;
            case -1274492040:
                if (str.equals(ViewProps.FILTER)) {
                    b = 3;
                }
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    b = 4;
                }
                break;
            case -1171891896:
                if (str.equals("alignmentBaseline")) {
                    b = 5;
                }
                break;
            case -1139902161:
                if (str.equals("verticalAlign")) {
                    b = 6;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 7;
                }
                break;
            case -1077554975:
                if (str.equals(TCEventPropertiesNames.TCE_METHOD)) {
                    b = 8;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 9;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 10;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = Ascii.f3535VT;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = Ascii.f3524FF;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = Ascii.f3522CR;
                }
                break;
            case -734428249:
                if (str.equals(ViewProps.FONT_WEIGHT)) {
                    b = Ascii.f3532SO;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = Ascii.f3531SI;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = Ascii.DLE;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    b = 17;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = Ascii.DC2;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = 19;
                }
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                if (str.equals("x")) {
                    b = Ascii.DC4;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = Ascii.NAK;
                }
                break;
            case 3220:
                if (str.equals("dx")) {
                    b = Ascii.SYN;
                }
                break;
            case 3221:
                if (str.equals("dy")) {
                    b = Ascii.ETB;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = Ascii.CAN;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = Ascii.f3523EM;
                }
                break;
            case 3211051:
                if (str.equals("href")) {
                    b = Ascii.SUB;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = Ascii.ESC;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.f3525FS;
                }
                break;
            case 3530071:
                if (str.equals("side")) {
                    b = Ascii.f3526GS;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = Ascii.f3530RS;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = Ascii.f3534US;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = 32;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 33;
                }
                break;
            case 275888445:
                if (str.equals("baselineShift")) {
                    b = 34;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    b = 35;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = 36;
                }
                break;
            case 778043962:
                if (str.equals("inlineSize")) {
                    b = 37;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 38;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 39;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 40;
                }
                break;
            case 1054434908:
                if (str.equals("midLine")) {
                    b = 41;
                }
                break;
            case 1637488243:
                if (str.equals("textLength")) {
                    b = 42;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = 43;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 44;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 45;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 46;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setSpacing(t, obj != null ? (String) obj : null);
                break;
            case 1:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStartOffset(t, new DynamicFromObject(obj));
                break;
            case 2:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setLengthAdjust(t, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 4:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 5:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setAlignmentBaseline(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setVerticalAlign(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 8:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMethod(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 10:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setRotate(t, new DynamicFromObject(obj));
                break;
            case 13:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 16:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 17:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 19:
                RNSVGTextPathManagerInterface rNSVGTextPathManagerInterface = (RNSVGTextPathManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGTextPathManagerInterface.setStrokeDashoffset(t, fFloatValue);
                break;
            case 20:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDx(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDy(t, new DynamicFromObject(obj));
                break;
            case 24:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 25:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setHref(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setSide(t, obj != null ? (String) obj : null);
                break;
            case 30:
                RNSVGTextPathManagerInterface rNSVGTextPathManagerInterface2 = (RNSVGTextPathManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGTextPathManagerInterface2.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 31:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 32:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 33:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setBaselineShift(t, new DynamicFromObject(obj));
                break;
            case 35:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 36:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 37:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setInlineSize(t, new DynamicFromObject(obj));
                break;
            case 38:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 39:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 41:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMidLine(t, obj != null ? (String) obj : null);
                break;
            case 42:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setTextLength(t, new DynamicFromObject(obj));
                break;
            case 43:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 44:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 45:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 46:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
