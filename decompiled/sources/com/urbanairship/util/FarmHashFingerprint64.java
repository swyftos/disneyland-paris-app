package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.nio.charset.StandardCharsets;
import org.bouncycastle.asn1.cmc.BodyPartID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class FarmHashFingerprint64 {
    private static long hashLength16(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    private static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    public static long fingerprint(@NonNull String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return fingerprint(bytes, 0, bytes.length);
    }

    static long fingerprint(byte[] bArr, int i, int i2) {
        if (i2 <= 32) {
            if (i2 <= 16) {
                return hashLength0to16(bArr, i, i2);
            }
            return hashLength17to32(bArr, i, i2);
        }
        if (i2 <= 64) {
            return hashLength33To64(bArr, i, i2);
        }
        return hashLength65Plus(bArr, i, i2);
    }

    static long load32(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            j |= (bArr[i + i2] & 255) << (i2 * 8);
        }
        return j;
    }

    static long load64(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j |= (bArr[i + i2] & 255) << (i2 * 8);
        }
        return j;
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jLoad64 = load64(bArr, i);
        long jLoad642 = load64(bArr, i + 8);
        long jLoad643 = load64(bArr, i + 16);
        long jLoad644 = load64(bArr, i + 24);
        long j3 = j + jLoad64;
        long j4 = jLoad642 + j3 + jLoad643;
        long jRotateRight = Long.rotateRight(j2 + j3 + jLoad644, 21) + Long.rotateRight(j4, 44);
        jArr[0] = j4 + jLoad644;
        jArr[1] = jRotateRight + j3;
    }

    private static long hashLength0to16(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = (i2 * 2) - 7286425919675154353L;
            long jLoad64 = load64(bArr, i) - 7286425919675154353L;
            long jLoad642 = load64(bArr, (i + i2) - 8);
            return hashLength16((Long.rotateRight(jLoad642, 37) * j) + jLoad64, (Long.rotateRight(jLoad64, 25) + jLoad642) * j, j);
        }
        if (i2 >= 4) {
            return hashLength16(i2 + ((load32(bArr, i) & BodyPartID.bodyIdMax) << 3), load32(bArr, (i + i2) - 4) & BodyPartID.bodyIdMax, (i2 * 2) - 7286425919675154353L);
        }
        if (i2 <= 0) {
            return -7286425919675154353L;
        }
        return shiftMix((((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8)) * (-7286425919675154353L)) ^ ((i2 + ((bArr[i + (i2 - 1)] & 255) << 2)) * (-4348849565147123417L))) * (-7286425919675154353L);
    }

    private static long hashLength17to32(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) - 7286425919675154353L;
        long jLoad64 = load64(bArr, i) * (-5435081209227447693L);
        long jLoad642 = load64(bArr, i + 8);
        int i3 = i + i2;
        long jLoad643 = load64(bArr, i3 - 8) * j;
        return hashLength16((load64(bArr, i3 - 16) * (-7286425919675154353L)) + Long.rotateRight(jLoad64 + jLoad642, 43) + Long.rotateRight(jLoad643, 30), jLoad643 + jLoad64 + Long.rotateRight(jLoad642 - 7286425919675154353L, 18), j);
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) - 7286425919675154353L;
        long jLoad64 = load64(bArr, i) * (-7286425919675154353L);
        long jLoad642 = load64(bArr, i + 8);
        int i3 = i + i2;
        long jLoad643 = load64(bArr, i3 - 8) * j;
        long jRotateRight = Long.rotateRight(jLoad64 + jLoad642, 43) + Long.rotateRight(jLoad643, 30) + (load64(bArr, i3 - 16) * (-7286425919675154353L));
        long jHashLength16 = hashLength16(jRotateRight, jLoad643 + Long.rotateRight(jLoad642 - 7286425919675154353L, 18) + jLoad64, j);
        long jLoad644 = load64(bArr, i + 16) * j;
        long jLoad645 = load64(bArr, i + 24);
        long jLoad646 = (jRotateRight + load64(bArr, i3 - 32)) * j;
        return hashLength16(((jHashLength16 + load64(bArr, i3 - 24)) * j) + Long.rotateRight(jLoad644 + jLoad645, 43) + Long.rotateRight(jLoad646, 30), jLoad644 + Long.rotateRight(jLoad645 + jLoad64, 18) + jLoad646, j);
    }

    private static long hashLength65Plus(byte[] bArr, int i, int i2) {
        long j = 81;
        long j2 = (j * (-5435081209227447693L)) + 113;
        long jShiftMix = shiftMix((j2 * (-7286425919675154353L)) + 113) * (-7286425919675154353L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jLoad64 = (j * (-7286425919675154353L)) + load64(bArr, i);
        int i3 = i2 - 1;
        int i4 = i + ((i3 / 64) * 64);
        int i5 = i3 & 63;
        int i6 = i4 + i5;
        int i7 = i6 - 63;
        int i8 = i;
        while (true) {
            long jRotateRight = Long.rotateRight(jLoad64 + j2 + jArr[0] + load64(bArr, i8 + 8), 37) * (-5435081209227447693L);
            long jRotateRight2 = Long.rotateRight(j2 + jArr[1] + load64(bArr, i8 + 48), 42) * (-5435081209227447693L);
            long j3 = jRotateRight ^ jArr2[1];
            long jLoad642 = jRotateRight2 + jArr[0] + load64(bArr, i8 + 40);
            long jRotateRight3 = Long.rotateRight(jShiftMix + jArr2[0], 33) * (-5435081209227447693L);
            weakHashLength32WithSeeds(bArr, i8, jArr[1] * (-5435081209227447693L), j3 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i8 + 32, jRotateRight3 + jArr2[1], jLoad642 + load64(bArr, i8 + 16), jArr2);
            int i9 = i8 + 64;
            if (i9 == i4) {
                long j4 = (-5435081209227447693L) + ((j3 & 255) << 1);
                long j5 = jArr2[0] + i5;
                jArr2[0] = j5;
                long j6 = jArr[0] + j5;
                jArr[0] = j6;
                jArr2[0] = jArr2[0] + j6;
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jLoad642 + jArr[0] + load64(bArr, i6 - 55), 37) * j4;
                long jRotateRight5 = Long.rotateRight(jLoad642 + jArr[1] + load64(bArr, i6 - 15), 42) * j4;
                long j7 = jRotateRight4 ^ (jArr2[1] * 9);
                long jLoad643 = jRotateRight5 + (jArr[0] * 9) + load64(bArr, i6 - 23);
                long jRotateRight6 = Long.rotateRight(j3 + jArr2[0], 33) * j4;
                weakHashLength32WithSeeds(bArr, i7, jArr[1] * j4, j7 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr, i6 - 31, jRotateRight6 + jArr2[1], jLoad643 + load64(bArr, i6 - 47), jArr2);
                return hashLength16(hashLength16(jArr[0], jArr2[0], j4) + (shiftMix(jLoad643) * (-4348849565147123417L)) + j7, hashLength16(jArr[1], jArr2[1], j4) + jRotateRight6, j4);
            }
            i8 = i9;
            jShiftMix = j3;
            j2 = jLoad642;
            jLoad64 = jRotateRight3;
        }
    }
}
