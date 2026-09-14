package org.bouncycastle.math.p183ec.custom.sec;

import org.bouncycastle.math.p183ec.ECConstants;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.p183ec.ECPoint;
import org.bouncycastle.math.raw.Nat576;

/* JADX INFO: loaded from: classes6.dex */
public class SecT571K1Point extends ECPoint.AbstractF2m {
    SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
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
            secT571FieldElement = (SecT571FieldElement) eCFieldElementDivide.square().add(eCFieldElementDivide).add(secT571FieldElement10);
            if (secT571FieldElement.isZero()) {
                return new SecT571K1Point(curve, secT571FieldElement, curve.getB());
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
                return new SecT571K1Point(curve, secT571FieldElement, curve.getB());
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
        return new SecT571K1Point(curve, secT571FieldElement, secT571FieldElement2, new ECFieldElement[]{secT571FieldElement3});
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    protected ECPoint detach() {
        return new SecT571K1Point(null, getAffineXCoord(), getAffineYCoord());
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
        return new SecT571K1Point(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    @Override // org.bouncycastle.math.p183ec.ECPoint
    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement = this.f4703x;
        if (eCFieldElement.isZero()) {
            return curve.getInfinity();
        }
        ECFieldElement eCFieldElement2 = this.f4704y;
        ECFieldElement eCFieldElementSquare = this.f4705zs[0];
        boolean zIsOne = eCFieldElementSquare.isOne();
        ECFieldElement eCFieldElementSquare2 = zIsOne ? eCFieldElementSquare : eCFieldElementSquare.square();
        ECFieldElement eCFieldElementAdd = zIsOne ? eCFieldElement2.square().add(eCFieldElement2) : eCFieldElement2.add(eCFieldElementSquare).multiply(eCFieldElement2);
        if (eCFieldElementAdd.isZero()) {
            return new SecT571K1Point(curve, eCFieldElementAdd, curve.getB());
        }
        ECFieldElement eCFieldElementSquare3 = eCFieldElementAdd.square();
        ECFieldElement eCFieldElementMultiply = zIsOne ? eCFieldElementAdd : eCFieldElementAdd.multiply(eCFieldElementSquare2);
        ECFieldElement eCFieldElementSquare4 = eCFieldElement2.add(eCFieldElement).square();
        if (!zIsOne) {
            eCFieldElementSquare = eCFieldElementSquare2.square();
        }
        return new SecT571K1Point(curve, eCFieldElementSquare3, eCFieldElementSquare4.add(eCFieldElementAdd).add(eCFieldElementSquare2).multiply(eCFieldElementSquare4).add(eCFieldElementSquare).add(eCFieldElementSquare3).add(eCFieldElementMultiply), new ECFieldElement[]{eCFieldElementMultiply});
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
        ECFieldElement eCFieldElement = this.f4703x;
        if (eCFieldElement.isZero()) {
            return eCPoint;
        }
        ECFieldElement rawXCoord = eCPoint.getRawXCoord();
        ECFieldElement zCoord = eCPoint.getZCoord(0);
        if (rawXCoord.isZero() || !zCoord.isOne()) {
            return twice().add(eCPoint);
        }
        ECFieldElement eCFieldElement2 = this.f4704y;
        ECFieldElement eCFieldElement3 = this.f4705zs[0];
        ECFieldElement rawYCoord = eCPoint.getRawYCoord();
        ECFieldElement eCFieldElementSquare = eCFieldElement.square();
        ECFieldElement eCFieldElementSquare2 = eCFieldElement2.square();
        ECFieldElement eCFieldElementSquare3 = eCFieldElement3.square();
        ECFieldElement eCFieldElementAdd = eCFieldElementSquare2.add(eCFieldElement2.multiply(eCFieldElement3));
        ECFieldElement eCFieldElementAddOne = rawYCoord.addOne();
        ECFieldElement eCFieldElementMultiplyPlusProduct = eCFieldElementAddOne.multiply(eCFieldElementSquare3).add(eCFieldElementSquare2).multiplyPlusProduct(eCFieldElementAdd, eCFieldElementSquare, eCFieldElementSquare3);
        ECFieldElement eCFieldElementMultiply = rawXCoord.multiply(eCFieldElementSquare3);
        ECFieldElement eCFieldElementSquare4 = eCFieldElementMultiply.add(eCFieldElementAdd).square();
        if (eCFieldElementSquare4.isZero()) {
            return eCFieldElementMultiplyPlusProduct.isZero() ? eCPoint.twice() : curve.getInfinity();
        }
        if (eCFieldElementMultiplyPlusProduct.isZero()) {
            return new SecT571K1Point(curve, eCFieldElementMultiplyPlusProduct, curve.getB());
        }
        ECFieldElement eCFieldElementMultiply2 = eCFieldElementMultiplyPlusProduct.square().multiply(eCFieldElementMultiply);
        ECFieldElement eCFieldElementMultiply3 = eCFieldElementMultiplyPlusProduct.multiply(eCFieldElementSquare4).multiply(eCFieldElementSquare3);
        return new SecT571K1Point(curve, eCFieldElementMultiply2, eCFieldElementMultiplyPlusProduct.add(eCFieldElementSquare4).square().multiplyPlusProduct(eCFieldElementAdd, eCFieldElementAddOne, eCFieldElementMultiply3), new ECFieldElement[]{eCFieldElementMultiply3});
    }
}
