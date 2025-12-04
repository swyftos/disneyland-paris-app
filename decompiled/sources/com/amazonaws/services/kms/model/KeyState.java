package com.amazonaws.services.kms.model;

import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum KeyState {
    Enabled("Enabled"),
    Disabled(BucketLifecycleConfiguration.DISABLED),
    PendingDeletion("PendingDeletion"),
    PendingImport("PendingImport"),
    Unavailable("Unavailable");

    private static final Map enumMap;
    private String value;

    static {
        KeyState keyState = Enabled;
        KeyState keyState2 = Disabled;
        KeyState keyState3 = PendingDeletion;
        KeyState keyState4 = PendingImport;
        KeyState keyState5 = Unavailable;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Enabled", keyState);
        map.put(BucketLifecycleConfiguration.DISABLED, keyState2);
        map.put("PendingDeletion", keyState3);
        map.put("PendingImport", keyState4);
        map.put("Unavailable", keyState5);
    }

    KeyState(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static KeyState fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (KeyState) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
