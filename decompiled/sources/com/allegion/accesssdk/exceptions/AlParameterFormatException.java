package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class AlParameterFormatException extends AlRuntimeException {
    public AlParameterFormatException() {
        super(AlErrorCode.SDK_STORAGE_ERROR, getFailureMessage(null), "");
    }

    private static String getFailureMessage(@Nullable String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid parameter format");
        if (str == null) {
            str2 = "";
        } else {
            str2 = ": " + str;
        }
        sb.append(str2);
        return sb.toString();
    }

    public AlParameterFormatException(String str) {
        super(AlErrorCode.SDK_STORAGE_ERROR, getFailureMessage(str), "");
    }

    public AlParameterFormatException(String str, Throwable th) {
        super(AlErrorCode.SDK_STORAGE_ERROR, getFailureMessage(str), "", th);
    }

    public AlParameterFormatException(Throwable th) {
        super(AlErrorCode.SDK_STORAGE_ERROR, "Invalid parameter format", "", th);
    }
}
