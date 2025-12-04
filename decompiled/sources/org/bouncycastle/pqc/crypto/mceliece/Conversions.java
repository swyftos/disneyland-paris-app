package org.bouncycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.bouncycastle.pqc.math.linearalgebra.BigIntUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

/* loaded from: classes6.dex */
abstract class Conversions {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);

    public static byte[] decode(int i, int i2, GF2Vector gF2Vector) {
        if (gF2Vector.getLength() != i || gF2Vector.getHammingWeight() != i2) {
            throw new IllegalArgumentException("vector has wrong length or hamming weight");
        }
        int[] vecArray = gF2Vector.getVecArray();
        BigInteger bigIntegerBinomial = IntegerFunctions.binomial(i, i2);
        BigInteger bigIntegerAdd = ZERO;
        int i3 = i;
        for (int i4 = 0; i4 < i; i4++) {
            bigIntegerBinomial = bigIntegerBinomial.multiply(BigInteger.valueOf(i3 - i2)).divide(BigInteger.valueOf(i3));
            i3--;
            if ((vecArray[i4 >> 5] & (1 << (i4 & 31))) != 0) {
                bigIntegerAdd = bigIntegerAdd.add(bigIntegerBinomial);
                int i5 = i2 - 1;
                bigIntegerBinomial = i3 == i5 ? ONE : bigIntegerBinomial.multiply(BigInteger.valueOf(i2)).divide(BigInteger.valueOf(i3 - i5));
                i2 = i5;
            }
        }
        return BigIntUtils.toMinimalByteArray(bigIntegerAdd);
    }

    public static GF2Vector encode(int i, int i2, byte[] bArr) {
        if (i < i2) {
            throw new IllegalArgumentException("n < t");
        }
        BigInteger bigIntegerBinomial = IntegerFunctions.binomial(i, i2);
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(bigIntegerBinomial) >= 0) {
            throw new IllegalArgumentException("Encoded number too large.");
        }
        GF2Vector gF2Vector = new GF2Vector(i);
        int i3 = i;
        for (int i4 = 0; i4 < i; i4++) {
            bigIntegerBinomial = bigIntegerBinomial.multiply(BigInteger.valueOf(i3 - i2)).divide(BigInteger.valueOf(i3));
            i3--;
            if (bigIntegerBinomial.compareTo(bigInteger) <= 0) {
                gF2Vector.setBit(i4);
                bigInteger = bigInteger.subtract(bigIntegerBinomial);
                int i5 = i2 - 1;
                bigIntegerBinomial = i3 == i5 ? ONE : bigIntegerBinomial.multiply(BigInteger.valueOf(i2)).divide(BigInteger.valueOf(i3 - i5));
                i2 = i5;
            }
        }
        return gF2Vector;
    }
}
