package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes6.dex */
public abstract class ECPublicBCPGKey extends BCPGObject implements BCPGKey {
    ASN1ObjectIdentifier oid;
    BigInteger point;

    protected ECPublicBCPGKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger) {
        this.point = bigInteger;
        this.oid = aSN1ObjectIdentifier;
    }

    protected ECPublicBCPGKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, ECPoint eCPoint) {
        this.point = new BigInteger(1, eCPoint.getEncoded(false));
        this.oid = aSN1ObjectIdentifier;
    }

    protected ECPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.oid = ASN1ObjectIdentifier.getInstance(ASN1Primitive.fromByteArray(readBytesOfEncodedLength(bCPGInputStream)));
        this.point = new MPInteger(bCPGInputStream).getValue();
    }

    protected static byte[] readBytesOfEncodedLength(BCPGInputStream bCPGInputStream) throws IOException {
        int i = bCPGInputStream.read();
        if (i < 0) {
            throw new IOException("unexpected end-of-stream");
        }
        if (i == 0 || i == 255) {
            throw new IOException("future extensions not yet implemented");
        }
        if (i > 127) {
            throw new IOException("unsupported OID");
        }
        byte[] bArr = new byte[i + 2];
        bCPGInputStream.readFully(bArr, 2, i);
        bArr[0] = 6;
        bArr[1] = (byte) i;
        return bArr;
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        byte[] encoded = this.oid.getEncoded();
        bCPGOutputStream.write(encoded, 1, encoded.length - 1);
        bCPGOutputStream.writeObject(new MPInteger(this.point));
    }

    public ASN1ObjectIdentifier getCurveOID() {
        return this.oid;
    }

    @Override // org.bouncycastle.bcpg.BCPGObject, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public BigInteger getEncodedPoint() {
        return this.point;
    }

    @Override // org.bouncycastle.bcpg.BCPGKey
    public String getFormat() {
        return "PGP";
    }
}
