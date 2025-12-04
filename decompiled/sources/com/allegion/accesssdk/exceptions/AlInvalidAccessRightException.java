package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlInvalidAccessRightException extends AlException {
    public AlInvalidAccessRightException() {
        super(AlErrorCode.PAYLOADS_INVALID_ACCESS_RIGHT, "Request failed due to an invalid access right.", "404");
    }

    public AlInvalidAccessRightException(String str) {
        super(AlErrorCode.PAYLOADS_INVALID_ACCESS_RIGHT, str, "404");
    }

    public AlInvalidAccessRightException(String str, Throwable th) {
        super(AlErrorCode.PAYLOADS_INVALID_ACCESS_RIGHT, str, "404", th);
    }

    public AlInvalidAccessRightException(Throwable th) {
        super(AlErrorCode.PAYLOADS_INVALID_ACCESS_RIGHT, "Request failed due to an invalid access right.", "404", th);
    }
}
