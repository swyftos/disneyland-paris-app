package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum DataKeyPairSpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    ECC_NIST_P256("ECC_NIST_P256"),
    ECC_NIST_P384("ECC_NIST_P384"),
    ECC_NIST_P521("ECC_NIST_P521"),
    ECC_SECG_P256K1("ECC_SECG_P256K1");

    private static final Map enumMap;
    private String value;

    static {
        DataKeyPairSpec dataKeyPairSpec = RSA_2048;
        DataKeyPairSpec dataKeyPairSpec2 = RSA_3072;
        DataKeyPairSpec dataKeyPairSpec3 = RSA_4096;
        DataKeyPairSpec dataKeyPairSpec4 = ECC_NIST_P256;
        DataKeyPairSpec dataKeyPairSpec5 = ECC_NIST_P384;
        DataKeyPairSpec dataKeyPairSpec6 = ECC_NIST_P521;
        DataKeyPairSpec dataKeyPairSpec7 = ECC_SECG_P256K1;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("RSA_2048", dataKeyPairSpec);
        map.put("RSA_3072", dataKeyPairSpec2);
        map.put("RSA_4096", dataKeyPairSpec3);
        map.put("ECC_NIST_P256", dataKeyPairSpec4);
        map.put("ECC_NIST_P384", dataKeyPairSpec5);
        map.put("ECC_NIST_P521", dataKeyPairSpec6);
        map.put("ECC_SECG_P256K1", dataKeyPairSpec7);
    }

    DataKeyPairSpec(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static DataKeyPairSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DataKeyPairSpec) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
