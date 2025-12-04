package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSVGTextManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class RNSVGTextManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGTextManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGTextManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        float fFloatValue = BitmapDescriptorFactory.HUE_RED;
        char c = 65535;
        switch (str.hashCode()) {
            case -1603134955:
                if (str.equals("lengthAdjust")) {
                    c = 0;
                    break;
                }
                break;
            case -1274492040:
                if (str.equals(ViewProps.FILTER)) {
                    c = 1;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    c = 2;
                    break;
                }
                break;
            case -1171891896:
                if (str.equals("alignmentBaseline")) {
                    c = 3;
                    break;
                }
                break;
            case -1139902161:
                if (str.equals("verticalAlign")) {
                    c = 4;
                    break;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    c = 5;
                    break;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    c = 6;
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c = 7;
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c = '\b';
                    break;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    c = '\t';
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    c = '\n';
                    break;
                }
                break;
            case -734428249:
                if (str.equals(ViewProps.FONT_WEIGHT)) {
                    c = 11;
                    break;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    c = '\f';
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    c = 14;
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c = 15;
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    c = 16;
                    break;
                }
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                if (str.equals("x")) {
                    c = 17;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c = 18;
                    break;
                }
                break;
            case 3220:
                if (str.equals("dx")) {
                    c = 19;
                    break;
                }
                break;
            case 3221:
                if (str.equals("dy")) {
                    c = 20;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c = 21;
                    break;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    c = 22;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c = 23;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 24;
                    break;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    c = 25;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 26;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c = 27;
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c = 28;
                    break;
                }
                break;
            case 275888445:
                if (str.equals("baselineShift")) {
                    c = 29;
                    break;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    c = 30;
                    break;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c = 31;
                    break;
                }
                break;
            case 778043962:
                if (str.equals("inlineSize")) {
                    c = ' ';
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c = '!';
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c = '\"';
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c = '#';
                    break;
                }
                break;
            case 1637488243:
                if (str.equals("textLength")) {
                    c = '$';
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c = CoreConstants.PERCENT_CHAR;
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c = CoreConstants.SINGLE_QUOTE_CHAR;
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c = CoreConstants.LEFT_PARENTHESIS_CHAR;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNSVGTextManagerInterface) this.mViewManager).setLengthAdjust(t, obj != null ? (String) obj : null);
                break;
            case 1:
                ((RNSVGTextManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGTextManagerInterface) this.mViewManager).setAlignmentBaseline(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGTextManagerInterface) this.mViewManager).setVerticalAlign(t, new DynamicFromObject(obj));
                break;
            case 5:
                ((RNSVGTextManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGTextManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 7:
                ((RNSVGTextManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case '\b':
                ((RNSVGTextManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case '\t':
                ((RNSVGTextManagerInterface) this.mViewManager).setRotate(t, new DynamicFromObject(obj));
                break;
            case '\n':
                ((RNSVGTextManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNSVGTextManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case '\f':
                ((RNSVGTextManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case '\r':
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                ((RNSVGTextManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSVGTextManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 16:
                RNSVGTextManagerInterface rNSVGTextManagerInterface = (RNSVGTextManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGTextManagerInterface.setStrokeDashoffset(t, fFloatValue);
                break;
            case 17:
                ((RNSVGTextManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGTextManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGTextManagerInterface) this.mViewManager).setDx(t, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGTextManagerInterface) this.mViewManager).setDy(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGTextManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGTextManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGTextManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSVGTextManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 25:
                RNSVGTextManagerInterface rNSVGTextManagerInterface2 = (RNSVGTextManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGTextManagerInterface2.setStrokeMiterlimit(t, fFloatValue);
                break;
            case 26:
                ((RNSVGTextManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 27:
                ((RNSVGTextManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGTextManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGTextManagerInterface) this.mViewManager).setBaselineShift(t, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGTextManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 31:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case ' ':
                ((RNSVGTextManagerInterface) this.mViewManager).setInlineSize(t, new DynamicFromObject(obj));
                break;
            case '!':
                ((RNSVGTextManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case '\"':
                ((RNSVGTextManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '#':
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '$':
                ((RNSVGTextManagerInterface) this.mViewManager).setTextLength(t, new DynamicFromObject(obj));
                break;
            case '%':
                ((RNSVGTextManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case '&':
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '\'':
                ((RNSVGTextManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '(':
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
