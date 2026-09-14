package org.bouncycastle.math.p183ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes6.dex */
public class SecP192R1FieldElement extends ECFieldElement.AbstractFp {

    /* JADX INFO: renamed from: Q */
    public static final BigInteger f4735Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: x */
    protected int[] f4736x;

    public SecP192R1FieldElement() {
        this.f4736x = Nat192.create();
    }

    public SecP192R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f4735Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f4736x = SecP192R1Field.fromBigInteger(bigInteger);
    }

    protected SecP192R1FieldElement(int[] iArr) {
        this.f4736x = iArr;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.add(this.f4736x, ((SecP192R1FieldElement) eCFieldElement).f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.addOne(this.f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.inv(((SecP192R1FieldElement) eCFieldElement).f4736x, iArrCreate);
        SecP192R1Field.multiply(iArrCreate, this.f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP192R1FieldElement) {
            return Nat192.m2102eq(this.f4736x, ((SecP192R1FieldElement) obj).f4736x);
        }
        return false;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public String getFieldName() {
        return "SecP192R1Field";
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public int getFieldSize() {
        return f4735Q.bitLength();
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4736x, 0, 6) ^ f4735Q.hashCode();
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement invert() {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.inv(this.f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne(this.f4736x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero(this.f4736x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.multiply(this.f4736x, ((SecP192R1FieldElement) eCFieldElement).f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement negate() {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.negate(this.f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] iArr = this.f4736x;
        if (Nat192.isZero(iArr) || Nat192.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = Nat192.create();
        int[] iArrCreate2 = Nat192.create();
        SecP192R1Field.square(iArr, iArrCreate);
        SecP192R1Field.multiply(iArrCreate, iArr, iArrCreate);
        SecP192R1Field.squareN(iArrCreate, 2, iArrCreate2);
        SecP192R1Field.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        SecP192R1Field.squareN(iArrCreate2, 4, iArrCreate);
        SecP192R1Field.multiply(iArrCreate, iArrCreate2, iArrCreate);
        SecP192R1Field.squareN(iArrCreate, 8, iArrCreate2);
        SecP192R1Field.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        SecP192R1Field.squareN(iArrCreate2, 16, iArrCreate);
        SecP192R1Field.multiply(iArrCreate, iArrCreate2, iArrCreate);
        SecP192R1Field.squareN(iArrCreate, 32, iArrCreate2);
        SecP192R1Field.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        SecP192R1Field.squareN(iArrCreate2, 64, iArrCreate);
        SecP192R1Field.multiply(iArrCreate, iArrCreate2, iArrCreate);
        SecP192R1Field.squareN(iArrCreate, 62, iArrCreate);
        SecP192R1Field.square(iArrCreate, iArrCreate2);
        if (Nat192.m2102eq(iArr, iArrCreate2)) {
            return new SecP192R1FieldElement(iArrCreate);
        }
        return null;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement square() {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.square(this.f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat192.create();
        SecP192R1Field.subtract(this.f4736x, ((SecP192R1FieldElement) eCFieldElement).f4736x, iArrCreate);
        return new SecP192R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean testBitZero() {
        return Nat192.getBit(this.f4736x, 0) == 1;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat192.toBigInteger(this.f4736x);
    }
}
