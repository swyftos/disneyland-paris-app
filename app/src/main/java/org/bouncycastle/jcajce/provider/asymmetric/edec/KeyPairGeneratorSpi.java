package org.bouncycastle.jcajce.provider.asymmetric.edec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.generators.Ed25519KeyPairGenerator;
import org.bouncycastle.crypto.generators.Ed448KeyPairGenerator;
import org.bouncycastle.crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.crypto.generators.X448KeyPairGenerator;
import org.bouncycastle.crypto.params.Ed25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.Ed448KeyGenerationParameters;
import org.bouncycastle.crypto.params.X25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.X448KeyGenerationParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class KeyPairGeneratorSpi extends java.security.KeyPairGeneratorSpi {
    private int algorithm;
    private AsymmetricCipherKeyPairGenerator generator;
    private boolean initialised;
    private SecureRandom secureRandom;

    public static final class Ed25519 extends KeyPairGeneratorSpi {
        public Ed25519() {
            super(1, new Ed25519KeyPairGenerator());
        }
    }

    public static final class Ed448 extends KeyPairGeneratorSpi {
        public Ed448() {
            super(0, new Ed448KeyPairGenerator());
        }
    }

    public static final class EdDSA extends KeyPairGeneratorSpi {
        public EdDSA() {
            super(-1, null);
        }
    }

    public static final class X25519 extends KeyPairGeneratorSpi {
        public X25519() {
            super(3, new X25519KeyPairGenerator());
        }
    }

    public static final class X448 extends KeyPairGeneratorSpi {
        public X448() {
            super(2, new X448KeyPairGenerator());
        }
    }

    public static final class XDH extends KeyPairGeneratorSpi {
        public XDH() {
            super(-2, null);
        }
    }

    KeyPairGeneratorSpi(int i, AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator) {
        this.algorithm = i;
        this.generator = asymmetricCipherKeyPairGenerator;
    }

    private void algorithmCheck(int i) throws InvalidAlgorithmParameterException {
        int i2 = this.algorithm;
        if (i2 != i) {
            if (i2 == 1 || i2 == 0) {
                throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
            }
            if (i2 == -1 && i != 1 && i != 0) {
                throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
            }
            if (i2 == 3 || i2 == 2) {
                throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
            }
            if (i2 == -2 && i != 3 && i != 2) {
                throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
            }
        }
    }

    private void initializeGenerator(String str) throws InvalidAlgorithmParameterException {
        int i;
        AsymmetricCipherKeyPairGenerator ed448KeyPairGenerator;
        if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed448) || str.equals(EdECObjectIdentifiers.id_Ed448.getId())) {
            i = 0;
            algorithmCheck(0);
            ed448KeyPairGenerator = new Ed448KeyPairGenerator();
        } else if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed25519) || str.equals(EdECObjectIdentifiers.id_Ed25519.getId())) {
            i = 1;
            algorithmCheck(1);
            ed448KeyPairGenerator = new Ed25519KeyPairGenerator();
        } else if (str.equalsIgnoreCase(XDHParameterSpec.X448) || str.equals(EdECObjectIdentifiers.id_X448.getId())) {
            i = 2;
            algorithmCheck(2);
            ed448KeyPairGenerator = new X448KeyPairGenerator();
        } else {
            if (!str.equalsIgnoreCase(XDHParameterSpec.X25519) && !str.equals(EdECObjectIdentifiers.id_X25519.getId())) {
                return;
            }
            i = 3;
            algorithmCheck(3);
            ed448KeyPairGenerator = new X25519KeyPairGenerator();
        }
        this.generator = ed448KeyPairGenerator;
        setupGenerator(i);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    private void setupGenerator(int i) {
        AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator;
        KeyGenerationParameters x25519KeyGenerationParameters;
        this.initialised = true;
        if (i == -2) {
            asymmetricCipherKeyPairGenerator = this.generator;
            x25519KeyGenerationParameters = new X25519KeyGenerationParameters(this.secureRandom);
        } else if (i == -1) {
            asymmetricCipherKeyPairGenerator = this.generator;
            x25519KeyGenerationParameters = new Ed25519KeyGenerationParameters(this.secureRandom);
        } else if (i == 0) {
            asymmetricCipherKeyPairGenerator = this.generator;
            x25519KeyGenerationParameters = new Ed448KeyGenerationParameters(this.secureRandom);
        } else if (i == 1) {
            asymmetricCipherKeyPairGenerator = this.generator;
            x25519KeyGenerationParameters = new Ed25519KeyGenerationParameters(this.secureRandom);
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            asymmetricCipherKeyPairGenerator = this.generator;
            x25519KeyGenerationParameters = new X25519KeyGenerationParameters(this.secureRandom);
        } else {
            asymmetricCipherKeyPairGenerator = this.generator;
            x25519KeyGenerationParameters = new X448KeyGenerationParameters(this.secureRandom);
        }
        asymmetricCipherKeyPairGenerator.init(x25519KeyGenerationParameters);
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.generator == null) {
            throw new IllegalStateException("generator not correctly initialized");
        }
        if (!this.initialised) {
            setupGenerator(this.algorithm);
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.generator.generateKeyPair();
        int i = this.algorithm;
        return (i == -2 || i == 2 || i == 3) ? new KeyPair(new BCXDHPublicKey(asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCXDHPrivateKey(asymmetricCipherKeyPairGenerateKeyPair.getPrivate())) : new KeyPair(new BCEdDSAPublicKey(asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCEdDSAPrivateKey(asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        int i2;
        this.secureRandom = secureRandom;
        try {
            if (i == 255 || i == 256) {
                int i3 = this.algorithm;
                i2 = 3;
                if (i3 != -2) {
                    if (i3 == -1 || i3 == 1) {
                        algorithmCheck(1);
                        this.generator = new Ed25519KeyPairGenerator();
                        setupGenerator(1);
                        return;
                    } else if (i3 != 3) {
                        throw new InvalidParameterException("key size not configurable");
                    }
                }
                algorithmCheck(3);
                this.generator = new X25519KeyPairGenerator();
            } else {
                if (i != 448) {
                    throw new InvalidParameterException("unknown key size");
                }
                int i4 = this.algorithm;
                i2 = 2;
                if (i4 != -2) {
                    if (i4 == -1 || i4 == 0) {
                        algorithmCheck(0);
                        this.generator = new Ed448KeyPairGenerator();
                        setupGenerator(0);
                        return;
                    } else if (i4 != 2) {
                        throw new InvalidParameterException("key size not configurable");
                    }
                }
                algorithmCheck(2);
                this.generator = new X448KeyPairGenerator();
            }
            setupGenerator(i2);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String curveName;
        this.secureRandom = secureRandom;
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            curveName = ((ECGenParameterSpec) algorithmParameterSpec).getName();
        } else if (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec) {
            curveName = ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getName();
        } else if (algorithmParameterSpec instanceof EdDSAParameterSpec) {
            curveName = ((EdDSAParameterSpec) algorithmParameterSpec).getCurveName();
        } else {
            if (!(algorithmParameterSpec instanceof XDHParameterSpec)) {
                String nameFrom = ECUtil.getNameFrom(algorithmParameterSpec);
                if (nameFrom != null) {
                    initializeGenerator(nameFrom);
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid parameterSpec: " + algorithmParameterSpec);
            }
            curveName = ((XDHParameterSpec) algorithmParameterSpec).getCurveName();
        }
        initializeGenerator(curveName);
    }
}
