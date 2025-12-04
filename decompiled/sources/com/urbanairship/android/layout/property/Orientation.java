package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum Orientation {
    PORTRAIT("portrait"),
    LANDSCAPE("landscape");

    private final String value;

    Orientation(String str) {
        this.value = str;
    }

    @NonNull
    public static Orientation from(@NonNull String str) throws JsonException {
        for (Orientation orientation : values()) {
            if (orientation.value.equals(str.toLowerCase(Locale.ROOT))) {
                return orientation;
            }
        }
        throw new JsonException("Unknown Orientation value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
