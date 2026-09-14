package org.bouncycastle.math.p183ec.custom.sec;

import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.p183ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

/* JADX INFO: loaded from: classes6.dex */
public class SecP192K1Point extends ECPoint.AbstractFp {
    SecP192K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    SecP192K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint add(ECPoint eCPoint) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        if (this == eCPoint) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecP192K1FieldElement secP192K1FieldElement = (SecP192K1FieldElement) this.f4703x;
        SecP192K1FieldElement secP192K1FieldElement2 = (SecP192K1FieldElement) this.f4704y;
        SecP192K1FieldElement secP192K1FieldElement3 = (SecP192K1FieldElement) eCPoint.getXCoord();
        SecP192K1FieldElement secP192K1FieldElement4 = (SecP192K1FieldElement) eCPoint.getYCoord();
        SecP192K1FieldElement secP192K1FieldElement5 = (SecP192K1FieldElement) this.f4705zs[0];
        SecP192K1FieldElement secP192K1FieldElement6 = (SecP192K1FieldElement) eCPoint.getZCoord(0);
        int[] iArrCreateExt = Nat192.createExt();
        int[] iArrCreate = Nat192.create();
        int[] iArrCreate2 = Nat192.create();
        int[] iArrCreate3 = Nat192.create();
        boolean zIsOne = secP192K1FieldElement5.isOne();
        if (zIsOne) {
            iArr = secP192K1FieldElement3.f4732x;
            iArr2 = secP192K1FieldElement4.f4732x;
        } else {
            SecP192K1Field.square(secP192K1FieldElement5.f4732x, iArrCreate2);
            SecP192K1Field.multiply(iArrCreate2, secP192K1FieldElement3.f4732x, iArrCreate);
            SecP192K1Field.multiply(iArrCreate2, secP192K1FieldElement5.f4732x, iArrCreate2);
            SecP192K1Field.multiply(iArrCreate2, secP192K1FieldElement4.f4732x, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = secP192K1FieldElement6.isOne();
        if (zIsOne2) {
            iArr3 = secP192K1FieldElement.f4732x;
            iArr4 = secP192K1FieldElement2.f4732x;
        } else {
            SecP192K1Field.square(secP192K1FieldElement6.f4732x, iArrCreate3);
            SecP192K1Field.multiply(iArrCreate3, secP192K1FieldElement.f4732x, iArrCreateExt);
            SecP192K1Field.multiply(iArrCreate3, secP192K1FieldElement6.f4732x, iArrCreate3);
            SecP192K1Field.multiply(iArrCreate3, secP192K1FieldElement2.f4732x, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = Nat192.create();
        SecP192K1Field.subtract(iArr3, iArr, iArrCreate4);
        SecP192K1Field.subtract(iArr4, iArr2, iArrCreate);
        if (Nat192.isZero(iArrCreate4)) {
            return Nat192.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        SecP192K1Field.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = Nat192.create();
        SecP192K1Field.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        SecP192K1Field.multiply(iArrCreate2, iArr3, iArrCreate2);
        SecP192K1Field.negate(iArrCreate5, iArrCreate5);
        Nat192.mul(iArr4, iArrCreate5, iArrCreateExt);
        SecP192K1Field.reduce32(Nat192.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        SecP192K1FieldElement secP192K1FieldElement7 = new SecP192K1FieldElement(iArrCreate3);
        SecP192K1Field.square(iArrCreate, secP192K1FieldElement7.f4732x);
        int[] iArr5 = secP192K1FieldElement7.f4732x;
        SecP192K1Field.subtract(iArr5, iArrCreate5, iArr5);
        SecP192K1FieldElement secP192K1FieldElement8 = new SecP192K1FieldElement(iArrCreate5);
        SecP192K1Field.subtract(iArrCreate2, secP192K1FieldElement7.f4732x, secP192K1FieldElement8.f4732x);
        SecP192K1Field.multiplyAddToExt(secP192K1FieldElement8.f4732x, iArrCreate, iArrCreateExt);
        SecP192K1Field.reduce(iArrCreateExt, secP192K1FieldElement8.f4732x);
        SecP192K1FieldElement secP192K1FieldElement9 = new SecP192K1FieldElement(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = secP192K1FieldElement9.f4732x;
            SecP192K1Field.multiply(iArr6, secP192K1FieldElement5.f4732x, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = secP192K1FieldElement9.f4732x;
            SecP192K1Field.multiply(iArr7, secP192K1FieldElement6.f4732x, iArr7);
        }
        return new SecP192K1Point(curve, secP192K1FieldElement7, secP192K1FieldElement8, new ECFieldElement[]{secP192K1FieldElement9});
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    protected ECPoint detach() {
        return new SecP192K1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint negate() {
        return isInfinity() ? this : new SecP192K1Point(this.curve, this.f4703x, this.f4704y.negate(), this.f4705zs);
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint threeTimes() {
        return (isInfinity() || this.f4704y.isZero()) ? this : twice().add(this);
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP192K1FieldElement secP192K1FieldElement = (SecP192K1FieldElement) this.f4704y;
        if (secP192K1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP192K1FieldElement secP192K1FieldElement2 = (SecP192K1FieldElement) this.f4703x;
        SecP192K1FieldElement secP192K1FieldElement3 = (SecP192K1FieldElement) this.f4705zs[0];
        int[] iArrCreate = Nat192.create();
        SecP192K1Field.square(secP192K1FieldElement.f4732x, iArrCreate);
        int[] iArrCreate2 = Nat192.create();
        SecP192K1Field.square(iArrCreate, iArrCreate2);
        int[] iArrCreate3 = Nat192.create();
        SecP192K1Field.square(secP192K1FieldElement2.f4732x, iArrCreate3);
        SecP192K1Field.reduce32(Nat192.addBothTo(iArrCreate3, iArrCreate3, iArrCreate3), iArrCreate3);
        SecP192K1Field.multiply(iArrCreate, secP192K1FieldElement2.f4732x, iArrCreate);
        SecP192K1Field.reduce32(Nat.shiftUpBits(6, iArrCreate, 2, 0), iArrCreate);
        int[] iArrCreate4 = Nat192.create();
        SecP192K1Field.reduce32(Nat.shiftUpBits(6, iArrCreate2, 3, 0, iArrCreate4), iArrCreate4);
        SecP192K1FieldElement secP192K1FieldElement4 = new SecP192K1FieldElement(iArrCreate2);
        SecP192K1Field.square(iArrCreate3, secP192K1FieldElement4.f4732x);
        int[] iArr = secP192K1FieldElement4.f4732x;
        SecP192K1Field.subtract(iArr, iArrCreate, iArr);
        int[] iArr2 = secP192K1FieldElement4.f4732x;
        SecP192K1Field.subtract(iArr2, iArrCreate, iArr2);
        SecP192K1FieldElement secP192K1FieldElement5 = new SecP192K1FieldElement(iArrCreate);
        SecP192K1Field.subtract(iArrCreate, secP192K1FieldElement4.f4732x, secP192K1FieldElement5.f4732x);
        int[] iArr3 = secP192K1FieldElement5.f4732x;
        SecP192K1Field.multiply(iArr3, iArrCreate3, iArr3);
        int[] iArr4 = secP192K1FieldElement5.f4732x;
        SecP192K1Field.subtract(iArr4, iArrCreate4, iArr4);
        SecP192K1FieldElement secP192K1FieldElement6 = new SecP192K1FieldElement(iArrCreate3);
        SecP192K1Field.twice(secP192K1FieldElement.f4732x, secP192K1FieldElement6.f4732x);
        if (!secP192K1FieldElement3.isOne()) {
            int[] iArr5 = secP192K1FieldElement6.f4732x;
            SecP192K1Field.multiply(iArr5, secP192K1FieldElement3.f4732x, iArr5);
        }
        return new SecP192K1Point(curve, secP192K1FieldElement4, secP192K1FieldElement5, new ECFieldElement[]{secP192K1FieldElement6});
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint twicePlus(ECPoint eCPoint) {
        if (this == eCPoint) {
            return threeTimes();
        }
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        return this.f4704y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}
