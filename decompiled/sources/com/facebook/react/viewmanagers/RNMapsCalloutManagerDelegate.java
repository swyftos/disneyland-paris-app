package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNMapsCalloutManagerInterface;

/* loaded from: classes3.dex */
public class RNMapsCalloutManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsCalloutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsCalloutManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        if (str.equals("tooltip")) {
            ((RNMapsCalloutManagerInterface) this.mViewManager).setTooltip(t, obj != null ? ((Boolean) obj).booleanValue() : false);
        } else if (str.equals("alphaHitTest")) {
            ((RNMapsCalloutManagerInterface) this.mViewManager).setAlphaHitTest(t, obj != null ? ((Boolean) obj).booleanValue() : false);
        } else {
            super.kotlinCompat$setProperty(t, str, obj);
        }
    }
}
