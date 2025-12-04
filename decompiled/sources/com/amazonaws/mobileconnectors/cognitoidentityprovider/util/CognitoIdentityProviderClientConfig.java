package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import ch.qos.logback.core.spi.ComponentTracker;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;

/* loaded from: classes2.dex */
public final class CognitoIdentityProviderClientConfig {
    private static long refreshThreshold = 300000;

    public static void setRefreshThreshold(long j) {
        if (j > ComponentTracker.DEFAULT_TIMEOUT || j < 0) {
            throw new CognitoParameterInvalidException(String.format("The value of refreshThreshold must between %d and %d milliseconds", 0L, Long.valueOf(ComponentTracker.DEFAULT_TIMEOUT)));
        }
        refreshThreshold = j;
    }

    public static long getRefreshThreshold() {
        return refreshThreshold;
    }
}
