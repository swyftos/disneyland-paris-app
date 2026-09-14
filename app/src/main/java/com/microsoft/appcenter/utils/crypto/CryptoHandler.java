package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes4.dex */
interface CryptoHandler {
    byte[] decrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr);

    byte[] encrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr);

    void generateKey(CryptoUtils.ICryptoFactory iCryptoFactory, String str, Context context);

    String getAlgorithm();
}
