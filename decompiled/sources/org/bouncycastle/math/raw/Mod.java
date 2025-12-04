package org.bouncycastle.math.raw;

import java.util.Random;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Integers;

/* loaded from: classes6.dex */
public abstract class Mod {
    public static void add(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.add(length, iArr2, iArr3, iArr4) != 0) {
            Nat.subFrom(length, iArr, iArr4);
        }
    }

    private static int add30(int i, int[] iArr, int[] iArr2) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + iArr[i4] + iArr2[i4];
            iArr[i4] = 1073741823 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 + iArr[i2] + iArr2[i2];
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static void checkedModOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        if (modOddInverse(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void checkedModOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        if (!modOddInverseVar(iArr, iArr2, iArr3)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    private static void cnegate30(int i, int i2, int[] iArr) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + ((iArr[i5] ^ i2) - i2);
            iArr[i5] = 1073741823 & i6;
            i4 = i6 >> 30;
        }
        iArr[i3] = i4 + ((iArr[i3] ^ i2) - i2);
    }

    private static void cnormalize30(int i, int i2, int[] iArr, int[] iArr2) {
        int i3 = i - 1;
        int i4 = iArr[i3] >> 31;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i5 + (((iArr[i6] + (iArr2[i6] & i4)) ^ i2) - i2);
            iArr[i6] = 1073741823 & i7;
            i5 = i7 >> 30;
        }
        int i8 = i5 + (((iArr[i3] + (i4 & iArr2[i3])) ^ i2) - i2);
        iArr[i3] = i8;
        int i9 = i8 >> 31;
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            int i12 = i10 + iArr[i11] + (iArr2[i11] & i9);
            iArr[i11] = i12 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            i10 = i12 >> 30;
        }
        iArr[i3] = i10 + iArr[i3] + (i9 & iArr2[i3]);
    }

    private static void decode30(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            while (i4 < Math.min(32, i)) {
                j |= iArr[i2] << i4;
                i4 += 30;
                i2++;
            }
            iArr2[i3] = (int) j;
            j >>>= 32;
            i4 -= 32;
            i -= 32;
            i3++;
        }
    }

    private static int divsteps30(int i, int i2, int i3, int[] iArr) {
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 30; i8++) {
            int i9 = i >> 31;
            int i10 = -(i3 & 1);
            int i11 = i3 + (((i2 ^ i9) - i9) & i10);
            i7 += ((i4 ^ i9) - i9) & i10;
            i5 += ((i6 ^ i9) - i9) & i10;
            int i12 = i9 & i10;
            i = (i ^ i12) - (i12 + 1);
            i2 += i11 & i12;
            i3 = i11 >> 1;
            i4 = (i4 + (i7 & i12)) << 1;
            i6 = (i6 + (i12 & i5)) << 1;
        }
        iArr[0] = i4;
        iArr[1] = i6;
        iArr[2] = i7;
        iArr[3] = i5;
        return i;
    }

    private static int divsteps30Var(int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5 = i2;
        int i6 = i3;
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        int i11 = 30;
        int i12 = i;
        while (true) {
            int iNumberOfTrailingZeros = Integers.numberOfTrailingZeros(((-1) << i11) | i6);
            int i13 = i6 >> iNumberOfTrailingZeros;
            i7 <<= iNumberOfTrailingZeros;
            i9 <<= iNumberOfTrailingZeros;
            i12 -= iNumberOfTrailingZeros;
            i11 -= iNumberOfTrailingZeros;
            if (i11 <= 0) {
                iArr[0] = i7;
                iArr[1] = i9;
                iArr[2] = i10;
                iArr[3] = i8;
                return i12;
            }
            if (i12 < 0) {
                i12 = -i12;
                int i14 = -i5;
                int i15 = -i7;
                int i16 = -i9;
                int i17 = i12 + 1;
                if (i17 > i11) {
                    i17 = i11;
                }
                i4 = ((-1) >>> (32 - i17)) & 63 & (i13 * i14 * ((i13 * i13) - 2));
                i13 = i14;
                i5 = i13;
                int i18 = i10;
                i10 = i15;
                i7 = i18;
                int i19 = i8;
                i8 = i16;
                i9 = i19;
            } else {
                int i20 = i12 + 1;
                if (i20 > i11) {
                    i20 = i11;
                }
                i4 = ((-1) >>> (32 - i20)) & 15 & ((-((((i5 + 1) & 4) << 1) + i5)) * i13);
            }
            i6 = i13 + (i5 * i4);
            i10 += i7 * i4;
            i8 += i4 * i9;
        }
    }

    private static void encode30(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            if (i4 < Math.min(30, i)) {
                j |= (iArr[i2] & BodyPartID.bodyIdMax) << i4;
                i4 += 32;
                i2++;
            }
            iArr2[i3] = ((int) j) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j >>>= 30;
            i4 -= 30;
            i -= 30;
            i3++;
        }
    }

    private static int getMaximumDivsteps(int i) {
        return ((i * 49) + (i < 46 ? 80 : 47)) / 17;
    }

    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }

    public static void invert(int[] iArr, int[] iArr2, int[] iArr3) {
        checkedModOddInverseVar(iArr, iArr2, iArr3);
    }

    public static int modOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int iNumberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr[length - 1]);
        int i = (iNumberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i];
        int[] iArr6 = new int[i];
        int[] iArr7 = new int[i];
        int[] iArr8 = new int[i];
        int[] iArr9 = new int[i];
        int i2 = 0;
        iArr6[0] = 1;
        encode30(iNumberOfLeadingZeros, iArr2, 0, iArr8, 0);
        encode30(iNumberOfLeadingZeros, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i);
        int iInverse32 = inverse32(iArr9[0]);
        int i3 = -1;
        int i4 = 0;
        for (int maximumDivsteps = getMaximumDivsteps(iNumberOfLeadingZeros); i4 < maximumDivsteps; maximumDivsteps = maximumDivsteps) {
            int iDivsteps30 = divsteps30(i3, iArr7[i2], iArr8[i2], iArr4);
            updateDE30(i, iArr5, iArr6, iArr4, iInverse32, iArr9);
            updateFG30(i, iArr7, iArr8, iArr4);
            i4 += 30;
            i2 = i2;
            i3 = iDivsteps30;
        }
        int i5 = i2;
        int i6 = iArr7[i - 1] >> 31;
        cnegate30(i, i6, iArr7);
        cnormalize30(i, i6, iArr5, iArr9);
        decode30(iNumberOfLeadingZeros, iArr5, i5, iArr3, i5);
        return Nat.equalTo(i, iArr7, 1) & Nat.equalToZero(i, iArr8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public static boolean modOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int iNumberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr[length - 1]);
        int i = (iNumberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i];
        int[] iArr6 = new int[i];
        int[] iArr7 = new int[i];
        int[] iArr8 = new int[i];
        int[] iArr9 = new int[i];
        ?? r9 = 0;
        iArr6[0] = 1;
        encode30(iNumberOfLeadingZeros, iArr2, 0, iArr8, 0);
        encode30(iNumberOfLeadingZeros, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i);
        int i2 = i - 1;
        int iNumberOfLeadingZeros2 = (-1) - (Integers.numberOfLeadingZeros(iArr8[i2] | 1) - (((i * 30) + 2) - iNumberOfLeadingZeros));
        int iInverse32 = inverse32(iArr9[0]);
        int maximumDivsteps = getMaximumDivsteps(iNumberOfLeadingZeros);
        int i3 = i;
        int i4 = 0;
        while (!Nat.isZero(i3, iArr8)) {
            if (i4 >= maximumDivsteps) {
                return r9;
            }
            int i5 = i4 + 30;
            int iDivsteps30Var = divsteps30Var(iNumberOfLeadingZeros2, iArr7[r9], iArr8[r9], iArr4);
            int[] iArr10 = iArr6;
            int i6 = i3;
            int i7 = maximumDivsteps;
            int[] iArr11 = iArr6;
            ?? r12 = r9;
            updateDE30(i, iArr5, iArr10, iArr4, iInverse32, iArr9);
            updateFG30(i6, iArr7, iArr8, iArr4);
            int i8 = i6 - 1;
            int i9 = iArr7[i8];
            int i10 = iArr8[i8];
            int i11 = i6 - 2;
            if (((i11 >> 31) | ((i9 >> 31) ^ i9) | ((i10 >> 31) ^ i10)) == 0) {
                iArr7[i11] = (i9 << 30) | iArr7[i11];
                iArr8[i11] = iArr8[i11] | (i10 << 30);
                i3 = i6 - 1;
            } else {
                i3 = i6;
            }
            r9 = r12;
            i4 = i5;
            iNumberOfLeadingZeros2 = iDivsteps30Var;
            maximumDivsteps = i7;
            iArr6 = iArr11;
        }
        int i12 = i3;
        boolean z = r9;
        int i13 = iArr7[i12 - 1] >> 31;
        int iNegate30 = iArr5[i2] >> 31;
        if (iNegate30 < 0) {
            iNegate30 = add30(i, iArr5, iArr9);
        }
        if (i13 < 0) {
            iNegate30 = negate30(i, iArr5);
            negate30(i12, iArr7);
        }
        if (!Nat.isOne(i12, iArr7)) {
            return z;
        }
        if (iNegate30 < 0) {
            add30(i, iArr5, iArr9);
        }
        decode30(iNumberOfLeadingZeros, iArr5, z ? 1 : 0, iArr3, z ? 1 : 0);
        return true;
    }

    private static int negate30(int i, int[] iArr) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 - iArr[i4];
            iArr[i4] = 1073741823 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 - iArr[i2];
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static int[] random(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] iArrCreate = Nat.create(length);
        int i = length - 1;
        int i2 = iArr[i];
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        do {
            for (int i8 = 0; i8 != length; i8++) {
                iArrCreate[i8] = random.nextInt();
            }
            iArrCreate[i] = iArrCreate[i] & i7;
        } while (Nat.gte(length, iArrCreate, iArr));
        return iArrCreate;
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.sub(length, iArr2, iArr3, iArr4) != 0) {
            Nat.addTo(length, iArr, iArr4);
        }
    }

    private static void updateDE30(int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int[] iArr4) {
        int i3 = i;
        int i4 = iArr3[0];
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        int i8 = i3 - 1;
        int i9 = iArr[i8] >> 31;
        int i10 = iArr2[i8] >> 31;
        int i11 = (i4 & i9) + (i5 & i10);
        int i12 = (i9 & i6) + (i10 & i7);
        int i13 = iArr4[0];
        long j = i4;
        long j2 = iArr[0];
        long j3 = i5;
        long j4 = iArr2[0];
        long j5 = (j * j2) + (j3 * j4);
        long j6 = i6;
        long j7 = i7;
        long j8 = (j2 * j6) + (j4 * j7);
        long j9 = i13;
        long j10 = i11 - (((((int) j5) * i2) + i11) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        int i14 = i8;
        long j11 = i12 - (((((int) j8) * i2) + i12) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        long j12 = (j8 + (j9 * j11)) >> 30;
        long j13 = (j5 + (j9 * j10)) >> 30;
        int i15 = 1;
        while (i15 < i3) {
            int i16 = iArr4[i15];
            long j14 = j12;
            long j15 = iArr[i15];
            int i17 = i15;
            long j16 = iArr2[i15];
            long j17 = j11;
            long j18 = i16;
            long j19 = j13 + (j * j15) + (j3 * j16) + (j18 * j10);
            long j20 = j14 + (j15 * j6) + (j16 * j7) + (j18 * j17);
            int i18 = i17 - 1;
            iArr[i18] = ((int) j19) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j13 = j19 >> 30;
            iArr2[i18] = ((int) j20) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j12 = j20 >> 30;
            i15 = i17 + 1;
            i3 = i;
            i14 = i14;
            j11 = j17;
        }
        int i19 = i14;
        iArr[i19] = (int) j13;
        iArr2[i19] = (int) j12;
    }

    private static void updateFG30(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = iArr3[0];
        int i3 = 1;
        int i4 = iArr3[1];
        int i5 = iArr3[2];
        int i6 = iArr3[3];
        long j = i2;
        long j2 = iArr[0];
        long j3 = i4;
        long j4 = iArr2[0];
        long j5 = i5;
        long j6 = i6;
        long j7 = ((j * j2) + (j3 * j4)) >> 30;
        long j8 = ((j2 * j5) + (j4 * j6)) >> 30;
        int i7 = 1;
        while (i7 < i) {
            int i8 = iArr[i7];
            int i9 = iArr2[i7];
            int i10 = i7;
            long j9 = i8;
            long j10 = j * j9;
            long j11 = j;
            long j12 = i9;
            long j13 = j7 + j10 + (j3 * j12);
            long j14 = j8 + (j9 * j5) + (j12 * j6);
            int i11 = i10 - 1;
            iArr[i11] = ((int) j13) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j7 = j13 >> 30;
            iArr2[i11] = 1073741823 & ((int) j14);
            j8 = j14 >> 30;
            i7 = i10 + 1;
            j = j11;
            i3 = 1;
        }
        int i12 = i - i3;
        iArr[i12] = (int) j7;
        iArr2[i12] = (int) j8;
    }
}
