package org.bouncycastle.math.p183ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.p183ec.AbstractECLookupTable;
import org.bouncycastle.math.p183ec.ECConstants;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECFieldElement;
import org.bouncycastle.math.p183ec.ECLookupTable;
import org.bouncycastle.math.p183ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes6.dex */
public class SecP256K1Curve extends ECCurve.AbstractFp {
    protected SecP256K1Point infinity;

    /* JADX INFO: renamed from: q */
    public static final BigInteger f4745q = SecP256K1FieldElement.f4747Q;
    private static final ECFieldElement[] SECP256K1_AFFINE_ZS = {new SecP256K1FieldElement(ECConstants.ONE)};

    public SecP256K1Curve() {
        super(f4745q);
        this.infinity = new SecP256K1Point(this, null, null);
        this.f4688a = fromBigInteger(ECConstants.ZERO);
        this.f4689b = fromBigInteger(BigInteger.valueOf(7L));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.cofactor = BigInteger.valueOf(1L);
        this.coord = 2;
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    protected ECCurve cloneCurve() {
        return new SecP256K1Curve();
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i, final int i2) {
        final int[] iArr = new int[i2 * 16];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            ECPoint eCPoint = eCPointArr[i + i4];
            Nat256.copy(((SecP256K1FieldElement) eCPoint.getRawXCoord()).f4748x, 0, iArr, i3);
            Nat256.copy(((SecP256K1FieldElement) eCPoint.getRawYCoord()).f4748x, 0, iArr, i3 + 8);
            i3 += 16;
        }
        return new AbstractECLookupTable() { // from class: org.bouncycastle.math.ec.custom.sec.SecP256K1Curve.1
            private ECPoint createPoint(int[] iArr2, int[] iArr3) {
                return SecP256K1Curve.this.createRawPoint(new SecP256K1FieldElement(iArr2), new SecP256K1FieldElement(iArr3), SecP256K1Curve.SECP256K1_AFFINE_ZS);
            }

            @Override // org.bouncycastle.math.p183ec.ECLookupTable
            public int getSize() {
                return i2;
            }

            @Override // org.bouncycastle.math.p183ec.ECLookupTable
            public ECPoint lookup(int i5) {
                int[] iArrCreate = Nat256.create();
                int[] iArrCreate2 = Nat256.create();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = ((i7 ^ i5) - 1) >> 31;
                    for (int i9 = 0; i9 < 8; i9++) {
                        int i10 = iArrCreate[i9];
                        int[] iArr2 = iArr;
                        iArrCreate[i9] = i10 ^ (iArr2[i6 + i9] & i8);
                        iArrCreate2[i9] = iArrCreate2[i9] ^ (iArr2[(i6 + 8) + i9] & i8);
                    }
                    i6 += 16;
                }
                return createPoint(iArrCreate, iArrCreate2);
            }

            @Override // org.bouncycastle.math.p183ec.AbstractECLookupTable, org.bouncycastle.math.p183ec.ECLookupTable
            public ECPoint lookupVar(int i5) {
                int[] iArrCreate = Nat256.create();
                int[] iArrCreate2 = Nat256.create();
                int i6 = i5 * 16;
                for (int i7 = 0; i7 < 8; i7++) {
                    int[] iArr2 = iArr;
                    iArrCreate[i7] = iArr2[i6 + i7];
                    iArrCreate2[i7] = iArr2[8 + i6 + i7];
                }
                return createPoint(iArrCreate, iArrCreate2);
            }
        };
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    protected ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP256K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    protected ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP256K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP256K1FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public int getFieldSize() {
        return f4745q.bitLength();
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f4745q;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.p183ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = Nat256.create();
        SecP256K1Field.random(secureRandom, iArrCreate);
        return new SecP256K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.p183ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = Nat256.create();
        SecP256K1Field.randomMult(secureRandom, iArrCreate);
        return new SecP256K1FieldElement(iArrCreate);
    }

    @Override // org.bouncycastle.math.p183ec.ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }
}
