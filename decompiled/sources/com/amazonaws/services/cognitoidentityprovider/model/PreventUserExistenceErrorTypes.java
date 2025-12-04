package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum PreventUserExistenceErrorTypes {
    LEGACY("LEGACY"),
    ENABLED("ENABLED");

    private static final Map enumMap;
    private String value;

    static {
        PreventUserExistenceErrorTypes preventUserExistenceErrorTypes = LEGACY;
        PreventUserExistenceErrorTypes preventUserExistenceErrorTypes2 = ENABLED;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("LEGACY", preventUserExistenceErrorTypes);
        map.put("ENABLED", preventUserExistenceErrorTypes2);
    }

    PreventUserExistenceErrorTypes(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static PreventUserExistenceErrorTypes fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (PreventUserExistenceErrorTypes) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
