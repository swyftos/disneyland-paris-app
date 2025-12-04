package com.urbanairship.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.urbanairship.Predicate;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import com.urbanairship.json.matchers.ArrayLengthMatcher;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.json.matchers.NumberRangeMatcher;
import com.urbanairship.json.matchers.PresenceMatcher;
import com.urbanairship.json.matchers.StringBeginsMatcher;
import com.urbanairship.json.matchers.StringContainsMatcher;
import com.urbanairship.json.matchers.StringEndsMatcher;
import com.urbanairship.json.matchers.VersionMatcher;
import com.urbanairship.util.IvyVersionMatcher;

/* loaded from: classes5.dex */
public abstract class ValueMatcher implements JsonSerializable, Predicate<JsonSerializable> {
    protected abstract boolean apply(@NonNull JsonValue jsonValue, boolean z);

    protected ValueMatcher() {
    }

    @NonNull
    public static ValueMatcher newNumberRangeMatcher(@Nullable Double d, @Nullable Double d2) {
        if (d != null && d2 != null && d2.doubleValue() < d.doubleValue()) {
            throw new IllegalArgumentException();
        }
        return new NumberRangeMatcher(d, d2);
    }

    @NonNull
    public static ValueMatcher newValueMatcher(@NonNull JsonValue jsonValue) {
        return new ExactValueMatcher(jsonValue);
    }

    @NonNull
    public static ValueMatcher newIsPresentMatcher() {
        return new PresenceMatcher(true);
    }

    @NonNull
    public static ValueMatcher newIsAbsentMatcher() {
        return new PresenceMatcher(false);
    }

    @NonNull
    public static ValueMatcher newVersionMatcher(@NonNull String str) {
        return new VersionMatcher(IvyVersionMatcher.newMatcher(str));
    }

    @NonNull
    public static ValueMatcher newArrayContainsMatcher(@NonNull JsonPredicate jsonPredicate, int i) {
        return new ArrayContainsMatcher(jsonPredicate, Integer.valueOf(i));
    }

    @NonNull
    public static ValueMatcher newArrayContainsMatcher(@NonNull JsonPredicate jsonPredicate) {
        return new ArrayContainsMatcher(jsonPredicate, null);
    }

    @NonNull
    public static ValueMatcher newArrayLengthMatcher(@NonNull JsonPredicate jsonPredicate) {
        return new ArrayLengthMatcher(jsonPredicate);
    }

    @NonNull
    public static ValueMatcher parse(@Nullable JsonValue jsonValue) throws JsonException {
        JsonMap jsonMapOptMap = jsonValue == null ? JsonMap.EMPTY_MAP : jsonValue.optMap();
        if (jsonMapOptMap.containsKey(ExactValueMatcher.EQUALS_VALUE_KEY)) {
            return newValueMatcher(jsonMapOptMap.opt(ExactValueMatcher.EQUALS_VALUE_KEY));
        }
        if (jsonMapOptMap.containsKey(NumberRangeMatcher.MIN_VALUE_KEY) || jsonMapOptMap.containsKey(NumberRangeMatcher.MAX_VALUE_KEY)) {
            try {
                return newNumberRangeMatcher(jsonMapOptMap.containsKey(NumberRangeMatcher.MIN_VALUE_KEY) ? Double.valueOf(jsonMapOptMap.opt(NumberRangeMatcher.MIN_VALUE_KEY).getDouble(AudioStats.AUDIO_AMPLITUDE_NONE)) : null, jsonMapOptMap.containsKey(NumberRangeMatcher.MAX_VALUE_KEY) ? Double.valueOf(jsonMapOptMap.opt(NumberRangeMatcher.MAX_VALUE_KEY).getDouble(AudioStats.AUDIO_AMPLITUDE_NONE)) : null);
            } catch (Exception e) {
                throw new JsonException("Invalid range matcher: " + jsonValue, e);
            }
        }
        if (jsonMapOptMap.containsKey(PresenceMatcher.IS_PRESENT_VALUE_KEY)) {
            return jsonMapOptMap.opt(PresenceMatcher.IS_PRESENT_VALUE_KEY).getBoolean(false) ? newIsPresentMatcher() : newIsAbsentMatcher();
        }
        if (jsonMapOptMap.containsKey(VersionMatcher.VERSION_KEY)) {
            try {
                return newVersionMatcher(jsonMapOptMap.opt(VersionMatcher.VERSION_KEY).optString());
            } catch (Exception e2) {
                throw new JsonException("Invalid version constraint: " + jsonMapOptMap.opt(VersionMatcher.VERSION_KEY), e2);
            }
        }
        if (jsonMapOptMap.containsKey("version")) {
            try {
                return newVersionMatcher(jsonMapOptMap.opt("version").optString());
            } catch (Exception e3) {
                throw new JsonException("Invalid version constraint: " + jsonMapOptMap.opt("version"), e3);
            }
        }
        if (jsonMapOptMap.containsKey(ArrayLengthMatcher.ARRAY_LENGTH_KEY)) {
            return newArrayLengthMatcher(JsonPredicate.parse(jsonMapOptMap.get(ArrayLengthMatcher.ARRAY_LENGTH_KEY)));
        }
        if (jsonMapOptMap.containsKey(ArrayContainsMatcher.ARRAY_CONTAINS_KEY)) {
            JsonPredicate jsonPredicate = JsonPredicate.parse(jsonMapOptMap.get(ArrayContainsMatcher.ARRAY_CONTAINS_KEY));
            if (jsonMapOptMap.containsKey("index")) {
                int i = jsonMapOptMap.opt("index").getInt(-1);
                if (i == -1) {
                    throw new JsonException("Invalid index for array_contains matcher: " + jsonMapOptMap.get("index"));
                }
                return newArrayContainsMatcher(jsonPredicate, i);
            }
            return newArrayContainsMatcher(jsonPredicate);
        }
        if (jsonMapOptMap.containsKey(StringBeginsMatcher.STRING_BEGINS)) {
            return new StringBeginsMatcher(jsonMapOptMap.opt(StringBeginsMatcher.STRING_BEGINS));
        }
        if (jsonMapOptMap.containsKey(StringEndsMatcher.STRING_ENDS)) {
            return new StringEndsMatcher(jsonMapOptMap.opt(StringEndsMatcher.STRING_ENDS));
        }
        if (jsonMapOptMap.containsKey(StringContainsMatcher.STRING_CONTAINS)) {
            return new StringContainsMatcher(jsonMapOptMap.opt(StringContainsMatcher.STRING_CONTAINS));
        }
        throw new JsonException("Unknown value matcher: " + jsonValue);
    }

    @Override // com.urbanairship.Predicate
    public boolean apply(@Nullable JsonSerializable jsonSerializable) {
        return apply(jsonSerializable, false);
    }

    boolean apply(JsonSerializable jsonSerializable, boolean z) {
        return apply(jsonSerializable == null ? JsonValue.NULL : jsonSerializable.toJsonValue(), z);
    }

    @NonNull
    public String toString() {
        return toJsonValue().toString();
    }
}
