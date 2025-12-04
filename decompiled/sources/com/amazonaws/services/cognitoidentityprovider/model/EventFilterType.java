package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum EventFilterType {
    SIGN_IN("SIGN_IN"),
    PASSWORD_CHANGE("PASSWORD_CHANGE"),
    SIGN_UP("SIGN_UP");

    private static final Map enumMap;
    private String value;

    static {
        EventFilterType eventFilterType = SIGN_IN;
        EventFilterType eventFilterType2 = PASSWORD_CHANGE;
        EventFilterType eventFilterType3 = SIGN_UP;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("SIGN_IN", eventFilterType);
        map.put("PASSWORD_CHANGE", eventFilterType2);
        map.put("SIGN_UP", eventFilterType3);
    }

    EventFilterType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EventFilterType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (EventFilterType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
