package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateExpiredException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes4.dex */
public class CryptoUtils {
    static final ICryptoFactory DEFAULT_CRYPTO_FACTORY = new ICryptoFactory() { // from class: com.microsoft.appcenter.utils.crypto.CryptoUtils.1
        @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICryptoFactory
        public IKeyGenerator getKeyGenerator(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
            final KeyGenerator keyGenerator = KeyGenerator.getInstance(str, str2);
            return new IKeyGenerator() { // from class: com.microsoft.appcenter.utils.crypto.CryptoUtils.1.1
                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.IKeyGenerator
                public void init(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
                    keyGenerator.init(algorithmParameterSpec);
                }

                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.IKeyGenerator
                public void generateKey() {
                    keyGenerator.generateKey();
                }
            };
        }

        @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICryptoFactory
        public ICipher getCipher(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
            final Cipher cipher = Cipher.getInstance(str, str2);
            return new ICipher() { // from class: com.microsoft.appcenter.utils.crypto.CryptoUtils.1.2
                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICipher
                public void init(int i, Key key) throws InvalidKeyException {
                    cipher.init(i, key);
                }

                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICipher
                public void init(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
                    cipher.init(i, key, algorithmParameterSpec);
                }

                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICipher
                public byte[] doFinal(byte[] bArr) {
                    return cipher.doFinal(bArr);
                }

                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICipher
                public byte[] doFinal(byte[] bArr, int i, int i2) {
                    return cipher.doFinal(bArr, i, i2);
                }

                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICipher
                public byte[] getIV() {
                    return cipher.getIV();
                }

                @Override // com.microsoft.appcenter.utils.crypto.CryptoUtils.ICipher
                public int getBlockSize() {
                    return cipher.getBlockSize();
                }
            };
        }
    };
    private static CryptoUtils sInstance;
    private final int mApiLevel;
    private final Context mContext;
    private final ICryptoFactory mCryptoFactory;
    private final Map mCryptoHandlers;
    private final KeyStore mKeyStore;

    interface ICipher {
        byte[] doFinal(byte[] bArr);

        byte[] doFinal(byte[] bArr, int i, int i2);

        int getBlockSize();

        byte[] getIV();

        void init(int i, Key key);

        void init(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec);
    }

    interface ICryptoFactory {
        ICipher getCipher(String str, String str2);

        IKeyGenerator getKeyGenerator(String str, String str2);
    }

    interface IKeyGenerator {
        void generateKey();

        void init(AlgorithmParameterSpec algorithmParameterSpec);
    }

    private CryptoUtils(Context context) {
        this(context, DEFAULT_CRYPTO_FACTORY, Build.VERSION.SDK_INT);
    }

    CryptoUtils(Context context, ICryptoFactory iCryptoFactory, int i) {
        this.mCryptoHandlers = new LinkedHashMap();
        this.mContext = context.getApplicationContext();
        this.mCryptoFactory = iCryptoFactory;
        this.mApiLevel = i;
        KeyStore keyStore = null;
        if (i >= 19) {
            try {
                KeyStore keyStore2 = KeyStore.getInstance("AndroidKeyStore");
                try {
                    keyStore2.load(null);
                    keyStore = keyStore2;
                } catch (Exception unused) {
                    keyStore = keyStore2;
                    AppCenterLog.error("AppCenter", "Cannot use secure keystore on this device.");
                }
            } catch (Exception unused2) {
            }
        }
        this.mKeyStore = keyStore;
        if (keyStore != null && i >= 23) {
            try {
                registerHandler(new CryptoAesHandler());
            } catch (Exception unused3) {
                AppCenterLog.error("AppCenter", "Cannot use modern encryption on this device.");
            }
        }
        if (keyStore != null) {
            try {
                registerHandler(new CryptoRsaHandler());
            } catch (Exception unused4) {
                AppCenterLog.error("AppCenter", "Cannot use old encryption on this device.");
            }
        }
        CryptoNoOpHandler cryptoNoOpHandler = new CryptoNoOpHandler();
        this.mCryptoHandlers.put(cryptoNoOpHandler.getAlgorithm(), new CryptoHandlerEntry(0, cryptoNoOpHandler));
    }

    public static CryptoUtils getInstance(@NonNull Context context) {
        if (sInstance == null) {
            sInstance = new CryptoUtils(context);
        }
        return sInstance;
    }

    private void registerHandler(CryptoHandler cryptoHandler) throws KeyStoreException {
        int i = 0;
        String alias = getAlias(cryptoHandler, 0);
        String alias2 = getAlias(cryptoHandler, 1);
        Date creationDate = this.mKeyStore.getCreationDate(alias);
        Date creationDate2 = this.mKeyStore.getCreationDate(alias2);
        if (creationDate2 != null && creationDate2.after(creationDate)) {
            i = 1;
            alias = alias2;
        }
        if (this.mCryptoHandlers.isEmpty() && !this.mKeyStore.containsAlias(alias)) {
            AppCenterLog.debug("AppCenter", "Creating alias: " + alias);
            cryptoHandler.generateKey(this.mCryptoFactory, alias, this.mContext);
        }
        AppCenterLog.debug("AppCenter", "Using " + alias);
        this.mCryptoHandlers.put(cryptoHandler.getAlgorithm(), new CryptoHandlerEntry(i, cryptoHandler));
    }

    private String getAlias(CryptoHandler cryptoHandler, int i) {
        return "appcenter." + i + InstructionFileId.DOT + cryptoHandler.getAlgorithm();
    }

    private KeyStore.Entry getKeyStoreEntry(CryptoHandlerEntry cryptoHandlerEntry) {
        return getKeyStoreEntry(cryptoHandlerEntry.mCryptoHandler, cryptoHandlerEntry.mAliasIndex);
    }

    private KeyStore.Entry getKeyStoreEntry(CryptoHandler cryptoHandler, int i) {
        if (this.mKeyStore == null) {
            return null;
        }
        return this.mKeyStore.getEntry(getAlias(cryptoHandler, i), null);
    }

    @Nullable
    public String encrypt(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            CryptoHandlerEntry cryptoHandlerEntry = (CryptoHandlerEntry) this.mCryptoHandlers.values().iterator().next();
            CryptoHandler cryptoHandler = cryptoHandlerEntry.mCryptoHandler;
            try {
                return cryptoHandler.getAlgorithm() + ":" + Base64.encodeToString(cryptoHandler.encrypt(this.mCryptoFactory, this.mApiLevel, getKeyStoreEntry(cryptoHandlerEntry), str.getBytes("UTF-8")), 0);
            } catch (InvalidKeyException e) {
                if (!(e.getCause() instanceof CertificateExpiredException) && !"android.security.keystore.KeyExpiredException".equals(e.getClass().getName())) {
                    throw e;
                }
                AppCenterLog.debug("AppCenter", "Alias expired: " + cryptoHandlerEntry.mAliasIndex);
                int i = cryptoHandlerEntry.mAliasIndex ^ 1;
                cryptoHandlerEntry.mAliasIndex = i;
                String alias = getAlias(cryptoHandler, i);
                if (this.mKeyStore.containsAlias(alias)) {
                    AppCenterLog.debug("AppCenter", "Deleting alias: " + alias);
                    this.mKeyStore.deleteEntry(alias);
                }
                AppCenterLog.debug("AppCenter", "Creating alias: " + alias);
                cryptoHandler.generateKey(this.mCryptoFactory, alias, this.mContext);
                return encrypt(str);
            }
        } catch (Exception unused) {
            AppCenterLog.error("AppCenter", "Failed to encrypt data.");
            return str;
        }
    }

    @NonNull
    public DecryptedData decrypt(@Nullable String str) {
        if (str == null) {
            return new DecryptedData(null, null);
        }
        String[] strArrSplit = str.split(":");
        CryptoHandlerEntry cryptoHandlerEntry = strArrSplit.length == 2 ? (CryptoHandlerEntry) this.mCryptoHandlers.get(strArrSplit[0]) : null;
        CryptoHandler cryptoHandler = cryptoHandlerEntry == null ? null : cryptoHandlerEntry.mCryptoHandler;
        if (cryptoHandler == null) {
            AppCenterLog.error("AppCenter", "Failed to decrypt data.");
            return new DecryptedData(str, null);
        }
        try {
            try {
                return getDecryptedData(cryptoHandler, cryptoHandlerEntry.mAliasIndex, strArrSplit[1]);
            } catch (Exception unused) {
                AppCenterLog.error("AppCenter", "Failed to decrypt data.");
                return new DecryptedData(str, null);
            }
        } catch (Exception unused2) {
            return getDecryptedData(cryptoHandler, cryptoHandlerEntry.mAliasIndex ^ 1, strArrSplit[1]);
        }
    }

    private DecryptedData getDecryptedData(CryptoHandler cryptoHandler, int i, String str) {
        String str2 = new String(cryptoHandler.decrypt(this.mCryptoFactory, this.mApiLevel, getKeyStoreEntry(cryptoHandler, i), Base64.decode(str, 0)), "UTF-8");
        return new DecryptedData(str2, cryptoHandler != ((CryptoHandlerEntry) this.mCryptoHandlers.values().iterator().next()).mCryptoHandler ? encrypt(str2) : null);
    }

    static class CryptoHandlerEntry {
        int mAliasIndex;
        final CryptoHandler mCryptoHandler;

        CryptoHandlerEntry(int i, CryptoHandler cryptoHandler) {
            this.mAliasIndex = i;
            this.mCryptoHandler = cryptoHandler;
        }
    }

    public static class DecryptedData {
        final String mDecryptedData;
        final String mNewEncryptedData;

        @VisibleForTesting
        public DecryptedData(String str, String str2) {
            this.mDecryptedData = str;
            this.mNewEncryptedData = str2;
        }

        public String getDecryptedData() {
            return this.mDecryptedData;
        }

        public String getNewEncryptedData() {
            return this.mNewEncryptedData;
        }
    }
}
