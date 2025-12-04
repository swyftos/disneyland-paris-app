package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum AliasAttributeType {
    Phone_number("phone_number"),
    Email("email"),
    Preferred_username("preferred_username");

    private static final Map enumMap;
    private String value;

    static {
        AliasAttributeType aliasAttributeType = Phone_number;
        AliasAttributeType aliasAttributeType2 = Email;
        AliasAttributeType aliasAttributeType3 = Preferred_username;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("phone_number", aliasAttributeType);
        map.put("email", aliasAttributeType2);
        map.put("preferred_username", aliasAttributeType3);
    }

    AliasAttributeType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AliasAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (AliasAttributeType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
