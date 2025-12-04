package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum GrantOperation {
    Decrypt("Decrypt"),
    Encrypt("Encrypt"),
    GenerateDataKey("GenerateDataKey"),
    GenerateDataKeyWithoutPlaintext("GenerateDataKeyWithoutPlaintext"),
    ReEncryptFrom("ReEncryptFrom"),
    ReEncryptTo("ReEncryptTo"),
    Sign("Sign"),
    Verify("Verify"),
    GetPublicKey("GetPublicKey"),
    CreateGrant("CreateGrant"),
    RetireGrant("RetireGrant"),
    DescribeKey("DescribeKey"),
    GenerateDataKeyPair("GenerateDataKeyPair"),
    GenerateDataKeyPairWithoutPlaintext("GenerateDataKeyPairWithoutPlaintext");

    private static final Map enumMap;
    private String value;

    static {
        GrantOperation grantOperation = Decrypt;
        GrantOperation grantOperation2 = Encrypt;
        GrantOperation grantOperation3 = GenerateDataKey;
        GrantOperation grantOperation4 = GenerateDataKeyWithoutPlaintext;
        GrantOperation grantOperation5 = ReEncryptFrom;
        GrantOperation grantOperation6 = ReEncryptTo;
        GrantOperation grantOperation7 = Sign;
        GrantOperation grantOperation8 = Verify;
        GrantOperation grantOperation9 = GetPublicKey;
        GrantOperation grantOperation10 = CreateGrant;
        GrantOperation grantOperation11 = RetireGrant;
        GrantOperation grantOperation12 = DescribeKey;
        GrantOperation grantOperation13 = GenerateDataKeyPair;
        GrantOperation grantOperation14 = GenerateDataKeyPairWithoutPlaintext;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Decrypt", grantOperation);
        map.put("Encrypt", grantOperation2);
        map.put("GenerateDataKey", grantOperation3);
        map.put("GenerateDataKeyWithoutPlaintext", grantOperation4);
        map.put("ReEncryptFrom", grantOperation5);
        map.put("ReEncryptTo", grantOperation6);
        map.put("Sign", grantOperation7);
        map.put("Verify", grantOperation8);
        map.put("GetPublicKey", grantOperation9);
        map.put("CreateGrant", grantOperation10);
        map.put("RetireGrant", grantOperation11);
        map.put("DescribeKey", grantOperation12);
        map.put("GenerateDataKeyPair", grantOperation13);
        map.put("GenerateDataKeyPairWithoutPlaintext", grantOperation14);
    }

    GrantOperation(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static GrantOperation fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (GrantOperation) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
