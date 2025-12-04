package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum FeedbackValueType {
    Valid("Valid"),
    Invalid("Invalid");

    private static final Map enumMap;
    private String value;

    static {
        FeedbackValueType feedbackValueType = Valid;
        FeedbackValueType feedbackValueType2 = Invalid;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Valid", feedbackValueType);
        map.put("Invalid", feedbackValueType2);
    }

    FeedbackValueType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static FeedbackValueType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (FeedbackValueType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
