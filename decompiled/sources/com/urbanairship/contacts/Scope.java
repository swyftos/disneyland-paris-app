package com.urbanairship.contacts;

import androidx.annotation.NonNull;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum Scope implements JsonSerializable {
    APP(TCEventPropertiesNames.TCA_APP),
    WEB("web"),
    EMAIL("email"),
    SMS("sms");

    private final String value;

    Scope(String str) {
        this.value = str;
    }

    @NonNull
    public static Scope fromJson(@NonNull JsonValue jsonValue) throws JsonException {
        String strOptString = jsonValue.optString();
        for (Scope scope : values()) {
            if (scope.value.equalsIgnoreCase(strOptString)) {
                return scope;
            }
        }
        throw new JsonException("Invalid scope: " + jsonValue);
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
