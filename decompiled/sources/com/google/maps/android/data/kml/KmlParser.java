package com.google.maps.android.data.kml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
class KmlParser {
    private final XmlPullParser mParser;
    private final HashMap mPlacemarks = new HashMap();
    private final ArrayList mContainers = new ArrayList();
    private final HashMap mStyles = new HashMap();
    private final HashMap mStyleMaps = new HashMap();
    private final HashMap mGroundOverlays = new HashMap();

    KmlParser(XmlPullParser xmlPullParser) {
        this.mParser = xmlPullParser;
    }

    void parseKml() throws XmlPullParserException, IOException {
        int eventType = this.mParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.mParser.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|NetworkLink|NetworkLinkControl|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    skip(this.mParser);
                }
                if (this.mParser.getName().matches("Folder|Document")) {
                    this.mContainers.add(KmlContainerParser.createContainer(this.mParser));
                }
                if (this.mParser.getName().equals("Style")) {
                    KmlStyle kmlStyleCreateStyle = KmlStyleParser.createStyle(this.mParser);
                    this.mStyles.put(kmlStyleCreateStyle.getStyleId(), kmlStyleCreateStyle);
                }
                if (this.mParser.getName().equals("StyleMap")) {
                    this.mStyleMaps.putAll(KmlStyleParser.createStyleMap(this.mParser));
                }
                if (this.mParser.getName().equals("Placemark")) {
                    this.mPlacemarks.put(KmlFeatureParser.createPlacemark(this.mParser), null);
                }
                if (this.mParser.getName().equals("GroundOverlay")) {
                    this.mGroundOverlays.put(KmlFeatureParser.createGroundOverlay(this.mParser), null);
                }
            }
            eventType = this.mParser.next();
        }
        this.mStyles.put(null, new KmlStyle());
    }

    HashMap getStyles() {
        return this.mStyles;
    }

    HashMap getPlacemarks() {
        return this.mPlacemarks;
    }

    HashMap getStyleMaps() {
        return this.mStyleMaps;
    }

    ArrayList getContainers() {
        return this.mContainers;
    }

    HashMap getGroundOverlays() {
        return this.mGroundOverlays;
    }

    static void skip(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
