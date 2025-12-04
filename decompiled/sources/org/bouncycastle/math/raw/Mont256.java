package org.bouncycastle.math.raw;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes6.dex */
public abstract class Mont256 {
    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }

    public static void multAdd(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        char c = 0;
        long j = iArr2[0] & BodyPartID.bodyIdMax;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 8) {
            long j2 = iArr3[c] & BodyPartID.bodyIdMax;
            long j3 = iArr[i2] & BodyPartID.bodyIdMax;
            long j4 = j3 * j;
            long j5 = (j4 & BodyPartID.bodyIdMax) + j2;
            long j6 = j;
            long j7 = (((int) j5) * i) & BodyPartID.bodyIdMax;
            int i4 = i2;
            int i5 = i3;
            long j8 = (iArr4[c] & BodyPartID.bodyIdMax) * j7;
            char c2 = ' ';
            long j9 = ((j5 + (j8 & BodyPartID.bodyIdMax)) >>> 32) + (j4 >>> 32) + (j8 >>> 32);
            int i6 = 1;
            while (i6 < 8) {
                long j10 = (iArr2[i6] & BodyPartID.bodyIdMax) * j3;
                long j11 = (iArr4[i6] & BodyPartID.bodyIdMax) * j7;
                long j12 = j9 + (j10 & BodyPartID.bodyIdMax) + (j11 & BodyPartID.bodyIdMax) + (iArr3[i6] & BodyPartID.bodyIdMax);
                iArr3[i6 - 1] = (int) j12;
                j9 = (j12 >>> 32) + (j10 >>> 32) + (j11 >>> 32);
                i6++;
                c2 = ' ';
                j7 = j7;
            }
            long j13 = j9 + (i5 & BodyPartID.bodyIdMax);
            iArr3[7] = (int) j13;
            i3 = (int) (j13 >>> c2);
            i2 = i4 + 1;
            j = j6;
            c = 0;
        }
        if (i3 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void multAddXF(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        char c = 0;
        long j = iArr2[0] & BodyPartID.bodyIdMax;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= 8) {
                break;
            }
            long j2 = iArr[i] & BodyPartID.bodyIdMax;
            long j3 = (j2 * j) + (iArr3[c] & BodyPartID.bodyIdMax);
            long j4 = j3 & BodyPartID.bodyIdMax;
            long j5 = (j3 >>> 32) + j4;
            int i3 = 1;
            for (int i4 = 8; i3 < i4; i4 = 8) {
                long j6 = j;
                long j7 = (iArr2[i3] & BodyPartID.bodyIdMax) * j2;
                long j8 = (iArr4[i3] & BodyPartID.bodyIdMax) * j4;
                long j9 = j5 + (j7 & BodyPartID.bodyIdMax) + (j8 & BodyPartID.bodyIdMax) + (iArr3[i3] & BodyPartID.bodyIdMax);
                iArr3[i3 - 1] = (int) j9;
                j5 = (j9 >>> 32) + (j7 >>> 32) + (j8 >>> 32);
                i3++;
                j = j6;
                j2 = j2;
                j4 = j4;
            }
            long j10 = j5 + (i2 & BodyPartID.bodyIdMax);
            iArr3[7] = (int) j10;
            i2 = (int) (j10 >>> 32);
            i++;
            j = j;
            c = 0;
        }
        if (i2 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2, int i) {
        char c = 0;
        int i2 = 0;
        while (i2 < 8) {
            int i3 = iArr[c];
            long j = (i3 * i) & BodyPartID.bodyIdMax;
            long j2 = (((iArr2[c] & BodyPartID.bodyIdMax) * j) + (i3 & BodyPartID.bodyIdMax)) >>> 32;
            int i4 = 1;
            while (i4 < 8) {
                long j3 = j2 + ((iArr2[i4] & BodyPartID.bodyIdMax) * j) + (iArr[i4] & BodyPartID.bodyIdMax);
                iArr[i4 - 1] = (int) j3;
                j2 = j3 >>> 32;
                i4++;
                i2 = i2;
            }
            iArr[7] = (int) j2;
            i2++;
            c = 0;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }

    public static void reduceXF(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 8; i++) {
            long j = iArr[0] & BodyPartID.bodyIdMax;
            long j2 = j;
            for (int i2 = 1; i2 < 8; i2++) {
                long j3 = j2 + ((iArr2[i2] & BodyPartID.bodyIdMax) * j) + (iArr[i2] & BodyPartID.bodyIdMax);
                iArr[i2 - 1] = (int) j3;
                j2 = j3 >>> 32;
            }
            iArr[7] = (int) j2;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }
}
