package org.bouncycastle.cert.selector;

import com.google.common.base.Ascii;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.Pack;

/* loaded from: classes6.dex */
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
                this.byteCount += bArr2.length;
            }
            while (i2 > 0) {
                update(bArr[i]);
                i++;
                i2--;
            }
        }
    }

    private static class SHA1Digest extends GeneralDigest {
        private int H1;
        private int H2;
        private int H3;
        private int H4;
        private int H5;
        private int[] X = new int[80];
        private int xOff;

        public SHA1Digest() {
            reset();
        }

        private int f(int i, int i2, int i3) {
            return (i & i2) | ((~i) & i3);
        }

        private int g(int i, int i2, int i3) {
            return ((i2 | i3) & i) | (i2 & i3);
        }

        private int h(int i, int i2, int i3) {
            return (i ^ i2) ^ i3;
        }

        public int doFinal(byte[] bArr, int i) {
            finish();
            Pack.intToBigEndian(this.H1, bArr, i);
            Pack.intToBigEndian(this.H2, bArr, i + 4);
            Pack.intToBigEndian(this.H3, bArr, i + 8);
            Pack.intToBigEndian(this.H4, bArr, i + 12);
            Pack.intToBigEndian(this.H5, bArr, i + 16);
            reset();
            return 20;
        }

        public int getDigestSize() {
            return 20;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processBlock() {
            for (int i = 16; i < 80; i++) {
                int[] iArr = this.X;
                int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                iArr[i] = (i2 >>> 31) | (i2 << 1);
            }
            int iH = this.H1;
            int iH2 = this.H2;
            int i3 = this.H3;
            int i4 = this.H4;
            int i5 = this.H5;
            int i6 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                int iF = i5 + ((iH << 5) | (iH >>> 27)) + f(iH2, i3, i4) + this.X[i6] + 1518500249;
                int i8 = (iH2 >>> 2) | (iH2 << 30);
                int iF2 = i4 + ((iF << 5) | (iF >>> 27)) + f(iH, i8, i3) + this.X[i6 + 1] + 1518500249;
                int i9 = (iH >>> 2) | (iH << 30);
                int iF3 = i3 + ((iF2 << 5) | (iF2 >>> 27)) + f(iF, i9, i8) + this.X[i6 + 2] + 1518500249;
                i5 = (iF >>> 2) | (iF << 30);
                int i10 = i6 + 4;
                iH2 = i8 + ((iF3 << 5) | (iF3 >>> 27)) + f(iF2, i5, i9) + this.X[i6 + 3] + 1518500249;
                i4 = (iF2 >>> 2) | (iF2 << 30);
                i6 += 5;
                iH = i9 + ((iH2 << 5) | (iH2 >>> 27)) + f(iF3, i4, i5) + this.X[i10] + 1518500249;
                i3 = (iF3 >>> 2) | (iF3 << 30);
            }
            for (int i11 = 0; i11 < 4; i11++) {
                int iH3 = i5 + ((iH << 5) | (iH >>> 27)) + h(iH2, i3, i4) + this.X[i6] + 1859775393;
                int i12 = (iH2 >>> 2) | (iH2 << 30);
                int iH4 = i4 + ((iH3 << 5) | (iH3 >>> 27)) + h(iH, i12, i3) + this.X[i6 + 1] + 1859775393;
                int i13 = (iH >>> 2) | (iH << 30);
                int iH5 = i3 + ((iH4 << 5) | (iH4 >>> 27)) + h(iH3, i13, i12) + this.X[i6 + 2] + 1859775393;
                i5 = (iH3 >>> 2) | (iH3 << 30);
                int i14 = i6 + 4;
                iH2 = i12 + ((iH5 << 5) | (iH5 >>> 27)) + h(iH4, i5, i13) + this.X[i6 + 3] + 1859775393;
                i4 = (iH4 >>> 2) | (iH4 << 30);
                i6 += 5;
                iH = i13 + ((iH2 << 5) | (iH2 >>> 27)) + h(iH5, i4, i5) + this.X[i14] + 1859775393;
                i3 = (iH5 >>> 2) | (iH5 << 30);
            }
            for (int i15 = 0; i15 < 4; i15++) {
                int iG = i5 + (((((iH << 5) | (iH >>> 27)) + g(iH2, i3, i4)) + this.X[i6]) - 1894007588);
                int iG2 = i4 + (((((iG << 5) | (iG >>> 27)) + g(iH, r2, i3)) + this.X[i6 + 1]) - 1894007588);
                int iG3 = i3 + (((((iG2 << 5) | (iG2 >>> 27)) + g(iG, r1, r2)) + this.X[i6 + 2]) - 1894007588);
                i5 = (iG >>> 2) | (iG << 30);
                int i16 = i6 + 4;
                iH2 = ((iH2 >>> 2) | (iH2 << 30)) + (((((iG3 << 5) | (iG3 >>> 27)) + g(iG2, i5, r1)) + this.X[i6 + 3]) - 1894007588);
                i4 = (iG2 >>> 2) | (iG2 << 30);
                i6 += 5;
                iH = ((iH >>> 2) | (iH << 30)) + (((((iH2 << 5) | (iH2 >>> 27)) + g(iG3, i4, i5)) + this.X[i16]) - 1894007588);
                i3 = (iG3 >>> 2) | (iG3 << 30);
            }
            for (int i17 = 0; i17 <= 3; i17++) {
                int iH6 = i5 + (((((iH << 5) | (iH >>> 27)) + h(iH2, i3, i4)) + this.X[i6]) - 899497514);
                int iH7 = i4 + (((((iH6 << 5) | (iH6 >>> 27)) + h(iH, r2, i3)) + this.X[i6 + 1]) - 899497514);
                int iH8 = i3 + (((((iH7 << 5) | (iH7 >>> 27)) + h(iH6, r1, r2)) + this.X[i6 + 2]) - 899497514);
                i5 = (iH6 >>> 2) | (iH6 << 30);
                int i18 = i6 + 4;
                iH2 = ((iH2 >>> 2) | (iH2 << 30)) + (((((iH8 << 5) | (iH8 >>> 27)) + h(iH7, i5, r1)) + this.X[i6 + 3]) - 899497514);
                i4 = (iH7 >>> 2) | (iH7 << 30);
                i6 += 5;
                iH = ((iH >>> 2) | (iH << 30)) + (((((iH2 << 5) | (iH2 >>> 27)) + h(iH8, i4, i5)) + this.X[i18]) - 899497514);
                i3 = (iH8 >>> 2) | (iH8 << 30);
            }
            this.H1 += iH;
            this.H2 += iH2;
            this.H3 += i3;
            this.H4 += i4;
            this.H5 += i5;
            this.xOff = 0;
            for (int i19 = 0; i19 < 16; i19++) {
                this.X[i19] = 0;
            }
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processLength(long j) {
            if (this.xOff > 14) {
                processBlock();
            }
            int[] iArr = this.X;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) j;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processWord(byte[] bArr, int i) {
            int i2 = (bArr[i + 3] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            int[] iArr = this.X;
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
            this.H1 = 1732584193;
            this.H2 = -271733879;
            this.H3 = -1732584194;
            this.H4 = 271733878;
            this.H5 = -1009589776;
            this.xOff = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.X;
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
