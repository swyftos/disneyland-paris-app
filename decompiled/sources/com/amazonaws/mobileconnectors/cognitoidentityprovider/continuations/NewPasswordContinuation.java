package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NewPasswordContinuation extends ChallengeContinuation {
    private final AuthenticationHandler callback;
    private Map currentUserAttributes;
    private List requiredAttributes;

    public NewPasswordContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) throws JSONException {
        super(cognitoUser, context, str, str2, str3, respondToAuthChallengeResult, z, authenticationHandler);
        this.callback = authenticationHandler;
        parseUserAttributes(getParameters().get(CognitoServiceConstants.CHLG_PARAM_USER_ATTRIBUTE));
        parseRequiredAttributes(getParameters().get(CognitoServiceConstants.CHLG_PARAM_REQUIRED_ATTRIBUTE));
    }

    public List<String> getRequiredAttributes() {
        return this.requiredAttributes;
    }

    public Map<String, String> getCurrentUserAttributes() {
        return this.currentUserAttributes;
    }

    public void setUserAttribute(String str, String str2) {
        setChallengeResponse(CognitoServiceConstants.CHLG_PARAM_USER_ATTRIBUTE_PREFIX + str, str2);
    }

    public void setPassword(String str) {
        if (str != null) {
            setChallengeResponse(CognitoServiceConstants.CHLG_RESP_NEW_PASSWORD, str);
        }
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation, com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        List list = this.requiredAttributes;
        if (list != null && list.size() > 1) {
            for (String str : this.requiredAttributes) {
                if (!this.challengeResponses.containsKey(CognitoServiceConstants.CHLG_PARAM_USER_ATTRIBUTE_PREFIX + str)) {
                    throw new CognitoParameterInvalidException(String.format("Missing required attribute: %s", str));
                }
            }
        }
        if (this.challengeResponses.containsKey(CognitoServiceConstants.CHLG_RESP_NEW_PASSWORD) && this.challengeResponses.get(CognitoServiceConstants.CHLG_RESP_NEW_PASSWORD) != null) {
            super.continueTask();
            return;
        }
        throw new CognitoParameterInvalidException("New password was not set");
    }

    private void parseUserAttributes(String str) throws JSONException {
        this.currentUserAttributes = new HashMap();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.currentUserAttributes.put(next, jSONObject.getString(next));
                }
            } catch (Exception e) {
                this.callback.onFailure(e);
            }
        }
    }

    private void parseRequiredAttributes(String str) {
        this.requiredAttributes = new ArrayList();
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.requiredAttributes.add(jSONArray.getString(i).split(CognitoServiceConstants.CHLG_PARAM_USER_ATTRIBUTE_PREFIX, 2)[1]);
                }
            } catch (Exception e) {
                this.callback.onFailure(e);
            }
        }
    }
}
