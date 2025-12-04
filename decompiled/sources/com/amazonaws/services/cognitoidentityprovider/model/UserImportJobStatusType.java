package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum UserImportJobStatusType {
    Created("Created"),
    Pending("Pending"),
    InProgress("InProgress"),
    Stopping("Stopping"),
    Expired("Expired"),
    Stopped("Stopped"),
    Failed("Failed"),
    Succeeded("Succeeded");

    private static final Map enumMap;
    private String value;

    static {
        UserImportJobStatusType userImportJobStatusType = Created;
        UserImportJobStatusType userImportJobStatusType2 = Pending;
        UserImportJobStatusType userImportJobStatusType3 = InProgress;
        UserImportJobStatusType userImportJobStatusType4 = Stopping;
        UserImportJobStatusType userImportJobStatusType5 = Expired;
        UserImportJobStatusType userImportJobStatusType6 = Stopped;
        UserImportJobStatusType userImportJobStatusType7 = Failed;
        UserImportJobStatusType userImportJobStatusType8 = Succeeded;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Created", userImportJobStatusType);
        map.put("Pending", userImportJobStatusType2);
        map.put("InProgress", userImportJobStatusType3);
        map.put("Stopping", userImportJobStatusType4);
        map.put("Expired", userImportJobStatusType5);
        map.put("Stopped", userImportJobStatusType6);
        map.put("Failed", userImportJobStatusType7);
        map.put("Succeeded", userImportJobStatusType8);
    }

    UserImportJobStatusType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static UserImportJobStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (UserImportJobStatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
