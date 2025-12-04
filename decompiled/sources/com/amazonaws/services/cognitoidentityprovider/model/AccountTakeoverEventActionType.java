package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum AccountTakeoverEventActionType {
    BLOCK("BLOCK"),
    MFA_IF_CONFIGURED("MFA_IF_CONFIGURED"),
    MFA_REQUIRED("MFA_REQUIRED"),
    NO_ACTION("NO_ACTION");

    private static final Map enumMap;
    private String value;

    static {
        AccountTakeoverEventActionType accountTakeoverEventActionType = BLOCK;
        AccountTakeoverEventActionType accountTakeoverEventActionType2 = MFA_IF_CONFIGURED;
        AccountTakeoverEventActionType accountTakeoverEventActionType3 = MFA_REQUIRED;
        AccountTakeoverEventActionType accountTakeoverEventActionType4 = NO_ACTION;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("BLOCK", accountTakeoverEventActionType);
        map.put("MFA_IF_CONFIGURED", accountTakeoverEventActionType2);
        map.put("MFA_REQUIRED", accountTakeoverEventActionType3);
        map.put("NO_ACTION", accountTakeoverEventActionType4);
    }

    AccountTakeoverEventActionType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AccountTakeoverEventActionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (AccountTakeoverEventActionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
