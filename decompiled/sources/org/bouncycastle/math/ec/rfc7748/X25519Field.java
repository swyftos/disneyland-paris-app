package org.bouncycastle.math.ec.rfc7748;

import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import org.bouncycastle.math.raw.Mod;

/* loaded from: classes6.dex */
public abstract class X25519Field {
    private static final int[] P32 = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    private static final int[] ROOT_NEG_ONE = {34513072, 59165138, 4688974, 3500415, 6194736, 33281959, 54535759, 32551604, 163342, 5703241};
    public static final int SIZE = 10;

    protected X25519Field() {
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < 10; i++) {
            iArr3[i] = iArr[i] + iArr2[i];
        }
    }

    public static void addOne(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void addOne(int[] iArr, int i) {
        iArr[i] = iArr[i] + 1;
    }

    public static void apm(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i = 0; i < 10; i++) {
            int i2 = iArr[i];
            int i3 = iArr2[i];
            iArr3[i] = i2 + i3;
            iArr4[i] = i2 - i3;
        }
    }

    public static void carry(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = i3 + (i2 >> 26);
        int i11 = i5 + (i4 >> 26);
        int i12 = i8 + (i7 >> 26);
        int i13 = iArr[9] + (i9 >> 26);
        int i14 = (i4 & 67108863) + (i10 >> 25);
        int i15 = i6 + (i11 >> 25);
        int i16 = (i9 & 67108863) + (i12 >> 25);
        int i17 = i + ((i13 >> 25) * 38);
        int i18 = (i2 & 67108863) + (i17 >> 26);
        int i19 = (i7 & 67108863) + (i15 >> 26);
        iArr[0] = i17 & 67108863;
        iArr[1] = i18 & 67108863;
        iArr[2] = (i10 & 33554431) + (i18 >> 26);
        iArr[3] = i14 & 67108863;
        iArr[4] = (i11 & 33554431) + (i14 >> 26);
        iArr[5] = i15 & 67108863;
        iArr[6] = i19 & 67108863;
        iArr[7] = (i12 & 33554431) + (i19 >> 26);
        iArr[8] = i16 & 67108863;
        iArr[9] = (i13 & 33554431) + (i16 >> 26);
    }

    public static void cmov(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 0; i4 < 10; i4++) {
            int i5 = i3 + i4;
            int i6 = iArr2[i5];
            iArr2[i5] = i6 ^ ((iArr[i2 + i4] ^ i6) & i);
        }
    }

    public static void cnegate(int i, int[] iArr) {
        int i2 = 0 - i;
        for (int i3 = 0; i3 < 10; i3++) {
            iArr[i3] = (iArr[i3] ^ i2) - i2;
        }
    }

    public static void copy(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 0; i3 < 10; i3++) {
            iArr2[i2 + i3] = iArr[i + i3];
        }
    }

    public static int[] create() {
        return new int[10];
    }

    public static int[] createTable(int i) {
        return new int[i * 10];
    }

    public static void cswap(int i, int[] iArr, int[] iArr2) {
        int i2 = 0 - i;
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = iArr[i3];
            int i5 = iArr2[i3];
            int i6 = (i4 ^ i5) & i2;
            iArr[i3] = i4 ^ i6;
            iArr2[i3] = i5 ^ i6;
        }
    }

    public static void decode(byte[] bArr, int i, int[] iArr) {
        decode128(bArr, i, iArr, 0);
        decode128(bArr, i + 16, iArr, 5);
        iArr[9] = iArr[9] & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static void decode(int[] iArr, int i, int[] iArr2) {
        decode128(iArr, i, iArr2, 0);
        decode128(iArr, i + 4, iArr2, 5);
        iArr2[9] = iArr2[9] & ViewCompat.MEASURED_SIZE_MASK;
    }

    private static void decode128(byte[] bArr, int i, int[] iArr, int i2) {
        int iDecode32 = decode32(bArr, i);
        int iDecode322 = decode32(bArr, i + 4);
        int iDecode323 = decode32(bArr, i + 8);
        int iDecode324 = decode32(bArr, i + 12);
        iArr[i2] = iDecode32 & 67108863;
        iArr[i2 + 1] = ((iDecode32 >>> 26) | (iDecode322 << 6)) & 67108863;
        iArr[i2 + 2] = ((iDecode322 >>> 20) | (iDecode323 << 12)) & 33554431;
        iArr[i2 + 3] = 67108863 & ((iDecode324 << 19) | (iDecode323 >>> 13));
        iArr[i2 + 4] = iDecode324 >>> 7;
    }

    private static void decode128(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i];
        int i4 = iArr[i + 1];
        int i5 = iArr[i + 2];
        int i6 = iArr[i + 3];
        iArr2[i2] = i3 & 67108863;
        iArr2[i2 + 1] = ((i3 >>> 26) | (i4 << 6)) & 67108863;
        iArr2[i2 + 2] = ((i4 >>> 20) | (i5 << 12)) & 33554431;
        iArr2[i2 + 3] = 67108863 & ((i6 << 19) | (i5 >>> 13));
        iArr2[i2 + 4] = i6 >>> 7;
    }

    private static int decode32(byte[] bArr, int i) {
        return (bArr[i + 3] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static void encode(int[] iArr, byte[] bArr, int i) {
        encode128(iArr, 0, bArr, i);
        encode128(iArr, 5, bArr, i + 16);
    }

    public static void encode(int[] iArr, int[] iArr2, int i) {
        encode128(iArr, 0, iArr2, i);
        encode128(iArr, 5, iArr2, i + 4);
    }

    private static void encode128(int[] iArr, int i, byte[] bArr, int i2) {
        int i3 = iArr[i];
        int i4 = iArr[i + 1];
        int i5 = iArr[i + 2];
        int i6 = iArr[i + 3];
        int i7 = iArr[i + 4];
        encode32((i4 << 26) | i3, bArr, i2);
        encode32((i4 >>> 6) | (i5 << 20), bArr, i2 + 4);
        encode32((i5 >>> 12) | (i6 << 13), bArr, i2 + 8);
        encode32((i7 << 7) | (i6 >>> 19), bArr, i2 + 12);
    }

    private static void encode128(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i];
        int i4 = iArr[i + 1];
        int i5 = iArr[i + 2];
        int i6 = iArr[i + 3];
        int i7 = iArr[i + 4];
        iArr2[i2] = (i4 << 26) | i3;
        iArr2[i2 + 1] = (i4 >>> 6) | (i5 << 20);
        iArr2[i2 + 2] = (i5 >>> 12) | (i6 << 13);
        iArr2[i2 + 3] = (i7 << 7) | (i6 >>> 19);
    }

    private static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public static void inv(int[] iArr, int[] iArr2) {
        int[] iArrCreate = create();
        int[] iArr3 = new int[8];
        copy(iArr, 0, iArrCreate, 0);
        normalize(iArrCreate);
        encode(iArrCreate, iArr3, 0);
        Mod.modOddInverse(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static void invVar(int[] iArr, int[] iArr2) {
        int[] iArrCreate = create();
        int[] iArr3 = new int[8];
        copy(iArr, 0, iArrCreate, 0);
        normalize(iArrCreate);
        encode(iArrCreate, iArr3, 0);
        Mod.modOddInverseVar(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            i |= iArr[i2];
        }
        return (((i >>> 1) | (i & 1)) - 1) >> 31;
    }

    public static boolean isZeroVar(int[] iArr) {
        return isZero(iArr) != 0;
    }

    public static void mul(int[] iArr, int i, int[] iArr2) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = iArr[8];
        long j = i;
        long j2 = i4 * j;
        int i11 = ((int) j2) & 33554431;
        long j3 = i6 * j;
        int i12 = ((int) j3) & 33554431;
        long j4 = i9 * j;
        int i13 = ((int) j4) & 33554431;
        long j5 = iArr[9] * j;
        int i14 = ((int) j5) & 33554431;
        long j6 = ((j5 >> 25) * 38) + (i2 * j);
        iArr2[0] = ((int) j6) & 67108863;
        long j7 = (j3 >> 25) + (i7 * j);
        iArr2[5] = ((int) j7) & 67108863;
        long j8 = (j6 >> 26) + (i3 * j);
        iArr2[1] = ((int) j8) & 67108863;
        long j9 = (j2 >> 25) + (i5 * j);
        iArr2[3] = ((int) j9) & 67108863;
        long j10 = (j7 >> 26) + (i8 * j);
        iArr2[6] = ((int) j10) & 67108863;
        long j11 = (j4 >> 25) + (i10 * j);
        iArr2[8] = ((int) j11) & 67108863;
        iArr2[2] = i11 + ((int) (j8 >> 26));
        iArr2[4] = i12 + ((int) (j9 >> 26));
        iArr2[7] = i13 + ((int) (j10 >> 26));
        iArr2[9] = i14 + ((int) (j11 >> 26));
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = iArr[0];
        int i2 = iArr2[0];
        int i3 = iArr[1];
        int i4 = iArr2[1];
        int i5 = iArr[2];
        int i6 = iArr2[2];
        int i7 = iArr[3];
        int i8 = iArr2[3];
        int i9 = iArr[4];
        int i10 = iArr2[4];
        int i11 = iArr[5];
        int i12 = iArr2[5];
        int i13 = iArr[6];
        int i14 = iArr2[6];
        int i15 = iArr[7];
        int i16 = iArr2[7];
        int i17 = iArr[8];
        int i18 = iArr2[8];
        int i19 = iArr[9];
        int i20 = iArr2[9];
        long j = i;
        long j2 = i2;
        long j3 = j * j2;
        long j4 = i4;
        long j5 = i3;
        long j6 = (j * j4) + (j5 * j2);
        long j7 = i6;
        long j8 = i5;
        long j9 = (j * j7) + (j5 * j4) + (j8 * j2);
        long j10 = ((j5 * j7) + (j8 * j4)) << 1;
        long j11 = i8;
        long j12 = j * j11;
        long j13 = i7;
        long j14 = j10 + j12 + (j13 * j2);
        long j15 = (j8 * j7) << 1;
        long j16 = i10;
        long j17 = (j * j16) + (j5 * j11) + (j13 * j4);
        long j18 = i9;
        long j19 = j15 + j17 + (j2 * j18);
        long j20 = ((((j5 * j16) + (j8 * j11)) + (j13 * j7)) + (j18 * j4)) << 1;
        long j21 = (((j8 * j16) + (j18 * j7)) << 1) + (j13 * j11);
        long j22 = (j13 * j16) + (j18 * j11);
        long j23 = (j18 * j16) << 1;
        long j24 = i11;
        long j25 = i12;
        long j26 = j24 * j25;
        long j27 = i14;
        long j28 = i13;
        long j29 = (j24 * j27) + (j28 * j25);
        long j30 = i16;
        long j31 = i15;
        long j32 = (j24 * j30) + (j28 * j27) + (j31 * j25);
        long j33 = i18;
        long j34 = i17;
        long j35 = (((j28 * j30) + (j31 * j27)) << 1) + (j24 * j33) + (j34 * j25);
        long j36 = (j31 * j30) << 1;
        long j37 = i20;
        long j38 = (j24 * j37) + (j28 * j33) + (j34 * j27);
        long j39 = i19;
        long j40 = j36 + j38 + (j25 * j39);
        long j41 = j3 - (((((j28 * j37) + (j31 * j33)) + (j34 * j30)) + (j39 * j27)) * 76);
        long j42 = j6 - (((((j31 * j37) + (j39 * j30)) << 1) + (j34 * j33)) * 38);
        long j43 = j9 - (((j34 * j37) + (j33 * j39)) * 38);
        long j44 = j14 - ((j39 * j37) * 76);
        long j45 = j20 - j26;
        long j46 = j21 - j29;
        long j47 = j22 - j32;
        long j48 = j23 - j35;
        int i21 = i + i11;
        int i22 = i3 + i13;
        int i23 = i5 + i15;
        int i24 = i6 + i16;
        int i25 = i7 + i17;
        int i26 = i9 + i19;
        long j49 = i21;
        long j50 = i2 + i12;
        long j51 = i4 + i14;
        long j52 = i22;
        long j53 = (j49 * j51) + (j52 * j50);
        long j54 = i24;
        long j55 = i23;
        long j56 = (j49 * j54) + (j52 * j51) + (j55 * j50);
        long j57 = ((j52 * j54) + (j55 * j51)) << 1;
        long j58 = i8 + i18;
        long j59 = i25;
        long j60 = i10 + i20;
        long j61 = i26;
        long j62 = ((((j52 * j60) + (j55 * j58)) + (j59 * j54)) + (j61 * j51)) << 1;
        long j63 = (((j55 * j60) + (j61 * j54)) << 1) + (j59 * j58);
        long j64 = j48 + ((j57 + ((j49 * j58) + (j59 * j50))) - j44);
        int i27 = ((int) j64) & 67108863;
        long j65 = (j64 >> 26) + (((((j55 * j54) << 1) + ((((j49 * j60) + (j52 * j58)) + (j59 * j51)) + (j50 * j61))) - j19) - j40);
        int i28 = ((int) j65) & 33554431;
        long j66 = j41 + ((((j65 >> 25) + j62) - j45) * 38);
        iArr3[0] = ((int) j66) & 67108863;
        long j67 = (j66 >> 26) + j42 + ((j63 - j46) * 38);
        iArr3[1] = ((int) j67) & 67108863;
        long j68 = (j67 >> 26) + j43 + ((((j59 * j60) + (j61 * j58)) - j47) * 38);
        iArr3[2] = ((int) j68) & 33554431;
        long j69 = (j68 >> 25) + j44 + ((((j61 * j60) << 1) - j48) * 38);
        iArr3[3] = ((int) j69) & 67108863;
        long j70 = (j69 >> 26) + j19 + (j40 * 38);
        iArr3[4] = ((int) j70) & 33554431;
        long j71 = (j70 >> 25) + j45 + ((j49 * j50) - j41);
        iArr3[5] = ((int) j71) & 67108863;
        long j72 = (j71 >> 26) + j46 + (j53 - j42);
        iArr3[6] = ((int) j72) & 67108863;
        long j73 = (j72 >> 26) + j47 + (j56 - j43);
        iArr3[7] = ((int) j73) & 33554431;
        long j74 = (j73 >> 25) + i27;
        iArr3[8] = ((int) j74) & 67108863;
        iArr3[9] = i28 + ((int) (j74 >> 26));
    }

    public static void negate(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 10; i++) {
            iArr2[i] = -iArr[i];
        }
    }

    public static void normalize(int[] iArr) {
        int i = (iArr[9] >>> 23) & 1;
        reduce(iArr, i);
        reduce(iArr, -i);
    }

    public static void one(int[] iArr) {
        iArr[0] = 1;
        for (int i = 1; i < 10; i++) {
            iArr[i] = 0;
        }
    }

    private static void powPm5d8(int[] iArr, int[] iArr2, int[] iArr3) {
        sqr(iArr, iArr2);
        mul(iArr, iArr2, iArr2);
        int[] iArrCreate = create();
        sqr(iArr2, iArrCreate);
        mul(iArr, iArrCreate, iArrCreate);
        sqr(iArrCreate, 2, iArrCreate);
        mul(iArr2, iArrCreate, iArrCreate);
        int[] iArrCreate2 = create();
        sqr(iArrCreate, 5, iArrCreate2);
        mul(iArrCreate, iArrCreate2, iArrCreate2);
        int[] iArrCreate3 = create();
        sqr(iArrCreate2, 5, iArrCreate3);
        mul(iArrCreate, iArrCreate3, iArrCreate3);
        sqr(iArrCreate3, 10, iArrCreate);
        mul(iArrCreate2, iArrCreate, iArrCreate);
        sqr(iArrCreate, 25, iArrCreate2);
        mul(iArrCreate, iArrCreate2, iArrCreate2);
        sqr(iArrCreate2, 25, iArrCreate3);
        mul(iArrCreate, iArrCreate3, iArrCreate3);
        sqr(iArrCreate3, 50, iArrCreate);
        mul(iArrCreate2, iArrCreate, iArrCreate);
        sqr(iArrCreate, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH, iArrCreate2);
        mul(iArrCreate, iArrCreate2, iArrCreate2);
        sqr(iArrCreate2, 2, iArrCreate);
        mul(iArrCreate, iArr, iArr3);
    }

    private static void reduce(int[] iArr, int i) {
        int i2 = iArr[9];
        long j = (((i2 >> 24) + i) * 19) + iArr[0];
        iArr[0] = ((int) j) & 67108863;
        long j2 = (j >> 26) + iArr[1];
        iArr[1] = ((int) j2) & 67108863;
        long j3 = (j2 >> 26) + iArr[2];
        iArr[2] = ((int) j3) & 33554431;
        long j4 = (j3 >> 25) + iArr[3];
        iArr[3] = ((int) j4) & 67108863;
        long j5 = (j4 >> 26) + iArr[4];
        iArr[4] = ((int) j5) & 33554431;
        long j6 = (j5 >> 25) + iArr[5];
        iArr[5] = ((int) j6) & 67108863;
        long j7 = (j6 >> 26) + iArr[6];
        iArr[6] = ((int) j7) & 67108863;
        long j8 = (j7 >> 26) + iArr[7];
        iArr[7] = 33554431 & ((int) j8);
        long j9 = (j8 >> 25) + iArr[8];
        iArr[8] = 67108863 & ((int) j9);
        iArr[9] = (16777215 & i2) + ((int) (j9 >> 26));
    }

    public static void sqr(int[] iArr, int i, int[] iArr2) {
        sqr(iArr, iArr2);
        while (true) {
            i--;
            if (i <= 0) {
                return;
            } else {
                sqr(iArr2, iArr2);
            }
        }
    }

    public static void sqr(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        long j = i;
        long j2 = j * j;
        long j3 = i2 * 2;
        long j4 = j * j3;
        long j5 = i3 * 2;
        long j6 = i2;
        long j7 = (j * j5) + (j6 * j6);
        long j8 = i4 * 2;
        long j9 = (j3 * j5) + (j * j8);
        long j10 = i5 * 2;
        long j11 = (i3 * j5) + (j * j10) + (j6 * j8);
        long j12 = (j3 * j10) + (j8 * j5);
        long j13 = i4;
        long j14 = (j5 * j10) + (j13 * j13);
        long j15 = j13 * j10;
        long j16 = i5 * j10;
        int i11 = i10 * 2;
        long j17 = i6;
        long j18 = j17 * j17;
        long j19 = i7 * 2;
        long j20 = j17 * j19;
        long j21 = i8 * 2;
        long j22 = i7;
        long j23 = (j17 * j21) + (j22 * j22);
        long j24 = i9 * 2;
        long j25 = (j19 * j21) + (j17 * j24);
        long j26 = i11;
        long j27 = (i8 * j21) + (j17 * j26) + (j22 * j24);
        long j28 = i9;
        long j29 = j2 - (((j19 * j26) + (j24 * j21)) * 38);
        long j30 = j4 - (((j21 * j26) + (j28 * j28)) * 38);
        long j31 = j7 - ((j28 * j26) * 38);
        long j32 = j9 - ((i10 * j26) * 38);
        long j33 = j12 - j18;
        long j34 = j14 - j20;
        long j35 = j15 - j23;
        long j36 = j16 - j25;
        int i12 = i2 + i7;
        int i13 = i3 + i8;
        int i14 = i4 + i9;
        int i15 = i5 + i10;
        long j37 = i + i6;
        long j38 = j37 * j37;
        long j39 = i12 * 2;
        long j40 = j37 * j39;
        long j41 = i13 * 2;
        long j42 = i12;
        long j43 = (j37 * j41) + (j42 * j42);
        long j44 = i14 * 2;
        long j45 = (j39 * j41) + (j37 * j44);
        long j46 = i15 * 2;
        long j47 = (i13 * j41) + (j37 * j46) + (j42 * j44);
        long j48 = (j39 * j46) + (j44 * j41);
        long j49 = i14;
        long j50 = (j41 * j46) + (j49 * j49);
        long j51 = j49 * j46;
        long j52 = i15 * j46;
        long j53 = j36 + (j45 - j32);
        int i16 = ((int) j53) & 67108863;
        long j54 = (j53 >> 26) + ((j47 - j11) - j27);
        int i17 = ((int) j54) & 33554431;
        long j55 = j29 + ((((j54 >> 25) + j48) - j33) * 38);
        iArr2[0] = ((int) j55) & 67108863;
        long j56 = (j55 >> 26) + j30 + ((j50 - j34) * 38);
        iArr2[1] = ((int) j56) & 67108863;
        long j57 = (j56 >> 26) + j31 + ((j51 - j35) * 38);
        iArr2[2] = ((int) j57) & 33554431;
        long j58 = (j57 >> 25) + j32 + ((j52 - j36) * 38);
        iArr2[3] = ((int) j58) & 67108863;
        long j59 = (j58 >> 26) + j11 + (38 * j27);
        iArr2[4] = ((int) j59) & 33554431;
        long j60 = (j59 >> 25) + j33 + (j38 - j29);
        iArr2[5] = ((int) j60) & 67108863;
        long j61 = (j60 >> 26) + j34 + (j40 - j30);
        iArr2[6] = ((int) j61) & 67108863;
        long j62 = (j61 >> 26) + j35 + (j43 - j31);
        iArr2[7] = ((int) j62) & 33554431;
        long j63 = (j62 >> 25) + i16;
        iArr2[8] = ((int) j63) & 67108863;
        iArr2[9] = i17 + ((int) (j63 >> 26));
    }

    public static boolean sqrtRatioVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreate = create();
        int[] iArrCreate2 = create();
        mul(iArr, iArr2, iArrCreate);
        sqr(iArr2, iArrCreate2);
        mul(iArrCreate, iArrCreate2, iArrCreate);
        sqr(iArrCreate2, iArrCreate2);
        mul(iArrCreate2, iArrCreate, iArrCreate2);
        int[] iArrCreate3 = create();
        int[] iArrCreate4 = create();
        powPm5d8(iArrCreate2, iArrCreate3, iArrCreate4);
        mul(iArrCreate4, iArrCreate, iArrCreate4);
        int[] iArrCreate5 = create();
        sqr(iArrCreate4, iArrCreate5);
        mul(iArrCreate5, iArr2, iArrCreate5);
        sub(iArrCreate5, iArr, iArrCreate3);
        normalize(iArrCreate3);
        if (isZeroVar(iArrCreate3)) {
            copy(iArrCreate4, 0, iArr3, 0);
            return true;
        }
        add(iArrCreate5, iArr, iArrCreate3);
        normalize(iArrCreate3);
        if (!isZeroVar(iArrCreate3)) {
            return false;
        }
        mul(iArrCreate4, ROOT_NEG_ONE, iArr3);
        return true;
    }

    public static void sub(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < 10; i++) {
            iArr3[i] = iArr[i] - iArr2[i];
        }
    }

    public static void subOne(int[] iArr) {
        iArr[0] = iArr[0] - 1;
    }

    public static void zero(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            iArr[i] = 0;
        }
    }
}
