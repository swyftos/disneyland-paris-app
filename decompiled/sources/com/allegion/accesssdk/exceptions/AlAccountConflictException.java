package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlAccountConflictException extends AlException {
    public AlAccountConflictException() {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONFLICT, "An account is already registered for this device, please use that information or restart the entire enrollment process.", "409");
    }

    public AlAccountConflictException(String str) {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONFLICT, str, "409");
    }

    public AlAccountConflictException(String str, Throwable th) {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONFLICT, str, "409", th);
    }

    public AlAccountConflictException(Throwable th) {
        super(AlErrorCode.ENROLLMENT_ACCOUNT_CONFLICT, "An account is already registered for this device, please use that information or restart the entire enrollment process.", "409", th);
    }
}
