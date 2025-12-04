package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

/* loaded from: classes2.dex */
public interface CognitoIdentityProviderContinuation<T> {
    void continueTask();

    T getParameters();
}
