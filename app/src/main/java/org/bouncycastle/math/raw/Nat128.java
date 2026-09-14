package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Nat128 {
    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & BodyPartID.bodyIdMax) + (((long) iArr2[3]) & BodyPartID.bodyIdMax);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax) + (((long) iArr3[0]) & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax) + (((long) iArr3[1]) & BodyPartID.bodyIdMax);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax) + (((long) iArr3[2]) & BodyPartID.bodyIdMax);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & BodyPartID.bodyIdMax) + (((long) iArr2[3]) & BodyPartID.bodyIdMax) + (((long) iArr3[3]) & BodyPartID.bodyIdMax);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        long j = (((long) i3) & BodyPartID.bodyIdMax) + (((long) iArr[i]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2]) & BodyPartID.bodyIdMax);
        iArr2[i2] = (int) j;
        int i4 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & BodyPartID.bodyIdMax) + (((long) iArr2[i4]) & BodyPartID.bodyIdMax);
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & BodyPartID.bodyIdMax) + (((long) iArr2[i5]) & BodyPartID.bodyIdMax);
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[i6]));
        iArr2[i6] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[3]));
        iArr2[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        long j = (((long) iArr[i]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2]) & BodyPartID.bodyIdMax);
        int i3 = (int) j;
        iArr[i] = i3;
        iArr2[i2] = i3;
        int i4 = i + 1;
        int i5 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i4]) & BodyPartID.bodyIdMax) + (((long) iArr2[i5]) & BodyPartID.bodyIdMax);
        int i6 = (int) j2;
        iArr[i4] = i6;
        iArr2[i5] = i6;
        int i7 = i + 2;
        int i8 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i7]) & BodyPartID.bodyIdMax) + (((long) iArr2[i8]) & BodyPartID.bodyIdMax);
        int i9 = (int) j3;
        iArr[i7] = i9;
        iArr2[i8] = i9;
        int i10 = i + 3;
        int i11 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i10]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[i11]));
        int i12 = (int) j4;
        iArr[i10] = i12;
        iArr2[i11] = i12;
        return (int) (j4 >>> 32);
    }

    public static void copy(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2] = iArr[i];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
    }

    public static void copy64(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2] = jArr[i];
        jArr2[i2 + 1] = jArr[i + 1];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static int[] create() {
        return new int[4];
    }

    public static long[] create64() {
        return new long[2];
    }

    public static int[] createExt() {
        return new int[8];
    }

    public static long[] createExt64() {
        return new long[4];
    }

    public static boolean diff(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean zGte = gte(iArr, i, iArr2, i2);
        if (zGte) {
            sub(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            sub(iArr2, i2, iArr, i, iArr3, i3);
        }
        return zGte;
    }

    /* JADX INFO: renamed from: eq */
    public static boolean m2100eq(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i = 1; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] iArrCreate = create();
        for (int i = 0; i < 4; i++) {
            iArrCreate[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrCreate;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        long[] jArrCreate64 = create64();
        for (int i = 0; i < 2; i++) {
            jArrCreate64[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrCreate64;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 4) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 3; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] jArr) {
        return jArr[0] == 1 && jArr[1] == 0;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i = 0; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
        long j6 = j5 * j;
        iArr3[i3] = (int) j6;
        char c = ' ';
        long j7 = (j6 >>> 32) + (j5 * j2);
        iArr3[i3 + 1] = (int) j7;
        long j8 = (j7 >>> 32) + (j5 * j3);
        iArr3[i3 + 2] = (int) j8;
        long j9 = (j8 >>> 32) + (j5 * j4);
        iArr3[i3 + 3] = (int) j9;
        iArr3[i3 + 4] = (int) (j9 >>> 32);
        int i4 = 1;
        int i5 = i3;
        while (i4 < 4) {
            int i6 = i5 + 1;
            long j10 = ((long) iArr[i + i4]) & BodyPartID.bodyIdMax;
            long j11 = j;
            long j12 = (j10 * j) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j12;
            int i7 = i5 + 2;
            long j13 = (j12 >>> c) + (j10 * j2) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax);
            iArr3[i7] = (int) j13;
            int i8 = i5 + 3;
            long j14 = (j13 >>> 32) + (j10 * j3) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax);
            iArr3[i8] = (int) j14;
            int i9 = i5 + 4;
            long j15 = (j14 >>> 32) + (j10 * j4) + (((long) iArr3[i9]) & BodyPartID.bodyIdMax);
            iArr3[i9] = (int) j15;
            iArr3[i5 + 5] = (int) (j15 >>> 32);
            i4++;
            c = ' ';
            i5 = i6;
            j3 = j3;
            j = j11;
            j2 = j2;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        int i = 1;
        long j2 = ((long) iArr2[1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr[0]) & BodyPartID.bodyIdMax;
        long j6 = j5 * j;
        iArr3[0] = (int) j6;
        long j7 = (j6 >>> 32) + (j5 * j2);
        iArr3[1] = (int) j7;
        long j8 = (j7 >>> 32) + (j5 * j3);
        iArr3[2] = (int) j8;
        long j9 = (j8 >>> 32) + (j5 * j4);
        iArr3[3] = (int) j9;
        iArr3[4] = (int) (j9 >>> 32);
        for (int i2 = 4; i < i2; i2 = 4) {
            long j10 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
            long j11 = (j10 * j) + (((long) iArr3[i]) & BodyPartID.bodyIdMax);
            iArr3[i] = (int) j11;
            int i3 = i + 1;
            int i4 = i;
            long j12 = (j11 >>> 32) + (j10 * j2) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax);
            iArr3[i3] = (int) j12;
            int i5 = i4 + 2;
            long j13 = (j12 >>> 32) + (j10 * j3) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax);
            iArr3[i5] = (int) j13;
            int i6 = i4 + 3;
            long j14 = (j13 >>> 32) + (j10 * j4) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j14;
            iArr3[i4 + 4] = (int) (j14 >>> 32);
            i = i3;
            j = j;
        }
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr[i2]) & BodyPartID.bodyIdMax;
        long j3 = (j * j2) + (((long) iArr2[i3]) & BodyPartID.bodyIdMax);
        iArr3[i4] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & BodyPartID.bodyIdMax;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (((long) iArr2[i3 + 1]) & BodyPartID.bodyIdMax);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = ((long) iArr[i2 + 2]) & BodyPartID.bodyIdMax;
        long j8 = j6 + (j * j7) + j4 + (((long) iArr2[i3 + 2]) & BodyPartID.bodyIdMax);
        iArr3[i4 + 2] = (int) j8;
        long j9 = ((long) iArr[i2 + 3]) & BodyPartID.bodyIdMax;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (BodyPartID.bodyIdMax & ((long) iArr2[i3 + 3]));
        iArr3[i4 + 3] = (int) j10;
        return (j10 >>> 32) + j9;
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & BodyPartID.bodyIdMax;
        long j3 = j & BodyPartID.bodyIdMax;
        long j4 = (j2 * j3) + (((long) iArr[i2]) & BodyPartID.bodyIdMax);
        iArr[i2] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i3 = i2 + 1;
        long j7 = (j4 >>> 32) + j6 + (((long) iArr[i3]) & BodyPartID.bodyIdMax);
        iArr[i3] = (int) j7;
        int i4 = i2 + 2;
        long j8 = (j7 >>> 32) + j5 + (((long) iArr[i4]) & BodyPartID.bodyIdMax);
        iArr[i4] = (int) j8;
        int i5 = i2 + 3;
        long j9 = (j8 >>> 32) + (((long) iArr[i5]) & BodyPartID.bodyIdMax);
        iArr[i5] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = ((long) i2) & BodyPartID.bodyIdMax;
        long j3 = (j * j2) + (((long) iArr[i3]) & BodyPartID.bodyIdMax);
        iArr[i3] = (int) j3;
        int i4 = i3 + 1;
        long j4 = (j3 >>> 32) + j2 + (((long) iArr[i4]) & BodyPartID.bodyIdMax);
        iArr[i4] = (int) j4;
        long j5 = j4 >>> 32;
        int i5 = i3 + 2;
        long j6 = j5 + (((long) iArr[i5]) & BodyPartID.bodyIdMax);
        iArr[i5] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(4, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = iArr2[i2];
        long j2 = BodyPartID.bodyIdMax;
        long j3 = j & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax;
        int i4 = 0;
        long j7 = 0;
        int i5 = i3;
        while (i4 < 4) {
            long j8 = ((long) iArr[i + i4]) & j2;
            long j9 = j3;
            long j10 = (j8 * j3) + (((long) iArr3[i5]) & j2);
            iArr3[i5] = (int) j10;
            int i6 = i5 + 1;
            long j11 = (j10 >>> 32) + (j8 * j4) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j11;
            int i7 = i5 + 2;
            long j12 = (j11 >>> 32) + (j8 * j5) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax);
            iArr3[i7] = (int) j12;
            int i8 = i5 + 3;
            long j13 = (j12 >>> 32) + (j8 * j6) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax);
            iArr3[i8] = (int) j13;
            int i9 = i5 + 4;
            long j14 = j7 + (j13 >>> 32) + (((long) iArr3[i9]) & BodyPartID.bodyIdMax);
            iArr3[i9] = (int) j14;
            j7 = j14 >>> 32;
            i4++;
            i5 = i6;
            j2 = 4294967295L;
            j3 = j9;
            j4 = j4;
        }
        return (int) j7;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
        long j5 = 0;
        while (i < 4) {
            long j6 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
            long j7 = j;
            long j8 = (((long) iArr3[i]) & BodyPartID.bodyIdMax) + (j6 * j);
            iArr3[i] = (int) j8;
            int i2 = i + 1;
            long j9 = (j8 >>> 32) + (j6 * j2) + (((long) iArr3[i2]) & BodyPartID.bodyIdMax);
            iArr3[i2] = (int) j9;
            int i3 = i + 2;
            long j10 = (j9 >>> 32) + (j6 * j3) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax);
            iArr3[i3] = (int) j10;
            int i4 = i + 3;
            long j11 = (j10 >>> 32) + (j6 * j4) + (((long) iArr3[i4]) & BodyPartID.bodyIdMax);
            iArr3[i4] = (int) j11;
            int i5 = i + 4;
            long j12 = j5 + (j11 >>> 32) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax);
            iArr3[i5] = (int) j12;
            j5 = j12 >>> 32;
            i = i2;
            j = j7;
            j2 = j2;
        }
        return (int) j5;
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((((long) iArr[i3]) & BodyPartID.bodyIdMax) * j);
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 4);
        return (int) j2;
    }

    public static int mulWordAddExt(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = ((((long) iArr[i2]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i3]) & BodyPartID.bodyIdMax);
        iArr2[i3] = (int) j2;
        int i4 = i3 + 1;
        long j3 = (j2 >>> 32) + ((((long) iArr[i2 + 1]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i4]) & BodyPartID.bodyIdMax);
        iArr2[i4] = (int) j3;
        int i5 = i3 + 2;
        long j4 = (j3 >>> 32) + ((((long) iArr[i2 + 2]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i5]) & BodyPartID.bodyIdMax);
        iArr2[i5] = (int) j4;
        int i6 = i3 + 3;
        long j5 = (j4 >>> 32) + (j * (((long) iArr[i2 + 3]) & BodyPartID.bodyIdMax)) + (((long) iArr2[i6]) & BodyPartID.bodyIdMax);
        iArr2[i6] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & BodyPartID.bodyIdMax;
        long j3 = ((j & BodyPartID.bodyIdMax) * j2) + (((long) iArr[i2]) & BodyPartID.bodyIdMax);
        iArr[i2] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i3 = i2 + 1;
        long j5 = (j3 >>> 32) + j4 + (((long) iArr[i3]) & BodyPartID.bodyIdMax);
        iArr[i3] = (int) j5;
        int i4 = i2 + 2;
        long j6 = (j5 >>> 32) + (((long) iArr[i4]) & BodyPartID.bodyIdMax);
        iArr[i4] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(4, iArr, i2, 3);
    }

    public static int mulWordsAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((((long) i2) & BodyPartID.bodyIdMax) * (((long) i) & BodyPartID.bodyIdMax)) + (((long) iArr[i3]) & BodyPartID.bodyIdMax);
        iArr[i3] = (int) j;
        int i4 = i3 + 1;
        long j2 = (j >>> 32) + (BodyPartID.bodyIdMax & ((long) iArr[i4]));
        iArr[i4] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(4, iArr, i3, 2);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i]) & BodyPartID.bodyIdMax;
        int i3 = 0;
        int i4 = 8;
        int i5 = 3;
        while (true) {
            int i6 = i5 - 1;
            long j2 = ((long) iArr[i + i5]) & BodyPartID.bodyIdMax;
            long j3 = j2 * j2;
            iArr2[i2 + (i4 - 1)] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 -= 2;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                long j5 = (j4 >>> 33) | (((long) (i3 << 31)) & BodyPartID.bodyIdMax);
                iArr2[i2] = (int) j4;
                int i7 = ((int) (j4 >>> 32)) & 1;
                long j6 = ((long) iArr[i + 1]) & BodyPartID.bodyIdMax;
                int i8 = i2 + 2;
                long j7 = ((long) iArr2[i8]) & BodyPartID.bodyIdMax;
                long j8 = j5 + (j6 * j);
                int i9 = (int) j8;
                iArr2[i2 + 1] = (i9 << 1) | i7;
                int i10 = i9 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[i + 2]) & BodyPartID.bodyIdMax;
                int i11 = i2 + 3;
                long j11 = ((long) iArr2[i11]) & BodyPartID.bodyIdMax;
                int i12 = i2 + 4;
                long j12 = ((long) iArr2[i12]) & BodyPartID.bodyIdMax;
                long j13 = j9 + (j10 * j);
                int i13 = (int) j13;
                iArr2[i8] = (i13 << 1) | i10;
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & BodyPartID.bodyIdMax;
                long j17 = ((long) iArr[i + 3]) & BodyPartID.bodyIdMax;
                int i14 = i2 + 5;
                long j18 = (((long) iArr2[i14]) & BodyPartID.bodyIdMax) + (j15 >>> 32);
                long j19 = j15 & BodyPartID.bodyIdMax;
                int i15 = i2 + 6;
                long j20 = (((long) iArr2[i15]) & BodyPartID.bodyIdMax) + (j18 >>> 32);
                long j21 = BodyPartID.bodyIdMax & j18;
                long j22 = j16 + (j * j17);
                int i16 = (int) j22;
                iArr2[i11] = (i16 << 1) | (i13 >>> 31);
                long j23 = j19 + (j22 >>> 32) + (j6 * j17);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j20 + (j24 >>> 32);
                int i17 = (int) j23;
                iArr2[i12] = (i16 >>> 31) | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) j24;
                iArr2[i14] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j25;
                iArr2[i15] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = i2 + 7;
                iArr2[i23] = i22 | ((iArr2[i23] + ((int) (j25 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & BodyPartID.bodyIdMax;
        int i = 8;
        int i2 = 0;
        int i3 = 3;
        while (true) {
            int i4 = i3 - 1;
            long j2 = ((long) iArr[i3]) & BodyPartID.bodyIdMax;
            long j3 = j2 * j2;
            iArr2[i - 1] = (i2 << 31) | ((int) (j3 >>> 33));
            i -= 2;
            iArr2[i] = (int) (j3 >>> 1);
            i2 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (j4 >>> 33) | (((long) (i2 << 31)) & BodyPartID.bodyIdMax);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & BodyPartID.bodyIdMax;
                long j7 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
                long j8 = j5 + (j6 * j);
                int i5 = (int) j8;
                iArr2[1] = (i5 << 1) | (((int) (j4 >>> 32)) & 1);
                int i6 = i5 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & BodyPartID.bodyIdMax;
                long j11 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
                long j12 = ((long) iArr2[4]) & BodyPartID.bodyIdMax;
                long j13 = j9 + (j10 * j);
                int i7 = (int) j13;
                iArr2[2] = (i7 << 1) | i6;
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & BodyPartID.bodyIdMax;
                long j17 = ((long) iArr[3]) & BodyPartID.bodyIdMax;
                long j18 = (((long) iArr2[5]) & BodyPartID.bodyIdMax) + (j15 >>> 32);
                long j19 = j15 & BodyPartID.bodyIdMax;
                long j20 = (((long) iArr2[6]) & BodyPartID.bodyIdMax) + (j18 >>> 32);
                long j21 = j18 & BodyPartID.bodyIdMax;
                long j22 = j16 + (j * j17);
                int i8 = (int) j22;
                iArr2[3] = (i8 << 1) | (i7 >>> 31);
                long j23 = j19 + (j22 >>> 32) + (j6 * j17);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j20 + (j24 >>> 32);
                long j26 = j24 & BodyPartID.bodyIdMax;
                int i9 = (int) j23;
                iArr2[4] = (i8 >>> 31) | (i9 << 1);
                int i10 = (int) j26;
                iArr2[5] = (i9 >>> 31) | (i10 << 1);
                int i11 = i10 >>> 31;
                int i12 = (int) j25;
                iArr2[6] = i11 | (i12 << 1);
                iArr2[7] = ((iArr2[7] + ((int) (j25 >>> 32))) << 1) | (i12 >>> 31);
                return;
            }
            i3 = i4;
        }
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2]) & BodyPartID.bodyIdMax);
        iArr3[i3] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) - (((long) iArr2[0]) & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & BodyPartID.bodyIdMax) - (((long) iArr2[1]) & BodyPartID.bodyIdMax));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & BodyPartID.bodyIdMax) - (((long) iArr2[2]) & BodyPartID.bodyIdMax));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & BodyPartID.bodyIdMax) - (((long) iArr2[3]) & BodyPartID.bodyIdMax));
        iArr3[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr3[0]) & BodyPartID.bodyIdMax) - (((long) iArr[0]) & BodyPartID.bodyIdMax)) - (((long) iArr2[0]) & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((((long) iArr3[1]) & BodyPartID.bodyIdMax) - (((long) iArr[1]) & BodyPartID.bodyIdMax)) - (((long) iArr2[1]) & BodyPartID.bodyIdMax));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((((long) iArr3[2]) & BodyPartID.bodyIdMax) - (((long) iArr[2]) & BodyPartID.bodyIdMax)) - (((long) iArr2[2]) & BodyPartID.bodyIdMax));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((((long) iArr3[3]) & BodyPartID.bodyIdMax) - (((long) iArr[3]) & BodyPartID.bodyIdMax)) - (((long) iArr2[3]) & BodyPartID.bodyIdMax));
        iArr3[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        long j = (((long) iArr2[i2]) & BodyPartID.bodyIdMax) - (((long) iArr[i]) & BodyPartID.bodyIdMax);
        iArr2[i2] = (int) j;
        int i3 = i2 + 1;
        long j2 = (j >> 32) + ((((long) iArr2[i3]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 1]) & BodyPartID.bodyIdMax));
        iArr2[i3] = (int) j2;
        int i4 = i2 + 2;
        long j3 = (j2 >> 32) + ((((long) iArr2[i4]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 2]) & BodyPartID.bodyIdMax));
        iArr2[i4] = (int) j3;
        int i5 = i2 + 3;
        long j4 = (j3 >> 32) + ((((long) iArr2[i5]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 3]) & BodyPartID.bodyIdMax));
        iArr2[i5] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = (((long) iArr2[0]) & BodyPartID.bodyIdMax) - (((long) iArr[0]) & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & BodyPartID.bodyIdMax) - (((long) iArr[1]) & BodyPartID.bodyIdMax));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & BodyPartID.bodyIdMax) - (((long) iArr[2]) & BodyPartID.bodyIdMax));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & BodyPartID.bodyIdMax) - (BodyPartID.bodyIdMax & ((long) iArr[3])));
        iArr2[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (3 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 2; i++) {
            long j = jArr[i];
            if (j != 0) {
                Pack.longToBigEndian(j, bArr, (1 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
    }
}
