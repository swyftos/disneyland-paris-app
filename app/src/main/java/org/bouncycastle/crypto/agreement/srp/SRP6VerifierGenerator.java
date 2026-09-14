package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

/* JADX INFO: loaded from: classes6.dex */
public class SRP6VerifierGenerator {

    /* JADX INFO: renamed from: N */
    protected BigInteger f4166N;
    protected Digest digest;

    /* JADX INFO: renamed from: g */
    protected BigInteger f4167g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f4167g.modPow(SRP6Util.calculateX(this.digest, this.f4166N, bArr, bArr2, bArr3), this.f4166N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest) {
        this.f4166N = bigInteger;
        this.f4167g = bigInteger2;
        this.digest = digest;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest) {
        this.f4166N = sRP6GroupParameters.getN();
        this.f4167g = sRP6GroupParameters.getG();
        this.digest = digest;
    }
}
