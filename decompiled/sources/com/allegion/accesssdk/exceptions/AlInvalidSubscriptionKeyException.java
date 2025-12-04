package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlInvalidSubscriptionKeyException extends AlException {
    public AlInvalidSubscriptionKeyException() {
        super(AlErrorCode.MAH_INVALID_SUBSCRIPTION_KEY, "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.", "401");
    }

    public AlInvalidSubscriptionKeyException(String str) {
        super(AlErrorCode.MAH_INVALID_SUBSCRIPTION_KEY, str, "401");
    }

    public AlInvalidSubscriptionKeyException(String str, Throwable th) {
        super(AlErrorCode.MAH_INVALID_SUBSCRIPTION_KEY, str, "401", th);
    }

    public AlInvalidSubscriptionKeyException(Throwable th) {
        super(AlErrorCode.MAH_INVALID_SUBSCRIPTION_KEY, "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.", "401", th);
    }
}
