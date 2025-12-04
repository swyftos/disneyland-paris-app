package org.bouncycastle.openpgp.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPBEEncryptedData;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBEDataDecryptorFactoryBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes6.dex */
public class ByteArrayHandler {
    private static byte[] compress(byte[] bArr, String str, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(i);
        OutputStream outputStreamOpen = new PGPLiteralDataGenerator().open(pGPCompressedDataGenerator.open(byteArrayOutputStream), 'b', str, bArr.length, new Date());
        outputStreamOpen.write(bArr);
        outputStreamOpen.close();
        pGPCompressedDataGenerator.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decrypt(byte[] bArr, char[] cArr) throws IOException, PGPException, NoSuchProviderException {
        JcaPGPObjectFactory jcaPGPObjectFactory = new JcaPGPObjectFactory(PGPUtil.getDecoderStream(new ByteArrayInputStream(bArr)));
        Object objNextObject = jcaPGPObjectFactory.nextObject();
        if (!(objNextObject instanceof PGPEncryptedDataList)) {
            objNextObject = jcaPGPObjectFactory.nextObject();
        }
        return Streams.readAll(((PGPLiteralData) new JcaPGPObjectFactory(((PGPCompressedData) new JcaPGPObjectFactory(((PGPPBEEncryptedData) ((PGPEncryptedDataList) objNextObject).get(0)).getDataStream(new JcePBEDataDecryptorFactoryBuilder(new JcaPGPDigestCalculatorProviderBuilder().setProvider("BC").build()).setProvider("BC").build(cArr))).nextObject()).getDataStream()).nextObject()).getInputStream());
    }

    public static byte[] encrypt(byte[] bArr, char[] cArr, String str, int i, boolean z) throws IOException, PGPException, NoSuchProviderException {
        if (str == null) {
            str = "_CONSOLE";
        }
        byte[] bArrCompress = compress(bArr, str, 1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream armoredOutputStream = z ? new ArmoredOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
        PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(i).setSecureRandom(new SecureRandom()).setProvider("BC"));
        pGPEncryptedDataGenerator.addMethod(new JcePBEKeyEncryptionMethodGenerator(cArr).setProvider("BC"));
        OutputStream outputStreamOpen = pGPEncryptedDataGenerator.open(armoredOutputStream, bArrCompress.length);
        outputStreamOpen.write(bArrCompress);
        outputStreamOpen.close();
        if (z) {
            armoredOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        char[] charArray = "Dick Beck".toCharArray();
        byte[] bytes = "Hello world".getBytes();
        PrintStream printStream = System.out;
        printStream.println("Starting PGP test");
        byte[] bArrEncrypt = encrypt(bytes, charArray, "iway", 3, true);
        printStream.println("\nencrypted data = '" + new String(bArrEncrypt) + "'");
        printStream.println("\ndecrypted data = '" + new String(decrypt(bArrEncrypt, charArray)) + "'");
        byte[] bArrEncrypt2 = encrypt(bytes, charArray, "iway", 9, false);
        printStream.println("\nencrypted data = '" + new String(Hex.encode(bArrEncrypt2)) + "'");
        printStream.println("\ndecrypted data = '" + new String(decrypt(bArrEncrypt2, charArray)) + "'");
    }
}
