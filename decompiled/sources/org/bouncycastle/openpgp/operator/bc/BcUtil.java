package org.bouncycastle.openpgp.operator.bc;

import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.openpgp.operator.PGPDataDecryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes6.dex */
abstract class BcUtil {
    public static PGPDataDecryptor createDataDecryptor(boolean z, BlockCipher blockCipher, byte[] bArr) throws IllegalArgumentException {
        final BufferedBlockCipher bufferedBlockCipherCreateStreamCipher = createStreamCipher(false, blockCipher, z, bArr);
        return new PGPDataDecryptor() { // from class: org.bouncycastle.openpgp.operator.bc.BcUtil.1
            @Override // org.bouncycastle.openpgp.operator.PGPDataDecryptor
            public int getBlockSize() {
                return bufferedBlockCipherCreateStreamCipher.getBlockSize();
            }

            @Override // org.bouncycastle.openpgp.operator.PGPDataDecryptor
            public InputStream getInputStream(InputStream inputStream) {
                return new CipherInputStream(inputStream, bufferedBlockCipherCreateStreamCipher);
            }

            @Override // org.bouncycastle.openpgp.operator.PGPDataDecryptor
            public PGPDigestCalculator getIntegrityCalculator() {
                return new SHA1PGPDigestCalculator();
            }
        };
    }

    static BufferedBlockCipher createStreamCipher(boolean z, BlockCipher blockCipher, boolean z2, byte[] bArr) throws IllegalArgumentException {
        BufferedBlockCipher bufferedBlockCipher = z2 ? new BufferedBlockCipher(new CFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8)) : new BufferedBlockCipher(new OpenPGPCFBBlockCipher(blockCipher));
        KeyParameter keyParameter = new KeyParameter(bArr);
        if (z2) {
            bufferedBlockCipher.init(z, new ParametersWithIV(keyParameter, new byte[blockCipher.getBlockSize()]));
        } else {
            bufferedBlockCipher.init(z, keyParameter);
        }
        return bufferedBlockCipher;
    }

    public static BufferedBlockCipher createSymmetricKeyWrapper(boolean z, BlockCipher blockCipher, byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        BufferedBlockCipher bufferedBlockCipher = new BufferedBlockCipher(new CFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        bufferedBlockCipher.init(z, new ParametersWithIV(new KeyParameter(bArr), bArr2));
        return bufferedBlockCipher;
    }

    static ECPoint decodePoint(BigInteger bigInteger, ECCurve eCCurve) {
        return eCCurve.decodePoint(BigIntegers.asUnsignedByteArray(bigInteger));
    }

    static X9ECParameters getX9Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        return byOID == null ? ECNamedCurveTable.getByOID(aSN1ObjectIdentifier) : byOID;
    }
}
