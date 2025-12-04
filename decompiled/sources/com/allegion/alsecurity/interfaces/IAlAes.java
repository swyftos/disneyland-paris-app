package com.allegion.alsecurity.interfaces;

import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&J*\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/allegion/alsecurity/interfaces/IAlAes;", "", "decrypt", "", "key", "Ljavax/crypto/SecretKey;", "data", "paddingType", "Lcom/allegion/alsecurity/enums/AlPaddingType;", "iv", "encrypt", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlAes {
    @NotNull
    byte[] decrypt(@NotNull SecretKey key, @NotNull byte[] data, @NotNull AlPaddingType paddingType, @Nullable byte[] iv) throws AlSecurityException;

    @NotNull
    byte[] encrypt(@NotNull SecretKey key, @NotNull byte[] data, @NotNull AlPaddingType paddingType, @Nullable byte[] iv) throws AlSecurityException;
}
