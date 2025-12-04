package org.bouncycastle.openpgp;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Date;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.DecoderException;

/* loaded from: classes6.dex */
public class PGPUtil implements HashAlgorithmTags {
    private static String defProvider = "BC";

    static class BufferedInputStreamExt extends BufferedInputStream {
        BufferedInputStreamExt(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
        public synchronized int available() {
            int iAvailable;
            iAvailable = super.available();
            if (iAvailable < 0) {
                iAvailable = Integer.MAX_VALUE;
            }
            return iAvailable;
        }
    }

    static MPInteger[] dsaSigToMpi(byte[] bArr) throws PGPException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(bArr);
            return new MPInteger[]{new MPInteger(ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue()), new MPInteger(ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue())};
        } catch (RuntimeException e) {
            throw new PGPException("exception decoding signature", e);
        }
    }

    public static InputStream getDecoderStream(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStreamExt(inputStream);
        }
        inputStream.mark(60);
        int i = inputStream.read();
        if ((i & 128) != 0) {
            inputStream.reset();
            return inputStream;
        }
        if (!isPossiblyBase64(i)) {
            inputStream.reset();
            return new ArmoredInputStream(inputStream);
        }
        byte[] bArr = new byte[60];
        bArr[0] = (byte) i;
        int i2 = 1;
        int i3 = 1;
        while (i2 != 60) {
            int i4 = inputStream.read();
            if (i4 < 0) {
                break;
            }
            if (!isPossiblyBase64(i4)) {
                inputStream.reset();
                return new ArmoredInputStream(inputStream);
            }
            if (i4 != 10 && i4 != 13) {
                bArr[i3] = (byte) i4;
                i3++;
            }
            i2++;
        }
        inputStream.reset();
        if (i2 < 4) {
            return new ArmoredInputStream(inputStream);
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        try {
            return (Base64.decode(bArr2)[0] & 128) != 0 ? new ArmoredInputStream(inputStream, false) : new ArmoredInputStream(inputStream);
        } catch (DecoderException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static String getDefaultProvider() {
        return defProvider;
    }

    public static String getDigestName(int i) throws PGPException {
        switch (i) {
            case 1:
                return MessageDigestAlgorithms.MD5;
            case 2:
                return "SHA1";
            case 3:
                return "RIPEMD160";
            case 4:
            case 7:
            default:
                throw new PGPException("unknown hash algorithm tag in getDigestName: " + i);
            case 5:
                return MessageDigestAlgorithms.MD2;
            case 6:
                return "TIGER";
            case 8:
                return "SHA256";
            case 9:
                return "SHA384";
            case 10:
                return "SHA512";
            case 11:
                return "SHA224";
        }
    }

    public static String getSignatureName(int i, int i2) throws PGPException {
        String str;
        if (i == 1 || i == 3) {
            str = "RSA";
        } else if (i == 20 || i == 16) {
            str = "ElGamal";
        } else {
            if (i != 17) {
                throw new PGPException("unknown algorithm tag in signature:" + i);
            }
            str = "DSA";
        }
        return getDigestName(i2) + "with" + str;
    }

    public static String getSymmetricCipherName(int i) {
        switch (i) {
            case 0:
                return null;
            case 1:
                return "IDEA";
            case 2:
                return "DESEDE";
            case 3:
                return "CAST5";
            case 4:
                return "Blowfish";
            case 5:
                return "SAFER";
            case 6:
                return "DES";
            case 7:
            case 8:
            case 9:
                return JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM;
            case 10:
                return "Twofish";
            case 11:
            case 12:
            case 13:
                return "Camellia";
            default:
                throw new IllegalArgumentException("unknown symmetric algorithm: " + i);
        }
    }

    public static boolean isKeyBox(byte[] bArr) throws IOException {
        if (bArr.length < 12) {
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        for (int i = 0; i != 8; i++) {
            byteArrayInputStream.read();
        }
        return byteArrayInputStream.read() == 75 && byteArrayInputStream.read() == 66 && byteArrayInputStream.read() == 88 && byteArrayInputStream.read() == 102;
    }

    public static boolean isKeyRing(byte[] bArr) throws IOException {
        int iNextPacketTag = new BCPGInputStream(new ByteArrayInputStream(bArr)).nextPacketTag();
        return iNextPacketTag == 6 || iNextPacketTag == 14 || iNextPacketTag == 5 || iNextPacketTag == 7;
    }

    private static boolean isPossiblyBase64(int i) {
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122) || ((i >= 48 && i <= 57) || i == 43 || i == 47 || i == 13 || i == 10);
    }

    public static byte[] makeRandomKey(int i, SecureRandom secureRandom) throws PGPException {
        int i2 = 192;
        switch (i) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 11:
                i2 = 128;
                break;
            case 2:
            case 8:
            case 12:
                break;
            case 6:
                i2 = 64;
                break;
            case 9:
            case 10:
            case 13:
                i2 = 256;
                break;
            default:
                throw new PGPException("unknown symmetric algorithm: " + i);
        }
        byte[] bArr = new byte[(i2 + 7) / 8];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    private static void pipeFileContents(File file, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    outputStream.close();
                    Arrays.fill(bArr, (byte) 0);
                    try {
                        fileInputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                outputStream.write(bArr, 0, i2);
            } catch (Throwable th) {
                Arrays.fill(bArr, (byte) 0);
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
    }

    public static void setDefaultProvider(String str) {
        defProvider = str;
    }

    public static void writeFileToLiteralData(OutputStream outputStream, char c, File file) throws IOException {
        pipeFileContents(file, new PGPLiteralDataGenerator().open(outputStream, c, file), 32768);
    }

    public static void writeFileToLiteralData(OutputStream outputStream, char c, File file, byte[] bArr) throws IOException {
        pipeFileContents(file, new PGPLiteralDataGenerator().open(outputStream, c, file.getName(), new Date(file.lastModified()), bArr), bArr.length);
    }
}
