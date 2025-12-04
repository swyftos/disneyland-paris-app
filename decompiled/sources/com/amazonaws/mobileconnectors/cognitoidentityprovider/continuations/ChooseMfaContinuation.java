package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ChooseMfaContinuation extends ChallengeContinuation {
    private List mfaOptions;

    public ChooseMfaContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        super(cognitoUser, context, str, str2, str3, respondToAuthChallengeResult, z, authenticationHandler);
        this.mfaOptions = getListFromString(getParameters().get(CognitoServiceConstants.CHLG_PARAM_MFAS_CAN_CHOOSE));
    }

    public List<String> getMfaOptions() {
        if (this.mfaOptions == null) {
            this.mfaOptions = getListFromString(getParameters().get(CognitoServiceConstants.CHLG_PARAM_MFAS_CAN_CHOOSE));
        }
        return this.mfaOptions;
    }

    public void setMfaOption(String str) {
        List<String> mfaOptions = getMfaOptions();
        if (str == null || !mfaOptions.contains(str)) {
            throw new CognitoParameterInvalidException(String.format(Locale.US, "invalid MFA option: %s", str));
        }
        setChallengeResponse(CognitoServiceConstants.CHLG_RESP_ANSWER, str);
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation, com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        if (!this.challengeResponses.containsKey(CognitoServiceConstants.CHLG_RESP_ANSWER)) {
            throw new CognitoParameterInvalidException("MFA option is not set");
        }
        super.continueTask();
    }

    private List getListFromString(String str) {
        return Arrays.asList(str.replace("[", "").replace("]", "").replace("\"", "").split(","));
    }
}
