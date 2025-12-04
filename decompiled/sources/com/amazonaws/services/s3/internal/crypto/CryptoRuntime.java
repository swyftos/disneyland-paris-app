package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@Deprecated
/* loaded from: classes2.dex */
public class CryptoRuntime {
    private static final Log LOGGER = LogFactory.getLog(CryptoRuntime.class);

    public static synchronized boolean isBouncyCastleAvailable() {
        return Security.getProvider("BC") != null;
    }

    public static synchronized void enableBouncyCastle() {
        if (isBouncyCastleAvailable()) {
            return;
        }
        try {
            String str = BouncyCastleProvider.PROVIDER_NAME;
            Security.addProvider((Provider) BouncyCastleProvider.class.newInstance());
        } catch (Exception e) {
            LOGGER.debug("Bouncy Castle not available", e);
        }
    }

    public static boolean isAesGcmAvailable(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return AesGcm.check(provider);
    }

    static boolean isRsaKeyWrapAvailable(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return RsaEcbOaepWithSHA256AndMGF1Padding.check(provider);
    }

    private static final class AesGcm {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean check(Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException {
            try {
                Cipher.getInstance(ContentCryptoScheme.AES_GCM.getCipherAlgorithm(), provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private static final class RsaEcbOaepWithSHA256AndMGF1Padding {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean check(Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException {
            try {
                Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
