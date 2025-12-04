package com.urbanairship.util;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class UAHttpStatusUtil {
    public static boolean inSuccessRange(int i) {
        return i / 100 == 2;
    }

    public static boolean inRedirectionRange(int i) {
        return i / 100 == 3;
    }

    public static boolean inClientErrorRange(int i) {
        return i / 100 == 4;
    }

    public static boolean inServerErrorRange(int i) {
        return i / 100 == 5;
    }
}
