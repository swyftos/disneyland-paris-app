package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.http.RequestException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class PlatformUtils {
    public static final String AMAZON = "amazon";
    public static final String ANDROID = "android";
    public static final String UNKNOWN = "unknown";

    public static boolean isPlatformValid(int i) {
        return i == -1 || i == 1 || i == 2;
    }

    public static int parsePlatform(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return -1;
            }
        }
        return i2;
    }

    @NonNull
    public static String asString(int i) {
        if (i == 1) {
            return "amazon";
        }
        if (i == 2) {
            return "android";
        }
        return "unknown";
    }

    @NonNull
    public static String getDeviceType(int i) throws RequestException {
        String strAsString = asString(i);
        if (strAsString.equals("unknown")) {
            throw new RequestException("Invalid platform");
        }
        return strAsString;
    }
}
