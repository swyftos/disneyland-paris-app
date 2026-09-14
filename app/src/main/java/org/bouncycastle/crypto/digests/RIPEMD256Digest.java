package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes6.dex */
public class RIPEMD256Digest extends GeneralDigest {

    /* JADX INFO: renamed from: H0 */
    private int f4238H0;

    /* JADX INFO: renamed from: H1 */
    private int f4239H1;

    /* JADX INFO: renamed from: H2 */
    private int f4240H2;

    /* JADX INFO: renamed from: H3 */
    private int f4241H3;

    /* JADX INFO: renamed from: H4 */
    private int f4242H4;

    /* JADX INFO: renamed from: H5 */
    private int f4243H5;

    /* JADX INFO: renamed from: H6 */
    private int f4244H6;

    /* JADX INFO: renamed from: H7 */
    private int f4245H7;

    /* JADX INFO: renamed from: X */
    private int[] f4246X;
    private int xOff;

    public RIPEMD256Digest() {
        this.f4246X = new int[16];
        reset();
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super(rIPEMD256Digest);
        this.f4246X = new int[16];
        copyIn(rIPEMD256Digest);
    }

    /* JADX INFO: renamed from: F1 */
    private int m2028F1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(i + m2033f1(i2, i3, i4) + i5, i6);
    }

    /* JADX INFO: renamed from: F2 */
    private int m2029F2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(i + m2034f2(i2, i3, i4) + i5 + 1518500249, i6);
    }

    /* JADX INFO: renamed from: F3 */
    private int m2030F3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(i + m2035f3(i2, i3, i4) + i5 + 1859775393, i6);
    }

    /* JADX INFO: renamed from: F4 */
    private int m2031F4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(((i + m2036f4(i2, i3, i4)) + i5) - 1894007588, i6);
    }

    private int FF1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(i + m2033f1(i2, i3, i4) + i5, i6);
    }

    private int FF2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(i + m2034f2(i2, i3, i4) + i5 + 1836072691, i6);
    }

    private int FF3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(i + m2035f3(i2, i3, i4) + i5 + 1548603684, i6);
    }

    private int FF4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m2032RL(i + m2036f4(i2, i3, i4) + i5 + 1352829926, i6);
    }

    /* JADX INFO: renamed from: RL */
    private int m2032RL(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    private void copyIn(RIPEMD256Digest rIPEMD256Digest) {
        super.copyIn((GeneralDigest) rIPEMD256Digest);
        this.f4238H0 = rIPEMD256Digest.f4238H0;
        this.f4239H1 = rIPEMD256Digest.f4239H1;
        this.f4240H2 = rIPEMD256Digest.f4240H2;
        this.f4241H3 = rIPEMD256Digest.f4241H3;
        this.f4242H4 = rIPEMD256Digest.f4242H4;
        this.f4243H5 = rIPEMD256Digest.f4243H5;
        this.f4244H6 = rIPEMD256Digest.f4244H6;
        this.f4245H7 = rIPEMD256Digest.f4245H7;
        int[] iArr = rIPEMD256Digest.f4246X;
        System.arraycopy(iArr, 0, this.f4246X, 0, iArr.length);
        this.xOff = rIPEMD256Digest.xOff;
    }

    /* JADX INFO: renamed from: f1 */
    private int m2033f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* JADX INFO: renamed from: f2 */
    private int m2034f2(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* JADX INFO: renamed from: f3 */
    private int m2035f3(int i, int i2, int i3) {
        return ((~i2) | i) ^ i3;
    }

    /* JADX INFO: renamed from: f4 */
    private int m2036f4(int i, int i2, int i3) {
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
        unpackWord(this.f4238H0, bArr, i);
        unpackWord(this.f4239H1, bArr, i + 4);
        unpackWord(this.f4240H2, bArr, i + 8);
        unpackWord(this.f4241H3, bArr, i + 12);
        unpackWord(this.f4242H4, bArr, i + 16);
        unpackWord(this.f4243H5, bArr, i + 20);
        unpackWord(this.f4244H6, bArr, i + 24);
        unpackWord(this.f4245H7, bArr, i + 28);
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
        int i = this.f4238H0;
        int i2 = this.f4239H1;
        int i3 = this.f4240H2;
        int i4 = this.f4241H3;
        int i5 = this.f4242H4;
        int i6 = this.f4243H5;
        int i7 = this.f4244H6;
        int i8 = this.f4245H7;
        int iM2028F1 = m2028F1(i, i2, i3, i4, this.f4246X[0], 11);
        int iM2028F2 = m2028F1(i4, iM2028F1, i2, i3, this.f4246X[1], 14);
        int iM2028F3 = m2028F1(i3, iM2028F2, iM2028F1, i2, this.f4246X[2], 15);
        int iM2028F4 = m2028F1(i2, iM2028F3, iM2028F2, iM2028F1, this.f4246X[3], 12);
        int iM2028F5 = m2028F1(iM2028F1, iM2028F4, iM2028F3, iM2028F2, this.f4246X[4], 5);
        int iM2028F6 = m2028F1(iM2028F2, iM2028F5, iM2028F4, iM2028F3, this.f4246X[5], 8);
        int iM2028F7 = m2028F1(iM2028F3, iM2028F6, iM2028F5, iM2028F4, this.f4246X[6], 7);
        int iM2028F8 = m2028F1(iM2028F4, iM2028F7, iM2028F6, iM2028F5, this.f4246X[7], 9);
        int iM2028F9 = m2028F1(iM2028F5, iM2028F8, iM2028F7, iM2028F6, this.f4246X[8], 11);
        int iM2028F10 = m2028F1(iM2028F6, iM2028F9, iM2028F8, iM2028F7, this.f4246X[9], 13);
        int iM2028F11 = m2028F1(iM2028F7, iM2028F10, iM2028F9, iM2028F8, this.f4246X[10], 14);
        int iM2028F12 = m2028F1(iM2028F8, iM2028F11, iM2028F10, iM2028F9, this.f4246X[11], 15);
        int iM2028F13 = m2028F1(iM2028F9, iM2028F12, iM2028F11, iM2028F10, this.f4246X[12], 6);
        int iM2028F14 = m2028F1(iM2028F10, iM2028F13, iM2028F12, iM2028F11, this.f4246X[13], 7);
        int iM2028F15 = m2028F1(iM2028F11, iM2028F14, iM2028F13, iM2028F12, this.f4246X[14], 9);
        int iM2028F16 = m2028F1(iM2028F12, iM2028F15, iM2028F14, iM2028F13, this.f4246X[15], 8);
        int iFF4 = FF4(i5, i6, i7, i8, this.f4246X[5], 8);
        int iFF5 = FF4(i8, iFF4, i6, i7, this.f4246X[14], 9);
        int iFF6 = FF4(i7, iFF5, iFF4, i6, this.f4246X[7], 9);
        int iFF7 = FF4(i6, iFF6, iFF5, iFF4, this.f4246X[0], 11);
        int iFF8 = FF4(iFF4, iFF7, iFF6, iFF5, this.f4246X[9], 13);
        int iFF9 = FF4(iFF5, iFF8, iFF7, iFF6, this.f4246X[2], 15);
        int iFF10 = FF4(iFF6, iFF9, iFF8, iFF7, this.f4246X[11], 15);
        int iFF11 = FF4(iFF7, iFF10, iFF9, iFF8, this.f4246X[4], 5);
        int iFF12 = FF4(iFF8, iFF11, iFF10, iFF9, this.f4246X[13], 7);
        int iFF13 = FF4(iFF9, iFF12, iFF11, iFF10, this.f4246X[6], 7);
        int iFF14 = FF4(iFF10, iFF13, iFF12, iFF11, this.f4246X[15], 8);
        int iFF15 = FF4(iFF11, iFF14, iFF13, iFF12, this.f4246X[8], 11);
        int iFF16 = FF4(iFF12, iFF15, iFF14, iFF13, this.f4246X[1], 14);
        int iFF17 = FF4(iFF13, iFF16, iFF15, iFF14, this.f4246X[10], 14);
        int iFF18 = FF4(iFF14, iFF17, iFF16, iFF15, this.f4246X[3], 12);
        int iFF19 = FF4(iFF15, iFF18, iFF17, iFF16, this.f4246X[12], 6);
        int iM2029F2 = m2029F2(iFF16, iM2028F16, iM2028F15, iM2028F14, this.f4246X[7], 7);
        int iM2029F3 = m2029F2(iM2028F14, iM2029F2, iM2028F16, iM2028F15, this.f4246X[4], 6);
        int iM2029F4 = m2029F2(iM2028F15, iM2029F3, iM2029F2, iM2028F16, this.f4246X[13], 8);
        int iM2029F5 = m2029F2(iM2028F16, iM2029F4, iM2029F3, iM2029F2, this.f4246X[1], 13);
        int iM2029F6 = m2029F2(iM2029F2, iM2029F5, iM2029F4, iM2029F3, this.f4246X[10], 11);
        int iM2029F7 = m2029F2(iM2029F3, iM2029F6, iM2029F5, iM2029F4, this.f4246X[6], 9);
        int iM2029F8 = m2029F2(iM2029F4, iM2029F7, iM2029F6, iM2029F5, this.f4246X[15], 7);
        int iM2029F9 = m2029F2(iM2029F5, iM2029F8, iM2029F7, iM2029F6, this.f4246X[3], 15);
        int iM2029F10 = m2029F2(iM2029F6, iM2029F9, iM2029F8, iM2029F7, this.f4246X[12], 7);
        int iM2029F11 = m2029F2(iM2029F7, iM2029F10, iM2029F9, iM2029F8, this.f4246X[0], 12);
        int iM2029F12 = m2029F2(iM2029F8, iM2029F11, iM2029F10, iM2029F9, this.f4246X[9], 15);
        int iM2029F13 = m2029F2(iM2029F9, iM2029F12, iM2029F11, iM2029F10, this.f4246X[5], 9);
        int iM2029F14 = m2029F2(iM2029F10, iM2029F13, iM2029F12, iM2029F11, this.f4246X[2], 11);
        int iM2029F15 = m2029F2(iM2029F11, iM2029F14, iM2029F13, iM2029F12, this.f4246X[14], 7);
        int iM2029F16 = m2029F2(iM2029F12, iM2029F15, iM2029F14, iM2029F13, this.f4246X[11], 13);
        int iM2029F17 = m2029F2(iM2029F13, iM2029F16, iM2029F15, iM2029F14, this.f4246X[8], 12);
        int iFF3 = FF3(iM2028F13, iFF19, iFF18, iFF17, this.f4246X[6], 9);
        int iFF20 = FF3(iFF17, iFF3, iFF19, iFF18, this.f4246X[11], 13);
        int iFF21 = FF3(iFF18, iFF20, iFF3, iFF19, this.f4246X[3], 15);
        int iFF22 = FF3(iFF19, iFF21, iFF20, iFF3, this.f4246X[7], 7);
        int iFF23 = FF3(iFF3, iFF22, iFF21, iFF20, this.f4246X[0], 12);
        int iFF24 = FF3(iFF20, iFF23, iFF22, iFF21, this.f4246X[13], 8);
        int iFF25 = FF3(iFF21, iFF24, iFF23, iFF22, this.f4246X[5], 9);
        int iFF26 = FF3(iFF22, iFF25, iFF24, iFF23, this.f4246X[10], 11);
        int iFF27 = FF3(iFF23, iFF26, iFF25, iFF24, this.f4246X[14], 7);
        int iFF28 = FF3(iFF24, iFF27, iFF26, iFF25, this.f4246X[15], 7);
        int iFF29 = FF3(iFF25, iFF28, iFF27, iFF26, this.f4246X[8], 12);
        int iFF30 = FF3(iFF26, iFF29, iFF28, iFF27, this.f4246X[12], 7);
        int iFF31 = FF3(iFF27, iFF30, iFF29, iFF28, this.f4246X[4], 6);
        int iFF32 = FF3(iFF28, iFF31, iFF30, iFF29, this.f4246X[9], 15);
        int iFF33 = FF3(iFF29, iFF32, iFF31, iFF30, this.f4246X[1], 13);
        int iFF34 = FF3(iFF30, iFF33, iFF32, iFF31, this.f4246X[2], 11);
        int iM2030F3 = m2030F3(iM2029F14, iFF34, iM2029F16, iM2029F15, this.f4246X[3], 11);
        int iM2030F4 = m2030F3(iM2029F15, iM2030F3, iFF34, iM2029F16, this.f4246X[10], 13);
        int iM2030F5 = m2030F3(iM2029F16, iM2030F4, iM2030F3, iFF34, this.f4246X[14], 6);
        int iM2030F6 = m2030F3(iFF34, iM2030F5, iM2030F4, iM2030F3, this.f4246X[4], 7);
        int iM2030F7 = m2030F3(iM2030F3, iM2030F6, iM2030F5, iM2030F4, this.f4246X[9], 14);
        int iM2030F8 = m2030F3(iM2030F4, iM2030F7, iM2030F6, iM2030F5, this.f4246X[15], 9);
        int iM2030F9 = m2030F3(iM2030F5, iM2030F8, iM2030F7, iM2030F6, this.f4246X[8], 13);
        int iM2030F10 = m2030F3(iM2030F6, iM2030F9, iM2030F8, iM2030F7, this.f4246X[1], 15);
        int iM2030F11 = m2030F3(iM2030F7, iM2030F10, iM2030F9, iM2030F8, this.f4246X[2], 14);
        int iM2030F12 = m2030F3(iM2030F8, iM2030F11, iM2030F10, iM2030F9, this.f4246X[7], 8);
        int iM2030F13 = m2030F3(iM2030F9, iM2030F12, iM2030F11, iM2030F10, this.f4246X[0], 13);
        int iM2030F14 = m2030F3(iM2030F10, iM2030F13, iM2030F12, iM2030F11, this.f4246X[6], 6);
        int iM2030F15 = m2030F3(iM2030F11, iM2030F14, iM2030F13, iM2030F12, this.f4246X[13], 5);
        int iM2030F16 = m2030F3(iM2030F12, iM2030F15, iM2030F14, iM2030F13, this.f4246X[11], 12);
        int iM2030F17 = m2030F3(iM2030F13, iM2030F16, iM2030F15, iM2030F14, this.f4246X[5], 7);
        int iM2030F18 = m2030F3(iM2030F14, iM2030F17, iM2030F16, iM2030F15, this.f4246X[12], 5);
        int iFF2 = FF2(iFF31, iM2029F17, iFF33, iFF32, this.f4246X[15], 9);
        int iFF35 = FF2(iFF32, iFF2, iM2029F17, iFF33, this.f4246X[5], 7);
        int iFF36 = FF2(iFF33, iFF35, iFF2, iM2029F17, this.f4246X[1], 15);
        int iFF37 = FF2(iM2029F17, iFF36, iFF35, iFF2, this.f4246X[3], 11);
        int iFF38 = FF2(iFF2, iFF37, iFF36, iFF35, this.f4246X[7], 8);
        int iFF39 = FF2(iFF35, iFF38, iFF37, iFF36, this.f4246X[14], 6);
        int iFF40 = FF2(iFF36, iFF39, iFF38, iFF37, this.f4246X[6], 6);
        int iFF41 = FF2(iFF37, iFF40, iFF39, iFF38, this.f4246X[9], 14);
        int iFF42 = FF2(iFF38, iFF41, iFF40, iFF39, this.f4246X[11], 12);
        int iFF43 = FF2(iFF39, iFF42, iFF41, iFF40, this.f4246X[8], 13);
        int iFF44 = FF2(iFF40, iFF43, iFF42, iFF41, this.f4246X[12], 5);
        int iFF45 = FF2(iFF41, iFF44, iFF43, iFF42, this.f4246X[2], 14);
        int iFF46 = FF2(iFF42, iFF45, iFF44, iFF43, this.f4246X[10], 13);
        int iFF47 = FF2(iFF43, iFF46, iFF45, iFF44, this.f4246X[0], 13);
        int iFF48 = FF2(iFF44, iFF47, iFF46, iFF45, this.f4246X[4], 7);
        int iFF49 = FF2(iFF45, iFF48, iFF47, iFF46, this.f4246X[13], 5);
        int iM2031F4 = m2031F4(iM2030F15, iM2030F18, iFF48, iM2030F16, this.f4246X[1], 11);
        int iM2031F5 = m2031F4(iM2030F16, iM2031F4, iM2030F18, iFF48, this.f4246X[9], 12);
        int iM2031F6 = m2031F4(iFF48, iM2031F5, iM2031F4, iM2030F18, this.f4246X[11], 14);
        int iM2031F7 = m2031F4(iM2030F18, iM2031F6, iM2031F5, iM2031F4, this.f4246X[10], 15);
        int iM2031F8 = m2031F4(iM2031F4, iM2031F7, iM2031F6, iM2031F5, this.f4246X[0], 14);
        int iM2031F9 = m2031F4(iM2031F5, iM2031F8, iM2031F7, iM2031F6, this.f4246X[8], 15);
        int iM2031F10 = m2031F4(iM2031F6, iM2031F9, iM2031F8, iM2031F7, this.f4246X[12], 9);
        int iM2031F11 = m2031F4(iM2031F7, iM2031F10, iM2031F9, iM2031F8, this.f4246X[4], 8);
        int iM2031F12 = m2031F4(iM2031F8, iM2031F11, iM2031F10, iM2031F9, this.f4246X[13], 9);
        int iM2031F13 = m2031F4(iM2031F9, iM2031F12, iM2031F11, iM2031F10, this.f4246X[3], 14);
        int iM2031F14 = m2031F4(iM2031F10, iM2031F13, iM2031F12, iM2031F11, this.f4246X[7], 5);
        int iM2031F15 = m2031F4(iM2031F11, iM2031F14, iM2031F13, iM2031F12, this.f4246X[15], 6);
        int iM2031F16 = m2031F4(iM2031F12, iM2031F15, iM2031F14, iM2031F13, this.f4246X[14], 8);
        int iM2031F17 = m2031F4(iM2031F13, iM2031F16, iM2031F15, iM2031F14, this.f4246X[5], 6);
        int iM2031F18 = m2031F4(iM2031F14, iM2031F17, iM2031F16, iM2031F15, this.f4246X[6], 5);
        int iM2031F19 = m2031F4(iM2031F15, iM2031F18, iM2031F17, iM2031F16, this.f4246X[2], 12);
        int iFF1 = FF1(iFF46, iFF49, iM2030F17, iFF47, this.f4246X[8], 15);
        int iFF50 = FF1(iFF47, iFF1, iFF49, iM2030F17, this.f4246X[6], 5);
        int iFF51 = FF1(iM2030F17, iFF50, iFF1, iFF49, this.f4246X[4], 8);
        int iFF52 = FF1(iFF49, iFF51, iFF50, iFF1, this.f4246X[1], 11);
        int iFF53 = FF1(iFF1, iFF52, iFF51, iFF50, this.f4246X[3], 14);
        int iFF54 = FF1(iFF50, iFF53, iFF52, iFF51, this.f4246X[11], 14);
        int iFF55 = FF1(iFF51, iFF54, iFF53, iFF52, this.f4246X[15], 6);
        int iFF56 = FF1(iFF52, iFF55, iFF54, iFF53, this.f4246X[0], 14);
        int iFF57 = FF1(iFF53, iFF56, iFF55, iFF54, this.f4246X[5], 6);
        int iFF58 = FF1(iFF54, iFF57, iFF56, iFF55, this.f4246X[12], 9);
        int iFF59 = FF1(iFF55, iFF58, iFF57, iFF56, this.f4246X[2], 12);
        int iFF60 = FF1(iFF56, iFF59, iFF58, iFF57, this.f4246X[13], 9);
        int iFF61 = FF1(iFF57, iFF60, iFF59, iFF58, this.f4246X[9], 12);
        int iFF62 = FF1(iFF58, iFF61, iFF60, iFF59, this.f4246X[7], 5);
        int iFF63 = FF1(iFF59, iFF62, iFF61, iFF60, this.f4246X[10], 15);
        int iFF64 = FF1(iFF60, iFF63, iFF62, iFF61, this.f4246X[14], 8);
        this.f4238H0 += iM2031F16;
        this.f4239H1 += iM2031F19;
        this.f4240H2 += iM2031F18;
        this.f4241H3 += iFF62;
        this.f4242H4 += iFF61;
        this.f4243H5 += iFF64;
        this.f4244H6 += iFF63;
        this.f4245H7 += iM2031F17;
        this.xOff = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.f4246X;
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
        int[] iArr = this.f4246X;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    protected void processWord(byte[] bArr, int i) {
        int[] iArr = this.f4246X;
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
        this.f4238H0 = 1732584193;
        this.f4239H1 = -271733879;
        this.f4240H2 = -1732584194;
        this.f4241H3 = 271733878;
        this.f4242H4 = 1985229328;
        this.f4243H5 = -19088744;
        this.f4244H6 = -1985229329;
        this.f4245H7 = 19088743;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f4246X;
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
