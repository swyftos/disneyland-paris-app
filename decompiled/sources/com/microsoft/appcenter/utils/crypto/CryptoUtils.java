package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.amazonaws.services.s3.model.InstructionFileId;
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
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes4.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    CryptoUtils(android.content.Context r2, com.microsoft.appcenter.utils.crypto.CryptoUtils.ICryptoFactory r3, int r4) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyStoreException, java.security.cert.CertificateException {
        /*
            r1 = this;
            r1.<init>()
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r1.mCryptoHandlers = r0
            android.content.Context r2 = r2.getApplicationContext()
            r1.mContext = r2
            r1.mCryptoFactory = r3
            r1.mApiLevel = r4
            r2 = 19
            java.lang.String r3 = "AppCenter"
            r0 = 0
            if (r4 < r2) goto L2c
            java.lang.String r2 = "AndroidKeyStore"
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r2)     // Catch: java.lang.Exception -> L27
            r2.load(r0)     // Catch: java.lang.Exception -> L26
            r0 = r2
            goto L2c
        L26:
            r0 = r2
        L27:
            java.lang.String r2 = "Cannot use secure keystore on this device."
            com.microsoft.appcenter.utils.AppCenterLog.error(r3, r2)
        L2c:
            r1.mKeyStore = r0
            if (r0 == 0) goto L42
            r2 = 23
            if (r4 < r2) goto L42
            com.microsoft.appcenter.utils.crypto.CryptoAesHandler r2 = new com.microsoft.appcenter.utils.crypto.CryptoAesHandler     // Catch: java.lang.Exception -> L3d
            r2.<init>()     // Catch: java.lang.Exception -> L3d
            r1.registerHandler(r2)     // Catch: java.lang.Exception -> L3d
            goto L42
        L3d:
            java.lang.String r2 = "Cannot use modern encryption on this device."
            com.microsoft.appcenter.utils.AppCenterLog.error(r3, r2)
        L42:
            if (r0 == 0) goto L52
            com.microsoft.appcenter.utils.crypto.CryptoRsaHandler r2 = new com.microsoft.appcenter.utils.crypto.CryptoRsaHandler     // Catch: java.lang.Exception -> L4d
            r2.<init>()     // Catch: java.lang.Exception -> L4d
            r1.registerHandler(r2)     // Catch: java.lang.Exception -> L4d
            goto L52
        L4d:
            java.lang.String r2 = "Cannot use old encryption on this device."
            com.microsoft.appcenter.utils.AppCenterLog.error(r3, r2)
        L52:
            com.microsoft.appcenter.utils.crypto.CryptoNoOpHandler r2 = new com.microsoft.appcenter.utils.crypto.CryptoNoOpHandler
            r2.<init>()
            java.util.Map r1 = r1.mCryptoHandlers
            java.lang.String r3 = r2.getAlgorithm()
            com.microsoft.appcenter.utils.crypto.CryptoUtils$CryptoHandlerEntry r4 = new com.microsoft.appcenter.utils.crypto.CryptoUtils$CryptoHandlerEntry
            r0 = 0
            r4.<init>(r0, r2)
            r1.put(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.crypto.CryptoUtils.<init>(android.content.Context, com.microsoft.appcenter.utils.crypto.CryptoUtils$ICryptoFactory, int):void");
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
    public String encrypt(@Nullable String str) throws InvalidKeyException, KeyStoreException {
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
                String alias = this.getAlias(cryptoHandler, i);
                if (this.mKeyStore.containsAlias(alias)) {
                    AppCenterLog.debug("AppCenter", "Deleting alias: " + alias);
                    this.mKeyStore.deleteEntry(alias);
                }
                AppCenterLog.debug("AppCenter", "Creating alias: " + alias);
                cryptoHandler.generateKey(this.mCryptoFactory, alias, this.mContext);
                return this.encrypt(str);
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
            return this.getDecryptedData(cryptoHandler, cryptoHandlerEntry.mAliasIndex ^ 1, strArrSplit[1]);
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
