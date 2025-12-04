package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.common.MapBuilder;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.collections.GroundOverlayManager;
import com.rnmaps.fabric.event.OnPressEvent;
import java.util.Map;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class MapOverlay extends MapFeature {
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private LatLngBounds bounds;
    private DataSource dataSource;
    private GroundOverlay groundOverlay;
    private GroundOverlayManager.Collection groundOverlayCollection;
    private GroundOverlayOptions groundOverlayOptions;
    private String imageUri;
    private boolean tappable;
    private float transparency;
    private float zIndex;

    public MapOverlay(Context context) {
        super(context);
        this.transparency = 1.0f;
    }

    public void setBounds(LatLngBounds latLngBounds) {
        this.bounds = latLngBounds;
        GroundOverlay groundOverlay = this.groundOverlay;
        if (groundOverlay != null) {
            groundOverlay.setPositionFromBounds(latLngBounds);
        }
    }

    public void setBearing(float f) {
        this.bearing = f;
        GroundOverlay groundOverlay = this.groundOverlay;
        if (groundOverlay != null) {
            groundOverlay.setBearing(f);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        GroundOverlay groundOverlay = this.groundOverlay;
        if (groundOverlay != null) {
            groundOverlay.setZIndex(f);
        }
    }

    public void setTransparency(float f) {
        this.transparency = f;
        GroundOverlay groundOverlay = this.groundOverlay;
        if (groundOverlay != null) {
            groundOverlay.setTransparency(f);
        }
    }

    public void setImage(String str) throws NumberFormatException {
        this.imageUri = str;
        if (str == null) {
            this.bitmapDescriptor = null;
            return;
        }
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://") || str.startsWith("asset://") || str.startsWith("data:")) {
            this.dataSource = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), this);
            this.dataSource.subscribe(new AnonymousClass1(), Executors.newSingleThreadExecutor());
            return;
        }
        this.bitmapDescriptor = getBitmapDescriptorByName(str);
    }

    /* renamed from: com.rnmaps.maps.MapOverlay$1, reason: invalid class name */
    class AnonymousClass1 extends BaseDataSubscriber {
        @Override // com.facebook.datasource.BaseDataSubscriber
        protected void onFailureImpl(DataSource dataSource) {
        }

        AnonymousClass1() {
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        protected void onNewResultImpl(DataSource dataSource) {
            CloseableReference closeableReference;
            Bitmap underlyingBitmap;
            if (dataSource.isFinished() && (closeableReference = (CloseableReference) dataSource.getResult()) != null) {
                try {
                    CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                    if ((closeableImage instanceof CloseableBitmap) && (underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap()) != null) {
                        MapOverlay.this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(underlyingBitmap);
                    }
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.rnmaps.maps.MapOverlay$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onNewResultImpl$0();
                        }
                    });
                } catch (Throwable th) {
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNewResultImpl$0() {
            MapOverlay.this.update();
        }
    }

    private BitmapDescriptor getBitmapDescriptorByName(String str) {
        return BitmapDescriptorFactory.fromResource(getDrawableResourceByName(str));
    }

    private int getDrawableResourceByName(String str) {
        return getResources().getIdentifier(str, "drawable", getContext().getPackageName());
    }

    public void setTappable(boolean z) {
        this.tappable = z;
        GroundOverlay groundOverlay = this.groundOverlay;
        if (groundOverlay != null) {
            groundOverlay.setClickable(z);
        }
    }

    public static Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnPressEvent.EVENT_NAME));
        return builder.build();
    }

    public GroundOverlayOptions getGroundOverlayOptions() {
        if (this.groundOverlayOptions == null) {
            this.groundOverlayOptions = createGroundOverlayOptions();
        }
        return this.groundOverlayOptions;
    }

    private GroundOverlayOptions createGroundOverlayOptions() {
        GroundOverlayOptions groundOverlayOptions = this.groundOverlayOptions;
        if (groundOverlayOptions != null) {
            return groundOverlayOptions;
        }
        GroundOverlayOptions groundOverlayOptions2 = new GroundOverlayOptions();
        BitmapDescriptor bitmapDescriptor = this.bitmapDescriptor;
        if (bitmapDescriptor != null) {
            groundOverlayOptions2.image(bitmapDescriptor);
        } else {
            groundOverlayOptions2.image(BitmapDescriptorFactory.defaultMarker());
            groundOverlayOptions2.visible(false);
        }
        groundOverlayOptions2.positionFromBounds(this.bounds);
        groundOverlayOptions2.zIndex(this.zIndex);
        groundOverlayOptions2.bearing(this.bearing);
        return groundOverlayOptions2;
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.groundOverlay;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void addToMap(Object obj) {
        GroundOverlayManager.Collection collection = (GroundOverlayManager.Collection) obj;
        GroundOverlayOptions groundOverlayOptions = getGroundOverlayOptions();
        if (groundOverlayOptions != null) {
            GroundOverlay groundOverlayAddGroundOverlay = collection.addGroundOverlay(groundOverlayOptions);
            this.groundOverlay = groundOverlayAddGroundOverlay;
            groundOverlayAddGroundOverlay.setClickable(this.tappable);
            return;
        }
        this.groundOverlayCollection = collection;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void removeFromMap(Object obj) {
        GroundOverlay groundOverlay = this.groundOverlay;
        if (groundOverlay != null) {
            ((GroundOverlayManager.Collection) obj).remove(groundOverlay);
            this.groundOverlay = null;
            this.groundOverlayOptions = null;
        }
        this.groundOverlayCollection = null;
    }

    public void update() {
        GroundOverlay groundOverlay = getGroundOverlay();
        this.groundOverlay = groundOverlay;
        if (groundOverlay != null) {
            groundOverlay.setVisible(true);
            this.groundOverlay.setImage(this.bitmapDescriptor);
            this.groundOverlay.setClickable(this.tappable);
        }
    }

    private GroundOverlay getGroundOverlay() {
        GroundOverlayOptions groundOverlayOptions;
        GroundOverlay groundOverlay = this.groundOverlay;
        if (groundOverlay != null) {
            return groundOverlay;
        }
        if (this.groundOverlayCollection == null || (groundOverlayOptions = getGroundOverlayOptions()) == null) {
            return null;
        }
        return this.groundOverlayCollection.addGroundOverlay(groundOverlayOptions);
    }
}
