package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import com.google.maps.android.data.Renderer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class KmlRenderer extends Renderer {
    private ArrayList mContainers;
    private boolean mGroundOverlayImagesDownloaded;
    private final Set mGroundOverlayUrls;
    private boolean mMarkerIconsDownloaded;

    KmlRenderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) {
        super(googleMap, context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
        this.mGroundOverlayUrls = new HashSet();
        this.mMarkerIconsDownloaded = false;
        this.mGroundOverlayImagesDownloaded = false;
    }

    private void removePlacemarks(HashMap map) {
        removeFeatures((HashMap<? extends Feature, Object>) map);
    }

    static boolean getContainerVisibility(KmlContainer kmlContainer, boolean z) {
        return z && (!kmlContainer.hasProperty("visibility") || Integer.parseInt(kmlContainer.getProperty("visibility")) != 0);
    }

    private void removeContainers(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            removePlacemarks(kmlContainer.getPlacemarksHashMap());
            removeGroundOverlays(kmlContainer.getGroundOverlayHashMap());
            removeContainers(kmlContainer.getContainers());
        }
    }

    public void addLayerToMap() {
        setLayerVisibility(true);
        this.mContainers = getContainerList();
        putStyles();
        assignStyleMap(getStyleMaps(), getStylesRenderer());
        addGroundOverlays(getGroundOverlayMap(), this.mContainers);
        addContainerGroupToMap(this.mContainers, true);
        addPlacemarksToMap(getAllFeatures());
        if (!this.mGroundOverlayImagesDownloaded) {
            downloadGroundOverlays();
        }
        if (!this.mMarkerIconsDownloaded) {
            downloadMarkerIcons();
        }
        checkClearBitmapCache();
    }

    void storeKmlData(HashMap map, HashMap map2, HashMap map3, ArrayList arrayList, HashMap map4) {
        storeData(map, map2, map3, arrayList, map4);
    }

    void storeKmzData(HashMap map, HashMap map2, HashMap map3, ArrayList arrayList, HashMap map4, HashMap map5) {
        storeData(map, map2, map3, arrayList, map4);
        for (Map.Entry entry : map5.entrySet()) {
            cacheBitmap((String) entry.getKey(), (Bitmap) entry.getValue());
        }
    }

    @Override // com.google.maps.android.data.Renderer
    public void setMap(GoogleMap googleMap) {
        removeLayerFromMap();
        super.setMap(googleMap);
        addLayerToMap();
    }

    public boolean hasNestedContainers() {
        return this.mContainers.size() > 0;
    }

    public Iterable<KmlContainer> getNestedContainers() {
        return this.mContainers;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return getGroundOverlayMap().keySet();
    }

    public void removeLayerFromMap() {
        removePlacemarks(getAllFeatures());
        removeGroundOverlays(getGroundOverlayMap());
        if (hasNestedContainers()) {
            removeContainers(getNestedContainers());
        }
        setLayerVisibility(false);
        clearStylesRenderer();
    }

    private void addPlacemarksToMap(HashMap map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            addFeature((Feature) it.next());
        }
    }

    private void addContainerGroupToMap(Iterable iterable, boolean z) throws NumberFormatException {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            boolean containerVisibility = getContainerVisibility(kmlContainer, z);
            if (kmlContainer.getStyles() != null) {
                putStyles(kmlContainer.getStyles());
            }
            if (kmlContainer.getStyleMap() != null) {
                super.assignStyleMap(kmlContainer.getStyleMap(), getStylesRenderer());
            }
            addContainerObjectToMap(kmlContainer, containerVisibility);
            if (kmlContainer.hasContainers()) {
                addContainerGroupToMap(kmlContainer.getContainers(), containerVisibility);
            }
        }
    }

    private void addContainerObjectToMap(KmlContainer kmlContainer, boolean z) throws NumberFormatException {
        for (KmlPlacemark kmlPlacemark : kmlContainer.getPlacemarks()) {
            boolean z2 = z && Renderer.getPlacemarkVisibility(kmlPlacemark);
            if (kmlPlacemark.getGeometry() != null) {
                String id = kmlPlacemark.getId();
                Geometry geometry = kmlPlacemark.getGeometry();
                KmlStyle placemarkStyle = getPlacemarkStyle(id);
                KmlPlacemark kmlPlacemark2 = kmlPlacemark;
                Object objAddKmlPlacemarkToMap = addKmlPlacemarkToMap(kmlPlacemark2, geometry, placemarkStyle, kmlPlacemark2.getInlineStyle(), z2);
                kmlContainer.setPlacemark(kmlPlacemark2, objAddKmlPlacemarkToMap);
                putContainerFeature(objAddKmlPlacemarkToMap, kmlPlacemark);
            }
        }
    }

    private void downloadMarkerIcons() {
        this.mMarkerIconsDownloaded = true;
        Iterator<String> it = getMarkerIconUrls().iterator();
        while (it.hasNext()) {
            new MarkerIconImageDownload(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIconToMarkers(String str, HashMap map) {
        for (Feature feature : map.keySet()) {
            addIconToGeometry(str, getStylesRenderer().get(feature.getId()), ((KmlPlacemark) feature).getInlineStyle(), feature.getGeometry(), map.get(feature));
        }
    }

    private void addIconToGeometry(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, Geometry geometry, Object obj) {
        if (geometry == null) {
            return;
        }
        if ("Point".equals(geometry.getGeometryType())) {
            addIconToMarker(str, kmlStyle, kmlStyle2, (Marker) obj);
        } else if ("MultiGeometry".equals(geometry.getGeometryType())) {
            addIconToMultiGeometry(str, kmlStyle, kmlStyle2, (MultiGeometry) geometry, (List) obj);
        }
    }

    private void addIconToMultiGeometry(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, MultiGeometry multiGeometry, List list) {
        Iterator<Geometry> it = multiGeometry.getGeometryObject().iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext() && it2.hasNext()) {
            addIconToGeometry(str, kmlStyle, kmlStyle2, it.next(), it2.next());
        }
    }

    private void addIconToMarker(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, Marker marker) {
        boolean z = false;
        boolean z2 = kmlStyle2 != null && str.equals(kmlStyle2.getIconUrl());
        if (kmlStyle != null && str.equals(kmlStyle.getIconUrl())) {
            z = true;
        }
        if (z2) {
            scaleBitmap(kmlStyle2, marker);
        } else if (z) {
            scaleBitmap(kmlStyle, marker);
        }
    }

    private void scaleBitmap(KmlStyle kmlStyle, Marker marker) {
        marker.setIcon(getCachedMarkerImage(kmlStyle.getIconUrl(), kmlStyle.getIconScale()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addContainerGroupIconsToMarkers(String str, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            addIconToMarkers(str, kmlContainer.getPlacemarksHashMap());
            if (kmlContainer.hasContainers()) {
                addContainerGroupIconsToMarkers(str, kmlContainer.getContainers());
            }
        }
    }

    private void addGroundOverlays(HashMap map, Iterable iterable) {
        addGroundOverlays(map);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            addGroundOverlays(kmlContainer.getGroundOverlayHashMap(), kmlContainer.getContainers());
        }
    }

    private void addGroundOverlays(HashMap map) {
        for (KmlGroundOverlay kmlGroundOverlay : map.keySet()) {
            String imageUrl = kmlGroundOverlay.getImageUrl();
            if (imageUrl != null && kmlGroundOverlay.getLatLngBox() != null) {
                if (getCachedGroundOverlayImage(imageUrl) != null) {
                    addGroundOverlayToMap(imageUrl, map, true);
                } else {
                    this.mGroundOverlayUrls.add(imageUrl);
                }
            }
        }
    }

    private void downloadGroundOverlays() {
        this.mGroundOverlayImagesDownloaded = true;
        Iterator it = this.mGroundOverlayUrls.iterator();
        while (it.hasNext()) {
            new GroundOverlayImageDownload((String) it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGroundOverlayToMap(String str, HashMap map, boolean z) {
        BitmapDescriptor cachedGroundOverlayImage = getCachedGroundOverlayImage(str);
        for (KmlGroundOverlay kmlGroundOverlay : map.keySet()) {
            if (kmlGroundOverlay.getImageUrl().equals(str)) {
                GroundOverlay groundOverlayAttachGroundOverlay = attachGroundOverlay(kmlGroundOverlay.getGroundOverlayOptions().image(cachedGroundOverlayImage));
                if (!z) {
                    groundOverlayAttachGroundOverlay.setVisible(false);
                }
                map.put(kmlGroundOverlay, groundOverlayAttachGroundOverlay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGroundOverlayInContainerGroups(String str, Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            boolean containerVisibility = getContainerVisibility(kmlContainer, z);
            addGroundOverlayToMap(str, kmlContainer.getGroundOverlayHashMap(), containerVisibility);
            if (kmlContainer.hasContainers()) {
                addGroundOverlayInContainerGroups(str, kmlContainer.getContainers(), containerVisibility);
            }
        }
    }

    private class MarkerIconImageDownload extends AsyncTask {
        private final String mIconUrl;

        public MarkerIconImageDownload(String str) {
            this.mIconUrl = str;
            KmlRenderer.this.downloadStarted();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mIconUrl);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.mIconUrl);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                KmlRenderer.this.cacheBitmap(this.mIconUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addIconToMarkers(this.mIconUrl, kmlRenderer.getAllFeatures());
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addContainerGroupIconsToMarkers(this.mIconUrl, kmlRenderer2.mContainers);
                }
            } else {
                Log.e("KmlRenderer", "Image at this URL could not be found " + this.mIconUrl);
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    private class GroundOverlayImageDownload extends AsyncTask {
        private final String mGroundOverlayUrl;

        public GroundOverlayImageDownload(String str) {
            this.mGroundOverlayUrl = str;
            KmlRenderer.this.downloadStarted();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mGroundOverlayUrl);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.mGroundOverlayUrl);
            } catch (IOException e) {
                Log.e("KmlRenderer", "Image [" + this.mGroundOverlayUrl + "] download issue", e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                KmlRenderer.this.cacheBitmap(this.mGroundOverlayUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addGroundOverlayToMap(this.mGroundOverlayUrl, kmlRenderer.getGroundOverlayMap(), true);
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addGroundOverlayInContainerGroups(this.mGroundOverlayUrl, kmlRenderer2.mContainers, true);
                }
            } else {
                Log.e("KmlRenderer", "Image at this URL could not be found " + this.mGroundOverlayUrl);
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getBitmapFromUrl(String str) {
        return BitmapFactory.decodeStream(openConnectionCheckRedirects(new URL(str).openConnection()));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.InputStream openConnectionCheckRedirects(java.net.URLConnection r6) throws java.io.IOException {
        /*
            r5 = this;
            r5 = 0
            r0 = r5
        L2:
            boolean r1 = r6 instanceof java.net.HttpURLConnection
            if (r1 == 0) goto Lc
            r2 = r6
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
            r2.setInstanceFollowRedirects(r5)
        Lc:
            java.io.InputStream r2 = com.appdynamics.eumagent.runtime.InstrumentationCallbacks.getInputStream(r6)
            if (r1 == 0) goto L82
            r1 = r6
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestAboutToBeSent(r1)
            int r3 = r1.getResponseCode()     // Catch: java.io.IOException -> L7d
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestHarvestable(r1)     // Catch: java.io.IOException -> L7d
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 < r4) goto L82
            r4 = 307(0x133, float:4.3E-43)
            if (r3 > r4) goto L82
            r4 = 306(0x132, float:4.29E-43)
            if (r3 == r4) goto L82
            r4 = 304(0x130, float:4.26E-43)
            if (r3 == r4) goto L82
            java.net.URL r6 = r1.getURL()
            java.lang.String r3 = "Location"
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestAboutToBeSent(r1)
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch: java.io.IOException -> L78
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestHarvestable(r1)     // Catch: java.io.IOException -> L78
            if (r3 == 0) goto L47
            java.net.URL r4 = new java.net.URL
            r4.<init>(r6, r3)
            goto L48
        L47:
            r4 = 0
        L48:
            r1.disconnect()
            if (r4 == 0) goto L70
            java.lang.String r6 = r4.getProtocol()
            java.lang.String r1 = "http"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L65
            java.lang.String r6 = r4.getProtocol()
            java.lang.String r1 = "https"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L70
        L65:
            r6 = 5
            if (r0 >= r6) goto L70
            java.net.URLConnection r6 = r4.openConnection()
            int r0 = r0 + 1
            r1 = 1
            goto L83
        L70:
            java.lang.SecurityException r5 = new java.lang.SecurityException
            java.lang.String r6 = "illegal URL redirect"
            r5.<init>(r6)
            throw r5
        L78:
            r5 = move-exception
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.networkError(r1, r5)
            throw r5
        L7d:
            r5 = move-exception
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.networkError(r1, r5)
            throw r5
        L82:
            r1 = r5
        L83:
            if (r1 != 0) goto L2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.kml.KmlRenderer.openConnectionCheckRedirects(java.net.URLConnection):java.io.InputStream");
    }
}
