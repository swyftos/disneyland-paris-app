package org.bouncycastle.math.p183ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes6.dex */
public class SecP224K1FieldElement extends ECFieldElement.AbstractFp {

    /* JADX INFO: renamed from: x */
    protected int[] f4740x;

    /* JADX INFO: renamed from: Q */
    public static final BigInteger f4739Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
    private static final int[] PRECOMP_POW2 = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    public SecP224K1FieldElement() {
        this.f4740x = Nat224.create();
    }

    public SecP224K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f4739Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f4740x = SecP224K1Field.fromBigInteger(bigInteger);
    }

    protected SecP224K1FieldElement(int[] iArr) {
        this.f4740x = iArr;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.add(this.f4740x, ((SecP224K1FieldElement) eCFieldElement).f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.addOne(this.f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.inv(((SecP224K1FieldElement) eCFieldElement).f4740x, iArrCreate);
        SecP224K1Field.multiply(iArrCreate, this.f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP224K1FieldElement) {
            return Nat224.m2103eq(this.f4740x, ((SecP224K1FieldElement) obj).f4740x);
        }
        return false;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public String getFieldName() {
        return "SecP224K1Field";
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public int getFieldSize() {
        return f4739Q.bitLength();
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4740x, 0, 7) ^ f4739Q.hashCode();
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement invert() {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.inv(this.f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isOne() {
        return Nat224.isOne(this.f4740x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isZero() {
        return Nat224.isZero(this.f4740x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.multiply(this.f4740x, ((SecP224K1FieldElement) eCFieldElement).f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement negate() {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.negate(this.f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] iArr = this.f4740x;
        if (Nat224.isZero(iArr) || Nat224.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.square(iArr, iArrCreate);
        SecP224K1Field.multiply(iArrCreate, iArr, iArrCreate);
        SecP224K1Field.square(iArrCreate, iArrCreate);
        SecP224K1Field.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = Nat224.create();
        SecP224K1Field.square(iArrCreate, iArrCreate2);
        SecP224K1Field.multiply(iArrCreate2, iArr, iArrCreate2);
        int[] iArrCreate3 = Nat224.create();
        SecP224K1Field.squareN(iArrCreate2, 4, iArrCreate3);
        SecP224K1Field.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        int[] iArrCreate4 = Nat224.create();
        SecP224K1Field.squareN(iArrCreate3, 3, iArrCreate4);
        SecP224K1Field.multiply(iArrCreate4, iArrCreate, iArrCreate4);
        SecP224K1Field.squareN(iArrCreate4, 8, iArrCreate4);
        SecP224K1Field.multiply(iArrCreate4, iArrCreate3, iArrCreate4);
        SecP224K1Field.squareN(iArrCreate4, 4, iArrCreate3);
        SecP224K1Field.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        SecP224K1Field.squareN(iArrCreate3, 19, iArrCreate2);
        SecP224K1Field.multiply(iArrCreate2, iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = Nat224.create();
        SecP224K1Field.squareN(iArrCreate2, 42, iArrCreate5);
        SecP224K1Field.multiply(iArrCreate5, iArrCreate2, iArrCreate5);
        SecP224K1Field.squareN(iArrCreate5, 23, iArrCreate2);
        SecP224K1Field.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        SecP224K1Field.squareN(iArrCreate2, 84, iArrCreate3);
        SecP224K1Field.multiply(iArrCreate3, iArrCreate5, iArrCreate3);
        SecP224K1Field.squareN(iArrCreate3, 20, iArrCreate3);
        SecP224K1Field.multiply(iArrCreate3, iArrCreate4, iArrCreate3);
        SecP224K1Field.squareN(iArrCreate3, 3, iArrCreate3);
        SecP224K1Field.multiply(iArrCreate3, iArr, iArrCreate3);
        SecP224K1Field.squareN(iArrCreate3, 2, iArrCreate3);
        SecP224K1Field.multiply(iArrCreate3, iArr, iArrCreate3);
        SecP224K1Field.squareN(iArrCreate3, 4, iArrCreate3);
        SecP224K1Field.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        SecP224K1Field.square(iArrCreate3, iArrCreate3);
        SecP224K1Field.square(iArrCreate3, iArrCreate5);
        if (Nat224.m2103eq(iArr, iArrCreate5)) {
            return new SecP224K1FieldElement(iArrCreate3);
        }
        SecP224K1Field.multiply(iArrCreate3, PRECOMP_POW2, iArrCreate3);
        SecP224K1Field.square(iArrCreate3, iArrCreate5);
        if (Nat224.m2103eq(iArr, iArrCreate5)) {
            return new SecP224K1FieldElement(iArrCreate3);
        }
        return null;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement square() {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.square(this.f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat224.create();
        SecP224K1Field.subtract(this.f4740x, ((SecP224K1FieldElement) eCFieldElement).f4740x, iArrCreate);
        return new SecP224K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean testBitZero() {
        return Nat224.getBit(this.f4740x, 0) == 1;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.f4740x);
    }
}
