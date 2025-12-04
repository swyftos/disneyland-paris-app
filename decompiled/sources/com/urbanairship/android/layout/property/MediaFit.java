package com.urbanairship.android.layout.property;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum MediaFit {
    CENTER("center", ImageView.ScaleType.CENTER),
    CENTER_INSIDE("center_inside", ImageView.ScaleType.FIT_CENTER),
    CENTER_CROP("center_crop", ImageView.ScaleType.CENTER_CROP),
    FIT_CROP("fit_crop", ImageView.ScaleType.MATRIX);

    private final ImageView.ScaleType scaleType;
    private final String value;

    MediaFit(String str, ImageView.ScaleType scaleType) {
        this.value = str;
        this.scaleType = scaleType;
    }

    @NonNull
    public static MediaFit from(@NonNull String str) throws JsonException {
        for (MediaFit mediaFit : values()) {
            if (mediaFit.value.equals(str.toLowerCase(Locale.ROOT))) {
                return mediaFit;
            }
        }
        throw new JsonException("Unknown MediaFit value: " + str);
    }

    @NonNull
    public ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
