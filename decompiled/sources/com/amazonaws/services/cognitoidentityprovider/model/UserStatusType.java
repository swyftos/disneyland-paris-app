package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum UserStatusType {
    UNCONFIRMED("UNCONFIRMED"),
    CONFIRMED("CONFIRMED"),
    ARCHIVED("ARCHIVED"),
    COMPROMISED("COMPROMISED"),
    RESET_REQUIRED("RESET_REQUIRED"),
    FORCE_CHANGE_PASSWORD("FORCE_CHANGE_PASSWORD");

    private static final Map enumMap;
    private String value;

    static {
        UserStatusType userStatusType = UNCONFIRMED;
        UserStatusType userStatusType2 = CONFIRMED;
        UserStatusType userStatusType3 = ARCHIVED;
        UserStatusType userStatusType4 = COMPROMISED;
        UserStatusType userStatusType5 = RESET_REQUIRED;
        UserStatusType userStatusType6 = FORCE_CHANGE_PASSWORD;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("UNCONFIRMED", userStatusType);
        map.put("CONFIRMED", userStatusType2);
        map.put("ARCHIVED", userStatusType3);
        map.put("COMPROMISED", userStatusType4);
        map.put("RESET_REQUIRED", userStatusType5);
        map.put("FORCE_CHANGE_PASSWORD", userStatusType6);
    }

    UserStatusType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static UserStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (UserStatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
