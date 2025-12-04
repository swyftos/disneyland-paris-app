package com.rnmaps.maps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;

/* loaded from: classes4.dex */
public class MapLocalTile extends MapFeature {
    private String pathTemplate;
    private TileOverlay tileOverlay;
    private TileOverlayOptions tileOverlayOptions;
    private AIRMapLocalTileProvider tileProvider;
    private float tileSize;
    private boolean useAssets;
    private float zIndex;

    class AIRMapLocalTileProvider implements TileProvider {
        private String pathTemplate;
        private int tileSize;
        private final boolean useAssets;

        public AIRMapLocalTileProvider(int i, String str, boolean z) {
            this.tileSize = i;
            this.pathTemplate = str;
            this.useAssets = z;
        }

        @Override // com.google.android.gms.maps.model.TileProvider
        public Tile getTile(int i, int i2, int i3) throws Throwable {
            byte[] tileImage = readTileImage(i, i2, i3);
            if (tileImage == null) {
                return TileProvider.NO_TILE;
            }
            int i4 = this.tileSize;
            return new Tile(i4, i4, tileImage);
        }

        public void setPathTemplate(String str) {
            this.pathTemplate = str;
        }

        public void setTileSize(int i) {
            this.tileSize = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private byte[] readTileImage(int r6, int r7, int r8) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.String r6 = r5.getTileFilename(r6, r7, r8)
                r7 = 0
                boolean r8 = r5.useAssets     // Catch: java.lang.Throwable -> L18 java.lang.Throwable -> L1c
                if (r8 == 0) goto L20
                com.rnmaps.maps.MapLocalTile r5 = com.rnmaps.maps.MapLocalTile.this     // Catch: java.lang.Throwable -> L18 java.lang.Throwable -> L1c
                android.content.Context r5 = r5.getContext()     // Catch: java.lang.Throwable -> L18 java.lang.Throwable -> L1c
                android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L18 java.lang.Throwable -> L1c
                java.io.InputStream r5 = r5.open(r6)     // Catch: java.lang.Throwable -> L18 java.lang.Throwable -> L1c
                goto L25
            L18:
                r5 = move-exception
                r6 = r7
                goto L6f
            L1c:
                r5 = move-exception
                r6 = r7
                r8 = r6
                goto L5e
            L20:
                java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L18 java.lang.Throwable -> L1c
                r5.<init>(r6)     // Catch: java.lang.Throwable -> L18 java.lang.Throwable -> L1c
            L25:
                java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L59
                r6.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L59
                r8 = 16384(0x4000, float:2.2959E-41)
                byte[] r0 = new byte[r8]     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
            L2e:
                r1 = 0
                int r2 = r5.read(r0, r1, r8)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
                r3 = -1
                if (r2 == r3) goto L45
                r6.write(r0, r1, r2)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
                goto L2e
            L3a:
                r7 = move-exception
                r4 = r7
                r7 = r5
                r5 = r4
                goto L6f
            L3f:
                r8 = move-exception
                r4 = r6
                r6 = r5
                r5 = r8
                r8 = r4
                goto L5e
            L45:
                r6.flush()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
                byte[] r7 = r6.toByteArray()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
                r5.close()     // Catch: java.lang.Exception -> L4f
            L4f:
                r6.close()     // Catch: java.lang.Exception -> L52
            L52:
                return r7
            L53:
                r6 = move-exception
                r4 = r7
                r7 = r5
                r5 = r6
                r6 = r4
                goto L6f
            L59:
                r6 = move-exception
                r8 = r7
                r4 = r6
                r6 = r5
                r5 = r4
            L5e:
                r5.printStackTrace()     // Catch: java.lang.Throwable -> L6c
                if (r6 == 0) goto L66
                r6.close()     // Catch: java.lang.Exception -> L66
            L66:
                if (r8 == 0) goto L6b
                r8.close()     // Catch: java.lang.Exception -> L6b
            L6b:
                return r7
            L6c:
                r5 = move-exception
                r7 = r6
                r6 = r8
            L6f:
                if (r7 == 0) goto L74
                r7.close()     // Catch: java.lang.Exception -> L74
            L74:
                if (r6 == 0) goto L79
                r6.close()     // Catch: java.lang.Exception -> L79
            L79:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapLocalTile.AIRMapLocalTileProvider.readTileImage(int, int, int):byte[]");
        }

        private String getTileFilename(int i, int i2, int i3) {
            return this.pathTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
        }
    }

    public MapLocalTile(Context context) {
        super(context);
    }

    public void setPathTemplate(String str) {
        this.pathTemplate = str;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.tileProvider;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.setPathTemplate(str);
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

    public void setTileSize(float f) {
        this.tileSize = f;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.tileProvider;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.setTileSize((int) f);
        }
    }

    public void setUseAssets(boolean z) {
        this.useAssets = z;
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.tileOverlayOptions == null) {
            this.tileOverlayOptions = createTileOverlayOptions();
        }
        return this.tileOverlayOptions;
    }

    private TileOverlayOptions createTileOverlayOptions() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.zIndex);
        AIRMapLocalTileProvider aIRMapLocalTileProvider = new AIRMapLocalTileProvider((int) this.tileSize, this.pathTemplate, this.useAssets);
        this.tileProvider = aIRMapLocalTileProvider;
        tileOverlayOptions.tileProvider(aIRMapLocalTileProvider);
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
