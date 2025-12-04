package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum AlgorithmSpec {
    RSAES_PKCS1_V1_5("RSAES_PKCS1_V1_5"),
    RSAES_OAEP_SHA_1("RSAES_OAEP_SHA_1"),
    RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256");

    private static final Map enumMap;
    private String value;

    static {
        AlgorithmSpec algorithmSpec = RSAES_PKCS1_V1_5;
        AlgorithmSpec algorithmSpec2 = RSAES_OAEP_SHA_1;
        AlgorithmSpec algorithmSpec3 = RSAES_OAEP_SHA_256;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("RSAES_PKCS1_V1_5", algorithmSpec);
        map.put("RSAES_OAEP_SHA_1", algorithmSpec2);
        map.put("RSAES_OAEP_SHA_256", algorithmSpec3);
    }

    AlgorithmSpec(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (AlgorithmSpec) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
