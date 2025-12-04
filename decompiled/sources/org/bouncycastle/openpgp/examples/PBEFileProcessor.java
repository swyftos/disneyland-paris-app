package org.bouncycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.security.Security;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPPBEEncryptedData;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBEDataDecryptorFactoryBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes6.dex */
public class PBEFileProcessor {
    private static void decryptFile(InputStream inputStream, char[] cArr) throws IOException {
        PrintStream printStream;
        String str;
        JcaPGPObjectFactory jcaPGPObjectFactory = new JcaPGPObjectFactory(PGPUtil.getDecoderStream(inputStream));
        Object objNextObject = jcaPGPObjectFactory.nextObject();
        if (!(objNextObject instanceof PGPEncryptedDataList)) {
            objNextObject = jcaPGPObjectFactory.nextObject();
        }
        PGPPBEEncryptedData pGPPBEEncryptedData = (PGPPBEEncryptedData) ((PGPEncryptedDataList) objNextObject).get(0);
        Object objNextObject2 = new JcaPGPObjectFactory(pGPPBEEncryptedData.getDataStream(new JcePBEDataDecryptorFactoryBuilder(new JcaPGPDigestCalculatorProviderBuilder().setProvider("BC").build()).setProvider("BC").build(cArr))).nextObject();
        if (objNextObject2 instanceof PGPCompressedData) {
            objNextObject2 = new JcaPGPObjectFactory(((PGPCompressedData) objNextObject2).getDataStream()).nextObject();
        }
        PGPLiteralData pGPLiteralData = (PGPLiteralData) objNextObject2;
        InputStream inputStream2 = pGPLiteralData.getInputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(pGPLiteralData.getFileName()));
        Streams.pipeAll(inputStream2, bufferedOutputStream);
        bufferedOutputStream.close();
        if (!pGPPBEEncryptedData.isIntegrityProtected()) {
            printStream = System.err;
            str = "no message integrity check";
        } else if (pGPPBEEncryptedData.verify()) {
            printStream = System.err;
            str = "message integrity check passed";
        } else {
            printStream = System.err;
            str = "message failed integrity check";
        }
        printStream.println(str);
    }

    private static void decryptFile(String str, char[] cArr) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        decryptFile(bufferedInputStream, cArr);
        bufferedInputStream.close();
    }

    private static void encryptFile(OutputStream outputStream, String str, char[] cArr, boolean z, boolean z2) throws IOException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        try {
            byte[] bArrCompressFile = PGPExampleUtil.compressFile(str, 1);
            PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(3).setWithIntegrityPacket(z2).setSecureRandom(new SecureRandom()).setProvider("BC"));
            pGPEncryptedDataGenerator.addMethod(new JcePBEKeyEncryptionMethodGenerator(cArr).setProvider("BC"));
            OutputStream outputStreamOpen = pGPEncryptedDataGenerator.open(outputStream, bArrCompressFile.length);
            outputStreamOpen.write(bArrCompressFile);
            outputStreamOpen.close();
            if (z) {
                outputStream.close();
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    private static void encryptFile(String str, String str2, char[] cArr, boolean z, boolean z2) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        encryptFile(bufferedOutputStream, str2, cArr, z, z2);
        bufferedOutputStream.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (!strArr[0].equals("-e")) {
            if (strArr[0].equals("-d")) {
                decryptFile(strArr[1], strArr[2].toCharArray());
                return;
            } else {
                System.err.println("usage: PBEFileProcessor -e [-ai]|-d file passPhrase");
                return;
            }
        }
        if (strArr[1].equals("-a") || strArr[1].equals("-ai") || strArr[1].equals("-ia")) {
            encryptFile(strArr[2] + ".asc", strArr[2], strArr[3].toCharArray(), true, strArr[1].indexOf(105) > 0);
            return;
        }
        if (strArr[1].equals("-i")) {
            encryptFile(strArr[2] + ".bpg", strArr[2], strArr[3].toCharArray(), false, true);
            return;
        }
        encryptFile(strArr[1] + ".bpg", strArr[1], strArr[2].toCharArray(), false, false);
    }
}
