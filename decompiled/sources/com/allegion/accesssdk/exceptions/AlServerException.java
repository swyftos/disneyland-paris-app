package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlServerException extends AlException {
    public AlServerException() {
        super(AlErrorCode.MAH_SERVER_ERROR, "Request failed while attempting to contact the server.", "500");
    }

    public AlServerException(String str) {
        super(AlErrorCode.MAH_SERVER_ERROR, str, "500");
    }

    public AlServerException(String str, Throwable th) {
        super(AlErrorCode.MAH_SERVER_ERROR, str, "500", th);
    }

    public AlServerException(Throwable th) {
        super(AlErrorCode.MAH_SERVER_ERROR, "Request failed while attempting to contact the server.", "500", th);
    }
}
