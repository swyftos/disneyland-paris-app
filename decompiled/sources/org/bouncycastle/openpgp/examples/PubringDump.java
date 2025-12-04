package org.bouncycastle.openpgp.examples;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.security.Security;
import java.util.Iterator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes6.dex */
public class PubringDump {
    public static String getAlgorithm(int i) {
        if (i == 1) {
            return "RSA_GENERAL";
        }
        if (i == 2) {
            return "RSA_ENCRYPT";
        }
        if (i == 3) {
            return "RSA_SIGN";
        }
        switch (i) {
            case 16:
                return "ELGAMAL_ENCRYPT";
            case 17:
                return "DSA";
            case 18:
                return "ECDH";
            case 19:
                return "ECDSA";
            case 20:
                return "ELGAMAL_GENERAL";
            case 21:
                return "DIFFIE_HELLMAN";
            default:
                return "unknown";
        }
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Iterator<PGPPublicKeyRing> keyRings = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(new FileInputStream(strArr[0])), new JcaKeyFingerprintCalculator()).getKeyRings();
        while (keyRings.hasNext()) {
            PGPPublicKeyRing next = keyRings.next();
            try {
                next.getPublicKey();
                Iterator<PGPPublicKey> publicKeys = next.getPublicKeys();
                boolean z = true;
                while (publicKeys.hasNext()) {
                    PGPPublicKey next2 = publicKeys.next();
                    if (z) {
                        System.out.println("Key ID: " + Long.toHexString(next2.getKeyID()));
                        z = false;
                    } else {
                        System.out.println("Key ID: " + Long.toHexString(next2.getKeyID()) + " (subkey)");
                    }
                    PrintStream printStream = System.out;
                    printStream.println("            Algorithm: " + getAlgorithm(next2.getAlgorithm()));
                    printStream.println("            Fingerprint: " + new String(Hex.encode(next2.getFingerprint())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
