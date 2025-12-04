package com.urbanairship.analytics.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.collection.ScatterMapKt;
import com.urbanairship.UALog;
import com.urbanairship.analytics.ConversionData;
import com.urbanairship.analytics.Event;
import com.urbanairship.analytics.EventType;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.Checks;
import com.urbanairship.util.UAStringUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes4.dex */
public class RegionEvent extends Event implements JsonSerializable {
    public static final int BOUNDARY_EVENT_ENTER = 1;
    public static final int BOUNDARY_EVENT_EXIT = 2;
    public static final int MAX_CHARACTER_LENGTH = 255;
    public static final double MAX_LATITUDE = 90.0d;
    public static final double MAX_LONGITUDE = 180.0d;
    public static final double MIN_LATITUDE = -90.0d;
    public static final double MIN_LONGITUDE = -180.0d;

    @NonNull
    public static final String REGION_ID = "region_id";
    private final int boundaryEvent;
    private final CircularRegion circularRegion;
    private final ProximityRegion proximityRegion;
    private final String regionId;
    private final String source;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Boundary {
    }

    @Override // com.urbanairship.analytics.Event
    public int getPriority() {
        return 2;
    }

    private RegionEvent(Builder builder) {
        this.regionId = builder.regionId;
        this.source = builder.source;
        this.boundaryEvent = builder.boundaryEvent;
        this.circularRegion = builder.circularRegion;
        this.proximityRegion = builder.proximityRegion;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.urbanairship.analytics.Event
    @NonNull
    public final EventType getType() {
        if (this.boundaryEvent == 1) {
            return EventType.REGION_ENTER;
        }
        return EventType.REGION_EXIT;
    }

    public int getBoundaryEvent() {
        return this.boundaryEvent;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getRegionId() {
        return this.regionId;
    }

    @Override // com.urbanairship.analytics.Event
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final JsonMap getEventData(@NonNull ConversionData conversionData) {
        return createEventData();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return createEventData().toJsonValue();
    }

    private JsonMap createEventData() {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put(REGION_ID, this.regionId).put("source", this.source).put("action", this.boundaryEvent == 1 ? "enter" : "exit");
        ProximityRegion proximityRegion = this.proximityRegion;
        if (proximityRegion != null && proximityRegion.isValid()) {
            JsonMap.Builder builderPutOpt = JsonMap.newBuilder().put("proximity_id", this.proximityRegion.getProximityId()).put("major", this.proximityRegion.getMajor()).put("minor", this.proximityRegion.getMinor()).putOpt("rssi", this.proximityRegion.getRssi());
            if (this.proximityRegion.getLatitude() != null) {
                builderPutOpt.put("latitude", Double.toString(this.proximityRegion.getLatitude().doubleValue()));
            }
            if (this.proximityRegion.getLongitude() != null) {
                builderPutOpt.put("longitude", Double.toString(this.proximityRegion.getLongitude().doubleValue()));
            }
            builderPut.put("proximity", builderPutOpt.build());
        }
        CircularRegion circularRegion = this.circularRegion;
        if (circularRegion != null && circularRegion.isValid()) {
            JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
            Locale locale = Locale.US;
            builderPut.put("circular_region", builderNewBuilder.put("radius", String.format(locale, "%.1f", Double.valueOf(this.circularRegion.getRadius()))).put("latitude", String.format(locale, "%.7f", Double.valueOf(this.circularRegion.getLatitude()))).put("longitude", String.format(locale, "%.7f", Double.valueOf(this.circularRegion.getLongitude()))).build());
        }
        return builderPut.build();
    }

    static boolean regionEventCharacterCountIsValid(String str) {
        return str.length() <= 255 && str.length() > 0;
    }

    static boolean regionEventLatitudeIsValid(Double d) {
        return d.doubleValue() <= 90.0d && d.doubleValue() >= -90.0d;
    }

    static boolean regionEventLongitudeIsValid(Double d) {
        return d.doubleValue() <= 180.0d && d.doubleValue() >= -180.0d;
    }

    @Override // com.urbanairship.analytics.Event
    public boolean isValid() {
        String str = this.regionId;
        if (str == null || this.source == null) {
            UALog.e("The region ID and source must not be null.", new Object[0]);
            return false;
        }
        if (!regionEventCharacterCountIsValid(str)) {
            UALog.e("The region ID must not be greater than %s or less than %s characters in length.", 255, 1);
            return false;
        }
        if (!regionEventCharacterCountIsValid(this.source)) {
            UALog.e("The source must not be greater than %s or less than %s characters in length.", 255, 1);
            return false;
        }
        int i = this.boundaryEvent;
        if (i >= 1 && i <= 2) {
            return true;
        }
        UALog.e("The boundary event must either be an entrance (%s) or an exit (%s).", 1, 2);
        return false;
    }

    public static class Builder {
        private int boundaryEvent;
        private CircularRegion circularRegion;
        private ProximityRegion proximityRegion;
        private String regionId;
        private String source;

        private Builder() {
        }

        @NonNull
        public Builder setRegionId(@NonNull @Size(max = ScatterMapKt.Sentinel, min = 1) String str) {
            this.regionId = str;
            return this;
        }

        @NonNull
        public Builder setSource(@NonNull @Size(max = ScatterMapKt.Sentinel, min = 1) String str) {
            this.source = str;
            return this;
        }

        @NonNull
        public Builder setBoundaryEvent(int i) {
            this.boundaryEvent = i;
            return this;
        }

        @NonNull
        public Builder setCircularRegion(@Nullable CircularRegion circularRegion) {
            this.circularRegion = circularRegion;
            return this;
        }

        @NonNull
        public Builder setProximityRegion(@Nullable ProximityRegion proximityRegion) {
            this.proximityRegion = proximityRegion;
            return this;
        }

        @NonNull
        public RegionEvent build() {
            Checks.checkNotNull(this.regionId, "Region identifier must not be null");
            Checks.checkNotNull(this.source, "Region event source must not be null");
            Checks.checkArgument(!UAStringUtil.isEmpty(this.regionId), "Region identifier must be greater than 0 characters.");
            Checks.checkArgument(this.regionId.length() <= 255, "Region identifier exceeds max identifier length: 255");
            Checks.checkArgument(!UAStringUtil.isEmpty(this.source), "Source must be greater than 0 characters.");
            Checks.checkArgument(this.source.length() <= 255, "Source exceeds max source length: 255");
            int i = this.boundaryEvent;
            if (i < 1 || i > 2) {
                throw new IllegalArgumentException("The boundary event must either be an entrance (1) or an exit (2).");
            }
            return new RegionEvent(this);
        }
    }
}
