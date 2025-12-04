package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum EventType {
    SignIn("SignIn"),
    SignUp("SignUp"),
    ForgotPassword("ForgotPassword");

    private static final Map enumMap;
    private String value;

    static {
        EventType eventType = SignIn;
        EventType eventType2 = SignUp;
        EventType eventType3 = ForgotPassword;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("SignIn", eventType);
        map.put("SignUp", eventType2);
        map.put("ForgotPassword", eventType3);
    }

    EventType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EventType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (EventType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
