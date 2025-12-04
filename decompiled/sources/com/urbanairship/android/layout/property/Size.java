package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.android.layout.util.PercentUtils;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public class Size {
    private final Dimension height;
    private final Dimension width;

    public enum DimensionType {
        AUTO,
        PERCENT,
        ABSOLUTE
    }

    public Size(@NonNull String str, @NonNull String str2) {
        this.width = Dimension.of(str);
        this.height = Dimension.of(str2);
    }

    @NonNull
    public static Size fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        String strCoerceString = jsonMap.opt("width").coerceString();
        String strCoerceString2 = jsonMap.opt("height").coerceString();
        if (strCoerceString == null || strCoerceString2 == null) {
            throw new JsonException("Size requires both width and height!");
        }
        return new Size(strCoerceString, strCoerceString2);
    }

    @NonNull
    public String toString() {
        return "Size { width=" + getWidth() + ", height=" + getHeight() + " }";
    }

    @NonNull
    public Dimension getWidth() {
        return this.width;
    }

    @NonNull
    public Dimension getHeight() {
        return this.height;
    }

    public static abstract class Dimension {
        private final DimensionType type;

        @NonNull
        protected final String value;

        public abstract float getFloat();

        public abstract int getInt();

        Dimension(String str, DimensionType dimensionType) {
            this.value = str;
            this.type = dimensionType;
        }

        @NonNull
        public static Dimension of(@NonNull String str) {
            if (str.equals("auto")) {
                return new AutoDimension();
            }
            if (PercentUtils.isPercent(str)) {
                return new PercentDimension(str);
            }
            return new AbsoluteDimension(str);
        }

        @NonNull
        public DimensionType getType() {
            return this.type;
        }

        public boolean isAuto() {
            return this.type == DimensionType.AUTO;
        }

        public boolean isPercent() {
            return this.type == DimensionType.PERCENT;
        }

        public boolean isAbsolute() {
            return this.type == DimensionType.ABSOLUTE;
        }
    }

    public static class AutoDimension extends Dimension {
        @Override // com.urbanairship.android.layout.property.Size.Dimension
        public float getFloat() {
            return -1.0f;
        }

        @Override // com.urbanairship.android.layout.property.Size.Dimension
        public int getInt() {
            return -1;
        }

        AutoDimension() {
            super("auto", DimensionType.AUTO);
        }

        @NonNull
        public String toString() {
            return this.value;
        }
    }

    public static class PercentDimension extends Dimension {
        PercentDimension(String str) {
            super(str, DimensionType.PERCENT);
        }

        @Override // com.urbanairship.android.layout.property.Size.Dimension
        public float getFloat() {
            return PercentUtils.parse(this.value);
        }

        @Override // com.urbanairship.android.layout.property.Size.Dimension
        public int getInt() {
            return (int) getFloat();
        }

        @NonNull
        public String toString() {
            return ((int) (getFloat() * 100.0f)) + "%";
        }
    }

    public static class AbsoluteDimension extends Dimension {
        AbsoluteDimension(String str) {
            super(str, DimensionType.ABSOLUTE);
        }

        @Override // com.urbanairship.android.layout.property.Size.Dimension
        public float getFloat() {
            return Float.parseFloat(this.value);
        }

        @Override // com.urbanairship.android.layout.property.Size.Dimension
        public int getInt() {
            return (int) getFloat();
        }

        @NonNull
        public String toString() {
            return getInt() + "dp";
        }
    }
}
