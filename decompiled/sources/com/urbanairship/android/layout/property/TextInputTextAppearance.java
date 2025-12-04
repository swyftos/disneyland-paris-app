package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public class TextInputTextAppearance extends TextAppearance {
    private final Color hintColor;

    public TextInputTextAppearance(@NonNull TextAppearance textAppearance, @Nullable Color color) {
        super(textAppearance);
        this.hintColor = color;
    }

    @NonNull
    public static TextInputTextAppearance fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        return new TextInputTextAppearance(TextAppearance.fromJson(jsonMap), Color.fromJsonField(jsonMap, "place_holder_color"));
    }

    @Nullable
    public Color getHintColor() {
        return this.hintColor;
    }
}
