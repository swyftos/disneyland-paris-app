package org.bouncycastle.math.p183ec.custom.sec;

import org.bouncycastle.math.p183ec.ECConstants;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.p183ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

/* JADX INFO: loaded from: classes6.dex */
public class SecT571R1Point extends ECPoint.AbstractF2m {
    SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint add(ECPoint eCPoint) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        SecT571FieldElement secT571FieldElement;
        SecT571FieldElement secT571FieldElement2;
        SecT571FieldElement secT571FieldElement3;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.f4703x;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) eCPoint.getRawXCoord();
        if (secT571FieldElement4.isZero()) {
            return secT571FieldElement5.isZero() ? curve.getInfinity() : eCPoint.add(this);
        }
        SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) this.f4704y;
        SecT571FieldElement secT571FieldElement7 = (SecT571FieldElement) this.f4705zs[0];
        SecT571FieldElement secT571FieldElement8 = (SecT571FieldElement) eCPoint.getRawYCoord();
        SecT571FieldElement secT571FieldElement9 = (SecT571FieldElement) eCPoint.getZCoord(0);
        long[] jArrCreate64 = Nat576.create64();
        long[] jArrCreate65 = Nat576.create64();
        long[] jArrCreate66 = Nat576.create64();
        long[] jArrCreate67 = Nat576.create64();
        long[] jArrPrecompMultiplicand = secT571FieldElement7.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement7.f4769x);
        if (jArrPrecompMultiplicand == null) {
            jArr = secT571FieldElement5.f4769x;
            jArr2 = secT571FieldElement8.f4769x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement5.f4769x, jArrPrecompMultiplicand, jArrCreate65);
            SecT571Field.multiplyPrecomp(secT571FieldElement8.f4769x, jArrPrecompMultiplicand, jArrCreate67);
            jArr = jArrCreate65;
            jArr2 = jArrCreate67;
        }
        long[] jArrPrecompMultiplicand2 = secT571FieldElement9.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement9.f4769x);
        if (jArrPrecompMultiplicand2 == null) {
            jArr3 = secT571FieldElement4.f4769x;
            jArr4 = secT571FieldElement6.f4769x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement4.f4769x, jArrPrecompMultiplicand2, jArrCreate64);
            SecT571Field.multiplyPrecomp(secT571FieldElement6.f4769x, jArrPrecompMultiplicand2, jArrCreate66);
            jArr3 = jArrCreate64;
            jArr4 = jArrCreate66;
        }
        SecT571Field.add(jArr4, jArr2, jArrCreate66);
        SecT571Field.add(jArr3, jArr, jArrCreate67);
        if (Nat576.isZero64(jArrCreate67)) {
            return Nat576.isZero64(jArrCreate66) ? twice() : curve.getInfinity();
        }
        if (secT571FieldElement5.isZero()) {
            ECPoint eCPointNormalize = normalize();
            SecT571FieldElement secT571FieldElement10 = (SecT571FieldElement) eCPointNormalize.getXCoord();
            ECFieldElement yCoord = eCPointNormalize.getYCoord();
            ECFieldElement eCFieldElementDivide = yCoord.add(secT571FieldElement8).divide(secT571FieldElement10);
            secT571FieldElement = (SecT571FieldElement) eCFieldElementDivide.square().add(eCFieldElementDivide).add(secT571FieldElement10).addOne();
            if (secT571FieldElement.isZero()) {
                return new SecT571R1Point(curve, secT571FieldElement, SecT571R1Curve.SecT571R1_B_SQRT);
            }
            secT571FieldElement2 = (SecT571FieldElement) eCFieldElementDivide.multiply(secT571FieldElement10.add(secT571FieldElement)).add(secT571FieldElement).add(yCoord).divide(secT571FieldElement).add(secT571FieldElement);
            secT571FieldElement3 = (SecT571FieldElement) curve.fromBigInteger(ECConstants.ONE);
        } else {
            SecT571Field.square(jArrCreate67, jArrCreate67);
            long[] jArrPrecompMultiplicand3 = SecT571Field.precompMultiplicand(jArrCreate66);
            SecT571Field.multiplyPrecomp(jArr3, jArrPrecompMultiplicand3, jArrCreate64);
            SecT571Field.multiplyPrecomp(jArr, jArrPrecompMultiplicand3, jArrCreate65);
            secT571FieldElement = new SecT571FieldElement(jArrCreate64);
            SecT571Field.multiply(jArrCreate64, jArrCreate65, secT571FieldElement.f4769x);
            if (secT571FieldElement.isZero()) {
                return new SecT571R1Point(curve, secT571FieldElement, SecT571R1Curve.SecT571R1_B_SQRT);
            }
            SecT571FieldElement secT571FieldElement11 = new SecT571FieldElement(jArrCreate66);
            SecT571Field.multiplyPrecomp(jArrCreate67, jArrPrecompMultiplicand3, secT571FieldElement11.f4769x);
            if (jArrPrecompMultiplicand2 != null) {
                long[] jArr5 = secT571FieldElement11.f4769x;
                SecT571Field.multiplyPrecomp(jArr5, jArrPrecompMultiplicand2, jArr5);
            }
            long[] jArrCreateExt64 = Nat576.createExt64();
            SecT571Field.add(jArrCreate65, jArrCreate67, jArrCreate67);
            SecT571Field.squareAddToExt(jArrCreate67, jArrCreateExt64);
            SecT571Field.add(secT571FieldElement6.f4769x, secT571FieldElement7.f4769x, jArrCreate67);
            SecT571Field.multiplyAddToExt(jArrCreate67, secT571FieldElement11.f4769x, jArrCreateExt64);
            SecT571FieldElement secT571FieldElement12 = new SecT571FieldElement(jArrCreate67);
            SecT571Field.reduce(jArrCreateExt64, secT571FieldElement12.f4769x);
            if (jArrPrecompMultiplicand != null) {
                long[] jArr6 = secT571FieldElement11.f4769x;
                SecT571Field.multiplyPrecomp(jArr6, jArrPrecompMultiplicand, jArr6);
            }
            secT571FieldElement2 = secT571FieldElement12;
            secT571FieldElement3 = secT571FieldElement11;
        }
        return new SecT571R1Point(curve, secT571FieldElement, secT571FieldElement2, new ECFieldElement[]{secT571FieldElement3});
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    protected ECPoint detach() {
        return new SecT571R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    protected boolean getCompressionYTilde() {
        ECFieldElement rawXCoord = getRawXCoord();
        return (rawXCoord.isZero() || getRawYCoord().testBitZero() == rawXCoord.testBitZero()) ? false : true;
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECFieldElement getYCoord() {
        ECFieldElement eCFieldElement = this.f4703x;
        ECFieldElement eCFieldElement2 = this.f4704y;
        if (isInfinity() || eCFieldElement.isZero()) {
            return eCFieldElement2;
        }
        ECFieldElement eCFieldElementMultiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
        ECFieldElement eCFieldElement3 = this.f4705zs[0];
        return !eCFieldElement3.isOne() ? eCFieldElementMultiply.divide(eCFieldElement3) : eCFieldElementMultiply;
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.f4703x;
        if (eCFieldElement.isZero()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.f4704y;
        ECFieldElement eCFieldElement3 = this.f4705zs[0];
        return new SecT571R1Point(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint twice() {
        long[] jArr;
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement) this.f4703x;
        if (secT571FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement) this.f4704y;
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement) this.f4705zs[0];
        long[] jArrCreate64 = Nat576.create64();
        long[] jArrCreate65 = Nat576.create64();
        long[] jArrPrecompMultiplicand = secT571FieldElement3.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement3.f4769x);
        long[] jArr2 = secT571FieldElement2.f4769x;
        if (jArrPrecompMultiplicand == null) {
            jArr = secT571FieldElement3.f4769x;
        } else {
            SecT571Field.multiplyPrecomp(jArr2, jArrPrecompMultiplicand, jArrCreate64);
            SecT571Field.square(secT571FieldElement3.f4769x, jArrCreate65);
            jArr2 = jArrCreate64;
            jArr = jArrCreate65;
        }
        long[] jArrCreate66 = Nat576.create64();
        SecT571Field.square(secT571FieldElement2.f4769x, jArrCreate66);
        SecT571Field.addBothTo(jArr2, jArr, jArrCreate66);
        if (Nat576.isZero64(jArrCreate66)) {
            return new SecT571R1Point(curve, new SecT571FieldElement(jArrCreate66), SecT571R1Curve.SecT571R1_B_SQRT);
        }
        long[] jArrCreateExt64 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(jArrCreate66, jArr2, jArrCreateExt64);
        SecT571FieldElement secT571FieldElement4 = new SecT571FieldElement(jArrCreate64);
        SecT571Field.square(jArrCreate66, secT571FieldElement4.f4769x);
        SecT571FieldElement secT571FieldElement5 = new SecT571FieldElement(jArrCreate66);
        if (jArrPrecompMultiplicand != null) {
            long[] jArr3 = secT571FieldElement5.f4769x;
            SecT571Field.multiply(jArr3, jArr, jArr3);
        }
        long[] jArr4 = secT571FieldElement.f4769x;
        if (jArrPrecompMultiplicand != null) {
            SecT571Field.multiplyPrecomp(jArr4, jArrPrecompMultiplicand, jArrCreate65);
            jArr4 = jArrCreate65;
        }
        SecT571Field.squareAddToExt(jArr4, jArrCreateExt64);
        SecT571Field.reduce(jArrCreateExt64, jArrCreate65);
        SecT571Field.addBothTo(secT571FieldElement4.f4769x, secT571FieldElement5.f4769x, jArrCreate65);
        return new SecT571R1Point(curve, secT571FieldElement4, new SecT571FieldElement(jArrCreate65), new ECFieldElement[]{secT571FieldElement5});
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint twicePlus(ECPoint eCPoint) {
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement) this.f4703x;
        if (secT571FieldElement.isZero()) {
            return eCPoint;
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement) eCPoint.getRawXCoord();
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement) eCPoint.getZCoord(0);
        if (secT571FieldElement2.isZero() || !secT571FieldElement3.isOne()) {
            return twice().add(eCPoint);
        }
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.f4704y;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) this.f4705zs[0];
        SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) eCPoint.getRawYCoord();
        long[] jArrCreate64 = Nat576.create64();
        long[] jArrCreate65 = Nat576.create64();
        long[] jArrCreate66 = Nat576.create64();
        long[] jArrCreate67 = Nat576.create64();
        SecT571Field.square(secT571FieldElement.f4769x, jArrCreate64);
        SecT571Field.square(secT571FieldElement4.f4769x, jArrCreate65);
        SecT571Field.square(secT571FieldElement5.f4769x, jArrCreate66);
        SecT571Field.multiply(secT571FieldElement4.f4769x, secT571FieldElement5.f4769x, jArrCreate67);
        SecT571Field.addBothTo(jArrCreate66, jArrCreate65, jArrCreate67);
        long[] jArrPrecompMultiplicand = SecT571Field.precompMultiplicand(jArrCreate66);
        SecT571Field.multiplyPrecomp(secT571FieldElement6.f4769x, jArrPrecompMultiplicand, jArrCreate66);
        SecT571Field.add(jArrCreate66, jArrCreate65, jArrCreate66);
        long[] jArrCreateExt64 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(jArrCreate66, jArrCreate67, jArrCreateExt64);
        SecT571Field.multiplyPrecompAddToExt(jArrCreate64, jArrPrecompMultiplicand, jArrCreateExt64);
        SecT571Field.reduce(jArrCreateExt64, jArrCreate66);
        SecT571Field.multiplyPrecomp(secT571FieldElement2.f4769x, jArrPrecompMultiplicand, jArrCreate64);
        SecT571Field.add(jArrCreate64, jArrCreate67, jArrCreate65);
        SecT571Field.square(jArrCreate65, jArrCreate65);
        if (Nat576.isZero64(jArrCreate65)) {
            return Nat576.isZero64(jArrCreate66) ? eCPoint.twice() : curve.getInfinity();
        }
        if (Nat576.isZero64(jArrCreate66)) {
            return new SecT571R1Point(curve, new SecT571FieldElement(jArrCreate66), SecT571R1Curve.SecT571R1_B_SQRT);
        }
        SecT571FieldElement secT571FieldElement7 = new SecT571FieldElement();
        SecT571Field.square(jArrCreate66, secT571FieldElement7.f4769x);
        long[] jArr = secT571FieldElement7.f4769x;
        SecT571Field.multiply(jArr, jArrCreate64, jArr);
        SecT571FieldElement secT571FieldElement8 = new SecT571FieldElement(jArrCreate64);
        SecT571Field.multiply(jArrCreate66, jArrCreate65, secT571FieldElement8.f4769x);
        long[] jArr2 = secT571FieldElement8.f4769x;
        SecT571Field.multiplyPrecomp(jArr2, jArrPrecompMultiplicand, jArr2);
        SecT571FieldElement secT571FieldElement9 = new SecT571FieldElement(jArrCreate65);
        SecT571Field.add(jArrCreate66, jArrCreate65, secT571FieldElement9.f4769x);
        long[] jArr3 = secT571FieldElement9.f4769x;
        SecT571Field.square(jArr3, jArr3);
        Nat.zero64(18, jArrCreateExt64);
        SecT571Field.multiplyAddToExt(secT571FieldElement9.f4769x, jArrCreate67, jArrCreateExt64);
        SecT571Field.addOne(secT571FieldElement6.f4769x, jArrCreate67);
        SecT571Field.multiplyAddToExt(jArrCreate67, secT571FieldElement8.f4769x, jArrCreateExt64);
        SecT571Field.reduce(jArrCreateExt64, secT571FieldElement9.f4769x);
        return new SecT571R1Point(curve, secT571FieldElement7, secT571FieldElement9, new ECFieldElement[]{secT571FieldElement8});
    }
}
