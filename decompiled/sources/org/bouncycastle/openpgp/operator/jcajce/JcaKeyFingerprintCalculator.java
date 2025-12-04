package org.bouncycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;

/* loaded from: classes6.dex */
public class JcaKeyFingerprintCalculator implements KeyFingerPrintCalculator {
    private final JcaJceHelper helper;

    public JcaKeyFingerprintCalculator() {
        this(new DefaultJcaJceHelper());
    }

    private JcaKeyFingerprintCalculator(JcaJceHelper jcaJceHelper) {
        this.helper = jcaJceHelper;
    }

    @Override // org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator
    public byte[] calculateFingerprint(PublicKeyPacket publicKeyPacket) throws PGPException {
        BCPGKey key = publicKeyPacket.getKey();
        if (publicKeyPacket.getVersion() <= 3) {
            RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
            try {
                MessageDigest messageDigestCreateMessageDigest = this.helper.createMessageDigest(MessageDigestAlgorithms.MD5);
                byte[] encoded = new MPInteger(rSAPublicBCPGKey.getModulus()).getEncoded();
                messageDigestCreateMessageDigest.update(encoded, 2, encoded.length - 2);
                byte[] encoded2 = new MPInteger(rSAPublicBCPGKey.getPublicExponent()).getEncoded();
                messageDigestCreateMessageDigest.update(encoded2, 2, encoded2.length - 2);
                return messageDigestCreateMessageDigest.digest();
            } catch (IOException e) {
                throw new PGPException("can't encode key components: " + e.getMessage(), e);
            } catch (NoSuchAlgorithmException e2) {
                throw new PGPException("can't find MD5", e2);
            } catch (NoSuchProviderException e3) {
                throw new PGPException("can't find MD5", e3);
            }
        }
        try {
            byte[] encodedContents = publicKeyPacket.getEncodedContents();
            MessageDigest messageDigestCreateMessageDigest2 = this.helper.createMessageDigest("SHA1");
            messageDigestCreateMessageDigest2.update((byte) -103);
            messageDigestCreateMessageDigest2.update((byte) (encodedContents.length >> 8));
            messageDigestCreateMessageDigest2.update((byte) encodedContents.length);
            messageDigestCreateMessageDigest2.update(encodedContents);
            return messageDigestCreateMessageDigest2.digest();
        } catch (IOException e4) {
            throw new PGPException("can't encode key components: " + e4.getMessage(), e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new PGPException("can't find SHA1", e5);
        } catch (NoSuchProviderException e6) {
            throw new PGPException("can't find SHA1", e6);
        }
    }

    public JcaKeyFingerprintCalculator setProvider(String str) {
        return new JcaKeyFingerprintCalculator(new NamedJcaJceHelper(str));
    }

    public JcaKeyFingerprintCalculator setProvider(Provider provider) {
        return new JcaKeyFingerprintCalculator(new ProviderJcaJceHelper(provider));
    }
}
