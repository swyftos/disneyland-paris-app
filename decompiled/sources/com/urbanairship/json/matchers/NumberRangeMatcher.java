package com.urbanairship.json.matchers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NumberRangeMatcher extends ValueMatcher {

    @NonNull
    public static final String MAX_VALUE_KEY = "at_most";

    @NonNull
    public static final String MIN_VALUE_KEY = "at_least";
    private final Double max;
    private final Double min;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NumberRangeMatcher(@Nullable Double d, @Nullable Double d2) {
        this.min = d;
        this.max = d2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NumberRangeMatcher numberRangeMatcher = (NumberRangeMatcher) obj;
        Double d = this.min;
        if (d == null ? numberRangeMatcher.min != null : !d.equals(numberRangeMatcher.min)) {
            return false;
        }
        Double d2 = this.max;
        return d2 != null ? d2.equals(numberRangeMatcher.max) : numberRangeMatcher.max == null;
    }

    public int hashCode() {
        Double d = this.min;
        int iHashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.max;
        return iHashCode + (d2 != null ? d2.hashCode() : 0);
    }

    @Override // com.urbanairship.json.ValueMatcher
    protected boolean apply(@NonNull JsonValue jsonValue, boolean z) {
        if (this.min == null || (jsonValue.isNumber() && jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE) >= this.min.doubleValue())) {
            return this.max == null || (jsonValue.isNumber() && jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE) <= this.max.doubleValue());
        }
        return false;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonMap.newBuilder().putOpt(MIN_VALUE_KEY, this.min).putOpt(MAX_VALUE_KEY, this.max).build().toJsonValue();
    }
}
