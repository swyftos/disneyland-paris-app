package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.KeyWrapException;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.ExtraMaterialsDescription;
import com.amazonaws.services.s3.model.KMSEncryptionMaterials;
import com.amazonaws.services.s3.model.MaterialsDescriptionProvider;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.json.JsonUtils;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
/* loaded from: classes2.dex */
final class ContentCryptoMaterial {
    private final CipherLite cipherLite;
    private final byte[] encryptedCEK;
    private final Map kekMaterialsDescription;
    private final String keyWrappingAlgorithm;

    ContentCryptoMaterial(Map map, byte[] bArr, String str, CipherLite cipherLite) {
        this.cipherLite = cipherLite;
        this.keyWrappingAlgorithm = str;
        this.encryptedCEK = (byte[]) bArr.clone();
        this.kekMaterialsDescription = map;
    }

    String getKeyWrappingAlgorithm() {
        return this.keyWrappingAlgorithm;
    }

    private boolean usesKMSKey() {
        return KMSSecuredCEK.isKMSKeyWrapped(this.keyWrappingAlgorithm);
    }

    ContentCryptoScheme getContentCryptoScheme() {
        return this.cipherLite.getContentCryptoScheme();
    }

    ObjectMetadata toObjectMetadata(ObjectMetadata objectMetadata, CryptoMode cryptoMode) {
        if (cryptoMode == CryptoMode.EncryptionOnly && !usesKMSKey()) {
            return toObjectMetadataEO(objectMetadata);
        }
        return toObjectMetadata(objectMetadata);
    }

    private ObjectMetadata toObjectMetadata(ObjectMetadata objectMetadata) {
        objectMetadata.addUserMetadata(Headers.CRYPTO_KEY_V2, Base64.encodeAsString(getEncryptedCEK()));
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        objectMetadata.addUserMetadata(Headers.CRYPTO_CEK_ALGORITHM, contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_TAG_LENGTH, String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm != null) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_KEYWRAP_ALGORITHM, keyWrappingAlgorithm);
        }
        return objectMetadata;
    }

    private ObjectMetadata toObjectMetadataEO(ObjectMetadata objectMetadata) {
        objectMetadata.addUserMetadata(Headers.CRYPTO_KEY, Base64.encodeAsString(getEncryptedCEK()));
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        return objectMetadata;
    }

    String toJsonString(CryptoMode cryptoMode) {
        return (cryptoMode != CryptoMode.EncryptionOnly || usesKMSKey()) ? toJsonString() : toJsonStringEO();
    }

    String toJsonString() {
        HashMap map = new HashMap();
        map.put(Headers.CRYPTO_KEY_V2, Base64.encodeAsString(getEncryptedCEK()));
        map.put(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        map.put(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        map.put(Headers.CRYPTO_CEK_ALGORITHM, contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            map.put(Headers.CRYPTO_TAG_LENGTH, String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm != null) {
            map.put(Headers.CRYPTO_KEYWRAP_ALGORITHM, keyWrappingAlgorithm);
        }
        return JsonUtils.mapToString(map);
    }

    private String toJsonStringEO() {
        HashMap map = new HashMap();
        map.put(Headers.CRYPTO_KEY, Base64.encodeAsString(getEncryptedCEK()));
        map.put(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        map.put(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        return JsonUtils.mapToString(map);
    }

    private String kekMaterialDescAsJson() {
        Map kEKMaterialsDescription = getKEKMaterialsDescription();
        if (kEKMaterialsDescription == null) {
            kEKMaterialsDescription = Collections.emptyMap();
        }
        return JsonUtils.mapToString(kEKMaterialsDescription);
    }

    private static Map matdescFromJson(String str) {
        Map<String, String> mapJsonToMap = JsonUtils.jsonToMap(str);
        if (mapJsonToMap == null) {
            return null;
        }
        return Collections.unmodifiableMap(mapJsonToMap);
    }

    private static SecretKey cek(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, Provider provider, ContentCryptoScheme contentCryptoScheme, AWSKMSClient aWSKMSClient) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Key symmetricKey;
        Cipher cipher;
        if (KMSSecuredCEK.isKMSKeyWrapped(str)) {
            return cekByKMS(bArr, str, encryptionMaterials, contentCryptoScheme, aWSKMSClient);
        }
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPrivate();
            if (symmetricKey == null) {
                throw new AmazonClientException("Key encrypting key not available");
            }
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
            if (symmetricKey == null) {
                throw new AmazonClientException("Key encrypting key not available");
            }
        }
        try {
            if (str != null) {
                Cipher cipher2 = provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
                cipher2.init(4, symmetricKey);
                return (SecretKey) cipher2.unwrap(bArr, str, 3);
            }
            if (provider != null) {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm(), provider);
            } else {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm());
            }
            cipher.init(2, symmetricKey);
            return new SecretKeySpec(cipher.doFinal(bArr), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to decrypt symmetric key from object metadata", e);
        }
    }

    private static SecretKey cekByKMS(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, AWSKMSClient aWSKMSClient) {
        return new SecretKeySpec(BinaryUtils.copyAllBytesFrom(aWSKMSClient.decrypt(new DecryptRequest().withEncryptionContext(encryptionMaterials.getMaterialsDescription()).withCiphertextBlob(ByteBuffer.wrap(bArr))).getPlaintext()), contentCryptoScheme.getKeyGeneratorAlgorithm());
    }

    static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, boolean z, AWSKMSClient aWSKMSClient) {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, null, ExtraMaterialsDescription.NONE, z, aWSKMSClient);
    }

    static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, jArr, extraMaterialsDescription, z, aWSKMSClient);
    }

    private static ContentCryptoMaterial fromObjectMetadata0(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        EncryptionMaterials encryptionMaterials;
        int i;
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        String str = userMetadata.get(Headers.CRYPTO_KEY_V2);
        if (str == null && (str = userMetadata.get(Headers.CRYPTO_KEY)) == null) {
            throw new AmazonClientException("Content encrypting key not found.");
        }
        byte[] bArrDecode = Base64.decode(str);
        byte[] bArrDecode2 = Base64.decode(userMetadata.get(Headers.CRYPTO_IV));
        if (bArrDecode == null || bArrDecode2 == null) {
            throw new AmazonClientException("Content encrypting key or IV not found.");
        }
        String str2 = userMetadata.get(Headers.MATERIALS_DESCRIPTION);
        String str3 = userMetadata.get(Headers.CRYPTO_KEYWRAP_ALGORITHM);
        boolean zIsKMSKeyWrapped = KMSSecuredCEK.isKMSKeyWrapped(str3);
        Map<String, String> mapMatdescFromJson = matdescFromJson(str2);
        Map<String, String> mapMergeInto = (zIsKMSKeyWrapped || extraMaterialsDescription == null) ? mapMatdescFromJson : extraMaterialsDescription.mergeInto(mapMatdescFromJson);
        if (zIsKMSKeyWrapped) {
            encryptionMaterials = new KMSEncryptionMaterials(mapMatdescFromJson.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            encryptionMaterials.addDescriptions(mapMatdescFromJson);
        } else {
            encryptionMaterials = encryptionMaterialsAccessor == null ? null : encryptionMaterialsAccessor.getEncryptionMaterials(mapMergeInto);
            if (encryptionMaterials == null) {
                throw new AmazonClientException("Unable to retrieve the client encryption materials");
            }
        }
        EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
        String str4 = userMetadata.get(Headers.CRYPTO_CEK_ALGORITHM);
        boolean z2 = jArr != null;
        ContentCryptoScheme contentCryptoSchemeFromCEKAlgo = ContentCryptoScheme.fromCEKAlgo(str4, z2);
        if (z2) {
            bArrDecode2 = contentCryptoSchemeFromCEKAlgo.adjustIV(bArrDecode2, jArr[0]);
        } else {
            int tagLengthInBits = contentCryptoSchemeFromCEKAlgo.getTagLengthInBits();
            if (tagLengthInBits > 0 && tagLengthInBits != (i = Integer.parseInt(userMetadata.get(Headers.CRYPTO_TAG_LENGTH)))) {
                throw new AmazonClientException("Unsupported tag length: " + i + ", expected: " + tagLengthInBits);
            }
        }
        byte[] bArr = bArrDecode2;
        if (z && str3 == null) {
            throw newKeyWrapException();
        }
        return new ContentCryptoMaterial(mapMergeInto, bArrDecode, str3, contentCryptoSchemeFromCEKAlgo.createCipherLite(cek(bArrDecode, str3, encryptionMaterials2, provider, contentCryptoSchemeFromCEKAlgo, aWSKMSClient), bArr, 2, provider));
    }

    private static KeyWrapException newKeyWrapException() {
        return new KeyWrapException("Missing key-wrap for the content-encrypting-key");
    }

    static ContentCryptoMaterial fromInstructionFile(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, boolean z, AWSKMSClient aWSKMSClient) {
        return fromInstructionFile0(map, encryptionMaterialsAccessor, provider, null, ExtraMaterialsDescription.NONE, z, aWSKMSClient);
    }

    static ContentCryptoMaterial fromInstructionFile(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        return fromInstructionFile0(map, encryptionMaterialsAccessor, provider, jArr, extraMaterialsDescription, z, aWSKMSClient);
    }

    private static ContentCryptoMaterial fromInstructionFile0(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        EncryptionMaterials encryptionMaterials;
        int i;
        String str = (String) map.get(Headers.CRYPTO_KEY_V2);
        if (str == null && (str = (String) map.get(Headers.CRYPTO_KEY)) == null) {
            throw new AmazonClientException("Content encrypting key not found.");
        }
        byte[] bArrDecode = Base64.decode(str);
        byte[] bArrDecode2 = Base64.decode((String) map.get(Headers.CRYPTO_IV));
        if (bArrDecode == null || bArrDecode2 == null) {
            throw new AmazonClientException("Necessary encryption info not found in the instruction file " + map);
        }
        String str2 = (String) map.get(Headers.CRYPTO_KEYWRAP_ALGORITHM);
        boolean zIsKMSKeyWrapped = KMSSecuredCEK.isKMSKeyWrapped(str2);
        Map<String, String> mapMatdescFromJson = matdescFromJson((String) map.get(Headers.MATERIALS_DESCRIPTION));
        Map<String, String> mapMergeInto = (extraMaterialsDescription == null || zIsKMSKeyWrapped) ? mapMatdescFromJson : extraMaterialsDescription.mergeInto(mapMatdescFromJson);
        if (zIsKMSKeyWrapped) {
            encryptionMaterials = new KMSEncryptionMaterials(mapMatdescFromJson.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            encryptionMaterials.addDescriptions(mapMatdescFromJson);
        } else {
            encryptionMaterials = encryptionMaterialsAccessor == null ? null : encryptionMaterialsAccessor.getEncryptionMaterials(mapMergeInto);
            if (encryptionMaterials == null) {
                throw new AmazonClientException("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file " + map);
            }
        }
        EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
        String str3 = (String) map.get(Headers.CRYPTO_CEK_ALGORITHM);
        boolean z2 = jArr != null;
        ContentCryptoScheme contentCryptoSchemeFromCEKAlgo = ContentCryptoScheme.fromCEKAlgo(str3, z2);
        if (z2) {
            bArrDecode2 = contentCryptoSchemeFromCEKAlgo.adjustIV(bArrDecode2, jArr[0]);
        } else {
            int tagLengthInBits = contentCryptoSchemeFromCEKAlgo.getTagLengthInBits();
            if (tagLengthInBits > 0 && tagLengthInBits != (i = Integer.parseInt((String) map.get(Headers.CRYPTO_TAG_LENGTH)))) {
                throw new AmazonClientException("Unsupported tag length: " + i + ", expected: " + tagLengthInBits);
            }
        }
        byte[] bArr = bArrDecode2;
        if (z && str2 == null) {
            throw newKeyWrapException();
        }
        return new ContentCryptoMaterial(mapMergeInto, bArrDecode, str2, contentCryptoSchemeFromCEKAlgo.createCipherLite(cek(bArrDecode, str2, encryptionMaterials2, provider, contentCryptoSchemeFromCEKAlgo, aWSKMSClient), bArr, 2, provider));
    }

    CipherLite getCipherLite() {
        return this.cipherLite;
    }

    Map getKEKMaterialsDescription() {
        return this.kekMaterialsDescription;
    }

    byte[] getEncryptedCEK() {
        return (byte[]) this.encryptedCEK.clone();
    }

    ContentCryptoMaterial recreate(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        EncryptionMaterials encryptionMaterials;
        if (!usesKMSKey() && map.equals(this.kekMaterialsDescription)) {
            throw new SecurityException("Material description of the new KEK must differ from the current one");
        }
        if (usesKMSKey()) {
            encryptionMaterials = new KMSEncryptionMaterials((String) this.kekMaterialsDescription.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
        } else {
            encryptionMaterials = encryptionMaterialsAccessor.getEncryptionMaterials(this.kekMaterialsDescription);
        }
        EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
        EncryptionMaterials encryptionMaterials3 = encryptionMaterialsAccessor.getEncryptionMaterials(map);
        if (encryptionMaterials3 == null) {
            throw new AmazonClientException("No material available with the description " + map + " from the encryption material provider");
        }
        ContentCryptoMaterial contentCryptoMaterialCreate = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, encryptionMaterials2, provider, getContentCryptoScheme(), aWSKMSClient), this.cipherLite.getIV(), encryptionMaterials3, getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
        if (Arrays.equals(contentCryptoMaterialCreate.encryptedCEK, this.encryptedCEK)) {
            throw new SecurityException("The new KEK must differ from the original");
        }
        return contentCryptoMaterialCreate;
    }

    ContentCryptoMaterial recreate(EncryptionMaterials encryptionMaterials, EncryptionMaterialsAccessor encryptionMaterialsAccessor, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        EncryptionMaterials encryptionMaterials2;
        if (!usesKMSKey() && encryptionMaterials.getMaterialsDescription().equals(this.kekMaterialsDescription)) {
            throw new SecurityException("Material description of the new KEK must differ from the current one");
        }
        if (usesKMSKey()) {
            encryptionMaterials2 = new KMSEncryptionMaterials((String) this.kekMaterialsDescription.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
        } else {
            encryptionMaterials2 = encryptionMaterialsAccessor.getEncryptionMaterials(this.kekMaterialsDescription);
        }
        ContentCryptoMaterial contentCryptoMaterialCreate = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, encryptionMaterials2, provider, getContentCryptoScheme(), aWSKMSClient), this.cipherLite.getIV(), encryptionMaterials, getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
        if (Arrays.equals(contentCryptoMaterialCreate.encryptedCEK, this.encryptedCEK)) {
            throw new SecurityException("The new KEK must differ from the original");
        }
        return contentCryptoMaterialCreate;
    }

    static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return doCreate(secretKey, bArr, encryptionMaterials, contentCryptoScheme, s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
    }

    static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return doCreate(secretKey, bArr, encryptionMaterials, s3CryptoScheme.getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
    }

    private static ContentCryptoMaterial doCreate(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return wrap(secretKey, bArr, contentCryptoScheme, provider, secureCEK(secretKey, encryptionMaterials, s3CryptoScheme.getKeyWrapScheme(), s3CryptoScheme.getSecureRandom(), provider, aWSKMSClient, amazonWebServiceRequest));
    }

    public static ContentCryptoMaterial wrap(SecretKey secretKey, byte[] bArr, ContentCryptoScheme contentCryptoScheme, Provider provider, SecuredCEK securedCEK) {
        return new ContentCryptoMaterial(securedCEK.getMaterialDescription(), securedCEK.getEncrypted(), securedCEK.getKeyWrapAlgorithm(), contentCryptoScheme.createCipherLite(secretKey, bArr, 1, provider));
    }

    private static SecuredCEK secureCEK(SecretKey secretKey, EncryptionMaterials encryptionMaterials, S3KeyWrapScheme s3KeyWrapScheme, SecureRandom secureRandom, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Key symmetricKey;
        Cipher cipher;
        if (encryptionMaterials.isKMSEnabled()) {
            Map<String, String> mapMergeMaterialDescriptions = mergeMaterialDescriptions(encryptionMaterials, amazonWebServiceRequest);
            EncryptRequest encryptRequestWithPlaintext = new EncryptRequest().withEncryptionContext(mapMergeMaterialDescriptions).withKeyId(encryptionMaterials.getCustomerMasterKeyId()).withPlaintext(ByteBuffer.wrap(secretKey.getEncoded()));
            encryptRequestWithPlaintext.withGeneralProgressListener(amazonWebServiceRequest.getGeneralProgressListener()).withRequestMetricCollector(amazonWebServiceRequest.getRequestMetricCollector());
            return new KMSSecuredCEK(BinaryUtils.copyAllBytesFrom(aWSKMSClient.encrypt(encryptRequestWithPlaintext).getCiphertextBlob()), mapMergeMaterialDescriptions);
        }
        Map<String, String> materialsDescription = encryptionMaterials.getMaterialsDescription();
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPublic();
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
        }
        String keyWrapAlgorithm = s3KeyWrapScheme.getKeyWrapAlgorithm(symmetricKey, provider);
        try {
            if (keyWrapAlgorithm != null) {
                Cipher cipher2 = provider == null ? Cipher.getInstance(keyWrapAlgorithm) : Cipher.getInstance(keyWrapAlgorithm, provider);
                cipher2.init(3, symmetricKey, secureRandom);
                return new SecuredCEK(cipher2.wrap(secretKey), keyWrapAlgorithm, materialsDescription);
            }
            byte[] encoded = secretKey.getEncoded();
            String algorithm = symmetricKey.getAlgorithm();
            if (provider != null) {
                cipher = Cipher.getInstance(algorithm, provider);
            } else {
                cipher = Cipher.getInstance(algorithm);
            }
            cipher.init(1, symmetricKey);
            return new SecuredCEK(cipher.doFinal(encoded), null, materialsDescription);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to encrypt symmetric key", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Map mergeMaterialDescriptions(EncryptionMaterials encryptionMaterials, AmazonWebServiceRequest amazonWebServiceRequest) {
        Map<String, String> materialsDescription;
        Map<String, String> materialsDescription2 = encryptionMaterials.getMaterialsDescription();
        if (!(amazonWebServiceRequest instanceof MaterialsDescriptionProvider) || (materialsDescription = ((MaterialsDescriptionProvider) amazonWebServiceRequest).getMaterialsDescription()) == null) {
            return materialsDescription2;
        }
        TreeMap treeMap = new TreeMap(materialsDescription2);
        treeMap.putAll(materialsDescription);
        return treeMap;
    }
}
