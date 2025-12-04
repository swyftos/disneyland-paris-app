package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlAlreadyEnrolledException extends AlException {
    public AlAlreadyEnrolledException() {
        super(AlErrorCode.SDK_ALREADY_ENROLLED, "An error occurred while validating the requested operation", "The operation requires the SDK to not be enrolled");
    }

    public AlAlreadyEnrolledException(String str) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "The operation requires the SDK to not be enrolled");
    }

    public AlAlreadyEnrolledException(String str, Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "The operation requires the SDK to not be enrolled", th);
    }

    public AlAlreadyEnrolledException(Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, "An error occurred while validating the requested operation", "The operation requires the SDK to not be enrolled", th);
    }
}
