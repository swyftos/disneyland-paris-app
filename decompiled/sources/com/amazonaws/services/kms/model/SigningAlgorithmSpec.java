package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum SigningAlgorithmSpec {
    RSASSA_PSS_SHA_256("RSASSA_PSS_SHA_256"),
    RSASSA_PSS_SHA_384("RSASSA_PSS_SHA_384"),
    RSASSA_PSS_SHA_512("RSASSA_PSS_SHA_512"),
    RSASSA_PKCS1_V1_5_SHA_256("RSASSA_PKCS1_V1_5_SHA_256"),
    RSASSA_PKCS1_V1_5_SHA_384("RSASSA_PKCS1_V1_5_SHA_384"),
    RSASSA_PKCS1_V1_5_SHA_512("RSASSA_PKCS1_V1_5_SHA_512"),
    ECDSA_SHA_256("ECDSA_SHA_256"),
    ECDSA_SHA_384("ECDSA_SHA_384"),
    ECDSA_SHA_512("ECDSA_SHA_512");

    private static final Map enumMap;
    private String value;

    static {
        SigningAlgorithmSpec signingAlgorithmSpec = RSASSA_PSS_SHA_256;
        SigningAlgorithmSpec signingAlgorithmSpec2 = RSASSA_PSS_SHA_384;
        SigningAlgorithmSpec signingAlgorithmSpec3 = RSASSA_PSS_SHA_512;
        SigningAlgorithmSpec signingAlgorithmSpec4 = RSASSA_PKCS1_V1_5_SHA_256;
        SigningAlgorithmSpec signingAlgorithmSpec5 = RSASSA_PKCS1_V1_5_SHA_384;
        SigningAlgorithmSpec signingAlgorithmSpec6 = RSASSA_PKCS1_V1_5_SHA_512;
        SigningAlgorithmSpec signingAlgorithmSpec7 = ECDSA_SHA_256;
        SigningAlgorithmSpec signingAlgorithmSpec8 = ECDSA_SHA_384;
        SigningAlgorithmSpec signingAlgorithmSpec9 = ECDSA_SHA_512;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("RSASSA_PSS_SHA_256", signingAlgorithmSpec);
        map.put("RSASSA_PSS_SHA_384", signingAlgorithmSpec2);
        map.put("RSASSA_PSS_SHA_512", signingAlgorithmSpec3);
        map.put("RSASSA_PKCS1_V1_5_SHA_256", signingAlgorithmSpec4);
        map.put("RSASSA_PKCS1_V1_5_SHA_384", signingAlgorithmSpec5);
        map.put("RSASSA_PKCS1_V1_5_SHA_512", signingAlgorithmSpec6);
        map.put("ECDSA_SHA_256", signingAlgorithmSpec7);
        map.put("ECDSA_SHA_384", signingAlgorithmSpec8);
        map.put("ECDSA_SHA_512", signingAlgorithmSpec9);
    }

    SigningAlgorithmSpec(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static SigningAlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (SigningAlgorithmSpec) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
