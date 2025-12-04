package org.bouncycastle.openpgp.examples;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.Security;
import java.util.Iterator;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class ClearSignedFileProcessor {
    private static int getLengthWithoutSeparatorOrTrailingWhitespace(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && isWhiteSpace(bArr[length])) {
            length--;
        }
        return length + 1;
    }

    private static int getLengthWithoutWhiteSpace(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && isWhiteSpace(bArr[length])) {
            length--;
        }
        return length + 1;
    }

    private static byte[] getLineSeparator() {
        String strLineSeparator = Strings.lineSeparator();
        int length = strLineSeparator.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) strLineSeparator.charAt(i);
        }
        return bArr;
    }

    private static boolean isLineEnding(byte b) {
        return b == 13 || b == 10;
    }

    private static boolean isWhiteSpace(byte b) {
        return isLineEnding(b) || b == 9 || b == 32;
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr[0].equals("-s")) {
            InputStream decoderStream = PGPUtil.getDecoderStream(new FileInputStream(strArr[2]));
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1] + ".asc");
            if (strArr.length == 4) {
                signFile(strArr[1], decoderStream, fileOutputStream, strArr[3].toCharArray(), "SHA1");
                return;
            } else {
                signFile(strArr[1], decoderStream, fileOutputStream, strArr[3].toCharArray(), strArr[4]);
                return;
            }
        }
        if (!strArr[0].equals("-v")) {
            System.err.println("usage: ClearSignedFileProcessor [-s file keyfile passPhrase]|[-v sigFile keyFile]");
            return;
        }
        if (strArr[1].indexOf(".asc") < 0) {
            System.err.println("file needs to end in \".asc\"");
            System.exit(1);
        }
        FileInputStream fileInputStream = new FileInputStream(strArr[1]);
        InputStream decoderStream2 = PGPUtil.getDecoderStream(new FileInputStream(strArr[2]));
        String str = strArr[1];
        verifyFile(fileInputStream, decoderStream2, str.substring(0, str.length() - 4));
    }

    private static void processLine(OutputStream outputStream, PGPSignatureGenerator pGPSignatureGenerator, byte[] bArr) throws IOException {
        int lengthWithoutWhiteSpace = getLengthWithoutWhiteSpace(bArr);
        if (lengthWithoutWhiteSpace > 0) {
            pGPSignatureGenerator.update(bArr, 0, lengthWithoutWhiteSpace);
        }
        outputStream.write(bArr, 0, bArr.length);
    }

    private static void processLine(PGPSignature pGPSignature, byte[] bArr) throws IOException {
        int lengthWithoutWhiteSpace = getLengthWithoutWhiteSpace(bArr);
        if (lengthWithoutWhiteSpace > 0) {
            pGPSignature.update(bArr, 0, lengthWithoutWhiteSpace);
        }
    }

    private static int readInputLine(ByteArrayOutputStream byteArrayOutputStream, int i, InputStream inputStream) throws IOException {
        byteArrayOutputStream.reset();
        int i2 = i;
        do {
            byteArrayOutputStream.write(i2);
            if (i2 == 13 || i2 == 10) {
                i = readPassedEOL(byteArrayOutputStream, i2, inputStream);
                break;
            }
            i2 = inputStream.read();
        } while (i2 >= 0);
        if (i2 < 0) {
            return -1;
        }
        return i;
    }

    private static int readInputLine(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) throws IOException {
        int i;
        byteArrayOutputStream.reset();
        do {
            i = inputStream.read();
            if (i < 0) {
                return -1;
            }
            byteArrayOutputStream.write(i);
            if (i == 13) {
                break;
            }
        } while (i != 10);
        return readPassedEOL(byteArrayOutputStream, i, inputStream);
    }

    private static int readPassedEOL(ByteArrayOutputStream byteArrayOutputStream, int i, InputStream inputStream) throws IOException {
        int i2 = inputStream.read();
        if (i != 13 || i2 != 10) {
            return i2;
        }
        byteArrayOutputStream.write(i2);
        return inputStream.read();
    }

    private static void signFile(String str, InputStream inputStream, OutputStream outputStream, char[] cArr, String str2) throws IOException, PGPException {
        int i = str2.equals("SHA256") ? 8 : str2.equals("SHA384") ? 9 : str2.equals("SHA512") ? 10 : str2.equals(MessageDigestAlgorithms.MD5) ? 1 : str2.equals("RIPEMD160") ? 3 : 2;
        PGPSecretKey secretKey = PGPExampleUtil.readSecretKey(inputStream);
        PGPPrivateKey pGPPrivateKeyExtractPrivateKey = secretKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build(cArr));
        PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(new JcaPGPContentSignerBuilder(secretKey.getPublicKey().getAlgorithm(), i).setProvider("BC"));
        PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator = new PGPSignatureSubpacketGenerator();
        pGPSignatureGenerator.init(1, pGPPrivateKeyExtractPrivateKey);
        Iterator<String> userIDs = secretKey.getPublicKey().getUserIDs();
        if (userIDs.hasNext()) {
            pGPSignatureSubpacketGenerator.setSignerUserID(false, userIDs.next());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketGenerator.generate());
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(outputStream);
        armoredOutputStream.beginClearText(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int inputLine = readInputLine(byteArrayOutputStream, bufferedInputStream);
        processLine(armoredOutputStream, pGPSignatureGenerator, byteArrayOutputStream.toByteArray());
        if (inputLine != -1) {
            do {
                inputLine = readInputLine(byteArrayOutputStream, inputLine, bufferedInputStream);
                pGPSignatureGenerator.update(Ascii.CR);
                pGPSignatureGenerator.update((byte) 10);
                processLine(armoredOutputStream, pGPSignatureGenerator, byteArrayOutputStream.toByteArray());
            } while (inputLine != -1);
        }
        bufferedInputStream.close();
        armoredOutputStream.endClearText();
        pGPSignatureGenerator.generate().encode(new BCPGOutputStream(armoredOutputStream));
        armoredOutputStream.close();
    }

    private static void verifyFile(InputStream inputStream, InputStream inputStream2, String str) throws IOException, PGPException {
        PrintStream printStream;
        String str2;
        ArmoredInputStream armoredInputStream = new ArmoredInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int inputLine = readInputLine(byteArrayOutputStream, armoredInputStream);
        byte[] lineSeparator = getLineSeparator();
        if (inputLine != -1 && armoredInputStream.isClearText()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedOutputStream.write(byteArray, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray));
            while (true) {
                bufferedOutputStream.write(lineSeparator);
                if (inputLine == -1 || !armoredInputStream.isClearText()) {
                    break;
                }
                inputLine = readInputLine(byteArrayOutputStream, inputLine, armoredInputStream);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                bufferedOutputStream.write(byteArray2, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray2));
            }
        } else if (inputLine != -1) {
            byte[] byteArray3 = byteArrayOutputStream.toByteArray();
            bufferedOutputStream.write(byteArray3, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray3));
            bufferedOutputStream.write(lineSeparator);
        }
        bufferedOutputStream.close();
        PGPPublicKeyRingCollection pGPPublicKeyRingCollection = new PGPPublicKeyRingCollection(inputStream2, new JcaKeyFingerprintCalculator());
        PGPSignature pGPSignature = ((PGPSignatureList) new JcaPGPObjectFactory(armoredInputStream).nextObject()).get(0);
        pGPSignature.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BC"), pGPPublicKeyRingCollection.getPublicKey(pGPSignature.getKeyID()));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        int inputLine2 = readInputLine(byteArrayOutputStream, bufferedInputStream);
        processLine(pGPSignature, byteArrayOutputStream.toByteArray());
        if (inputLine2 != -1) {
            do {
                inputLine2 = readInputLine(byteArrayOutputStream, inputLine2, bufferedInputStream);
                pGPSignature.update(Ascii.CR);
                pGPSignature.update((byte) 10);
                processLine(pGPSignature, byteArrayOutputStream.toByteArray());
            } while (inputLine2 != -1);
        }
        bufferedInputStream.close();
        if (pGPSignature.verify()) {
            printStream = System.out;
            str2 = "signature verified.";
        } else {
            printStream = System.out;
            str2 = "signature verification failed.";
        }
        printStream.println(str2);
    }
}
