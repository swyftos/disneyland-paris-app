package com.urbanairship.android.layout.util;

import androidx.annotation.NonNull;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class PercentUtils {
    private static final Pattern PATTERN_NON_NUMERIC = Pattern.compile("[^\\d.]");
    private static final Pattern PATTERN_PERCENT_W_SYMBOL = Pattern.compile("^\\d{1,3}%$");

    public static boolean isPercent(@NonNull String str) {
        return PATTERN_PERCENT_W_SYMBOL.matcher(str).matches();
    }

    public static float parse(@NonNull String str) {
        return Float.parseFloat(digits(str)) / 100.0f;
    }

    @NonNull
    public static String digits(@NonNull String str) {
        return PATTERN_NON_NUMERIC.matcher(str).replaceAll("");
    }
}
