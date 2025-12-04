package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum DomainStatusType {
    CREATING("CREATING"),
    DELETING("DELETING"),
    UPDATING("UPDATING"),
    ACTIVE("ACTIVE"),
    FAILED("FAILED");

    private static final Map enumMap;
    private String value;

    static {
        DomainStatusType domainStatusType = CREATING;
        DomainStatusType domainStatusType2 = DELETING;
        DomainStatusType domainStatusType3 = UPDATING;
        DomainStatusType domainStatusType4 = ACTIVE;
        DomainStatusType domainStatusType5 = FAILED;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("CREATING", domainStatusType);
        map.put("DELETING", domainStatusType2);
        map.put("UPDATING", domainStatusType3);
        map.put("ACTIVE", domainStatusType4);
        map.put("FAILED", domainStatusType5);
    }

    DomainStatusType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static DomainStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DomainStatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
