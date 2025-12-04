package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.internal.RepeatableCipherInputStream;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.util.Base64;
import com.amazonaws.util.LengthCheckInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
/* loaded from: classes2.dex */
public class EncryptionUtils {
    @Deprecated
    public static PutObjectRequest encryptRequestUsingMetadata(PutObjectRequest putObjectRequest, EncryptionMaterials encryptionMaterials, Provider provider) {
        EncryptionInstruction encryptionInstructionGenerateInstruction = generateInstruction(encryptionMaterials, provider);
        PutObjectRequest putObjectRequestEncryptRequestUsingInstruction = encryptRequestUsingInstruction(putObjectRequest, encryptionInstructionGenerateInstruction);
        updateMetadataWithEncryptionInstruction(putObjectRequest, encryptionInstructionGenerateInstruction);
        return putObjectRequestEncryptRequestUsingInstruction;
    }

    @Deprecated
    public static S3Object decryptObjectUsingMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return decryptObjectUsingInstruction(s3Object, buildInstructionFromObjectMetadata(s3Object, encryptionMaterials, provider));
    }

    @Deprecated
    public static EncryptionInstruction generateInstruction(EncryptionMaterials encryptionMaterials, Provider provider) {
        return generateInstruction(new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction generateInstruction(EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        return buildInstruction(encryptionMaterialsProvider.getEncryptionMaterials(), provider);
    }

    public static EncryptionInstruction generateInstruction(EncryptionMaterialsProvider encryptionMaterialsProvider, Map<String, String> map, Provider provider) {
        return buildInstruction(encryptionMaterialsProvider.getEncryptionMaterials(map), provider);
    }

    private static EncryptionInstruction buildInstruction(EncryptionMaterials encryptionMaterials, Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKey secretKeyGenerateOneTimeUseSymmetricKey = generateOneTimeUseSymmetricKey();
        CipherFactory cipherFactory = new CipherFactory(secretKeyGenerateOneTimeUseSymmetricKey, 1, null, provider);
        return new EncryptionInstruction(encryptionMaterials.getMaterialsDescription(), getEncryptedSymmetricKey(secretKeyGenerateOneTimeUseSymmetricKey, encryptionMaterials, provider), secretKeyGenerateOneTimeUseSymmetricKey, cipherFactory);
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromInstructionFile(s3Object, new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Map jSONInstruction = parseJSONInstruction(s3Object);
        String str = (String) jSONInstruction.get(Headers.CRYPTO_KEY);
        String str2 = (String) jSONInstruction.get(Headers.CRYPTO_IV);
        Map mapConvertJSONToMap = convertJSONToMap((String) jSONInstruction.get(Headers.MATERIALS_DESCRIPTION));
        byte[] bArrDecode = Base64.decode(str);
        byte[] bArrDecode2 = Base64.decode(str2);
        if (bArrDecode == null || bArrDecode2 == null) {
            throw new AmazonClientException(String.format("Necessary encryption info not found in the instruction file '%s' in bucket '%s'", s3Object.getKey(), s3Object.getBucketName()));
        }
        EncryptionMaterials encryptionMaterialsRetrieveOriginalMaterials = retrieveOriginalMaterials(mapConvertJSONToMap, encryptionMaterialsProvider);
        if (encryptionMaterialsRetrieveOriginalMaterials == null) {
            throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file '%s' in bucket '%s'.", s3Object.getKey(), s3Object.getBucketName()));
        }
        SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(bArrDecode, encryptionMaterialsRetrieveOriginalMaterials, provider);
        return new EncryptionInstruction((Map<String, String>) mapConvertJSONToMap, bArrDecode, decryptedSymmetricKey, new CipherFactory(decryptedSymmetricKey, 2, bArrDecode2, provider));
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromObjectMetadata(s3Object, new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ObjectMetadata objectMetadata = s3Object.getObjectMetadata();
        byte[] cryptoBytesFromMetadata = getCryptoBytesFromMetadata(Headers.CRYPTO_KEY, objectMetadata);
        byte[] cryptoBytesFromMetadata2 = getCryptoBytesFromMetadata(Headers.CRYPTO_IV, objectMetadata);
        Map mapConvertJSONToMap = convertJSONToMap(getStringFromMetadata(Headers.MATERIALS_DESCRIPTION, objectMetadata));
        if (cryptoBytesFromMetadata == null || cryptoBytesFromMetadata2 == null) {
            throw new AmazonClientException(String.format("Necessary encryption info not found in the headers of file '%s' in bucket '%s'", s3Object.getKey(), s3Object.getBucketName()));
        }
        EncryptionMaterials encryptionMaterialsRetrieveOriginalMaterials = retrieveOriginalMaterials(mapConvertJSONToMap, encryptionMaterialsProvider);
        if (encryptionMaterialsRetrieveOriginalMaterials == null) {
            throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted file '%s' in bucket '%s'.", s3Object.getKey(), s3Object.getBucketName()));
        }
        SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(cryptoBytesFromMetadata, encryptionMaterialsRetrieveOriginalMaterials, provider);
        return new EncryptionInstruction((Map<String, String>) mapConvertJSONToMap, cryptoBytesFromMetadata, decryptedSymmetricKey, new CipherFactory(decryptedSymmetricKey, 2, cryptoBytesFromMetadata2, provider));
    }

    public static PutObjectRequest encryptRequestUsingInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (metadata.getContentMD5() != null) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_MD5, metadata.getContentMD5());
        }
        metadata.setContentMD5(null);
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, metadata);
        if (unencryptedContentLength >= 0) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_LENGTH, Long.toString(unencryptedContentLength));
        }
        long jCalculateCryptoContentLength = calculateCryptoContentLength(encryptionInstruction.getSymmetricCipher(), putObjectRequest, metadata);
        if (jCalculateCryptoContentLength >= 0) {
            metadata.setContentLength(jCalculateCryptoContentLength);
        }
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(getEncryptedInputStream(putObjectRequest, encryptionInstruction.getCipherFactory(), unencryptedContentLength));
        putObjectRequest.setFile(null);
        return putObjectRequest;
    }

    public static S3Object decryptObjectUsingInstruction(S3Object s3Object, EncryptionInstruction encryptionInstruction) {
        s3Object.setObjectContent(new S3ObjectInputStream(new RepeatableCipherInputStream(s3Object.getObjectContent(), encryptionInstruction.getCipherFactory())));
        return s3Object;
    }

    public static PutObjectRequest createInstructionPutRequest(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(JsonUtils.mapToString(convertInstructionToJSONObject(encryptionInstruction)).getBytes(StringUtils.UTF8));
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        metadata.setContentLength(r5.length);
        metadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        putObjectRequest.setKey(putObjectRequest.getKey() + ".instruction");
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(byteArrayInputStream);
        return putObjectRequest;
    }

    public static PutObjectRequest createInstructionPutRequest(String str, String str2, EncryptionInstruction encryptionInstruction) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(JsonUtils.mapToString(convertInstructionToJSONObject(encryptionInstruction)).getBytes(StringUtils.UTF8));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(r6.length);
        objectMetadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        return new PutObjectRequest(str, str2 + ".instruction", byteArrayInputStream, objectMetadata);
    }

    public static GetObjectRequest createInstructionGetRequest(GetObjectRequest getObjectRequest) {
        return new GetObjectRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey() + ".instruction", getObjectRequest.getVersionId());
    }

    public static DeleteObjectRequest createInstructionDeleteObjectRequest(DeleteObjectRequest deleteObjectRequest) {
        return new DeleteObjectRequest(deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey() + ".instruction");
    }

    public static boolean isEncryptionInfoInMetadata(S3Object s3Object) {
        Map<String, String> userMetadata = s3Object.getObjectMetadata().getUserMetadata();
        return userMetadata != null && userMetadata.containsKey(Headers.CRYPTO_IV) && userMetadata.containsKey(Headers.CRYPTO_KEY);
    }

    public static boolean isEncryptionInfoInInstructionFile(S3Object s3Object) {
        Map<String, String> userMetadata;
        if (s3Object == null || (userMetadata = s3Object.getObjectMetadata().getUserMetadata()) == null) {
            return false;
        }
        return userMetadata.containsKey(Headers.CRYPTO_INSTRUCTION_FILE);
    }

    public static long[] getAdjustedCryptoRange(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        long j = jArr[0];
        if (j > jArr[1]) {
            return null;
        }
        return new long[]{getCipherBlockLowerBound(j), getCipherBlockUpperBound(jArr[1])};
    }

    public static S3Object adjustOutputToDesiredRange(S3Object s3Object, long[] jArr) {
        if (jArr == null || jArr[0] > jArr[1]) {
            return s3Object;
        }
        try {
            s3Object.setObjectContent(new S3ObjectInputStream(new AdjustedRangeInputStream(s3Object.getObjectContent(), jArr[0], jArr[1])));
            return s3Object;
        } catch (IOException e) {
            throw new AmazonClientException("Error adjusting output to desired byte range: " + e.getMessage());
        }
    }

    public static SecretKey generateOneTimeUseSymmetricKey() throws NoSuchAlgorithmException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            keyGenerator.init(256, new SecureRandom());
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new AmazonClientException("Unable to generate envelope symmetric key:" + e.getMessage(), e);
        }
    }

    public static Cipher createSymmetricCipher(SecretKey secretKey, int i, Provider provider, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher;
        try {
            if (provider != null) {
                cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, provider);
            } else {
                cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            }
            if (bArr != null) {
                cipher.init(i, secretKey, new IvParameterSpec(bArr));
            } else {
                cipher.init(i, secretKey);
            }
            return cipher;
        } catch (Exception e) {
            throw new AmazonClientException("Unable to build cipher: " + e.getMessage() + "\nMake sure you have the JCE unlimited strength policy files installed and configured for your JVM: http://www.ngs.ac.uk/tools/jcepolicyfiles", e);
        }
    }

    public static byte[] getEncryptedSymmetricKey(SecretKey secretKey, EncryptionMaterials encryptionMaterials, Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Key symmetricKey;
        Cipher cipher;
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPublic();
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
        }
        try {
            byte[] encoded = secretKey.getEncoded();
            if (provider != null) {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm(), provider);
            } else {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm());
            }
            cipher.init(1, symmetricKey);
            return cipher.doFinal(encoded);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to encrypt symmetric key: " + e.getMessage(), e);
        }
    }

    private static SecretKey getDecryptedSymmetricKey(byte[] bArr, EncryptionMaterials encryptionMaterials, Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Key symmetricKey;
        Cipher cipher;
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPrivate();
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
        }
        try {
            if (provider != null) {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm(), provider);
            } else {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm());
            }
            cipher.init(2, symmetricKey);
            return new SecretKeySpec(cipher.doFinal(bArr), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to decrypt symmetric key from object metadata : " + e.getMessage(), e);
        }
    }

    private static InputStream getEncryptedInputStream(PutObjectRequest putObjectRequest, CipherFactory cipherFactory, long j) {
        try {
            InputStream inputStream = putObjectRequest.getInputStream();
            if (putObjectRequest.getFile() != null) {
                inputStream = new RepeatableFileInputStream(putObjectRequest.getFile());
            }
            if (j > -1) {
                inputStream = new LengthCheckInputStream(inputStream, j, false);
            }
            return new RepeatableCipherInputStream(inputStream, cipherFactory);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to create cipher input stream: " + e.getMessage(), e);
        }
    }

    public static ByteRangeCapturingInputStream getEncryptedInputStream(UploadPartRequest uploadPartRequest, CipherFactory cipherFactory) {
        try {
            InputStream inputStream = uploadPartRequest.getInputStream();
            if (uploadPartRequest.getFile() != null) {
                inputStream = new InputSubstream(new RepeatableFileInputStream(uploadPartRequest.getFile()), uploadPartRequest.getFileOffset(), uploadPartRequest.getPartSize(), uploadPartRequest.isLastPart());
            }
            FilterInputStream repeatableCipherInputStream = new RepeatableCipherInputStream(inputStream, cipherFactory);
            FilterInputStream inputSubstream = !uploadPartRequest.isLastPart() ? new InputSubstream(repeatableCipherInputStream, 0L, uploadPartRequest.getPartSize(), false) : repeatableCipherInputStream;
            long partSize = uploadPartRequest.getPartSize();
            return new ByteRangeCapturingInputStream(inputSubstream, partSize - cipherFactory.createCipher().getBlockSize(), partSize);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to create cipher input stream: " + e.getMessage(), e);
        }
    }

    private static byte[] getCryptoBytesFromMetadata(String str, ObjectMetadata objectMetadata) {
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata == null || !userMetadata.containsKey(str)) {
            return null;
        }
        return Base64.decode(userMetadata.get(str));
    }

    private static String getStringFromMetadata(String str, ObjectMetadata objectMetadata) {
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata == null || !userMetadata.containsKey(str)) {
            return null;
        }
        return userMetadata.get(str);
    }

    private static Map convertJSONToMap(String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonUtils.jsonToMap(str);
        } catch (AmazonClientException e) {
            throw new AmazonClientException("Unable to parse encryption materials description from metadata :" + e.getMessage());
        }
    }

    public static void updateMetadataWithEncryptionInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        byte[] encryptedSymmetricKey = encryptionInstruction.getEncryptedSymmetricKey();
        Cipher symmetricCipher = encryptionInstruction.getSymmetricCipher();
        Map<String, String> materialsDescription = encryptionInstruction.getMaterialsDescription();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (putObjectRequest.getFile() != null) {
            metadata.setContentType(Mimetypes.getInstance().getMimetype(putObjectRequest.getFile()));
        }
        updateMetadata(metadata, encryptedSymmetricKey, symmetricCipher, materialsDescription);
        putObjectRequest.setMetadata(metadata);
    }

    private static void updateMetadata(ObjectMetadata objectMetadata, byte[] bArr, Cipher cipher, Map map) {
        if (bArr != null) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_KEY, Base64.encodeAsString(bArr));
        }
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(cipher.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, JsonUtils.mapToString(map));
    }

    public static ObjectMetadata updateMetadataWithEncryptionInfo(InitiateMultipartUploadRequest initiateMultipartUploadRequest, byte[] bArr, Cipher cipher, Map<String, String> map) {
        ObjectMetadata objectMetadata = initiateMultipartUploadRequest.getObjectMetadata();
        if (objectMetadata == null) {
            objectMetadata = new ObjectMetadata();
        }
        updateMetadata(objectMetadata, bArr, cipher, map);
        return objectMetadata;
    }

    private static EncryptionMaterials retrieveOriginalMaterials(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor) {
        if (encryptionMaterialsAccessor == null) {
            return null;
        }
        return encryptionMaterialsAccessor.getEncryptionMaterials(map);
    }

    private static long calculateCryptoContentLength(Cipher cipher, PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, objectMetadata);
        if (unencryptedContentLength < 0) {
            return -1L;
        }
        long blockSize = cipher.getBlockSize();
        return unencryptedContentLength + (blockSize - (unencryptedContentLength % blockSize));
    }

    public static long calculateCryptoContentLength(Cipher cipher, UploadPartRequest uploadPartRequest) {
        long partSize;
        if (uploadPartRequest.getFile() != null) {
            if (uploadPartRequest.getPartSize() > 0) {
                partSize = uploadPartRequest.getPartSize();
            } else {
                partSize = uploadPartRequest.getFile().length();
            }
        } else {
            if (uploadPartRequest.getInputStream() == null) {
                return -1L;
            }
            partSize = uploadPartRequest.getPartSize();
        }
        long blockSize = cipher.getBlockSize();
        return partSize + (blockSize - (partSize % blockSize));
    }

    private static long getUnencryptedContentLength(PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        if (putObjectRequest.getFile() != null) {
            return putObjectRequest.getFile().length();
        }
        if (putObjectRequest.getInputStream() == null || objectMetadata.getRawMetadataValue("Content-Length") == null) {
            return -1L;
        }
        return objectMetadata.getContentLength();
    }

    private static Map convertInstructionToJSONObject(EncryptionInstruction encryptionInstruction) {
        HashMap map = new HashMap();
        map.put(Headers.MATERIALS_DESCRIPTION, JsonUtils.mapToString(encryptionInstruction.getMaterialsDescription()));
        map.put(Headers.CRYPTO_KEY, Base64.encodeAsString(encryptionInstruction.getEncryptedSymmetricKey()));
        map.put(Headers.CRYPTO_IV, Base64.encodeAsString(encryptionInstruction.getSymmetricCipher().getIV()));
        return map;
    }

    private static Map parseJSONInstruction(S3Object s3Object) {
        try {
            return JsonUtils.jsonToMap(convertStreamToString(s3Object.getObjectContent()));
        } catch (Exception e) {
            throw new AmazonClientException("Error parsing JSON instruction file: " + e.getMessage());
        }
    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    inputStream.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private static long getCipherBlockLowerBound(long j) {
        long j2 = (j - (j % 16)) - 16;
        if (j2 < 0) {
            return 0L;
        }
        return j2;
    }

    private static long getCipherBlockUpperBound(long j) {
        return j + (16 - (j % 16)) + 16;
    }
}
