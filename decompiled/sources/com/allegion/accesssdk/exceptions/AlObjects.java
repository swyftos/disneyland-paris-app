package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlObjects {
    private AlObjects() {
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new AlNullPointerException(str, AlErrorCode.SDK_NULL_VALUE_ERROR);
    }

    public static <T> T requireNonNull(T t, AlErrorCode alErrorCode) {
        if (t != null) {
            return t;
        }
        throw new AlNullPointerException(alErrorCode);
    }

    public static <T> T requireNonNull(T t, String str, AlErrorCode alErrorCode) {
        if (t != null) {
            return t;
        }
        throw new AlNullPointerException(str, alErrorCode);
    }
}
