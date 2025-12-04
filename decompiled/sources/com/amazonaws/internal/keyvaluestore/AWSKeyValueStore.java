package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes2.dex */
public class AWSKeyValueStore {
    private Map cache;
    Context context;
    private boolean isPersistenceEnabled;
    KeyProvider keyProvider;
    private SecureRandom secureRandom = new SecureRandom();
    SharedPreferences sharedPreferencesForData;
    SharedPreferences sharedPreferencesForEncryptionMaterials;
    private final String sharedPreferencesName;
    private static final Log logger = LogFactory.getLog(AWSKeyValueStore.class);
    static Map cacheFactory = new HashMap();

    private static Map getCacheForKey(String str) {
        if (cacheFactory.containsKey(str)) {
            return (Map) cacheFactory.get(str);
        }
        HashMap map = new HashMap();
        cacheFactory.put(str, map);
        return map;
    }

    public AWSKeyValueStore(Context context, String str, boolean z) {
        this.cache = getCacheForKey(str);
        this.sharedPreferencesName = str;
        this.context = context;
        setPersistenceEnabled(z);
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        try {
            try {
                boolean z2 = this.isPersistenceEnabled;
                this.isPersistenceEnabled = z;
                if (z && !z2) {
                    this.sharedPreferencesForData = this.context.getSharedPreferences(this.sharedPreferencesName, 0);
                    this.sharedPreferencesForEncryptionMaterials = this.context.getSharedPreferences(this.sharedPreferencesName + ".encryptionkey", 0);
                    initKeyProviderBasedOnAPILevel();
                    Log log = logger;
                    log.info("Detected Android API Level = " + Build.VERSION.SDK_INT);
                    log.info("Creating the AWSKeyValueStore with key for sharedPreferencesForData = " + this.sharedPreferencesName);
                    onMigrateFromNoEncryption();
                } else if (!z) {
                    logger.info("Persistence is disabled. Data will be accessed from memory.");
                }
                if (!z && z2) {
                    this.sharedPreferencesForData.edit().clear().apply();
                }
            } catch (Exception e) {
                logger.error("Error in enabling persistence for " + this.sharedPreferencesName, e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean contains(String str) {
        if (this.isPersistenceEnabled) {
            if (this.cache.containsKey(str)) {
                return true;
            }
            return this.sharedPreferencesForData.contains(getDataKeyUsedInPersistentStore(str));
        }
        return this.cache.containsKey(str);
    }

    public synchronized String get(String str) {
        if (str == null) {
            return null;
        }
        if (!this.cache.containsKey(str) && this.isPersistenceEnabled) {
            String dataKeyUsedInPersistentStore = getDataKeyUsedInPersistentStore(str);
            Key keyRetrieveEncryptionKey = retrieveEncryptionKey(getEncryptionKeyAlias());
            if (keyRetrieveEncryptionKey == null) {
                logger.error("Error in retrieving the decryption key used to decrypt the data from the persistent store. Returning null for the requested dataKey = " + str);
                return null;
            }
            if (!this.sharedPreferencesForData.contains(dataKeyUsedInPersistentStore)) {
                return null;
            }
            try {
                if (Integer.parseInt(this.sharedPreferencesForData.getString(dataKeyUsedInPersistentStore + ".keyvaluestoreversion", null)) != 1) {
                    logger.error("The version of the data read from SharedPreferences for " + str + " does not match the version of the store.");
                    return null;
                }
                String strDecrypt = decrypt(keyRetrieveEncryptionKey, getInitializationVector(dataKeyUsedInPersistentStore), this.sharedPreferencesForData.getString(dataKeyUsedInPersistentStore, null));
                this.cache.put(str, strDecrypt);
                return strDecrypt;
            } catch (Exception e) {
                logger.error("Error in retrieving value for dataKey = " + str, e);
                remove(str);
                return null;
            }
        }
        return (String) this.cache.get(str);
    }

    public synchronized void put(String str, String str2) {
        byte[] bArrGenerateInitializationVector;
        if (str == null) {
            logger.error("dataKey is null.");
            return;
        }
        this.cache.put(str, str2);
        if (this.isPersistenceEnabled) {
            if (str2 == null) {
                logger.debug("Value is null. Removing the data, IV and version from SharedPreferences");
                this.cache.remove(str);
                remove(str);
                return;
            }
            String dataKeyUsedInPersistentStore = getDataKeyUsedInPersistentStore(str);
            String encryptionKeyAlias = getEncryptionKeyAlias();
            Key keyRetrieveEncryptionKey = retrieveEncryptionKey(encryptionKeyAlias);
            if (keyRetrieveEncryptionKey == null) {
                Log log = logger;
                log.warn("No encryption key found for encryptionKeyAlias: " + encryptionKeyAlias);
                Key keyGenerateEncryptionKey = generateEncryptionKey(encryptionKeyAlias);
                if (keyGenerateEncryptionKey == null) {
                    log.error("Error in generating the encryption key for encryptionKeyAlias: " + encryptionKeyAlias + " used to encrypt the data before storing. Skipping persisting the data in the persistent store.");
                    return;
                }
                keyRetrieveEncryptionKey = keyGenerateEncryptionKey;
            }
            try {
                bArrGenerateInitializationVector = generateInitializationVector();
            } catch (Exception e) {
                logger.error("Error in storing value for dataKey = " + str + ". This data has not been stored in the persistent store.", e);
            }
            if (bArrGenerateInitializationVector == null) {
                throw new Exception("The generated IV for dataKey = " + str + " is null.");
            }
            String strEncrypt = encrypt(keyRetrieveEncryptionKey, getAlgorithmParameterSpecForIV(bArrGenerateInitializationVector), str2);
            String strEncodeAsString = Base64.encodeAsString(bArrGenerateInitializationVector);
            if (strEncodeAsString == null) {
                throw new Exception("Error in Base64 encoding the IV for dataKey = " + str);
            }
            this.sharedPreferencesForData.edit().putString(dataKeyUsedInPersistentStore, strEncrypt).putString(dataKeyUsedInPersistentStore + ".iv", strEncodeAsString).putString(dataKeyUsedInPersistentStore + ".keyvaluestoreversion", String.valueOf(1)).apply();
        }
    }

    public synchronized void remove(String str) {
        this.cache.remove(str);
        if (this.isPersistenceEnabled) {
            String dataKeyUsedInPersistentStore = getDataKeyUsedInPersistentStore(str);
            this.sharedPreferencesForData.edit().remove(dataKeyUsedInPersistentStore).remove(dataKeyUsedInPersistentStore + ".iv").remove(dataKeyUsedInPersistentStore + ".keyvaluestoreversion").apply();
        }
    }

    public synchronized void clear() {
        this.cache.clear();
        if (this.isPersistenceEnabled) {
            this.sharedPreferencesForData.edit().clear().apply();
        }
    }

    private String encrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, key, algorithmParameterSpec);
            return Base64.encodeAsString(cipher.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            logger.error("Error in encrypting data. ", e);
            return null;
        }
    }

    private String decrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            byte[] bArrDecode = Base64.decode(str);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, key, algorithmParameterSpec);
            return new String(cipher.doFinal(bArrDecode), "UTF-8");
        } catch (Exception e) {
            logger.error("Error in decrypting data. ", e);
            return null;
        }
    }

    private AlgorithmParameterSpec getInitializationVector(String str) throws Exception {
        String str2 = str + ".iv";
        if (!this.sharedPreferencesForData.contains(str2)) {
            throw new Exception("Initialization vector for " + str + " is missing from the SharedPreferences.");
        }
        String string = this.sharedPreferencesForData.getString(str2, null);
        if (string == null) {
            throw new Exception("Cannot read the initialization vector for " + str + " from SharedPreferences.");
        }
        byte[] bArrDecode = Base64.decode(string);
        if (bArrDecode == null || bArrDecode.length == 0) {
            throw new Exception("Cannot base64 decode the initialization vector for " + str + " read from SharedPreferences.");
        }
        return getAlgorithmParameterSpecForIV(bArrDecode);
    }

    private byte[] generateInitializationVector() {
        byte[] bArr = new byte[12];
        this.secureRandom.nextBytes(bArr);
        return bArr;
    }

    private AlgorithmParameterSpec getAlgorithmParameterSpecForIV(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    private synchronized Key retrieveEncryptionKey(String str) {
        try {
        } catch (KeyNotFoundException e) {
            Log log = logger;
            log.error(e);
            log.info("Deleting the encryption key identified by the keyAlias: " + str);
            this.keyProvider.deleteKey(str);
            return null;
        }
        return this.keyProvider.retrieveKey(str);
    }

    synchronized Key generateEncryptionKey(String str) {
        try {
        } catch (KeyNotGeneratedException e) {
            logger.error("Encryption Key cannot be generated successfully.", e);
            return null;
        }
        return this.keyProvider.generateKey(str);
    }

    private String getDataKeyUsedInPersistentStore(String str) {
        if (str == null) {
            return null;
        }
        return str + ".encrypted";
    }

    private String getEncryptionKeyAlias() {
        return this.sharedPreferencesName + ".aesKeyStoreAlias";
    }

    private void initKeyProviderBasedOnAPILevel() {
        this.keyProvider = new KeyProvider23();
    }

    private void onMigrateFromNoEncryption() {
        Map<String, ?> all = this.sharedPreferencesForData.getAll();
        for (String str : all.keySet()) {
            if (!str.endsWith(".encrypted") && !str.endsWith(".iv") && !str.endsWith(".keyvaluestoreversion")) {
                if (all.get(str) instanceof Long) {
                    put(str, String.valueOf(Long.valueOf(this.sharedPreferencesForData.getLong(str, 0L))));
                } else if (all.get(str) instanceof String) {
                    put(str, this.sharedPreferencesForData.getString(str, null));
                } else if (all.get(str) instanceof Float) {
                    put(str, String.valueOf(Float.valueOf(this.sharedPreferencesForData.getFloat(str, BitmapDescriptorFactory.HUE_RED))));
                } else if (all.get(str) instanceof Boolean) {
                    put(str, String.valueOf(Boolean.valueOf(this.sharedPreferencesForData.getBoolean(str, false))));
                } else if (all.get(str) instanceof Integer) {
                    put(str, String.valueOf(Integer.valueOf(this.sharedPreferencesForData.getInt(str, 0))));
                } else if (all.get(str) instanceof Set) {
                    Set set = (Set) all.get(str);
                    StringBuilder sb = new StringBuilder();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        if (it.hasNext()) {
                            sb.append(",");
                        }
                    }
                    put(str, sb.toString());
                }
                this.sharedPreferencesForData.edit().remove(str).apply();
            }
        }
    }
}
