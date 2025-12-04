package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlDeviceEncryptionKeyException extends AlException {
    public AlDeviceEncryptionKeyException() {
        super(AlErrorCode.ENROLLMENT_DEVICE_ENCRYPTION_ERROR, "Invalid device encryption key. Please ensure you are using a proper context and your device supports secure storage.", "403");
    }

    public AlDeviceEncryptionKeyException(String str) {
        super(AlErrorCode.ENROLLMENT_DEVICE_ENCRYPTION_ERROR, str, "403");
    }

    public AlDeviceEncryptionKeyException(String str, Throwable th) {
        super(AlErrorCode.ENROLLMENT_DEVICE_ENCRYPTION_ERROR, str, "403", th);
    }

    public AlDeviceEncryptionKeyException(Throwable th) {
        super(AlErrorCode.ENROLLMENT_DEVICE_ENCRYPTION_ERROR, "Invalid device encryption key. Please ensure you are using a proper context and your device supports secure storage.", "403", th);
    }
}
