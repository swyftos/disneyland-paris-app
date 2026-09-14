package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

/* JADX INFO: loaded from: classes2.dex */
public interface CognitoIdentityProviderContinuation<T> {
    void continueTask();

    T getParameters();
}
