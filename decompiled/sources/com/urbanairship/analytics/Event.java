package com.urbanairship.analytics;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonMap;
import com.urbanairship.util.Network;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes4.dex */
public abstract class Event {
    public static final int HIGH_PRIORITY = 2;
    public static final int LOW_PRIORITY = 0;
    public static final int NORMAL_PRIORITY = 1;
    private final String eventId;
    protected final long timeMilliseconds;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    public int getPriority() {
        return 1;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract EventType getType();

    public boolean isValid() {
        return true;
    }

    public Event(long j) {
        this.eventId = UUID.randomUUID().toString();
        this.timeMilliseconds = j;
    }

    public Event() {
        this(System.currentTimeMillis());
    }

    @NonNull
    public String getEventId() {
        return this.eventId;
    }

    @NonNull
    public String getTime() {
        return millisecondsToSecondsString(this.timeMilliseconds);
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public JsonMap getEventData() {
        return JsonMap.EMPTY_MAP;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public JsonMap getEventData(@NonNull ConversionData conversionData) {
        return getEventData();
    }

    @NonNull
    public String getConnectionType() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) UAirship.getApplicationContext().getSystemService("connectivity");
        int type = (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? -1 : activeNetworkInfo.getType();
        if (type == 0) {
            return "cell";
        }
        if (type == 1) {
            return "wifi";
        }
        if (type == 6) {
            return "wimax";
        }
        return "none";
    }

    @NonNull
    public String getConnectionSubType() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) UAirship.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "";
            }
            return activeNetworkInfo.getSubtypeName();
        } catch (ClassCastException e) {
            UALog.e("Connection subtype lookup failed", e);
            return "";
        }
    }

    @Nullable
    protected String getCarrier() {
        return Network.getCarrier();
    }

    protected long getTimezone() {
        return Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000;
    }

    protected boolean isDaylightSavingsTime() {
        return Calendar.getInstance().getTimeZone().inDaylightTime(new Date());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String millisecondsToSecondsString(long j) {
        return String.format(Locale.US, "%.3f", Double.valueOf(j / 1000.0d));
    }
}
