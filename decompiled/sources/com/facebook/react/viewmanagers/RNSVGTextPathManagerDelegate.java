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
import com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class RNSVGTextPathManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGTextPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGTextPathManagerDelegate(BaseViewManager baseViewManager) {
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
            case -2012158909:
                if (str.equals("spacing")) {
                    c = 0;
                    break;
                }
                break;
            case -1993948267:
                if (str.equals("startOffset")) {
                    c = 1;
                    break;
                }
                break;
            case -1603134955:
                if (str.equals("lengthAdjust")) {
                    c = 2;
                    break;
                }
                break;
            case -1274492040:
                if (str.equals(ViewProps.FILTER)) {
                    c = 3;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    c = 4;
                    break;
                }
                break;
            case -1171891896:
                if (str.equals("alignmentBaseline")) {
                    c = 5;
                    break;
                }
                break;
            case -1139902161:
                if (str.equals("verticalAlign")) {
                    c = 6;
                    break;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    c = 7;
                    break;
                }
                break;
            case -1077554975:
                if (str.equals("method")) {
                    c = '\b';
                    break;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    c = '\t';
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c = '\n';
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c = 11;
                    break;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    c = '\f';
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case -734428249:
                if (str.equals(ViewProps.FONT_WEIGHT)) {
                    c = 14;
                    break;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    c = 15;
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c = 16;
                    break;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    c = 17;
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c = 18;
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    c = 19;
                    break;
                }
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                if (str.equals("x")) {
                    c = 20;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c = 21;
                    break;
                }
                break;
            case 3220:
                if (str.equals("dx")) {
                    c = 22;
                    break;
                }
                break;
            case 3221:
                if (str.equals("dy")) {
                    c = 23;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c = 24;
                    break;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    c = 25;
                    break;
                }
                break;
            case 3211051:
                if (str.equals("href")) {
                    c = 26;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c = 27;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 28;
                    break;
                }
                break;
            case 3530071:
                if (str.equals("side")) {
                    c = 29;
                    break;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    c = 30;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 31;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c = ' ';
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c = '!';
                    break;
                }
                break;
            case 275888445:
                if (str.equals("baselineShift")) {
                    c = '\"';
                    break;
                }
                break;
            case 365601008:
                if (str.equals(ViewProps.FONT_SIZE)) {
                    c = '#';
                    break;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c = '$';
                    break;
                }
                break;
            case 778043962:
                if (str.equals("inlineSize")) {
                    c = CoreConstants.PERCENT_CHAR;
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c = CoreConstants.SINGLE_QUOTE_CHAR;
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c = CoreConstants.LEFT_PARENTHESIS_CHAR;
                    break;
                }
                break;
            case 1054434908:
                if (str.equals("midLine")) {
                    c = CoreConstants.RIGHT_PARENTHESIS_CHAR;
                    break;
                }
                break;
            case 1637488243:
                if (str.equals("textLength")) {
                    c = '*';
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c = '+';
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c = ',';
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c = '-';
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c = '.';
                    break;
                }
                break;
        }
        switch (c) {
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
            case '\b':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMethod(t, obj != null ? (String) obj : null);
                break;
            case '\t':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case '\n':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case '\f':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setRotate(t, new DynamicFromObject(obj));
                break;
            case '\r':
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
            case ' ':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '!':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case '\"':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setBaselineShift(t, new DynamicFromObject(obj));
                break;
            case '#':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case '$':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case '%':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setInlineSize(t, new DynamicFromObject(obj));
                break;
            case '&':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case '\'':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '(':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case ')':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMidLine(t, obj != null ? (String) obj : null);
                break;
            case '*':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setTextLength(t, new DynamicFromObject(obj));
                break;
            case '+':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case ',':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '-':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '.':
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
