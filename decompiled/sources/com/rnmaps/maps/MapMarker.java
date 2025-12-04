package com.rnmaps.maps;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.util.Property;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.collections.MarkerManager;
import com.rnmaps.fabric.event.OnDeselectEvent;
import com.rnmaps.fabric.event.OnDragEndEvent;
import com.rnmaps.fabric.event.OnDragEvent;
import com.rnmaps.fabric.event.OnDragStartEvent;
import com.rnmaps.fabric.event.OnPressEvent;
import com.rnmaps.fabric.event.OnSelectEvent;
import com.rnmaps.maps.MapView;
import java.util.Map;

/* loaded from: classes4.dex */
public class MapMarker extends MapFeature {
    private boolean anchorIsSet;
    private float anchorX;
    private float anchorY;
    private boolean calloutAnchorIsSet;
    private float calloutAnchorX;
    private float calloutAnchorY;
    private MapCallout calloutView;
    private final Context context;
    private DataSource dataSource;
    private boolean draggable;
    private boolean flat;
    private boolean hasCustomMarkerView;
    private int height;
    private Bitmap iconBitmap;
    private BitmapDescriptor iconBitmapDescriptor;
    private String identifier;
    private ImageManager.OnImageLoadedListener imageLoadedListener;
    private String imageUri;
    private boolean loadingImage;
    private final DraweeHolder logoHolder;
    private Bitmap mLastBitmapCreated;
    private final ControllerListener mLogoControllerListener;
    private Marker marker;
    private float markerHue;
    private final MapMarkerManager markerManager;
    private MarkerOptions markerOptions;
    private float opacity;
    private LatLng position;
    private float rotation;
    private String snippet;
    private String title;
    private boolean tracksViewChanges;
    private boolean tracksViewChangesActive;
    private int width;
    private View wrappedCalloutView;
    private int zIndex;

    @FunctionalInterface
    public interface EventCreator<T extends Event> {
        T create(int i, int i2, WritableMap writableMap);
    }

    public MapMarker(Context context, MapMarkerManager mapMarkerManager) {
        super(context);
        this.markerHue = BitmapDescriptorFactory.HUE_RED;
        this.rotation = BitmapDescriptorFactory.HUE_RED;
        this.flat = false;
        this.draggable = false;
        this.zIndex = 0;
        this.opacity = 1.0f;
        this.tracksViewChanges = true;
        this.tracksViewChangesActive = false;
        this.hasCustomMarkerView = false;
        this.mLogoControllerListener = new BaseControllerListener() { // from class: com.rnmaps.maps.MapMarker.1
            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onSubmit(String str, Object obj) {
                MapMarker.this.loadingImage = true;
            }

            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) throws Throwable {
                CloseableReference closeableReference;
                Throwable th;
                Bitmap underlyingBitmap;
                try {
                    closeableReference = (CloseableReference) MapMarker.this.dataSource.getResult();
                    if (closeableReference != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                            if ((closeableImage instanceof CloseableStaticBitmap) && (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) != null) {
                                Bitmap bitmapCopy = underlyingBitmap.copy(Bitmap.Config.ARGB_8888, true);
                                MapMarker.this.iconBitmap = bitmapCopy;
                                MapMarker.this.iconBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmapCopy);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            MapMarker.this.dataSource.close();
                            if (closeableReference != null) {
                                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                            }
                            throw th;
                        }
                    }
                    MapMarker.this.dataSource.close();
                    if (closeableReference != null) {
                        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    }
                    if (MapMarker.this.markerManager != null && MapMarker.this.imageUri != null) {
                        MapMarker.this.markerManager.getSharedIcon(MapMarker.this.imageUri).updateIcon(MapMarker.this.iconBitmapDescriptor, MapMarker.this.iconBitmap);
                    }
                    MapMarker.this.update(true);
                    MapMarker.this.loadingImage = false;
                    if (MapMarker.this.imageLoadedListener != null) {
                        MapMarker.this.imageLoadedListener.onImageLoaded(null, null, false);
                        MapMarker.this.imageLoadedListener = null;
                    }
                } catch (Throwable th3) {
                    closeableReference = null;
                    th = th3;
                }
            }
        };
        this.mLastBitmapCreated = null;
        this.context = context;
        this.markerManager = mapMarkerManager;
        DraweeHolder draweeHolderCreate = DraweeHolder.create(createDraweeHierarchy(), context);
        this.logoHolder = draweeHolderCreate;
        draweeHolderCreate.onAttach();
    }

    public MapMarker(Context context, MarkerOptions markerOptions, MapMarkerManager mapMarkerManager) {
        super(context);
        this.markerHue = BitmapDescriptorFactory.HUE_RED;
        this.rotation = BitmapDescriptorFactory.HUE_RED;
        this.flat = false;
        this.draggable = false;
        this.zIndex = 0;
        this.opacity = 1.0f;
        this.tracksViewChanges = true;
        this.tracksViewChangesActive = false;
        this.hasCustomMarkerView = false;
        this.mLogoControllerListener = new BaseControllerListener() { // from class: com.rnmaps.maps.MapMarker.1
            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onSubmit(String str, Object obj) {
                MapMarker.this.loadingImage = true;
            }

            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) throws Throwable {
                CloseableReference closeableReference;
                Throwable th;
                Bitmap underlyingBitmap;
                try {
                    closeableReference = (CloseableReference) MapMarker.this.dataSource.getResult();
                    if (closeableReference != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                            if ((closeableImage instanceof CloseableStaticBitmap) && (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) != null) {
                                Bitmap bitmapCopy = underlyingBitmap.copy(Bitmap.Config.ARGB_8888, true);
                                MapMarker.this.iconBitmap = bitmapCopy;
                                MapMarker.this.iconBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmapCopy);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            MapMarker.this.dataSource.close();
                            if (closeableReference != null) {
                                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                            }
                            throw th;
                        }
                    }
                    MapMarker.this.dataSource.close();
                    if (closeableReference != null) {
                        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    }
                    if (MapMarker.this.markerManager != null && MapMarker.this.imageUri != null) {
                        MapMarker.this.markerManager.getSharedIcon(MapMarker.this.imageUri).updateIcon(MapMarker.this.iconBitmapDescriptor, MapMarker.this.iconBitmap);
                    }
                    MapMarker.this.update(true);
                    MapMarker.this.loadingImage = false;
                    if (MapMarker.this.imageLoadedListener != null) {
                        MapMarker.this.imageLoadedListener.onImageLoaded(null, null, false);
                        MapMarker.this.imageLoadedListener = null;
                    }
                } catch (Throwable th3) {
                    closeableReference = null;
                    th = th3;
                }
            }
        };
        this.mLastBitmapCreated = null;
        this.context = context;
        this.markerManager = mapMarkerManager;
        DraweeHolder draweeHolderCreate = DraweeHolder.create(createDraweeHierarchy(), context);
        this.logoHolder = draweeHolderCreate;
        draweeHolderCreate.onAttach();
        this.position = markerOptions.getPosition();
        setAnchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        setCalloutAnchor(markerOptions.getInfoWindowAnchorU(), markerOptions.getInfoWindowAnchorV());
        setTitle(markerOptions.getTitle());
        setSnippet(markerOptions.getSnippet());
        setRotation(markerOptions.getRotation());
        setFlat(markerOptions.isFlat());
        setDraggable(markerOptions.isDraggable());
        setZIndex(Math.round(markerOptions.getZIndex()));
        setOpacity(markerOptions.getAlpha());
        this.iconBitmapDescriptor = markerOptions.getIcon();
    }

    private GenericDraweeHierarchy createDraweeHierarchy() {
        return new GenericDraweeHierarchyBuilder(getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void setCoordinate(ReadableMap readableMap) {
        setCoordinate(new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude")));
    }

    public void setCoordinate(LatLng latLng) {
        this.position = latLng;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setPosition(latLng);
        }
        update(false);
    }

    public void setIdentifier(String str) {
        this.identifier = str;
        update(false);
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setTitle(String str) {
        this.title = str;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setTitle(str);
        }
        update(false);
    }

    public void setSnippet(String str) {
        this.snippet = str;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setSnippet(str);
        }
        update(false);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.rotation = f;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setRotation(f);
        }
        update(false);
    }

    public void setFlat(boolean z) {
        this.flat = z;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setFlat(z);
        }
        update(false);
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setDraggable(z);
        }
        update(false);
    }

    public void setZIndex(int i) {
        this.zIndex = i;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setZIndex(i);
        }
        update(false);
    }

    public void setOpacity(float f) {
        this.opacity = f;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setAlpha(f);
        }
        update(false);
    }

    public void setMarkerHue(float f) {
        this.markerHue = f;
        update(false);
    }

    public void setAnchor(double d, double d2) {
        this.anchorIsSet = true;
        float f = (float) d;
        this.anchorX = f;
        float f2 = (float) d2;
        this.anchorY = f2;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setAnchor(f, f2);
        }
        update(false);
    }

    public void setCalloutAnchor(double d, double d2) {
        this.calloutAnchorIsSet = true;
        float f = (float) d;
        this.calloutAnchorX = f;
        float f2 = (float) d2;
        this.calloutAnchorY = f2;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setInfoWindowAnchor(f, f2);
        }
        update(false);
    }

    public void setTracksViewChanges(boolean z) {
        this.tracksViewChanges = z;
        updateTracksViewChanges();
    }

    private void updateTracksViewChanges() {
        boolean z = this.tracksViewChanges && this.hasCustomMarkerView && this.marker != null;
        if (z == this.tracksViewChangesActive) {
            return;
        }
        this.tracksViewChangesActive = z;
        if (z) {
            ViewChangesTracker.getInstance().addMarker(this);
        } else {
            ViewChangesTracker.getInstance().removeMarker(this);
            updateMarkerIcon();
        }
    }

    public LatLng getPosition() {
        return this.position;
    }

    public boolean updateCustomForTracking() {
        if (!this.tracksViewChangesActive) {
            return false;
        }
        updateMarkerIcon();
        return true;
    }

    public void updateMarkerIcon() {
        Marker marker = this.marker;
        if (marker == null) {
            return;
        }
        marker.setIcon(getIcon());
    }

    public LatLng interpolate(float f, LatLng latLng, LatLng latLng2) {
        double d = latLng2.latitude;
        double d2 = latLng.latitude;
        double d3 = f;
        double d4 = ((d - d2) * d3) + d2;
        double d5 = latLng2.longitude;
        double d6 = latLng.longitude;
        return new LatLng(d4, ((d5 - d6) * d3) + d6);
    }

    public void animateToCoodinate(LatLng latLng, Integer num) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.marker, (Property<Marker, V>) Property.of(Marker.class, LatLng.class, ViewProps.POSITION), new TypeEvaluator() { // from class: com.rnmaps.maps.MapMarker.2
            @Override // android.animation.TypeEvaluator
            public LatLng evaluate(float f, LatLng latLng2, LatLng latLng3) {
                return MapMarker.this.interpolate(f, latLng2, latLng3);
            }
        }, latLng);
        objectAnimatorOfObject.setDuration(num.intValue());
        objectAnimatorOfObject.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setImage(java.lang.String r6) {
        /*
            r5 = this;
            com.rnmaps.maps.MapMarkerManager r0 = r5.markerManager
            r1 = 1
            if (r0 == 0) goto L27
            java.lang.String r2 = r5.imageUri
            if (r2 == 0) goto L17
            com.rnmaps.maps.MapMarkerManager$AirMapMarkerSharedIcon r0 = r0.getSharedIcon(r2)
            r0.removeMarker(r5)
            com.rnmaps.maps.MapMarkerManager r0 = r5.markerManager
            java.lang.String r2 = r5.imageUri
            r0.removeSharedIconIfEmpty(r2)
        L17:
            if (r6 == 0) goto L27
            com.rnmaps.maps.MapMarkerManager r0 = r5.markerManager
            com.rnmaps.maps.MapMarkerManager$AirMapMarkerSharedIcon r0 = r0.getSharedIcon(r6)
            r0.addMarker(r5)
            boolean r0 = r0.shouldLoadImage()
            goto L28
        L27:
            r0 = r1
        L28:
            r5.imageUri = r6
            if (r0 != 0) goto L2d
            return
        L2d:
            if (r6 != 0) goto L37
            r6 = 0
            r5.iconBitmapDescriptor = r6
            r5.update(r1)
            goto Lf4
        L37:
            java.lang.String r0 = "http://"
            boolean r0 = r6.startsWith(r0)
            if (r0 != 0) goto Lb7
            java.lang.String r0 = "https://"
            boolean r0 = r6.startsWith(r0)
            if (r0 != 0) goto Lb7
            java.lang.String r0 = "file://"
            boolean r0 = r6.startsWith(r0)
            if (r0 != 0) goto Lb7
            java.lang.String r0 = "asset://"
            boolean r0 = r6.startsWith(r0)
            if (r0 != 0) goto Lb7
            java.lang.String r0 = "data:"
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L60
            goto Lb7
        L60:
            com.google.android.gms.maps.model.BitmapDescriptor r0 = r5.getBitmapDescriptorByName(r6)
            r5.iconBitmapDescriptor = r0
            int r0 = r5.getDrawableResourceByName(r6)
            android.content.res.Resources r2 = r5.getResources()
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            r5.iconBitmap = r2
            if (r2 != 0) goto La4
            android.content.res.Resources r2 = r5.getResources()
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r0)
            int r2 = r0.getIntrinsicWidth()
            int r3 = r0.getIntrinsicHeight()
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r3, r4)
            r5.iconBitmap = r2
            int r2 = r0.getIntrinsicWidth()
            int r3 = r0.getIntrinsicHeight()
            r4 = 0
            r0.setBounds(r4, r4, r2, r3)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            android.graphics.Bitmap r3 = r5.iconBitmap
            r2.<init>(r3)
            r0.draw(r2)
        La4:
            com.rnmaps.maps.MapMarkerManager r0 = r5.markerManager
            if (r0 == 0) goto Lb3
            com.rnmaps.maps.MapMarkerManager$AirMapMarkerSharedIcon r6 = r0.getSharedIcon(r6)
            com.google.android.gms.maps.model.BitmapDescriptor r0 = r5.iconBitmapDescriptor
            android.graphics.Bitmap r2 = r5.iconBitmap
            r6.updateIcon(r0, r2)
        Lb3:
            r5.update(r1)
            goto Lf4
        Lb7:
            android.net.Uri r6 = android.net.Uri.parse(r6)
            com.facebook.imagepipeline.request.ImageRequestBuilder r6 = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(r6)
            com.facebook.imagepipeline.request.ImageRequest r6 = r6.build()
            com.facebook.imagepipeline.core.ImagePipeline r0 = com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline()
            com.facebook.datasource.DataSource r0 = r0.fetchDecodedImage(r6, r5)
            r5.dataSource = r0
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r0 = com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r6 = r0.setImageRequest(r6)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r6 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r6
            com.facebook.drawee.controller.ControllerListener r0 = r5.mLogoControllerListener
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r6 = r6.setControllerListener(r0)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r6 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r6
            com.facebook.drawee.view.DraweeHolder r0 = r5.logoHolder
            com.facebook.drawee.interfaces.DraweeController r0 = r0.getController()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r6 = r6.setOldController(r0)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r6 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r6
            com.facebook.drawee.controller.AbstractDraweeController r6 = r6.build()
            com.facebook.drawee.view.DraweeHolder r5 = r5.logoHolder
            r5.setController(r6)
        Lf4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapMarker.setImage(java.lang.String):void");
    }

    public void setIconBitmapDescriptor(BitmapDescriptor bitmapDescriptor, Bitmap bitmap) {
        this.iconBitmapDescriptor = bitmapDescriptor;
        this.iconBitmap = bitmap;
        update(true);
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.iconBitmap = bitmap;
    }

    public MarkerOptions getMarkerOptions() {
        if (this.markerOptions == null) {
            this.markerOptions = new MarkerOptions();
        }
        fillMarkerOptions(this.markerOptions);
        return this.markerOptions;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        if (!(view instanceof MapCallout)) {
            this.hasCustomMarkerView = true;
            updateTracksViewChanges();
        }
        update(true);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (getChildCount() == 0 && this.hasCustomMarkerView) {
            this.hasCustomMarkerView = false;
            clearDrawableCache();
            updateTracksViewChanges();
            update(true);
        }
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.marker;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void addToMap(Object obj) {
        this.marker = ((MarkerManager.Collection) obj).addMarker(getMarkerOptions());
        updateTracksViewChanges();
    }

    @Override // com.rnmaps.maps.MapFeature
    public void removeFromMap(Object obj) {
        Marker marker = this.marker;
        if (marker == null) {
            return;
        }
        ((MarkerManager.Collection) obj).remove(marker);
        this.marker = null;
        updateTracksViewChanges();
    }

    private BitmapDescriptor getIcon() {
        if (this.hasCustomMarkerView) {
            if (this.iconBitmapDescriptor != null) {
                Bitmap bitmapCreateDrawable = createDrawable();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(this.iconBitmap.getWidth(), bitmapCreateDrawable.getWidth()), Math.max(this.iconBitmap.getHeight(), bitmapCreateDrawable.getHeight()), this.iconBitmap.getConfig());
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawBitmap(this.iconBitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
                canvas.drawBitmap(bitmapCreateDrawable, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
                return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
            }
            return BitmapDescriptorFactory.fromBitmap(createDrawable());
        }
        BitmapDescriptor bitmapDescriptor = this.iconBitmapDescriptor;
        return bitmapDescriptor != null ? bitmapDescriptor : BitmapDescriptorFactory.defaultMarker(this.markerHue);
    }

    private MarkerOptions fillMarkerOptions(MarkerOptions markerOptions) {
        markerOptions.position(this.position);
        if (this.anchorIsSet) {
            markerOptions.anchor(this.anchorX, this.anchorY);
        }
        if (this.calloutAnchorIsSet) {
            markerOptions.infoWindowAnchor(this.calloutAnchorX, this.calloutAnchorY);
        }
        markerOptions.title(this.title);
        markerOptions.snippet(this.snippet);
        markerOptions.rotation(this.rotation);
        markerOptions.flat(this.flat);
        markerOptions.draggable(this.draggable);
        markerOptions.zIndex(this.zIndex);
        markerOptions.alpha(this.opacity);
        markerOptions.icon(getIcon());
        return markerOptions;
    }

    public void update(boolean z) {
        if (this.marker == null) {
            return;
        }
        if (z) {
            updateMarkerIcon();
        }
        if (this.anchorIsSet) {
            this.marker.setAnchor(this.anchorX, this.anchorY);
        } else {
            this.marker.setAnchor(0.5f, 1.0f);
        }
        if (this.calloutAnchorIsSet) {
            this.marker.setInfoWindowAnchor(this.calloutAnchorX, this.calloutAnchorY);
        } else {
            this.marker.setInfoWindowAnchor(0.5f, BitmapDescriptorFactory.HUE_RED);
        }
    }

    public void update(int i, int i2) {
        this.width = i;
        this.height = i2;
        update(true);
    }

    private void clearDrawableCache() {
        this.mLastBitmapCreated = null;
    }

    private Bitmap createDrawable() {
        int i = this.width;
        if (i <= 0) {
            i = 100;
        }
        int i2 = this.height;
        int i3 = i2 > 0 ? i2 : 100;
        buildDrawingCache();
        Bitmap bitmapCreateBitmap = this.mLastBitmapCreated;
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.isRecycled() || bitmapCreateBitmap.getWidth() != i || bitmapCreateBitmap.getHeight() != i3) {
            bitmapCreateBitmap = Bitmap.createBitmap(i, i3, Bitmap.Config.ARGB_8888);
            this.mLastBitmapCreated = bitmapCreateBitmap;
        } else {
            bitmapCreateBitmap.eraseColor(0);
        }
        draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public void setCalloutView(MapCallout mapCallout) {
        this.calloutView = mapCallout;
    }

    public MapCallout getCalloutView() {
        return this.calloutView;
    }

    public View getCallout() {
        if (this.calloutView == null) {
            return null;
        }
        if (this.wrappedCalloutView == null) {
            wrapCalloutView();
        }
        if (this.calloutView.getTooltip()) {
            return this.wrappedCalloutView;
        }
        return null;
    }

    public View getInfoContents() {
        if (this.calloutView == null) {
            return null;
        }
        if (this.wrappedCalloutView == null) {
            wrapCalloutView();
        }
        if (this.calloutView.getTooltip()) {
            return null;
        }
        return this.wrappedCalloutView;
    }

    private void wrapCalloutView() {
        MapCallout mapCallout = this.calloutView;
        if (mapCallout == null || mapCallout.getChildCount() == 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        MapCallout mapCallout2 = this.calloutView;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(mapCallout2.width, mapCallout2.height, BitmapDescriptorFactory.HUE_RED));
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setOrientation(0);
        MapCallout mapCallout3 = this.calloutView;
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(mapCallout3.width, mapCallout3.height, BitmapDescriptorFactory.HUE_RED));
        linearLayout.addView(linearLayout2);
        linearLayout2.addView(this.calloutView);
        this.wrappedCalloutView = linearLayout;
    }

    private int getDrawableResourceByName(String str) {
        return getResources().getIdentifier(str, "drawable", getContext().getPackageName());
    }

    public boolean isLoadingImage() {
        return this.loadingImage;
    }

    public ImageManager.OnImageLoadedListener getImageLoadedListener() {
        return this.imageLoadedListener;
    }

    public void setImageLoadedListener(ImageManager.OnImageLoadedListener onImageLoadedListener) {
        this.imageLoadedListener = onImageLoadedListener;
    }

    public <T extends Event> void dispatchEvent(WritableMap writableMap, MapView.EventCreator<T> eventCreator) {
        ReactContext reactContext = (ReactContext) this.context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(eventCreator.create(UIManagerHelper.getSurfaceId(reactContext), getId(), writableMap));
        }
    }

    private BitmapDescriptor getBitmapDescriptorByName(String str) {
        return BitmapDescriptorFactory.fromResource(getDrawableResourceByName(str));
    }

    public static Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnPressEvent.EVENT_NAME));
        return builder.build();
    }

    public static Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(OnSelectEvent.EVENT_NAME, MapBuilder.of("registrationName", OnSelectEvent.EVENT_NAME), OnDeselectEvent.EVENT_NAME, MapBuilder.of("registrationName", OnDeselectEvent.EVENT_NAME), OnDragEvent.EVENT_NAME, MapBuilder.of("registrationName", OnDragEvent.EVENT_NAME), OnDragStartEvent.EVENT_NAME, MapBuilder.of("registrationName", OnDragStartEvent.EVENT_NAME), OnDragEndEvent.EVENT_NAME, MapBuilder.of("registrationName", OnDragEndEvent.EVENT_NAME));
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.height = i4 - i2;
        this.width = i3 - i;
    }
}
