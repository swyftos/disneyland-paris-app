package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes6.dex */
public class ECDHPublicBCPGKey extends ECPublicBCPGKey {
    private byte hashFunctionId;
    private byte reserved;
    private byte symAlgorithmId;

    public ECDHPublicBCPGKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger, int i, int i2) {
        super(aSN1ObjectIdentifier, bigInteger);
        this.reserved = (byte) 1;
        this.hashFunctionId = (byte) i;
        this.symAlgorithmId = (byte) i2;
        verifyHashAlgorithm();
        verifySymmetricKeyAlgorithm();
    }

    public ECDHPublicBCPGKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, ECPoint eCPoint, int i, int i2) {
        super(aSN1ObjectIdentifier, eCPoint);
        this.reserved = (byte) 1;
        this.hashFunctionId = (byte) i;
        this.symAlgorithmId = (byte) i2;
        verifyHashAlgorithm();
        verifySymmetricKeyAlgorithm();
    }

    public ECDHPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        int i = bCPGInputStream.read();
        byte[] bArr = new byte[i];
        if (i != 3) {
            throw new IllegalStateException("kdf parameters size of 3 expected.");
        }
        bCPGInputStream.readFully(bArr);
        this.reserved = bArr[0];
        this.hashFunctionId = bArr[1];
        this.symAlgorithmId = bArr[2];
        verifyHashAlgorithm();
        verifySymmetricKeyAlgorithm();
    }

    private void verifyHashAlgorithm() {
        switch (this.hashFunctionId) {
            case 8:
            case 9:
            case 10:
                return;
            default:
                throw new IllegalStateException("Hash algorithm must be SHA-256 or stronger.");
        }
    }

    private void verifySymmetricKeyAlgorithm() {
        byte b = this.symAlgorithmId;
        if (b != 7 && b != 8 && b != 9) {
            throw new IllegalStateException("Symmetric key algorithm must be AES-128 or stronger.");
        }
    }

    @Override // org.bouncycastle.bcpg.ECPublicBCPGKey, org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        super.encode(bCPGOutputStream);
        bCPGOutputStream.write(3);
        bCPGOutputStream.write(this.reserved);
        bCPGOutputStream.write(this.hashFunctionId);
        bCPGOutputStream.write(this.symAlgorithmId);
    }

    public byte getHashAlgorithm() {
        return this.hashFunctionId;
    }

    public byte getReserved() {
        return this.reserved;
    }

    public byte getSymmetricKeyAlgorithm() {
        return this.symAlgorithmId;
    }
}
