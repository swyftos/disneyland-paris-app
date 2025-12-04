package com.amazonaws;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RequestClientOptions {
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 131073;
    private final Map markers = new EnumMap(Marker.class);

    public enum Marker {
        USER_AGENT
    }

    @Deprecated
    public String getClientMarker() {
        return getClientMarker(Marker.USER_AGENT);
    }

    public String getClientMarker(Marker marker) {
        return (String) this.markers.get(marker);
    }

    public void putClientMarker(Marker marker, String str) {
        this.markers.put(marker, str);
    }

    @Deprecated
    public void addClientMarker(String str) {
        appendUserAgent(str);
    }

    public void appendUserAgent(String str) {
        Map map = this.markers;
        Marker marker = Marker.USER_AGENT;
        String str2 = (String) map.get(marker);
        if (str2 == null) {
            str2 = "";
        }
        putClientMarker(marker, createUserAgentMarkerString(str2, str));
    }

    private String createUserAgentMarkerString(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str + " " + str2;
    }
}
