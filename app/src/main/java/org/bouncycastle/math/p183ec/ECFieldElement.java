package org.bouncycastle.math.p183ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ECFieldElement implements ECConstants {

    public static abstract class AbstractF2m extends ECFieldElement {
        public ECFieldElement halfTrace() {
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) == 0) {
                throw new IllegalStateException("Half-trace only defined for odd m");
            }
            int i = (fieldSize + 1) >>> 1;
            int iNumberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(i);
            ECFieldElement eCFieldElementAdd = this;
            int i2 = 1;
            while (iNumberOfLeadingZeros > 0) {
                eCFieldElementAdd = eCFieldElementAdd.squarePow(i2 << 1).add(eCFieldElementAdd);
                iNumberOfLeadingZeros--;
                i2 = i >>> iNumberOfLeadingZeros;
                if ((i2 & 1) != 0) {
                    eCFieldElementAdd = eCFieldElementAdd.squarePow(2).add(this);
                }
            }
            return eCFieldElementAdd;
        }

        public boolean hasFastTrace() {
            return false;
        }

        public int trace() {
            int fieldSize = getFieldSize();
            int iNumberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(fieldSize);
            ECFieldElement eCFieldElementAdd = this;
            int i = 1;
            while (iNumberOfLeadingZeros > 0) {
                eCFieldElementAdd = eCFieldElementAdd.squarePow(i).add(eCFieldElementAdd);
                iNumberOfLeadingZeros--;
                i = fieldSize >>> iNumberOfLeadingZeros;
                if ((i & 1) != 0) {
                    eCFieldElementAdd = eCFieldElementAdd.square().add(this);
                }
            }
            if (eCFieldElementAdd.isZero()) {
                return 0;
            }
            if (eCFieldElementAdd.isOne()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class AbstractFp extends ECFieldElement {
    }

    public static class F2m extends AbstractF2m {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;

        /* JADX INFO: renamed from: ks */
        private int[] f4697ks;

        /* JADX INFO: renamed from: m */
        private int f4698m;
        private int representation;

        /* JADX INFO: renamed from: x */
        LongArray f4699x;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
                this.f4697ks = new int[]{i2};
            } else {
                if (i3 >= i4) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (i3 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.representation = 3;
                this.f4697ks = new int[]{i2, i3, i4};
            }
            this.f4698m = i;
            this.f4699x = new LongArray(bigInteger);
        }

        F2m(int i, int[] iArr, LongArray longArray) {
            this.f4698m = i;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.f4697ks = iArr;
            this.f4699x = longArray;
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.f4699x.clone();
            longArray.addShiftedByWords(((F2m) eCFieldElement).f4699x, 0);
            return new F2m(this.f4698m, this.f4697ks, longArray);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement addOne() {
            return new F2m(this.f4698m, this.f4697ks, this.f4699x.addOne());
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public int bitLength() {
            return this.f4699x.degree();
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.f4698m == f2m.f4698m && this.representation == f2m.representation && Arrays.areEqual(this.f4697ks, f2m.f4697ks) && this.f4699x.equals(f2m.f4699x);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public int getFieldSize() {
            return this.f4698m;
        }

        public int getK1() {
            return this.f4697ks[0];
        }

        public int getK2() {
            int[] iArr = this.f4697ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.f4697ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int getM() {
            return this.f4698m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f4697ks) ^ (this.f4699x.hashCode() ^ this.f4698m);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement invert() {
            int i = this.f4698m;
            int[] iArr = this.f4697ks;
            return new F2m(i, iArr, this.f4699x.modInverse(i, iArr));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public boolean isOne() {
            return this.f4699x.isOne();
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public boolean isZero() {
            return this.f4699x.isZero();
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            int i = this.f4698m;
            int[] iArr = this.f4697ks;
            return new F2m(i, iArr, this.f4699x.modMultiply(((F2m) eCFieldElement).f4699x, i, iArr));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            LongArray longArray = this.f4699x;
            LongArray longArray2 = ((F2m) eCFieldElement).f4699x;
            LongArray longArray3 = ((F2m) eCFieldElement2).f4699x;
            LongArray longArray4 = ((F2m) eCFieldElement3).f4699x;
            LongArray longArrayMultiply = longArray.multiply(longArray2, this.f4698m, this.f4697ks);
            LongArray longArrayMultiply2 = longArray3.multiply(longArray4, this.f4698m, this.f4697ks);
            if (longArrayMultiply == longArray || longArrayMultiply == longArray2) {
                longArrayMultiply = (LongArray) longArrayMultiply.clone();
            }
            longArrayMultiply.addShiftedByWords(longArrayMultiply2, 0);
            longArrayMultiply.reduce(this.f4698m, this.f4697ks);
            return new F2m(this.f4698m, this.f4697ks, longArrayMultiply);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement sqrt() {
            return (this.f4699x.isZero() || this.f4699x.isOne()) ? this : squarePow(this.f4698m - 1);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement square() {
            int i = this.f4698m;
            int[] iArr = this.f4697ks;
            return new F2m(i, iArr, this.f4699x.modSquare(i, iArr));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return squarePlusProduct(eCFieldElement, eCFieldElement2);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            LongArray longArray = this.f4699x;
            LongArray longArray2 = ((F2m) eCFieldElement).f4699x;
            LongArray longArray3 = ((F2m) eCFieldElement2).f4699x;
            LongArray longArraySquare = longArray.square(this.f4698m, this.f4697ks);
            LongArray longArrayMultiply = longArray2.multiply(longArray3, this.f4698m, this.f4697ks);
            if (longArraySquare == longArray) {
                longArraySquare = (LongArray) longArraySquare.clone();
            }
            longArraySquare.addShiftedByWords(longArrayMultiply, 0);
            longArraySquare.reduce(this.f4698m, this.f4697ks);
            return new F2m(this.f4698m, this.f4697ks, longArraySquare);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement squarePow(int i) {
            if (i < 1) {
                return this;
            }
            int i2 = this.f4698m;
            int[] iArr = this.f4697ks;
            return new F2m(i2, iArr, this.f4699x.modSquareN(i, i2, iArr));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public boolean testBitZero() {
            return this.f4699x.testBitZero();
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f4699x.toBigInteger();
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.math.ec.ECFieldElement$Fp */
    public static class C7836Fp extends AbstractFp {

        /* JADX INFO: renamed from: q */
        BigInteger f4700q;

        /* JADX INFO: renamed from: r */
        BigInteger f4701r;

        /* JADX INFO: renamed from: x */
        BigInteger f4702x;

        public C7836Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, calculateResidue(bigInteger), bigInteger2);
        }

        C7836Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f4700q = bigInteger;
            this.f4701r = bigInteger2;
            this.f4702x = bigInteger3;
        }

        static BigInteger calculateResidue(BigInteger bigInteger) {
            int iBitLength = bigInteger.bitLength();
            if (iBitLength < 96 || bigInteger.shiftRight(iBitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.ONE.shiftLeft(iBitLength).subtract(bigInteger);
        }

        private ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
            if (eCFieldElement.square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        private BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int iBitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigIntegerModMult = ECConstants.ONE;
            BigInteger bigIntegerModReduce = bigInteger;
            BigInteger bigIntegerModMult2 = bigIntegerModMult;
            BigInteger bigIntegerModReduce2 = ECConstants.TWO;
            BigInteger bigIntegerModMult3 = bigIntegerModMult2;
            for (int i = iBitLength - 1; i >= lowestSetBit + 1; i--) {
                bigIntegerModMult = modMult(bigIntegerModMult, bigIntegerModMult3);
                if (bigInteger3.testBit(i)) {
                    bigIntegerModMult3 = modMult(bigIntegerModMult, bigInteger2);
                    bigIntegerModMult2 = modMult(bigIntegerModMult2, bigIntegerModReduce);
                    bigIntegerModReduce2 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerModMult)));
                    bigIntegerModReduce = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce).subtract(bigIntegerModMult3.shiftLeft(1)));
                } else {
                    BigInteger bigIntegerModReduce3 = modReduce(bigIntegerModMult2.multiply(bigIntegerModReduce2).subtract(bigIntegerModMult));
                    BigInteger bigIntegerModReduce4 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerModMult)));
                    bigIntegerModReduce2 = modReduce(bigIntegerModReduce2.multiply(bigIntegerModReduce2).subtract(bigIntegerModMult.shiftLeft(1)));
                    bigIntegerModReduce = bigIntegerModReduce4;
                    bigIntegerModMult2 = bigIntegerModReduce3;
                    bigIntegerModMult3 = bigIntegerModMult;
                }
            }
            BigInteger bigIntegerModMult4 = modMult(bigIntegerModMult, bigIntegerModMult3);
            BigInteger bigIntegerModMult5 = modMult(bigIntegerModMult4, bigInteger2);
            BigInteger bigIntegerModReduce5 = modReduce(bigIntegerModMult2.multiply(bigIntegerModReduce2).subtract(bigIntegerModMult4));
            BigInteger bigIntegerModReduce6 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerModMult4)));
            BigInteger bigIntegerModMult6 = modMult(bigIntegerModMult4, bigIntegerModMult5);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                bigIntegerModReduce5 = modMult(bigIntegerModReduce5, bigIntegerModReduce6);
                bigIntegerModReduce6 = modReduce(bigIntegerModReduce6.multiply(bigIntegerModReduce6).subtract(bigIntegerModMult6.shiftLeft(1)));
                bigIntegerModMult6 = modMult(bigIntegerModMult6, bigIntegerModMult6);
            }
            return new BigInteger[]{bigIntegerModReduce5, bigIntegerModReduce6};
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new C7836Fp(this.f4700q, this.f4701r, modAdd(this.f4702x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger bigIntegerAdd = this.f4702x.add(ECConstants.ONE);
            if (bigIntegerAdd.compareTo(this.f4700q) == 0) {
                bigIntegerAdd = ECConstants.ZERO;
            }
            return new C7836Fp(this.f4700q, this.f4701r, bigIntegerAdd);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new C7836Fp(this.f4700q, this.f4701r, modMult(this.f4702x, modInverse(eCFieldElement.toBigInteger())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C7836Fp)) {
                return false;
            }
            C7836Fp c7836Fp = (C7836Fp) obj;
            return this.f4700q.equals(c7836Fp.f4700q) && this.f4702x.equals(c7836Fp.f4702x);
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public int getFieldSize() {
            return this.f4700q.bitLength();
        }

        public BigInteger getQ() {
            return this.f4700q;
        }

        public int hashCode() {
            return this.f4702x.hashCode() ^ this.f4700q.hashCode();
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement invert() {
            return new C7836Fp(this.f4700q, this.f4701r, modInverse(this.f4702x));
        }

        protected BigInteger modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
            return bigIntegerAdd.compareTo(this.f4700q) >= 0 ? bigIntegerAdd.subtract(this.f4700q) : bigIntegerAdd;
        }

        protected BigInteger modDouble(BigInteger bigInteger) {
            BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(1);
            return bigIntegerShiftLeft.compareTo(this.f4700q) >= 0 ? bigIntegerShiftLeft.subtract(this.f4700q) : bigIntegerShiftLeft;
        }

        protected BigInteger modHalf(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f4700q.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        protected BigInteger modHalfAbs(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f4700q.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        protected BigInteger modInverse(BigInteger bigInteger) {
            return BigIntegers.modOddInverse(this.f4700q, bigInteger);
        }

        protected BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        protected BigInteger modReduce(BigInteger bigInteger) {
            if (this.f4701r == null) {
                return bigInteger.mod(this.f4700q);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int iBitLength = this.f4700q.bitLength();
            boolean zEquals = this.f4701r.equals(ECConstants.ONE);
            while (bigInteger.bitLength() > iBitLength + 1) {
                BigInteger bigIntegerShiftRight = bigInteger.shiftRight(iBitLength);
                BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftRight.shiftLeft(iBitLength));
                if (!zEquals) {
                    bigIntegerShiftRight = bigIntegerShiftRight.multiply(this.f4701r);
                }
                bigInteger = bigIntegerShiftRight.add(bigIntegerSubtract);
            }
            while (bigInteger.compareTo(this.f4700q) >= 0) {
                bigInteger = bigInteger.subtract(this.f4700q);
            }
            return (!z || bigInteger.signum() == 0) ? bigInteger : this.f4700q.subtract(bigInteger);
        }

        protected BigInteger modSubtract(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
            return bigIntegerSubtract.signum() < 0 ? bigIntegerSubtract.add(this.f4700q) : bigIntegerSubtract;
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new C7836Fp(this.f4700q, this.f4701r, modMult(this.f4702x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f4702x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new C7836Fp(this.f4700q, this.f4701r, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f4702x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new C7836Fp(this.f4700q, this.f4701r, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement negate() {
            if (this.f4702x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f4700q;
            return new C7836Fp(bigInteger, this.f4701r, bigInteger.subtract(this.f4702x));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (isZero() || isOne()) {
                return this;
            }
            if (!this.f4700q.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.f4700q.testBit(1)) {
                BigInteger bigIntegerAdd = this.f4700q.shiftRight(2).add(ECConstants.ONE);
                BigInteger bigInteger = this.f4700q;
                return checkSqrt(new C7836Fp(bigInteger, this.f4701r, this.f4702x.modPow(bigIntegerAdd, bigInteger)));
            }
            if (this.f4700q.testBit(2)) {
                BigInteger bigIntegerModPow = this.f4702x.modPow(this.f4700q.shiftRight(3), this.f4700q);
                BigInteger bigIntegerModMult = modMult(bigIntegerModPow, this.f4702x);
                if (modMult(bigIntegerModMult, bigIntegerModPow).equals(ECConstants.ONE)) {
                    return checkSqrt(new C7836Fp(this.f4700q, this.f4701r, bigIntegerModMult));
                }
                return checkSqrt(new C7836Fp(this.f4700q, this.f4701r, modMult(bigIntegerModMult, ECConstants.TWO.modPow(this.f4700q.shiftRight(2), this.f4700q))));
            }
            BigInteger bigIntegerShiftRight = this.f4700q.shiftRight(1);
            BigInteger bigIntegerModPow2 = this.f4702x.modPow(bigIntegerShiftRight, this.f4700q);
            BigInteger bigInteger2 = ECConstants.ONE;
            if (!bigIntegerModPow2.equals(bigInteger2)) {
                return null;
            }
            BigInteger bigInteger3 = this.f4702x;
            BigInteger bigIntegerModDouble = modDouble(modDouble(bigInteger3));
            BigInteger bigIntegerAdd2 = bigIntegerShiftRight.add(bigInteger2);
            BigInteger bigIntegerSubtract = this.f4700q.subtract(bigInteger2);
            Random random = new Random();
            while (true) {
                BigInteger bigInteger4 = new BigInteger(this.f4700q.bitLength(), random);
                if (bigInteger4.compareTo(this.f4700q) < 0 && modReduce(bigInteger4.multiply(bigInteger4).subtract(bigIntegerModDouble)).modPow(bigIntegerShiftRight, this.f4700q).equals(bigIntegerSubtract)) {
                    BigInteger[] bigIntegerArrLucasSequence = lucasSequence(bigInteger4, bigInteger3, bigIntegerAdd2);
                    BigInteger bigInteger5 = bigIntegerArrLucasSequence[0];
                    BigInteger bigInteger6 = bigIntegerArrLucasSequence[1];
                    if (modMult(bigInteger6, bigInteger6).equals(bigIntegerModDouble)) {
                        return new C7836Fp(this.f4700q, this.f4701r, modHalfAbs(bigInteger6));
                    }
                    if (!bigInteger5.equals(ECConstants.ONE) && !bigInteger5.equals(bigIntegerSubtract)) {
                        return null;
                    }
                }
            }
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.f4700q;
            BigInteger bigInteger2 = this.f4701r;
            BigInteger bigInteger3 = this.f4702x;
            return new C7836Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f4702x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new C7836Fp(this.f4700q, this.f4701r, modReduce(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f4702x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new C7836Fp(this.f4700q, this.f4701r, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new C7836Fp(this.f4700q, this.f4701r, modSubtract(this.f4702x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.math.p183ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f4702x;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().subtract(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().add(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePow(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this = this.square();
        }
        return this;
    }

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
