package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Nat224 {
    public static int add(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2]) & BodyPartID.bodyIdMax);
        iArr3[i3] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax);
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax);
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax);
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax);
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 5]) & BodyPartID.bodyIdMax);
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 6]) & BodyPartID.bodyIdMax);
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax);
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & BodyPartID.bodyIdMax) + (((long) iArr2[3]) & BodyPartID.bodyIdMax);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & BodyPartID.bodyIdMax) + (((long) iArr2[4]) & BodyPartID.bodyIdMax);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & BodyPartID.bodyIdMax) + (((long) iArr2[5]) & BodyPartID.bodyIdMax);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & BodyPartID.bodyIdMax) + (((long) iArr2[6]) & BodyPartID.bodyIdMax);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2]) & BodyPartID.bodyIdMax) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax);
        iArr3[i3] = (int) j;
        int i4 = i3 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax) + (((long) iArr3[i4]) & BodyPartID.bodyIdMax);
        iArr3[i4] = (int) j2;
        int i5 = i3 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax);
        iArr3[i5] = (int) j3;
        int i6 = i3 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax);
        iArr3[i6] = (int) j4;
        int i7 = i3 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax);
        iArr3[i7] = (int) j5;
        int i8 = i3 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 5]) & BodyPartID.bodyIdMax) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax);
        iArr3[i8] = (int) j6;
        int i9 = i3 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & BodyPartID.bodyIdMax) + (((long) iArr2[i2 + 6]) & BodyPartID.bodyIdMax) + (((long) iArr3[i9]) & BodyPartID.bodyIdMax);
        iArr3[i9] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & BodyPartID.bodyIdMax) + (((long) iArr2[4]) & BodyPartID.bodyIdMax) + (((long) iArr3[4]) & BodyPartID.bodyIdMax);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & BodyPartID.bodyIdMax) + (((long) iArr2[5]) & BodyPartID.bodyIdMax) + (((long) iArr3[5]) & BodyPartID.bodyIdMax);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & BodyPartID.bodyIdMax) + (((long) iArr2[6]) & BodyPartID.bodyIdMax) + (((long) iArr3[6]) & BodyPartID.bodyIdMax);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & BodyPartID.bodyIdMax) + (((long) iArr2[i6]) & BodyPartID.bodyIdMax);
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & BodyPartID.bodyIdMax) + (((long) iArr2[i7]) & BodyPartID.bodyIdMax);
        iArr2[i7] = (int) j5;
        int i8 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & BodyPartID.bodyIdMax) + (((long) iArr2[i8]) & BodyPartID.bodyIdMax);
        iArr2[i8] = (int) j6;
        int i9 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[i9]));
        iArr2[i9] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & BodyPartID.bodyIdMax) + (((long) iArr2[3]) & BodyPartID.bodyIdMax);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & BodyPartID.bodyIdMax) + (((long) iArr2[4]) & BodyPartID.bodyIdMax);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & BodyPartID.bodyIdMax) + (((long) iArr2[5]) & BodyPartID.bodyIdMax);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[6]));
        iArr2[6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j4 = (j3 >>> 32) + (((long) iArr[i10]) & BodyPartID.bodyIdMax) + (((long) iArr2[i11]) & BodyPartID.bodyIdMax);
        int i12 = (int) j4;
        iArr[i10] = i12;
        iArr2[i11] = i12;
        int i13 = i + 4;
        int i14 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i13]) & BodyPartID.bodyIdMax) + (((long) iArr2[i14]) & BodyPartID.bodyIdMax);
        int i15 = (int) j5;
        iArr[i13] = i15;
        iArr2[i14] = i15;
        int i16 = i + 5;
        int i17 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i16]) & BodyPartID.bodyIdMax) + (((long) iArr2[i17]) & BodyPartID.bodyIdMax);
        int i18 = (int) j6;
        iArr[i16] = i18;
        iArr2[i17] = i18;
        int i19 = i + 6;
        int i20 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i19]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[i20]));
        int i21 = (int) j7;
        iArr[i19] = i21;
        iArr2[i20] = i21;
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

    /* JADX INFO: renamed from: eq */
    public static boolean m2103eq(int[] iArr, int[] iArr2) {
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
        long j = ((long) iArr2[i2]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr2[i2 + 5]) & BodyPartID.bodyIdMax;
        long j7 = ((long) iArr2[i2 + 6]) & BodyPartID.bodyIdMax;
        long j8 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
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
            long j17 = ((long) iArr[i + i4]) & BodyPartID.bodyIdMax;
            long j18 = j15;
            int i7 = i4;
            long j19 = (j17 * j) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j19;
            int i8 = i5 + 2;
            long j20 = (j19 >>> 32) + (j17 * j2) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax);
            iArr3[i8] = (int) j20;
            int i9 = i5 + 3;
            long j21 = j3;
            long j22 = (j20 >>> 32) + (j17 * j3) + (((long) iArr3[i9]) & BodyPartID.bodyIdMax);
            iArr3[i9] = (int) j22;
            int i10 = i5 + 4;
            int i11 = i5;
            long j23 = (j22 >>> 32) + (j17 * j4) + (((long) iArr3[i10]) & BodyPartID.bodyIdMax);
            iArr3[i10] = (int) j23;
            int i12 = i11 + 5;
            long j24 = (j23 >>> 32) + (j17 * j5) + (((long) iArr3[i12]) & BodyPartID.bodyIdMax);
            iArr3[i12] = (int) j24;
            int i13 = i11 + 6;
            long j25 = (j24 >>> 32) + (j17 * j6) + (((long) iArr3[i13]) & BodyPartID.bodyIdMax);
            iArr3[i13] = (int) j25;
            int i14 = i11 + 7;
            long j26 = (j25 >>> 32) + (j17 * j18) + (((long) iArr3[i14]) & BodyPartID.bodyIdMax);
            iArr3[i14] = (int) j26;
            iArr3[i11 + 8] = (int) (j26 >>> 32);
            i4 = i7 + 1;
            i5 = i6;
            j15 = j18;
            j3 = j21;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[4]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr2[5]) & BodyPartID.bodyIdMax;
        long j7 = ((long) iArr2[6]) & BodyPartID.bodyIdMax;
        long j8 = ((long) iArr[0]) & BodyPartID.bodyIdMax;
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
            long j16 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
            long j17 = (j16 * j) + (((long) iArr3[i]) & BodyPartID.bodyIdMax);
            iArr3[i] = (int) j17;
            int i3 = i + 1;
            long j18 = (j17 >>> 32) + (j16 * j2) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax);
            iArr3[i3] = (int) j18;
            int i4 = i + 2;
            long j19 = j2;
            long j20 = (j18 >>> 32) + (j16 * j3) + (((long) iArr3[i4]) & BodyPartID.bodyIdMax);
            iArr3[i4] = (int) j20;
            int i5 = i + 3;
            long j21 = (j20 >>> 32) + (j16 * j4) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax);
            iArr3[i5] = (int) j21;
            int i6 = i + 4;
            long j22 = (j21 >>> 32) + (j16 * j5) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j22;
            int i7 = i + 5;
            long j23 = (j22 >>> 32) + (j16 * j6) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax);
            iArr3[i7] = (int) j23;
            int i8 = i + 6;
            long j24 = (j23 >>> 32) + (j16 * j7) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax);
            iArr3[i8] = (int) j24;
            iArr3[i + 7] = (int) (j24 >>> 32);
            j4 = j4;
            j = j;
            i = i3;
            j2 = j19;
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
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (((long) iArr2[i3 + 3]) & BodyPartID.bodyIdMax);
        iArr3[i4 + 3] = (int) j10;
        long j11 = ((long) iArr[i2 + 4]) & BodyPartID.bodyIdMax;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (((long) iArr2[i3 + 4]) & BodyPartID.bodyIdMax);
        iArr3[i4 + 4] = (int) j12;
        long j13 = ((long) iArr[i2 + 5]) & BodyPartID.bodyIdMax;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (((long) iArr2[i3 + 5]) & BodyPartID.bodyIdMax);
        iArr3[i4 + 5] = (int) j14;
        long j15 = ((long) iArr[i2 + 6]) & BodyPartID.bodyIdMax;
        long j16 = (j14 >>> 32) + (j * j15) + j13 + (BodyPartID.bodyIdMax & ((long) iArr2[i3 + 6]));
        iArr3[i4 + 6] = (int) j16;
        return (j16 >>> 32) + j15;
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
        long j9 = j8 >>> 32;
        int i5 = i2 + 3;
        long j10 = j9 + (((long) iArr[i5]) & BodyPartID.bodyIdMax);
        iArr[i5] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr, i2, 4);
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
        return Nat.incAt(7, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr2[i2 + 5]) & BodyPartID.bodyIdMax;
        long j7 = ((long) iArr2[i2 + 6]) & BodyPartID.bodyIdMax;
        long j8 = 0;
        int i4 = 0;
        int i5 = i3;
        while (i4 < 7) {
            int i6 = i4;
            long j9 = ((long) iArr[i + i4]) & BodyPartID.bodyIdMax;
            long j10 = j;
            long j11 = (j9 * j) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax);
            long j12 = j7;
            iArr3[i5] = (int) j11;
            int i7 = i5 + 1;
            long j13 = (j11 >>> 32) + (j9 * j2) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax);
            iArr3[i7] = (int) j13;
            int i8 = i5 + 2;
            long j14 = (j13 >>> 32) + (j9 * j3) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax);
            iArr3[i8] = (int) j14;
            int i9 = i5 + 3;
            long j15 = (j14 >>> 32) + (j9 * j4) + (((long) iArr3[i9]) & BodyPartID.bodyIdMax);
            iArr3[i9] = (int) j15;
            int i10 = i5 + 4;
            long j16 = (j15 >>> 32) + (j9 * j5) + (((long) iArr3[i10]) & BodyPartID.bodyIdMax);
            iArr3[i10] = (int) j16;
            int i11 = i5 + 5;
            long j17 = (j16 >>> 32) + (j9 * j6) + (((long) iArr3[i11]) & BodyPartID.bodyIdMax);
            iArr3[i11] = (int) j17;
            int i12 = i5 + 6;
            long j18 = (j17 >>> 32) + (j9 * j12) + (((long) iArr3[i12]) & BodyPartID.bodyIdMax);
            iArr3[i12] = (int) j18;
            int i13 = i5 + 7;
            long j19 = (j18 >>> 32) + (((long) iArr3[i13]) & BodyPartID.bodyIdMax) + j8;
            iArr3[i13] = (int) j19;
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
        long j = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[4]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr2[5]) & BodyPartID.bodyIdMax;
        long j7 = ((long) iArr2[6]) & BodyPartID.bodyIdMax;
        long j8 = 0;
        int i = 0;
        while (i < 7) {
            long j9 = j7;
            long j10 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
            long j11 = j6;
            long j12 = (((long) iArr3[i]) & BodyPartID.bodyIdMax) + (j10 * j);
            iArr3[i] = (int) j12;
            int i2 = i + 1;
            long j13 = j2;
            long j14 = (j12 >>> 32) + (j10 * j2) + (((long) iArr3[i2]) & BodyPartID.bodyIdMax);
            iArr3[i2] = (int) j14;
            int i3 = i + 2;
            long j15 = (j14 >>> 32) + (j10 * j3) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax);
            iArr3[i3] = (int) j15;
            int i4 = i + 3;
            long j16 = (j15 >>> 32) + (j10 * j4) + (((long) iArr3[i4]) & BodyPartID.bodyIdMax);
            iArr3[i4] = (int) j16;
            int i5 = i + 4;
            long j17 = (j16 >>> 32) + (j10 * j5) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax);
            iArr3[i5] = (int) j17;
            int i6 = i + 5;
            long j18 = (j17 >>> 32) + (j10 * j11) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax);
            iArr3[i6] = (int) j18;
            int i7 = i + 6;
            long j19 = (j18 >>> 32) + (j10 * j9) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax);
            iArr3[i7] = (int) j19;
            int i8 = i + 7;
            long j20 = (j19 >>> 32) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax) + j8;
            iArr3[i8] = (int) j20;
            j8 = j20 >>> 32;
            i = i2;
            j7 = j9;
            j6 = j11;
            j2 = j13;
        }
        return (int) j8;
    }

    public static int mulByWord(int i, int[] iArr) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = (((long) iArr[0]) & BodyPartID.bodyIdMax) * j;
        iArr[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr[1]) & BodyPartID.bodyIdMax) * j);
        iArr[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr[2]) & BodyPartID.bodyIdMax) * j);
        iArr[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr[3]) & BodyPartID.bodyIdMax) * j);
        iArr[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr[4]) & BodyPartID.bodyIdMax) * j);
        iArr[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr[5]) & BodyPartID.bodyIdMax) * j);
        iArr[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (BodyPartID.bodyIdMax & ((long) iArr[6])));
        iArr[6] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulByWordAddTo(int i, int[] iArr, int[] iArr2) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = ((((long) iArr2[0]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[0]) & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr2[1]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[1]) & BodyPartID.bodyIdMax);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr2[2]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[2]) & BodyPartID.bodyIdMax);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr2[3]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[3]) & BodyPartID.bodyIdMax);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr2[4]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[4]) & BodyPartID.bodyIdMax);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr2[5]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[5]) & BodyPartID.bodyIdMax);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (((long) iArr2[6]) & BodyPartID.bodyIdMax)) + (BodyPartID.bodyIdMax & ((long) iArr[6]));
        iArr2[6] = (int) j8;
        return (int) (j8 >>> 32);
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
        } while (i3 < 7);
        return (int) j2;
    }

    public static int mulWordAddTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
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
        long j5 = (j4 >>> 32) + ((((long) iArr[i2 + 3]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i6]) & BodyPartID.bodyIdMax);
        iArr2[i6] = (int) j5;
        int i7 = i3 + 4;
        long j6 = (j5 >>> 32) + ((((long) iArr[i2 + 4]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i7]) & BodyPartID.bodyIdMax);
        iArr2[i7] = (int) j6;
        int i8 = i3 + 5;
        long j7 = (j6 >>> 32) + ((((long) iArr[i2 + 5]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i8]) & BodyPartID.bodyIdMax);
        iArr2[i8] = (int) j7;
        int i9 = i3 + 6;
        long j8 = (j7 >>> 32) + (j * (((long) iArr[i2 + 6]) & BodyPartID.bodyIdMax)) + (((long) iArr2[i9]) & BodyPartID.bodyIdMax);
        iArr2[i9] = (int) j8;
        return (int) (j8 >>> 32);
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
        return Nat.incAt(7, iArr, i2, 3);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i]) & BodyPartID.bodyIdMax;
        int i3 = 0;
        int i4 = 14;
        int i5 = 6;
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
                long j21 = j18 & BodyPartID.bodyIdMax;
                long j22 = j16 + (j17 * j);
                int i16 = (int) j22;
                iArr2[i11] = (i16 << 1) | (i13 >>> 31);
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j23 & BodyPartID.bodyIdMax;
                long j26 = j20 + (j24 >>> 32);
                long j27 = j24 & BodyPartID.bodyIdMax;
                long j28 = ((long) iArr[i + 4]) & BodyPartID.bodyIdMax;
                int i17 = i2 + 7;
                long j29 = (((long) iArr2[i17]) & BodyPartID.bodyIdMax) + (j26 >>> 32);
                long j30 = j26 & BodyPartID.bodyIdMax;
                int i18 = i2 + 8;
                long j31 = (((long) iArr2[i18]) & BodyPartID.bodyIdMax) + (j29 >>> 32);
                long j32 = j29 & BodyPartID.bodyIdMax;
                long j33 = j25 + (j28 * j);
                int i19 = (int) j33;
                iArr2[i12] = (i19 << 1) | (i16 >>> 31);
                int i20 = i19 >>> 31;
                long j34 = j27 + (j33 >>> 32) + (j28 * j6);
                long j35 = j30 + (j34 >>> 32) + (j28 * j10);
                long j36 = j34 & BodyPartID.bodyIdMax;
                long j37 = j32 + (j35 >>> 32) + (j28 * j17);
                long j38 = j35 & BodyPartID.bodyIdMax;
                long j39 = j31 + (j37 >>> 32);
                long j40 = j37 & BodyPartID.bodyIdMax;
                long j41 = ((long) iArr[i + 5]) & BodyPartID.bodyIdMax;
                int i21 = i2 + 9;
                long j42 = (((long) iArr2[i21]) & BodyPartID.bodyIdMax) + (j39 >>> 32);
                long j43 = j39 & BodyPartID.bodyIdMax;
                int i22 = i2 + 10;
                long j44 = (((long) iArr2[i22]) & BodyPartID.bodyIdMax) + (j42 >>> 32);
                long j45 = j42 & BodyPartID.bodyIdMax;
                long j46 = j36 + (j41 * j);
                int i23 = (int) j46;
                iArr2[i14] = (i23 << 1) | i20;
                int i24 = i23 >>> 31;
                long j47 = j38 + (j46 >>> 32) + (j41 * j6);
                long j48 = j40 + (j47 >>> 32) + (j41 * j10);
                long j49 = j47 & BodyPartID.bodyIdMax;
                long j50 = j43 + (j48 >>> 32) + (j41 * j17);
                long j51 = j48 & BodyPartID.bodyIdMax;
                long j52 = j45 + (j50 >>> 32) + (j41 * j28);
                long j53 = j50 & BodyPartID.bodyIdMax;
                long j54 = j44 + (j52 >>> 32);
                long j55 = j52 & BodyPartID.bodyIdMax;
                long j56 = ((long) iArr[i + 6]) & BodyPartID.bodyIdMax;
                int i25 = i2 + 11;
                long j57 = (((long) iArr2[i25]) & BodyPartID.bodyIdMax) + (j54 >>> 32);
                long j58 = j54 & BodyPartID.bodyIdMax;
                int i26 = i2 + 12;
                long j59 = (((long) iArr2[i26]) & BodyPartID.bodyIdMax) + (j57 >>> 32);
                long j60 = j57 & BodyPartID.bodyIdMax;
                long j61 = j49 + (j * j56);
                int i27 = (int) j61;
                iArr2[i15] = (i27 << 1) | i24;
                long j62 = j51 + (j61 >>> 32) + (j6 * j56);
                long j63 = j53 + (j62 >>> 32) + (j56 * j10);
                long j64 = j55 + (j63 >>> 32) + (j56 * j17);
                long j65 = j58 + (j64 >>> 32) + (j56 * j28);
                long j66 = j60 + (j65 >>> 32) + (j56 * j41);
                long j67 = j59 + (j66 >>> 32);
                int i28 = (int) j62;
                iArr2[i17] = (i27 >>> 31) | (i28 << 1);
                int i29 = (int) j63;
                iArr2[i18] = (i28 >>> 31) | (i29 << 1);
                int i30 = i29 >>> 31;
                int i31 = (int) j64;
                iArr2[i21] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                int i33 = (int) j65;
                iArr2[i22] = i32 | (i33 << 1);
                int i34 = i33 >>> 31;
                int i35 = (int) j66;
                iArr2[i25] = i34 | (i35 << 1);
                int i36 = i35 >>> 31;
                int i37 = (int) j67;
                iArr2[i26] = i36 | (i37 << 1);
                int i38 = i37 >>> 31;
                int i39 = i2 + 13;
                iArr2[i39] = i38 | ((iArr2[i39] + ((int) (j67 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & BodyPartID.bodyIdMax;
        int i = 14;
        int i2 = 0;
        int i3 = 6;
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
                long j22 = j16 + (j17 * j);
                int i8 = (int) j22;
                iArr2[3] = (i7 >>> 31) | (i8 << 1);
                int i9 = i8 >>> 31;
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j23 & BodyPartID.bodyIdMax;
                long j26 = j20 + (j24 >>> 32);
                long j27 = j24 & BodyPartID.bodyIdMax;
                long j28 = ((long) iArr[4]) & BodyPartID.bodyIdMax;
                long j29 = (((long) iArr2[7]) & BodyPartID.bodyIdMax) + (j26 >>> 32);
                long j30 = j26 & BodyPartID.bodyIdMax;
                long j31 = (((long) iArr2[8]) & BodyPartID.bodyIdMax) + (j29 >>> 32);
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
                long j41 = ((long) iArr[5]) & BodyPartID.bodyIdMax;
                long j42 = (((long) iArr2[9]) & BodyPartID.bodyIdMax) + (j39 >>> 32);
                long j43 = j39 & BodyPartID.bodyIdMax;
                long j44 = (((long) iArr2[10]) & BodyPartID.bodyIdMax) + (j42 >>> 32);
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
                long j56 = ((long) iArr[6]) & BodyPartID.bodyIdMax;
                long j57 = (((long) iArr2[11]) & BodyPartID.bodyIdMax) + (j54 >>> 32);
                long j58 = j54 & BodyPartID.bodyIdMax;
                long j59 = (((long) iArr2[12]) & BodyPartID.bodyIdMax) + (j57 >>> 32);
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
        long j = (((long) iArr[i]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2]) & BodyPartID.bodyIdMax);
        iArr3[i3] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[i + 4]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[i + 5]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 5]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[i + 6]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 6]) & BodyPartID.bodyIdMax));
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & BodyPartID.bodyIdMax) - (((long) iArr2[4]) & BodyPartID.bodyIdMax));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[5]) & BodyPartID.bodyIdMax) - (((long) iArr2[5]) & BodyPartID.bodyIdMax));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[6]) & BodyPartID.bodyIdMax) - (((long) iArr2[6]) & BodyPartID.bodyIdMax));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j5 = (j4 >> 32) + (((((long) iArr3[4]) & BodyPartID.bodyIdMax) - (((long) iArr[4]) & BodyPartID.bodyIdMax)) - (((long) iArr2[4]) & BodyPartID.bodyIdMax));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + (((((long) iArr3[5]) & BodyPartID.bodyIdMax) - (((long) iArr[5]) & BodyPartID.bodyIdMax)) - (((long) iArr2[5]) & BodyPartID.bodyIdMax));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + (((((long) iArr3[6]) & BodyPartID.bodyIdMax) - (((long) iArr[6]) & BodyPartID.bodyIdMax)) - (((long) iArr2[6]) & BodyPartID.bodyIdMax));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
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
        int i6 = i2 + 4;
        long j5 = (j4 >> 32) + ((((long) iArr2[i6]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 4]) & BodyPartID.bodyIdMax));
        iArr2[i6] = (int) j5;
        int i7 = i2 + 5;
        long j6 = (j5 >> 32) + ((((long) iArr2[i7]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 5]) & BodyPartID.bodyIdMax));
        iArr2[i7] = (int) j6;
        int i8 = i2 + 6;
        long j7 = (j6 >> 32) + ((((long) iArr2[i8]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 6]) & BodyPartID.bodyIdMax));
        iArr2[i8] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = (((long) iArr2[0]) & BodyPartID.bodyIdMax) - (((long) iArr[0]) & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & BodyPartID.bodyIdMax) - (((long) iArr[1]) & BodyPartID.bodyIdMax));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & BodyPartID.bodyIdMax) - (((long) iArr[2]) & BodyPartID.bodyIdMax));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & BodyPartID.bodyIdMax) - (((long) iArr[3]) & BodyPartID.bodyIdMax));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & BodyPartID.bodyIdMax) - (((long) iArr[4]) & BodyPartID.bodyIdMax));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & BodyPartID.bodyIdMax) - (((long) iArr[5]) & BodyPartID.bodyIdMax));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr2[6]) & BodyPartID.bodyIdMax) - (BodyPartID.bodyIdMax & ((long) iArr[6])));
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
