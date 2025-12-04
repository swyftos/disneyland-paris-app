package com.urbanairship.analytics;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonMap;

/* loaded from: classes4.dex */
class AppForegroundEvent extends Event {
    AppForegroundEvent(long j) {
        super(j);
    }

    @Override // com.urbanairship.analytics.Event
    public final EventType getType() {
        return EventType.APP_FOREGROUND;
    }

    @Override // com.urbanairship.analytics.Event
    public final JsonMap getEventData(ConversionData conversionData) {
        PackageInfo packageInfo = UAirship.getPackageInfo();
        return JsonMap.newBuilder().put(OneIDTrackerEvent.EVENT_PARAM_CONNECTION_TYPE, getConnectionType()).put("connection_subtype", getConnectionSubType()).put("carrier", getCarrier()).put("time_zone", getTimezone()).put("daylight_savings", isDaylightSavingsTime()).put("os_version", Build.VERSION.RELEASE).put("lib_version", UAirship.getVersion()).putOpt("package_version", packageInfo != null ? packageInfo.versionName : null).put("push_id", conversionData.getConversionSendId()).put("metadata", conversionData.getConversionMetadata()).put("last_metadata", conversionData.getLastReceivedMetadata()).build();
    }
}
