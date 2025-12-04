package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public class Position {

    @NonNull
    public static final Position CENTER = new Position(HorizontalPosition.CENTER, VerticalPosition.CENTER);
    private final HorizontalPosition horizontal;
    private final VerticalPosition vertical;

    public Position(@NonNull HorizontalPosition horizontalPosition, @NonNull VerticalPosition verticalPosition) {
        this.horizontal = horizontalPosition;
        this.vertical = verticalPosition;
    }

    @NonNull
    public static Position fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        return new Position(HorizontalPosition.from(jsonMap.opt("horizontal").optString()), VerticalPosition.from(jsonMap.opt("vertical").optString()));
    }

    @NonNull
    public HorizontalPosition getHorizontal() {
        return this.horizontal;
    }

    @NonNull
    public VerticalPosition getVertical() {
        return this.vertical;
    }

    public int getGravity() {
        return this.vertical.getGravity() | this.horizontal.getGravity() | 17;
    }
}
