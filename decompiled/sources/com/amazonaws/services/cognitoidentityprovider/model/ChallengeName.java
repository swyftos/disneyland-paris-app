package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum ChallengeName {
    Password("Password"),
    Mfa("Mfa");

    private static final Map enumMap;
    private String value;

    static {
        ChallengeName challengeName = Password;
        ChallengeName challengeName2 = Mfa;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Password", challengeName);
        map.put("Mfa", challengeName2);
    }

    ChallengeName(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ChallengeName fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ChallengeName) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
