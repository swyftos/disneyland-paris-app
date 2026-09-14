package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSVGDefsManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGDefsManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGDefsManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGDefsManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    b = 0;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 1;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 2;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 3;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    b = 4;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 5;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 6;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 7;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 8;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 9;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    b = 10;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = Ascii.f3535VT;
                }
                break;
        }
        switch (b) {
            case 0:
                this.mViewManager.setOpacity(t, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 1:
                ((RNSVGDefsManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 2:
                ((RNSVGDefsManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSVGDefsManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGDefsManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGDefsManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGDefsManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGDefsManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGDefsManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGDefsManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 10:
                ((RNSVGDefsManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGDefsManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
