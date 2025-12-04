package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface;

/* loaded from: classes3.dex */
public class RNSVGFeOffsetManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeOffsetManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeOffsetManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "height":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setResult(t, obj != null ? (String) obj : null);
                break;
            case "x":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case "dx":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setDx(t, new DynamicFromObject(obj));
                break;
            case "dy":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setDy(t, new DynamicFromObject(obj));
                break;
            case "in1":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setIn1(t, obj != null ? (String) obj : null);
                break;
            case "width":
                ((RNSVGFeOffsetManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
