package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlInvalidHeadersException extends AlException {
    public AlInvalidHeadersException() {
        super(AlErrorCode.MAH_INVALID_HEADERS, "Access denied due to invalid headers", "415");
    }

    public AlInvalidHeadersException(String str) {
        super(AlErrorCode.MAH_INVALID_HEADERS, str, "415");
    }

    public AlInvalidHeadersException(String str, Throwable th) {
        super(AlErrorCode.MAH_INVALID_HEADERS, str, "415", th);
    }

    public AlInvalidHeadersException(Throwable th) {
        super(AlErrorCode.MAH_INVALID_HEADERS, "Access denied due to invalid headers", "415", th);
    }
}
