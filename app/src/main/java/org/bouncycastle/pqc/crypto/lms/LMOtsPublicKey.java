package org.bouncycastle.pqc.crypto.lms;

import java.util.Arrays;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes6.dex */
class LMOtsPublicKey implements Encodable {

    /* JADX INFO: renamed from: I */
    private final byte[] f4843I;

    /* JADX INFO: renamed from: K */
    private final byte[] f4844K;
    private final LMOtsParameters parameter;

    /* JADX INFO: renamed from: q */
    private final int f4845q;

    public LMOtsPublicKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i, byte[] bArr2) {
        this.parameter = lMOtsParameters;
        this.f4843I = bArr;
        this.f4845q = i;
        this.f4844K = bArr2;
    }

    LMSContext createOtsContext(LMSSignature lMSSignature) {
        Digest digest = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(this.f4843I, digest);
        LmsUtils.u32str(this.f4845q, digest);
        LmsUtils.u16str((short) -32383, digest);
        LmsUtils.byteArray(lMSSignature.getOtsSignature().getC(), digest);
        return new LMSContext(this, lMSSignature, digest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMOtsPublicKey lMOtsPublicKey = (LMOtsPublicKey) obj;
        if (this.f4845q != lMOtsPublicKey.f4845q) {
            return false;
        }
        LMOtsParameters lMOtsParameters = this.parameter;
        if (lMOtsParameters == null ? lMOtsPublicKey.parameter != null : !lMOtsParameters.equals(lMOtsPublicKey.parameter)) {
            return false;
        }
        if (Arrays.equals(this.f4843I, lMOtsPublicKey.f4843I)) {
            return Arrays.equals(this.f4844K, lMOtsPublicKey.f4844K);
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return Composer.compose().u32str(this.parameter.getType()).bytes(this.f4843I).u32str(this.f4845q).bytes(this.f4844K).build();
    }

    public byte[] getI() {
        return this.f4843I;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.f4845q;
    }

    public int hashCode() {
        LMOtsParameters lMOtsParameters = this.parameter;
        return ((((((lMOtsParameters != null ? lMOtsParameters.hashCode() : 0) * 31) + Arrays.hashCode(this.f4843I)) * 31) + this.f4845q) * 31) + Arrays.hashCode(this.f4844K);
    }
}
