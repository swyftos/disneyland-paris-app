package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes3.dex */
public class RNSVGFeGaussianBlurManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeGaussianBlurManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeGaussianBlurManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        float fFloatValue;
        str.hashCode();
        fFloatValue = BitmapDescriptorFactory.HUE_RED;
        switch (str) {
            case "height":
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setResult(t, obj != null ? (String) obj : null);
                break;
            case "x":
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case "in1":
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setIn1(t, obj != null ? (String) obj : null);
                break;
            case "width":
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case "edgeMode":
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setEdgeMode(t, (String) obj);
                break;
            case "stdDeviationX":
                RNSVGFeGaussianBlurManagerInterface rNSVGFeGaussianBlurManagerInterface = (RNSVGFeGaussianBlurManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGFeGaussianBlurManagerInterface.setStdDeviationX(t, fFloatValue);
                break;
            case "stdDeviationY":
                RNSVGFeGaussianBlurManagerInterface rNSVGFeGaussianBlurManagerInterface2 = (RNSVGFeGaussianBlurManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGFeGaussianBlurManagerInterface2.setStdDeviationY(t, fFloatValue);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
