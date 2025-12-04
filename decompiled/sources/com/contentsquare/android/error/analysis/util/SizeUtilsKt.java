package com.contentsquare.android.error.analysis.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ASCII_MAX_CODE_POINT", "", "BMP_MAX_CODE_POINT", "HIGH_SURROGATE_MAX_CODE_POINT", "HIGH_SURROGATE_RANGE_END", "HIGH_SURROGATE_RANGE_START", "LOW_SURROGATE_MAX_CODE_POINT", "LOW_SURROGATE_MIN_CODE_POINT", "SURROGATE_PAIR_MALFORMED_SIZE", "UTF8_SIZE_1_BYTE_CHAR", "UTF8_SIZE_2_BYTE_CHAR", "UTF8_SIZE_3_BYTE_CHAR", "UTF8_SIZE_4_BYTE_CHAR", "utf8Size", "", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SizeUtilsKt {
    private static final int ASCII_MAX_CODE_POINT = 128;
    private static final int BMP_MAX_CODE_POINT = 2048;
    private static final int HIGH_SURROGATE_MAX_CODE_POINT = 56319;
    private static final int HIGH_SURROGATE_RANGE_END = 57343;
    private static final int HIGH_SURROGATE_RANGE_START = 55296;
    private static final int LOW_SURROGATE_MAX_CODE_POINT = 57343;
    private static final int LOW_SURROGATE_MIN_CODE_POINT = 56320;
    private static final int SURROGATE_PAIR_MALFORMED_SIZE = 1;
    private static final int UTF8_SIZE_1_BYTE_CHAR = 1;
    private static final int UTF8_SIZE_2_BYTE_CHAR = 2;
    private static final int UTF8_SIZE_3_BYTE_CHAR = 3;
    private static final int UTF8_SIZE_4_BYTE_CHAR = 4;

    public static final int utf8Size(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            int i3 = 1;
            if (cCharAt < 128) {
                i++;
            } else if (cCharAt < 2048) {
                i++;
                i3 = 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i++;
                i3 = 3;
            } else {
                int i4 = i + 1;
                char cCharAt2 = i4 < str.length() ? str.charAt(i4) : (char) 0;
                if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                    i = i4;
                } else {
                    i += 2;
                    i3 = 4;
                }
            }
            i2 += i3;
        }
        return i2;
    }
}
