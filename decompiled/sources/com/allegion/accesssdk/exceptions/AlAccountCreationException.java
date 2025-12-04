package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlAccountCreationException extends AlException {
    public AlAccountCreationException() {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to create an account.", "");
    }

    public AlAccountCreationException(String str) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "");
    }

    public AlAccountCreationException(String str, Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "", th);
    }

    public AlAccountCreationException(Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to create an account.", "", th);
    }
}
