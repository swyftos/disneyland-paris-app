package com.disney.id.android.crypto;

import java.security.GeneralSecurityException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/disney/id/android/crypto/Crypto;", "", "decrypt", "", "cipherBytes", "encrypt", "plainBytes", "isAvailable", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Crypto {
    @Nullable
    byte[] decrypt(@NotNull byte[] cipherBytes) throws GeneralSecurityException;

    @Nullable
    byte[] encrypt(@NotNull byte[] plainBytes) throws GeneralSecurityException;

    boolean isAvailable();
}
