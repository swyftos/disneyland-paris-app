package com.rnmaps.maps;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.maps.model.SquareCap;
import com.google.android.gms.maps.model.StrokeStyle;
import com.google.android.gms.maps.model.StyleSpan;
import com.google.maps.android.collections.PolylineManager;
import com.rnmaps.fabric.event.OnPressEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
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

    /* JADX WARN: Code duplicated, block: B:18:0x0033  */
    public void setLineCap(String str) {
        byte b;
        Cap roundCap;
        int iHashCode = str.hashCode();
        if (iHashCode != -894674659) {
            if (iHashCode != 3035667) {
                if (iHashCode == 108704142 && str.equals("round")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("butt")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals("square")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b == 0) {
            roundCap = new RoundCap();
        } else if (b == 1) {
            roundCap = new SquareCap();
        } else {
            roundCap = new ButtCap();
        }
        setLineCap(roundCap);
    }

    public static Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnPressEvent.EVENT_NAME, MapBuilder.m1373of("registrationName", OnPressEvent.EVENT_NAME));
        return builder.build();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    public void setLineJoin(String str) {
        byte b;
        int iHashCode = str.hashCode();
        int i = 2;
        if (iHashCode != 93630586) {
            if (iHashCode != 103906565) {
                if (iHashCode == 108704142 && str.equals("round")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("miter")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals("bevel")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            i = b != 1 ? 0 : 1;
        }
        Polyline polyline = this.polyline;
        if (polyline != null) {
            polyline.setJointType(i);
        }
    }
}
