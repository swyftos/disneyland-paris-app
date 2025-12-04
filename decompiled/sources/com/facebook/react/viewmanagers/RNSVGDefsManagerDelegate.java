package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGDefsManagerInterface;

/* loaded from: classes3.dex */
public class RNSVGDefsManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGDefsManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGDefsManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "opacity":
                this.mViewManager.setOpacity(t, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case "matrix":
                ((RNSVGDefsManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case "markerEnd":
                ((RNSVGDefsManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case "markerMid":
                ((RNSVGDefsManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case "pointerEvents":
                ((RNSVGDefsManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case "mask":
                ((RNSVGDefsManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case "name":
                ((RNSVGDefsManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case "markerStart":
                ((RNSVGDefsManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case "clipPath":
                ((RNSVGDefsManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case "clipRule":
                ((RNSVGDefsManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "display":
                ((RNSVGDefsManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case "responsible":
                ((RNSVGDefsManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
