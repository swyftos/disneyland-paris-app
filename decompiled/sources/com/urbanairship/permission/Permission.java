package com.urbanairship.permission;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum Permission implements JsonSerializable {
    DISPLAY_NOTIFICATIONS("display_notifications"),
    LOCATION("location");

    private final String value;

    Permission(String str) {
        this.value = str;
    }

    @NonNull
    public String getValue() {
        return this.value;
    }

    @NonNull
    public static Permission fromJson(@NonNull JsonValue jsonValue) throws JsonException {
        String strOptString = jsonValue.optString();
        for (Permission permission : values()) {
            if (permission.value.equalsIgnoreCase(strOptString)) {
                return permission;
            }
        }
        throw new JsonException("Invalid permission: " + jsonValue);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonValue.wrapOpt(this.value);
    }
}
