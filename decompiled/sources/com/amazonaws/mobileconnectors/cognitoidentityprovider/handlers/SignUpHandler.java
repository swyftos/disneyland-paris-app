package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;

/* loaded from: classes2.dex */
public interface SignUpHandler {
    void onFailure(Exception exc);

    void onSuccess(CognitoUser cognitoUser, SignUpResult signUpResult);
}
