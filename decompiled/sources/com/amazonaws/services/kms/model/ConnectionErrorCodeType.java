package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum ConnectionErrorCodeType {
    INVALID_CREDENTIALS("INVALID_CREDENTIALS"),
    CLUSTER_NOT_FOUND("CLUSTER_NOT_FOUND"),
    NETWORK_ERRORS("NETWORK_ERRORS"),
    INTERNAL_ERROR("INTERNAL_ERROR"),
    INSUFFICIENT_CLOUDHSM_HSMS("INSUFFICIENT_CLOUDHSM_HSMS"),
    USER_LOCKED_OUT("USER_LOCKED_OUT"),
    USER_NOT_FOUND("USER_NOT_FOUND"),
    USER_LOGGED_IN("USER_LOGGED_IN"),
    SUBNET_NOT_FOUND("SUBNET_NOT_FOUND");

    private static final Map enumMap;
    private String value;

    static {
        ConnectionErrorCodeType connectionErrorCodeType = INVALID_CREDENTIALS;
        ConnectionErrorCodeType connectionErrorCodeType2 = CLUSTER_NOT_FOUND;
        ConnectionErrorCodeType connectionErrorCodeType3 = NETWORK_ERRORS;
        ConnectionErrorCodeType connectionErrorCodeType4 = INTERNAL_ERROR;
        ConnectionErrorCodeType connectionErrorCodeType5 = INSUFFICIENT_CLOUDHSM_HSMS;
        ConnectionErrorCodeType connectionErrorCodeType6 = USER_LOCKED_OUT;
        ConnectionErrorCodeType connectionErrorCodeType7 = USER_NOT_FOUND;
        ConnectionErrorCodeType connectionErrorCodeType8 = USER_LOGGED_IN;
        ConnectionErrorCodeType connectionErrorCodeType9 = SUBNET_NOT_FOUND;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("INVALID_CREDENTIALS", connectionErrorCodeType);
        map.put("CLUSTER_NOT_FOUND", connectionErrorCodeType2);
        map.put("NETWORK_ERRORS", connectionErrorCodeType3);
        map.put("INTERNAL_ERROR", connectionErrorCodeType4);
        map.put("INSUFFICIENT_CLOUDHSM_HSMS", connectionErrorCodeType5);
        map.put("USER_LOCKED_OUT", connectionErrorCodeType6);
        map.put("USER_NOT_FOUND", connectionErrorCodeType7);
        map.put("USER_LOGGED_IN", connectionErrorCodeType8);
        map.put("SUBNET_NOT_FOUND", connectionErrorCodeType9);
    }

    ConnectionErrorCodeType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ConnectionErrorCodeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ConnectionErrorCodeType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
