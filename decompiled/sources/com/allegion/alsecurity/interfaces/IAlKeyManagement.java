package com.allegion.alsecurity.interfaces;

import com.allegion.alsecurity.enums.AlKeyType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPublicKey;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J$\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u001d"}, d2 = {"Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "", "containsKeySecureReference", "", "keyReference", "", "decryptData", "", "data", "reference", "alKeyType", "encryptData", "exportPublicKeyX963Uncompressed", "key", "Ljava/security/interfaces/ECPublicKey;", "generateKey", "type", "Lcom/allegion/alsecurity/enums/AlKeyType;", "generateKeySecure", "requireAuth", "getKey", "Ljavax/crypto/SecretKey;", "getKeyPair", "Ljava/security/KeyPair;", "getKeyPairSecureReference", "getKeySecureReference", "removeKey", "storeKey", "storeKeyPair", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlKeyManagement {
    boolean containsKeySecureReference(@NotNull String keyReference) throws AlSecurityException;

    @NotNull
    byte[] decryptData(@NotNull byte[] data, @NotNull String reference) throws AlSecurityException;

    @NotNull
    byte[] decryptData(@Nullable byte[] data, @Nullable String reference, @NotNull String alKeyType) throws AlSecurityException;

    @NotNull
    byte[] encryptData(@NotNull byte[] data, @NotNull String reference) throws AlSecurityException;

    @NotNull
    byte[] encryptData(@Nullable byte[] data, @Nullable String reference, @NotNull String alKeyType) throws AlSecurityException;

    @NotNull
    byte[] exportPublicKeyX963Uncompressed(@NotNull ECPublicKey key) throws AlSecurityException;

    boolean generateKey(@NotNull AlKeyType type, @NotNull String keyReference) throws AlSecurityException;

    boolean generateKeySecure(@NotNull AlKeyType type, @NotNull String keyReference, boolean requireAuth) throws AlSecurityException;

    @Nullable
    SecretKey getKey(@NotNull String keyReference) throws AlSecurityException;

    @NotNull
    KeyPair getKeyPair(@NotNull String keyReference) throws AlSecurityException;

    @Nullable
    KeyPair getKeyPairSecureReference(@NotNull String keyReference) throws AlSecurityException;

    @Nullable
    SecretKey getKeySecureReference(@NotNull String keyReference) throws AlSecurityException;

    boolean removeKey(@NotNull String keyReference) throws AlSecurityException;

    boolean storeKey(@NotNull byte[] key, @NotNull String reference) throws AlSecurityException;

    boolean storeKeyPair(@NotNull KeyPair key, @NotNull String reference) throws AlSecurityException;
}
