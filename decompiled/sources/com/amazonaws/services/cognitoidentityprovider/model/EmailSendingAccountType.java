package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum EmailSendingAccountType {
    COGNITO_DEFAULT("COGNITO_DEFAULT"),
    DEVELOPER("DEVELOPER");

    private static final Map enumMap;
    private String value;

    static {
        EmailSendingAccountType emailSendingAccountType = COGNITO_DEFAULT;
        EmailSendingAccountType emailSendingAccountType2 = DEVELOPER;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("COGNITO_DEFAULT", emailSendingAccountType);
        map.put("DEVELOPER", emailSendingAccountType2);
    }

    EmailSendingAccountType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EmailSendingAccountType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (EmailSendingAccountType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
