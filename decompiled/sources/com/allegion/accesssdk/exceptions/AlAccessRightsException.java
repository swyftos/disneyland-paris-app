package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlAccessRightsException extends AlException {
    public AlAccessRightsException() {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to retrieve access rights.", "");
    }

    public AlAccessRightsException(String str) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "");
    }

    public AlAccessRightsException(String str, Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "", th);
    }

    public AlAccessRightsException(Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to retrieve access rights.", "", th);
    }
}
