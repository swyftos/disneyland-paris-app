package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes6.dex */
public class RSASecretBCPGKey extends BCPGObject implements BCPGKey {
    BigInteger crt;

    /* JADX INFO: renamed from: d */
    MPInteger f4108d;
    BigInteger expP;
    BigInteger expQ;

    /* JADX INFO: renamed from: p */
    MPInteger f4109p;

    /* JADX INFO: renamed from: q */
    MPInteger f4110q;

    /* JADX INFO: renamed from: u */
    MPInteger f4111u;

    public RSASecretBCPGKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int iCompareTo = bigInteger2.compareTo(bigInteger3);
        if (iCompareTo >= 0) {
            if (iCompareTo == 0) {
                throw new IllegalArgumentException("p and q cannot be equal");
            }
            bigInteger3 = bigInteger2;
            bigInteger2 = bigInteger3;
        }
        this.f4108d = new MPInteger(bigInteger);
        this.f4109p = new MPInteger(bigInteger2);
        this.f4110q = new MPInteger(bigInteger3);
        this.f4111u = new MPInteger(BigIntegers.modOddInverse(bigInteger3, bigInteger2));
        this.expP = bigInteger.remainder(bigInteger2.subtract(BigInteger.valueOf(1L)));
        this.expQ = bigInteger.remainder(bigInteger3.subtract(BigInteger.valueOf(1L)));
        this.crt = BigIntegers.modOddInverse(bigInteger2, bigInteger3);
    }

    public RSASecretBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.f4108d = new MPInteger(bCPGInputStream);
        this.f4109p = new MPInteger(bCPGInputStream);
        this.f4110q = new MPInteger(bCPGInputStream);
        this.f4111u = new MPInteger(bCPGInputStream);
        this.expP = this.f4108d.getValue().remainder(this.f4109p.getValue().subtract(BigInteger.valueOf(1L)));
        this.expQ = this.f4108d.getValue().remainder(this.f4110q.getValue().subtract(BigInteger.valueOf(1L)));
        this.crt = BigIntegers.modOddInverse(this.f4109p.getValue(), this.f4110q.getValue());
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.f4108d);
        bCPGOutputStream.writeObject(this.f4109p);
        bCPGOutputStream.writeObject(this.f4110q);
        bCPGOutputStream.writeObject(this.f4111u);
    }

    public BigInteger getCrtCoefficient() {
        return this.crt;
    }

    @Override // org.bouncycastle.bcpg.BCPGObject, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.bcpg.BCPGKey
    public String getFormat() {
        return "PGP";
    }

    public BigInteger getModulus() {
        return this.f4109p.getValue().multiply(this.f4110q.getValue());
    }

    public BigInteger getPrimeExponentP() {
        return this.expP;
    }

    public BigInteger getPrimeExponentQ() {
        return this.expQ;
    }

    public BigInteger getPrimeP() {
        return this.f4109p.getValue();
    }

    public BigInteger getPrimeQ() {
        return this.f4110q.getValue();
    }

    public BigInteger getPrivateExponent() {
        return this.f4108d.getValue();
    }
}
