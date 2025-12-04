package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ForgotPasswordContinuation implements CognitoIdentityProviderContinuation<CognitoUserCodeDeliveryDetails> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final ForgotPasswordHandler callback;
    private final CognitoUserCodeDeliveryDetails parameters;
    private final boolean runInBackground;
    private final CognitoUser user;
    private String password = null;
    private String verificationCode = null;
    private final Map clientMetadata = new HashMap();

    public ForgotPasswordContinuation(CognitoUser cognitoUser, CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails, boolean z, ForgotPasswordHandler forgotPasswordHandler) {
        this.callback = forgotPasswordHandler;
        this.user = cognitoUser;
        this.parameters = cognitoUserCodeDeliveryDetails;
        this.runInBackground = z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public CognitoUserCodeDeliveryDetails getParameters() {
        return this.parameters;
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        if (this.runInBackground) {
            this.user.confirmPasswordInBackground(this.verificationCode, this.password, this.clientMetadata, this.callback);
        } else {
            this.user.confirmPassword(this.verificationCode, this.password, this.clientMetadata, this.callback);
        }
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setVerificationCode(String str) {
        this.verificationCode = str;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata.clear();
        if (map != null) {
            this.clientMetadata.putAll(map);
        }
    }
}
