package com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions;

/* loaded from: classes2.dex */
public class CognitoLambdaFailedException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = -2401240885762953890L;

    public CognitoLambdaFailedException(String str, Throwable th) {
        super(str, th);
    }

    public CognitoLambdaFailedException(String str) {
        super(str);
    }
}
