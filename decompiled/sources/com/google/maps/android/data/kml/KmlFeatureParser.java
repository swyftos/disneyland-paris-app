package com.google.maps.android.data.kml;

import com.amazonaws.util.DateUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
abstract class KmlFeatureParser {

    private static class LatLngAlt {
        public final Double altitude;
        public final LatLng latLng;

        LatLngAlt(LatLng latLng, Double d) {
            this.latLng = latLng;
            this.altitude = d;
        }
    }

    static KmlPlacemark createPlacemark(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        int eventType = xmlPullParser.getEventType();
        Geometry geometryCreateGeometry = null;
        String strNextText = null;
        KmlStyle kmlStyleCreateStyle = null;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Placemark")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("styleUrl")) {
                        strNextText = xmlPullParser.nextText();
                    } else if (xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry|Track|MultiTrack")) {
                        geometryCreateGeometry = createGeometry(xmlPullParser, xmlPullParser.getName());
                    } else if (xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber")) {
                        map.put(xmlPullParser.getName(), xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("ExtendedData")) {
                        map.putAll(setExtendedDataProperties(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("Style")) {
                        kmlStyleCreateStyle = KmlStyleParser.createStyle(xmlPullParser);
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlPlacemark(geometryCreateGeometry, strNextText, kmlStyleCreateStyle, map);
            }
        }
    }

    static KmlGroundOverlay createGroundOverlay(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, NumberFormatException {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int eventType = xmlPullParser.getEventType();
        String imageUrl = null;
        float rotation = 0.0f;
        int i = 1;
        float f = 0.0f;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("GroundOverlay")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("Icon")) {
                        imageUrl = getImageUrl(xmlPullParser);
                    } else if (xmlPullParser.getName().equals("drawOrder")) {
                        f = Float.parseFloat(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("visibility")) {
                        i = Integer.parseInt(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("ExtendedData")) {
                        map.putAll(setExtendedDataProperties(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("rotation")) {
                        rotation = getRotation(xmlPullParser);
                    } else if (xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber") || xmlPullParser.getName().equals("color")) {
                        map.put(xmlPullParser.getName(), xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().matches("north|south|east|west")) {
                        map2.put(xmlPullParser.getName(), Double.valueOf(Double.parseDouble(xmlPullParser.nextText())));
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlGroundOverlay(imageUrl, createLatLngBounds((Double) map2.get("north"), (Double) map2.get("south"), (Double) map2.get("east"), (Double) map2.get("west")), f, i, map, rotation);
            }
        }
    }

    private static float getRotation(XmlPullParser xmlPullParser) {
        return -Float.parseFloat(xmlPullParser.nextText());
    }

    private static String getImageUrl(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Icon")) {
                return null;
            }
            if (eventType == 2 && xmlPullParser.getName().equals("href")) {
                return xmlPullParser.nextText();
            }
            eventType = xmlPullParser.next();
        }
    }

    private static Geometry createGeometry(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(str)) {
                return null;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Point")) {
                    return createPoint(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("LineString")) {
                    return createLineString(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("Track")) {
                    return createTrack(xmlPullParser);
                }
                if (xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                    return createPolygon(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("MultiGeometry")) {
                    return createMultiGeometry(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("MultiTrack")) {
                    return createMultiTrack(xmlPullParser);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static HashMap setExtendedDataProperties(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        int eventType = xmlPullParser.getEventType();
        String attributeValue = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("ExtendedData")) {
                return map;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Data")) {
                    attributeValue = xmlPullParser.getAttributeValue(null, "name");
                } else if (xmlPullParser.getName().equals("value") && attributeValue != null) {
                    map.put(attributeValue, xmlPullParser.nextText());
                    attributeValue = null;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static KmlPoint createPoint(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        LatLngAlt latLngAltConvertToLatLngAlt = null;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Point")) {
                if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                    latLngAltConvertToLatLngAlt = convertToLatLngAlt(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlPoint(latLngAltConvertToLatLngAlt.latLng, latLngAltConvertToLatLngAlt.altitude);
            }
        }
    }

    private static KmlLineString createLineString(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("LineString")) {
                if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                    for (LatLngAlt latLngAlt : convertToLatLngAltArray(xmlPullParser.nextText())) {
                        arrayList.add(latLngAlt.latLng);
                        Double d = latLngAlt.altitude;
                        if (d != null) {
                            arrayList2.add(d);
                        }
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlLineString(arrayList, arrayList2);
            }
        }
    }

    private static KmlTrack createTrack(XmlPullParser xmlPullParser) throws XmlPullParserException, NumberFormatException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ALTERNATE_ISO8601_DATE_PATTERN, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap map = new HashMap();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Track")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("coord")) {
                        LatLngAlt latLngAltConvertToLatLngAlt = convertToLatLngAlt(xmlPullParser.nextText(), " ");
                        arrayList.add(latLngAltConvertToLatLngAlt.latLng);
                        Double d = latLngAltConvertToLatLngAlt.altitude;
                        if (d != null) {
                            arrayList2.add(d);
                        }
                    } else if (xmlPullParser.getName().equals("when")) {
                        try {
                            arrayList3.add(Long.valueOf(simpleDateFormat.parse(xmlPullParser.nextText()).getTime()));
                        } catch (ParseException e) {
                            throw new XmlPullParserException("Invalid date", xmlPullParser, e);
                        }
                    } else if (xmlPullParser.getName().equals("ExtendedData")) {
                        map.putAll(setExtendedDataProperties(xmlPullParser));
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlTrack(arrayList, arrayList2, arrayList3, map);
            }
        }
    }

    private static KmlPolygon createPolygon(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        boolean zEquals = false;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().matches("outerBoundaryIs|innerBoundaryIs")) {
                        zEquals = xmlPullParser.getName().equals("outerBoundaryIs");
                    } else if (xmlPullParser.getName().equals("coordinates")) {
                        if (zEquals) {
                            arrayList = convertToLatLngArray(xmlPullParser.nextText());
                        } else {
                            arrayList2.add(convertToLatLngArray(xmlPullParser.nextText()));
                        }
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlPolygon(arrayList, arrayList2);
            }
        }
    }

    private static KmlMultiGeometry createMultiGeometry(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int next = xmlPullParser.next();
        while (true) {
            if (next != 3 || !xmlPullParser.getName().equals("MultiGeometry")) {
                if (next == 2 && xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry|Track|MultiTrack")) {
                    arrayList.add(createGeometry(xmlPullParser, xmlPullParser.getName()));
                }
                next = xmlPullParser.next();
            } else {
                return new KmlMultiGeometry(arrayList);
            }
        }
    }

    private static KmlMultiTrack createMultiTrack(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int next = xmlPullParser.next();
        while (true) {
            if (next != 3 || !xmlPullParser.getName().equals("MultiTrack")) {
                if (next == 2 && xmlPullParser.getName().matches("Track")) {
                    arrayList.add(createTrack(xmlPullParser));
                }
                next = xmlPullParser.next();
            } else {
                return new KmlMultiTrack(arrayList);
            }
        }
    }

    private static ArrayList convertToLatLngArray(String str) {
        ArrayList arrayListConvertToLatLngAltArray = convertToLatLngAltArray(str);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListConvertToLatLngAltArray.iterator();
        while (it.hasNext()) {
            arrayList.add(((LatLngAlt) it.next()).latLng);
        }
        return arrayList;
    }

    private static ArrayList convertToLatLngAltArray(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("(\\s+)")) {
            arrayList.add(convertToLatLngAlt(str2));
        }
        return arrayList;
    }

    private static LatLngAlt convertToLatLngAlt(String str) {
        return convertToLatLngAlt(str, ",");
    }

    private static LatLngAlt convertToLatLngAlt(String str, String str2) throws NumberFormatException {
        String[] strArrSplit = str.split(str2);
        if (strArrSplit.length < 2) {
            throw new IllegalArgumentException("Wrong coordinate, latitude and longitude must be set");
        }
        return new LatLngAlt(new LatLng(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0])), strArrSplit.length > 2 ? Double.valueOf(Double.parseDouble(strArrSplit[2])) : null);
    }

    private static LatLngBounds createLatLngBounds(Double d, Double d2, Double d3, Double d4) {
        return new LatLngBounds(new LatLng(d2.doubleValue(), d4.doubleValue()), new LatLng(d.doubleValue(), d3.doubleValue()));
    }
}
