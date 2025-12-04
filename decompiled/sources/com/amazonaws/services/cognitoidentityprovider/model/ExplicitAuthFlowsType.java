package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum ExplicitAuthFlowsType {
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    CUSTOM_AUTH_FLOW_ONLY("CUSTOM_AUTH_FLOW_ONLY"),
    USER_PASSWORD_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD),
    ALLOW_ADMIN_USER_PASSWORD_AUTH("ALLOW_ADMIN_USER_PASSWORD_AUTH"),
    ALLOW_CUSTOM_AUTH("ALLOW_CUSTOM_AUTH"),
    ALLOW_USER_PASSWORD_AUTH("ALLOW_USER_PASSWORD_AUTH"),
    ALLOW_USER_SRP_AUTH("ALLOW_USER_SRP_AUTH"),
    ALLOW_REFRESH_TOKEN_AUTH("ALLOW_REFRESH_TOKEN_AUTH");

    private static final Map enumMap;
    private String value;

    static {
        ExplicitAuthFlowsType explicitAuthFlowsType = ADMIN_NO_SRP_AUTH;
        ExplicitAuthFlowsType explicitAuthFlowsType2 = CUSTOM_AUTH_FLOW_ONLY;
        ExplicitAuthFlowsType explicitAuthFlowsType3 = USER_PASSWORD_AUTH;
        ExplicitAuthFlowsType explicitAuthFlowsType4 = ALLOW_ADMIN_USER_PASSWORD_AUTH;
        ExplicitAuthFlowsType explicitAuthFlowsType5 = ALLOW_CUSTOM_AUTH;
        ExplicitAuthFlowsType explicitAuthFlowsType6 = ALLOW_USER_PASSWORD_AUTH;
        ExplicitAuthFlowsType explicitAuthFlowsType7 = ALLOW_USER_SRP_AUTH;
        ExplicitAuthFlowsType explicitAuthFlowsType8 = ALLOW_REFRESH_TOKEN_AUTH;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("ADMIN_NO_SRP_AUTH", explicitAuthFlowsType);
        map.put("CUSTOM_AUTH_FLOW_ONLY", explicitAuthFlowsType2);
        map.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD, explicitAuthFlowsType3);
        map.put("ALLOW_ADMIN_USER_PASSWORD_AUTH", explicitAuthFlowsType4);
        map.put("ALLOW_CUSTOM_AUTH", explicitAuthFlowsType5);
        map.put("ALLOW_USER_PASSWORD_AUTH", explicitAuthFlowsType6);
        map.put("ALLOW_USER_SRP_AUTH", explicitAuthFlowsType7);
        map.put("ALLOW_REFRESH_TOKEN_AUTH", explicitAuthFlowsType8);
    }

    ExplicitAuthFlowsType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ExplicitAuthFlowsType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ExplicitAuthFlowsType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
