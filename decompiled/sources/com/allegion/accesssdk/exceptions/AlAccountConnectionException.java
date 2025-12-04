package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlAccountConnectionException extends AlException {
    public AlAccountConnectionException() {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONNECTION_ERROR, "An unknown error occurred while attempting to connect your account.", "");
    }

    public AlAccountConnectionException(String str) {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONNECTION_ERROR, str, "");
    }

    public AlAccountConnectionException(String str, Throwable th) {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONNECTION_ERROR, str, "", th);
    }

    public AlAccountConnectionException(Throwable th) {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONNECTION_ERROR, "An unknown error occurred while attempting to connect your account.", "", th);
    }
}
