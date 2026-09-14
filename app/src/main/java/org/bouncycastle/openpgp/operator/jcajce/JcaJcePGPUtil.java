package org.bouncycastle.openpgp.operator.jcajce;

import java.math.BigInteger;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.p172x9.ECNamedCurveTable;
import org.bouncycastle.asn1.p172x9.X9ECParameters;
import org.bouncycastle.crypto.p176ec.CustomNamedCurves;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECPoint;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes6.dex */
abstract class JcaJcePGPUtil {
    static ECPoint decodePoint(BigInteger bigInteger, ECCurve eCCurve) {
        return eCCurve.decodePoint(BigIntegers.asUnsignedByteArray(bigInteger));
    }

    static X9ECParameters getX9Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        return byOID == null ? ECNamedCurveTable.getByOID(aSN1ObjectIdentifier) : byOID;
    }

    public static SecretKey makeSymmetricKey(int i, byte[] bArr) throws PGPException {
        String symmetricCipherName = PGPUtil.getSymmetricCipherName(i);
        if (symmetricCipherName != null) {
            return new SecretKeySpec(bArr, symmetricCipherName);
        }
        throw new PGPException("unknown symmetric algorithm: " + i);
    }
}
