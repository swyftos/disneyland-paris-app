package com.google.common.hash;

import com.google.common.base.Preconditions;

/* loaded from: classes4.dex */
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();

    static long hash128to64(long j, long j2) {
        long j3 = (j2 ^ j) * (-4132994306676758123L);
        long j4 = (j ^ (j3 ^ (j3 >>> 47))) * (-4132994306676758123L);
        return (j4 ^ (j4 >>> 47)) * (-4132994306676758123L);
    }

    private static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    Fingerprint2011() {
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }

    static long fingerprint(byte[] bArr, int i, int i2) {
        long jFullFingerprint;
        if (i2 <= 32) {
            jFullFingerprint = murmurHash64WithSeed(bArr, i, i2, -1397348546323613475L);
        } else if (i2 <= 64) {
            jFullFingerprint = hashLength33To64(bArr, i, i2);
        } else {
            jFullFingerprint = fullFingerprint(bArr, i, i2);
        }
        long jHash128to64 = hash128to64(jFullFingerprint + (i2 >= 9 ? LittleEndianByteArray.load64(bArr, (i + i2) - 8) : -6505348102511208375L), i2 >= 8 ? LittleEndianByteArray.load64(bArr, i) : -6505348102511208375L);
        return (jHash128to64 == 0 || jHash128to64 == 1) ? jHash128to64 - 2 : jHash128to64;
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i);
        long jLoad642 = LittleEndianByteArray.load64(bArr, i + 8);
        long jLoad643 = LittleEndianByteArray.load64(bArr, i + 16);
        long jLoad644 = LittleEndianByteArray.load64(bArr, i + 24);
        long j3 = j + jLoad64;
        long j4 = jLoad642 + j3 + jLoad643;
        long jRotateRight = Long.rotateRight(j2 + j3 + jLoad644, 51) + Long.rotateRight(j4, 23);
        jArr[0] = j4 + jLoad644;
        jArr[1] = jRotateRight + j3;
    }

    private static long fullFingerprint(byte[] bArr, int i, int i2) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i);
        int i3 = i + i2;
        long jLoad642 = LittleEndianByteArray.load64(bArr, i3 - 16) ^ (-8261664234251669945L);
        long jLoad643 = LittleEndianByteArray.load64(bArr, i3 - 56) ^ (-6505348102511208375L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j = i2;
        weakHashLength32WithSeeds(bArr, i3 - 64, j, jLoad642, jArr);
        weakHashLength32WithSeeds(bArr, i3 - 32, j * (-8261664234251669945L), -6505348102511208375L, jArr2);
        long jShiftMix = jLoad643 + (shiftMix(jArr[1]) * (-8261664234251669945L));
        long jRotateRight = Long.rotateRight(jShiftMix + jLoad64, 39) * (-8261664234251669945L);
        long jRotateRight2 = Long.rotateRight(jLoad642, 33) * (-8261664234251669945L);
        int i4 = i;
        int i5 = (i2 - 1) & (-64);
        while (true) {
            long jRotateRight3 = Long.rotateRight(jRotateRight + jRotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr, i4 + 16), 37) * (-8261664234251669945L);
            long jRotateRight4 = Long.rotateRight(jRotateRight2 + jArr[1] + LittleEndianByteArray.load64(bArr, i4 + 48), 42) * (-8261664234251669945L);
            long j2 = jRotateRight3 ^ jArr2[1];
            long j3 = jRotateRight4 ^ jArr[0];
            long jRotateRight5 = Long.rotateRight(jShiftMix ^ jArr2[0], 33);
            weakHashLength32WithSeeds(bArr, i4, jArr[1] * (-8261664234251669945L), j2 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i4 + 32, jArr2[1] + jRotateRight5, j3, jArr2);
            i4 += 64;
            i5 -= 64;
            if (i5 == 0) {
                return hash128to64(hash128to64(jArr[0], jArr2[0]) + (shiftMix(j3) * (-8261664234251669945L)) + j2, hash128to64(jArr[1], jArr2[1]) + jRotateRight5);
            }
            jRotateRight = jRotateRight5;
            jShiftMix = j2;
            jRotateRight2 = j3;
        }
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i + 24);
        int i3 = i + i2;
        int i4 = i3 - 16;
        long jLoad642 = LittleEndianByteArray.load64(bArr, i) + ((i2 + LittleEndianByteArray.load64(bArr, i4)) * (-6505348102511208375L));
        long jRotateRight = Long.rotateRight(jLoad642 + jLoad64, 52);
        long jRotateRight2 = Long.rotateRight(jLoad642, 37);
        long jLoad643 = jLoad642 + LittleEndianByteArray.load64(bArr, i + 8);
        long jRotateRight3 = jRotateRight2 + Long.rotateRight(jLoad643, 7);
        int i5 = i + 16;
        long jLoad644 = jLoad643 + LittleEndianByteArray.load64(bArr, i5);
        long j = jLoad64 + jLoad644;
        long jRotateRight4 = jRotateRight + Long.rotateRight(jLoad644, 31) + jRotateRight3;
        long jLoad645 = LittleEndianByteArray.load64(bArr, i5) + LittleEndianByteArray.load64(bArr, i3 - 32);
        long jLoad646 = LittleEndianByteArray.load64(bArr, i3 - 8);
        long jRotateRight5 = Long.rotateRight(jLoad645 + jLoad646, 52);
        long jRotateRight6 = Long.rotateRight(jLoad645, 37);
        long jLoad647 = jLoad645 + LittleEndianByteArray.load64(bArr, i3 - 24);
        long jRotateRight7 = jRotateRight6 + Long.rotateRight(jLoad647, 7);
        long jLoad648 = jLoad647 + LittleEndianByteArray.load64(bArr, i4);
        return shiftMix((shiftMix(((j + jRotateRight5 + Long.rotateRight(jLoad648, 31) + jRotateRight7) * (-4288712594273399085L)) + ((jLoad646 + jLoad648 + jRotateRight4) * (-6505348102511208375L))) * (-6505348102511208375L)) + jRotateRight4) * (-4288712594273399085L);
    }

    static long murmurHash64WithSeed(byte[] bArr, int i, int i2, long j) {
        int i3 = i2 & (-8);
        int i4 = i2 & 7;
        long jLoad64Safely = j ^ (i2 * (-4132994306676758123L));
        for (int i5 = 0; i5 < i3; i5 += 8) {
            jLoad64Safely = (jLoad64Safely ^ (shiftMix(LittleEndianByteArray.load64(bArr, i + i5) * (-4132994306676758123L)) * (-4132994306676758123L))) * (-4132994306676758123L);
        }
        if (i4 != 0) {
            jLoad64Safely = (LittleEndianByteArray.load64Safely(bArr, i + i3, i4) ^ jLoad64Safely) * (-4132994306676758123L);
        }
        return shiftMix(shiftMix(jLoad64Safely) * (-4132994306676758123L));
    }
}
