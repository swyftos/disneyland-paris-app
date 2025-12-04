package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum DefaultEmailOptionType {
    CONFIRM_WITH_LINK("CONFIRM_WITH_LINK"),
    CONFIRM_WITH_CODE("CONFIRM_WITH_CODE");

    private static final Map enumMap;
    private String value;

    static {
        DefaultEmailOptionType defaultEmailOptionType = CONFIRM_WITH_LINK;
        DefaultEmailOptionType defaultEmailOptionType2 = CONFIRM_WITH_CODE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("CONFIRM_WITH_LINK", defaultEmailOptionType);
        map.put("CONFIRM_WITH_CODE", defaultEmailOptionType2);
    }

    DefaultEmailOptionType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static DefaultEmailOptionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DefaultEmailOptionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
