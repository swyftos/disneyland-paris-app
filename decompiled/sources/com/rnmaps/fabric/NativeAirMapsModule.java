package com.rnmaps.fabric;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import androidx.camera.video.AudioStats;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.fbreact.specs.NativeAirMapsModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.rnmaps.fabric.NativeAirMapsModule;
import com.rnmaps.maps.MapModule;
import com.rnmaps.maps.MapUIBlock;
import com.rnmaps.maps.MapView;
import com.urbanairship.util.Attributes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class NativeAirMapsModule extends NativeAirMapsModuleSpec {
    public NativeAirMapsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeAirMapsModuleSpec.NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec
    public void getCamera(final double d, final Promise promise) {
        final UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(getReactApplicationContext(), (int) d);
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.rnmaps.fabric.NativeAirMapsModule.1
            @Override // java.lang.Runnable
            public void run() {
                CameraPosition cameraPosition = ((MapView) uIManagerForReactTag.resolveView((int) d)).map.getCameraPosition();
                WritableMap writableMapCreateMap = Arguments.createMap();
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putDouble("latitude", cameraPosition.target.latitude);
                writableMapCreateMap2.putDouble("longitude", cameraPosition.target.longitude);
                writableMapCreateMap.putMap("center", writableMapCreateMap2);
                writableMapCreateMap.putDouble("heading", cameraPosition.bearing);
                writableMapCreateMap.putDouble("pitch", cameraPosition.tilt);
                writableMapCreateMap.putDouble("zoom", cameraPosition.zoom);
                promise.resolve(writableMapCreateMap);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec
    public void getMarkersFrames(final double d, final boolean z, final Promise promise) {
        final UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(getReactApplicationContext(), (int) d);
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.rnmaps.fabric.NativeAirMapsModule$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                NativeAirMapsModule.lambda$getMarkersFrames$0(uIManagerForReactTag, d, z, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMarkersFrames$0(UIManager uIManager, double d, boolean z, Promise promise) {
        double[][] markersFrames = ((MapView) uIManager.resolveView((int) d)).getMarkersFrames(z);
        if (markersFrames != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            WritableNativeMap writableNativeMap3 = new WritableNativeMap();
            writableNativeMap2.putDouble("longitude", markersFrames[0][0]);
            writableNativeMap2.putDouble("latitude", markersFrames[0][1]);
            writableNativeMap3.putDouble("longitude", markersFrames[1][0]);
            writableNativeMap3.putDouble("latitude", markersFrames[1][1]);
            writableNativeMap.putMap("northEast", writableNativeMap2);
            writableNativeMap.putMap("southWest", writableNativeMap3);
            promise.resolve(writableNativeMap);
            return;
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec
    public void getMapBoundaries(final double d, final Promise promise) {
        final UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(getReactApplicationContext(), (int) d);
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.rnmaps.fabric.NativeAirMapsModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NativeAirMapsModule.lambda$getMapBoundaries$1(uIManagerForReactTag, d, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMapBoundaries$1(UIManager uIManager, double d, Promise promise) {
        double[][] mapBoundaries = ((MapView) uIManager.resolveView((int) d)).getMapBoundaries();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap2.putDouble("longitude", mapBoundaries[0][0]);
        writableNativeMap2.putDouble("latitude", mapBoundaries[0][1]);
        writableNativeMap3.putDouble("longitude", mapBoundaries[1][0]);
        writableNativeMap3.putDouble("latitude", mapBoundaries[1][1]);
        writableNativeMap.putMap("northEast", writableNativeMap2);
        writableNativeMap.putMap("southWest", writableNativeMap3);
        promise.resolve(writableNativeMap);
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec
    public void takeSnapshot(double d, String str, Promise promise) {
        Bitmap.CompressFormat compressFormat;
        if (str != null) {
            try {
                WritableMap writableMapConvertJsonToWritable = JSONUtil.convertJsonToWritable(new JSONObject(str));
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                String string = writableMapConvertJsonToWritable.hasKey("format") ? writableMapConvertJsonToWritable.getString("format") : MapModule.SNAPSHOT_FORMAT_PNG;
                if (string.equals(MapModule.SNAPSHOT_FORMAT_PNG)) {
                    compressFormat = Bitmap.CompressFormat.PNG;
                } else {
                    compressFormat = string.equals(MapModule.SNAPSHOT_FORMAT_JPG) ? Bitmap.CompressFormat.JPEG : null;
                }
                Bitmap.CompressFormat compressFormat2 = compressFormat;
                double d2 = writableMapConvertJsonToWritable.hasKey("quality") ? writableMapConvertJsonToWritable.getDouble("quality") : 1.0d;
                DisplayMetrics displayMetrics = reactApplicationContext.getResources().getDisplayMetrics();
                getReactApplicationContext().runOnUiQueueThread(new AnonymousClass2(UIManagerHelper.getUIManagerForReactTag(getReactApplicationContext(), (int) d), d, promise, Integer.valueOf(writableMapConvertJsonToWritable.hasKey("width") ? (int) (displayMetrics.density * writableMapConvertJsonToWritable.getDouble("width")) : 0), Integer.valueOf(writableMapConvertJsonToWritable.hasKey("height") ? (int) (displayMetrics.density * writableMapConvertJsonToWritable.getDouble("height")) : 0), writableMapConvertJsonToWritable.hasKey("result") ? writableMapConvertJsonToWritable.getString("result") : "file", string, reactApplicationContext, compressFormat2, d2));
            } catch (JSONException unused) {
                promise.reject("Failed to parse config ", str);
            }
        }
    }

    /* renamed from: com.rnmaps.fabric.NativeAirMapsModule$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Bitmap.CompressFormat val$compressFormat;
        final /* synthetic */ ReactApplicationContext val$context;
        final /* synthetic */ String val$format;
        final /* synthetic */ Integer val$height;
        final /* synthetic */ Promise val$promise;
        final /* synthetic */ double val$quality;
        final /* synthetic */ String val$result;
        final /* synthetic */ double val$tag;
        final /* synthetic */ UIManager val$uiManager;
        final /* synthetic */ Integer val$width;

        AnonymousClass2(UIManager uIManager, double d, Promise promise, Integer num, Integer num2, String str, String str2, ReactApplicationContext reactApplicationContext, Bitmap.CompressFormat compressFormat, double d2) {
            this.val$uiManager = uIManager;
            this.val$tag = d;
            this.val$promise = promise;
            this.val$width = num;
            this.val$height = num2;
            this.val$result = str;
            this.val$format = str2;
            this.val$context = reactApplicationContext;
            this.val$compressFormat = compressFormat;
            this.val$quality = d2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GoogleMap googleMap = ((MapView) this.val$uiManager.resolveView((int) this.val$tag)).map;
            final Promise promise = this.val$promise;
            final Integer num = this.val$width;
            final Integer num2 = this.val$height;
            final String str = this.val$result;
            final String str2 = this.val$format;
            final ReactApplicationContext reactApplicationContext = this.val$context;
            final Bitmap.CompressFormat compressFormat = this.val$compressFormat;
            final double d = this.val$quality;
            googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.rnmaps.fabric.NativeAirMapsModule$2$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                public final void onSnapshotReady(Bitmap bitmap) throws IOException {
                    NativeAirMapsModule.AnonymousClass2.lambda$run$0(promise, num, num2, str, str2, reactApplicationContext, compressFormat, d, bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(Promise promise, Integer num, Integer num2, String str, String str2, ReactApplicationContext reactApplicationContext, Bitmap.CompressFormat compressFormat, double d, Bitmap bitmap) throws IOException {
            if (bitmap == null) {
                promise.reject("Failed to generate bitmap, snapshot = null");
                return;
            }
            if (num.intValue() != 0 && num2.intValue() != 0 && (num.intValue() != bitmap.getWidth() || num2.intValue() != bitmap.getHeight())) {
                bitmap = Bitmap.createScaledBitmap(bitmap, num.intValue(), num2.intValue(), true);
            }
            if (str.equals("file")) {
                try {
                    File fileCreateTempFile = File.createTempFile("AirMapSnapshot", InstructionFileId.DOT + str2, reactApplicationContext.getCacheDir());
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    bitmap.compress(compressFormat, (int) (d * 100.0d), fileOutputStream);
                    MapModule.closeQuietly(fileOutputStream);
                    promise.resolve(Uri.fromFile(fileCreateTempFile).toString());
                    return;
                } catch (Exception e) {
                    promise.reject(e);
                    return;
                }
            }
            if (str.equals("base64")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, (int) (d * 100.0d), byteArrayOutputStream);
                MapModule.closeQuietly(byteArrayOutputStream);
                promise.resolve(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec
    public void getAddressFromCoordinates(double d, ReadableMap readableMap, Promise promise) throws IOException {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (readableMap == null || !readableMap.hasKey("latitude") || !readableMap.hasKey("longitude")) {
            promise.reject("Invalid coordinate format");
            return;
        }
        try {
            List<Address> fromLocation = new Geocoder(reactApplicationContext).getFromLocation(readableMap.getDouble("latitude"), readableMap.getDouble("longitude"), 1);
            if (fromLocation.isEmpty()) {
                promise.reject("Can not get address location");
                return;
            }
            Address address = fromLocation.get(0);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("name", address.getFeatureName());
            writableNativeMap.putString("locality", address.getLocality());
            writableNativeMap.putString("thoroughfare", address.getThoroughfare());
            writableNativeMap.putString("subThoroughfare", address.getSubThoroughfare());
            writableNativeMap.putString("subLocality", address.getSubLocality());
            writableNativeMap.putString("administrativeArea", address.getAdminArea());
            writableNativeMap.putString("subAdministrativeArea", address.getSubAdminArea());
            writableNativeMap.putString(HintConstants.AUTOFILL_HINT_POSTAL_CODE, address.getPostalCode());
            writableNativeMap.putString("countryCode", address.getCountryCode());
            writableNativeMap.putString(Attributes.COUNTRY, address.getCountryName());
            promise.resolve(writableNativeMap);
        } catch (IOException unused) {
            promise.reject("Can not get address location");
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec
    public void getPointForCoordinate(double d, ReadableMap readableMap, final Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final double d2 = reactApplicationContext.getResources().getDisplayMetrics().density;
        boolean zHasKey = readableMap.hasKey("latitude");
        double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d4 = zHasKey ? readableMap.getDouble("latitude") : 0.0d;
        if (readableMap.hasKey("longitude")) {
            d3 = readableMap.getDouble("longitude");
        }
        final LatLng latLng = new LatLng(d4, d3);
        new MapUIBlock((int) d, promise, reactApplicationContext, new Function() { // from class: com.rnmaps.fabric.NativeAirMapsModule$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeAirMapsModule.lambda$getPointForCoordinate$2(latLng, d2, promise, (MapView) obj);
            }
        }).addToUIManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$getPointForCoordinate$2(LatLng latLng, double d, Promise promise, MapView mapView) {
        Point screenLocation = mapView.map.getProjection().toScreenLocation(latLng);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("x", screenLocation.x / d);
        writableNativeMap.putDouble("y", screenLocation.y / d);
        promise.resolve(writableNativeMap);
        return null;
    }

    @Override // com.facebook.fbreact.specs.NativeAirMapsModuleSpec
    public void getCoordinateForPoint(double d, ReadableMap readableMap, final Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        double d2 = reactApplicationContext.getResources().getDisplayMetrics().density;
        final Point point = new Point(readableMap.hasKey("x") ? (int) (readableMap.getDouble("x") * d2) : 0, readableMap.hasKey("y") ? (int) (readableMap.getDouble("y") * d2) : 0);
        new MapUIBlock((int) d, promise, reactApplicationContext, new Function() { // from class: com.rnmaps.fabric.NativeAirMapsModule$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeAirMapsModule.lambda$getCoordinateForPoint$3(point, promise, (MapView) obj);
            }
        }).addToUIManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$getCoordinateForPoint$3(Point point, Promise promise, MapView mapView) {
        LatLng latLngFromScreenLocation = mapView.map.getProjection().fromScreenLocation(point);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("latitude", latLngFromScreenLocation.latitude);
        writableNativeMap.putDouble("longitude", latLngFromScreenLocation.longitude);
        promise.resolve(writableNativeMap);
        return null;
    }
}
