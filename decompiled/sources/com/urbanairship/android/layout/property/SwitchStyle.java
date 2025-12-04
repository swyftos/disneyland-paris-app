package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public class SwitchStyle extends ToggleStyle {
    private final Color offColor;
    private final Color onColor;

    public SwitchStyle(@NonNull Color color, @NonNull Color color2) {
        super(ToggleType.SWITCH);
        this.onColor = color;
        this.offColor = color2;
    }

    @NonNull
    public static SwitchStyle fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        JsonMap jsonMapOptMap = jsonMap.opt("toggle_colors").optMap();
        Color colorFromJsonField = Color.fromJsonField(jsonMapOptMap, "on");
        if (colorFromJsonField == null) {
            throw new JsonException("Failed to parse SwitchStyle! Field 'toggle_colors.on' may not be null.");
        }
        Color colorFromJsonField2 = Color.fromJsonField(jsonMapOptMap, "off");
        if (colorFromJsonField2 == null) {
            throw new JsonException("Failed to parse SwitchStyle! Field 'toggle_colors.off' may not be null.");
        }
        return new SwitchStyle(colorFromJsonField, colorFromJsonField2);
    }

    @NonNull
    public Color getOnColor() {
        return this.onColor;
    }

    @NonNull
    public Color getOffColor() {
        return this.offColor;
    }
}
