package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum EventResponseType {
    Success("Success"),
    Failure("Failure");

    private static final Map enumMap;
    private String value;

    static {
        EventResponseType eventResponseType = Success;
        EventResponseType eventResponseType2 = Failure;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Success", eventResponseType);
        map.put("Failure", eventResponseType2);
    }

    EventResponseType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EventResponseType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (EventResponseType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
