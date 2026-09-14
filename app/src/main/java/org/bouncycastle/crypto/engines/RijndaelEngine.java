package org.bouncycastle.crypto.engines;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.contentsquare.android.api.Currencies;
import com.facebook.imageutils.JfifUtil;
import com.fasterxml.jackson.dataformat.cbor.CBORConstants;
import com.google.common.base.Ascii;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import java.lang.reflect.Array;
import kotlin.p163io.encoding.Base64;
import okio.Utf8;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes6.dex */
public class RijndaelEngine implements BlockCipher {

    /* JADX INFO: renamed from: A0 */
    private long f4389A0;

    /* JADX INFO: renamed from: A1 */
    private long f4390A1;

    /* JADX INFO: renamed from: A2 */
    private long f4391A2;

    /* JADX INFO: renamed from: A3 */
    private long f4392A3;

    /* JADX INFO: renamed from: BC */
    private int f4393BC;
    private long BC_MASK;
    private int ROUNDS;
    private int blockBits;
    private boolean forEncryption;
    private byte[] shifts0SC;
    private byte[] shifts1SC;
    private long[][] workingKey;
    private static final byte[] logtable = {0, 0, Ascii.f3523EM, 1, 50, 2, Ascii.SUB, -58, 75, -57, Ascii.ESC, 104, 51, -18, -33, 3, 100, 4, -32, Ascii.f3532SO, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, Ascii.f3525FS, -63, 125, CBORConstants.BYTE_TAG_BIGNUM_POS, Ascii.f3526GS, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, CBORConstants.BYTE_STRING_1BYTE_LEN, 101, 47, -118, 5, 33, Ascii.f3531SI, -31, 36, Ascii.DC2, -16, CBORConstants.BYTE_ARRAY_2_ELEMENTS, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, 64, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, Ascii.DLE, 126, 110, 72, CBORConstants.BYTE_TAG_BIGNUM_NEG, -93, -74, Ascii.f3530RS, 66, 58, 107, 40, 84, -6, -123, Base64.padSymbol, -70, 43, CBORConstants.BYTE_STRING_2BYTE_LEN, 10, Ascii.NAK, -101, CBORConstants.BYTE_ARRAY_INDEFINITE, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, CBORConstants.BYTE_FALSE, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, Ascii.SYN, Ascii.f3535VT, CBORConstants.BYTE_TRUE, 89, -53, 95, -80, -100, -87, 81, -96, 127, Ascii.f3524FF, -10, 111, Ascii.ETB, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, 73, -20, -40, 67, Ascii.f3534US, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, CBORConstants.BYTE_EMPTY_STRING, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, Utf8.REPLACEMENT_BYTE, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, Ascii.DC4, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, CBORConstants.BYTE_TAG_BIGFLOAT, 49, -2, Ascii.CAN, Ascii.f3522CR, 99, -116, -128, -64, -9, 112, 7};
    private static final byte[] aLogtable = {0, 3, 5, Ascii.f3531SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.f3530RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, CBORConstants.BYTE_TRUE, 4, Ascii.f3524FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, CBORConstants.BYTE_STRING_1BYTE_LEN, -120, -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, -77, -50, 73, -37, 118, -102, -75, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, 87, -7, Ascii.DLE, 48, 80, -16, Ascii.f3535VT, Ascii.f3526GS, 39, 105, -69, -42, 97, -93, -2, Ascii.f3523EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, CBORConstants.BYTE_EMPTY_STRING, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, CBORConstants.BYTE_TAG_BIGNUM_POS, 93, -25, 50, 86, -6, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 65, CBORConstants.BYTE_TAG_BIGNUM_NEG, 94, -30, Base64.padSymbol, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, CBORConstants.BYTE_ARRAY_INDEFINITE, -70, -43, 100, -84, -17, 42, 126, CBORConstants.BYTE_ARRAY_2_ELEMENTS, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, -128, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, CBORConstants.BYTE_TAG_BIGFLOAT, 84, -4, Ascii.f3534US, 33, 99, -91, CBORConstants.BYTE_FALSE, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, CBORConstants.BYTE_STRING_2BYTE_LEN, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.f3532SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.f3522CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.f3525FS, 36, 108, -76, -57, 82, -10, 1, 3, 5, Ascii.f3531SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.f3530RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, CBORConstants.BYTE_TRUE, 4, Ascii.f3524FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, CBORConstants.BYTE_STRING_1BYTE_LEN, -120, -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, -77, -50, 73, -37, 118, -102, -75, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, 87, -7, Ascii.DLE, 48, 80, -16, Ascii.f3535VT, Ascii.f3526GS, 39, 105, -69, -42, 97, -93, -2, Ascii.f3523EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, CBORConstants.BYTE_EMPTY_STRING, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, CBORConstants.BYTE_TAG_BIGNUM_POS, 93, -25, 50, 86, -6, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 65, CBORConstants.BYTE_TAG_BIGNUM_NEG, 94, -30, Base64.padSymbol, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, CBORConstants.BYTE_ARRAY_INDEFINITE, -70, -43, 100, -84, -17, 42, 126, CBORConstants.BYTE_ARRAY_2_ELEMENTS, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, -128, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, CBORConstants.BYTE_TAG_BIGFLOAT, 84, -4, Ascii.f3534US, 33, 99, -91, CBORConstants.BYTE_FALSE, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, CBORConstants.BYTE_STRING_2BYTE_LEN, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.f3532SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.f3522CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.f3525FS, 36, 108, -76, -57, 82, -10, 1};

    /* JADX INFO: renamed from: S */
    private static final byte[] f4387S = {99, 124, 119, 123, -14, 107, 111, CBORConstants.BYTE_TAG_BIGFLOAT, 48, 1, 103, 43, -2, -41, -85, 118, -54, CBORConstants.BYTE_ARRAY_2_ELEMENTS, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, CBORConstants.BYTE_TAG_BIGNUM_NEG, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, -128, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, 80, 60, CBORConstants.BYTE_ARRAY_INDEFINITE, -88, 81, -93, 64, -113, -110, -99, 56, CBORConstants.BYTE_TRUE, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Ascii.DLE, -1, -13, -46, -51, Ascii.f3524FF, 19, -20, 95, -105, 68, Ascii.ETB, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, -89, 126, Base64.padSymbol, 100, 93, Ascii.f3523EM, 115, CBORConstants.BYTE_EMPTY_STRING, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.f3535VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, CBORConstants.BYTE_TAG_BIGNUM_POS, -45, -84, 98, -111, -107, -28, CBORConstants.BYTE_STRING_2BYTE_LEN, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, CBORConstants.BYTE_FALSE, -22, 101, 122, -82, 8, -70, CBORConstants.BYTE_STRING_1BYTE_LEN, 37, 46, Ascii.f3525FS, -90, -76, -58, -24, -35, 116, Ascii.f3534US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.f3532SO, 97, 53, 87, -71, -122, -63, Ascii.f3526GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.f3530RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.f3522CR, -65, -26, 66, 104, 65, -103, 45, Ascii.f3531SI, -80, 84, -69, Ascii.SYN};

    /* JADX INFO: renamed from: Si */
    private static final byte[] f4388Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, CBORConstants.BYTE_ARRAY_2_ELEMENTS, -101, 47, -1, -121, 52, -114, 67, 68, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, -34, -23, -53, 84, 123, -108, 50, -90, CBORConstants.BYTE_TAG_BIGNUM_POS, 35, Base64.padSymbol, -18, 76, -107, Ascii.f3535VT, 66, -6, CBORConstants.BYTE_TAG_BIGNUM_NEG, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.f3530RS, -113, -54, Utf8.REPLACEMENT_BYTE, Ascii.f3531SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.f3525FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.f3526GS, 41, CBORConstants.BYTE_TAG_BIGFLOAT, -119, 111, -73, 98, Ascii.f3532SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, CBORConstants.BYTE_STRING_2BYTE_LEN, 32, -102, -37, -64, -2, CBORConstants.BYTE_STRING_1BYTE_LEN, -51, 90, CBORConstants.BYTE_FALSE, Ascii.f3534US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, Ascii.DLE, 89, 39, -128, -20, 95, CBORConstants.BYTE_EMPTY_STRING, 81, 127, -87, Ascii.f3523EM, -75, 74, Ascii.f3522CR, 45, -27, 122, CBORConstants.BYTE_ARRAY_INDEFINITE, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, CBORConstants.BYTE_TRUE, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.f3524FF, 125};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, JfifUtil.MARKER_SOI, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, PublicKeyAlgorithmTags.EXPERIMENTAL_7, 212, 179, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 239, 197, 145};
    static byte[][] shifts0 = {new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, 32}, new byte[]{0, 8, Ascii.CAN, 32}};
    static byte[][] shifts1 = {new byte[]{0, Ascii.CAN, Ascii.DLE, 8}, new byte[]{0, 32, Ascii.CAN, Ascii.DLE}, new byte[]{0, 40, 32, Ascii.CAN}, new byte[]{0, 48, 40, Ascii.CAN}, new byte[]{0, 56, 40, 32}};

    public RijndaelEngine() {
        this(128);
    }

    public RijndaelEngine(int i) {
        if (i == 128) {
            this.f4393BC = 32;
            this.BC_MASK = BodyPartID.bodyIdMax;
            this.shifts0SC = shifts0[0];
            this.shifts1SC = shifts1[0];
        } else if (i == 160) {
            this.f4393BC = 40;
            this.BC_MASK = 1099511627775L;
            this.shifts0SC = shifts0[1];
            this.shifts1SC = shifts1[1];
        } else if (i == 192) {
            this.f4393BC = 48;
            this.BC_MASK = 281474976710655L;
            this.shifts0SC = shifts0[2];
            this.shifts1SC = shifts1[2];
        } else if (i == 224) {
            this.f4393BC = 56;
            this.BC_MASK = 72057594037927935L;
            this.shifts0SC = shifts0[3];
            this.shifts1SC = shifts1[3];
        } else {
            if (i != 256) {
                throw new IllegalArgumentException("unknown blocksize to Rijndael");
            }
            this.f4393BC = 64;
            this.BC_MASK = -1L;
            this.shifts0SC = shifts0[4];
            this.shifts1SC = shifts1[4];
        }
        this.blockBits = i;
    }

    private void InvMixColumn() {
        long jMul0xe = 0;
        long jMul0xe2 = 0;
        long jMul0xe3 = 0;
        long jMul0xe4 = 0;
        for (int i = 0; i < this.f4393BC; i += 8) {
            int i2 = (int) ((this.f4389A0 >> i) & 255);
            int i3 = (int) ((this.f4390A1 >> i) & 255);
            int i4 = (int) ((this.f4391A2 >> i) & 255);
            long j = jMul0xe3;
            int i5 = (int) ((this.f4392A3 >> i) & 255);
            int i6 = -1;
            int i7 = i2 != 0 ? logtable[i2 & 255] & 255 : -1;
            int i8 = i3 != 0 ? logtable[i3 & 255] & 255 : -1;
            int i9 = i4 != 0 ? logtable[i4 & 255] & 255 : -1;
            if (i5 != 0) {
                i6 = logtable[i5 & 255] & 255;
            }
            jMul0xe |= ((long) ((((mul0xe(i7) ^ mul0xb(i8)) ^ mul0xd(i9)) ^ mul0x9(i6)) & 255)) << i;
            jMul0xe4 |= ((long) ((((mul0xe(i8) ^ mul0xb(i9)) ^ mul0xd(i6)) ^ mul0x9(i7)) & 255)) << i;
            jMul0xe2 |= ((long) ((((mul0xe(i9) ^ mul0xb(i6)) ^ mul0xd(i7)) ^ mul0x9(i8)) & 255)) << i;
            jMul0xe3 = (((long) ((((mul0xe(i6) ^ mul0xb(i7)) ^ mul0xd(i8)) ^ mul0x9(i9)) & 255)) << i) | j;
        }
        this.f4389A0 = jMul0xe;
        this.f4390A1 = jMul0xe4;
        this.f4391A2 = jMul0xe2;
        this.f4392A3 = jMul0xe3;
    }

    private void KeyAddition(long[] jArr) {
        this.f4389A0 ^= jArr[0];
        this.f4390A1 ^= jArr[1];
        this.f4391A2 ^= jArr[2];
        this.f4392A3 ^= jArr[3];
    }

    private void MixColumn() {
        long jMul0x2 = 0;
        long jMul0x3 = 0;
        long jMul0x4 = 0;
        long jMul0x5 = 0;
        for (int i = 0; i < this.f4393BC; i += 8) {
            int i2 = (int) ((this.f4389A0 >> i) & 255);
            int i3 = (int) ((this.f4390A1 >> i) & 255);
            int i4 = (int) ((this.f4391A2 >> i) & 255);
            long j = jMul0x4;
            int i5 = (int) ((this.f4392A3 >> i) & 255);
            jMul0x2 |= ((long) ((((mul0x2(i2) ^ mul0x3(i3)) ^ i4) ^ i5) & 255)) << i;
            jMul0x5 |= ((long) ((((mul0x2(i3) ^ mul0x3(i4)) ^ i5) ^ i2) & 255)) << i;
            jMul0x3 |= ((long) ((((mul0x2(i4) ^ mul0x3(i5)) ^ i2) ^ i3) & 255)) << i;
            jMul0x4 = (((long) ((((mul0x2(i5) ^ mul0x3(i2)) ^ i3) ^ i4) & 255)) << i) | j;
        }
        this.f4389A0 = jMul0x2;
        this.f4390A1 = jMul0x5;
        this.f4391A2 = jMul0x3;
        this.f4392A3 = jMul0x4;
    }

    private void ShiftRow(byte[] bArr) {
        this.f4390A1 = shift(this.f4390A1, bArr[1]);
        this.f4391A2 = shift(this.f4391A2, bArr[2]);
        this.f4392A3 = shift(this.f4392A3, bArr[3]);
    }

    private void Substitution(byte[] bArr) {
        this.f4389A0 = applyS(this.f4389A0, bArr);
        this.f4390A1 = applyS(this.f4390A1, bArr);
        this.f4391A2 = applyS(this.f4391A2, bArr);
        this.f4392A3 = applyS(this.f4392A3, bArr);
    }

    private long applyS(long j, byte[] bArr) {
        long j2 = 0;
        for (int i = 0; i < this.f4393BC; i += 8) {
            j2 |= ((long) (bArr[(int) ((j >> i) & 255)] & 255)) << i;
        }
        return j2;
    }

    private void decryptBlock(long[][] jArr) {
        KeyAddition(jArr[this.ROUNDS]);
        Substitution(f4388Si);
        ShiftRow(this.shifts1SC);
        for (int i = this.ROUNDS - 1; i > 0; i--) {
            KeyAddition(jArr[i]);
            InvMixColumn();
            Substitution(f4388Si);
            ShiftRow(this.shifts1SC);
        }
        KeyAddition(jArr[0]);
    }

    private void encryptBlock(long[][] jArr) {
        KeyAddition(jArr[0]);
        for (int i = 1; i < this.ROUNDS; i++) {
            Substitution(f4387S);
            ShiftRow(this.shifts0SC);
            MixColumn();
            KeyAddition(jArr[i]);
        }
        Substitution(f4387S);
        ShiftRow(this.shifts0SC);
        KeyAddition(jArr[this.ROUNDS]);
    }

    private long[][] generateWorkingKey(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4 = 8;
        int length = bArr.length * 8;
        int i5 = 1;
        int i6 = 0;
        int i7 = 4;
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 64);
        long[][] jArr = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 15, 4);
        if (length == 128) {
            i = 4;
        } else if (length == 160) {
            i = 5;
        } else if (length == 192) {
            i = 6;
        } else if (length == 224) {
            i = 7;
        } else {
            if (length != 256) {
                throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
            }
            i = 8;
        }
        this.ROUNDS = length >= this.blockBits ? i + 6 : (this.f4393BC / 8) + 6;
        int i8 = 0;
        int i9 = 0;
        while (i8 < bArr.length) {
            bArr2[i8 % 4][i8 / 4] = bArr[i9];
            i8++;
            i9++;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < i && i11 < (this.ROUNDS + 1) * (this.f4393BC / 8)) {
            int i12 = i6;
            while (i12 < i7) {
                int i13 = this.f4393BC;
                long[] jArr2 = jArr[i11 / (i13 / 8)];
                jArr2[i12] = (((long) (bArr2[i12][i10] & 255)) << ((i11 * 8) % i13)) | jArr2[i12];
                i12++;
                i7 = 4;
            }
            i10++;
            i11++;
            i6 = 0;
            i7 = 4;
        }
        int i14 = 0;
        while (i11 < (this.ROUNDS + i5) * (this.f4393BC / i4)) {
            int i15 = 0;
            for (int i16 = 4; i15 < i16; i16 = 4) {
                byte[] bArr3 = bArr2[i15];
                i15++;
                bArr3[0] = (byte) (f4387S[bArr2[i15 % 4][i - 1] & 255] ^ bArr3[0]);
            }
            byte[] bArr4 = bArr2[0];
            int i17 = i14 + 1;
            bArr4[0] = (byte) (rcon[i14] ^ bArr4[0]);
            if (i <= 6) {
                for (int i18 = i5; i18 < i; i18++) {
                    for (int i19 = 0; i19 < 4; i19++) {
                        byte[] bArr5 = bArr2[i19];
                        bArr5[i18] = (byte) (bArr5[i18] ^ bArr5[i18 - 1]);
                    }
                }
            } else {
                int i20 = i5;
                while (true) {
                    i2 = 4;
                    i3 = 0;
                    if (i20 >= 4) {
                        break;
                    }
                    while (i3 < i2) {
                        byte[] bArr6 = bArr2[i3];
                        bArr6[i20] = (byte) (bArr6[i20] ^ bArr6[i20 - 1]);
                        i3++;
                        i2 = 4;
                    }
                    i20++;
                }
                while (i3 < 4) {
                    byte[] bArr7 = bArr2[i3];
                    bArr7[4] = (byte) (bArr7[4] ^ f4387S[bArr7[3] & 255]);
                    i3++;
                }
                int i21 = 5;
                while (i21 < i) {
                    int i22 = 0;
                    while (i22 < i2) {
                        byte[] bArr8 = bArr2[i22];
                        bArr8[i21] = (byte) (bArr8[i21] ^ bArr8[i21 - 1]);
                        i22++;
                        i2 = 4;
                    }
                    i21++;
                    i2 = 4;
                }
            }
            int i23 = 0;
            while (i23 < i && i11 < (this.ROUNDS + i5) * (this.f4393BC / i4)) {
                for (int i24 = 0; i24 < 4; i24++) {
                    int i25 = this.f4393BC;
                    long[] jArr3 = jArr[i11 / (i25 / 8)];
                    jArr3[i24] = (((long) (bArr2[i24][i23] & 255)) << ((i11 * 8) % i25)) | jArr3[i24];
                }
                i23++;
                i11++;
                i4 = 8;
                i5 = 1;
            }
            i14 = i17;
            i4 = 8;
            i5 = 1;
        }
        return jArr;
    }

    private byte mul0x2(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & 255) + 25];
        }
        return (byte) 0;
    }

    private byte mul0x3(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & 255) + 1];
        }
        return (byte) 0;
    }

    private byte mul0x9(int i) {
        if (i >= 0) {
            return aLogtable[i + 199];
        }
        return (byte) 0;
    }

    private byte mul0xb(int i) {
        if (i >= 0) {
            return aLogtable[i + 104];
        }
        return (byte) 0;
    }

    private byte mul0xd(int i) {
        if (i >= 0) {
            return aLogtable[i + Currencies.FKP];
        }
        return (byte) 0;
    }

    private byte mul0xe(int i) {
        if (i >= 0) {
            return aLogtable[i + 223];
        }
        return (byte) 0;
    }

    private void packBlock(byte[] bArr, int i) {
        for (int i2 = 0; i2 != this.f4393BC; i2 += 8) {
            bArr[i] = (byte) (this.f4389A0 >> i2);
            bArr[i + 1] = (byte) (this.f4390A1 >> i2);
            int i3 = i + 3;
            bArr[i + 2] = (byte) (this.f4391A2 >> i2);
            i += 4;
            bArr[i3] = (byte) (this.f4392A3 >> i2);
        }
    }

    private long shift(long j, int i) {
        return ((j << (this.f4393BC - i)) | (j >>> i)) & this.BC_MASK;
    }

    private void unpackBlock(byte[] bArr, int i) {
        this.f4389A0 = bArr[i] & 255;
        this.f4390A1 = bArr[i + 1] & 255;
        int i2 = i + 3;
        this.f4391A2 = bArr[i + 2] & 255;
        int i3 = i + 4;
        this.f4392A3 = bArr[i2] & 255;
        for (int i4 = 8; i4 != this.f4393BC; i4 += 8) {
            this.f4389A0 |= ((long) (bArr[i3] & 255)) << i4;
            this.f4390A1 |= ((long) (bArr[i3 + 1] & 255)) << i4;
            int i5 = i3 + 3;
            this.f4391A2 |= ((long) (bArr[i3 + 2] & 255)) << i4;
            i3 += 4;
            this.f4392A3 |= ((long) (bArr[i5] & 255)) << i4;
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Rijndael";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.f4393BC / 2;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
            this.forEncryption = z;
        } else {
            throw new IllegalArgumentException("invalid parameter passed to Rijndael init - " + cipherParameters.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
        int i3 = this.f4393BC;
        if ((i3 / 2) + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if ((i3 / 2) + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        boolean z = this.forEncryption;
        unpackBlock(bArr, i);
        long[][] jArr = this.workingKey;
        if (z) {
            encryptBlock(jArr);
        } else {
            decryptBlock(jArr);
        }
        packBlock(bArr2, i2);
        return this.f4393BC / 2;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
