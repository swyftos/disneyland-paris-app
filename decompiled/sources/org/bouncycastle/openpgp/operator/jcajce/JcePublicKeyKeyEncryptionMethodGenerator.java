package org.bouncycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.bcpg.ECDHPublicBCPGKey;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.PGPPad;
import org.bouncycastle.openpgp.operator.PublicKeyKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.RFC6637Utils;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class JcePublicKeyKeyEncryptionMethodGenerator extends PublicKeyKeyEncryptionMethodGenerator {
    private OperatorHelper helper;
    private JcaPGPKeyConverter keyConverter;
    private SecureRandom random;

    public JcePublicKeyKeyEncryptionMethodGenerator(PGPPublicKey pGPPublicKey) {
        super(pGPPublicKey);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.keyConverter = new JcaPGPKeyConverter();
    }

    private byte[] encryptSessionInfo(ECDHPublicBCPGKey eCDHPublicBCPGKey, byte[] bArr, Key key, byte[] bArr2) throws IllegalBlockSizeException, InvalidKeyException, IOException, PGPException {
        byte[] bArrPadSessionData = PGPPad.padSessionData(bArr, this.sessionKeyObfuscation);
        Cipher cipherCreateKeyWrapper = this.helper.createKeyWrapper(eCDHPublicBCPGKey.getSymmetricKeyAlgorithm());
        cipherCreateKeyWrapper.init(3, key, this.random);
        byte[] bArrWrap = cipherCreateKeyWrapper.wrap(new SecretKeySpec(bArrPadSessionData, PGPUtil.getSymmetricCipherName(bArr[0])));
        byte[] encoded = new MPInteger(new BigInteger(1, bArr2)).getEncoded();
        byte[] bArr3 = new byte[encoded.length + 1 + bArrWrap.length];
        System.arraycopy(encoded, 0, bArr3, 0, encoded.length);
        bArr3[encoded.length] = (byte) bArrWrap.length;
        System.arraycopy(bArrWrap, 0, bArr3, encoded.length + 1, bArrWrap.length);
        return bArr3;
    }

    @Override // org.bouncycastle.openpgp.operator.PublicKeyKeyEncryptionMethodGenerator
    protected byte[] encryptSessionInfo(PGPPublicKey pGPPublicKey, byte[] bArr) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, IOException, PGPException, InvalidAlgorithmParameterException {
        try {
            PublicKey publicKey = this.keyConverter.getPublicKey(pGPPublicKey);
            if (pGPPublicKey.getAlgorithm() != 18) {
                Cipher cipherCreatePublicKeyCipher = this.helper.createPublicKeyCipher(pGPPublicKey.getAlgorithm());
                cipherCreatePublicKeyCipher.init(1, publicKey, this.random);
                return cipherCreatePublicKeyCipher.doFinal(bArr);
            }
            PublicKeyPacket publicKeyPacket = pGPPublicKey.getPublicKeyPacket();
            ECDHPublicBCPGKey eCDHPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.getKey();
            UserKeyingMaterialSpec userKeyingMaterialSpec = new UserKeyingMaterialSpec(RFC6637Utils.createUserKeyingMaterial(publicKeyPacket, new JcaKeyFingerprintCalculator()));
            String id = RFC6637Utils.getKeyEncryptionOID(eCDHPublicBCPGKey.getSymmetricKeyAlgorithm()).getId();
            if (eCDHPublicBCPGKey.getCurveOID().equals((ASN1Primitive) CryptlibObjectIdentifiers.curvey25519)) {
                KeyPairGenerator keyPairGeneratorCreateKeyPairGenerator = this.helper.createKeyPairGenerator(XDHParameterSpec.X25519);
                keyPairGeneratorCreateKeyPairGenerator.initialize(255, this.random);
                KeyPair keyPairGenerateKeyPair = keyPairGeneratorCreateKeyPairGenerator.generateKeyPair();
                KeyAgreement keyAgreementCreateKeyAgreement = this.helper.createKeyAgreement(RFC6637Utils.getXDHAlgorithm(publicKeyPacket));
                keyAgreementCreateKeyAgreement.init(keyPairGenerateKeyPair.getPrivate(), userKeyingMaterialSpec);
                keyAgreementCreateKeyAgreement.doPhase(publicKey, true);
                return encryptSessionInfo(eCDHPublicBCPGKey, bArr, keyAgreementCreateKeyAgreement.generateSecret(id), Arrays.prepend(SubjectPublicKeyInfo.getInstance(keyPairGenerateKeyPair.getPublic().getEncoded()).getPublicKeyData().getBytes(), (byte) 64));
            }
            AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.helper.createAlgorithmParameters("EC");
            algorithmParametersCreateAlgorithmParameters.init(new X962Parameters(eCDHPublicBCPGKey.getCurveOID()).getEncoded());
            KeyPairGenerator keyPairGeneratorCreateKeyPairGenerator2 = this.helper.createKeyPairGenerator("EC");
            keyPairGeneratorCreateKeyPairGenerator2.initialize(algorithmParametersCreateAlgorithmParameters.getParameterSpec(AlgorithmParameterSpec.class), this.random);
            KeyPair keyPairGenerateKeyPair2 = keyPairGeneratorCreateKeyPairGenerator2.generateKeyPair();
            KeyAgreement keyAgreementCreateKeyAgreement2 = this.helper.createKeyAgreement(RFC6637Utils.getAgreementAlgorithm(publicKeyPacket));
            keyAgreementCreateKeyAgreement2.init(keyPairGenerateKeyPair2.getPrivate(), userKeyingMaterialSpec);
            keyAgreementCreateKeyAgreement2.doPhase(publicKey, true);
            SecretKey secretKeyGenerateSecret = keyAgreementCreateKeyAgreement2.generateSecret(id);
            byte[] bytes = SubjectPublicKeyInfo.getInstance(keyPairGenerateKeyPair2.getPublic().getEncoded()).getPublicKeyData().getBytes();
            if (bytes == null || bytes.length < 1 || bytes[0] != 4) {
                bytes = JcaJcePGPUtil.getX9Parameters(eCDHPublicBCPGKey.getCurveOID()).getCurve().decodePoint(bytes).getEncoded(false);
            }
            return encryptSessionInfo(eCDHPublicBCPGKey, bArr, secretKeyGenerateSecret, bytes);
        } catch (IOException e) {
            throw new PGPException("unable to encode MPI: " + e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            throw new PGPException("key invalid: " + e2.getMessage(), e2);
        } catch (BadPaddingException e3) {
            throw new PGPException("bad padding: " + e3.getMessage(), e3);
        } catch (IllegalBlockSizeException e4) {
            throw new PGPException("illegal block size: " + e4.getMessage(), e4);
        } catch (GeneralSecurityException e5) {
            throw new PGPException("unable to set up ephemeral keys: " + e5.getMessage(), e5);
        }
    }

    public JcePublicKeyKeyEncryptionMethodGenerator setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        this.keyConverter.setProvider(str);
        return this;
    }

    public JcePublicKeyKeyEncryptionMethodGenerator setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        this.keyConverter.setProvider(provider);
        return this;
    }

    public JcePublicKeyKeyEncryptionMethodGenerator setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
