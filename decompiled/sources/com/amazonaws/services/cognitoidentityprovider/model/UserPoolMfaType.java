package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum UserPoolMfaType {
    OFF("OFF"),
    ON("ON"),
    OPTIONAL("OPTIONAL");

    private static final Map enumMap;
    private String value;

    static {
        UserPoolMfaType userPoolMfaType = OFF;
        UserPoolMfaType userPoolMfaType2 = ON;
        UserPoolMfaType userPoolMfaType3 = OPTIONAL;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("OFF", userPoolMfaType);
        map.put("ON", userPoolMfaType2);
        map.put("OPTIONAL", userPoolMfaType3);
    }

    UserPoolMfaType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static UserPoolMfaType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (UserPoolMfaType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
