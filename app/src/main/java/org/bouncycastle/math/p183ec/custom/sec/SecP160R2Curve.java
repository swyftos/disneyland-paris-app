package org.bouncycastle.math.p183ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.p183ec.AbstractECLookupTable;
import org.bouncycastle.math.p183ec.ECConstants;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.p183ec.ECLookupTable;
import org.bouncycastle.math.p183ec.ECPoint;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes6.dex */
public class SecP160R2Curve extends ECCurve.AbstractFp {
    protected SecP160R2Point infinity;

    /* JADX INFO: renamed from: q */
    public static final BigInteger f4725q = SecP160R2FieldElement.f4727Q;
    private static final ECFieldElement[] SECP160R2_AFFINE_ZS = {new SecP160R2FieldElement(ECConstants.ONE)};

    public SecP160R2Curve() {
        super(f4725q);
        this.infinity = new SecP160R2Point(this, null, null);
        this.f4688a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.f4689b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.order = new BigInteger(1, Hex.decodeStrict("0100000000000000000000351EE786A818F3A1A16B"));
        this.cofactor = BigInteger.valueOf(1L);
        this.coord = 2;
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    protected ECCurve cloneCurve() {
        return new SecP160R2Curve();
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i, final int i2) {
        final int[] iArr = new int[i2 * 10];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            ECPoint eCPoint = eCPointArr[i + i4];
            Nat160.copy(((SecP160R2FieldElement) eCPoint.getRawXCoord()).f4728x, 0, iArr, i3);
            Nat160.copy(((SecP160R2FieldElement) eCPoint.getRawYCoord()).f4728x, 0, iArr, i3 + 5);
            i3 += 10;
        }
        return new AbstractECLookupTable() { // from class: org.bouncycastle.math.ec.custom.sec.SecP160R2Curve.1
            private ECPoint createPoint(int[] iArr2, int[] iArr3) {
                return SecP160R2Curve.this.createRawPoint(new SecP160R2FieldElement(iArr2), new SecP160R2FieldElement(iArr3), SecP160R2Curve.SECP160R2_AFFINE_ZS);
            }

            @Override // org.bouncycastle.math.p183ec.ECLookupTable
            public int getSize() {
                return i2;
            }

            @Override // org.bouncycastle.math.p183ec.ECLookupTable
            public ECPoint lookup(int i5) {
                int[] iArrCreate = Nat160.create();
                int[] iArrCreate2 = Nat160.create();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = ((i7 ^ i5) - 1) >> 31;
                    for (int i9 = 0; i9 < 5; i9++) {
                        int i10 = iArrCreate[i9];
                        int[] iArr2 = iArr;
                        iArrCreate[i9] = i10 ^ (iArr2[i6 + i9] & i8);
                        iArrCreate2[i9] = iArrCreate2[i9] ^ (iArr2[(i6 + 5) + i9] & i8);
                    }
                    i6 += 10;
                }
                return createPoint(iArrCreate, iArrCreate2);
            }

            @Override // org.bouncycastle.math.p183ec.AbstractECLookupTable, org.bouncycastle.math.p183ec.ECLookupTable
            public ECPoint lookupVar(int i5) {
                int[] iArrCreate = Nat160.create();
                int[] iArrCreate2 = Nat160.create();
                int i6 = i5 * 10;
                for (int i7 = 0; i7 < 5; i7++) {
                    int[] iArr2 = iArr;
                    iArrCreate[i7] = iArr2[i6 + i7];
                    iArrCreate2[i7] = iArr2[5 + i6 + i7];
                }
                return createPoint(iArrCreate, iArrCreate2);
            }
        };
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    protected ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP160R2Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    protected ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP160R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP160R2FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public int getFieldSize() {
        return f4725q.bitLength();
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f4725q;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.p183ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = Nat160.create();
        SecP160R2Field.random(secureRandom, iArrCreate);
        return new SecP160R2FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.p183ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = Nat160.create();
        SecP160R2Field.randomMult(secureRandom, iArrCreate);
        return new SecP160R2FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }
}
