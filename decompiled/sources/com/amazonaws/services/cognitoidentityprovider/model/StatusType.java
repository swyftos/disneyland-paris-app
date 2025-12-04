package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum StatusType {
    Enabled("Enabled"),
    Disabled(BucketLifecycleConfiguration.DISABLED);

    private static final Map enumMap;
    private String value;

    static {
        StatusType statusType = Enabled;
        StatusType statusType2 = Disabled;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Enabled", statusType);
        map.put(BucketLifecycleConfiguration.DISABLED, statusType2);
    }

    StatusType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static StatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (StatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
