package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface;

/* loaded from: classes3.dex */
public class RNMapsGooglePolygonManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsGooglePolygonManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsGooglePolygonManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "fillColor":
                ((RNMapsGooglePolygonManagerInterface) this.mViewManager).setFillColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "tappable":
                ((RNMapsGooglePolygonManagerInterface) this.mViewManager).setTappable(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "holes":
                ((RNMapsGooglePolygonManagerInterface) this.mViewManager).setHoles(t, (ReadableArray) obj);
                break;
            case "geodesic":
                ((RNMapsGooglePolygonManagerInterface) this.mViewManager).setGeodesic(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "coordinates":
                ((RNMapsGooglePolygonManagerInterface) this.mViewManager).setCoordinates(t, (ReadableArray) obj);
                break;
            case "strokeColor":
                ((RNMapsGooglePolygonManagerInterface) this.mViewManager).setStrokeColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
