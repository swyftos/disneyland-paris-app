package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

/* JADX INFO: loaded from: classes6.dex */
public class SRP6Server {

    /* JADX INFO: renamed from: A */
    protected BigInteger f4156A;

    /* JADX INFO: renamed from: B */
    protected BigInteger f4157B;
    protected BigInteger Key;

    /* JADX INFO: renamed from: M1 */
    protected BigInteger f4158M1;

    /* JADX INFO: renamed from: M2 */
    protected BigInteger f4159M2;

    /* JADX INFO: renamed from: N */
    protected BigInteger f4160N;

    /* JADX INFO: renamed from: S */
    protected BigInteger f4161S;

    /* JADX INFO: renamed from: b */
    protected BigInteger f4162b;
    protected Digest digest;

    /* JADX INFO: renamed from: g */
    protected BigInteger f4163g;
    protected SecureRandom random;

    /* JADX INFO: renamed from: u */
    protected BigInteger f4164u;

    /* JADX INFO: renamed from: v */
    protected BigInteger f4165v;

    private BigInteger calculateS() {
        return this.f4165v.modPow(this.f4164u, this.f4160N).multiply(this.f4156A).mod(this.f4160N).modPow(this.f4162b, this.f4160N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerValidatePublicValue = SRP6Util.validatePublicValue(this.f4160N, bigInteger);
        this.f4156A = bigIntegerValidatePublicValue;
        this.f4164u = SRP6Util.calculateU(this.digest, this.f4160N, bigIntegerValidatePublicValue, this.f4157B);
        BigInteger bigIntegerCalculateS = calculateS();
        this.f4161S = bigIntegerCalculateS;
        return bigIntegerCalculateS;
    }

    public BigInteger calculateServerEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f4156A;
        if (bigInteger3 == null || (bigInteger = this.f4158M1) == null || (bigInteger2 = this.f4161S) == null) {
            throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
        }
        BigInteger bigIntegerCalculateM2 = SRP6Util.calculateM2(this.digest, this.f4160N, bigInteger3, bigInteger, bigInteger2);
        this.f4159M2 = bigIntegerCalculateM2;
        return bigIntegerCalculateM2;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f4161S;
        if (bigInteger == null || this.f4158M1 == null || this.f4159M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger bigIntegerCalculateKey = SRP6Util.calculateKey(this.digest, this.f4160N, bigInteger);
        this.Key = bigIntegerCalculateKey;
        return bigIntegerCalculateKey;
    }

    public BigInteger generateServerCredentials() {
        BigInteger bigIntegerCalculateK = SRP6Util.calculateK(this.digest, this.f4160N, this.f4163g);
        this.f4162b = selectPrivateValue();
        BigInteger bigIntegerMod = bigIntegerCalculateK.multiply(this.f4165v).mod(this.f4160N).add(this.f4163g.modPow(this.f4162b, this.f4160N)).mod(this.f4160N);
        this.f4157B = bigIntegerMod;
        return bigIntegerMod;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest, SecureRandom secureRandom) {
        this.f4160N = bigInteger;
        this.f4163g = bigInteger2;
        this.f4165v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, BigInteger bigInteger, Digest digest, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), bigInteger, digest, secureRandom);
    }

    protected BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f4160N, this.f4163g, this.random);
    }

    public boolean verifyClientEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f4156A;
        if (bigInteger4 == null || (bigInteger2 = this.f4157B) == null || (bigInteger3 = this.f4161S) == null) {
            throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
        }
        if (!SRP6Util.calculateM1(this.digest, this.f4160N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        }
        this.f4158M1 = bigInteger;
        return true;
    }
}
