package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum VerticalPosition {
    TOP(ViewProps.TOP, 48),
    BOTTOM(ViewProps.BOTTOM, 80),
    CENTER("center", 16);

    private final int gravity;
    private final String value;

    VerticalPosition(String str, int i) {
        this.value = str;
        this.gravity = i;
    }

    @NonNull
    public static VerticalPosition from(@NonNull String str) throws JsonException {
        for (VerticalPosition verticalPosition : values()) {
            if (verticalPosition.value.equals(str.toLowerCase(Locale.ROOT))) {
                return verticalPosition;
            }
        }
        throw new JsonException("Unknown VerticalPosition value: " + str);
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
