package org.apache.commons.lang3;

import java.util.UUID;
import kotlin.UShort;
import net.zetetic.database.DatabaseUtils;
import okhttp3.internal.p166ws.WebSocketProtocol;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: loaded from: classes6.dex */
public class Conversion {
    private static final boolean[] TTTT = {true, true, true, true};
    private static final boolean[] FTTT = {false, true, true, true};
    private static final boolean[] TFTT = {true, false, true, true};
    private static final boolean[] FFTT = {false, false, true, true};
    private static final boolean[] TTFT = {true, true, false, true};
    private static final boolean[] FTFT = {false, true, false, true};
    private static final boolean[] TFFT = {true, false, false, true};
    private static final boolean[] FFFT = {false, false, false, true};
    private static final boolean[] TTTF = {true, true, true, false};
    private static final boolean[] FTTF = {false, true, true, false};
    private static final boolean[] TFTF = {true, false, true, false};
    private static final boolean[] FFTF = {false, false, true, false};
    private static final boolean[] TTFF = {true, true, false, false};
    private static final boolean[] FTFF = {false, true, false, false};
    private static final boolean[] TFFF = {true, false, false, false};
    private static final boolean[] FFFF = {false, false, false, false};

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        return binaryBeMsb0ToHexDigit(zArr, 0);
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i) {
        if (Integer.compareUnsigned(i, zArr.length) >= 0) {
            if (zArr.length == 0) {
                throw new IllegalArgumentException("Cannot convert an empty array.");
            }
            throw new IndexOutOfBoundsException(i + " is not within array length " + zArr.length);
        }
        int length = (zArr.length - 1) - i;
        if (3 <= length && zArr[length - 3]) {
            if (zArr[length - 2]) {
                if (zArr[length - 1]) {
                    return zArr[length] ? 'f' : 'e';
                }
                return zArr[length] ? 'd' : 'c';
            }
            if (zArr[length - 1]) {
                return zArr[length] ? 'b' : 'a';
            }
            return zArr[length] ? '9' : '8';
        }
        if (2 <= length && zArr[length - 2]) {
            if (zArr[length - 1]) {
                return zArr[length] ? '7' : '6';
            }
            return zArr[length] ? '5' : '4';
        }
        if (1 > length || !zArr[length - 1]) {
            return zArr[length] ? '1' : '0';
        }
        return zArr[length] ? '3' : '2';
    }

    public static byte binaryToByte(boolean[] zArr, int i, byte b, int i2, int i3) {
        if ((zArr.length == 0 && i == 0) || i3 == 0) {
            return b;
        }
        if ((i3 - 1) + i2 >= 8) {
            throw new IllegalArgumentException("nBools - 1 + dstPos >= 8");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 + i2;
            b = (byte) ((b & (~(1 << i5))) | ((zArr[i4 + i] ? 1 : 0) << i5));
        }
        return b;
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        return binaryToHexDigit(zArr, 0);
    }

    public static char binaryToHexDigit(boolean[] zArr, int i) {
        if (zArr.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int i2 = i + 3;
        if (zArr.length > i2 && zArr[i2]) {
            if (zArr[i + 2]) {
                if (zArr[i + 1]) {
                    return zArr[i] ? 'f' : 'e';
                }
                return zArr[i] ? 'd' : 'c';
            }
            if (zArr[i + 1]) {
                return zArr[i] ? 'b' : 'a';
            }
            return zArr[i] ? '9' : '8';
        }
        int i3 = i + 2;
        if (zArr.length > i3 && zArr[i3]) {
            if (zArr[i + 1]) {
                return zArr[i] ? '7' : '6';
            }
            return zArr[i] ? '5' : '4';
        }
        int i4 = i + 1;
        if (zArr.length <= i4 || !zArr[i4]) {
            return zArr[i] ? '1' : '0';
        }
        return zArr[i] ? '3' : '2';
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        return binaryToHexDigitMsb0_4bits(zArr, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i) {
        if (zArr.length > 8) {
            throw new IllegalArgumentException("src.length > 8: src.length=" + zArr.length);
        }
        if (zArr.length - i < 4) {
            throw new IllegalArgumentException("src.length - srcPos < 4: src.length=" + zArr.length + ", srcPos=" + i);
        }
        if (zArr[i + 3]) {
            if (zArr[i + 2]) {
                if (zArr[i + 1]) {
                    return zArr[i] ? 'f' : '7';
                }
                return zArr[i] ? 'b' : '3';
            }
            if (zArr[i + 1]) {
                return zArr[i] ? 'd' : '5';
            }
            return zArr[i] ? '9' : '1';
        }
        if (zArr[i + 2]) {
            if (zArr[i + 1]) {
                return zArr[i] ? 'e' : '6';
            }
            return zArr[i] ? 'a' : '2';
        }
        if (zArr[i + 1]) {
            return zArr[i] ? 'c' : '4';
        }
        return zArr[i] ? '8' : '0';
    }

    public static int binaryToInt(boolean[] zArr, int i, int i2, int i3, int i4) {
        if ((zArr.length == 0 && i == 0) || i4 == 0) {
            return i2;
        }
        if ((i4 - 1) + i3 >= 32) {
            throw new IllegalArgumentException("nBools - 1 + dstPos >= 32");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i3;
            i2 = (i2 & (~(1 << i6))) | ((zArr[i5 + i] ? 1 : 0) << i6);
        }
        return i2;
    }

    public static long binaryToLong(boolean[] zArr, int i, long j, int i2, int i3) {
        if ((zArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if ((i3 - 1) + i2 >= 64) {
            throw new IllegalArgumentException("nBools - 1 + dstPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 + i2;
            j = (j & (~(1 << i5))) | ((zArr[i4 + i] ? 1L : 0L) << i5);
        }
        return j;
    }

    public static short binaryToShort(boolean[] zArr, int i, short s, int i2, int i3) {
        if ((zArr.length == 0 && i == 0) || i3 == 0) {
            return s;
        }
        if ((i3 - 1) + i2 >= 16) {
            throw new IllegalArgumentException("nBools - 1 + dstPos >= 16");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 + i2;
            s = (short) ((s & (~(1 << i5))) | ((zArr[i4 + i] ? 1 : 0) << i5));
        }
        return s;
    }

    public static int byteArrayToInt(byte[] bArr, int i, int i2, int i3, int i4) {
        if ((bArr.length == 0 && i == 0) || i4 == 0) {
            return i2;
        }
        if (((i4 - 1) * 8) + i3 >= 32) {
            throw new IllegalArgumentException("(nBytes - 1) * 8 + dstPos >= 32");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 8) + i3;
            i2 = (i2 & (~(255 << i6))) | ((bArr[i5 + i] & 255) << i6);
        }
        return i2;
    }

    public static long byteArrayToLong(byte[] bArr, int i, long j, int i2, int i3) {
        if ((bArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 8) + i2 >= 64) {
            throw new IllegalArgumentException("(nBytes - 1) * 8 + dstPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 8) + i2;
            j = (j & (~(255 << i5))) | ((((long) bArr[i4 + i]) & 255) << i5);
        }
        return j;
    }

    public static short byteArrayToShort(byte[] bArr, int i, short s, int i2, int i3) {
        if ((bArr.length == 0 && i == 0) || i3 == 0) {
            return s;
        }
        if (((i3 - 1) * 8) + i2 >= 16) {
            throw new IllegalArgumentException("(nBytes - 1) * 8 + dstPos >= 16");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 8) + i2;
            s = (short) ((s & (~(255 << i5))) | ((bArr[i4 + i] & 255) << i5));
        }
        return s;
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i) {
        if (bArr.length - i < 16) {
            throw new IllegalArgumentException("Need at least 16 bytes for UUID");
        }
        return new UUID(byteArrayToLong(bArr, i, 0L, 0, 8), byteArrayToLong(bArr, i + 8, 0L, 0, 8));
    }

    public static boolean[] byteToBinary(byte b, int i, boolean[] zArr, int i2, int i3) {
        if (i3 == 0) {
            return zArr;
        }
        if ((i3 - 1) + i >= 8) {
            throw new IllegalArgumentException("nBools -  1 + srcPos >= 8");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 + i4;
            boolean z = true;
            if (((b >> (i4 + i)) & 1) == 0) {
                z = false;
            }
            zArr[i5] = z;
        }
        return zArr;
    }

    public static String byteToHex(byte b, int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return str;
        }
        if (((i3 - 1) * 4) + i >= 8) {
            throw new IllegalArgumentException("(nHexs - 1) * 4 + srcPos >= 8");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (b >> ((i4 * 4) + i)) & 15;
            int i6 = i2 + i4;
            if (i6 == length) {
                length++;
                sb.append(intToHexDigit(i5));
            } else {
                sb.setCharAt(i6, intToHexDigit(i5));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    /* JADX WARN: Code duplicated, block: B:13:0x0040  */
    /* JADX WARN: Code duplicated, block: B:15:0x0049  */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    public static boolean[] hexDigitMsb0ToBinary(char c) {
        switch (c) {
            case '0':
                return (boolean[]) FFFF.clone();
            case '1':
                return (boolean[]) FFFT.clone();
            case '2':
                return (boolean[]) FFTF.clone();
            case '3':
                return (boolean[]) FFTT.clone();
            case '4':
                return (boolean[]) FTFF.clone();
            case EACTags.SEX /* 53 */:
                return (boolean[]) FTFT.clone();
            case EACTags.CURRENCY_EXPONENT /* 54 */:
                return (boolean[]) FTTF.clone();
            case '7':
                return (boolean[]) FTTT.clone();
            case '8':
                return (boolean[]) TFFF.clone();
            case '9':
                return (boolean[]) TFFT.clone();
            default:
                switch (c) {
                    case EACTags.ELEMENT_LIST /* 65 */:
                        return (boolean[]) TFTF.clone();
                    case EACTags.ADDRESS /* 66 */:
                        return (boolean[]) TFTT.clone();
                    case 'C':
                        return (boolean[]) TTFF.clone();
                    case 'D':
                        return (boolean[]) TTFT.clone();
                    case EACTags.DISPLAY_IMAGE /* 69 */:
                        return (boolean[]) TTTF.clone();
                    case 'F':
                        return (boolean[]) TTTT.clone();
                    default:
                        switch (c) {
                            case 'a':
                                return (boolean[]) TFTF.clone();
                            case 'b':
                                return (boolean[]) TFTT.clone();
                            case DatabaseUtils.STATEMENT_OTHER /* 99 */:
                                return (boolean[]) TTFF.clone();
                            case 'd':
                                return (boolean[]) TTFT.clone();
                            case 'e':
                                return (boolean[]) TTTF.clone();
                            case 'f':
                                return (boolean[]) TTTT.clone();
                            default:
                                throw new IllegalArgumentException("Cannot convert '" + c + "' to a hexadecimal digit");
                        }
                }
        }
    }

    public static int hexDigitMsb0ToInt(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case '3':
                return 12;
            case '4':
                return 2;
            case EACTags.SEX /* 53 */:
                return 10;
            case EACTags.CURRENCY_EXPONENT /* 54 */:
                return 6;
            case '7':
                return 14;
            case '8':
                return 1;
            case '9':
                return 9;
            default:
                switch (c) {
                    case EACTags.ELEMENT_LIST /* 65 */:
                        return 5;
                    case EACTags.ADDRESS /* 66 */:
                        return 13;
                    case 'C':
                        return 3;
                    case 'D':
                        return 11;
                    case EACTags.DISPLAY_IMAGE /* 69 */:
                        return 7;
                    case 'F':
                        return 15;
                    default:
                        switch (c) {
                            case 'a':
                                return 5;
                            case 'b':
                                return 13;
                            case DatabaseUtils.STATEMENT_OTHER /* 99 */:
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot convert '" + c + "' to a hexadecimal digit");
                        }
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    /* JADX WARN: Code duplicated, block: B:13:0x0040  */
    /* JADX WARN: Code duplicated, block: B:15:0x0049  */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    public static boolean[] hexDigitToBinary(char c) {
        switch (c) {
            case '0':
                return (boolean[]) FFFF.clone();
            case '1':
                return (boolean[]) TFFF.clone();
            case '2':
                return (boolean[]) FTFF.clone();
            case '3':
                return (boolean[]) TTFF.clone();
            case '4':
                return (boolean[]) FFTF.clone();
            case EACTags.SEX /* 53 */:
                return (boolean[]) TFTF.clone();
            case EACTags.CURRENCY_EXPONENT /* 54 */:
                return (boolean[]) FTTF.clone();
            case '7':
                return (boolean[]) TTTF.clone();
            case '8':
                return (boolean[]) FFFT.clone();
            case '9':
                return (boolean[]) TFFT.clone();
            default:
                switch (c) {
                    case EACTags.ELEMENT_LIST /* 65 */:
                        return (boolean[]) FTFT.clone();
                    case EACTags.ADDRESS /* 66 */:
                        return (boolean[]) TTFT.clone();
                    case 'C':
                        return (boolean[]) FFTT.clone();
                    case 'D':
                        return (boolean[]) TFTT.clone();
                    case EACTags.DISPLAY_IMAGE /* 69 */:
                        return (boolean[]) FTTT.clone();
                    case 'F':
                        return (boolean[]) TTTT.clone();
                    default:
                        switch (c) {
                            case 'a':
                                return (boolean[]) FTFT.clone();
                            case 'b':
                                return (boolean[]) TTFT.clone();
                            case DatabaseUtils.STATEMENT_OTHER /* 99 */:
                                return (boolean[]) FFTT.clone();
                            case 'd':
                                return (boolean[]) TFTT.clone();
                            case 'e':
                                return (boolean[]) FTTT.clone();
                            case 'f':
                                return (boolean[]) TTTT.clone();
                            default:
                                throw new IllegalArgumentException("Cannot convert '" + c + "' to a hexadecimal digit");
                        }
                }
        }
    }

    public static int hexDigitToInt(char c) {
        int iDigit = Character.digit(c, 16);
        if (iDigit >= 0) {
            return iDigit;
        }
        throw new IllegalArgumentException("Cannot convert '" + c + "' to a hexadecimal digit");
    }

    public static byte hexToByte(String str, int i, byte b, int i2, int i3) {
        if (i3 == 0) {
            return b;
        }
        if (((i3 - 1) * 4) + i2 >= 8) {
            throw new IllegalArgumentException("(nHex - 1) * 4 + dstPos >= 8");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 4) + i2;
            b = (byte) ((b & (~(15 << i5))) | ((hexDigitToInt(str.charAt(i4 + i)) & 15) << i5));
        }
        return b;
    }

    public static int hexToInt(String str, int i, int i2, int i3, int i4) {
        if (i4 == 0) {
            return i2;
        }
        if (((i4 - 1) * 4) + i3 >= 32) {
            throw new IllegalArgumentException("(nHexs - 1) * 4 + dstPos >= 32");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 4) + i3;
            i2 = (i2 & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i)) & 15) << i6);
        }
        return i2;
    }

    public static long hexToLong(String str, int i, long j, int i2, int i3) {
        if (i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 4) + i2 >= 64) {
            throw new IllegalArgumentException("(nHexs - 1) * 4 + dstPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 4) + i2;
            j = (j & (~(15 << i5))) | ((((long) hexDigitToInt(str.charAt(i4 + i))) & 15) << i5);
        }
        return j;
    }

    public static short hexToShort(String str, int i, short s, int i2, int i3) {
        if (i3 == 0) {
            return s;
        }
        if (((i3 - 1) * 4) + i2 >= 16) {
            throw new IllegalArgumentException("(nHexs - 1) * 4 + dstPos >= 16");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 4) + i2;
            s = (short) ((s & (~(15 << i5))) | ((hexDigitToInt(str.charAt(i4 + i)) & 15) << i5));
        }
        return s;
    }

    public static long intArrayToLong(int[] iArr, int i, long j, int i2, int i3) {
        if ((iArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 32) + i2 >= 64) {
            throw new IllegalArgumentException("(nInts - 1) * 32 + dstPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 32) + i2;
            j = (j & (~(BodyPartID.bodyIdMax << i5))) | ((((long) iArr[i4 + i]) & BodyPartID.bodyIdMax) << i5);
        }
        return j;
    }

    public static boolean[] intToBinary(int i, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 == 0) {
            return zArr;
        }
        if ((i4 - 1) + i2 >= 32) {
            throw new IllegalArgumentException("nBools -  1 + srcPos >= 32");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i3 + i5;
            boolean z = true;
            if (((i >> (i5 + i2)) & 1) == 0) {
                z = false;
            }
            zArr[i6] = z;
        }
        return zArr;
    }

    public static byte[] intToByteArray(int i, int i2, byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return bArr;
        }
        if (((i4 - 1) * 8) + i2 >= 32) {
            throw new IllegalArgumentException("(nBytes - 1) * 8 + srcPos >= 32");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i3 + i5] = (byte) ((i >> ((i5 * 8) + i2)) & 255);
        }
        return bArr;
    }

    public static String intToHex(int i, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (((i4 - 1) * 4) + i2 >= 32) {
            throw new IllegalArgumentException("(nHexs - 1) * 4 + srcPos >= 32");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i >> ((i5 * 4) + i2)) & 15;
            int i7 = i3 + i5;
            if (i7 == length) {
                length++;
                sb.append(intToHexDigit(i6));
            } else {
                sb.setCharAt(i7, intToHexDigit(i6));
            }
        }
        return sb.toString();
    }

    public static char intToHexDigit(int i) {
        char cForDigit = Character.forDigit(i, 16);
        if (cForDigit != 0) {
            return cForDigit;
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + i);
    }

    public static char intToHexDigitMsb0(int i) {
        switch (i) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return '4';
            case 3:
                return 'c';
            case 4:
                return '2';
            case 5:
                return 'a';
            case 6:
                return '6';
            case 7:
                return 'e';
            case 8:
                return '1';
            case 9:
                return '9';
            case 10:
                return '5';
            case 11:
                return 'd';
            case 12:
                return '3';
            case 13:
                return 'b';
            case 14:
                return '7';
            case 15:
                return 'f';
            default:
                throw new IllegalArgumentException("nibble value not between 0 and 15: " + i);
        }
    }

    public static short[] intToShortArray(int i, int i2, short[] sArr, int i3, int i4) {
        if (i4 == 0) {
            return sArr;
        }
        if (((i4 - 1) * 16) + i2 >= 32) {
            throw new IllegalArgumentException("(nShorts - 1) * 16 + srcPos >= 32");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            sArr[i3 + i5] = (short) ((i >> ((i5 * 16) + i2)) & 65535);
        }
        return sArr;
    }

    public static boolean[] longToBinary(long j, int i, boolean[] zArr, int i2, int i3) {
        if (i3 == 0) {
            return zArr;
        }
        if ((i3 - 1) + i >= 64) {
            throw new IllegalArgumentException("nBools -  1 + srcPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            zArr[i2 + i4] = (1 & (j >> (i4 + i))) != 0;
        }
        return zArr;
    }

    public static byte[] longToByteArray(long j, int i, byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (((i3 - 1) * 8) + i >= 64) {
            throw new IllegalArgumentException("(nBytes - 1) * 8 + srcPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i2 + i4] = (byte) (255 & (j >> ((i4 * 8) + i)));
        }
        return bArr;
    }

    public static String longToHex(long j, int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return str;
        }
        if (((i3 - 1) * 4) + i >= 64) {
            throw new IllegalArgumentException("(nHexs - 1) * 4 + srcPos >= 64");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (int) ((j >> ((i4 * 4) + i)) & 15);
            int i6 = i2 + i4;
            if (i6 == length) {
                length++;
                sb.append(intToHexDigit(i5));
            } else {
                sb.setCharAt(i6, intToHexDigit(i5));
            }
        }
        return sb.toString();
    }

    public static int[] longToIntArray(long j, int i, int[] iArr, int i2, int i3) {
        if (i3 == 0) {
            return iArr;
        }
        if (((i3 - 1) * 32) + i >= 64) {
            throw new IllegalArgumentException("(nInts - 1) * 32 + srcPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = (int) (j >> ((i4 * 32) + i));
        }
        return iArr;
    }

    public static short[] longToShortArray(long j, int i, short[] sArr, int i2, int i3) {
        if (i3 == 0) {
            return sArr;
        }
        if (((i3 - 1) * 16) + i >= 64) {
            throw new IllegalArgumentException("(nShorts - 1) * 16 + srcPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            sArr[i2 + i4] = (short) (WebSocketProtocol.PAYLOAD_SHORT_MAX & (j >> ((i4 * 16) + i)));
        }
        return sArr;
    }

    public static int shortArrayToInt(short[] sArr, int i, int i2, int i3, int i4) {
        if ((sArr.length == 0 && i == 0) || i4 == 0) {
            return i2;
        }
        if (((i4 - 1) * 16) + i3 >= 32) {
            throw new IllegalArgumentException("(nShorts - 1) * 16 + dstPos >= 32");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 16) + i3;
            i2 = (i2 & (~(65535 << i6))) | ((sArr[i5 + i] & UShort.MAX_VALUE) << i6);
        }
        return i2;
    }

    public static long shortArrayToLong(short[] sArr, int i, long j, int i2, int i3) {
        if ((sArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 16) + i2 >= 64) {
            throw new IllegalArgumentException("(nShorts - 1) * 16 + dstPos >= 64");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 16) + i2;
            j = (j & (~(WebSocketProtocol.PAYLOAD_SHORT_MAX << i5))) | ((((long) sArr[i4 + i]) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << i5);
        }
        return j;
    }

    public static boolean[] shortToBinary(short s, int i, boolean[] zArr, int i2, int i3) {
        if (i3 == 0) {
            return zArr;
        }
        if ((i3 - 1) + i >= 16) {
            throw new IllegalArgumentException("nBools -  1 + srcPos >= 16");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 + i4;
            boolean z = true;
            if (((s >> (i4 + i)) & 1) == 0) {
                z = false;
            }
            zArr[i5] = z;
        }
        return zArr;
    }

    public static byte[] shortToByteArray(short s, int i, byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (((i3 - 1) * 8) + i >= 16) {
            throw new IllegalArgumentException("(nBytes - 1) * 8 + srcPos >= 16");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i2 + i4] = (byte) ((s >> ((i4 * 8) + i)) & 255);
        }
        return bArr;
    }

    public static String shortToHex(short s, int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return str;
        }
        if (((i3 - 1) * 4) + i >= 16) {
            throw new IllegalArgumentException("(nHexs - 1) * 4 + srcPos >= 16");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (s >> ((i4 * 4) + i)) & 15;
            int i6 = i2 + i4;
            if (i6 == length) {
                length++;
                sb.append(intToHexDigit(i5));
            } else {
                sb.setCharAt(i6, intToHexDigit(i5));
            }
        }
        return sb.toString();
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return bArr;
        }
        if (i2 > 16) {
            throw new IllegalArgumentException("nBytes > 16");
        }
        longToByteArray(uuid.getMostSignificantBits(), 0, bArr, i, Math.min(i2, 8));
        if (i2 >= 8) {
            longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i + 8, i2 - 8);
        }
        return bArr;
    }

    @Deprecated
    public Conversion() {
    }
}
