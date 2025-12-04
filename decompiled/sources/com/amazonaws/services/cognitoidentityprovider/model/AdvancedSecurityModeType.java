package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum AdvancedSecurityModeType {
    OFF("OFF"),
    AUDIT("AUDIT"),
    ENFORCED("ENFORCED");

    private static final Map enumMap;
    private String value;

    static {
        AdvancedSecurityModeType advancedSecurityModeType = OFF;
        AdvancedSecurityModeType advancedSecurityModeType2 = AUDIT;
        AdvancedSecurityModeType advancedSecurityModeType3 = ENFORCED;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("OFF", advancedSecurityModeType);
        map.put("AUDIT", advancedSecurityModeType2);
        map.put("ENFORCED", advancedSecurityModeType3);
    }

    AdvancedSecurityModeType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AdvancedSecurityModeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (AdvancedSecurityModeType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
