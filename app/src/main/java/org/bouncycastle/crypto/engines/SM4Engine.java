package org.bouncycastle.crypto.engines;

import com.fasterxml.jackson.dataformat.cbor.CBORConstants;
import com.google.common.base.Ascii;
import kotlin.p163io.encoding.Base64;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
public class SM4Engine implements BlockCipher {

    /* JADX INFO: renamed from: X */
    private final int[] f4397X = new int[4];

    /* JADX INFO: renamed from: rk */
    private int[] f4398rk;
    private static final byte[] Sbox = {-42, -112, -23, -2, -52, -31, Base64.padSymbol, -73, Ascii.SYN, -74, Ascii.DC4, CBORConstants.BYTE_TAG_BIGNUM_POS, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, CBORConstants.BYTE_TAG_BIGNUM_NEG, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, CBORConstants.BYTE_FALSE, -111, -17, -104, 122, 51, 84, Ascii.f3535VT, 67, -19, -49, -84, 98, -28, -77, Ascii.f3525FS, -87, -55, 8, -24, -107, -128, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, Ascii.ETB, -70, -125, 89, 60, Ascii.f3523EM, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, Ascii.f3531SI, 75, 112, 86, -99, 53, Ascii.f3530RS, 36, Ascii.f3532SO, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, CBORConstants.BYTE_STRING_1BYTE_LEN, -121, -44, 0, 70, 87, CBORConstants.BYTE_ARRAY_INDEFINITE, -45, 39, 82, 76, 54, 2, -25, -96, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, Ascii.NAK, -95, -32, -82, 93, -92, -101, 52, Ascii.SUB, 85, -83, -109, 50, 48, CBORConstants.BYTE_TRUE, -116, -79, -29, Ascii.f3526GS, -10, -30, 46, CBORConstants.BYTE_ARRAY_2_ELEMENTS, 102, -54, CBORConstants.BYTE_EMPTY_STRING, -64, 41, 35, -85, Ascii.f3522CR, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, Ascii.ESC, -81, -110, -69, -35, PSSSigner.TRAILER_IMPLICIT, 127, 17, -39, 92, 65, Ascii.f3534US, Ascii.DLE, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, Ascii.DC2, -72, -27, -76, -80, -119, 105, -105, 74, Ascii.f3524FF, -106, 119, 126, 101, -71, -15, 9, CBORConstants.BYTE_TAG_BIGFLOAT, 110, -58, -124, Ascii.CAN, -16, 125, -20, 58, -36, 77, 32, CBORConstants.BYTE_STRING_2BYTE_LEN, -18, 95, 62, -41, -53, 57, 72};

    /* JADX INFO: renamed from: CK */
    private static final int[] f4395CK = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    /* JADX INFO: renamed from: FK */
    private static final int[] f4396FK = {-1548633402, 1453994832, 1736282519, -1301273892};

    /* JADX INFO: renamed from: F0 */
    private int m2072F0(int[] iArr, int i) {
        return m2077T((iArr[3] ^ (iArr[1] ^ iArr[2])) ^ i) ^ iArr[0];
    }

    /* JADX INFO: renamed from: F1 */
    private int m2073F1(int[] iArr, int i) {
        return m2077T((iArr[0] ^ (iArr[2] ^ iArr[3])) ^ i) ^ iArr[1];
    }

    /* JADX INFO: renamed from: F2 */
    private int m2074F2(int[] iArr, int i) {
        return m2077T((iArr[1] ^ (iArr[3] ^ iArr[0])) ^ i) ^ iArr[2];
    }

    /* JADX INFO: renamed from: F3 */
    private int m2075F3(int[] iArr, int i) {
        return m2077T((iArr[2] ^ (iArr[0] ^ iArr[1])) ^ i) ^ iArr[3];
    }

    /* JADX INFO: renamed from: L */
    private int m2076L(int i) {
        return rotateLeft(i, 24) ^ (((rotateLeft(i, 2) ^ i) ^ rotateLeft(i, 10)) ^ rotateLeft(i, 18));
    }

    private int L_ap(int i) {
        return rotateLeft(i, 23) ^ (rotateLeft(i, 13) ^ i);
    }

    /* JADX INFO: renamed from: T */
    private int m2077T(int i) {
        return m2076L(tau(i));
    }

    private int T_ap(int i) {
        return L_ap(tau(i));
    }

    private int[] expandKey(boolean z, byte[] bArr) {
        int[] iArr = new int[32];
        int[] iArr2 = {Pack.bigEndianToInt(bArr, 0), Pack.bigEndianToInt(bArr, 4), Pack.bigEndianToInt(bArr, 8), Pack.bigEndianToInt(bArr, 12)};
        int i = iArr2[0];
        int[] iArr3 = f4396FK;
        int[] iArr4 = {i ^ iArr3[0], iArr2[1] ^ iArr3[1], iArr2[2] ^ iArr3[2], iArr2[3] ^ iArr3[3]};
        if (z) {
            int i2 = iArr4[0];
            int i3 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr5 = f4395CK;
            int iT_ap = i2 ^ T_ap(i3 ^ iArr5[0]);
            iArr[0] = iT_ap;
            int iT_ap2 = T_ap((iT_ap ^ (iArr4[2] ^ iArr4[3])) ^ iArr5[1]) ^ iArr4[1];
            iArr[1] = iT_ap2;
            int iT_ap3 = T_ap((iT_ap2 ^ (iArr4[3] ^ iArr[0])) ^ iArr5[2]) ^ iArr4[2];
            iArr[2] = iT_ap3;
            iArr[3] = T_ap((iT_ap3 ^ (iArr[0] ^ iArr[1])) ^ iArr5[3]) ^ iArr4[3];
            for (int i4 = 4; i4 < 32; i4++) {
                iArr[i4] = iArr[i4 - 4] ^ T_ap(((iArr[i4 - 3] ^ iArr[i4 - 2]) ^ iArr[i4 - 1]) ^ f4395CK[i4]);
            }
        } else {
            int i5 = iArr4[0];
            int i6 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr6 = f4395CK;
            int iT_ap4 = i5 ^ T_ap(i6 ^ iArr6[0]);
            iArr[31] = iT_ap4;
            int iT_ap5 = T_ap((iT_ap4 ^ (iArr4[2] ^ iArr4[3])) ^ iArr6[1]) ^ iArr4[1];
            iArr[30] = iT_ap5;
            int iT_ap6 = T_ap((iT_ap5 ^ (iArr4[3] ^ iArr[31])) ^ iArr6[2]) ^ iArr4[2];
            iArr[29] = iT_ap6;
            iArr[28] = T_ap((iT_ap6 ^ (iArr[31] ^ iArr[30])) ^ iArr6[3]) ^ iArr4[3];
            for (int i7 = 27; i7 >= 0; i7--) {
                iArr[i7] = iArr[i7 + 4] ^ T_ap(((iArr[i7 + 3] ^ iArr[i7 + 2]) ^ iArr[i7 + 1]) ^ f4395CK[31 - i7]);
            }
        }
        return iArr;
    }

    private int rotateLeft(int i, int i2) {
        return (i << i2) | (i >>> (-i2));
    }

    private int tau(int i) {
        byte[] bArr = Sbox;
        return (bArr[i & 255] & 255) | ((bArr[(i >> 24) & 255] & 255) << 24) | ((bArr[(i >> 16) & 255] & 255) << 16) | ((bArr[(i >> 8) & 255] & 255) << 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "SM4";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to SM4 init - " + cipherParameters.getClass().getName());
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length != 16) {
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        this.f4398rk = expandKey(z, key);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        if (this.f4398rk == null) {
            throw new IllegalStateException("SM4 not initialised");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f4397X[0] = Pack.bigEndianToInt(bArr, i);
        this.f4397X[1] = Pack.bigEndianToInt(bArr, i + 4);
        this.f4397X[2] = Pack.bigEndianToInt(bArr, i + 8);
        this.f4397X[3] = Pack.bigEndianToInt(bArr, i + 12);
        for (int i3 = 0; i3 < 32; i3 += 4) {
            int[] iArr = this.f4397X;
            iArr[0] = m2072F0(iArr, this.f4398rk[i3]);
            int[] iArr2 = this.f4397X;
            iArr2[1] = m2073F1(iArr2, this.f4398rk[i3 + 1]);
            int[] iArr3 = this.f4397X;
            iArr3[2] = m2074F2(iArr3, this.f4398rk[i3 + 2]);
            int[] iArr4 = this.f4397X;
            iArr4[3] = m2075F3(iArr4, this.f4398rk[i3 + 3]);
        }
        Pack.intToBigEndian(this.f4397X[3], bArr2, i2);
        Pack.intToBigEndian(this.f4397X[2], bArr2, i2 + 4);
        Pack.intToBigEndian(this.f4397X[1], bArr2, i2 + 8);
        Pack.intToBigEndian(this.f4397X[0], bArr2, i2 + 12);
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
