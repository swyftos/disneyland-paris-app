package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class MapTileProvider implements TileProvider {
    protected static final int BUFFER_SIZE = 16384;
    protected static final int TARGET_TILE_SIZE = 512;
    protected Context context;
    protected boolean customMode;
    protected boolean doubleTileSize;
    protected boolean flipY;
    protected int maximumNativeZ;
    protected int maximumZ;
    protected int minimumZ;
    protected boolean offlineMode;
    protected int tileCacheMaxAge;
    protected String tileCachePath;
    protected UrlTileProvider tileProvider;
    protected int tileSize;
    protected String urlTemplate;

    public void setCustomMode() {
    }

    class AIRMapUrlTileProvider extends UrlTileProvider {
        private String urlTemplate;

        public AIRMapUrlTileProvider(int i, int i2, String str) {
            super(i, i2);
            this.urlTemplate = str;
        }

        @Override // com.google.android.gms.maps.model.UrlTileProvider
        public URL getTileUrl(int i, int i2, int i3) {
            if (MapTileProvider.this.flipY) {
                i2 = ((1 << i3) - i2) - 1;
            }
            String strReplace = this.urlTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
            MapTileProvider mapTileProvider = MapTileProvider.this;
            int i4 = mapTileProvider.maximumZ;
            if (i4 > 0 && i3 > i4) {
                return null;
            }
            int i5 = mapTileProvider.minimumZ;
            if (i5 > 0 && i3 < i5) {
                return null;
            }
            try {
                return new URL(strReplace);
            } catch (MalformedURLException e) {
                throw new AssertionError(e);
            }
        }
    }

    public MapTileProvider(int i, boolean z, String str, int i2, int i3, int i4, boolean z2, String str2, int i5, boolean z3, Context context, boolean z4) {
        this.tileProvider = new AIRMapUrlTileProvider(i, i, str);
        this.tileSize = i;
        this.doubleTileSize = z;
        this.urlTemplate = str;
        this.maximumZ = i2;
        this.maximumNativeZ = i3;
        this.minimumZ = i4;
        this.flipY = z2;
        this.tileCachePath = str2;
        this.tileCacheMaxAge = i5;
        this.offlineMode = z3;
        this.context = context;
        this.customMode = z4;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) throws Throwable {
        byte[] bArrScaleLowerZoomTile;
        int i4;
        if (!this.customMode) {
            return this.tileProvider.getTile(i, i2, i3);
        }
        int i5 = this.maximumZ;
        if (i5 <= 0) {
            i5 = Integer.MAX_VALUE;
        }
        if (this.tileSize != 256 || !this.doubleTileSize || (i4 = i3 + 1) > this.maximumNativeZ || i4 > i5) {
            bArrScaleLowerZoomTile = null;
        } else {
            Log.d("urlTile", "pullTilesFromHigherZoom");
            bArrScaleLowerZoomTile = pullTilesFromHigherZoom(i, i2, i3);
        }
        if (i3 > this.maximumNativeZ) {
            Log.d("urlTile", "scaleLowerZoomTile");
            bArrScaleLowerZoomTile = scaleLowerZoomTile(i, i2, i3, this.maximumNativeZ);
        }
        if (bArrScaleLowerZoomTile == null && i3 <= i5) {
            Log.d("urlTile", "getTileImage");
            bArrScaleLowerZoomTile = getTileImage(i, i2, i3);
        }
        if (bArrScaleLowerZoomTile == null && this.tileCachePath != null && this.offlineMode) {
            Log.d("urlTile", "findLowerZoomTileForScaling");
            int i6 = this.maximumNativeZ;
            int iMax = Math.max(this.minimumZ, i3 - 3);
            for (int i7 = i3 > i6 ? i6 - 1 : i3 - 1; i7 >= iMax; i7--) {
                bArrScaleLowerZoomTile = scaleLowerZoomTile(i, i2, i3, i7);
                if (bArrScaleLowerZoomTile != null) {
                    break;
                }
            }
        }
        if (bArrScaleLowerZoomTile == null) {
            return null;
        }
        int i8 = this.tileSize;
        return new Tile(i8, i8, bArrScaleLowerZoomTile);
    }

    byte[] getTileImage(int i, int i2, int i3) throws Throwable {
        byte[] bArrFetchTile;
        if (this.tileCachePath != null) {
            bArrFetchTile = readTileImage(i, i2, i3);
            if (bArrFetchTile != null) {
                Log.d("urlTile", "tile cache HIT for " + i3 + "/" + i + "/" + i2);
            } else {
                Log.d("urlTile", "tile cache MISS for " + i3 + "/" + i + "/" + i2);
            }
            if (bArrFetchTile != null && !this.offlineMode) {
                checkForRefresh(i, i2, i3);
            }
        } else {
            bArrFetchTile = null;
        }
        if (bArrFetchTile == null && !this.offlineMode && this.tileCachePath != null) {
            String tileFilename = getTileFilename(i, i2, i3);
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(MapTileWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).addTag(tileFilename).setInputData(new Data.Builder().putString("url", getTileUrl(i, i2, i3).toString()).putString("filename", tileFilename).putInt("maxAge", -1).build()).build();
            WorkManager workManager = WorkManager.getInstance(this.context.getApplicationContext());
            ListenableFuture<Operation.State.SUCCESS> result = workManager.enqueueUniqueWork(tileFilename, ExistingWorkPolicy.KEEP, oneTimeWorkRequestBuild).getResult();
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                result.get(1L, timeUnit);
                Thread.sleep(500L);
                Log.d("urlTile: ", workManager.getWorkInfosByTag(tileFilename).get(1L, timeUnit).get(0).toString());
                if (this.tileCachePath != null) {
                    bArrFetchTile = readTileImage(i, i2, i3);
                    if (bArrFetchTile != null) {
                        Log.d("urlTile", "tile cache fetch HIT for " + i3 + "/" + i + "/" + i2);
                    } else {
                        Log.d("urlTile", "tile cache fetch MISS for " + i3 + "/" + i + "/" + i2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bArrFetchTile == null && !this.offlineMode) {
            Log.d("urlTile", "Normal fetch");
            bArrFetchTile = fetchTile(i, i2, i3);
            if (bArrFetchTile == null) {
                Log.d("urlTile", "tile fetch TIMEOUT / FAIL for " + i3 + "/" + i + "/" + i2);
            }
        }
        return bArrFetchTile;
    }

    byte[] pullTilesFromHigherZoom(int i, int i2, int i3) throws Throwable {
        Bitmap newBitmap = getNewBitmap();
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();
        int i4 = i * 2;
        int i5 = i2 * 2;
        int i6 = i3 + 1;
        byte[] tileImage = getTileImage(i4, i5, i6);
        int i7 = i5 + 1;
        byte[] tileImage2 = getTileImage(i4, i7, i6);
        int i8 = i4 + 1;
        byte[] tileImage3 = getTileImage(i8, i5, i6);
        byte[] tileImage4 = getTileImage(i8, i7, i6);
        if (tileImage == null || tileImage2 == null || tileImage3 == null || tileImage4 == null) {
            return null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(tileImage, 0, tileImage.length);
        canvas.drawBitmap(bitmapDecodeByteArray, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        bitmapDecodeByteArray.recycle();
        Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(tileImage2, 0, tileImage2.length);
        canvas.drawBitmap(bitmapDecodeByteArray2, BitmapDescriptorFactory.HUE_RED, 256.0f, paint);
        bitmapDecodeByteArray2.recycle();
        Bitmap bitmapDecodeByteArray3 = BitmapFactory.decodeByteArray(tileImage3, 0, tileImage3.length);
        canvas.drawBitmap(bitmapDecodeByteArray3, 256.0f, BitmapDescriptorFactory.HUE_RED, paint);
        bitmapDecodeByteArray3.recycle();
        Bitmap bitmapDecodeByteArray4 = BitmapFactory.decodeByteArray(tileImage4, 0, tileImage4.length);
        canvas.drawBitmap(bitmapDecodeByteArray4, 256.0f, 256.0f, paint);
        bitmapDecodeByteArray4.recycle();
        byte[] bArrBitmapToByteArray = bitmapToByteArray(newBitmap);
        newBitmap.recycle();
        return bArrBitmapToByteArray;
    }

    Bitmap getNewBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        return bitmapCreateBitmap;
    }

    byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    byte[] scaleLowerZoomTile(int i, int i2, int i3, int i4) throws Throwable {
        int i5 = i3 - i4;
        int i6 = 1 << i5;
        int i7 = i >> i5;
        int i8 = i2 >> i5;
        int i9 = i3 - i5;
        int i10 = i % i6;
        int i11 = i2 % i6;
        Bitmap newBitmap = getNewBitmap();
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();
        byte[] tileImage = getTileImage(i7, i8, i9);
        if (tileImage == null) {
            return null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(tileImage, 0, tileImage.length);
        int i12 = this.tileSize / i6;
        int i13 = i10 * i12;
        int i14 = i11 * i12;
        canvas.drawBitmap(bitmapDecodeByteArray, new Rect(i13, i14, i13 + i12, i12 + i14), new Rect(0, 0, 512, 512), paint);
        bitmapDecodeByteArray.recycle();
        byte[] bArrBitmapToByteArray = bitmapToByteArray(newBitmap);
        newBitmap.recycle();
        return bArrBitmapToByteArray;
    }

    void checkForRefresh(int i, int i2, int i3) {
        String tileFilename = getTileFilename(i, i2, i3);
        if ((System.currentTimeMillis() - new File(tileFilename).lastModified()) / 1000 > this.tileCacheMaxAge) {
            Log.d("urlTile", "Refreshing");
            WorkManager.getInstance(this.context.getApplicationContext()).enqueueUniqueWork(tileFilename, ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(MapTileWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).addTag(tileFilename).setInputData(new Data.Builder().putString("url", getTileUrl(i, i2, i3).toString()).putString("filename", tileFilename).putInt("maxAge", this.tileCacheMaxAge).build()).build());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9 */
    byte[] fetchTile(int i, int i2, int i3) throws Throwable {
        ?? r7;
        Throwable th;
        ?? r5;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        URL tileUrl = getTileUrl(i, i2, i3);
        try {
            try {
                InputStream inputStream2 = InstrumentationCallbacks.getInputStream(tileUrl.openConnection());
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i4 = inputStream2.read(bArr, 0, 16384);
                            if (i4 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i4);
                        }
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            inputStream2.close();
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        return byteArray;
                    } catch (IOException | OutOfMemoryError e) {
                        e = e;
                        inputStream = inputStream2;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        return null;
                    }
                } catch (IOException | OutOfMemoryError e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    inputStream = inputStream2;
                } catch (Throwable th2) {
                    r7 = 0;
                    th = th2;
                    r5 = inputStream2;
                    if (r5 != 0) {
                        try {
                            r5.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (r7 != 0) {
                        try {
                            r7.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException | OutOfMemoryError e3) {
                e = e3;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                r7 = 0;
                th = th3;
                r5 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
            r5 = tileUrl;
            r7 = i2;
        }
    }

    byte[] readTileImage(int i, int i2, int i3) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        String tileFilename = getTileFilename(i, i2, i3);
        FileInputStream fileInputStream2 = null;
        if (tileFilename == null) {
            return null;
        }
        File file = new File(tileFilename);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i4 = fileInputStream.read(bArr, 0, 16384);
                            if (i4 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i4);
                            th = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused2) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                        byteArrayOutputStream.flush();
                        if (this.tileCacheMaxAge == 0) {
                            file.setLastModified(System.currentTimeMillis());
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused4) {
                        }
                        return byteArray;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException | OutOfMemoryError e) {
                    e = e;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    return null;
                }
            } catch (IOException | OutOfMemoryError e2) {
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (IOException | OutOfMemoryError e3) {
            e = e3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    String getTileFilename(int i, int i2, int i3) {
        if (this.tileCachePath == null) {
            return null;
        }
        return this.tileCachePath + '/' + i3 + "/" + i + "/" + i2;
    }

    protected URL getTileUrl(int i, int i2, int i3) {
        return this.tileProvider.getTileUrl(i, i2, i3);
    }

    public void setUrlTemplate(String str) {
        if (this.urlTemplate != str) {
            int i = this.tileSize;
            this.tileProvider = new AIRMapUrlTileProvider(i, i, str);
        }
        this.urlTemplate = str;
    }

    public void setTileSize(int i) {
        if (this.tileSize != i) {
            this.tileProvider = new AIRMapUrlTileProvider(i, i, this.urlTemplate);
        }
        this.tileSize = i;
    }

    public void setDoubleTileSize(boolean z) {
        this.doubleTileSize = z;
    }

    public void setMaximumZ(int i) {
        this.maximumZ = i;
    }

    public void setMaximumNativeZ(int i) {
        this.maximumNativeZ = i;
    }

    public void setMinimumZ(int i) {
        this.minimumZ = i;
    }

    public void setFlipY(boolean z) {
        this.flipY = z;
    }

    public void setTileCachePath(String str) {
        this.tileCachePath = str;
    }

    public void setTileCacheMaxAge(int i) {
        this.tileCacheMaxAge = i;
    }

    public void setOfflineMode(boolean z) {
        this.offlineMode = z;
    }
}
