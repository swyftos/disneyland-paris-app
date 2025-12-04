package com.allegion.accesssdk.enums;

/* loaded from: classes2.dex */
public enum AlErrorCode {
    SDK_ALREADY_ENROLLED("sdkAlreadyEnrolled"),
    SDK_CONFIG_INVALID_SUB_KEY("sdkConfigurationInvalidSubscriptionKey"),
    SDK_CONFIG_INVALID_CONFIG("sdkConfigurationInvalidConfig"),
    SDK_CONFIG_INVALID_APPLICATION("sdkConfigurationInvalidApplication"),
    SDK_STORAGE_ERROR("sdkStorageError"),
    SDK_NULL_VALUE_ERROR("sdkNullValueError"),
    ENROLLMENT_INVALID_TOKEN("enrollmentInvalidIdToken"),
    ENROLLMENT_INVALID_INTEGRATION_ID("enrollmentInvalidIntegrationId"),
    ENROLLMENT_ACCOUNT_CONFLICT("enrollmentAccountConflict"),
    ENROLLMENT_DEVICE_ENCRYPTION_ERROR("enrollmentDeviceEncryptionKeyError"),
    ENROLLMENT_ACCOUNT_CONNECTION_ERROR("enrollmentAccountConnectionError"),
    SDK_DEVICE_NOT_REGISTERED("deviceNotRegistered"),
    PAYLOADS_INVALID_ACCESS_RIGHT("payloadsInvalidAccessRight"),
    DEVICE_NULL_ERROR("deviceNullError"),
    DEVICE_UNKNOWN_ERROR("deviceUnknownError"),
    DEVICE_INVALID_REQUEST("deviceInvalidRequest"),
    DEVICE_CONNECTION_FAIL("deviceConnectionFail"),
    DEVICE_COMMUNICATION_FAIL("deviceCommunicationFail"),
    DEVICE_BUSY("deviceBusy"),
    DEVICE_PAYLOAD_FAIL("devicePayloadFail"),
    DEVICE_PAYLOAD_TIMEOUT("devicePayloadTimeout"),
    DEVICE_PUBLIC_KEY_EXPORT_ERROR("devicePublicKeyExportError"),
    SEARCH_UNSUPPORTED_DEVICE("searchUnsupportedDevice"),
    SEARCH_FAILED_TO_START("searchFailed"),
    UNKNOWN_ERROR("unknownError"),
    MAH_SERVER_ERROR("mahServerError"),
    MAH_INVALID_SUBSCRIPTION_KEY("mahInvalidSubscriptionKey"),
    MAH_INVALID_HEADERS("mahInvalidHeaders"),
    MAH_INVALID_RESPONSE("mahInvalidResponse");

    private String value;

    AlErrorCode(String str) {
        this.value = str;
    }

    public String getUrl() {
        return "https://api.allegion.com/errors/producers/MaSdkAndroid/errorcodes/" + this.value;
    }

    public String getValue() {
        return this.value;
    }
}
