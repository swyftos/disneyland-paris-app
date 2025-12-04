package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum TextStyle {
    BOLD("bold"),
    ITALIC("italic"),
    UNDERLINE("underlined");

    private final String value;

    TextStyle(String str) {
        this.value = str;
    }

    @NonNull
    public static TextStyle from(@NonNull String str) throws JsonException {
        for (TextStyle textStyle : values()) {
            if (textStyle.value.equals(str.toLowerCase(Locale.ROOT))) {
                return textStyle;
            }
        }
        throw new JsonException("Unknown Text Style value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
