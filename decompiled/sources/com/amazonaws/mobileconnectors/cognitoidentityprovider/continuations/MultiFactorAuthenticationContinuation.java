package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MultiFactorAuthenticationContinuation implements CognitoIdentityProviderContinuation<CognitoUserCodeDeliveryDetails> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final AuthenticationHandler callback;
    private final RespondToAuthChallengeResult challenge;
    private final Context context;
    private final boolean runInBackground;
    private final CognitoUser user;
    private String mfaCode = null;
    private final Map clientMetadata = new HashMap();

    public MultiFactorAuthenticationContinuation(CognitoUser cognitoUser, Context context, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        this.user = cognitoUser;
        this.context = context;
        this.callback = authenticationHandler;
        this.runInBackground = z;
        this.challenge = respondToAuthChallengeResult;
    }

    public Map<String, String> getClientMetaData() {
        return Collections.unmodifiableMap(this.clientMetadata);
    }

    public void setClientMetaData(Map<String, String> map) {
        this.clientMetadata.clear();
        if (map != null) {
            this.clientMetadata.putAll(map);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public CognitoUserCodeDeliveryDetails getParameters() {
        if (CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA.equals(this.challenge.getChallengeName())) {
            return new CognitoUserCodeDeliveryDetails("Time-based One-time Password", this.challenge.getChallengeParameters().get("FRIENDLY_DEVICE_NAME"), null);
        }
        if ("SMS_MFA".equals(this.challenge.getChallengeName())) {
            return new CognitoUserCodeDeliveryDetails(this.challenge.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_CODE_DEL_DESTINATION), this.challenge.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_CODE_DEL_MEDIUM), null);
        }
        return new CognitoUserCodeDeliveryDetails("", "", "");
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        Runnable runnableRespondToMfaChallenge;
        if (this.runInBackground) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnableRespondToMfaChallenge2;
                    Handler handler = new Handler(MultiFactorAuthenticationContinuation.this.context.getMainLooper());
                    try {
                        runnableRespondToMfaChallenge2 = MultiFactorAuthenticationContinuation.this.user.respondToMfaChallenge(MultiFactorAuthenticationContinuation.this.clientMetadata, MultiFactorAuthenticationContinuation.this.mfaCode, MultiFactorAuthenticationContinuation.this.challenge, MultiFactorAuthenticationContinuation.this.callback, true);
                    } catch (Exception e) {
                        runnableRespondToMfaChallenge2 = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MultiFactorAuthenticationContinuation.this.callback.onFailure(e);
                            }
                        };
                    }
                    handler.post(runnableRespondToMfaChallenge2);
                }
            }).start();
            return;
        }
        try {
            runnableRespondToMfaChallenge = this.user.respondToMfaChallenge(this.clientMetadata, this.mfaCode, this.challenge, this.callback, false);
        } catch (Exception e) {
            runnableRespondToMfaChallenge = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation.2
                @Override // java.lang.Runnable
                public void run() {
                    MultiFactorAuthenticationContinuation.this.callback.onFailure(e);
                }
            };
        }
        runnableRespondToMfaChallenge.run();
    }

    public void setMfaCode(String str) {
        this.mfaCode = str;
    }
}
