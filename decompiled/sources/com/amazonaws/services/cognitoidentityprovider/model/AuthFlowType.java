package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum AuthFlowType {
    USER_SRP_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP),
    REFRESH_TOKEN_AUTH(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN),
    REFRESH_TOKEN(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN),
    CUSTOM_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH),
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    USER_PASSWORD_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD),
    ADMIN_USER_PASSWORD_AUTH("ADMIN_USER_PASSWORD_AUTH");

    private static final Map enumMap;
    private String value;

    static {
        AuthFlowType authFlowType = USER_SRP_AUTH;
        AuthFlowType authFlowType2 = REFRESH_TOKEN_AUTH;
        AuthFlowType authFlowType3 = REFRESH_TOKEN;
        AuthFlowType authFlowType4 = CUSTOM_AUTH;
        AuthFlowType authFlowType5 = ADMIN_NO_SRP_AUTH;
        AuthFlowType authFlowType6 = USER_PASSWORD_AUTH;
        AuthFlowType authFlowType7 = ADMIN_USER_PASSWORD_AUTH;
        HashMap map = new HashMap();
        enumMap = map;
        map.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP, authFlowType);
        map.put(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN, authFlowType2);
        map.put(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN, authFlowType3);
        map.put(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH, authFlowType4);
        map.put("ADMIN_NO_SRP_AUTH", authFlowType5);
        map.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD, authFlowType6);
        map.put("ADMIN_USER_PASSWORD_AUTH", authFlowType7);
    }

    AuthFlowType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AuthFlowType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (AuthFlowType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
