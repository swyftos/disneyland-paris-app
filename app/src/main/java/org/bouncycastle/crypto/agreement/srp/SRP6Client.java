package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

/* JADX INFO: loaded from: classes6.dex */
public class SRP6Client {

    /* JADX INFO: renamed from: A */
    protected BigInteger f4146A;

    /* JADX INFO: renamed from: B */
    protected BigInteger f4147B;
    protected BigInteger Key;

    /* JADX INFO: renamed from: M1 */
    protected BigInteger f4148M1;

    /* JADX INFO: renamed from: M2 */
    protected BigInteger f4149M2;

    /* JADX INFO: renamed from: N */
    protected BigInteger f4150N;

    /* JADX INFO: renamed from: S */
    protected BigInteger f4151S;

    /* JADX INFO: renamed from: a */
    protected BigInteger f4152a;
    protected Digest digest;

    /* JADX INFO: renamed from: g */
    protected BigInteger f4153g;
    protected SecureRandom random;

    /* JADX INFO: renamed from: u */
    protected BigInteger f4154u;

    /* JADX INFO: renamed from: x */
    protected BigInteger f4155x;

    private BigInteger calculateS() {
        BigInteger bigIntegerCalculateK = SRP6Util.calculateK(this.digest, this.f4150N, this.f4153g);
        return this.f4147B.subtract(this.f4153g.modPow(this.f4155x, this.f4150N).multiply(bigIntegerCalculateK).mod(this.f4150N)).mod(this.f4150N).modPow(this.f4154u.multiply(this.f4155x).add(this.f4152a), this.f4150N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f4146A;
        if (bigInteger3 == null || (bigInteger = this.f4147B) == null || (bigInteger2 = this.f4151S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger bigIntegerCalculateM1 = SRP6Util.calculateM1(this.digest, this.f4150N, bigInteger3, bigInteger, bigInteger2);
        this.f4148M1 = bigIntegerCalculateM1;
        return bigIntegerCalculateM1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerValidatePublicValue = SRP6Util.validatePublicValue(this.f4150N, bigInteger);
        this.f4147B = bigIntegerValidatePublicValue;
        this.f4154u = SRP6Util.calculateU(this.digest, this.f4150N, this.f4146A, bigIntegerValidatePublicValue);
        BigInteger bigIntegerCalculateS = calculateS();
        this.f4151S = bigIntegerCalculateS;
        return bigIntegerCalculateS;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f4151S;
        if (bigInteger == null || this.f4148M1 == null || this.f4149M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger bigIntegerCalculateKey = SRP6Util.calculateKey(this.digest, this.f4150N, bigInteger);
        this.Key = bigIntegerCalculateKey;
        return bigIntegerCalculateKey;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f4155x = SRP6Util.calculateX(this.digest, this.f4150N, bArr, bArr2, bArr3);
        BigInteger bigIntegerSelectPrivateValue = selectPrivateValue();
        this.f4152a = bigIntegerSelectPrivateValue;
        BigInteger bigIntegerModPow = this.f4153g.modPow(bigIntegerSelectPrivateValue, this.f4150N);
        this.f4146A = bigIntegerModPow;
        return bigIntegerModPow;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest, SecureRandom secureRandom) {
        this.f4150N = bigInteger;
        this.f4153g = bigInteger2;
        this.digest = digest;
        this.random = secureRandom;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), digest, secureRandom);
    }

    protected BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f4150N, this.f4153g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f4146A;
        if (bigInteger4 == null || (bigInteger2 = this.f4148M1) == null || (bigInteger3 = this.f4151S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        }
        if (!SRP6Util.calculateM2(this.digest, this.f4150N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        }
        this.f4149M2 = bigInteger;
        return true;
    }
}
