package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum BannerPosition {
    TOP(ViewProps.TOP),
    BOTTOM(ViewProps.BOTTOM);

    private final String value;

    BannerPosition(String str) {
        this.value = str;
    }

    @NonNull
    public static BannerPosition from(@NonNull String str) throws JsonException {
        for (BannerPosition bannerPosition : values()) {
            if (bannerPosition.value.equals(str.toLowerCase(Locale.ROOT))) {
                return bannerPosition;
            }
        }
        throw new JsonException("Unknown BannerPosition value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
