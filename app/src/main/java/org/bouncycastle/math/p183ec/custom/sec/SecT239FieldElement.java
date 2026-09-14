package org.bouncycastle.math.p183ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class SecT239FieldElement extends ECFieldElement.AbstractF2m {

    /* JADX INFO: renamed from: x */
    protected long[] f4766x;

    public SecT239FieldElement() {
        this.f4766x = Nat256.create64();
    }

    public SecT239FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f4766x = SecT239Field.fromBigInteger(bigInteger);
    }

    protected SecT239FieldElement(long[] jArr) {
        this.f4766x = jArr;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.add(this.f4766x, ((SecT239FieldElement) eCFieldElement).f4766x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement addOne() {
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.addOne(this.f4766x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT239FieldElement) {
            return Nat256.eq64(this.f4766x, ((SecT239FieldElement) obj).f4766x);
        }
        return false;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public String getFieldName() {
        return "SecT239Field";
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public int getFieldSize() {
        return 239;
    }

    public int getK1() {
        return 158;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 239;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.halfTrace(this.f4766x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4766x, 0, 4) ^ 23900158;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement invert() {
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.invert(this.f4766x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne64(this.f4766x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero64(this.f4766x);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.multiply(this.f4766x, ((SecT239FieldElement) eCFieldElement).f4766x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f4766x;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement).f4766x;
        long[] jArr3 = ((SecT239FieldElement) eCFieldElement2).f4766x;
        long[] jArr4 = ((SecT239FieldElement) eCFieldElement3).f4766x;
        long[] jArrCreateExt64 = Nat256.createExt64();
        SecT239Field.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        SecT239Field.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.reduce(jArrCreateExt64, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement negate() {
        return this;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement sqrt() {
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.sqrt(this.f4766x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement square() {
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.square(this.f4766x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f4766x;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement).f4766x;
        long[] jArr3 = ((SecT239FieldElement) eCFieldElement2).f4766x;
        long[] jArrCreateExt64 = Nat256.createExt64();
        SecT239Field.squareAddToExt(jArr, jArrCreateExt64);
        SecT239Field.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.reduce(jArrCreateExt64, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = Nat256.create64();
        SecT239Field.squareN(this.f4766x, i, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return add(eCFieldElement);
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f4766x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.math.p183ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger64(this.f4766x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public int trace() {
        return SecT239Field.trace(this.f4766x);
    }
}
