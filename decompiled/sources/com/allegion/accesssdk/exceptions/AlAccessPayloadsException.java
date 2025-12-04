package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlAccessPayloadsException extends AlException {
    public AlAccessPayloadsException() {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to retrieve access payloads.", "");
    }

    public AlAccessPayloadsException(String str) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "");
    }

    public AlAccessPayloadsException(String str, Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "", th);
    }

    public AlAccessPayloadsException(Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to retrieve access payloads.", "", th);
    }
}
