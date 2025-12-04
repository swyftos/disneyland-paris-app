package com.urbanairship.analytics.location;

import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import com.urbanairship.UALog;

/* loaded from: classes4.dex */
public class CircularRegion {
    public static final int MAX_RADIUS = 100000;
    private final double latitude;
    private final double longitude;
    private final double radius;

    public CircularRegion(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 100000.0d) double d, @FloatRange(from = RegionEvent.MIN_LATITUDE, to = RegionEvent.MAX_LATITUDE) double d2, @FloatRange(from = RegionEvent.MIN_LONGITUDE, to = RegionEvent.MAX_LONGITUDE) double d3) {
        this.radius = d;
        this.latitude = d2;
        this.longitude = d3;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public boolean isValid() {
        double d = this.radius;
        if (d > 100000.0d || d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            UALog.e("The radius must be greater than %s and less than or equal to %s meters.", 0, 100000);
            return false;
        }
        if (!RegionEvent.regionEventLatitudeIsValid(Double.valueOf(this.latitude))) {
            UALog.e("The latitude must be greater than or equal to %s and less than or equal to %s degrees.", Double.valueOf(-90.0d), Double.valueOf(90.0d));
            return false;
        }
        if (RegionEvent.regionEventLongitudeIsValid(Double.valueOf(this.longitude))) {
            return true;
        }
        UALog.e("The longitude must be greater than or equal to %s and less than or equal to %s degrees.", Double.valueOf(-180.0d), Double.valueOf(180.0d));
        return false;
    }
}
