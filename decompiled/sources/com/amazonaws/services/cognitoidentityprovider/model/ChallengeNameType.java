package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum ChallengeNameType {
    SMS_MFA("SMS_MFA"),
    SOFTWARE_TOKEN_MFA(CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA),
    SELECT_MFA_TYPE(CognitoServiceConstants.CHLG_TYPE_SELECT_MFA_TYPE),
    MFA_SETUP(CognitoServiceConstants.CHLG_TYPE_MFA_SETUP),
    PASSWORD_VERIFIER(CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER),
    CUSTOM_CHALLENGE(CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE),
    DEVICE_SRP_AUTH(CognitoServiceConstants.CHLG_TYPE_DEVICE_SRP_AUTH),
    DEVICE_PASSWORD_VERIFIER(CognitoServiceConstants.CHLG_TYPE_DEVICE_PASSWORD_VERIFIER),
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    NEW_PASSWORD_REQUIRED(CognitoServiceConstants.CHLG_TYPE_NEW_PASSWORD_REQUIRED);

    private static final Map enumMap;
    private String value;

    static {
        ChallengeNameType challengeNameType = SMS_MFA;
        ChallengeNameType challengeNameType2 = SOFTWARE_TOKEN_MFA;
        ChallengeNameType challengeNameType3 = SELECT_MFA_TYPE;
        ChallengeNameType challengeNameType4 = MFA_SETUP;
        ChallengeNameType challengeNameType5 = PASSWORD_VERIFIER;
        ChallengeNameType challengeNameType6 = CUSTOM_CHALLENGE;
        ChallengeNameType challengeNameType7 = DEVICE_SRP_AUTH;
        ChallengeNameType challengeNameType8 = DEVICE_PASSWORD_VERIFIER;
        ChallengeNameType challengeNameType9 = ADMIN_NO_SRP_AUTH;
        ChallengeNameType challengeNameType10 = NEW_PASSWORD_REQUIRED;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("SMS_MFA", challengeNameType);
        map.put(CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA, challengeNameType2);
        map.put(CognitoServiceConstants.CHLG_TYPE_SELECT_MFA_TYPE, challengeNameType3);
        map.put(CognitoServiceConstants.CHLG_TYPE_MFA_SETUP, challengeNameType4);
        map.put(CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER, challengeNameType5);
        map.put(CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE, challengeNameType6);
        map.put(CognitoServiceConstants.CHLG_TYPE_DEVICE_SRP_AUTH, challengeNameType7);
        map.put(CognitoServiceConstants.CHLG_TYPE_DEVICE_PASSWORD_VERIFIER, challengeNameType8);
        map.put("ADMIN_NO_SRP_AUTH", challengeNameType9);
        map.put(CognitoServiceConstants.CHLG_TYPE_NEW_PASSWORD_REQUIRED, challengeNameType10);
    }

    ChallengeNameType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ChallengeNameType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ChallengeNameType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
