package com.urbanairship.analytics.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.utils.UriBuilder;
import com.disney.id.android.lightbox.LightboxActivity;
import com.urbanairship.analytics.AirshipEventData;
import com.urbanairship.analytics.Event;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import java.nio.charset.StandardCharsets;

@Entity(indices = {@Index(unique = true, value = {LightboxActivity.EVENT_ID_EXTRA})}, tableName = UriBuilder.ANALYTICS_EVENT_ENDPOINT)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class EventEntity {
    public JsonValue data;
    public String eventId;
    public int eventSize;

    @PrimaryKey(autoGenerate = true)
    public int id;

    @Nullable
    public String sessionId;
    public String time;
    public String type;

    EventEntity(String str, String str2, String str3, JsonValue jsonValue, String str4, int i) {
        this.type = str;
        this.eventId = str2;
        this.time = str3;
        this.data = jsonValue;
        this.sessionId = str4;
        this.eventSize = i;
    }

    public static EventEntity create(@NonNull AirshipEventData airshipEventData) throws JsonException {
        JsonValue fullEventPayload = airshipEventData.getFullEventPayload();
        return new EventEntity(airshipEventData.getType().getReportingName(), airshipEventData.getId(), Event.millisecondsToSecondsString(airshipEventData.getTimeMs()), fullEventPayload, airshipEventData.getSessionId(), fullEventPayload.toString().getBytes(StandardCharsets.UTF_8).length);
    }

    @Ignore
    public String toString() {
        return "EventEntity{id=" + this.id + ", type='" + this.type + CoreConstants.SINGLE_QUOTE_CHAR + ", eventId='" + this.eventId + CoreConstants.SINGLE_QUOTE_CHAR + ", time=" + this.time + ", data='" + this.data.toString() + CoreConstants.SINGLE_QUOTE_CHAR + ", sessionId='" + this.sessionId + CoreConstants.SINGLE_QUOTE_CHAR + ", eventSize=" + this.eventSize + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventEntity eventEntity = (EventEntity) obj;
        return this.id == eventEntity.id && this.eventSize == eventEntity.eventSize && ObjectsCompat.equals(this.type, eventEntity.type) && ObjectsCompat.equals(this.eventId, eventEntity.eventId) && ObjectsCompat.equals(this.time, eventEntity.time) && ObjectsCompat.equals(this.data, eventEntity.data) && ObjectsCompat.equals(this.sessionId, eventEntity.sessionId);
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.id), this.type, this.eventId, this.time, this.data, this.sessionId, Integer.valueOf(this.eventSize));
    }

    public boolean contentEquals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventEntity eventEntity = (EventEntity) obj;
        return this.eventSize == eventEntity.eventSize && ObjectsCompat.equals(this.type, eventEntity.type) && ObjectsCompat.equals(this.eventId, eventEntity.eventId) && ObjectsCompat.equals(this.time, eventEntity.time) && ObjectsCompat.equals(this.data, eventEntity.data) && ObjectsCompat.equals(this.sessionId, eventEntity.sessionId);
    }

    public static class EventIdAndData {
        public JsonValue data;
        public String eventId;
        public int id;

        public EventIdAndData(int i, String str, JsonValue jsonValue) {
            this.id = i;
            this.eventId = str;
            this.data = jsonValue;
        }
    }
}
