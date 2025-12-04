package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes3.dex */
public class RNMapsPolylineManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsPolylineManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsPolylineManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "strokeColors":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setStrokeColors(t, (ReadableArray) obj);
                break;
            case "tappable":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setTappable(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "lineCap":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setLineCap(t, (String) obj);
                break;
            case "lineDashPattern":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setLineDashPattern(t, (ReadableArray) obj);
                break;
            case "lineJoin":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setLineJoin(t, (String) obj);
                break;
            case "geodesic":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setGeodesic(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "coordinates":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setCoordinates(t, (ReadableArray) obj);
                break;
            case "strokeColor":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setStrokeColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "strokeWidth":
                ((RNMapsPolylineManagerInterface) this.mViewManager).setStrokeWidth(t, obj == null ? BitmapDescriptorFactory.HUE_RED : ((Double) obj).floatValue());
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
