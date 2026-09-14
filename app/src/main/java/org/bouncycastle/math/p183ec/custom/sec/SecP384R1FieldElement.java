package org.bouncycastle.math.p183ec.custom.sec;

import ch.qos.logback.core.net.SyslogConstants;
import java.math.BigInteger;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes6.dex */
public class SecP384R1FieldElement extends ECFieldElement.AbstractFp {

    /* JADX INFO: renamed from: Q */
    public static final BigInteger f4755Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* JADX INFO: renamed from: x */
    protected int[] f4756x;

    public SecP384R1FieldElement() {
        this.f4756x = Nat.create(12);
    }

    public SecP384R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f4755Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f4756x = SecP384R1Field.fromBigInteger(bigInteger);
    }

    protected SecP384R1FieldElement(int[] iArr) {
        this.f4756x = iArr;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.add(this.f4756x, ((SecP384R1FieldElement) eCFieldElement).f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.addOne(this.f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.inv(((SecP384R1FieldElement) eCFieldElement).f4756x, iArrCreate);
        SecP384R1Field.multiply(iArrCreate, this.f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP384R1FieldElement) {
            return Nat.m2099eq(12, this.f4756x, ((SecP384R1FieldElement) obj).f4756x);
        }
        return false;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public String getFieldName() {
        return "SecP384R1Field";
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public int getFieldSize() {
        return f4755Q.bitLength();
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4756x, 0, 12) ^ f4755Q.hashCode();
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement invert() {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.inv(this.f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(12, this.f4756x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(12, this.f4756x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.multiply(this.f4756x, ((SecP384R1FieldElement) eCFieldElement).f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement negate() {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.negate(this.f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] iArr = this.f4756x;
        if (Nat.isZero(12, iArr) || Nat.isOne(12, iArr)) {
            return this;
        }
        int[] iArrCreate = Nat.create(12);
        int[] iArrCreate2 = Nat.create(12);
        int[] iArrCreate3 = Nat.create(12);
        int[] iArrCreate4 = Nat.create(12);
        SecP384R1Field.square(iArr, iArrCreate);
        SecP384R1Field.multiply(iArrCreate, iArr, iArrCreate);
        SecP384R1Field.squareN(iArrCreate, 2, iArrCreate2);
        SecP384R1Field.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        SecP384R1Field.square(iArrCreate2, iArrCreate2);
        SecP384R1Field.multiply(iArrCreate2, iArr, iArrCreate2);
        SecP384R1Field.squareN(iArrCreate2, 5, iArrCreate3);
        SecP384R1Field.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        SecP384R1Field.squareN(iArrCreate3, 5, iArrCreate4);
        SecP384R1Field.multiply(iArrCreate4, iArrCreate2, iArrCreate4);
        SecP384R1Field.squareN(iArrCreate4, 15, iArrCreate2);
        SecP384R1Field.multiply(iArrCreate2, iArrCreate4, iArrCreate2);
        SecP384R1Field.squareN(iArrCreate2, 2, iArrCreate3);
        SecP384R1Field.multiply(iArrCreate, iArrCreate3, iArrCreate);
        SecP384R1Field.squareN(iArrCreate3, 28, iArrCreate3);
        SecP384R1Field.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        SecP384R1Field.squareN(iArrCreate2, 60, iArrCreate3);
        SecP384R1Field.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        SecP384R1Field.squareN(iArrCreate3, SyslogConstants.LOG_CLOCK, iArrCreate2);
        SecP384R1Field.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        SecP384R1Field.squareN(iArrCreate2, 15, iArrCreate2);
        SecP384R1Field.multiply(iArrCreate2, iArrCreate4, iArrCreate2);
        SecP384R1Field.squareN(iArrCreate2, 33, iArrCreate2);
        SecP384R1Field.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        SecP384R1Field.squareN(iArrCreate2, 64, iArrCreate2);
        SecP384R1Field.multiply(iArrCreate2, iArr, iArrCreate2);
        SecP384R1Field.squareN(iArrCreate2, 30, iArrCreate);
        SecP384R1Field.square(iArrCreate, iArrCreate2);
        if (Nat.m2099eq(12, iArr, iArrCreate2)) {
            return new SecP384R1FieldElement(iArrCreate);
        }
        return null;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement square() {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.square(this.f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrCreate = Nat.create(12);
        SecP384R1Field.subtract(this.f4756x, ((SecP384R1FieldElement) eCFieldElement).f4756x, iArrCreate);
        return new SecP384R1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean testBitZero() {
        return Nat.getBit(this.f4756x, 0) == 1;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat.toBigInteger(12, this.f4756x);
    }
}
