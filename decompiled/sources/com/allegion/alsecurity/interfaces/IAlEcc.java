package com.allegion.alsecurity.interfaces;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lcom/allegion/alsecurity/interfaces/IAlEcc;", "", "decrypt", "", "publicKey", "Ljava/security/PublicKey;", "privateKey", "Ljava/security/PrivateKey;", "data", "encodeEccPublicKey", "Ljava/security/interfaces/ECPublicKey;", "eccPublicKey", "encrypt", "sign", "key", "verify", "", AlCBORMessage.SIGNATURE, "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlEcc {
    @NotNull
    byte[] decrypt(@NotNull PublicKey publicKey, @NotNull PrivateKey privateKey, @NotNull byte[] data) throws AlSecurityException;

    @NotNull
    ECPublicKey encodeEccPublicKey(@NotNull byte[] eccPublicKey) throws AlSecurityException;

    @NotNull
    byte[] encrypt(@NotNull PublicKey publicKey, @NotNull PrivateKey privateKey, @NotNull byte[] data) throws AlSecurityException;

    @NotNull
    byte[] sign(@NotNull PrivateKey key, @NotNull byte[] data) throws AlSecurityException;

    boolean verify(@NotNull PublicKey key, @NotNull byte[] data, @NotNull byte[] signature) throws AlSecurityException;
}
