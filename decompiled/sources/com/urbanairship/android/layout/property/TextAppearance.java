package com.urbanairship.android.layout.property;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TextAppearance {
    private final TextAlignment alignment;
    private final Color color;
    private final List fontFamilies;
    private final int fontSize;
    private final List textStyles;

    protected TextAppearance(@NonNull TextAppearance textAppearance) {
        this.color = textAppearance.color;
        this.fontSize = textAppearance.fontSize;
        this.alignment = textAppearance.alignment;
        this.textStyles = textAppearance.textStyles;
        this.fontFamilies = textAppearance.fontFamilies;
    }

    public TextAppearance(@NonNull Color color, int i, @NonNull TextAlignment textAlignment, @NonNull List<TextStyle> list, @NonNull List<String> list2) {
        this.color = color;
        this.fontSize = i;
        this.alignment = textAlignment;
        this.textStyles = list;
        this.fontFamilies = list2;
    }

    @NonNull
    public static TextAppearance fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        TextAlignment textAlignmentFrom;
        int i = jsonMap.opt("font_size").getInt(14);
        Color colorFromJsonField = Color.fromJsonField(jsonMap, "color");
        if (colorFromJsonField == null) {
            throw new JsonException("Failed to parse text appearance. 'color' may not be null!");
        }
        String strOptString = jsonMap.opt("alignment").optString();
        JsonList jsonListOptList = jsonMap.opt("styles").optList();
        JsonList jsonListOptList2 = jsonMap.opt("font_families").optList();
        if (strOptString.isEmpty()) {
            textAlignmentFrom = TextAlignment.CENTER;
        } else {
            textAlignmentFrom = TextAlignment.from(strOptString);
        }
        TextAlignment textAlignment = textAlignmentFrom;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jsonListOptList.size(); i2++) {
            arrayList.add(TextStyle.from(jsonListOptList.get(i2).optString()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < jsonListOptList2.size(); i3++) {
            arrayList2.add(jsonListOptList2.get(i3).optString());
        }
        return new TextAppearance(colorFromJsonField, i, textAlignment, arrayList, arrayList2);
    }

    @NonNull
    public Color getColor() {
        return this.color;
    }

    @Dimension(unit = 0)
    public int getFontSize() {
        return this.fontSize;
    }

    @NonNull
    public TextAlignment getAlignment() {
        return this.alignment;
    }

    @NonNull
    public List<TextStyle> getTextStyles() {
        return this.textStyles;
    }

    @NonNull
    public List<String> getFontFamilies() {
        return this.fontFamilies;
    }
}
