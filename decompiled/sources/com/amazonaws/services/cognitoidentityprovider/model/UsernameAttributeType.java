package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum UsernameAttributeType {
    Phone_number("phone_number"),
    Email("email");

    private static final Map enumMap;
    private String value;

    static {
        UsernameAttributeType usernameAttributeType = Phone_number;
        UsernameAttributeType usernameAttributeType2 = Email;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("phone_number", usernameAttributeType);
        map.put("email", usernameAttributeType2);
    }

    UsernameAttributeType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static UsernameAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (UsernameAttributeType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
