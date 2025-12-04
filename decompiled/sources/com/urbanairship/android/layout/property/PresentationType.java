package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum PresentationType {
    BANNER("banner"),
    MODAL("modal"),
    EMBEDDED("embedded");

    private final String value;

    PresentationType(String str) {
        this.value = str;
    }

    @NonNull
    public static PresentationType from(@NonNull String str) throws JsonException {
        for (PresentationType presentationType : values()) {
            if (presentationType.value.equals(str.toLowerCase(Locale.ROOT))) {
                return presentationType;
            }
        }
        throw new JsonException("Unknown PresentationType value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
