package com.urbanairship.liveupdate.data;

import androidx.room.TypeConverter;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/liveupdate/data/Converters;", "", "()V", "fromJsonMap", "", "value", "Lcom/urbanairship/json/JsonMap;", "toJsonMap", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Converters {
    @TypeConverter
    @NotNull
    public final String fromJsonMap(@NotNull JsonMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String string = value.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @TypeConverter
    @NotNull
    public final JsonMap toJsonMap(@NotNull String value) throws JsonException {
        Intrinsics.checkNotNullParameter(value, "value");
        JsonMap jsonMapRequireMap = JsonValue.parseString(value).requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        return jsonMapRequireMap;
    }
}
