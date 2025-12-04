package com.amazonaws.mobileconnectors.cognitoidentityprovider;

/* loaded from: classes2.dex */
public class CognitoUserDetails {
    private CognitoUserAttributes cognitoUserAttributes;
    private CognitoUserSettings cognitoUserSettings;

    protected CognitoUserDetails(CognitoUserAttributes cognitoUserAttributes, CognitoUserSettings cognitoUserSettings) {
        this.cognitoUserAttributes = cognitoUserAttributes;
        this.cognitoUserSettings = cognitoUserSettings;
    }

    public CognitoUserAttributes getAttributes() {
        return this.cognitoUserAttributes;
    }

    public CognitoUserSettings getSettings() {
        return this.cognitoUserSettings;
    }
}
