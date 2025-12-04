package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlInvalidIdTokenException extends AlException {
    public AlInvalidIdTokenException() {
        super(AlErrorCode.ENROLLMENT_INVALID_TOKEN, "Invalid idToken. Please check with your access provider that your idToken is still valid.", "400");
    }

    public AlInvalidIdTokenException(String str) {
        super(AlErrorCode.ENROLLMENT_INVALID_TOKEN, str, "400");
    }

    public AlInvalidIdTokenException(String str, Throwable th) {
        super(AlErrorCode.ENROLLMENT_INVALID_TOKEN, str, "400", th);
    }

    public AlInvalidIdTokenException(Throwable th) {
        super(AlErrorCode.ENROLLMENT_INVALID_TOKEN, "Invalid idToken. Please check with your access provider that your idToken is still valid.", "400", th);
    }
}
