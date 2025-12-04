package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.util.PercentUtils;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public class ConstrainedSize extends Size {
    private final ConstrainedDimension maxHeight;
    private final ConstrainedDimension maxWidth;
    private final ConstrainedDimension minHeight;
    private final ConstrainedDimension minWidth;

    public enum ConstrainedDimensionType {
        PERCENT,
        ABSOLUTE
    }

    public ConstrainedSize(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        super(str, str2);
        this.minWidth = ConstrainedDimension.of(str3);
        this.minHeight = ConstrainedDimension.of(str4);
        this.maxWidth = ConstrainedDimension.of(str5);
        this.maxHeight = ConstrainedDimension.of(str6);
    }

    @NonNull
    public static ConstrainedSize fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        String strCoerceString = jsonMap.opt("width").coerceString();
        String strCoerceString2 = jsonMap.opt("height").coerceString();
        if (strCoerceString == null || strCoerceString2 == null) {
            throw new JsonException("Size requires both width and height!");
        }
        return new ConstrainedSize(strCoerceString, strCoerceString2, jsonMap.opt("min_width").coerceString(), jsonMap.opt("min_height").coerceString(), jsonMap.opt("max_width").coerceString(), jsonMap.opt("max_height").coerceString());
    }

    @Override // com.urbanairship.android.layout.property.Size
    @NonNull
    public String toString() {
        return "ConstrainedSize { width=" + getWidth() + ", height=" + getHeight() + ", minWidth=" + getMinWidth() + ", minHeight=" + getMinHeight() + ", maxWidth=" + getMaxWidth() + ", maxHeight=" + getMaxHeight() + " }";
    }

    @Nullable
    public ConstrainedDimension getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    public ConstrainedDimension getMinHeight() {
        return this.minHeight;
    }

    @Nullable
    public ConstrainedDimension getMaxWidth() {
        return this.maxWidth;
    }

    @Nullable
    public ConstrainedDimension getMaxHeight() {
        return this.maxHeight;
    }

    public static abstract class ConstrainedDimension {
        private final ConstrainedDimensionType type;

        @NonNull
        protected final String value;

        public abstract float getFloat();

        public abstract int getInt();

        ConstrainedDimension(String str, ConstrainedDimensionType constrainedDimensionType) {
            this.value = str;
            this.type = constrainedDimensionType;
        }

        @Nullable
        public static ConstrainedDimension of(@Nullable String str) {
            if (str == null) {
                return null;
            }
            if (PercentUtils.isPercent(str)) {
                return new PercentConstrainedDimension(str);
            }
            return new AbsoluteConstrainedDimension(str);
        }

        @NonNull
        public ConstrainedDimensionType getType() {
            return this.type;
        }

        public boolean isPercent() {
            return this.type == ConstrainedDimensionType.PERCENT;
        }

        public boolean isAbsolute() {
            return this.type == ConstrainedDimensionType.ABSOLUTE;
        }
    }

    public static class PercentConstrainedDimension extends ConstrainedDimension {
        PercentConstrainedDimension(String str) {
            super(str, ConstrainedDimensionType.PERCENT);
        }

        @Override // com.urbanairship.android.layout.property.ConstrainedSize.ConstrainedDimension
        public float getFloat() {
            return PercentUtils.parse(this.value);
        }

        @Override // com.urbanairship.android.layout.property.ConstrainedSize.ConstrainedDimension
        public int getInt() {
            return (int) getFloat();
        }

        @NonNull
        public String toString() {
            return ((int) (getFloat() * 100.0f)) + "%";
        }
    }

    public static class AbsoluteConstrainedDimension extends ConstrainedDimension {
        AbsoluteConstrainedDimension(String str) {
            super(str, ConstrainedDimensionType.ABSOLUTE);
        }

        @Override // com.urbanairship.android.layout.property.ConstrainedSize.ConstrainedDimension
        public float getFloat() {
            return Float.parseFloat(this.value);
        }

        @Override // com.urbanairship.android.layout.property.ConstrainedSize.ConstrainedDimension
        public int getInt() {
            return Integer.parseInt(this.value);
        }

        @NonNull
        public String toString() {
            return getInt() + "dp";
        }
    }
}
