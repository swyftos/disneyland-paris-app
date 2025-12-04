package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum CustomerMasterKeySpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    ECC_NIST_P256("ECC_NIST_P256"),
    ECC_NIST_P384("ECC_NIST_P384"),
    ECC_NIST_P521("ECC_NIST_P521"),
    ECC_SECG_P256K1("ECC_SECG_P256K1"),
    SYMMETRIC_DEFAULT("SYMMETRIC_DEFAULT");

    private static final Map enumMap;
    private String value;

    static {
        CustomerMasterKeySpec customerMasterKeySpec = RSA_2048;
        CustomerMasterKeySpec customerMasterKeySpec2 = RSA_3072;
        CustomerMasterKeySpec customerMasterKeySpec3 = RSA_4096;
        CustomerMasterKeySpec customerMasterKeySpec4 = ECC_NIST_P256;
        CustomerMasterKeySpec customerMasterKeySpec5 = ECC_NIST_P384;
        CustomerMasterKeySpec customerMasterKeySpec6 = ECC_NIST_P521;
        CustomerMasterKeySpec customerMasterKeySpec7 = ECC_SECG_P256K1;
        CustomerMasterKeySpec customerMasterKeySpec8 = SYMMETRIC_DEFAULT;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("RSA_2048", customerMasterKeySpec);
        map.put("RSA_3072", customerMasterKeySpec2);
        map.put("RSA_4096", customerMasterKeySpec3);
        map.put("ECC_NIST_P256", customerMasterKeySpec4);
        map.put("ECC_NIST_P384", customerMasterKeySpec5);
        map.put("ECC_NIST_P521", customerMasterKeySpec6);
        map.put("ECC_SECG_P256K1", customerMasterKeySpec7);
        map.put("SYMMETRIC_DEFAULT", customerMasterKeySpec8);
    }

    CustomerMasterKeySpec(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static CustomerMasterKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (CustomerMasterKeySpec) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
