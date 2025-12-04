package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNMapsCircleManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes3.dex */
public class RNMapsCircleManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsCircleManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsCircleManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "center":
                ((RNMapsCircleManagerInterface) this.mViewManager).setCenter(t, (ReadableMap) obj);
                break;
            case "fillColor":
                ((RNMapsCircleManagerInterface) this.mViewManager).setFillColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "radius":
                ((RNMapsCircleManagerInterface) this.mViewManager).setRadius(t, obj == null ? Double.NaN : ((Double) obj).doubleValue());
                break;
            case "tappable":
                ((RNMapsCircleManagerInterface) this.mViewManager).setTappable(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "strokeColor":
                ((RNMapsCircleManagerInterface) this.mViewManager).setStrokeColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "strokeWidth":
                ((RNMapsCircleManagerInterface) this.mViewManager).setStrokeWidth(t, obj == null ? BitmapDescriptorFactory.HUE_RED : ((Double) obj).floatValue());
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
