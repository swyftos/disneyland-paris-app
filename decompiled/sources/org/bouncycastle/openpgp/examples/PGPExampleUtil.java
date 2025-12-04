package org.bouncycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

/* loaded from: classes6.dex */
abstract class PGPExampleUtil {
    static byte[] compressFile(String str, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(i);
        PGPUtil.writeFileToLiteralData(pGPCompressedDataGenerator.open(byteArrayOutputStream), 'b', new File(str));
        pGPCompressedDataGenerator.close();
        return byteArrayOutputStream.toByteArray();
    }

    static PGPPrivateKey findSecretKey(PGPSecretKeyRingCollection pGPSecretKeyRingCollection, long j, char[] cArr) throws PGPException {
        PGPSecretKey secretKey = pGPSecretKeyRingCollection.getSecretKey(j);
        if (secretKey == null) {
            return null;
        }
        return secretKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build(cArr));
    }

    static PGPPublicKey readPublicKey(InputStream inputStream) {
        Iterator<PGPPublicKeyRing> keyRings = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new JcaKeyFingerprintCalculator()).getKeyRings();
        while (keyRings.hasNext()) {
            Iterator<PGPPublicKey> publicKeys = keyRings.next().getPublicKeys();
            while (publicKeys.hasNext()) {
                PGPPublicKey next = publicKeys.next();
                if (next.isEncryptionKey()) {
                    return next;
                }
            }
        }
        throw new IllegalArgumentException("Can't find encryption key in key ring.");
    }

    static PGPPublicKey readPublicKey(String str) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        PGPPublicKey publicKey = readPublicKey(bufferedInputStream);
        bufferedInputStream.close();
        return publicKey;
    }

    static PGPSecretKey readSecretKey(InputStream inputStream) {
        Iterator<PGPSecretKeyRing> keyRings = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new JcaKeyFingerprintCalculator()).getKeyRings();
        while (keyRings.hasNext()) {
            Iterator<PGPSecretKey> secretKeys = keyRings.next().getSecretKeys();
            while (secretKeys.hasNext()) {
                PGPSecretKey next = secretKeys.next();
                if (next.isSigningKey()) {
                    return next;
                }
            }
        }
        throw new IllegalArgumentException("Can't find signing key in key ring.");
    }
}
