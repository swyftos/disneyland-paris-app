package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Pack;

/* loaded from: classes6.dex */
public abstract class Nat224 {
    public static int add(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (iArr[i] & BodyPartID.bodyIdMax) + (iArr2[i2] & BodyPartID.bodyIdMax);
        iArr3[i3] = (int) j;
        long j2 = (j >>> 32) + (iArr[i + 1] & BodyPartID.bodyIdMax) + (iArr2[i2 + 1] & BodyPartID.bodyIdMax);
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[i + 2] & BodyPartID.bodyIdMax) + (iArr2[i2 + 2] & BodyPartID.bodyIdMax);
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[i + 3] & BodyPartID.bodyIdMax) + (iArr2[i2 + 3] & BodyPartID.bodyIdMax);
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[i + 4] & BodyPartID.bodyIdMax) + (iArr2[i2 + 4] & BodyPartID.bodyIdMax);
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[i + 5] & BodyPartID.bodyIdMax) + (iArr2[i2 + 5] & BodyPartID.bodyIdMax);
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[i + 6] & BodyPartID.bodyIdMax) + (iArr2[i2 + 6] & BodyPartID.bodyIdMax);
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >>> 32);
    }

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
        long j6 = (j5 >>> 32) + (iArr[5] & BodyPartID.bodyIdMax) + (iArr2[5] & BodyPartID.bodyIdMax);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[6] & BodyPartID.bodyIdMax) + (iArr2[6] & BodyPartID.bodyIdMax);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (iArr[i] & BodyPartID.bodyIdMax) + (iArr2[i2] & BodyPartID.bodyIdMax) + (iArr3[i3] & BodyPartID.bodyIdMax);
        iArr3[i3] = (int) j;
        long j2 = (j >>> 32) + (iArr[i + 1] & BodyPartID.bodyIdMax) + (iArr2[i2 + 1] & BodyPartID.bodyIdMax) + (iArr3[r7] & BodyPartID.bodyIdMax);
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[i + 2] & BodyPartID.bodyIdMax) + (iArr2[i2 + 2] & BodyPartID.bodyIdMax) + (iArr3[r7] & BodyPartID.bodyIdMax);
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[i + 3] & BodyPartID.bodyIdMax) + (iArr2[i2 + 3] & BodyPartID.bodyIdMax) + (iArr3[r7] & BodyPartID.bodyIdMax);
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[i + 4] & BodyPartID.bodyIdMax) + (iArr2[i2 + 4] & BodyPartID.bodyIdMax) + (iArr3[r7] & BodyPartID.bodyIdMax);
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[i + 5] & BodyPartID.bodyIdMax) + (iArr2[i2 + 5] & BodyPartID.bodyIdMax) + (iArr3[r7] & BodyPartID.bodyIdMax);
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[i + 6] & BodyPartID.bodyIdMax) + (iArr2[i2 + 6] & BodyPartID.bodyIdMax) + (iArr3[r15] & BodyPartID.bodyIdMax);
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j6 = (j5 >>> 32) + (iArr[5] & BodyPartID.bodyIdMax) + (iArr2[5] & BodyPartID.bodyIdMax) + (iArr3[5] & BodyPartID.bodyIdMax);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[6] & BodyPartID.bodyIdMax) + (iArr2[6] & BodyPartID.bodyIdMax) + (iArr3[6] & BodyPartID.bodyIdMax);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j5 = (j4 >>> 32) + (iArr[i + 4] & BodyPartID.bodyIdMax) + (iArr2[r6] & BodyPartID.bodyIdMax);
        iArr2[i2 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[i + 5] & BodyPartID.bodyIdMax) + (iArr2[r6] & BodyPartID.bodyIdMax);
        iArr2[i2 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[i + 6] & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & iArr2[r12]);
        iArr2[i2 + 6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j5 = (j4 >>> 32) + (iArr[4] & BodyPartID.bodyIdMax) + (iArr2[4] & BodyPartID.bodyIdMax);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[5] & BodyPartID.bodyIdMax) + (iArr2[5] & BodyPartID.bodyIdMax);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[6] & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & iArr2[6]);
        iArr2[6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j5 = (j4 >>> 32) + (iArr[r5] & BodyPartID.bodyIdMax) + (iArr2[r8] & BodyPartID.bodyIdMax);
        int i7 = (int) j5;
        iArr[i + 4] = i7;
        iArr2[i2 + 4] = i7;
        long j6 = (j5 >>> 32) + (iArr[r5] & BodyPartID.bodyIdMax) + (iArr2[r8] & BodyPartID.bodyIdMax);
        int i8 = (int) j6;
        iArr[i + 5] = i8;
        iArr2[i2 + 5] = i8;
        long j7 = (j6 >>> 32) + (iArr[r12] & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & iArr2[r14]);
        int i9 = (int) j7;
        iArr[i + 6] = i9;
        iArr2[i2 + 6] = i9;
        return (int) (j7 >>> 32);
    }

    public static void copy(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2] = iArr[i];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
        iArr2[i2 + 5] = iArr[i + 5];
        iArr2[i2 + 6] = iArr[i + 6];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] create() {
        return new int[7];
    }

    public static int[] createExt() {
        return new int[14];
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
        for (int i = 6; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] iArrCreate = create();
        for (int i = 0; i < 7; i++) {
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
            if (i3 < 0 || i3 >= 7) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 6; i3 >= 0; i3--) {
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
        for (int i = 6; i >= 0; i--) {
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
        for (int i = 1; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 7; i++) {
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
        long j6 = iArr2[i2 + 5] & BodyPartID.bodyIdMax;
        long j7 = iArr2[i2 + 6] & BodyPartID.bodyIdMax;
        long j8 = iArr[i] & BodyPartID.bodyIdMax;
        long j9 = j8 * j;
        iArr3[i3] = (int) j9;
        long j10 = (j9 >>> 32) + (j8 * j2);
        iArr3[i3 + 1] = (int) j10;
        long j11 = (j10 >>> 32) + (j8 * j3);
        iArr3[i3 + 2] = (int) j11;
        long j12 = (j11 >>> 32) + (j8 * j4);
        iArr3[i3 + 3] = (int) j12;
        long j13 = (j12 >>> 32) + (j8 * j5);
        iArr3[i3 + 4] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j6);
        iArr3[i3 + 5] = (int) j14;
        long j15 = j7;
        long j16 = (j14 >>> 32) + (j8 * j15);
        iArr3[i3 + 6] = (int) j16;
        iArr3[i3 + 7] = (int) (j16 >>> 32);
        int i4 = 1;
        int i5 = i3;
        while (i4 < 7) {
            int i6 = i5 + 1;
            long j17 = iArr[i + i4] & BodyPartID.bodyIdMax;
            long j18 = j15;
            int i7 = i4;
            long j19 = (j17 * j) + (iArr3[i6] & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j19;
            long j20 = (j19 >>> 32) + (j17 * j2) + (iArr3[r26] & BodyPartID.bodyIdMax);
            iArr3[i5 + 2] = (int) j20;
            long j21 = j3;
            long j22 = (j20 >>> 32) + (j17 * j3) + (iArr3[r22] & BodyPartID.bodyIdMax);
            iArr3[i5 + 3] = (int) j22;
            int i8 = i5;
            long j23 = (j22 >>> 32) + (j17 * j4) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i5 + 4] = (int) j23;
            long j24 = (j23 >>> 32) + (j17 * j5) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i8 + 5] = (int) j24;
            long j25 = (j24 >>> 32) + (j17 * j6) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i8 + 6] = (int) j25;
            long j26 = (j25 >>> 32) + (j17 * j18) + (iArr3[r3] & BodyPartID.bodyIdMax);
            iArr3[i8 + 7] = (int) j26;
            iArr3[i8 + 8] = (int) (j26 >>> 32);
            i4 = i7 + 1;
            i5 = i6;
            j15 = j18;
            j3 = j21;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = iArr2[0] & BodyPartID.bodyIdMax;
        long j2 = iArr2[1] & BodyPartID.bodyIdMax;
        long j3 = iArr2[2] & BodyPartID.bodyIdMax;
        long j4 = iArr2[3] & BodyPartID.bodyIdMax;
        long j5 = iArr2[4] & BodyPartID.bodyIdMax;
        long j6 = iArr2[5] & BodyPartID.bodyIdMax;
        long j7 = iArr2[6] & BodyPartID.bodyIdMax;
        long j8 = iArr[0] & BodyPartID.bodyIdMax;
        long j9 = j8 * j;
        iArr3[0] = (int) j9;
        long j10 = (j9 >>> 32) + (j8 * j2);
        iArr3[1] = (int) j10;
        long j11 = (j10 >>> 32) + (j8 * j3);
        iArr3[2] = (int) j11;
        long j12 = (j11 >>> 32) + (j8 * j4);
        iArr3[3] = (int) j12;
        long j13 = (j12 >>> 32) + (j8 * j5);
        iArr3[4] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j6);
        iArr3[5] = (int) j14;
        long j15 = (j14 >>> 32) + (j8 * j7);
        iArr3[6] = (int) j15;
        iArr3[7] = (int) (j15 >>> 32);
        int i = 1;
        for (int i2 = 7; i < i2; i2 = 7) {
            long j16 = iArr[i] & BodyPartID.bodyIdMax;
            long j17 = (j16 * j) + (iArr3[i] & BodyPartID.bodyIdMax);
            iArr3[i] = (int) j17;
            int i3 = i + 1;
            long j18 = (j17 >>> 32) + (j16 * j2) + (iArr3[i3] & BodyPartID.bodyIdMax);
            iArr3[i3] = (int) j18;
            long j19 = j2;
            long j20 = (j18 >>> 32) + (j16 * j3) + (iArr3[r18] & BodyPartID.bodyIdMax);
            iArr3[i + 2] = (int) j20;
            long j21 = (j20 >>> 32) + (j16 * j4) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 3] = (int) j21;
            long j22 = (j21 >>> 32) + (j16 * j5) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 4] = (int) j22;
            long j23 = (j22 >>> 32) + (j16 * j6) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 5] = (int) j23;
            long j24 = (j23 >>> 32) + (j16 * j7) + (iArr3[r3] & BodyPartID.bodyIdMax);
            iArr3[i + 6] = (int) j24;
            iArr3[i + 7] = (int) (j24 >>> 32);
            j4 = j4;
            j = j;
            i = i3;
            j2 = j19;
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
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (iArr2[i3 + 4] & BodyPartID.bodyIdMax);
        iArr3[i4 + 4] = (int) j12;
        long j13 = iArr[i2 + 5] & BodyPartID.bodyIdMax;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (iArr2[i3 + 5] & BodyPartID.bodyIdMax);
        iArr3[i4 + 5] = (int) j14;
        long j15 = iArr[i2 + 6] & BodyPartID.bodyIdMax;
        long j16 = (j14 >>> 32) + (j * j15) + j13 + (BodyPartID.bodyIdMax & iArr2[i3 + 6]);
        iArr3[i4 + 6] = (int) j16;
        return (j16 >>> 32) + j15;
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
        return Nat.incAt(7, iArr, i2, 4);
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
        return Nat.incAt(7, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = iArr2[i2] & BodyPartID.bodyIdMax;
        long j2 = iArr2[i2 + 1] & BodyPartID.bodyIdMax;
        long j3 = iArr2[i2 + 2] & BodyPartID.bodyIdMax;
        long j4 = iArr2[i2 + 3] & BodyPartID.bodyIdMax;
        long j5 = iArr2[i2 + 4] & BodyPartID.bodyIdMax;
        long j6 = iArr2[i2 + 5] & BodyPartID.bodyIdMax;
        long j7 = iArr2[i2 + 6] & BodyPartID.bodyIdMax;
        long j8 = 0;
        int i4 = 0;
        int i5 = i3;
        while (i4 < 7) {
            int i6 = i4;
            long j9 = iArr[i + i4] & BodyPartID.bodyIdMax;
            long j10 = j;
            long j11 = (j9 * j) + (iArr3[i5] & BodyPartID.bodyIdMax);
            long j12 = j7;
            iArr3[i5] = (int) j11;
            int i7 = i5 + 1;
            long j13 = (j11 >>> 32) + (j9 * j2) + (iArr3[i7] & BodyPartID.bodyIdMax);
            iArr3[i7] = (int) j13;
            long j14 = (j13 >>> 32) + (j9 * j3) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 2] = (int) j14;
            long j15 = (j14 >>> 32) + (j9 * j4) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 3] = (int) j15;
            long j16 = (j15 >>> 32) + (j9 * j5) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 4] = (int) j16;
            long j17 = (j16 >>> 32) + (j9 * j6) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 5] = (int) j17;
            long j18 = (j17 >>> 32) + (j9 * j12) + (iArr3[r5] & BodyPartID.bodyIdMax);
            iArr3[i5 + 6] = (int) j18;
            long j19 = (j18 >>> 32) + (iArr3[r16] & BodyPartID.bodyIdMax) + j8;
            iArr3[i5 + 7] = (int) j19;
            j8 = j19 >>> 32;
            i4 = i6 + 1;
            i5 = i7;
            j7 = j12;
            j = j10;
            j2 = j2;
        }
        return (int) j8;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = iArr2[0] & BodyPartID.bodyIdMax;
        long j2 = iArr2[1] & BodyPartID.bodyIdMax;
        long j3 = iArr2[2] & BodyPartID.bodyIdMax;
        long j4 = iArr2[3] & BodyPartID.bodyIdMax;
        long j5 = iArr2[4] & BodyPartID.bodyIdMax;
        long j6 = iArr2[5] & BodyPartID.bodyIdMax;
        long j7 = iArr2[6] & BodyPartID.bodyIdMax;
        long j8 = 0;
        int i = 0;
        while (i < 7) {
            long j9 = j7;
            long j10 = iArr[i] & BodyPartID.bodyIdMax;
            long j11 = j6;
            long j12 = (iArr3[i] & BodyPartID.bodyIdMax) + (j10 * j);
            iArr3[i] = (int) j12;
            int i2 = i + 1;
            long j13 = j2;
            long j14 = (j12 >>> 32) + (j10 * j2) + (iArr3[i2] & BodyPartID.bodyIdMax);
            iArr3[i2] = (int) j14;
            long j15 = (j14 >>> 32) + (j10 * j3) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 2] = (int) j15;
            long j16 = (j15 >>> 32) + (j10 * j4) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 3] = (int) j16;
            long j17 = (j16 >>> 32) + (j10 * j5) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 4] = (int) j17;
            long j18 = (j17 >>> 32) + (j10 * j11) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 5] = (int) j18;
            long j19 = (j18 >>> 32) + (j10 * j9) + (iArr3[r6] & BodyPartID.bodyIdMax);
            iArr3[i + 6] = (int) j19;
            long j20 = (j19 >>> 32) + (iArr3[r2] & BodyPartID.bodyIdMax) + j8;
            iArr3[i + 7] = (int) j20;
            j8 = j20 >>> 32;
            i = i2;
            j7 = j9;
            j6 = j11;
            j2 = j13;
        }
        return (int) j8;
    }

    public static int mulByWord(int i, int[] iArr) {
        long j = i & BodyPartID.bodyIdMax;
        long j2 = (iArr[0] & BodyPartID.bodyIdMax) * j;
        iArr[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((iArr[1] & BodyPartID.bodyIdMax) * j);
        iArr[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((iArr[2] & BodyPartID.bodyIdMax) * j);
        iArr[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((iArr[3] & BodyPartID.bodyIdMax) * j);
        iArr[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((iArr[4] & BodyPartID.bodyIdMax) * j);
        iArr[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((iArr[5] & BodyPartID.bodyIdMax) * j);
        iArr[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (BodyPartID.bodyIdMax & iArr[6]));
        iArr[6] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulByWordAddTo(int i, int[] iArr, int[] iArr2) {
        long j = i & BodyPartID.bodyIdMax;
        long j2 = ((iArr2[0] & BodyPartID.bodyIdMax) * j) + (iArr[0] & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((iArr2[1] & BodyPartID.bodyIdMax) * j) + (iArr[1] & BodyPartID.bodyIdMax);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((iArr2[2] & BodyPartID.bodyIdMax) * j) + (iArr[2] & BodyPartID.bodyIdMax);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((iArr2[3] & BodyPartID.bodyIdMax) * j) + (iArr[3] & BodyPartID.bodyIdMax);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((iArr2[4] & BodyPartID.bodyIdMax) * j) + (iArr[4] & BodyPartID.bodyIdMax);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((iArr2[5] & BodyPartID.bodyIdMax) * j) + (iArr[5] & BodyPartID.bodyIdMax);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (iArr2[6] & BodyPartID.bodyIdMax)) + (BodyPartID.bodyIdMax & iArr[6]);
        iArr2[6] = (int) j8;
        return (int) (j8 >>> 32);
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
        } while (i3 < 7);
        return (int) j2;
    }

    public static int mulWordAddTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = i & BodyPartID.bodyIdMax;
        long j2 = ((iArr[i2] & BodyPartID.bodyIdMax) * j) + (iArr2[i3] & BodyPartID.bodyIdMax);
        iArr2[i3] = (int) j2;
        long j3 = (j2 >>> 32) + ((iArr[i2 + 1] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 1] = (int) j3;
        long j4 = (j3 >>> 32) + ((iArr[i2 + 2] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 2] = (int) j4;
        long j5 = (j4 >>> 32) + ((iArr[i2 + 3] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 3] = (int) j5;
        long j6 = (j5 >>> 32) + ((iArr[i2 + 4] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 4] = (int) j6;
        long j7 = (j6 >>> 32) + ((iArr[i2 + 5] & BodyPartID.bodyIdMax) * j) + (iArr2[r8] & BodyPartID.bodyIdMax);
        iArr2[i3 + 5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (iArr[i2 + 6] & BodyPartID.bodyIdMax)) + (iArr2[r15] & BodyPartID.bodyIdMax);
        iArr2[i3 + 6] = (int) j8;
        return (int) (j8 >>> 32);
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
        return Nat.incAt(7, iArr, i2, 3);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = iArr[i] & BodyPartID.bodyIdMax;
        int i3 = 0;
        int i4 = 14;
        int i5 = 6;
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
                long j33 = j25 + (j28 * j);
                int i12 = (int) j33;
                iArr2[i2 + 4] = (i12 << 1) | (i11 >>> 31);
                int i13 = i12 >>> 31;
                long j34 = j27 + (j33 >>> 32) + (j28 * j6);
                long j35 = j30 + (j34 >>> 32) + (j28 * j10);
                long j36 = j34 & BodyPartID.bodyIdMax;
                long j37 = j32 + (j35 >>> 32) + (j28 * j17);
                long j38 = j35 & BodyPartID.bodyIdMax;
                long j39 = j31 + (j37 >>> 32);
                long j40 = j37 & BodyPartID.bodyIdMax;
                long j41 = iArr[i + 5] & BodyPartID.bodyIdMax;
                long j42 = (iArr2[r7] & BodyPartID.bodyIdMax) + (j39 >>> 32);
                long j43 = j39 & BodyPartID.bodyIdMax;
                long j44 = (iArr2[r21] & BodyPartID.bodyIdMax) + (j42 >>> 32);
                long j45 = j42 & BodyPartID.bodyIdMax;
                long j46 = j36 + (j41 * j);
                int i14 = (int) j46;
                iArr2[i2 + 5] = (i14 << 1) | i13;
                int i15 = i14 >>> 31;
                long j47 = j38 + (j46 >>> 32) + (j41 * j6);
                long j48 = j40 + (j47 >>> 32) + (j41 * j10);
                long j49 = j47 & BodyPartID.bodyIdMax;
                long j50 = j43 + (j48 >>> 32) + (j41 * j17);
                long j51 = j48 & BodyPartID.bodyIdMax;
                long j52 = j45 + (j50 >>> 32) + (j41 * j28);
                long j53 = j50 & BodyPartID.bodyIdMax;
                long j54 = j44 + (j52 >>> 32);
                long j55 = j52 & BodyPartID.bodyIdMax;
                long j56 = iArr[i + 6] & BodyPartID.bodyIdMax;
                long j57 = (iArr2[r7] & BodyPartID.bodyIdMax) + (j54 >>> 32);
                long j58 = j54 & BodyPartID.bodyIdMax;
                long j59 = (iArr2[r20] & BodyPartID.bodyIdMax) + (j57 >>> 32);
                long j60 = j57 & BodyPartID.bodyIdMax;
                long j61 = j49 + (j * j56);
                int i16 = (int) j61;
                iArr2[i2 + 6] = (i16 << 1) | i15;
                long j62 = j51 + (j61 >>> 32) + (j6 * j56);
                long j63 = j53 + (j62 >>> 32) + (j56 * j10);
                long j64 = j55 + (j63 >>> 32) + (j56 * j17);
                long j65 = j58 + (j64 >>> 32) + (j56 * j28);
                long j66 = j60 + (j65 >>> 32) + (j56 * j41);
                long j67 = j59 + (j66 >>> 32);
                int i17 = (int) j62;
                iArr2[i2 + 7] = (i16 >>> 31) | (i17 << 1);
                int i18 = (int) j63;
                iArr2[i2 + 8] = (i17 >>> 31) | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) j64;
                iArr2[i2 + 9] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j65;
                iArr2[i2 + 10] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j66;
                iArr2[i2 + 11] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j67;
                iArr2[i2 + 12] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = i2 + 13;
                iArr2[i28] = i27 | ((iArr2[i28] + ((int) (j67 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = iArr[0] & BodyPartID.bodyIdMax;
        int i = 14;
        int i2 = 0;
        int i3 = 6;
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
                int i6 = i5 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = iArr[2] & BodyPartID.bodyIdMax;
                long j11 = iArr2[3] & BodyPartID.bodyIdMax;
                long j12 = iArr2[4] & BodyPartID.bodyIdMax;
                long j13 = j9 + (j10 * j);
                int i7 = (int) j13;
                iArr2[2] = (i7 << 1) | i6;
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & BodyPartID.bodyIdMax;
                long j17 = iArr[3] & BodyPartID.bodyIdMax;
                long j18 = (iArr2[5] & BodyPartID.bodyIdMax) + (j15 >>> 32);
                long j19 = j15 & BodyPartID.bodyIdMax;
                long j20 = (iArr2[6] & BodyPartID.bodyIdMax) + (j18 >>> 32);
                long j21 = j18 & BodyPartID.bodyIdMax;
                long j22 = j16 + (j17 * j);
                int i8 = (int) j22;
                iArr2[3] = (i7 >>> 31) | (i8 << 1);
                int i9 = i8 >>> 31;
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j23 & BodyPartID.bodyIdMax;
                long j26 = j20 + (j24 >>> 32);
                long j27 = j24 & BodyPartID.bodyIdMax;
                long j28 = iArr[4] & BodyPartID.bodyIdMax;
                long j29 = (iArr2[7] & BodyPartID.bodyIdMax) + (j26 >>> 32);
                long j30 = j26 & BodyPartID.bodyIdMax;
                long j31 = (iArr2[8] & BodyPartID.bodyIdMax) + (j29 >>> 32);
                long j32 = j29 & BodyPartID.bodyIdMax;
                long j33 = j25 + (j28 * j);
                int i10 = (int) j33;
                iArr2[4] = (i10 << 1) | i9;
                long j34 = j27 + (j33 >>> 32) + (j28 * j6);
                long j35 = j30 + (j34 >>> 32) + (j28 * j10);
                long j36 = j34 & BodyPartID.bodyIdMax;
                long j37 = j32 + (j35 >>> 32) + (j28 * j17);
                long j38 = j35 & BodyPartID.bodyIdMax;
                long j39 = j31 + (j37 >>> 32);
                long j40 = j37 & BodyPartID.bodyIdMax;
                long j41 = iArr[5] & BodyPartID.bodyIdMax;
                long j42 = (iArr2[9] & BodyPartID.bodyIdMax) + (j39 >>> 32);
                long j43 = j39 & BodyPartID.bodyIdMax;
                long j44 = (iArr2[10] & BodyPartID.bodyIdMax) + (j42 >>> 32);
                long j45 = j42 & BodyPartID.bodyIdMax;
                long j46 = j36 + (j41 * j);
                int i11 = (int) j46;
                iArr2[5] = (i11 << 1) | (i10 >>> 31);
                long j47 = j38 + (j46 >>> 32) + (j41 * j6);
                long j48 = j40 + (j47 >>> 32) + (j41 * j10);
                long j49 = j47 & BodyPartID.bodyIdMax;
                long j50 = j43 + (j48 >>> 32) + (j41 * j17);
                long j51 = j48 & BodyPartID.bodyIdMax;
                long j52 = j45 + (j50 >>> 32) + (j41 * j28);
                long j53 = j50 & BodyPartID.bodyIdMax;
                long j54 = j44 + (j52 >>> 32);
                long j55 = j52 & BodyPartID.bodyIdMax;
                long j56 = iArr[6] & BodyPartID.bodyIdMax;
                long j57 = (iArr2[11] & BodyPartID.bodyIdMax) + (j54 >>> 32);
                long j58 = j54 & BodyPartID.bodyIdMax;
                long j59 = (iArr2[12] & BodyPartID.bodyIdMax) + (j57 >>> 32);
                long j60 = BodyPartID.bodyIdMax & j57;
                long j61 = j49 + (j * j56);
                int i12 = (int) j61;
                iArr2[6] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                long j62 = j51 + (j61 >>> 32) + (j56 * j6);
                long j63 = j53 + (j62 >>> 32) + (j56 * j10);
                long j64 = j55 + (j63 >>> 32) + (j56 * j17);
                long j65 = j58 + (j64 >>> 32) + (j56 * j28);
                long j66 = j60 + (j65 >>> 32) + (j56 * j41);
                long j67 = j59 + (j66 >>> 32);
                int i14 = (int) j62;
                iArr2[7] = i13 | (i14 << 1);
                int i15 = (int) j63;
                iArr2[8] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) j64;
                iArr2[9] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) j65;
                iArr2[10] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j66;
                iArr2[11] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j67;
                iArr2[12] = i22 | (i23 << 1);
                iArr2[13] = (i23 >>> 31) | ((iArr2[13] + ((int) (j67 >>> 32))) << 1);
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
        long j6 = (j5 >> 32) + ((iArr[i + 5] & BodyPartID.bodyIdMax) - (iArr2[i2 + 5] & BodyPartID.bodyIdMax));
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr[i + 6] & BodyPartID.bodyIdMax) - (iArr2[i2 + 6] & BodyPartID.bodyIdMax));
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j6 = (j5 >> 32) + ((iArr[5] & BodyPartID.bodyIdMax) - (iArr2[5] & BodyPartID.bodyIdMax));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr[6] & BodyPartID.bodyIdMax) - (iArr2[6] & BodyPartID.bodyIdMax));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j6 = (j5 >> 32) + (((iArr3[5] & BodyPartID.bodyIdMax) - (iArr[5] & BodyPartID.bodyIdMax)) - (iArr2[5] & BodyPartID.bodyIdMax));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + (((iArr3[6] & BodyPartID.bodyIdMax) - (iArr[6] & BodyPartID.bodyIdMax)) - (iArr2[6] & BodyPartID.bodyIdMax));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j5 = (j4 >> 32) + ((iArr2[r5] & BodyPartID.bodyIdMax) - (iArr[i + 4] & BodyPartID.bodyIdMax));
        iArr2[i2 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr2[r5] & BodyPartID.bodyIdMax) - (iArr[i + 5] & BodyPartID.bodyIdMax));
        iArr2[i2 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr2[r13] & BodyPartID.bodyIdMax) - (iArr[i + 6] & BodyPartID.bodyIdMax));
        iArr2[i2 + 6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j5 = (j4 >> 32) + ((iArr2[4] & BodyPartID.bodyIdMax) - (iArr[4] & BodyPartID.bodyIdMax));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr2[5] & BodyPartID.bodyIdMax) - (iArr[5] & BodyPartID.bodyIdMax));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr2[6] & BodyPartID.bodyIdMax) - (BodyPartID.bodyIdMax & iArr[6]));
        iArr2[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i = 0; i < 7; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (6 - i) << 2);
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
        iArr[5] = 0;
        iArr[6] = 0;
    }
}
