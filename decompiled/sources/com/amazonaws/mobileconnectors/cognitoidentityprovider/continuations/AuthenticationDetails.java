package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AuthenticationDetails {
    private Map authenticationParameters;
    private String authenticationType;
    private String password;
    private final String userId;
    private List validationData;

    public AuthenticationDetails(String str, String str2, Map<String, String> map) {
        this.authenticationType = CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER;
        this.userId = str;
        this.password = str2;
        setValidationData(map);
    }

    public AuthenticationDetails(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        this.userId = str;
        this.password = str2;
        if (map != null) {
            this.authenticationType = CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE;
            this.authenticationParameters = map;
            setAuthenticationParameter("USERNAME", str);
            setCustomChallenge("SRP_A");
            setValidationData(map2);
            return;
        }
        this.authenticationType = null;
    }

    public AuthenticationDetails(String str, Map<String, String> map, Map<String, String> map2) {
        this.userId = str;
        if (map != null) {
            this.authenticationType = CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE;
            this.authenticationParameters = map;
            setValidationData(map2);
            return;
        }
        this.authenticationType = null;
    }

    public void setAuthenticationType(String str) {
        this.authenticationType = str;
        if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(str) || CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD.equals(this.authenticationType)) {
            this.authenticationParameters = null;
        } else if (CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE.equals(this.authenticationType)) {
            this.password = null;
        }
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserId() {
        return this.userId;
    }

    public List<AttributeType> getValidationData() {
        return this.validationData;
    }

    public String getAuthenticationType() {
        return this.authenticationType;
    }

    public Map<String, String> getAuthenticationParameters() {
        return this.authenticationParameters;
    }

    public void setCustomChallenge(String str) {
        if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(this.authenticationType) || CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD.equals(this.authenticationType)) {
            throw new CognitoParameterInvalidException(String.format("Cannot set custom challenge when the authentication type is %s.", this.authenticationType));
        }
        this.authenticationType = CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE;
        setAuthenticationParameter(CognitoServiceConstants.AUTH_PARAM_CHALLENGE_NAME, str);
    }

    public String getCustomChallenge() {
        return (String) this.authenticationParameters.get(CognitoServiceConstants.AUTH_PARAM_CHALLENGE_NAME);
    }

    private void setValidationData(Map map) {
        if (map != null) {
            this.validationData = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                AttributeType attributeType = new AttributeType();
                attributeType.setName((String) entry.getKey());
                attributeType.setValue((String) entry.getValue());
                this.validationData.add(attributeType);
            }
            return;
        }
        this.validationData = null;
    }

    public void setAuthenticationParameters(Map<String, String> map) {
        this.authenticationParameters = map;
    }

    public void setAuthenticationParameter(String str, String str2) {
        if (str != null) {
            if (this.authenticationParameters == null) {
                this.authenticationParameters = new HashMap();
            }
            this.authenticationParameters.put(str, str2);
            return;
        }
        throw new CognitoParameterInvalidException("A null key was used to add a new authentications parameter.");
    }
}
