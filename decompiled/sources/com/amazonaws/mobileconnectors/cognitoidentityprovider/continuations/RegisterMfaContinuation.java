package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import com.amazonaws.util.StringUtils;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class RegisterMfaContinuation extends ChallengeContinuation {
    private List mfaOptions;

    public RegisterMfaContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        super(cognitoUser, context, str, str2, str3, respondToAuthChallengeResult, z, authenticationHandler);
        this.mfaOptions = getListFromString(getParameters().get(CognitoServiceConstants.CHLG_PARAM_MFAS_CAN_SETUP));
    }

    public List<String> getMfaOptions() {
        if (this.mfaOptions == null) {
            this.mfaOptions = getListFromString(getParameters().get(CognitoServiceConstants.CHLG_PARAM_MFAS_CAN_SETUP));
        }
        return this.mfaOptions;
    }

    public void setSessionToken(String str) {
        if (StringUtils.isBlank(str)) {
            throw new CognitoParameterInvalidException("session token cannot be null");
        }
        setResponseSessionCode(str);
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation, com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        super.continueTask();
    }

    private List getListFromString(String str) {
        return Arrays.asList(str.replace("[", "").replace("]", "").replace("\"", "").split(","));
    }
}
