package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum DeviceRememberedStatusType {
    Remembered("remembered"),
    Not_remembered("not_remembered");

    private static final Map enumMap;
    private String value;

    static {
        DeviceRememberedStatusType deviceRememberedStatusType = Remembered;
        DeviceRememberedStatusType deviceRememberedStatusType2 = Not_remembered;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("remembered", deviceRememberedStatusType);
        map.put("not_remembered", deviceRememberedStatusType2);
    }

    DeviceRememberedStatusType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static DeviceRememberedStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DeviceRememberedStatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
