package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum OAuthFlowType {
    Code("code"),
    Implicit("implicit"),
    Client_credentials("client_credentials");

    private static final Map enumMap;
    private String value;

    static {
        OAuthFlowType oAuthFlowType = Code;
        OAuthFlowType oAuthFlowType2 = Implicit;
        OAuthFlowType oAuthFlowType3 = Client_credentials;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("code", oAuthFlowType);
        map.put("implicit", oAuthFlowType2);
        map.put("client_credentials", oAuthFlowType3);
    }

    OAuthFlowType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static OAuthFlowType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (OAuthFlowType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
