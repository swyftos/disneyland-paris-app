package org.bouncycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.DSAPublicBCPGKey;
import org.bouncycastle.bcpg.DSASecretBCPGKey;
import org.bouncycastle.bcpg.ECDHPublicBCPGKey;
import org.bouncycastle.bcpg.ECDSAPublicBCPGKey;
import org.bouncycastle.bcpg.ECPublicBCPGKey;
import org.bouncycastle.bcpg.ECSecretBCPGKey;
import org.bouncycastle.bcpg.EdDSAPublicBCPGKey;
import org.bouncycastle.bcpg.EdSecretBCPGKey;
import org.bouncycastle.bcpg.ElGamalPublicBCPGKey;
import org.bouncycastle.bcpg.ElGamalSecretBCPGKey;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.bcpg.RSASecretBCPGKey;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.openpgp.PGPAlgorithmParameters;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKdfParameters;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes6.dex */
public class JcaPGPKeyConverter {
    private static final PGPKdfParameters DEFAULT_KDF_PARAMETERS = new PGPKdfParameters(8, 7);
    private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    private KeyFingerPrintCalculator fingerPrintCalculator = new JcaKeyFingerprintCalculator();

    private ECParameterSpec getECParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return getECParameterSpec(aSN1ObjectIdentifier, JcaJcePGPUtil.getX9Parameters(aSN1ObjectIdentifier));
    }

    private ECParameterSpec getECParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParameters x9ECParameters) throws InvalidParameterSpecException {
        AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.helper.createAlgorithmParameters("EC");
        algorithmParametersCreateAlgorithmParameters.init(new ECGenParameterSpec(ECNamedCurveTable.getName(aSN1ObjectIdentifier)));
        return (ECParameterSpec) algorithmParametersCreateAlgorithmParameters.getParameterSpec(ECParameterSpec.class);
    }

    private BCPGKey getPrivateBCPGKey(PGPPublicKey pGPPublicKey, PrivateKey privateKey) throws PGPException {
        int algorithm = pGPPublicKey.getAlgorithm();
        if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) privateKey;
            return new RSASecretBCPGKey(rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ());
        }
        if (algorithm == 22) {
            try {
                return new EdSecretBCPGKey(new BigInteger(1, ASN1OctetString.getInstance(PrivateKeyInfo.getInstance(privateKey.getEncoded()).parsePrivateKey()).getOctets()));
            } catch (IOException e) {
                throw new PGPException(e.getMessage(), e);
            }
        }
        switch (algorithm) {
            case 16:
            case 20:
                return new ElGamalSecretBCPGKey(((DHPrivateKey) privateKey).getX());
            case 17:
                return new DSASecretBCPGKey(((DSAPrivateKey) privateKey).getX());
            case 18:
                if (privateKey instanceof ECPrivateKey) {
                    return new ECSecretBCPGKey(((ECPrivateKey) privateKey).getS());
                }
                try {
                    return new ECSecretBCPGKey(new BigInteger(1, Arrays.reverse(ASN1OctetString.getInstance(PrivateKeyInfo.getInstance(privateKey.getEncoded()).parsePrivateKey()).getOctets())));
                } catch (IOException e2) {
                    throw new PGPException(e2.getMessage(), e2);
                }
            case 19:
                return new ECSecretBCPGKey(((ECPrivateKey) privateKey).getS());
            default:
                throw new PGPException("unknown key class");
        }
    }

    private BCPGKey getPublicBCPGKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, PublicKey publicKey, Date date) throws PGPException {
        if (publicKey instanceof RSAPublicKey) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
            return new RSAPublicBCPGKey(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        if (publicKey instanceof DSAPublicKey) {
            DSAPublicKey dSAPublicKey = (DSAPublicKey) publicKey;
            DSAParams params = dSAPublicKey.getParams();
            return new DSAPublicBCPGKey(params.getP(), params.getQ(), params.getG(), dSAPublicKey.getY());
        }
        if (publicKey instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            DHParameterSpec params2 = dHPublicKey.getParams();
            return new ElGamalPublicBCPGKey(params2.getP(), params2.getG(), dHPublicKey.getY());
        }
        if (publicKey instanceof ECPublicKey) {
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            X9ECParameters byOID = ECNamedCurveTable.getByOID(aSN1ObjectIdentifier);
            X9ECPoint x9ECPoint = new X9ECPoint(byOID.getCurve(), new DEROctetString(subjectPublicKeyInfo.getPublicKeyData().getBytes()));
            if (i == 18) {
                PGPKdfParameters pGPKdfParametersImplGetKdfParameters = implGetKdfParameters(pGPAlgorithmParameters);
                return new ECDHPublicBCPGKey(aSN1ObjectIdentifier, x9ECPoint.getPoint(), pGPKdfParametersImplGetKdfParameters.getHashAlgorithm(), pGPKdfParametersImplGetKdfParameters.getSymmetricWrapAlgorithm());
            }
            if (i == 19) {
                return new ECDSAPublicBCPGKey(aSN1ObjectIdentifier, x9ECPoint.getPoint());
            }
            throw new PGPException("unknown EC algorithm");
        }
        if (publicKey.getAlgorithm().regionMatches(true, 0, "ED2", 0, 3)) {
            SubjectPublicKeyInfo subjectPublicKeyInfo2 = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
            byte[] bArr = new byte[33];
            bArr[0] = 64;
            System.arraycopy(subjectPublicKeyInfo2.getPublicKeyData().getBytes(), 0, bArr, 1, 32);
            return new EdDSAPublicBCPGKey(GNUObjectIdentifiers.Ed25519, new BigInteger(1, bArr));
        }
        if (!publicKey.getAlgorithm().regionMatches(true, 0, "X2", 0, 2)) {
            throw new PGPException("unknown key class");
        }
        SubjectPublicKeyInfo subjectPublicKeyInfo3 = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
        byte[] bArr2 = new byte[33];
        bArr2[0] = 64;
        System.arraycopy(subjectPublicKeyInfo3.getPublicKeyData().getBytes(), 0, bArr2, 1, 32);
        PGPKdfParameters pGPKdfParametersImplGetKdfParameters2 = implGetKdfParameters(pGPAlgorithmParameters);
        return new ECDHPublicBCPGKey(CryptlibObjectIdentifiers.curvey25519, new BigInteger(1, bArr2), pGPKdfParametersImplGetKdfParameters2.getHashAlgorithm(), pGPKdfParametersImplGetKdfParameters2.getSymmetricWrapAlgorithm());
    }

    private PrivateKey implGeneratePrivate(String str, KeySpec keySpec) {
        return this.helper.createKeyFactory(str).generatePrivate(keySpec);
    }

    private PublicKey implGeneratePublic(String str, KeySpec keySpec) {
        return this.helper.createKeyFactory(str).generatePublic(keySpec);
    }

    private PGPKdfParameters implGetKdfParameters(PGPAlgorithmParameters pGPAlgorithmParameters) {
        return pGPAlgorithmParameters == null ? DEFAULT_KDF_PARAMETERS : (PGPKdfParameters) pGPAlgorithmParameters;
    }

    private PrivateKey implGetPrivateKeyEC(String str, ECPublicBCPGKey eCPublicBCPGKey, ECSecretBCPGKey eCSecretBCPGKey) {
        return implGeneratePrivate(str, new ECPrivateKeySpec(eCSecretBCPGKey.getX(), getECParameterSpec(eCPublicBCPGKey.getCurveOID())));
    }

    private PrivateKey implGetPrivateKeyPKCS8(String str, PrivateKeyInfo privateKeyInfo) {
        return implGeneratePrivate(str, new PKCS8EncodedKeySpec(privateKeyInfo.getEncoded()));
    }

    private PublicKey implGetPublicKeyEC(String str, ECPublicBCPGKey eCPublicBCPGKey) {
        ASN1ObjectIdentifier curveOID = eCPublicBCPGKey.getCurveOID();
        X9ECParameters x9Parameters = JcaJcePGPUtil.getX9Parameters(curveOID);
        ECPoint eCPointDecodePoint = JcaJcePGPUtil.decodePoint(eCPublicBCPGKey.getEncodedPoint(), x9Parameters.getCurve());
        return implGeneratePublic(str, new ECPublicKeySpec(new java.security.spec.ECPoint(eCPointDecodePoint.getAffineXCoord().toBigInteger(), eCPointDecodePoint.getAffineYCoord().toBigInteger()), getECParameterSpec(curveOID, x9Parameters)));
    }

    private PublicKey implGetPublicKeyX509(String str, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return implGeneratePublic(str, new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded()));
    }

    public PGPPrivateKey getPGPPrivateKey(PGPPublicKey pGPPublicKey, PrivateKey privateKey) throws PGPException {
        return new PGPPrivateKey(pGPPublicKey.getKeyID(), pGPPublicKey.getPublicKeyPacket(), getPrivateBCPGKey(pGPPublicKey, privateKey));
    }

    public PGPPublicKey getPGPPublicKey(int i, PublicKey publicKey, Date date) throws PGPException {
        return getPGPPublicKey(i, null, publicKey, date);
    }

    public PGPPublicKey getPGPPublicKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, PublicKey publicKey, Date date) throws PGPException {
        return new PGPPublicKey(new PublicKeyPacket(i, date, getPublicBCPGKey(i, pGPAlgorithmParameters, publicKey, date)), this.fingerPrintCalculator);
    }

    public PrivateKey getPrivateKey(PGPPrivateKey pGPPrivateKey) throws PGPException {
        if (pGPPrivateKey instanceof JcaPGPPrivateKey) {
            return ((JcaPGPPrivateKey) pGPPrivateKey).getPrivateKey();
        }
        PublicKeyPacket publicKeyPacket = pGPPrivateKey.getPublicKeyPacket();
        BCPGKey privateKeyDataPacket = pGPPrivateKey.getPrivateKeyDataPacket();
        try {
            int algorithm = publicKeyPacket.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                RSASecretBCPGKey rSASecretBCPGKey = (RSASecretBCPGKey) privateKeyDataPacket;
                return implGeneratePrivate("RSA", new RSAPrivateCrtKeySpec(rSASecretBCPGKey.getModulus(), ((RSAPublicBCPGKey) publicKeyPacket.getKey()).getPublicExponent(), rSASecretBCPGKey.getPrivateExponent(), rSASecretBCPGKey.getPrimeP(), rSASecretBCPGKey.getPrimeQ(), rSASecretBCPGKey.getPrimeExponentP(), rSASecretBCPGKey.getPrimeExponentQ(), rSASecretBCPGKey.getCrtCoefficient()));
            }
            if (algorithm == 22) {
                return implGetPrivateKeyPKCS8("EdDSA", new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), new DEROctetString(BigIntegers.asUnsignedByteArray(((EdSecretBCPGKey) privateKeyDataPacket).getX()))));
            }
            switch (algorithm) {
                case 16:
                case 20:
                    ElGamalPublicBCPGKey elGamalPublicBCPGKey = (ElGamalPublicBCPGKey) publicKeyPacket.getKey();
                    return implGeneratePrivate("ElGamal", new DHPrivateKeySpec(((ElGamalSecretBCPGKey) privateKeyDataPacket).getX(), elGamalPublicBCPGKey.getP(), elGamalPublicBCPGKey.getG()));
                case 17:
                    DSAPublicBCPGKey dSAPublicBCPGKey = (DSAPublicBCPGKey) publicKeyPacket.getKey();
                    return implGeneratePrivate("DSA", new DSAPrivateKeySpec(((DSASecretBCPGKey) privateKeyDataPacket).getX(), dSAPublicBCPGKey.getP(), dSAPublicBCPGKey.getQ(), dSAPublicBCPGKey.getG()));
                case 18:
                    ECDHPublicBCPGKey eCDHPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.getKey();
                    ECSecretBCPGKey eCSecretBCPGKey = (ECSecretBCPGKey) privateKeyDataPacket;
                    return CryptlibObjectIdentifiers.curvey25519.equals((ASN1Primitive) eCDHPublicBCPGKey.getCurveOID()) ? implGetPrivateKeyPKCS8("XDH", new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X25519), new DEROctetString(Arrays.reverse(BigIntegers.asUnsignedByteArray(eCSecretBCPGKey.getX()))))) : implGetPrivateKeyEC("ECDH", eCDHPublicBCPGKey, eCSecretBCPGKey);
                case 19:
                    return implGetPrivateKeyEC("ECDSA", (ECDSAPublicBCPGKey) publicKeyPacket.getKey(), (ECSecretBCPGKey) privateKeyDataPacket);
                default:
                    throw new PGPException("unknown public key algorithm encountered");
            }
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception constructing key", e2);
        }
    }

    public PublicKey getPublicKey(PGPPublicKey pGPPublicKey) throws PGPException {
        PublicKeyPacket publicKeyPacket = pGPPublicKey.getPublicKeyPacket();
        try {
            int algorithm = publicKeyPacket.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) publicKeyPacket.getKey();
                return implGeneratePublic("RSA", new RSAPublicKeySpec(rSAPublicBCPGKey.getModulus(), rSAPublicBCPGKey.getPublicExponent()));
            }
            if (algorithm == 22) {
                byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(((EdDSAPublicBCPGKey) publicKeyPacket.getKey()).getEncodedPoint());
                if (bArrAsUnsignedByteArray.length < 1 || 64 != bArrAsUnsignedByteArray[0]) {
                    throw new IllegalArgumentException("Invalid Ed25519 public key");
                }
                return implGetPublicKeyX509("EdDSA", new SubjectPublicKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), Arrays.copyOfRange(bArrAsUnsignedByteArray, 1, bArrAsUnsignedByteArray.length)));
            }
            switch (algorithm) {
                case 16:
                case 20:
                    ElGamalPublicBCPGKey elGamalPublicBCPGKey = (ElGamalPublicBCPGKey) publicKeyPacket.getKey();
                    return implGeneratePublic("ElGamal", new DHPublicKeySpec(elGamalPublicBCPGKey.getY(), elGamalPublicBCPGKey.getP(), elGamalPublicBCPGKey.getG()));
                case 17:
                    DSAPublicBCPGKey dSAPublicBCPGKey = (DSAPublicBCPGKey) publicKeyPacket.getKey();
                    return implGeneratePublic("DSA", new DSAPublicKeySpec(dSAPublicBCPGKey.getY(), dSAPublicBCPGKey.getP(), dSAPublicBCPGKey.getQ(), dSAPublicBCPGKey.getG()));
                case 18:
                    ECDHPublicBCPGKey eCDHPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.getKey();
                    if (!eCDHPublicBCPGKey.getCurveOID().equals((ASN1Primitive) CryptlibObjectIdentifiers.curvey25519)) {
                        return implGetPublicKeyEC("ECDH", eCDHPublicBCPGKey);
                    }
                    byte[] bArrAsUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(eCDHPublicBCPGKey.getEncodedPoint());
                    if (bArrAsUnsignedByteArray2.length < 1 || 64 != bArrAsUnsignedByteArray2[0]) {
                        throw new IllegalArgumentException("Invalid Curve25519 public key");
                    }
                    return implGetPublicKeyX509("XDH", new SubjectPublicKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X25519), Arrays.copyOfRange(bArrAsUnsignedByteArray2, 1, bArrAsUnsignedByteArray2.length)));
                case 19:
                    return implGetPublicKeyEC("ECDSA", (ECDSAPublicBCPGKey) publicKeyPacket.getKey());
                default:
                    throw new PGPException("unknown public key algorithm encountered");
            }
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("exception constructing public key", e2);
        }
    }

    public JcaPGPKeyConverter setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcaPGPKeyConverter setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
