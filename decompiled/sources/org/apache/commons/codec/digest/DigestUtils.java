package org.apache.commons.codec.digest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: classes6.dex */
public class DigestUtils {
    private final MessageDigest messageDigest;

    public static byte[] digest(MessageDigest messageDigest, byte[] bArr) {
        return messageDigest.digest(bArr);
    }

    public static byte[] digest(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        messageDigest.update(byteBuffer);
        return messageDigest.digest();
    }

    public static byte[] digest(MessageDigest messageDigest, File file) throws IOException {
        return updateDigest(messageDigest, file).digest();
    }

    public static byte[] digest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        return updateDigest(messageDigest, inputStream).digest();
    }

    public static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static MessageDigest getDigest(String str, MessageDigest messageDigest) {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            return messageDigest;
        }
    }

    public static MessageDigest getMd2Digest() {
        return getDigest(MessageDigestAlgorithms.MD2);
    }

    public static MessageDigest getMd5Digest() {
        return getDigest(MessageDigestAlgorithms.MD5);
    }

    public static MessageDigest getSha1Digest() {
        return getDigest("SHA-1");
    }

    public static MessageDigest getSha256Digest() {
        return getDigest("SHA-256");
    }

    public static MessageDigest getSha3_224Digest() {
        return getDigest(MessageDigestAlgorithms.SHA3_224);
    }

    public static MessageDigest getSha3_256Digest() {
        return getDigest("SHA3-256");
    }

    public static MessageDigest getSha3_384Digest() {
        return getDigest(MessageDigestAlgorithms.SHA3_384);
    }

    public static MessageDigest getSha3_512Digest() {
        return getDigest(MessageDigestAlgorithms.SHA3_512);
    }

    public static MessageDigest getSha384Digest() {
        return getDigest("SHA-384");
    }

    public static MessageDigest getSha512Digest() {
        return getDigest("SHA-512");
    }

    @Deprecated
    public static MessageDigest getShaDigest() {
        return getSha1Digest();
    }

    public static boolean isAvailable(String str) {
        return getDigest(str, null) != null;
    }

    public static byte[] md2(byte[] bArr) {
        return getMd2Digest().digest(bArr);
    }

    public static byte[] md2(InputStream inputStream) throws IOException {
        return digest(getMd2Digest(), inputStream);
    }

    public static byte[] md2(String str) {
        return md2(StringUtils.getBytesUtf8(str));
    }

    public static String md2Hex(byte[] bArr) {
        return Hex.encodeHexString(md2(bArr));
    }

    public static String md2Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(md2(inputStream));
    }

    public static String md2Hex(String str) {
        return Hex.encodeHexString(md2(str));
    }

    public static byte[] md5(byte[] bArr) {
        return getMd5Digest().digest(bArr);
    }

    public static byte[] md5(InputStream inputStream) throws IOException {
        return digest(getMd5Digest(), inputStream);
    }

    public static byte[] md5(String str) {
        return md5(StringUtils.getBytesUtf8(str));
    }

    public static String md5Hex(byte[] bArr) {
        return Hex.encodeHexString(md5(bArr));
    }

    public static String md5Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(md5(inputStream));
    }

    public static String md5Hex(String str) {
        return Hex.encodeHexString(md5(str));
    }

    @Deprecated
    public static byte[] sha(byte[] bArr) {
        return sha1(bArr);
    }

    @Deprecated
    public static byte[] sha(InputStream inputStream) throws IOException {
        return sha1(inputStream);
    }

    @Deprecated
    public static byte[] sha(String str) {
        return sha1(str);
    }

    public static byte[] sha1(byte[] bArr) {
        return getSha1Digest().digest(bArr);
    }

    public static byte[] sha1(InputStream inputStream) throws IOException {
        return digest(getSha1Digest(), inputStream);
    }

    public static byte[] sha1(String str) {
        return sha1(StringUtils.getBytesUtf8(str));
    }

    public static String sha1Hex(byte[] bArr) {
        return Hex.encodeHexString(sha1(bArr));
    }

    public static String sha1Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha1(inputStream));
    }

    public static String sha1Hex(String str) {
        return Hex.encodeHexString(sha1(str));
    }

    public static byte[] sha256(byte[] bArr) {
        return getSha256Digest().digest(bArr);
    }

    public static byte[] sha256(InputStream inputStream) throws IOException {
        return digest(getSha256Digest(), inputStream);
    }

    public static byte[] sha256(String str) {
        return sha256(StringUtils.getBytesUtf8(str));
    }

    public static String sha256Hex(byte[] bArr) {
        return Hex.encodeHexString(sha256(bArr));
    }

    public static String sha256Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha256(inputStream));
    }

    public static String sha256Hex(String str) {
        return Hex.encodeHexString(sha256(str));
    }

    public static byte[] sha3_224(byte[] bArr) {
        return getSha3_224Digest().digest(bArr);
    }

    public static byte[] sha3_224(InputStream inputStream) throws IOException {
        return digest(getSha3_224Digest(), inputStream);
    }

    public static byte[] sha3_224(String str) {
        return sha3_224(StringUtils.getBytesUtf8(str));
    }

    public static String sha3_224Hex(String str) {
        return Hex.encodeHexString(sha3_224(str));
    }

    public static byte[] sha3_256(byte[] bArr) {
        return getSha3_256Digest().digest(bArr);
    }

    public static byte[] sha3_256(InputStream inputStream) throws IOException {
        return digest(getSha3_256Digest(), inputStream);
    }

    public static byte[] sha3_256(String str) {
        return sha3_256(StringUtils.getBytesUtf8(str));
    }

    public static String sha3_256Hex(String str) {
        return Hex.encodeHexString(sha3_256(str));
    }

    public static byte[] sha3_384(byte[] bArr) {
        return getSha3_384Digest().digest(bArr);
    }

    public static byte[] sha3_384(InputStream inputStream) throws IOException {
        return digest(getSha3_384Digest(), inputStream);
    }

    public static byte[] sha3_384(String str) {
        return sha3_384(StringUtils.getBytesUtf8(str));
    }

    public static String sha3_384Hex(String str) {
        return Hex.encodeHexString(sha3_384(str));
    }

    public static byte[] sha3_512(byte[] bArr) {
        return getSha3_512Digest().digest(bArr);
    }

    public static byte[] sha3_512(InputStream inputStream) throws IOException {
        return digest(getSha3_512Digest(), inputStream);
    }

    public static byte[] sha3_512(String str) {
        return sha3_512(StringUtils.getBytesUtf8(str));
    }

    public static String sha3_512Hex(String str) {
        return Hex.encodeHexString(sha3_512(str));
    }

    public static byte[] sha384(byte[] bArr) {
        return getSha384Digest().digest(bArr);
    }

    public static byte[] sha384(InputStream inputStream) throws IOException {
        return digest(getSha384Digest(), inputStream);
    }

    public static byte[] sha384(String str) {
        return sha384(StringUtils.getBytesUtf8(str));
    }

    public static String sha384Hex(byte[] bArr) {
        return Hex.encodeHexString(sha384(bArr));
    }

    public static String sha384Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha384(inputStream));
    }

    public static String sha384Hex(String str) {
        return Hex.encodeHexString(sha384(str));
    }

    public static byte[] sha512(byte[] bArr) {
        return getSha512Digest().digest(bArr);
    }

    public static byte[] sha512(InputStream inputStream) throws IOException {
        return digest(getSha512Digest(), inputStream);
    }

    public static byte[] sha512(String str) {
        return sha512(StringUtils.getBytesUtf8(str));
    }

    public static String sha512Hex(byte[] bArr) {
        return Hex.encodeHexString(sha512(bArr));
    }

    public static String sha3_224Hex(byte[] bArr) {
        return Hex.encodeHexString(sha3_224(bArr));
    }

    public static String sha3_256Hex(byte[] bArr) {
        return Hex.encodeHexString(sha3_256(bArr));
    }

    public static String sha3_384Hex(byte[] bArr) {
        return Hex.encodeHexString(sha3_384(bArr));
    }

    public static String sha3_512Hex(byte[] bArr) {
        return Hex.encodeHexString(sha3_512(bArr));
    }

    public static String sha512Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha512(inputStream));
    }

    public static String sha3_224Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha3_224(inputStream));
    }

    public static String sha3_256Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha3_256(inputStream));
    }

    public static String sha3_384Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha3_384(inputStream));
    }

    public static String sha3_512Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha3_512(inputStream));
    }

    public static String sha512Hex(String str) {
        return Hex.encodeHexString(sha512(str));
    }

    @Deprecated
    public static String shaHex(byte[] bArr) {
        return sha1Hex(bArr);
    }

    @Deprecated
    public static String shaHex(InputStream inputStream) throws IOException {
        return sha1Hex(inputStream);
    }

    @Deprecated
    public static String shaHex(String str) {
        return sha1Hex(str);
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return messageDigest;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        messageDigest.update(byteBuffer);
        return messageDigest;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            MessageDigest messageDigestUpdateDigest = updateDigest(messageDigest, bufferedInputStream);
            bufferedInputStream.close();
            return messageDigestUpdateDigest;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int i = inputStream.read(bArr, 0, 1024);
        while (i > -1) {
            messageDigest.update(bArr, 0, i);
            i = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, String str) {
        messageDigest.update(StringUtils.getBytesUtf8(str));
        return messageDigest;
    }

    @Deprecated
    public DigestUtils() {
        this.messageDigest = null;
    }

    public DigestUtils(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    public DigestUtils(String str) {
        this(getDigest(str));
    }

    public byte[] digest(byte[] bArr) {
        return updateDigest(this.messageDigest, bArr).digest();
    }

    public byte[] digest(ByteBuffer byteBuffer) {
        return updateDigest(this.messageDigest, byteBuffer).digest();
    }

    public byte[] digest(File file) throws IOException {
        return updateDigest(this.messageDigest, file).digest();
    }

    public byte[] digest(InputStream inputStream) throws IOException {
        return updateDigest(this.messageDigest, inputStream).digest();
    }

    public byte[] digest(String str) {
        return updateDigest(this.messageDigest, str).digest();
    }

    public String digestAsHex(byte[] bArr) {
        return Hex.encodeHexString(digest(bArr));
    }

    public String digestAsHex(ByteBuffer byteBuffer) {
        return Hex.encodeHexString(digest(byteBuffer));
    }

    public String digestAsHex(File file) throws IOException {
        return Hex.encodeHexString(digest(file));
    }

    public String digestAsHex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(digest(inputStream));
    }

    public String digestAsHex(String str) {
        return Hex.encodeHexString(digest(str));
    }

    public MessageDigest getMessageDigest() {
        return this.messageDigest;
    }
}
