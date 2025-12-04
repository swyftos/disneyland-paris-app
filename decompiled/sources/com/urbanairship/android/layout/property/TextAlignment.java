package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum TextAlignment {
    START(ViewProps.START, GravityCompat.START),
    END(ViewProps.END, GravityCompat.END),
    CENTER("center", 17);

    private final int gravity;
    private final String value;

    TextAlignment(String str, int i) {
        this.value = str;
        this.gravity = i;
    }

    @NonNull
    public static TextAlignment from(@NonNull String str) throws JsonException {
        for (TextAlignment textAlignment : values()) {
            if (textAlignment.value.equals(str.toLowerCase(Locale.ROOT))) {
                return textAlignment;
            }
        }
        throw new JsonException("Unknown Text Alignment value: " + str);
    }

    public int getGravity() {
        return this.gravity;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
