package org.bouncycastle.openpgp.examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.util.Date;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyRingGenerator;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;

/* loaded from: classes6.dex */
public class DSAElGamalKeyRingGenerator {
    private static void exportKeyPair(OutputStream outputStream, OutputStream outputStream2, KeyPair keyPair, KeyPair keyPair2, String str, char[] cArr, boolean z) throws IOException, PGPException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        JcaPGPKeyPair jcaPGPKeyPair = new JcaPGPKeyPair(17, keyPair, new Date());
        JcaPGPKeyPair jcaPGPKeyPair2 = new JcaPGPKeyPair(16, keyPair2, new Date());
        PGPDigestCalculator pGPDigestCalculator = new JcaPGPDigestCalculatorProviderBuilder().build().get(2);
        PGPKeyRingGenerator pGPKeyRingGenerator = new PGPKeyRingGenerator(19, jcaPGPKeyPair, str, pGPDigestCalculator, null, null, new JcaPGPContentSignerBuilder(jcaPGPKeyPair.getPublicKey().getAlgorithm(), 2), new JcePBESecretKeyEncryptorBuilder(9, pGPDigestCalculator).setProvider("BC").build(cArr));
        pGPKeyRingGenerator.addSubKey(jcaPGPKeyPair2);
        pGPKeyRingGenerator.generateSecretKeyRing().encode(outputStream);
        outputStream.close();
        if (z) {
            outputStream2 = new ArmoredOutputStream(outputStream2);
        }
        pGPKeyRingGenerator.generatePublicKeyRing().encode(outputStream2);
        outputStream2.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr.length < 2) {
            System.out.println("DSAElGamalKeyRingGenerator [-a] identity passPhrase");
            System.exit(0);
        }
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA", "BC");
        keyPairGenerator.initialize(1024);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("ELGAMAL", "BC");
        keyPairGenerator2.initialize(new DHParameterSpec(new BigInteger("9494fec095f3b85ee286542b3836fc81a5dd0a0349b4c239dd38744d488cf8e31db8bcb7d33b41abb9e5a33cca9144b1cef332c94bf0573bf047a3aca98cdf3b", 16), new BigInteger("153d5d6172adb43045b68ae8e1de1070b6137005686d29d3d73a7749199681ee5b212c9b96bfdcfa5b20cd5e3fd2044895d609cf9b410b7a0f12ca1cb9a428cc", 16)));
        KeyPair keyPairGenerateKeyPair2 = keyPairGenerator2.generateKeyPair();
        if (!strArr[0].equals("-a")) {
            exportKeyPair(new FileOutputStream("secret.bpg"), new FileOutputStream("pub.bpg"), keyPairGenerateKeyPair, keyPairGenerateKeyPair2, strArr[0], strArr[1].toCharArray(), false);
            return;
        }
        if (strArr.length < 3) {
            System.out.println("DSAElGamalKeyRingGenerator [-a] identity passPhrase");
            System.exit(0);
        }
        exportKeyPair(new FileOutputStream("secret.asc"), new FileOutputStream("pub.asc"), keyPairGenerateKeyPair, keyPairGenerateKeyPair2, strArr[1], strArr[2].toCharArray(), true);
    }
}
