package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlInvalidResponseException extends AlException {
    public AlInvalidResponseException() {
        super(AlErrorCode.MAH_INVALID_RESPONSE, "Response invalid, retry request.", "500");
    }

    public AlInvalidResponseException(String str) {
        super(AlErrorCode.MAH_INVALID_RESPONSE, str, "500");
    }

    public AlInvalidResponseException(String str, Throwable th) {
        super(AlErrorCode.MAH_INVALID_RESPONSE, str, "500", th);
    }

    public AlInvalidResponseException(Throwable th) {
        super(AlErrorCode.MAH_INVALID_RESPONSE, "Response invalid, retry request.", "500", th);
    }
}
