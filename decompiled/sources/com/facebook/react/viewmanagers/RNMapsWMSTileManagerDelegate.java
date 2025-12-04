package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface;

/* loaded from: classes3.dex */
public class RNMapsWMSTileManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsWMSTileManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsWMSTileManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "tileSize":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setTileSize(t, obj == null ? 256 : ((Double) obj).intValue());
                break;
            case "minimumZ":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setMinimumZ(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "tileCachePath":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setTileCachePath(t, obj != null ? (String) obj : null);
                break;
            case "maximumNativeZ":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setMaximumNativeZ(t, obj != null ? ((Double) obj).intValue() : 100);
                break;
            case "urlTemplate":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setUrlTemplate(t, obj != null ? (String) obj : null);
                break;
            case "shouldReplaceMapContent":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setShouldReplaceMapContent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "maximumZ":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setMaximumZ(t, obj != null ? ((Double) obj).intValue() : 100);
                break;
            case "offlineMode":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setOfflineMode(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "tileCacheMaxAge":
                ((RNMapsWMSTileManagerInterface) this.mViewManager).setTileCacheMaxAge(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
