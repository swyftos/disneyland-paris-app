package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum ToggleType {
    SWITCH("switch"),
    CHECKBOX("checkbox");

    private final String value;

    ToggleType(String str) {
        this.value = str;
    }

    @NonNull
    public static ToggleType from(@NonNull String str) throws JsonException {
        for (ToggleType toggleType : values()) {
            if (toggleType.value.equals(str.toLowerCase(Locale.ROOT))) {
                return toggleType;
            }
        }
        throw new JsonException("Unknown ToggleType value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
