package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import java.security.KeyStore;

/* loaded from: classes4.dex */
interface CryptoHandler {
    byte[] decrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr);

    byte[] encrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr);

    void generateKey(CryptoUtils.ICryptoFactory iCryptoFactory, String str, Context context);

    String getAlgorithm();
}
