package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum MessageType {
    RAW("RAW"),
    DIGEST("DIGEST");

    private static final Map enumMap;
    private String value;

    static {
        MessageType messageType = RAW;
        MessageType messageType2 = DIGEST;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("RAW", messageType);
        map.put("DIGEST", messageType2);
    }

    MessageType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static MessageType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (MessageType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
