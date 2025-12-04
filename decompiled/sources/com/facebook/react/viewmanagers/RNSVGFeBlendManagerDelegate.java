package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface;

/* loaded from: classes3.dex */
public class RNSVGFeBlendManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeBlendManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeBlendManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "height":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setResult(t, obj != null ? (String) obj : null);
                break;
            case "x":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case "in1":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setIn1(t, obj != null ? (String) obj : null);
                break;
            case "in2":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setIn2(t, obj != null ? (String) obj : null);
                break;
            case "mode":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setMode(t, (String) obj);
                break;
            case "width":
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
