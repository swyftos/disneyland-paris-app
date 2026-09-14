package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.VerifyMfaContinuation;

/* JADX INFO: loaded from: classes2.dex */
public interface RegisterMfaHandler {
    void onFailure(Exception exc);

    void onSuccess(String str);

    void onVerify(VerifyMfaContinuation verifyMfaContinuation);
}
