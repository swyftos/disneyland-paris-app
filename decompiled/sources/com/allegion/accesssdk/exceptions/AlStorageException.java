package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlStorageException extends AlRuntimeException {
    public AlStorageException() {
        super(AlErrorCode.SDK_STORAGE_ERROR, "Storage facility failure.", "");
    }

    public AlStorageException(String str) {
        super(AlErrorCode.SDK_STORAGE_ERROR, str, "");
    }

    public AlStorageException(String str, Throwable th) {
        super(AlErrorCode.SDK_STORAGE_ERROR, "Storage facility failure.", "", th);
    }

    public AlStorageException(Throwable th) {
        super(AlErrorCode.SDK_STORAGE_ERROR, "Storage facility failure.", "", th);
    }
}
