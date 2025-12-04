package com.urbanairship;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.C;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class Fonts {
    private static final String[] JELLY_BEAN_SYSTEM_FONT_FAMILIES = {C.SERIF_NAME, C.SANS_SERIF_NAME, "sans-serif-light", "sans-serif-condensed", "sans-serif-thin", "sans-serif-medium"};
    private static final String[] LOLLIPOP_SYSTEM_FONT_FAMILIES = {"sans-serif-medium", "sans-serif-black", "cursive", "casual"};
    private static final String[] MARSHMALLOW_SYSTEM_FONT_FAMILIES = {"sans-serif-smallcaps", "serif-monospace", "monospace"};
    private static Fonts instance;
    private final Context context;
    private final Map fontCache;
    private final Set systemFonts;

    private Fonts(Context context) {
        HashSet hashSet = new HashSet();
        this.systemFonts = hashSet;
        this.fontCache = new HashMap();
        this.context = context.getApplicationContext();
        Collections.addAll(hashSet, JELLY_BEAN_SYSTEM_FONT_FAMILIES);
        Collections.addAll(hashSet, LOLLIPOP_SYSTEM_FONT_FAMILIES);
        Collections.addAll(hashSet, MARSHMALLOW_SYSTEM_FONT_FAMILIES);
    }

    @NonNull
    public static Fonts shared(@NonNull Context context) {
        synchronized (Fonts.class) {
            try {
                if (instance == null) {
                    instance = new Fonts(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return instance;
    }

    public synchronized void addFontFamily(@NonNull String str, @NonNull Typeface typeface) {
        this.fontCache.put(str, typeface);
    }

    @Nullable
    public synchronized Typeface getFontFamily(@NonNull String str) {
        if (this.fontCache.containsKey(str)) {
            return (Typeface) this.fontCache.get(str);
        }
        int identifier = this.context.getResources().getIdentifier(str, "font", this.context.getPackageName());
        if (identifier != 0) {
            try {
                Typeface font = ResourcesCompat.getFont(this.context, identifier);
                if (font != null) {
                    this.fontCache.put(str, font);
                    return font;
                }
            } catch (Resources.NotFoundException e) {
                UALog.e(e, "Unable to load font from resources: %s", str);
            }
        }
        if (!isSystemFont(str)) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        this.fontCache.put(str, typefaceCreate);
        return typefaceCreate;
    }

    public boolean isSystemFont(@NonNull String str) {
        return this.systemFonts.contains(str);
    }
}
