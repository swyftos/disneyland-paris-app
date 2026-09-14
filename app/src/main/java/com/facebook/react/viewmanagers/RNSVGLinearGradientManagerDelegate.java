package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGLinearGradientManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGLinearGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGLinearGradientManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1932235233:
                if (str.equals("gradientUnits")) {
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
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 3;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 4;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    b = 5;
                }
                break;
            case 3769:
                if (str.equals("x1")) {
                    b = 6;
                }
                break;
            case 3770:
                if (str.equals("x2")) {
                    b = 7;
                }
                break;
            case 3800:
                if (str.equals("y1")) {
                    b = 8;
                }
                break;
            case 3801:
                if (str.equals("y2")) {
                    b = 9;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 10;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.f3535VT;
                }
                break;
            case 89650992:
                if (str.equals("gradient")) {
                    b = Ascii.f3524FF;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = Ascii.f3522CR;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = Ascii.f3532SO;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = Ascii.DLE;
                }
                break;
            case 1822665244:
                if (str.equals("gradientTransform")) {
                    b = 17;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = Ascii.DC2;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradientUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 2:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setX1(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setX2(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setY1(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setY2(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradient(t, (ReadableArray) obj);
                break;
            case 13:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 16:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradientTransform(t, (ReadableArray) obj);
                break;
            case 18:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
