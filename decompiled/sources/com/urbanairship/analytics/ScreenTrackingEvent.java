package com.urbanairship.analytics;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonMap;

/* loaded from: classes4.dex */
class ScreenTrackingEvent extends Event {
    private final String previousScreen;
    private final String screen;
    private final long startTime;
    private final long stopTime;

    ScreenTrackingEvent(String str, String str2, long j, long j2) {
        this.screen = str;
        this.startTime = j;
        this.stopTime = j2;
        this.previousScreen = str2;
    }

    @Override // com.urbanairship.analytics.Event
    public boolean isValid() {
        if (this.screen.length() > 255 || this.screen.length() <= 0) {
            UALog.e("Screen identifier string must be between 1 and 255 characters long.", new Object[0]);
            return false;
        }
        if (this.startTime <= this.stopTime) {
            return true;
        }
        UALog.e("Screen tracking duration must be positive or zero.", new Object[0]);
        return false;
    }

    @Override // com.urbanairship.analytics.Event
    public EventType getType() {
        return EventType.SCREEN_TRACKING;
    }

    @Override // com.urbanairship.analytics.Event
    public final JsonMap getEventData(ConversionData conversionData) {
        return JsonMap.newBuilder().put(TCEventPropertiesNames.TCD_SCREEN, this.screen).put("entered_time", Event.millisecondsToSecondsString(this.startTime)).put("exited_time", Event.millisecondsToSecondsString(this.stopTime)).put(TypedValues.TransitionType.S_DURATION, Event.millisecondsToSecondsString(this.stopTime - this.startTime)).put("previous_screen", this.previousScreen).build();
    }
}
