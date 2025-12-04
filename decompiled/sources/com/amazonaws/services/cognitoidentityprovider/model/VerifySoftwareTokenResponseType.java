package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum VerifySoftwareTokenResponseType {
    SUCCESS("SUCCESS"),
    ERROR("ERROR");

    private static final Map enumMap;
    private String value;

    static {
        VerifySoftwareTokenResponseType verifySoftwareTokenResponseType = SUCCESS;
        VerifySoftwareTokenResponseType verifySoftwareTokenResponseType2 = ERROR;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("SUCCESS", verifySoftwareTokenResponseType);
        map.put("ERROR", verifySoftwareTokenResponseType2);
    }

    VerifySoftwareTokenResponseType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static VerifySoftwareTokenResponseType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (VerifySoftwareTokenResponseType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
