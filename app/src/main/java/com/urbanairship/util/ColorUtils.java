package com.urbanairship.util;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import gherkin.GherkinLanguageConstants;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ColorUtils {
    @NonNull
    public static String convertToString(@ColorInt int i) {
        StringBuilder sb = new StringBuilder(GherkinLanguageConstants.COMMENT_PREFIX);
        sb.append(Integer.toHexString(i));
        while (sb.length() < 9) {
            sb.append("0");
        }
        return sb.toString();
    }
}
