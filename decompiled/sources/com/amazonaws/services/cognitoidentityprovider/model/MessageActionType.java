package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum MessageActionType {
    RESEND("RESEND"),
    SUPPRESS("SUPPRESS");

    private static final Map enumMap;
    private String value;

    static {
        MessageActionType messageActionType = RESEND;
        MessageActionType messageActionType2 = SUPPRESS;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("RESEND", messageActionType);
        map.put("SUPPRESS", messageActionType2);
    }

    MessageActionType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static MessageActionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (MessageActionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
