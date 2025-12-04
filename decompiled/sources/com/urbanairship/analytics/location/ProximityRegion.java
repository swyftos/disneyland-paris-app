package com.urbanairship.analytics.location;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.urbanairship.UALog;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes4.dex */
public class ProximityRegion {
    private Double latitude;
    private Double longitude;
    private final int major;
    private final int minor;
    private final String proximityId;
    private Integer rssi;

    public ProximityRegion(@NonNull String str, @IntRange(from = 0, to = WebSocketProtocol.PAYLOAD_SHORT_MAX) int i, @IntRange(from = 0, to = WebSocketProtocol.PAYLOAD_SHORT_MAX) int i2) {
        this.proximityId = str;
        this.major = i;
        this.minor = i2;
    }

    public void setCoordinates(@Nullable @FloatRange(from = RegionEvent.MIN_LATITUDE, to = RegionEvent.MAX_LATITUDE) Double d, @Nullable @FloatRange(from = RegionEvent.MIN_LONGITUDE, to = RegionEvent.MAX_LONGITUDE) Double d2) {
        if (d == null || d2 == null) {
            this.latitude = null;
            this.longitude = null;
        } else if (!RegionEvent.regionEventLatitudeIsValid(d)) {
            UALog.e("The latitude must be greater than or equal to %s and less than or equal to %s degrees.", Double.valueOf(-90.0d), Double.valueOf(90.0d));
            this.latitude = null;
        } else if (!RegionEvent.regionEventLongitudeIsValid(d2)) {
            UALog.e("The longitude must be greater than or equal to %s and less than or equal to %s degrees.", Double.valueOf(-180.0d), Double.valueOf(180.0d));
            this.longitude = null;
        } else {
            this.latitude = d;
            this.longitude = d2;
        }
    }

    public void setRssi(@IntRange(from = -100, to = WebToNativeBridgeBase.CLOSE_WAIT_DURATION_MILLISECONDS) @Nullable Integer num) {
        if (num == null) {
            this.rssi = null;
        } else if (num.intValue() > 100 || num.intValue() < -100) {
            UALog.e("The rssi must be greater than or equal to %s and less than or equal to %s dBm.", -100, 100);
            this.rssi = null;
        } else {
            this.rssi = num;
        }
    }

    @NonNull
    public String getProximityId() {
        return this.proximityId;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    @Nullable
    public Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public Double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public Integer getRssi() {
        return this.rssi;
    }

    public boolean isValid() {
        String str = this.proximityId;
        if (str == null) {
            UALog.e("The proximity ID must not be null.", new Object[0]);
            return false;
        }
        if (!RegionEvent.regionEventCharacterCountIsValid(str)) {
            UALog.e("The proximity ID must not be greater than %s or less than %s characters in length.", 255, 1);
            return false;
        }
        int i = this.major;
        if (i > 65535 || i < 0) {
            UALog.e("The major must not be greater than 65535 or less than 0.", new Object[0]);
            return false;
        }
        int i2 = this.minor;
        if (i2 <= 65535 && i2 >= 0) {
            return true;
        }
        UALog.e("The minor must not be greater than %s or less than %s.", 65535, 0);
        return false;
    }
}
