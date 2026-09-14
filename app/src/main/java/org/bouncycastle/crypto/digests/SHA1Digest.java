package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
public class SHA1Digest extends GeneralDigest implements EncodableDigest {

    /* JADX INFO: renamed from: H1 */
    private int f4258H1;

    /* JADX INFO: renamed from: H2 */
    private int f4259H2;

    /* JADX INFO: renamed from: H3 */
    private int f4260H3;

    /* JADX INFO: renamed from: H4 */
    private int f4261H4;

    /* JADX INFO: renamed from: H5 */
    private int f4262H5;

    /* JADX INFO: renamed from: X */
    private int[] f4263X;
    private int xOff;

    public SHA1Digest() {
        this.f4263X = new int[80];
        reset();
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.f4263X = new int[80];
        copyIn(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.f4263X = new int[80];
        this.f4258H1 = Pack.bigEndianToInt(bArr, 16);
        this.f4259H2 = Pack.bigEndianToInt(bArr, 20);
        this.f4260H3 = Pack.bigEndianToInt(bArr, 24);
        this.f4261H4 = Pack.bigEndianToInt(bArr, 28);
        this.f4262H5 = Pack.bigEndianToInt(bArr, 32);
        this.xOff = Pack.bigEndianToInt(bArr, 36);
        for (int i = 0; i != this.xOff; i++) {
            this.f4263X[i] = Pack.bigEndianToInt(bArr, (i * 4) + 40);
        }
    }

    private void copyIn(SHA1Digest sHA1Digest) {
        this.f4258H1 = sHA1Digest.f4258H1;
        this.f4259H2 = sHA1Digest.f4259H2;
        this.f4260H3 = sHA1Digest.f4260H3;
        this.f4261H4 = sHA1Digest.f4261H4;
        this.f4262H5 = sHA1Digest.f4262H5;
        int[] iArr = sHA1Digest.f4263X;
        System.arraycopy(iArr, 0, this.f4263X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    /* JADX INFO: renamed from: f */
    private int m2043f(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* JADX INFO: renamed from: g */
    private int m2044g(int i, int i2, int i3) {
        return ((i2 | i3) & i) | (i2 & i3);
    }

    /* JADX INFO: renamed from: h */
    private int m2045h(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA1Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f4258H1, bArr, i);
        Pack.intToBigEndian(this.f4259H2, bArr, i + 4);
        Pack.intToBigEndian(this.f4260H3, bArr, i + 8);
        Pack.intToBigEndian(this.f4261H4, bArr, i + 12);
        Pack.intToBigEndian(this.f4262H5, bArr, i + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.xOff * 4) + 40];
        super.populateState(bArr);
        Pack.intToBigEndian(this.f4258H1, bArr, 16);
        Pack.intToBigEndian(this.f4259H2, bArr, 20);
        Pack.intToBigEndian(this.f4260H3, bArr, 24);
        Pack.intToBigEndian(this.f4261H4, bArr, 28);
        Pack.intToBigEndian(this.f4262H5, bArr, 32);
        Pack.intToBigEndian(this.xOff, bArr, 36);
        for (int i = 0; i != this.xOff; i++) {
            Pack.intToBigEndian(this.f4263X[i], bArr, (i * 4) + 40);
        }
        return bArr;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.f4263X;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int iM2045h = this.f4258H1;
        int iM2045h2 = this.f4259H2;
        int i3 = this.f4260H3;
        int i4 = this.f4261H4;
        int i5 = this.f4262H5;
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            int iM2043f = i5 + ((iM2045h << 5) | (iM2045h >>> 27)) + m2043f(iM2045h2, i3, i4) + this.f4263X[i6] + 1518500249;
            int i8 = (iM2045h2 >>> 2) | (iM2045h2 << 30);
            int iM2043f2 = i4 + ((iM2043f << 5) | (iM2043f >>> 27)) + m2043f(iM2045h, i8, i3) + this.f4263X[i6 + 1] + 1518500249;
            int i9 = (iM2045h >>> 2) | (iM2045h << 30);
            int iM2043f3 = i3 + ((iM2043f2 << 5) | (iM2043f2 >>> 27)) + m2043f(iM2043f, i9, i8) + this.f4263X[i6 + 2] + 1518500249;
            i5 = (iM2043f >>> 2) | (iM2043f << 30);
            int i10 = i6 + 4;
            iM2045h2 = i8 + ((iM2043f3 << 5) | (iM2043f3 >>> 27)) + m2043f(iM2043f2, i5, i9) + this.f4263X[i6 + 3] + 1518500249;
            i4 = (iM2043f2 >>> 2) | (iM2043f2 << 30);
            i6 += 5;
            iM2045h = i9 + ((iM2045h2 << 5) | (iM2045h2 >>> 27)) + m2043f(iM2043f3, i4, i5) + this.f4263X[i10] + 1518500249;
            i3 = (iM2043f3 >>> 2) | (iM2043f3 << 30);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            int iM2045h3 = i5 + ((iM2045h << 5) | (iM2045h >>> 27)) + m2045h(iM2045h2, i3, i4) + this.f4263X[i6] + 1859775393;
            int i12 = (iM2045h2 >>> 2) | (iM2045h2 << 30);
            int iM2045h4 = i4 + ((iM2045h3 << 5) | (iM2045h3 >>> 27)) + m2045h(iM2045h, i12, i3) + this.f4263X[i6 + 1] + 1859775393;
            int i13 = (iM2045h >>> 2) | (iM2045h << 30);
            int iM2045h5 = i3 + ((iM2045h4 << 5) | (iM2045h4 >>> 27)) + m2045h(iM2045h3, i13, i12) + this.f4263X[i6 + 2] + 1859775393;
            i5 = (iM2045h3 >>> 2) | (iM2045h3 << 30);
            int i14 = i6 + 4;
            iM2045h2 = i12 + ((iM2045h5 << 5) | (iM2045h5 >>> 27)) + m2045h(iM2045h4, i5, i13) + this.f4263X[i6 + 3] + 1859775393;
            i4 = (iM2045h4 >>> 2) | (iM2045h4 << 30);
            i6 += 5;
            iM2045h = i13 + ((iM2045h2 << 5) | (iM2045h2 >>> 27)) + m2045h(iM2045h5, i4, i5) + this.f4263X[i14] + 1859775393;
            i3 = (iM2045h5 >>> 2) | (iM2045h5 << 30);
        }
        for (int i15 = 0; i15 < 4; i15++) {
            int iM2044g = i5 + (((((iM2045h << 5) | (iM2045h >>> 27)) + m2044g(iM2045h2, i3, i4)) + this.f4263X[i6]) - 1894007588);
            int i16 = (iM2045h2 >>> 2) | (iM2045h2 << 30);
            int iM2044g2 = i4 + (((((iM2044g << 5) | (iM2044g >>> 27)) + m2044g(iM2045h, i16, i3)) + this.f4263X[i6 + 1]) - 1894007588);
            int i17 = (iM2045h >>> 2) | (iM2045h << 30);
            int iM2044g3 = i3 + (((((iM2044g2 << 5) | (iM2044g2 >>> 27)) + m2044g(iM2044g, i17, i16)) + this.f4263X[i6 + 2]) - 1894007588);
            i5 = (iM2044g >>> 2) | (iM2044g << 30);
            int i18 = i6 + 4;
            iM2045h2 = i16 + (((((iM2044g3 << 5) | (iM2044g3 >>> 27)) + m2044g(iM2044g2, i5, i17)) + this.f4263X[i6 + 3]) - 1894007588);
            i4 = (iM2044g2 >>> 2) | (iM2044g2 << 30);
            i6 += 5;
            iM2045h = i17 + (((((iM2045h2 << 5) | (iM2045h2 >>> 27)) + m2044g(iM2044g3, i4, i5)) + this.f4263X[i18]) - 1894007588);
            i3 = (iM2044g3 >>> 2) | (iM2044g3 << 30);
        }
        for (int i19 = 0; i19 <= 3; i19++) {
            int iM2045h6 = i5 + (((((iM2045h << 5) | (iM2045h >>> 27)) + m2045h(iM2045h2, i3, i4)) + this.f4263X[i6]) - 899497514);
            int i20 = (iM2045h2 >>> 2) | (iM2045h2 << 30);
            int iM2045h7 = i4 + (((((iM2045h6 << 5) | (iM2045h6 >>> 27)) + m2045h(iM2045h, i20, i3)) + this.f4263X[i6 + 1]) - 899497514);
            int i21 = (iM2045h >>> 2) | (iM2045h << 30);
            int iM2045h8 = i3 + (((((iM2045h7 << 5) | (iM2045h7 >>> 27)) + m2045h(iM2045h6, i21, i20)) + this.f4263X[i6 + 2]) - 899497514);
            i5 = (iM2045h6 >>> 2) | (iM2045h6 << 30);
            int i22 = i6 + 4;
            iM2045h2 = i20 + (((((iM2045h8 << 5) | (iM2045h8 >>> 27)) + m2045h(iM2045h7, i5, i21)) + this.f4263X[i6 + 3]) - 899497514);
            i4 = (iM2045h7 >>> 2) | (iM2045h7 << 30);
            i6 += 5;
            iM2045h = i21 + (((((iM2045h2 << 5) | (iM2045h2 >>> 27)) + m2045h(iM2045h8, i4, i5)) + this.f4263X[i22]) - 899497514);
            i3 = (iM2045h8 >>> 2) | (iM2045h8 << 30);
        }
        this.f4258H1 += iM2045h;
        this.f4259H2 += iM2045h2;
        this.f4260H3 += i3;
        this.f4261H4 += i4;
        this.f4262H5 += i5;
        this.xOff = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            this.f4263X[i23] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    protected void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f4263X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    protected void processWord(byte[] bArr, int i) {
        int i2 = (bArr[i + 3] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        int[] iArr = this.f4263X;
        int i3 = this.xOff;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.xOff = i4;
        if (i4 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f4258H1 = 1732584193;
        this.f4259H2 = -271733879;
        this.f4260H3 = -1732584194;
        this.f4261H4 = 271733878;
        this.f4262H5 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f4263X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }
}
