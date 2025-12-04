package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum Platform {
    ANDROID("android"),
    IOS("ios"),
    WEB("web");

    private final String value;

    Platform(String str) {
        this.value = str;
    }

    @NonNull
    public static Platform from(@NonNull String str) throws JsonException {
        for (Platform platform : values()) {
            if (platform.value.equals(str.toLowerCase(Locale.ROOT))) {
                return platform;
            }
        }
        throw new JsonException("Unknown Platform value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
