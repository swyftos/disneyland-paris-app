package com.allegion.alsecurity.enums;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/allegion/alsecurity/enums/AlKeyType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AES_CBC_256_NO_PADDING", "AES_CBC_256_PKCS7_PADDING", "ECC_ECDSA_SPEC256R1", "ECC_ECDH_SPEC256R1", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum AlKeyType {
    AES_CBC_256_NO_PADDING("AES/CBC/NoPadding"),
    AES_CBC_256_PKCS7_PADDING("AES/CBC/PKCS7Padding"),
    ECC_ECDSA_SPEC256R1("secp256r1"),
    ECC_ECDH_SPEC256R1("secp256r1");


    @NotNull
    private final String value;

    AlKeyType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
