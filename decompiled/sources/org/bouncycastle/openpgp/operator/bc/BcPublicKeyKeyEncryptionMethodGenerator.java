package org.bouncycastle.openpgp.operator.bc;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.bcpg.ECDHPublicBCPGKey;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.agreement.X25519Agreement;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.X25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.operator.PGPPad;
import org.bouncycastle.openpgp.operator.PublicKeyKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.RFC6637Utils;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes6.dex */
public class BcPublicKeyKeyEncryptionMethodGenerator extends PublicKeyKeyEncryptionMethodGenerator {
    private BcPGPKeyConverter keyConverter;
    private SecureRandom random;

    public BcPublicKeyKeyEncryptionMethodGenerator(PGPPublicKey pGPPublicKey) {
        super(pGPPublicKey);
        this.keyConverter = new BcPGPKeyConverter();
    }

    private byte[] encryptSessionInfo(ECDHPublicBCPGKey eCDHPublicBCPGKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws IOException, PGPException {
        KeyParameter keyParameter = new KeyParameter(new RFC6637KDFCalculator(new BcPGPDigestCalculatorProvider().get(eCDHPublicBCPGKey.getHashAlgorithm()), eCDHPublicBCPGKey.getSymmetricKeyAlgorithm()).createKey(bArr2, bArr3));
        byte[] bArrPadSessionData = PGPPad.padSessionData(bArr, this.sessionKeyObfuscation);
        Wrapper wrapperCreateWrapper = BcImplProvider.createWrapper(eCDHPublicBCPGKey.getSymmetricKeyAlgorithm());
        wrapperCreateWrapper.init(true, new ParametersWithRandom(keyParameter, this.random));
        byte[] bArrWrap = wrapperCreateWrapper.wrap(bArrPadSessionData, 0, bArrPadSessionData.length);
        byte[] encoded = new MPInteger(new BigInteger(1, bArr4)).getEncoded();
        byte[] bArr5 = new byte[encoded.length + 1 + bArrWrap.length];
        System.arraycopy(encoded, 0, bArr5, 0, encoded.length);
        bArr5[encoded.length] = (byte) bArrWrap.length;
        System.arraycopy(bArrWrap, 0, bArr5, encoded.length + 1, bArrWrap.length);
        return bArr5;
    }

    @Override // org.bouncycastle.openpgp.operator.PublicKeyKeyEncryptionMethodGenerator
    protected byte[] encryptSessionInfo(PGPPublicKey pGPPublicKey, byte[] bArr) throws PGPException {
        try {
            AsymmetricKeyParameter publicKey = this.keyConverter.getPublicKey(pGPPublicKey);
            if (pGPPublicKey.getAlgorithm() != 18) {
                AsymmetricBlockCipher asymmetricBlockCipherCreatePublicKeyCipher = BcImplProvider.createPublicKeyCipher(pGPPublicKey.getAlgorithm());
                asymmetricBlockCipherCreatePublicKeyCipher.init(true, new ParametersWithRandom(publicKey, this.random));
                return asymmetricBlockCipherCreatePublicKeyCipher.processBlock(bArr, 0, bArr.length);
            }
            PublicKeyPacket publicKeyPacket = pGPPublicKey.getPublicKeyPacket();
            ECDHPublicBCPGKey eCDHPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.getKey();
            byte[] bArrCreateUserKeyingMaterial = RFC6637Utils.createUserKeyingMaterial(publicKeyPacket, new BcKeyFingerprintCalculator());
            if (!eCDHPublicBCPGKey.getCurveOID().equals((ASN1Primitive) CryptlibObjectIdentifiers.curvey25519)) {
                ECDomainParameters parameters = ((ECPublicKeyParameters) publicKey).getParameters();
                ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                eCKeyPairGenerator.init(new ECKeyGenerationParameters(parameters, this.random));
                AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = eCKeyPairGenerator.generateKeyPair();
                ECDHBasicAgreement eCDHBasicAgreement = new ECDHBasicAgreement();
                eCDHBasicAgreement.init(asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
                return encryptSessionInfo(eCDHPublicBCPGKey, bArr, BigIntegers.asUnsignedByteArray(eCDHBasicAgreement.getFieldSize(), eCDHBasicAgreement.calculateAgreement(publicKey)), bArrCreateUserKeyingMaterial, ((ECPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()).getQ().getEncoded(false));
            }
            X25519KeyPairGenerator x25519KeyPairGenerator = new X25519KeyPairGenerator();
            x25519KeyPairGenerator.init(new X25519KeyGenerationParameters(this.random));
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair2 = x25519KeyPairGenerator.generateKeyPair();
            X25519Agreement x25519Agreement = new X25519Agreement();
            x25519Agreement.init(asymmetricCipherKeyPairGenerateKeyPair2.getPrivate());
            byte[] bArr2 = new byte[x25519Agreement.getAgreementSize()];
            x25519Agreement.calculateAgreement(publicKey, bArr2, 0);
            byte[] bArr3 = new byte[33];
            bArr3[0] = 64;
            ((X25519PublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair2.getPublic()).encode(bArr3, 1);
            return encryptSessionInfo(eCDHPublicBCPGKey, bArr, bArr2, bArrCreateUserKeyingMaterial, bArr3);
        } catch (IOException e) {
            throw new PGPException("exception encrypting session info: " + e.getMessage(), e);
        } catch (InvalidCipherTextException e2) {
            throw new PGPException("exception encrypting session info: " + e2.getMessage(), e2);
        }
    }

    public BcPublicKeyKeyEncryptionMethodGenerator setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
