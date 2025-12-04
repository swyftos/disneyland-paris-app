package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import android.content.Context;
import android.os.Build;
import ch.qos.logback.core.net.ssl.SSL;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class CognitoDeviceHelper {
    public static final int DEFAULT_DEVICE_PAGINATION_LIMIT = 10;
    private static final Log LOGGER = LogFactory.getLog(CognitoDeviceHelper.class);
    private static final Object LOCK = new Object();
    static deviceSRP srpCalculator = null;
    static Map awsKeyValueStoreMap = new HashMap();
    private static boolean isPersistenceEnabled = true;

    public static void setPersistenceEnabled(boolean z) {
        synchronized (LOCK) {
            try {
                isPersistenceEnabled = z;
                Iterator it = awsKeyValueStoreMap.keySet().iterator();
                while (it.hasNext()) {
                    ((AWSKeyValueStore) awsKeyValueStoreMap.get((String) it.next())).setPersistenceEnabled(z);
                }
            } catch (Exception e) {
                LOGGER.error("Error in setting the isPersistenceEnabled flag in the key-value store.", e);
            }
        }
    }

    private static AWSKeyValueStore getAWSKeyValueStore(Context context, String str, String str2) {
        synchronized (LOCK) {
            try {
                String deviceDetailsCacheForUser = getDeviceDetailsCacheForUser(str, str2);
                if (awsKeyValueStoreMap.containsKey(deviceDetailsCacheForUser)) {
                    return (AWSKeyValueStore) awsKeyValueStoreMap.get(deviceDetailsCacheForUser);
                }
                AWSKeyValueStore aWSKeyValueStore = new AWSKeyValueStore(context, deviceDetailsCacheForUser, isPersistenceEnabled);
                awsKeyValueStoreMap.put(deviceDetailsCacheForUser, aWSKeyValueStore);
                return aWSKeyValueStore;
            } catch (Exception e) {
                LOGGER.error("Error in retrieving the persistent store.", e);
                return null;
            }
        }
    }

    public static String getDeviceName() {
        return Build.MODEL;
    }

    public static String getDeviceKey(String str, String str2, Context context) {
        try {
            AWSKeyValueStore aWSKeyValueStore = getAWSKeyValueStore(context, str, str2);
            if (aWSKeyValueStore == null || !aWSKeyValueStore.contains("DeviceKey")) {
                return null;
            }
            return aWSKeyValueStore.get("DeviceKey");
        } catch (Exception e) {
            LOGGER.error("Error accessing SharedPreferences", e);
            return null;
        }
    }

    public static String getDeviceSecret(String str, String str2, Context context) {
        try {
            AWSKeyValueStore aWSKeyValueStore = getAWSKeyValueStore(context, str, str2);
            if (aWSKeyValueStore == null || !aWSKeyValueStore.contains("DeviceSecret")) {
                return null;
            }
            return aWSKeyValueStore.get("DeviceSecret");
        } catch (Exception e) {
            LOGGER.error("Error accessing SharedPreferences", e);
            return null;
        }
    }

    public static String getDeviceGroupKey(String str, String str2, Context context) {
        try {
            AWSKeyValueStore aWSKeyValueStore = getAWSKeyValueStore(context, str, str2);
            if (aWSKeyValueStore == null || !aWSKeyValueStore.contains("DeviceGroupKey")) {
                return null;
            }
            return aWSKeyValueStore.get("DeviceGroupKey");
        } catch (Exception e) {
            LOGGER.error("Error accessing SharedPreferences", e);
            return null;
        }
    }

    public static void cacheDeviceKey(String str, String str2, String str3, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).put("DeviceKey", str3);
        } catch (Exception e) {
            LOGGER.error("Error accessing SharedPreferences", e);
        }
    }

    public static void cacheDeviceVerifier(String str, String str2, String str3, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).put("DeviceSecret", str3);
        } catch (Exception e) {
            LOGGER.error("Error accessing SharedPreferences", e);
        }
    }

    public static void cacheDeviceGroupKey(String str, String str2, String str3, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).put("DeviceGroupKey", str3);
        } catch (Exception e) {
            LOGGER.error("Error accessing SharedPreferences", e);
        }
    }

    public static void clearCachedDevice(String str, String str2, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).clear();
        } catch (Exception e) {
            LOGGER.error("Error accessing SharedPreferences", e);
        }
    }

    public static Map<String, String> generateVerificationParameters(String str, String str2) {
        HashMap map = new HashMap();
        String strGenerateRandomString = generateRandomString();
        deviceSRP devicesrp = new deviceSRP(str2, str, strGenerateRandomString);
        srpCalculator = devicesrp;
        byte[] byteArray = devicesrp.getSalt().toByteArray();
        byte[] byteArray2 = srpCalculator.getVerifier().toByteArray();
        map.put("salt", new String(Base64.encode(byteArray)));
        map.put("verifier", new String(Base64.encode(byteArray2)));
        map.put("secret", strGenerateRandomString);
        return map;
    }

    private static String getDeviceDetailsCacheForUser(String str, String str2) {
        return "CognitoIdentityProviderDeviceCache." + str2 + InstructionFileId.DOT + str;
    }

    public static class deviceSRP {
        private static final SecureRandom SECURE_RANDOM;
        private final BigInteger salt;
        private final BigInteger verifier;
        private static final ThreadLocal THREAD_MESSAGE_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoDeviceHelper.deviceSRP.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public MessageDigest initialValue() {
                try {
                    return MessageDigest.getInstance("SHA-256");
                } catch (NoSuchAlgorithmException e) {
                    throw new ExceptionInInitializerError(e);
                }
            }
        };
        private static final BigInteger N = new BigInteger("FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF", 16);
        private static final BigInteger GG = BigInteger.valueOf(2);

        static {
            try {
                SECURE_RANDOM = SecureRandom.getInstance(SSL.DEFAULT_SECURE_RANDOM_ALGORITHM);
            } catch (NoSuchAlgorithmException e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        public BigInteger getSalt() {
            return this.salt;
        }

        public BigInteger getVerifier() {
            return this.verifier;
        }

        public deviceSRP(String str, String str2, String str3) {
            byte[] userIdHash = getUserIdHash(str, str2, str3);
            BigInteger bigInteger = new BigInteger(128, SECURE_RANDOM);
            this.salt = bigInteger;
            this.verifier = calcVerifier(bigInteger, userIdHash);
        }

        private static BigInteger calcVerifier(BigInteger bigInteger, byte[] bArr) {
            begin();
            update(bigInteger);
            update(bArr);
            return GG.modPow(new BigInteger(1, end()), N);
        }

        private byte[] getUserIdHash(String str, String str2, String str3) {
            begin();
            update(str, str2, ":", str3);
            return end();
        }

        public static void begin() {
            ((MessageDigest) THREAD_MESSAGE_DIGEST.get()).reset();
        }

        public static byte[] end() {
            return ((MessageDigest) THREAD_MESSAGE_DIGEST.get()).digest();
        }

        public static void update(String... strArr) {
            MessageDigest messageDigest = (MessageDigest) THREAD_MESSAGE_DIGEST.get();
            for (String str : strArr) {
                if (str != null) {
                    messageDigest.update(str.getBytes(StringUtils.UTF8));
                }
            }
        }

        public static void update(String str) {
            MessageDigest messageDigest = (MessageDigest) THREAD_MESSAGE_DIGEST.get();
            if (str != null) {
                messageDigest.update(str.getBytes(StringUtils.UTF8));
            }
        }

        public static void update(BigInteger... bigIntegerArr) {
            MessageDigest messageDigest = (MessageDigest) THREAD_MESSAGE_DIGEST.get();
            for (BigInteger bigInteger : bigIntegerArr) {
                if (bigInteger != null) {
                    messageDigest.update(bigInteger.toByteArray());
                }
            }
        }

        public static void update(BigInteger bigInteger) {
            MessageDigest messageDigest = (MessageDigest) THREAD_MESSAGE_DIGEST.get();
            if (bigInteger != null) {
                messageDigest.update(bigInteger.toByteArray());
            }
        }

        public static void update(ByteBuffer byteBuffer) {
            MessageDigest messageDigest = (MessageDigest) THREAD_MESSAGE_DIGEST.get();
            if (byteBuffer != null) {
                messageDigest.update(byteBuffer.array());
            }
        }

        public static void update(byte[] bArr) {
            MessageDigest messageDigest = (MessageDigest) THREAD_MESSAGE_DIGEST.get();
            if (bArr != null) {
                messageDigest.update(bArr);
            }
        }
    }

    public static String generateRandomString() {
        return String.valueOf(UUID.randomUUID());
    }
}
