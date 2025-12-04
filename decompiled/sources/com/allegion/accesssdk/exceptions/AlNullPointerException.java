package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlNullPointerException extends AlRuntimeException {
    public AlNullPointerException(AlErrorCode alErrorCode) {
        super(alErrorCode, "Null parameter", "");
    }

    public AlNullPointerException(String str, AlErrorCode alErrorCode) {
        super(alErrorCode, str, "");
    }

    public AlNullPointerException(String str, Throwable th, AlErrorCode alErrorCode) {
        super(alErrorCode, str, "", th);
    }

    public AlNullPointerException(Throwable th, AlErrorCode alErrorCode) {
        super(alErrorCode, "Null parameter", "", th);
    }
}
