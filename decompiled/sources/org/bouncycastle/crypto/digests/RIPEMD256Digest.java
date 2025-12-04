package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

/* loaded from: classes6.dex */
public class RIPEMD256Digest extends GeneralDigest {
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int[] X;
    private int xOff;

    public RIPEMD256Digest() {
        this.X = new int[16];
        reset();
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super(rIPEMD256Digest);
        this.X = new int[16];
        copyIn(rIPEMD256Digest);
    }

    private int F1(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(i + f1(i2, i3, i4) + i5, i6);
    }

    private int F2(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(i + f2(i2, i3, i4) + i5 + 1518500249, i6);
    }

    private int F3(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(i + f3(i2, i3, i4) + i5 + 1859775393, i6);
    }

    private int F4(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(((i + f4(i2, i3, i4)) + i5) - 1894007588, i6);
    }

    private int FF1(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(i + f1(i2, i3, i4) + i5, i6);
    }

    private int FF2(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(i + f2(i2, i3, i4) + i5 + 1836072691, i6);
    }

    private int FF3(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(i + f3(i2, i3, i4) + i5 + 1548603684, i6);
    }

    private int FF4(int i, int i2, int i3, int i4, int i5, int i6) {
        return RL(i + f4(i2, i3, i4) + i5 + 1352829926, i6);
    }

    private int RL(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    private void copyIn(RIPEMD256Digest rIPEMD256Digest) {
        super.copyIn((GeneralDigest) rIPEMD256Digest);
        this.H0 = rIPEMD256Digest.H0;
        this.H1 = rIPEMD256Digest.H1;
        this.H2 = rIPEMD256Digest.H2;
        this.H3 = rIPEMD256Digest.H3;
        this.H4 = rIPEMD256Digest.H4;
        this.H5 = rIPEMD256Digest.H5;
        this.H6 = rIPEMD256Digest.H6;
        this.H7 = rIPEMD256Digest.H7;
        int[] iArr = rIPEMD256Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = rIPEMD256Digest.xOff;
    }

    private int f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int f2(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    private int f3(int i, int i2, int i3) {
        return ((~i2) | i) ^ i3;
    }

    private int f4(int i, int i2, int i3) {
        return (i & i3) | ((~i3) & i2);
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new RIPEMD256Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.H0, bArr, i);
        unpackWord(this.H1, bArr, i + 4);
        unpackWord(this.H2, bArr, i + 8);
        unpackWord(this.H3, bArr, i + 12);
        unpackWord(this.H4, bArr, i + 16);
        unpackWord(this.H5, bArr, i + 20);
        unpackWord(this.H6, bArr, i + 24);
        unpackWord(this.H7, bArr, i + 28);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD256";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        int i = this.H0;
        int i2 = this.H1;
        int i3 = this.H2;
        int i4 = this.H3;
        int i5 = this.H4;
        int i6 = this.H5;
        int i7 = this.H6;
        int i8 = this.H7;
        int iF1 = F1(i, i2, i3, i4, this.X[0], 11);
        int iF12 = F1(i4, iF1, i2, i3, this.X[1], 14);
        int iF13 = F1(i3, iF12, iF1, i2, this.X[2], 15);
        int iF14 = F1(i2, iF13, iF12, iF1, this.X[3], 12);
        int iF15 = F1(iF1, iF14, iF13, iF12, this.X[4], 5);
        int iF16 = F1(iF12, iF15, iF14, iF13, this.X[5], 8);
        int iF17 = F1(iF13, iF16, iF15, iF14, this.X[6], 7);
        int iF18 = F1(iF14, iF17, iF16, iF15, this.X[7], 9);
        int iF19 = F1(iF15, iF18, iF17, iF16, this.X[8], 11);
        int iF110 = F1(iF16, iF19, iF18, iF17, this.X[9], 13);
        int iF111 = F1(iF17, iF110, iF19, iF18, this.X[10], 14);
        int iF112 = F1(iF18, iF111, iF110, iF19, this.X[11], 15);
        int iF113 = F1(iF19, iF112, iF111, iF110, this.X[12], 6);
        int iF114 = F1(iF110, iF113, iF112, iF111, this.X[13], 7);
        int iF115 = F1(iF111, iF114, iF113, iF112, this.X[14], 9);
        int iF116 = F1(iF112, iF115, iF114, iF113, this.X[15], 8);
        int iFF4 = FF4(i5, i6, i7, i8, this.X[5], 8);
        int iFF42 = FF4(i8, iFF4, i6, i7, this.X[14], 9);
        int iFF43 = FF4(i7, iFF42, iFF4, i6, this.X[7], 9);
        int iFF44 = FF4(i6, iFF43, iFF42, iFF4, this.X[0], 11);
        int iFF45 = FF4(iFF4, iFF44, iFF43, iFF42, this.X[9], 13);
        int iFF46 = FF4(iFF42, iFF45, iFF44, iFF43, this.X[2], 15);
        int iFF47 = FF4(iFF43, iFF46, iFF45, iFF44, this.X[11], 15);
        int iFF48 = FF4(iFF44, iFF47, iFF46, iFF45, this.X[4], 5);
        int iFF49 = FF4(iFF45, iFF48, iFF47, iFF46, this.X[13], 7);
        int iFF410 = FF4(iFF46, iFF49, iFF48, iFF47, this.X[6], 7);
        int iFF411 = FF4(iFF47, iFF410, iFF49, iFF48, this.X[15], 8);
        int iFF412 = FF4(iFF48, iFF411, iFF410, iFF49, this.X[8], 11);
        int iFF413 = FF4(iFF49, iFF412, iFF411, iFF410, this.X[1], 14);
        int iFF414 = FF4(iFF410, iFF413, iFF412, iFF411, this.X[10], 14);
        int iFF415 = FF4(iFF411, iFF414, iFF413, iFF412, this.X[3], 12);
        int iFF416 = FF4(iFF412, iFF415, iFF414, iFF413, this.X[12], 6);
        int iF2 = F2(iFF413, iF116, iF115, iF114, this.X[7], 7);
        int iF22 = F2(iF114, iF2, iF116, iF115, this.X[4], 6);
        int iF23 = F2(iF115, iF22, iF2, iF116, this.X[13], 8);
        int iF24 = F2(iF116, iF23, iF22, iF2, this.X[1], 13);
        int iF25 = F2(iF2, iF24, iF23, iF22, this.X[10], 11);
        int iF26 = F2(iF22, iF25, iF24, iF23, this.X[6], 9);
        int iF27 = F2(iF23, iF26, iF25, iF24, this.X[15], 7);
        int iF28 = F2(iF24, iF27, iF26, iF25, this.X[3], 15);
        int iF29 = F2(iF25, iF28, iF27, iF26, this.X[12], 7);
        int iF210 = F2(iF26, iF29, iF28, iF27, this.X[0], 12);
        int iF211 = F2(iF27, iF210, iF29, iF28, this.X[9], 15);
        int iF212 = F2(iF28, iF211, iF210, iF29, this.X[5], 9);
        int iF213 = F2(iF29, iF212, iF211, iF210, this.X[2], 11);
        int iF214 = F2(iF210, iF213, iF212, iF211, this.X[14], 7);
        int iF215 = F2(iF211, iF214, iF213, iF212, this.X[11], 13);
        int iF216 = F2(iF212, iF215, iF214, iF213, this.X[8], 12);
        int iFF3 = FF3(iF113, iFF416, iFF415, iFF414, this.X[6], 9);
        int iFF32 = FF3(iFF414, iFF3, iFF416, iFF415, this.X[11], 13);
        int iFF33 = FF3(iFF415, iFF32, iFF3, iFF416, this.X[3], 15);
        int iFF34 = FF3(iFF416, iFF33, iFF32, iFF3, this.X[7], 7);
        int iFF35 = FF3(iFF3, iFF34, iFF33, iFF32, this.X[0], 12);
        int iFF36 = FF3(iFF32, iFF35, iFF34, iFF33, this.X[13], 8);
        int iFF37 = FF3(iFF33, iFF36, iFF35, iFF34, this.X[5], 9);
        int iFF38 = FF3(iFF34, iFF37, iFF36, iFF35, this.X[10], 11);
        int iFF39 = FF3(iFF35, iFF38, iFF37, iFF36, this.X[14], 7);
        int iFF310 = FF3(iFF36, iFF39, iFF38, iFF37, this.X[15], 7);
        int iFF311 = FF3(iFF37, iFF310, iFF39, iFF38, this.X[8], 12);
        int iFF312 = FF3(iFF38, iFF311, iFF310, iFF39, this.X[12], 7);
        int iFF313 = FF3(iFF39, iFF312, iFF311, iFF310, this.X[4], 6);
        int iFF314 = FF3(iFF310, iFF313, iFF312, iFF311, this.X[9], 15);
        int iFF315 = FF3(iFF311, iFF314, iFF313, iFF312, this.X[1], 13);
        int iFF316 = FF3(iFF312, iFF315, iFF314, iFF313, this.X[2], 11);
        int iF3 = F3(iF213, iFF316, iF215, iF214, this.X[3], 11);
        int iF32 = F3(iF214, iF3, iFF316, iF215, this.X[10], 13);
        int iF33 = F3(iF215, iF32, iF3, iFF316, this.X[14], 6);
        int iF34 = F3(iFF316, iF33, iF32, iF3, this.X[4], 7);
        int iF35 = F3(iF3, iF34, iF33, iF32, this.X[9], 14);
        int iF36 = F3(iF32, iF35, iF34, iF33, this.X[15], 9);
        int iF37 = F3(iF33, iF36, iF35, iF34, this.X[8], 13);
        int iF38 = F3(iF34, iF37, iF36, iF35, this.X[1], 15);
        int iF39 = F3(iF35, iF38, iF37, iF36, this.X[2], 14);
        int iF310 = F3(iF36, iF39, iF38, iF37, this.X[7], 8);
        int iF311 = F3(iF37, iF310, iF39, iF38, this.X[0], 13);
        int iF312 = F3(iF38, iF311, iF310, iF39, this.X[6], 6);
        int iF313 = F3(iF39, iF312, iF311, iF310, this.X[13], 5);
        int iF314 = F3(iF310, iF313, iF312, iF311, this.X[11], 12);
        int iF315 = F3(iF311, iF314, iF313, iF312, this.X[5], 7);
        int iF316 = F3(iF312, iF315, iF314, iF313, this.X[12], 5);
        int iFF2 = FF2(iFF313, iF216, iFF315, iFF314, this.X[15], 9);
        int iFF22 = FF2(iFF314, iFF2, iF216, iFF315, this.X[5], 7);
        int iFF23 = FF2(iFF315, iFF22, iFF2, iF216, this.X[1], 15);
        int iFF24 = FF2(iF216, iFF23, iFF22, iFF2, this.X[3], 11);
        int iFF25 = FF2(iFF2, iFF24, iFF23, iFF22, this.X[7], 8);
        int iFF26 = FF2(iFF22, iFF25, iFF24, iFF23, this.X[14], 6);
        int iFF27 = FF2(iFF23, iFF26, iFF25, iFF24, this.X[6], 6);
        int iFF28 = FF2(iFF24, iFF27, iFF26, iFF25, this.X[9], 14);
        int iFF29 = FF2(iFF25, iFF28, iFF27, iFF26, this.X[11], 12);
        int iFF210 = FF2(iFF26, iFF29, iFF28, iFF27, this.X[8], 13);
        int iFF211 = FF2(iFF27, iFF210, iFF29, iFF28, this.X[12], 5);
        int iFF212 = FF2(iFF28, iFF211, iFF210, iFF29, this.X[2], 14);
        int iFF213 = FF2(iFF29, iFF212, iFF211, iFF210, this.X[10], 13);
        int iFF214 = FF2(iFF210, iFF213, iFF212, iFF211, this.X[0], 13);
        int iFF215 = FF2(iFF211, iFF214, iFF213, iFF212, this.X[4], 7);
        int iFF216 = FF2(iFF212, iFF215, iFF214, iFF213, this.X[13], 5);
        int iF4 = F4(iF313, iF316, iFF215, iF314, this.X[1], 11);
        int iF42 = F4(iF314, iF4, iF316, iFF215, this.X[9], 12);
        int iF43 = F4(iFF215, iF42, iF4, iF316, this.X[11], 14);
        int iF44 = F4(iF316, iF43, iF42, iF4, this.X[10], 15);
        int iF45 = F4(iF4, iF44, iF43, iF42, this.X[0], 14);
        int iF46 = F4(iF42, iF45, iF44, iF43, this.X[8], 15);
        int iF47 = F4(iF43, iF46, iF45, iF44, this.X[12], 9);
        int iF48 = F4(iF44, iF47, iF46, iF45, this.X[4], 8);
        int iF49 = F4(iF45, iF48, iF47, iF46, this.X[13], 9);
        int iF410 = F4(iF46, iF49, iF48, iF47, this.X[3], 14);
        int iF411 = F4(iF47, iF410, iF49, iF48, this.X[7], 5);
        int iF412 = F4(iF48, iF411, iF410, iF49, this.X[15], 6);
        int iF413 = F4(iF49, iF412, iF411, iF410, this.X[14], 8);
        int iF414 = F4(iF410, iF413, iF412, iF411, this.X[5], 6);
        int iF415 = F4(iF411, iF414, iF413, iF412, this.X[6], 5);
        int iF416 = F4(iF412, iF415, iF414, iF413, this.X[2], 12);
        int iFF1 = FF1(iFF213, iFF216, iF315, iFF214, this.X[8], 15);
        int iFF12 = FF1(iFF214, iFF1, iFF216, iF315, this.X[6], 5);
        int iFF13 = FF1(iF315, iFF12, iFF1, iFF216, this.X[4], 8);
        int iFF14 = FF1(iFF216, iFF13, iFF12, iFF1, this.X[1], 11);
        int iFF15 = FF1(iFF1, iFF14, iFF13, iFF12, this.X[3], 14);
        int iFF16 = FF1(iFF12, iFF15, iFF14, iFF13, this.X[11], 14);
        int iFF17 = FF1(iFF13, iFF16, iFF15, iFF14, this.X[15], 6);
        int iFF18 = FF1(iFF14, iFF17, iFF16, iFF15, this.X[0], 14);
        int iFF19 = FF1(iFF15, iFF18, iFF17, iFF16, this.X[5], 6);
        int iFF110 = FF1(iFF16, iFF19, iFF18, iFF17, this.X[12], 9);
        int iFF111 = FF1(iFF17, iFF110, iFF19, iFF18, this.X[2], 12);
        int iFF112 = FF1(iFF18, iFF111, iFF110, iFF19, this.X[13], 9);
        int iFF113 = FF1(iFF19, iFF112, iFF111, iFF110, this.X[9], 12);
        int iFF114 = FF1(iFF110, iFF113, iFF112, iFF111, this.X[7], 5);
        int iFF115 = FF1(iFF111, iFF114, iFF113, iFF112, this.X[10], 15);
        int iFF116 = FF1(iFF112, iFF115, iFF114, iFF113, this.X[14], 8);
        this.H0 += iF413;
        this.H1 += iF416;
        this.H2 += iF415;
        this.H3 += iFF114;
        this.H4 += iFF113;
        this.H5 += iFF116;
        this.H6 += iFF115;
        this.H7 += iF414;
        this.xOff = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i9 == iArr.length) {
                return;
            }
            iArr[i9] = 0;
            i9++;
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    protected void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    protected void processWord(byte[] bArr, int i) {
        int[] iArr = this.X;
        int i2 = this.xOff;
        int i3 = i2 + 1;
        this.xOff = i3;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        if (i3 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H0 = 1732584193;
        this.H1 = -271733879;
        this.H2 = -1732584194;
        this.H3 = 271733878;
        this.H4 = 1985229328;
        this.H5 = -19088744;
        this.H6 = -1985229329;
        this.H7 = 19088743;
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

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((RIPEMD256Digest) memoable);
    }
}
