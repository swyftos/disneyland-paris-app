package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlInvalidIntegrationIdException extends AlException {
    public AlInvalidIntegrationIdException() {
        super(AlErrorCode.ENROLLMENT_INVALID_INTEGRATION_ID, "Invalid Integration Id. Please ensure that your integration has already been setup in the mobile access hub.", "404");
    }

    public AlInvalidIntegrationIdException(String str) {
        super(AlErrorCode.ENROLLMENT_INVALID_INTEGRATION_ID, str, "404");
    }

    public AlInvalidIntegrationIdException(String str, Throwable th) {
        super(AlErrorCode.ENROLLMENT_INVALID_INTEGRATION_ID, str, "404", th);
    }

    public AlInvalidIntegrationIdException(Throwable th) {
        super(AlErrorCode.ENROLLMENT_INVALID_INTEGRATION_ID, "Invalid Integration Id. Please ensure that your integration has already been setup in the mobile access hub.", "404", th);
    }
}
