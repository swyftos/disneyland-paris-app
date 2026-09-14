package com.rnmaps.maps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
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

        /* JADX WARN: Code duplicated, block: B:54:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:68:? A[SYNTHETIC] */
        private byte[] readTileImage(int i, int i2, int i3) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            ByteArrayOutputStream byteArrayOutputStream2;
            String tileFilename = getTileFilename(i, i2, i3);
            InputStream inputStream2 = null;
            try {
                InputStream inputStreamOpen = this.useAssets ? MapLocalTile.this.getContext().getAssets().open(tileFilename) : new FileInputStream(tileFilename);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i4 = inputStreamOpen.read(bArr, 0, 16384);
                            if (i4 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i4);
                        }
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            inputStreamOpen.close();
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        return byteArray;
                    } catch (IOException | OutOfMemoryError e) {
                        inputStream = inputStreamOpen;
                        e = e;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            e.printStackTrace();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception unused4) {
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        inputStream2 = inputStreamOpen;
                        th = th2;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                            throw th;
                        }
                        throw th;
                    }
                } catch (IOException | OutOfMemoryError e2) {
                    byteArrayOutputStream2 = null;
                    inputStream = inputStreamOpen;
                    e = e2;
                } catch (Throwable th3) {
                    inputStream2 = inputStreamOpen;
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } catch (IOException | OutOfMemoryError e3) {
                e = e3;
                inputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
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
