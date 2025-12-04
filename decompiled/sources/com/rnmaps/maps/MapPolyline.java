package com.rnmaps.maps;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.maps.model.StrokeStyle;
import com.google.android.gms.maps.model.StyleSpan;
import com.google.maps.android.collections.PolylineManager;
import com.rnmaps.fabric.event.OnPressEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class MapPolyline extends MapFeature {
    private int color;
    private List coordinates;
    private boolean geodesic;
    private Cap lineCap;
    private List pattern;
    private ReadableArray patternValues;
    private Polyline polyline;
    private PolylineOptions polylineOptions;
    private List spans;
    private boolean tappable;
    private float width;
    private float zIndex;

    public MapPolyline(Context context) {
        super(context);
        this.lineCap = new RoundCap();
    }

    public void setCoordinates(ReadableArray readableArray) {
        this.coordinates = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            this.coordinates.add(i, new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setPoints(this.coordinates);
        }
    }

    public void setColor(int i) {
        this.color = i;
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setColor(i);
        }
    }

    public void setStrokeColors(ReadableArray readableArray) {
        StrokeStyle strokeStyleBuild;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            if (i == 0) {
                strokeStyleBuild = StrokeStyle.colorBuilder(readableArray.getInt(i)).build();
            } else {
                strokeStyleBuild = StrokeStyle.gradientBuilder(readableArray.getInt(i - 1), readableArray.getInt(i)).build();
            }
            arrayList.add(new StyleSpan(strokeStyleBuild));
        }
        this.spans = arrayList;
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setSpans(arrayList);
        }
    }

    public void setWidth(float f) {
        this.width = f;
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setWidth(f);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setZIndex(f);
        }
    }

    public void setTappable(boolean z) {
        this.tappable = z;
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setClickable(z);
        }
    }

    public void setGeodesic(boolean z) {
        this.geodesic = z;
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setGeodesic(z);
        }
    }

    public void setLineCap(Cap cap) {
        this.lineCap = cap;
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setStartCap(cap);
            this.polyline.setEndCap(cap);
        }
        applyPattern();
    }

    public void setLineDashPattern(ReadableArray readableArray) {
        this.patternValues = readableArray;
        applyPattern();
    }

    private void applyPattern() {
        SafeParcelable dash;
        if (this.patternValues == null) {
            return;
        }
        this.pattern = new ArrayList(this.patternValues.size());
        for (int i = 0; i < this.patternValues.size(); i++) {
            float f = (float) this.patternValues.getDouble(i);
            if (i % 2 != 0) {
                this.pattern.add(new Gap(f));
            } else {
                if (this.lineCap instanceof RoundCap) {
                    dash = new Dot();
                } else {
                    dash = new Dash(f);
                }
                this.pattern.add(dash);
            }
        }
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setPattern(this.pattern);
        }
    }

    public PolylineOptions getPolylineOptions() {
        if (this.polylineOptions == null) {
            this.polylineOptions = createPolylineOptions();
        }
        return this.polylineOptions;
    }

    private PolylineOptions createPolylineOptions() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.addAll(this.coordinates);
        polylineOptions.color(this.color);
        polylineOptions.width(this.width);
        polylineOptions.geodesic(this.geodesic);
        polylineOptions.zIndex(this.zIndex);
        polylineOptions.startCap(this.lineCap);
        polylineOptions.endCap(this.lineCap);
        polylineOptions.pattern(this.pattern);
        return polylineOptions;
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.polyline;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void addToMap(Object obj) {
        Polyline polylineAddPolyline = ((PolylineManager.Collection) obj).addPolyline(getPolylineOptions());
        this.polyline = polylineAddPolyline;
        polylineAddPolyline.setClickable(this.tappable);
        List<StyleSpan> list = this.spans;
        if (list != null) {
            this.polyline.setSpans(list);
        }
    }

    @Override // com.rnmaps.maps.MapFeature
    public void removeFromMap(Object obj) {
        ((PolylineManager.Collection) obj).remove(this.polyline);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setLineCap(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -894674659(0xffffffffcaac591d, float:-5647502.5)
            r2 = 1
            if (r0 == r1) goto L29
            r1 = 3035667(0x2e5213, float:4.253876E-39)
            if (r0 == r1) goto L1f
            r1 = 108704142(0x67ab18e, float:4.715022E-35)
            if (r0 == r1) goto L15
            goto L33
        L15:
            java.lang.String r0 = "round"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L33
            r4 = 0
            goto L34
        L1f:
            java.lang.String r0 = "butt"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L33
            r4 = 2
            goto L34
        L29:
            java.lang.String r0 = "square"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L33
            r4 = r2
            goto L34
        L33:
            r4 = -1
        L34:
            if (r4 == 0) goto L44
            if (r4 == r2) goto L3e
            com.google.android.gms.maps.model.ButtCap r4 = new com.google.android.gms.maps.model.ButtCap
            r4.<init>()
            goto L49
        L3e:
            com.google.android.gms.maps.model.SquareCap r4 = new com.google.android.gms.maps.model.SquareCap
            r4.<init>()
            goto L49
        L44:
            com.google.android.gms.maps.model.RoundCap r4 = new com.google.android.gms.maps.model.RoundCap
            r4.<init>()
        L49:
            r3.setLineCap(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapPolyline.setLineCap(java.lang.String):void");
    }

    public static Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnPressEvent.EVENT_NAME));
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setLineJoin(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 93630586(0x594b07a, float:1.398268E-35)
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = 103906565(0x6317d05, float:3.338185E-35)
            if (r0 == r1) goto L21
            r1 = 108704142(0x67ab18e, float:4.715022E-35)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "round"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r3
            goto L36
        L21:
            java.lang.String r0 = "miter"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r2
            goto L36
        L2b:
            java.lang.String r0 = "bevel"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r4
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3d
            if (r6 == r4) goto L3c
            r2 = r3
            goto L3d
        L3c:
            r2 = r4
        L3d:
            com.google.android.gms.maps.model.Polyline r5 = r5.polyline
            if (r5 == 0) goto L44
            r5.setJointType(r2)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapPolyline.setLineJoin(java.lang.String):void");
    }
}
