package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNMapsUrlTileManagerInterface;

/* loaded from: classes3.dex */
public class RNMapsUrlTileManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsUrlTileManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsUrlTileManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "tileSize":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setTileSize(t, obj == null ? 256 : ((Double) obj).intValue());
                break;
            case "minimumZ":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setMinimumZ(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "tileCachePath":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setTileCachePath(t, obj != null ? (String) obj : null);
                break;
            case "maximumNativeZ":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setMaximumNativeZ(t, obj != null ? ((Double) obj).intValue() : 100);
                break;
            case "flipY":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setFlipY(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "urlTemplate":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setUrlTemplate(t, obj != null ? (String) obj : null);
                break;
            case "shouldReplaceMapContent":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setShouldReplaceMapContent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "maximumZ":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setMaximumZ(t, obj != null ? ((Double) obj).intValue() : 100);
                break;
            case "doubleTileSize":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setDoubleTileSize(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "offlineMode":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setOfflineMode(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "tileCacheMaxAge":
                ((RNMapsUrlTileManagerInterface) this.mViewManager).setTileCacheMaxAge(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
