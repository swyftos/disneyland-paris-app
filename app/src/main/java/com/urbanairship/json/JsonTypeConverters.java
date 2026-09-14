package com.urbanairship.json;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.TypeConverter;
import com.urbanairship.UALog;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class JsonTypeConverters {
    @Nullable
    @TypeConverter
    public JsonValue jsonValueFromString(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonValue.parseString(str);
        } catch (JsonException e) {
            UALog.m1746e(e, "Unable to parse json value: " + str, new Object[0]);
            return null;
        }
    }

    @Nullable
    @TypeConverter
    public String jsonValueToString(@Nullable JsonValue jsonValue) {
        if (jsonValue == null) {
            return null;
        }
        return jsonValue.toString();
    }

    @Nullable
    @TypeConverter
    public JsonMap jsonMapFromString(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonValue.parseString(str).optMap();
        } catch (JsonException e) {
            UALog.m1746e(e, "Unable to parse json value: " + str, new Object[0]);
            return null;
        }
    }

    @Nullable
    @TypeConverter
    public String jsonMapToString(@Nullable JsonMap jsonMap) {
        if (jsonMap == null) {
            return null;
        }
        return jsonMap.toJsonValue().toString();
    }

    @Nullable
    @TypeConverter
    public String jsonPredicateToString(@Nullable JsonPredicate jsonPredicate) {
        if (jsonPredicate == null) {
            return null;
        }
        return jsonPredicate.toJsonValue().toString();
    }

    @Nullable
    @TypeConverter
    public JsonPredicate jsonPredicateFromString(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonPredicate.parse(JsonValue.parseString(str));
        } catch (JsonException e) {
            UALog.m1746e(e, "Unable to parse trigger context: " + str, new Object[0]);
            return null;
        }
    }
}
