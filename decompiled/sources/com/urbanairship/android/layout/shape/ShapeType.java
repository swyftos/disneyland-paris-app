package com.urbanairship.android.layout.shape;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonException;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public enum ShapeType {
    RECTANGLE("rectangle", 0),
    ELLIPSE("ellipse", 1);

    private final int drawableShape;
    private final String value;

    ShapeType(String str, int i) {
        this.value = str;
        this.drawableShape = i;
    }

    @NonNull
    public static ShapeType from(@NonNull String str) throws JsonException {
        for (ShapeType shapeType : values()) {
            if (shapeType.value.equals(str.toLowerCase(Locale.ROOT))) {
                return shapeType;
            }
        }
        throw new JsonException("Unknown ShapeType value: " + str);
    }

    public int getDrawableShapeType() {
        return this.drawableShape;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
