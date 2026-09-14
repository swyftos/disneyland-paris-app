package org.bouncycastle.cert.selector;

import com.google.common.base.Ascii;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
abstract class MSOutlookKeyIdCalculator {

    private static abstract class GeneralDigest {
        private long byteCount;
        private byte[] xBuf = new byte[4];
        private int xBufOff = 0;

        protected GeneralDigest() {
        }

        public void finish() {
            long j = this.byteCount << 3;
            byte b = -128;
            while (true) {
                update(b);
                if (this.xBufOff == 0) {
                    processLength(j);
                    processBlock();
                    return;
                }
                b = 0;
            }
        }

        protected abstract void processBlock();

        protected abstract void processLength(long j);

        protected abstract void processWord(byte[] bArr, int i);

        public void reset() {
            this.byteCount = 0L;
            this.xBufOff = 0;
            int i = 0;
            while (true) {
                byte[] bArr = this.xBuf;
                if (i >= bArr.length) {
                    return;
                }
                bArr[i] = 0;
                i++;
            }
        }

        public void update(byte b) {
            byte[] bArr = this.xBuf;
            int i = this.xBufOff;
            int i2 = i + 1;
            this.xBufOff = i2;
            bArr[i] = b;
            if (i2 == bArr.length) {
                processWord(bArr, 0);
                this.xBufOff = 0;
            }
            this.byteCount++;
        }

        public void update(byte[] bArr, int i, int i2) {
            while (this.xBufOff != 0 && i2 > 0) {
                update(bArr[i]);
                i++;
                i2--;
            }
            while (i2 > this.xBuf.length) {
                processWord(bArr, i);
                byte[] bArr2 = this.xBuf;
                i += bArr2.length;
                i2 -= bArr2.length;
                this.byteCount += (long) bArr2.length;
            }
            while (i2 > 0) {
                update(bArr[i]);
                i++;
                i2--;
            }
        }
    }

    private static class SHA1Digest extends GeneralDigest {

        /* JADX INFO: renamed from: H1 */
        private int f4120H1;

        /* JADX INFO: renamed from: H2 */
        private int f4121H2;

        /* JADX INFO: renamed from: H3 */
        private int f4122H3;

        /* JADX INFO: renamed from: H4 */
        private int f4123H4;

        /* JADX INFO: renamed from: H5 */
        private int f4124H5;

        /* JADX INFO: renamed from: X */
        private int[] f4125X = new int[80];
        private int xOff;

        public SHA1Digest() {
            reset();
        }

        /* JADX INFO: renamed from: f */
        private int m1990f(int i, int i2, int i3) {
            return (i & i2) | ((~i) & i3);
        }

        /* JADX INFO: renamed from: g */
        private int m1991g(int i, int i2, int i3) {
            return ((i2 | i3) & i) | (i2 & i3);
        }

        /* JADX INFO: renamed from: h */
        private int m1992h(int i, int i2, int i3) {
            return (i ^ i2) ^ i3;
        }

        public int doFinal(byte[] bArr, int i) {
            finish();
            Pack.intToBigEndian(this.f4120H1, bArr, i);
            Pack.intToBigEndian(this.f4121H2, bArr, i + 4);
            Pack.intToBigEndian(this.f4122H3, bArr, i + 8);
            Pack.intToBigEndian(this.f4123H4, bArr, i + 12);
            Pack.intToBigEndian(this.f4124H5, bArr, i + 16);
            reset();
            return 20;
        }

        public int getDigestSize() {
            return 20;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processBlock() {
            for (int i = 16; i < 80; i++) {
                int[] iArr = this.f4125X;
                int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                iArr[i] = (i2 >>> 31) | (i2 << 1);
            }
            int iM1992h = this.f4120H1;
            int iM1992h2 = this.f4121H2;
            int i3 = this.f4122H3;
            int i4 = this.f4123H4;
            int i5 = this.f4124H5;
            int i6 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                int iM1990f = i5 + ((iM1992h << 5) | (iM1992h >>> 27)) + m1990f(iM1992h2, i3, i4) + this.f4125X[i6] + 1518500249;
                int i8 = (iM1992h2 >>> 2) | (iM1992h2 << 30);
                int iM1990f2 = i4 + ((iM1990f << 5) | (iM1990f >>> 27)) + m1990f(iM1992h, i8, i3) + this.f4125X[i6 + 1] + 1518500249;
                int i9 = (iM1992h >>> 2) | (iM1992h << 30);
                int iM1990f3 = i3 + ((iM1990f2 << 5) | (iM1990f2 >>> 27)) + m1990f(iM1990f, i9, i8) + this.f4125X[i6 + 2] + 1518500249;
                i5 = (iM1990f >>> 2) | (iM1990f << 30);
                int i10 = i6 + 4;
                iM1992h2 = i8 + ((iM1990f3 << 5) | (iM1990f3 >>> 27)) + m1990f(iM1990f2, i5, i9) + this.f4125X[i6 + 3] + 1518500249;
                i4 = (iM1990f2 >>> 2) | (iM1990f2 << 30);
                i6 += 5;
                iM1992h = i9 + ((iM1992h2 << 5) | (iM1992h2 >>> 27)) + m1990f(iM1990f3, i4, i5) + this.f4125X[i10] + 1518500249;
                i3 = (iM1990f3 >>> 2) | (iM1990f3 << 30);
            }
            for (int i11 = 0; i11 < 4; i11++) {
                int iM1992h3 = i5 + ((iM1992h << 5) | (iM1992h >>> 27)) + m1992h(iM1992h2, i3, i4) + this.f4125X[i6] + 1859775393;
                int i12 = (iM1992h2 >>> 2) | (iM1992h2 << 30);
                int iM1992h4 = i4 + ((iM1992h3 << 5) | (iM1992h3 >>> 27)) + m1992h(iM1992h, i12, i3) + this.f4125X[i6 + 1] + 1859775393;
                int i13 = (iM1992h >>> 2) | (iM1992h << 30);
                int iM1992h5 = i3 + ((iM1992h4 << 5) | (iM1992h4 >>> 27)) + m1992h(iM1992h3, i13, i12) + this.f4125X[i6 + 2] + 1859775393;
                i5 = (iM1992h3 >>> 2) | (iM1992h3 << 30);
                int i14 = i6 + 4;
                iM1992h2 = i12 + ((iM1992h5 << 5) | (iM1992h5 >>> 27)) + m1992h(iM1992h4, i5, i13) + this.f4125X[i6 + 3] + 1859775393;
                i4 = (iM1992h4 >>> 2) | (iM1992h4 << 30);
                i6 += 5;
                iM1992h = i13 + ((iM1992h2 << 5) | (iM1992h2 >>> 27)) + m1992h(iM1992h5, i4, i5) + this.f4125X[i14] + 1859775393;
                i3 = (iM1992h5 >>> 2) | (iM1992h5 << 30);
            }
            for (int i15 = 0; i15 < 4; i15++) {
                int iM1991g = i5 + (((((iM1992h << 5) | (iM1992h >>> 27)) + m1991g(iM1992h2, i3, i4)) + this.f4125X[i6]) - 1894007588);
                int i16 = (iM1992h2 >>> 2) | (iM1992h2 << 30);
                int iM1991g2 = i4 + (((((iM1991g << 5) | (iM1991g >>> 27)) + m1991g(iM1992h, i16, i3)) + this.f4125X[i6 + 1]) - 1894007588);
                int i17 = (iM1992h >>> 2) | (iM1992h << 30);
                int iM1991g3 = i3 + (((((iM1991g2 << 5) | (iM1991g2 >>> 27)) + m1991g(iM1991g, i17, i16)) + this.f4125X[i6 + 2]) - 1894007588);
                i5 = (iM1991g >>> 2) | (iM1991g << 30);
                int i18 = i6 + 4;
                iM1992h2 = i16 + (((((iM1991g3 << 5) | (iM1991g3 >>> 27)) + m1991g(iM1991g2, i5, i17)) + this.f4125X[i6 + 3]) - 1894007588);
                i4 = (iM1991g2 >>> 2) | (iM1991g2 << 30);
                i6 += 5;
                iM1992h = i17 + (((((iM1992h2 << 5) | (iM1992h2 >>> 27)) + m1991g(iM1991g3, i4, i5)) + this.f4125X[i18]) - 1894007588);
                i3 = (iM1991g3 >>> 2) | (iM1991g3 << 30);
            }
            for (int i19 = 0; i19 <= 3; i19++) {
                int iM1992h6 = i5 + (((((iM1992h << 5) | (iM1992h >>> 27)) + m1992h(iM1992h2, i3, i4)) + this.f4125X[i6]) - 899497514);
                int i20 = (iM1992h2 >>> 2) | (iM1992h2 << 30);
                int iM1992h7 = i4 + (((((iM1992h6 << 5) | (iM1992h6 >>> 27)) + m1992h(iM1992h, i20, i3)) + this.f4125X[i6 + 1]) - 899497514);
                int i21 = (iM1992h >>> 2) | (iM1992h << 30);
                int iM1992h8 = i3 + (((((iM1992h7 << 5) | (iM1992h7 >>> 27)) + m1992h(iM1992h6, i21, i20)) + this.f4125X[i6 + 2]) - 899497514);
                i5 = (iM1992h6 >>> 2) | (iM1992h6 << 30);
                int i22 = i6 + 4;
                iM1992h2 = i20 + (((((iM1992h8 << 5) | (iM1992h8 >>> 27)) + m1992h(iM1992h7, i5, i21)) + this.f4125X[i6 + 3]) - 899497514);
                i4 = (iM1992h7 >>> 2) | (iM1992h7 << 30);
                i6 += 5;
                iM1992h = i21 + (((((iM1992h2 << 5) | (iM1992h2 >>> 27)) + m1992h(iM1992h8, i4, i5)) + this.f4125X[i22]) - 899497514);
                i3 = (iM1992h8 >>> 2) | (iM1992h8 << 30);
            }
            this.f4120H1 += iM1992h;
            this.f4121H2 += iM1992h2;
            this.f4122H3 += i3;
            this.f4123H4 += i4;
            this.f4124H5 += i5;
            this.xOff = 0;
            for (int i23 = 0; i23 < 16; i23++) {
                this.f4125X[i23] = 0;
            }
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processLength(long j) {
            if (this.xOff > 14) {
                processBlock();
            }
            int[] iArr = this.f4125X;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) j;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processWord(byte[] bArr, int i) {
            int i2 = (bArr[i + 3] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            int[] iArr = this.f4125X;
            int i3 = this.xOff;
            iArr[i3] = i2;
            int i4 = i3 + 1;
            this.xOff = i4;
            if (i4 == 16) {
                processBlock();
            }
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void reset() {
            super.reset();
            this.f4120H1 = 1732584193;
            this.f4121H2 = -271733879;
            this.f4122H3 = -1732584194;
            this.f4123H4 = 271733878;
            this.f4124H5 = -1009589776;
            this.xOff = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.f4125X;
                if (i == iArr.length) {
                    return;
                }
                iArr[i] = 0;
                i++;
            }
        }
    }

    static byte[] calculateKeyId(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        try {
            byte[] encoded = subjectPublicKeyInfo.getEncoded(ASN1Encoding.DER);
            sHA1Digest.update(encoded, 0, encoded.length);
            sHA1Digest.doFinal(bArr, 0);
            return bArr;
        } catch (IOException unused) {
            return new byte[0];
        }
    }
}
