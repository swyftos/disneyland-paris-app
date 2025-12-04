package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import androidx.media3.common.MimeTypes;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum MediaType {
    IMAGE(MimeTypes.BASE_TYPE_IMAGE),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    YOUTUBE("youtube"),
    VIMEO("vimeo");

    private final String value;

    MediaType(String str) {
        this.value = str;
    }

    @NonNull
    public static MediaType from(@NonNull String str) throws JsonException {
        for (MediaType mediaType : values()) {
            if (mediaType.value.equals(str.toLowerCase(Locale.ROOT))) {
                return mediaType;
            }
        }
        throw new JsonException("Unknown MediaType value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
