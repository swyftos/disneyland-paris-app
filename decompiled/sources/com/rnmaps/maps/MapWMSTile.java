package com.rnmaps.maps;

import android.content.Context;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes4.dex */
public class MapWMSTile extends MapUrlTile {
    private static final double[] mapBound = {-2.003750834789244E7d, 2.003750834789244E7d};

    class AIRMapGSUrlTileProvider extends MapTileProvider {

        class AIRMapWMSTileProvider extends UrlTileProvider {
            private final int tileSize;
            private String urlTemplate;

            public AIRMapWMSTileProvider(int i, int i2, String str) {
                super(i, i2);
                this.urlTemplate = str;
                this.tileSize = i;
            }

            @Override // com.google.android.gms.maps.model.UrlTileProvider
            public URL getTileUrl(int i, int i2, int i3) {
                AIRMapGSUrlTileProvider aIRMapGSUrlTileProvider = AIRMapGSUrlTileProvider.this;
                MapWMSTile mapWMSTile = MapWMSTile.this;
                if (mapWMSTile.maximumZ > 0 && i3 > aIRMapGSUrlTileProvider.maximumZ) {
                    return null;
                }
                if (mapWMSTile.minimumZ > 0 && i3 < aIRMapGSUrlTileProvider.minimumZ) {
                    return null;
                }
                double[] boundingBox = getBoundingBox(i, i2, i3);
                try {
                    return new URL(this.urlTemplate.replace("{minX}", Double.toString(boundingBox[0])).replace("{minY}", Double.toString(boundingBox[1])).replace("{maxX}", Double.toString(boundingBox[2])).replace("{maxY}", Double.toString(boundingBox[3])).replace("{width}", Integer.toString(this.tileSize)).replace("{height}", Integer.toString(this.tileSize)));
                } catch (MalformedURLException e) {
                    throw new AssertionError(e);
                }
            }

            private double[] getBoundingBox(int i, int i2, int i3) {
                double dPow = 4.007501669578488E7d / Math.pow(2.0d, i3);
                return new double[]{MapWMSTile.mapBound[0] + (i * dPow), MapWMSTile.mapBound[1] - ((i2 + 1) * dPow), MapWMSTile.mapBound[0] + ((i + 1) * dPow), MapWMSTile.mapBound[1] - (i2 * dPow)};
            }
        }

        public AIRMapGSUrlTileProvider(int i, String str, int i2, int i3, int i4, String str2, int i5, boolean z, Context context, boolean z2) {
            super(i, false, str, i2, i3, i4, false, str2, i5, z, context, z2);
            this.tileProvider = new AIRMapWMSTileProvider(i, i, str);
        }
    }

    public MapWMSTile(Context context) {
        super(context);
    }

    @Override // com.rnmaps.maps.MapUrlTile
    protected TileOverlayOptions createTileOverlayOptions() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.zIndex);
        tileOverlayOptions.transparency(1.0f - this.opacity);
        tileOverlayOptions.tileProvider(new AIRMapGSUrlTileProvider(this.tileSize, this.urlTemplate, this.maximumZ, this.maximumNativeZ, this.minimumZ, this.tileCachePath, this.tileCacheMaxAge, this.offlineMode, this.context, this.customTileProviderNeeded));
        return tileOverlayOptions;
    }
}
