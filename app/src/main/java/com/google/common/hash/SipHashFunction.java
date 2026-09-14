package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c */
    private final int f3549c;

    /* JADX INFO: renamed from: d */
    private final int f3550d;

    /* JADX INFO: renamed from: k0 */
    private final long f3551k0;

    /* JADX INFO: renamed from: k1 */
    private final long f3552k1;

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    SipHashFunction(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f3549c = i;
        this.f3550d = i2;
        this.f3551k0 = j;
        this.f3552k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f3549c, this.f3550d, this.f3551k0, this.f3552k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f3549c + "" + this.f3550d + "(" + this.f3551k0 + ", " + this.f3552k1 + ")";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f3549c == sipHashFunction.f3549c && this.f3550d == sipHashFunction.f3550d && this.f3551k0 == sipHashFunction.f3551k0 && this.f3552k1 == sipHashFunction.f3552k1;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f3549c) ^ this.f3550d)) ^ this.f3551k0) ^ this.f3552k1);
    }

    private static final class SipHasher extends AbstractStreamingHasher {

        /* JADX INFO: renamed from: b */
        private long f3553b;

        /* JADX INFO: renamed from: c */
        private final int f3554c;

        /* JADX INFO: renamed from: d */
        private final int f3555d;
        private long finalM;

        /* JADX INFO: renamed from: v0 */
        private long f3556v0;

        /* JADX INFO: renamed from: v1 */
        private long f3557v1;

        /* JADX INFO: renamed from: v2 */
        private long f3558v2;

        /* JADX INFO: renamed from: v3 */
        private long f3559v3;

        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f3553b = 0L;
            this.finalM = 0L;
            this.f3554c = i;
            this.f3555d = i2;
            this.f3556v0 = 8317987319222330741L ^ j;
            this.f3557v1 = 7237128888997146477L ^ j2;
            this.f3558v2 = 7816392313619706465L ^ j;
            this.f3559v3 = 8387220255154660723L ^ j2;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            this.f3553b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            this.f3553b += (long) byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i;
                i += 8;
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            long j = this.finalM ^ (this.f3553b << 56);
            this.finalM = j;
            processM(j);
            this.f3558v2 ^= 255;
            sipRound(this.f3555d);
            return HashCode.fromLong(((this.f3556v0 ^ this.f3557v1) ^ this.f3558v2) ^ this.f3559v3);
        }

        private void processM(long j) {
            this.f3559v3 ^= j;
            sipRound(this.f3554c);
            this.f3556v0 = j ^ this.f3556v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f3556v0;
                long j2 = this.f3557v1;
                this.f3556v0 = j + j2;
                this.f3558v2 += this.f3559v3;
                this.f3557v1 = Long.rotateLeft(j2, 13);
                long jRotateLeft = Long.rotateLeft(this.f3559v3, 16);
                long j3 = this.f3557v1;
                long j4 = this.f3556v0;
                this.f3557v1 = j3 ^ j4;
                this.f3559v3 = jRotateLeft ^ this.f3558v2;
                long jRotateLeft2 = Long.rotateLeft(j4, 32);
                long j5 = this.f3558v2;
                long j6 = this.f3557v1;
                this.f3558v2 = j5 + j6;
                this.f3556v0 = jRotateLeft2 + this.f3559v3;
                this.f3557v1 = Long.rotateLeft(j6, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f3559v3, 21);
                long j7 = this.f3557v1;
                long j8 = this.f3558v2;
                this.f3557v1 = j7 ^ j8;
                this.f3559v3 = jRotateLeft3 ^ this.f3556v0;
                this.f3558v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}
