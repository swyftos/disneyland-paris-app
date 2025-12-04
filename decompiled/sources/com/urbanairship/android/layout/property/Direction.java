package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum Direction {
    VERTICAL("vertical"),
    HORIZONTAL("horizontal");

    private final String value;

    Direction(String str) {
        this.value = str;
    }

    @NonNull
    public static Direction from(@NonNull String str) throws JsonException {
        for (Direction direction : values()) {
            if (direction.value.equals(str.toLowerCase(Locale.ROOT))) {
                return direction;
            }
        }
        throw new JsonException("Unknown Direction value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
