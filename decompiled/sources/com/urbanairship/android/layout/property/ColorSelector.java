package com.urbanairship.android.layout.property;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ColorSelector {
    private final int color;
    private final boolean darkMode;
    private final Platform platform;

    public ColorSelector(@Nullable Platform platform, boolean z, int i) {
        this.platform = platform;
        this.darkMode = z;
        this.color = i;
    }

    @NonNull
    public static ColorSelector fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        String strOptString = jsonMap.opt(DeferredApiClient.KEY_PLATFORM).optString();
        Platform platformFrom = strOptString.isEmpty() ? null : Platform.from(strOptString);
        boolean z = jsonMap.opt("dark_mode").getBoolean(false);
        Integer numFromJson = HexColor.fromJson(jsonMap.opt("color").optMap());
        if (numFromJson == null) {
            throw new JsonException("Failed to parse color selector. 'color' may not be null! json = '" + jsonMap + "'");
        }
        return new ColorSelector(platformFrom, z, numFromJson.intValue());
    }

    @NonNull
    public static List<ColorSelector> fromJsonList(@NonNull JsonList jsonList) throws JsonException {
        ArrayList arrayList = new ArrayList(jsonList.size());
        for (int i = 0; i < jsonList.size(); i++) {
            ColorSelector colorSelectorFromJson = fromJson(jsonList.get(i).optMap());
            Platform platform = colorSelectorFromJson.platform;
            if (platform == Platform.ANDROID || platform == null) {
                arrayList.add(colorSelectorFromJson);
            }
        }
        return arrayList;
    }

    public boolean isDarkMode() {
        return this.darkMode;
    }

    @ColorInt
    public int getColor() {
        return this.color;
    }
}
