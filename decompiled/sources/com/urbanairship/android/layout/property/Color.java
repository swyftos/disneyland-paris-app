package com.urbanairship.android.layout.property;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import java.util.List;

/* loaded from: classes5.dex */
public class Color {

    @ColorInt
    public static final int BLACK = -16777216;

    @ColorInt
    public static final int TRANSPARENT = 0;

    @ColorInt
    public static final int WHITE = -1;
    private final int defaultColor;
    private final List selectors;

    public Color(int i, @NonNull List<ColorSelector> list) {
        this.defaultColor = i;
        this.selectors = list;
    }

    @NonNull
    public static Color fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        Integer numFromJson = HexColor.fromJson(jsonMap.opt("default").optMap());
        if (numFromJson == null) {
            throw new JsonException("Failed to parse color. 'default' may not be null! json = " + jsonMap);
        }
        return new Color(numFromJson.intValue(), ColorSelector.fromJsonList(jsonMap.opt("selectors").optList()));
    }

    @Nullable
    public static Color fromJsonField(@Nullable JsonMap jsonMap, @NonNull String str) throws JsonException {
        if (jsonMap == null || jsonMap.isEmpty()) {
            return null;
        }
        JsonMap jsonMapOptMap = jsonMap.opt(str).optMap();
        if (jsonMapOptMap.isEmpty()) {
            return null;
        }
        return fromJson(jsonMapOptMap);
    }

    public static float alpha(@ColorInt int i) {
        return android.graphics.Color.alpha(i);
    }

    @ColorInt
    public int resolve(@NonNull Context context) {
        boolean zIsUiModeNight = ResourceUtils.isUiModeNight(context);
        for (ColorSelector colorSelector : this.selectors) {
            if (colorSelector.isDarkMode() == zIsUiModeNight) {
                return colorSelector.getColor();
            }
        }
        return this.defaultColor;
    }
}
