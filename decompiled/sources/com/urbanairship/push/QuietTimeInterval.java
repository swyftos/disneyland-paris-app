package com.urbanairship.push;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes5.dex */
class QuietTimeInterval implements JsonSerializable {
    private final int endHour;
    private final int endMin;
    private final int startHour;
    private final int startMin;

    private QuietTimeInterval(Builder builder) {
        this.startHour = builder.startHour;
        this.startMin = builder.startMin;
        this.endHour = builder.endHour;
        this.endMin = builder.endMin;
    }

    boolean isInQuietTime(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, this.startHour);
        calendar2.set(12, this.startMin);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(11, this.endHour);
        calendar3.set(12, this.endMin);
        calendar3.set(13, 0);
        calendar3.set(14, 0);
        Calendar calendar4 = (Calendar) calendar.clone();
        calendar4.set(13, 0);
        calendar4.set(14, 0);
        if (calendar4.compareTo(calendar2) == 0 || calendar4.compareTo(calendar3) == 0) {
            return true;
        }
        if (calendar3.compareTo(calendar2) == 0) {
            return false;
        }
        return calendar3.after(calendar2) ? calendar4.after(calendar2) && calendar4.before(calendar3) : calendar4.before(calendar3) || calendar4.after(calendar2);
    }

    Date[] getQuietTimeIntervalDateArray() {
        if (this.startHour == -1 || this.startMin == -1 || this.endHour == -1 || this.endMin == -1) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.startHour);
        calendar.set(12, this.startMin);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, this.endHour);
        calendar2.set(12, this.endMin);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return new Date[]{calendar.getTime(), calendar2.getTime()};
    }

    @Override // com.urbanairship.json.JsonSerializable
    public JsonValue toJsonValue() {
        return JsonMap.newBuilder().put("start_hour", this.startHour).put("start_min", this.startMin).put("end_hour", this.endHour).put("end_min", this.endMin).build().toJsonValue();
    }

    public static QuietTimeInterval fromJson(JsonValue jsonValue) throws JsonException {
        JsonMap jsonMapOptMap = jsonValue.optMap();
        if (jsonMapOptMap.isEmpty()) {
            throw new JsonException("Invalid quiet time interval: " + jsonValue);
        }
        return new Builder().setStartHour(jsonMapOptMap.opt("start_hour").getInt(-1)).setStartMin(jsonMapOptMap.opt("start_min").getInt(-1)).setEndHour(jsonMapOptMap.opt("end_hour").getInt(-1)).setEndMin(jsonMapOptMap.opt("end_min").getInt(-1)).build();
    }

    public String toString() {
        return "QuietTimeInterval{startHour=" + this.startHour + ", startMin=" + this.startMin + ", endHour=" + this.endHour + ", endMin=" + this.endMin + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QuietTimeInterval quietTimeInterval = (QuietTimeInterval) obj;
        return this.startHour == quietTimeInterval.startHour && this.startMin == quietTimeInterval.startMin && this.endHour == quietTimeInterval.endHour && this.endMin == quietTimeInterval.endMin;
    }

    public int hashCode() {
        return (((((this.startHour * 31) + this.startMin) * 31) + this.endHour) * 31) + this.endMin;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int startHour = -1;
        private int startMin = -1;
        private int endHour = -1;
        private int endMin = -1;

        @NonNull
        public Builder setQuietTimeInterval(@NonNull Date date, @NonNull Date date2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            this.startHour = calendar.get(11);
            this.startMin = calendar.get(12);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            this.endHour = calendar2.get(11);
            this.endMin = calendar2.get(12);
            return this;
        }

        @NonNull
        public Builder setStartHour(@IntRange(from = 0, to = 23) int i) {
            this.startHour = i;
            return this;
        }

        @NonNull
        public Builder setStartMin(@IntRange(from = 0, to = 59) int i) {
            this.startMin = i;
            return this;
        }

        @NonNull
        public Builder setEndHour(@IntRange(from = 0, to = 23) int i) {
            this.endHour = i;
            return this;
        }

        @NonNull
        public Builder setEndMin(@IntRange(from = 0, to = 59) int i) {
            this.endMin = i;
            return this;
        }

        @NonNull
        public QuietTimeInterval build() {
            return new QuietTimeInterval(this);
        }
    }
}
