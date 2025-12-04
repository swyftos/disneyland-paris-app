package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Pack;

/* loaded from: classes6.dex */
public abstract class Nat160 {
    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & BodyPartID.bodyIdMax) + (iArr2[0] & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & BodyPartID.bodyIdMax) + (iArr2[1] & BodyPartID.bodyIdMax);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & BodyPartID.bodyIdMax) + (iArr2[2] & BodyPartID.bodyIdMax);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & BodyPartID.bodyIdMax) + (iArr2[3] & BodyPartID.bodyIdMax);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & BodyPartID.bodyIdMax) + (iArr2[4] & BodyPartID.bodyIdMax);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & BodyPartID.bodyIdMax) + (iArr2[0] & BodyPartID.bodyIdMax) + (iArr3[0] & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & BodyPartID.bodyIdMax) + (iArr2[1] & BodyPartID.bodyIdMax) + (iArr3[1] & BodyPartID.bodyIdMax);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & BodyPartID.bodyIdMax) + (iArr2[2] & BodyPartID.bodyIdMax) + (iArr3[2] & BodyPartID.bodyIdMax);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & BodyPartID.bodyIdMax) + (iArr2[3] & BodyPartID.bodyIdMax) + (iArr3[3] & BodyPartID.bodyIdMax);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & BodyPartID.bodyIdMax) + (iArr2[4] & BodyPartID.bodyIdMax) + (iArr3[4] & BodyPartID.bodyIdMax);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        long j = (i3 & BodyPartID.bodyIdMax) + (iArr[i] & BodyPartID.bodyIdMax) + (iArr2[i2] & BodyPartID.bodyIdMax);
        iArr2[i2] = (int) j;
        long j2 = (j >>> 32) + (iArr[i + 1] & BodyPartID.bodyIdMax) + (iArr2[r6] & BodyPartID.bodyIdMax);
        iArr2[i2 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[i + 2] & BodyPartID.bodyIdMax) + (iArr2[r6] & BodyPartID.bodyIdMax);
        iArr2[i2 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[i + 3] & BodyPartID.bodyIdMax) + (iArr2[r6] & BodyPartID.bodyIdMax);
        iArr2[i2 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[i + 4] & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & iArr2[r12]);
        iArr2[i2 + 4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (iArr[0] & BodyPartID.bodyIdMax) + (iArr2[0] & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & BodyPartID.bodyIdMax) + (iArr2[1] & BodyPartID.bodyIdMax);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & BodyPartID.bodyIdMax) + (iArr2[2] & BodyPartID.bodyIdMax);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & BodyPartID.bodyIdMax) + (iArr2[3] & BodyPartID.bodyIdMax);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & iArr2[4]);
        iArr2[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        long j = (iArr[i] & BodyPartID.bodyIdMax) + (iArr2[i2] & BodyPartID.bodyIdMax);
        int i3 = (int) j;
        iArr[i] = i3;
        iArr2[i2] = i3;
        long j2 = (j >>> 32) + (iArr[r5] & BodyPartID.bodyIdMax) + (iArr2[r8] & BodyPartID.bodyIdMax);
        int i4 = (int) j2;
        iArr[i + 1] = i4;
        iArr2[i2 + 1] = i4;
        long j3 = (j2 >>> 32) + (iArr[r5] & BodyPartID.bodyIdMax) + (iArr2[r8] & BodyPartID.bodyIdMax);
        int i5 = (int) j3;
        iArr[i + 2] = i5;
        iArr2[i2 + 2] = i5;
        long j4 = (j3 >>> 32) + (iArr[r5] & BodyPartID.bodyIdMax) + (iArr2[r8] & BodyPartID.bodyIdMax);
        int i6 = (int) j4;
        iArr[i + 3] = i6;
        iArr2[i2 + 3] = i6;
        long j5 = (j4 >>> 32) + (iArr[r12] & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & iArr2[r14]);
        int i7 = (int) j5;
        iArr[i + 4] = i7;
        iArr2[i2 + 4] = i7;
        return (int) (j5 >>> 32);
    }

    public static void copy(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2] = iArr[i];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
    }

    public static int[] create() {
        return new int[5];
    }

    public static int[] createExt() {
        return new int[10];
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

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] iArrCreate = create();
        for (int i = 0; i < 5; i++) {
            iArrCreate[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrCreate;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 5) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 4; i3 >= 0; i3--) {
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
        for (int i = 4; i >= 0; i--) {
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
        for (int i = 1; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = iArr2[i2] & BodyPartID.bodyIdMax;
        long j2 = iArr2[i2 + 1] & BodyPartID.bodyIdMax;
        long j3 = iArr2[i2 + 2] & BodyPartID.bodyIdMax;
        long j4 = iArr2[i2 + 3] & BodyPartID.bodyIdMax;
        long j5 = iArr2[i2 + 4] & BodyPartID.bodyIdMax;
        long j6 = iArr[i] & BodyPartID.bodyIdMax;
        long j7 = j6 * j;
        iArr3[i3] = (int) j7;
        long j8 = (j7 >>> 32) + (j6 * j2);
        iArr3[i3 + 1] = (int) j8;
        long j9 = (j8 >>> 32) + (j6 * j3);
        iArr3[i3 + 2] = (int) j9;
        long j10 = (j9 >>> 32) + (j6 * j4);
        iArr3[i3 + 3] = (int) j10;
        long j11 = (j10 >>> 32) + (j6 * j5);
        iArr3[i3 + 4] = (int) j11;
        iArr3[i3 + 5] = (int) (j11 >>> 32);
        int i4 = 1;
        int i5 = i3;
        while (i4 < 5) {
            int i6 = i5 + 1;
            long j12 = iArr[i + i4] & BodyPartID.bodyIdMax;
            long j13 = j;
            long j14 = (j12 * j) + (iArr3[i6] & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j14;
            long j15 = (j14 >>> 32) + (j12 * j2) + (iArr3[r22] & BodyPartID.bodyIdMax);
            iArr3[i5 + 2] = (int) j15;
            long j16 = j3;
            long j17 = (j15 >>> 32) + (j12 * j3) + (iArr3[r16] & BodyPartID.bodyIdMax);
            iArr3[i5 + 3] = (int) j17;
            int i7 = i5;
            long j18 = (j17 >>> 32) + (j12 * j4) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i5 + 4] = (int) j18;
            long j19 = (j18 >>> 32) + (j12 * j5) + (iArr3[r3] & BodyPartID.bodyIdMax);
            iArr3[i7 + 5] = (int) j19;
            iArr3[i7 + 6] = (int) (j19 >>> 32);
            i4++;
            i5 = i6;
            j = j13;
            j3 = j16;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = iArr2[0] & BodyPartID.bodyIdMax;
        int i = 1;
        long j2 = iArr2[1] & BodyPartID.bodyIdMax;
        long j3 = iArr2[2] & BodyPartID.bodyIdMax;
        long j4 = iArr2[3] & BodyPartID.bodyIdMax;
        long j5 = iArr2[4] & BodyPartID.bodyIdMax;
        long j6 = iArr[0] & BodyPartID.bodyIdMax;
        long j7 = j6 * j;
        iArr3[0] = (int) j7;
        long j8 = (j7 >>> 32) + (j6 * j2);
        iArr3[1] = (int) j8;
        long j9 = (j8 >>> 32) + (j6 * j3);
        iArr3[2] = (int) j9;
        long j10 = (j9 >>> 32) + (j6 * j4);
        iArr3[3] = (int) j10;
        long j11 = (j10 >>> 32) + (j6 * j5);
        iArr3[4] = (int) j11;
        iArr3[5] = (int) (j11 >>> 32);
        for (int i2 = 5; i < i2; i2 = 5) {
            long j12 = iArr[i] & BodyPartID.bodyIdMax;
            long j13 = (j12 * j) + (iArr3[i] & BodyPartID.bodyIdMax);
            iArr3[i] = (int) j13;
            int i3 = i + 1;
            long j14 = (j13 >>> 32) + (j12 * j2) + (iArr3[i3] & BodyPartID.bodyIdMax);
            iArr3[i3] = (int) j14;
            long j15 = j2;
            long j16 = (j14 >>> 32) + (j12 * j3) + (iArr3[r16] & BodyPartID.bodyIdMax);
            iArr3[i + 2] = (int) j16;
            long j17 = (j16 >>> 32) + (j12 * j4) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 3] = (int) j17;
            long j18 = (j17 >>> 32) + (j12 * j5) + (iArr3[r3] & BodyPartID.bodyIdMax);
            iArr3[i + 4] = (int) j18;
            iArr3[i + 5] = (int) (j18 >>> 32);
            j4 = j4;
            j = j;
            i = i3;
            j2 = j15;
        }
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = i & BodyPartID.bodyIdMax;
        long j2 = iArr[i2] & BodyPartID.bodyIdMax;
        long j3 = (j * j2) + (iArr2[i3] & BodyPartID.bodyIdMax);
        iArr3[i4] = (int) j3;
        long j4 = iArr[i2 + 1] & BodyPartID.bodyIdMax;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (iArr2[i3 + 1] & BodyPartID.bodyIdMax);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = iArr[i2 + 2] & BodyPartID.bodyIdMax;
        long j8 = j6 + (j * j7) + j4 + (iArr2[i3 + 2] & BodyPartID.bodyIdMax);
        iArr3[i4 + 2] = (int) j8;
        long j9 = iArr[i2 + 3] & BodyPartID.bodyIdMax;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (iArr2[i3 + 3] & BodyPartID.bodyIdMax);
        iArr3[i4 + 3] = (int) j10;
        long j11 = iArr[i2 + 4] & BodyPartID.bodyIdMax;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (BodyPartID.bodyIdMax & iArr2[i3 + 4]);
        iArr3[i4 + 4] = (int) j12;
        return (j12 >>> 32) + j11;
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = i & BodyPartID.bodyIdMax;
        long j3 = j & BodyPartID.bodyIdMax;
        long j4 = (j2 * j3) + (iArr[i2] & BodyPartID.bodyIdMax);
        iArr[i2] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        long j7 = (j4 >>> 32) + j6 + (iArr[r4] & BodyPartID.bodyIdMax);
        iArr[i2 + 1] = (int) j7;
        long j8 = (j7 >>> 32) + j5 + (iArr[r4] & BodyPartID.bodyIdMax);
        iArr[i2 + 2] = (int) j8;
        long j9 = j8 >>> 32;
        long j10 = j9 + (iArr[r0] & BodyPartID.bodyIdMax);
        iArr[i2 + 3] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i2, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = i & BodyPartID.bodyIdMax;
        long j2 = i2 & BodyPartID.bodyIdMax;
        long j3 = (j * j2) + (iArr[i3] & BodyPartID.bodyIdMax);
        iArr[i3] = (int) j3;
        long j4 = (j3 >>> 32) + j2 + (iArr[r5] & BodyPartID.bodyIdMax);
        iArr[i3 + 1] = (int) j4;
        long j5 = j4 >>> 32;
        long j6 = j5 + (iArr[r0] & BodyPartID.bodyIdMax);
        iArr[i3 + 2] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = iArr2[i2] & BodyPartID.bodyIdMax;
        long j2 = iArr2[i2 + 1] & BodyPartID.bodyIdMax;
        long j3 = iArr2[i2 + 2] & BodyPartID.bodyIdMax;
        long j4 = iArr2[i2 + 3] & BodyPartID.bodyIdMax;
        long j5 = iArr2[i2 + 4] & BodyPartID.bodyIdMax;
        int i4 = 0;
        long j6 = 0;
        int i5 = i3;
        while (i4 < 5) {
            long j7 = iArr[i + i4] & BodyPartID.bodyIdMax;
            long j8 = j;
            long j9 = (j7 * j) + (iArr3[i5] & BodyPartID.bodyIdMax);
            iArr3[i5] = (int) j9;
            int i6 = i5 + 1;
            long j10 = (j9 >>> 32) + (j7 * j2) + (iArr3[i6] & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j10;
            long j11 = (j10 >>> 32) + (j7 * j3) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 2] = (int) j11;
            long j12 = (j11 >>> 32) + (j7 * j4) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 3] = (int) j12;
            long j13 = (j12 >>> 32) + (j7 * j5) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 4] = (int) j13;
            long j14 = j6 + (j13 >>> 32) + (iArr3[r12] & BodyPartID.bodyIdMax);
            iArr3[i5 + 5] = (int) j14;
            j6 = j14 >>> 32;
            i4++;
            i5 = i6;
            j = j8;
            j2 = j2;
        }
        return (int) j6;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = iArr2[0] & BodyPartID.bodyIdMax;
        long j2 = iArr2[1] & BodyPartID.bodyIdMax;
        long j3 = iArr2[2] & BodyPartID.bodyIdMax;
        long j4 = iArr2[3] & BodyPartID.bodyIdMax;
        long j5 = iArr2[4] & BodyPartID.bodyIdMax;
        long j6 = 0;
        while (i < 5) {
            long j7 = j6;
            long j8 = iArr[i] & BodyPartID.bodyIdMax;
            long j9 = j;
            long j10 = (j8 * j) + (iArr3[i] & BodyPartID.bodyIdMax);
            iArr3[i] = (int) j10;
            int i2 = i + 1;
            long j11 = (j10 >>> 32) + (j8 * j2) + (iArr3[i2] & BodyPartID.bodyIdMax);
            iArr3[i2] = (int) j11;
            long j12 = (j11 >>> 32) + (j8 * j3) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 2] = (int) j12;
            long j13 = (j12 >>> 32) + (j8 * j4) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 3] = (int) j13;
            long j14 = (j13 >>> 32) + (j8 * j5) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 4] = (int) j14;
            long j15 = j7 + (j14 >>> 32) + (iArr3[r0] & BodyPartID.bodyIdMax);
            iArr3[i + 5] = (int) j15;
            j6 = j15 >>> 32;
            j = j9;
            i = i2;
            j2 = j2;
        }
        return (int) j6;
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = i & BodyPartID.bodyIdMax;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((iArr[i3] & BodyPartID.bodyIdMax) * j);
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 5);
        return (int) j2;
    }

    public static int mulWordAddExt(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = i & BodyPartID.bodyIdMax;
        long j2 = ((iArr[i2] & BodyPartID.bodyIdMax) * j) + (iArr2[i3] & BodyPartID.bodyIdMax);
        iArr2[i3] = (int) j2;
        long j3 = (j2 >>> 32) + ((iArr[i2 + 1] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 1] = (int) j3;
        long j4 = (j3 >>> 32) + ((iArr[i2 + 2] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 2] = (int) j4;
        long j5 = (j4 >>> 32) + ((iArr[i2 + 3] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 3] = (int) j5;
        long j6 = (j5 >>> 32) + (j * (iArr[i2 + 4] & BodyPartID.bodyIdMax)) + (iArr2[r15] & BodyPartID.bodyIdMax);
        iArr2[i3 + 4] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = i & BodyPartID.bodyIdMax;
        long j3 = ((j & BodyPartID.bodyIdMax) * j2) + (iArr[i2] & BodyPartID.bodyIdMax);
        iArr[i2] = (int) j3;
        long j4 = j2 * (j >>> 32);
        long j5 = (j3 >>> 32) + j4 + (iArr[r9] & BodyPartID.bodyIdMax);
        iArr[i2 + 1] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[r0] & BodyPartID.bodyIdMax);
        iArr[i2 + 2] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i2, 3);
    }

    public static int mulWordsAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((i2 & BodyPartID.bodyIdMax) * (i & BodyPartID.bodyIdMax)) + (iArr[i3] & BodyPartID.bodyIdMax);
        iArr[i3] = (int) j;
        long j2 = (j >>> 32) + (BodyPartID.bodyIdMax & iArr[r1]);
        iArr[i3 + 1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i3, 2);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = iArr[i] & BodyPartID.bodyIdMax;
        int i3 = 0;
        int i4 = 10;
        int i5 = 4;
        while (true) {
            int i6 = i5 - 1;
            long j2 = iArr[i + i5] & BodyPartID.bodyIdMax;
            long j3 = j2 * j2;
            iArr2[i2 + (i4 - 1)] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 -= 2;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                long j5 = (j4 >>> 33) | ((i3 << 31) & BodyPartID.bodyIdMax);
                iArr2[i2] = (int) j4;
                int i7 = ((int) (j4 >>> 32)) & 1;
                long j6 = iArr[i + 1] & BodyPartID.bodyIdMax;
                long j7 = iArr2[r12] & BodyPartID.bodyIdMax;
                long j8 = j5 + (j6 * j);
                int i8 = (int) j8;
                iArr2[i2 + 1] = (i8 << 1) | i7;
                int i9 = i8 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = iArr[i + 2] & BodyPartID.bodyIdMax;
                long j11 = iArr2[r15] & BodyPartID.bodyIdMax;
                long j12 = iArr2[r7] & BodyPartID.bodyIdMax;
                long j13 = j9 + (j10 * j);
                int i10 = (int) j13;
                iArr2[i2 + 2] = (i10 << 1) | i9;
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & BodyPartID.bodyIdMax;
                long j17 = iArr[i + 3] & BodyPartID.bodyIdMax;
                long j18 = (iArr2[r20] & BodyPartID.bodyIdMax) + (j15 >>> 32);
                long j19 = j15 & BodyPartID.bodyIdMax;
                long j20 = (iArr2[r24] & BodyPartID.bodyIdMax) + (j18 >>> 32);
                long j21 = j18 & BodyPartID.bodyIdMax;
                long j22 = j16 + (j17 * j);
                int i11 = (int) j22;
                iArr2[i2 + 3] = (i11 << 1) | (i10 >>> 31);
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j23 & BodyPartID.bodyIdMax;
                long j26 = j20 + (j24 >>> 32);
                long j27 = j24 & BodyPartID.bodyIdMax;
                long j28 = iArr[i + 4] & BodyPartID.bodyIdMax;
                long j29 = (iArr2[r3] & BodyPartID.bodyIdMax) + (j26 >>> 32);
                long j30 = j26 & BodyPartID.bodyIdMax;
                long j31 = (iArr2[r19] & BodyPartID.bodyIdMax) + (j29 >>> 32);
                long j32 = j29 & BodyPartID.bodyIdMax;
                long j33 = j25 + (j * j28);
                int i12 = (int) j33;
                iArr2[i2 + 4] = (i12 << 1) | (i11 >>> 31);
                long j34 = j27 + (j33 >>> 32) + (j6 * j28);
                long j35 = j30 + (j34 >>> 32) + (j28 * j10);
                long j36 = j32 + (j35 >>> 32) + (j28 * j17);
                long j37 = j31 + (j36 >>> 32);
                int i13 = (int) j34;
                iArr2[i2 + 5] = (i12 >>> 31) | (i13 << 1);
                int i14 = (int) j35;
                iArr2[i2 + 6] = (i13 >>> 31) | (i14 << 1);
                int i15 = i14 >>> 31;
                int i16 = (int) j36;
                iArr2[i2 + 7] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) j37;
                iArr2[i2 + 8] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = i2 + 9;
                iArr2[i20] = i19 | ((iArr2[i20] + ((int) (j37 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = iArr[0] & BodyPartID.bodyIdMax;
        int i = 10;
        int i2 = 0;
        int i3 = 4;
        while (true) {
            int i4 = i3 - 1;
            long j2 = iArr[i3] & BodyPartID.bodyIdMax;
            long j3 = j2 * j2;
            iArr2[i - 1] = (i2 << 31) | ((int) (j3 >>> 33));
            i -= 2;
            iArr2[i] = (int) (j3 >>> 1);
            i2 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (j4 >>> 33) | ((i2 << 31) & BodyPartID.bodyIdMax);
                iArr2[0] = (int) j4;
                long j6 = iArr[1] & BodyPartID.bodyIdMax;
                long j7 = iArr2[2] & BodyPartID.bodyIdMax;
                long j8 = j5 + (j6 * j);
                int i5 = (int) j8;
                iArr2[1] = (i5 << 1) | (((int) (j4 >>> 32)) & 1);
                long j9 = j7 + (j8 >>> 32);
                long j10 = iArr[2] & BodyPartID.bodyIdMax;
                long j11 = iArr2[3] & BodyPartID.bodyIdMax;
                long j12 = iArr2[4] & BodyPartID.bodyIdMax;
                long j13 = j9 + (j10 * j);
                int i6 = (int) j13;
                iArr2[2] = (i6 << 1) | (i5 >>> 31);
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & BodyPartID.bodyIdMax;
                long j17 = iArr[3] & BodyPartID.bodyIdMax;
                long j18 = (iArr2[5] & BodyPartID.bodyIdMax) + (j15 >>> 32);
                long j19 = j15 & BodyPartID.bodyIdMax;
                long j20 = (iArr2[6] & BodyPartID.bodyIdMax) + (j18 >>> 32);
                long j21 = j18 & BodyPartID.bodyIdMax;
                long j22 = j16 + (j17 * j);
                int i7 = (int) j22;
                iArr2[3] = (i7 << 1) | (i6 >>> 31);
                int i8 = i7 >>> 31;
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j23 & BodyPartID.bodyIdMax;
                long j26 = j20 + (j24 >>> 32);
                long j27 = j24 & BodyPartID.bodyIdMax;
                long j28 = iArr[4] & BodyPartID.bodyIdMax;
                long j29 = (iArr2[7] & BodyPartID.bodyIdMax) + (j26 >>> 32);
                long j30 = j26 & BodyPartID.bodyIdMax;
                long j31 = (iArr2[8] & BodyPartID.bodyIdMax) + (j29 >>> 32);
                long j32 = BodyPartID.bodyIdMax & j29;
                long j33 = j25 + (j28 * j);
                int i9 = (int) j33;
                iArr2[4] = i8 | (i9 << 1);
                long j34 = j27 + (j33 >>> 32) + (j6 * j28);
                long j35 = j30 + (j34 >>> 32) + (j28 * j10);
                long j36 = j32 + (j35 >>> 32) + (j28 * j17);
                long j37 = j31 + (j36 >>> 32);
                int i10 = (int) j34;
                iArr2[5] = (i9 >>> 31) | (i10 << 1);
                int i11 = (int) j35;
                iArr2[6] = (i11 << 1) | (i10 >>> 31);
                int i12 = (int) j36;
                iArr2[7] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                int i14 = (int) j37;
                iArr2[8] = i13 | (i14 << 1);
                iArr2[9] = (i14 >>> 31) | ((iArr2[9] + ((int) (j37 >>> 32))) << 1);
                return;
            }
            i3 = i4;
        }
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (iArr[i] & BodyPartID.bodyIdMax) - (iArr2[i2] & BodyPartID.bodyIdMax);
        iArr3[i3] = (int) j;
        long j2 = (j >> 32) + ((iArr[i + 1] & BodyPartID.bodyIdMax) - (iArr2[i2 + 1] & BodyPartID.bodyIdMax));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[i + 2] & BodyPartID.bodyIdMax) - (iArr2[i2 + 2] & BodyPartID.bodyIdMax));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[i + 3] & BodyPartID.bodyIdMax) - (iArr2[i2 + 3] & BodyPartID.bodyIdMax));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[i + 4] & BodyPartID.bodyIdMax) - (iArr2[i2 + 4] & BodyPartID.bodyIdMax));
        iArr3[i3 + 4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & BodyPartID.bodyIdMax) - (iArr2[0] & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((iArr[1] & BodyPartID.bodyIdMax) - (iArr2[1] & BodyPartID.bodyIdMax));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[2] & BodyPartID.bodyIdMax) - (iArr2[2] & BodyPartID.bodyIdMax));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[3] & BodyPartID.bodyIdMax) - (iArr2[3] & BodyPartID.bodyIdMax));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[4] & BodyPartID.bodyIdMax) - (iArr2[4] & BodyPartID.bodyIdMax));
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((iArr3[0] & BodyPartID.bodyIdMax) - (iArr[0] & BodyPartID.bodyIdMax)) - (iArr2[0] & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((iArr3[1] & BodyPartID.bodyIdMax) - (iArr[1] & BodyPartID.bodyIdMax)) - (iArr2[1] & BodyPartID.bodyIdMax));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((iArr3[2] & BodyPartID.bodyIdMax) - (iArr[2] & BodyPartID.bodyIdMax)) - (iArr2[2] & BodyPartID.bodyIdMax));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((iArr3[3] & BodyPartID.bodyIdMax) - (iArr[3] & BodyPartID.bodyIdMax)) - (iArr2[3] & BodyPartID.bodyIdMax));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + (((iArr3[4] & BodyPartID.bodyIdMax) - (iArr[4] & BodyPartID.bodyIdMax)) - (iArr2[4] & BodyPartID.bodyIdMax));
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        long j = (iArr2[i2] & BodyPartID.bodyIdMax) - (iArr[i] & BodyPartID.bodyIdMax);
        iArr2[i2] = (int) j;
        long j2 = (j >> 32) + ((iArr2[r5] & BodyPartID.bodyIdMax) - (iArr[i + 1] & BodyPartID.bodyIdMax));
        iArr2[i2 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr2[r5] & BodyPartID.bodyIdMax) - (iArr[i + 2] & BodyPartID.bodyIdMax));
        iArr2[i2 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr2[r5] & BodyPartID.bodyIdMax) - (iArr[i + 3] & BodyPartID.bodyIdMax));
        iArr2[i2 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr2[r13] & BodyPartID.bodyIdMax) - (iArr[i + 4] & BodyPartID.bodyIdMax));
        iArr2[i2 + 4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = (iArr2[0] & BodyPartID.bodyIdMax) - (iArr[0] & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((iArr2[1] & BodyPartID.bodyIdMax) - (iArr[1] & BodyPartID.bodyIdMax));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr2[2] & BodyPartID.bodyIdMax) - (iArr[2] & BodyPartID.bodyIdMax));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr2[3] & BodyPartID.bodyIdMax) - (iArr[3] & BodyPartID.bodyIdMax));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr2[4] & BodyPartID.bodyIdMax) - (BodyPartID.bodyIdMax & iArr[4]));
        iArr2[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
    }
}
