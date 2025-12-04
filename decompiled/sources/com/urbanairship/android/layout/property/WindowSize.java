package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum WindowSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String value;

    WindowSize(String str) {
        this.value = str;
    }

    @NonNull
    public static WindowSize from(@NonNull String str) throws JsonException {
        for (WindowSize windowSize : values()) {
            if (windowSize.value.equals(str.toLowerCase(Locale.ROOT))) {
                return windowSize;
            }
        }
        throw new JsonException("Unknown WindowSize value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
