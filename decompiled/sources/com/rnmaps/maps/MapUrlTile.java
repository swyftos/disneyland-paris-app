package com.rnmaps.maps;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes4.dex */
public class MapUrlTile extends MapFeature {
    protected Context context;
    protected boolean customTileProviderNeeded;
    protected boolean doubleTileSize;
    protected boolean flipY;
    protected int maximumNativeZ;
    protected int maximumZ;
    protected int minimumZ;
    protected boolean offlineMode;
    protected float opacity;
    protected int tileCacheMaxAge;
    protected String tileCachePath;
    protected TileOverlay tileOverlay;
    protected TileOverlayOptions tileOverlayOptions;
    protected MapTileProvider tileProvider;
    protected int tileSize;
    protected String urlTemplate;
    protected float zIndex;

    public MapUrlTile(Context context) {
        super(context);
        this.maximumNativeZ = 100;
        this.flipY = false;
        this.tileSize = 256;
        this.doubleTileSize = false;
        this.offlineMode = false;
        this.opacity = 1.0f;
        this.customTileProviderNeeded = false;
        this.context = context;
    }

    public void setUrlTemplate(String str) {
        this.urlTemplate = str;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setUrlTemplate(str);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.setZIndex(f);
        }
    }

    public void setMaximumZ(int i) {
        this.maximumZ = i;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setMaximumZ(i);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setMaximumNativeZ(int i) {
        this.maximumNativeZ = i;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setMaximumNativeZ(i);
        }
        setCustomTileProviderMode();
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setMinimumZ(int i) {
        this.minimumZ = i;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setMinimumZ(i);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setFlipY(boolean z) {
        this.flipY = z;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setFlipY(z);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setDoubleTileSize(boolean z) {
        this.doubleTileSize = z;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setDoubleTileSize(z);
        }
        setCustomTileProviderMode();
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setTileSize(int i) {
        this.tileSize = i;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setTileSize(i);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setTileCachePath(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            this.tileCachePath = new URL(str).getPath();
        } catch (MalformedURLException unused) {
            this.tileCachePath = str;
        } catch (Exception unused2) {
            return;
        }
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setTileCachePath(str);
        }
        setCustomTileProviderMode();
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setTileCacheMaxAge(int i) {
        this.tileCacheMaxAge = i;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setTileCacheMaxAge(i);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setOfflineMode(boolean z) {
        this.offlineMode = z;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setOfflineMode(z);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setOpacity(float f) {
        this.opacity = f;
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.setTransparency(1.0f - f);
        }
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.tileOverlayOptions == null) {
            this.tileOverlayOptions = createTileOverlayOptions();
        }
        return this.tileOverlayOptions;
    }

    protected void setCustomTileProviderMode() {
        Log.d("urlTile ", "creating new mode TileProvider");
        this.customTileProviderNeeded = true;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setCustomMode();
        }
    }

    protected TileOverlayOptions createTileOverlayOptions() {
        Log.d("urlTile ", "creating TileProvider");
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.zIndex);
        tileOverlayOptions.transparency(1.0f - this.opacity);
        MapTileProvider mapTileProvider = new MapTileProvider(this.tileSize, this.doubleTileSize, this.urlTemplate, this.maximumZ, this.maximumNativeZ, this.minimumZ, this.flipY, this.tileCachePath, this.tileCacheMaxAge, this.offlineMode, this.context, this.customTileProviderNeeded);
        this.tileProvider = mapTileProvider;
        tileOverlayOptions.tileProvider(mapTileProvider);
        return tileOverlayOptions;
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.tileOverlay;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void addToMap(Object obj) {
        this.tileOverlay = ((GoogleMap) obj).addTileOverlay(getTileOverlayOptions());
    }

    @Override // com.rnmaps.maps.MapFeature
    public void removeFromMap(Object obj) {
        this.tileOverlay.remove();
    }
}
