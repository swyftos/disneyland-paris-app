package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat160;

/* loaded from: classes6.dex */
public class SecP160R1Point extends ECPoint.AbstractFp {
    SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
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
        SecP160R1FieldElement secP160R1FieldElement = (SecP160R1FieldElement) this.x;
        SecP160R1FieldElement secP160R1FieldElement2 = (SecP160R1FieldElement) this.y;
        SecP160R1FieldElement secP160R1FieldElement3 = (SecP160R1FieldElement) eCPoint.getXCoord();
        SecP160R1FieldElement secP160R1FieldElement4 = (SecP160R1FieldElement) eCPoint.getYCoord();
        SecP160R1FieldElement secP160R1FieldElement5 = (SecP160R1FieldElement) this.zs[0];
        SecP160R1FieldElement secP160R1FieldElement6 = (SecP160R1FieldElement) eCPoint.getZCoord(0);
        int[] iArrCreateExt = Nat160.createExt();
        int[] iArrCreate = Nat160.create();
        int[] iArrCreate2 = Nat160.create();
        int[] iArrCreate3 = Nat160.create();
        boolean zIsOne = secP160R1FieldElement5.isOne();
        if (zIsOne) {
            iArr = secP160R1FieldElement3.x;
            iArr2 = secP160R1FieldElement4.x;
        } else {
            SecP160R1Field.square(secP160R1FieldElement5.x, iArrCreate2);
            SecP160R1Field.multiply(iArrCreate2, secP160R1FieldElement3.x, iArrCreate);
            SecP160R1Field.multiply(iArrCreate2, secP160R1FieldElement5.x, iArrCreate2);
            SecP160R1Field.multiply(iArrCreate2, secP160R1FieldElement4.x, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = secP160R1FieldElement6.isOne();
        if (zIsOne2) {
            iArr3 = secP160R1FieldElement.x;
            iArr4 = secP160R1FieldElement2.x;
        } else {
            SecP160R1Field.square(secP160R1FieldElement6.x, iArrCreate3);
            SecP160R1Field.multiply(iArrCreate3, secP160R1FieldElement.x, iArrCreateExt);
            SecP160R1Field.multiply(iArrCreate3, secP160R1FieldElement6.x, iArrCreate3);
            SecP160R1Field.multiply(iArrCreate3, secP160R1FieldElement2.x, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = Nat160.create();
        SecP160R1Field.subtract(iArr3, iArr, iArrCreate4);
        SecP160R1Field.subtract(iArr4, iArr2, iArrCreate);
        if (Nat160.isZero(iArrCreate4)) {
            return Nat160.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        SecP160R1Field.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = Nat160.create();
        SecP160R1Field.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        SecP160R1Field.multiply(iArrCreate2, iArr3, iArrCreate2);
        SecP160R1Field.negate(iArrCreate5, iArrCreate5);
        Nat160.mul(iArr4, iArrCreate5, iArrCreateExt);
        SecP160R1Field.reduce32(Nat160.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        SecP160R1FieldElement secP160R1FieldElement7 = new SecP160R1FieldElement(iArrCreate3);
        SecP160R1Field.square(iArrCreate, secP160R1FieldElement7.x);
        int[] iArr5 = secP160R1FieldElement7.x;
        SecP160R1Field.subtract(iArr5, iArrCreate5, iArr5);
        SecP160R1FieldElement secP160R1FieldElement8 = new SecP160R1FieldElement(iArrCreate5);
        SecP160R1Field.subtract(iArrCreate2, secP160R1FieldElement7.x, secP160R1FieldElement8.x);
        SecP160R1Field.multiplyAddToExt(secP160R1FieldElement8.x, iArrCreate, iArrCreateExt);
        SecP160R1Field.reduce(iArrCreateExt, secP160R1FieldElement8.x);
        SecP160R1FieldElement secP160R1FieldElement9 = new SecP160R1FieldElement(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = secP160R1FieldElement9.x;
            SecP160R1Field.multiply(iArr6, secP160R1FieldElement5.x, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = secP160R1FieldElement9.x;
            SecP160R1Field.multiply(iArr7, secP160R1FieldElement6.x, iArr7);
        }
        return new SecP160R1Point(curve, secP160R1FieldElement7, secP160R1FieldElement8, new ECFieldElement[]{secP160R1FieldElement9});
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    protected ECPoint detach() {
        return new SecP160R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        return isInfinity() ? this : new SecP160R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint threeTimes() {
        return (isInfinity() || this.y.isZero()) ? this : twice().add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP160R1FieldElement secP160R1FieldElement = (SecP160R1FieldElement) this.y;
        if (secP160R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP160R1FieldElement secP160R1FieldElement2 = (SecP160R1FieldElement) this.x;
        SecP160R1FieldElement secP160R1FieldElement3 = (SecP160R1FieldElement) this.zs[0];
        int[] iArrCreate = Nat160.create();
        int[] iArrCreate2 = Nat160.create();
        int[] iArrCreate3 = Nat160.create();
        SecP160R1Field.square(secP160R1FieldElement.x, iArrCreate3);
        int[] iArrCreate4 = Nat160.create();
        SecP160R1Field.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = secP160R1FieldElement3.isOne();
        int[] iArr = secP160R1FieldElement3.x;
        if (!zIsOne) {
            SecP160R1Field.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        SecP160R1Field.subtract(secP160R1FieldElement2.x, iArr, iArrCreate);
        SecP160R1Field.add(secP160R1FieldElement2.x, iArr, iArrCreate2);
        SecP160R1Field.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        SecP160R1Field.reduce32(Nat160.addBothTo(iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        SecP160R1Field.multiply(iArrCreate3, secP160R1FieldElement2.x, iArrCreate3);
        SecP160R1Field.reduce32(Nat.shiftUpBits(5, iArrCreate3, 2, 0), iArrCreate3);
        SecP160R1Field.reduce32(Nat.shiftUpBits(5, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        SecP160R1FieldElement secP160R1FieldElement4 = new SecP160R1FieldElement(iArrCreate4);
        SecP160R1Field.square(iArrCreate2, secP160R1FieldElement4.x);
        int[] iArr2 = secP160R1FieldElement4.x;
        SecP160R1Field.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = secP160R1FieldElement4.x;
        SecP160R1Field.subtract(iArr3, iArrCreate3, iArr3);
        SecP160R1FieldElement secP160R1FieldElement5 = new SecP160R1FieldElement(iArrCreate3);
        SecP160R1Field.subtract(iArrCreate3, secP160R1FieldElement4.x, secP160R1FieldElement5.x);
        int[] iArr4 = secP160R1FieldElement5.x;
        SecP160R1Field.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = secP160R1FieldElement5.x;
        SecP160R1Field.subtract(iArr5, iArrCreate, iArr5);
        SecP160R1FieldElement secP160R1FieldElement6 = new SecP160R1FieldElement(iArrCreate2);
        SecP160R1Field.twice(secP160R1FieldElement.x, secP160R1FieldElement6.x);
        if (!zIsOne) {
            int[] iArr6 = secP160R1FieldElement6.x;
            SecP160R1Field.multiply(iArr6, secP160R1FieldElement3.x, iArr6);
        }
        return new SecP160R1Point(curve, secP160R1FieldElement4, secP160R1FieldElement5, new ECFieldElement[]{secP160R1FieldElement6});
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}
