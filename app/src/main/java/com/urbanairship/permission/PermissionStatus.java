package com.urbanairship.permission;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum PermissionStatus implements JsonSerializable {
    GRANTED(PermissionsResponse.GRANTED_KEY),
    DENIED("denied"),
    NOT_DETERMINED("not_determined");

    private final String value;

    PermissionStatus(String str) {
        this.value = str;
    }

    @NonNull
    public String getValue() {
        return this.value;
    }

    @NonNull
    public static PermissionStatus fromJson(@NonNull JsonValue jsonValue) throws JsonException {
        String strOptString = jsonValue.optString();
        for (PermissionStatus permissionStatus : values()) {
            if (permissionStatus.value.equalsIgnoreCase(strOptString)) {
                return permissionStatus;
            }
        }
        throw new JsonException("Invalid permission status: " + jsonValue);
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
