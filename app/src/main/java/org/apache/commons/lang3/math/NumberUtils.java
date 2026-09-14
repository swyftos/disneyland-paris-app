package org.apache.commons.lang3.math;

import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import gherkin.GherkinLanguageConstants;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes6.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Long LONG_INT_MAX_VALUE = 2147483647L;
    public static final Long LONG_INT_MIN_VALUE = -2147483648L;

    private static boolean isSign(char c) {
        return c == '-' || c == '+';
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    @Deprecated
    public static int compare(byte b, byte b2) {
        return Byte.compare(b, b2);
    }

    @Deprecated
    public static int compare(int i, int i2) {
        return Integer.compare(i, i2);
    }

    @Deprecated
    public static int compare(long j, long j2) {
        return Long.compare(j, j2);
    }

    @Deprecated
    public static int compare(short s, short s2) {
        return Short.compare(s, s2);
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(str);
    }

    public static BigInteger createBigInteger(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            throw new NumberFormatException("An empty string is not a valid number");
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        boolean z = true;
        if (cCharAt == '-') {
            i2 = 1;
        } else if (cCharAt == '+') {
            z = false;
            i2 = 1;
        } else {
            z = false;
        }
        int i3 = 16;
        if (str.startsWith("0x", i2) || str.startsWith("0X", i2)) {
            i2 += 2;
        } else if (str.startsWith(GherkinLanguageConstants.COMMENT_PREFIX, i2)) {
            i2++;
        } else if (!str.startsWith("0", i2) || str.length() <= (i = i2 + 1)) {
            i3 = 10;
        } else {
            i3 = 8;
            i2 = i;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i2), i3);
        return z ? bigInteger.negate() : bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0181 A[Catch: NumberFormatException -> 0x0190, TryCatch #5 {NumberFormatException -> 0x0190, blocks: (B:107:0x0177, B:109:0x0181, B:111:0x0189), top: B:164:0x0177 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011b, code lost:
    
        if (r4 == 'l') goto L84;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Number createNumber(String str) {
        int length;
        String mantissa;
        String mantissa2;
        String strSubstring;
        Double dCreateDouble;
        Float fCreateFloat;
        String strSubstring2 = null;
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        String[] strArr = {"0x", "0X", GherkinLanguageConstants.COMMENT_PREFIX};
        int length2 = str.length();
        char cCharAt = 0;
        boolean zIsSign = isSign(str.charAt(0));
        int i = 0;
        while (true) {
            if (i >= 3) {
                length = 0;
                break;
            }
            String str2 = strArr[i];
            if (str.startsWith(str2, zIsSign ? 1 : 0)) {
                length = str2.length() + (zIsSign ? 1 : 0);
                break;
            }
            i++;
        }
        if (length > 0) {
            int i2 = length;
            while (length < length2) {
                cCharAt = str.charAt(length);
                if (cCharAt != '0') {
                    break;
                }
                i2++;
                length++;
            }
            int i3 = length2 - i2;
            if (i3 > 16 || (i3 == 16 && cCharAt > '7')) {
                return createBigInteger(str);
            }
            if (i3 > 8 || (i3 == 8 && cCharAt > '7')) {
                return createLong(str);
            }
            return createInteger(str);
        }
        int i4 = length2 - 1;
        char cCharAt2 = str.charAt(i4);
        int iIndexOf = str.indexOf(46);
        int iIndexOf2 = str.indexOf(101) + str.indexOf(69);
        int i5 = iIndexOf2 + 1;
        byte b = (Character.isDigit(cCharAt2) || cCharAt2 == '.') ? false : true;
        if (iIndexOf > -1) {
            if (i5 <= -1) {
                int i6 = iIndexOf + 1;
                if (b != false) {
                    length2 = i4;
                }
                strSubstring = str.substring(i6, length2);
            } else {
                if (i5 <= iIndexOf || i5 > length2) {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                strSubstring = str.substring(iIndexOf + 1, i5);
            }
            mantissa2 = getMantissa(str, iIndexOf);
        } else {
            if (i5 <= -1) {
                if (b != false) {
                    length2 = i4;
                }
                mantissa = getMantissa(str, length2);
            } else {
                if (i5 > length2) {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                mantissa = getMantissa(str, i5);
            }
            mantissa2 = mantissa;
            strSubstring = null;
        }
        if (b != true) {
            if (i5 > -1 && i5 < i4) {
                strSubstring2 = str.substring(iIndexOf2 + 2);
            }
            if (strSubstring == null && strSubstring2 == null) {
                try {
                    try {
                        return createInteger(str);
                    } catch (NumberFormatException unused) {
                        return createLong(str);
                    }
                } catch (NumberFormatException unused2) {
                    return createBigInteger(str);
                }
            }
            try {
                Float fCreateFloat2 = createFloat(str);
                Double dCreateDouble2 = createDouble(str);
                if (!fCreateFloat2.isInfinite() && ((fCreateFloat2.floatValue() != BitmapDescriptorFactory.HUE_RED || isZero(mantissa2, strSubstring)) && fCreateFloat2.toString().equals(dCreateDouble2.toString()))) {
                    return fCreateFloat2;
                }
                if (!dCreateDouble2.isInfinite() && (dCreateDouble2.doubleValue() != AudioStats.AUDIO_AMPLITUDE_NONE || isZero(mantissa2, strSubstring))) {
                    BigDecimal bigDecimalCreateBigDecimal = createBigDecimal(str);
                    return bigDecimalCreateBigDecimal.compareTo(BigDecimal.valueOf(dCreateDouble2.doubleValue())) == 0 ? dCreateDouble2 : bigDecimalCreateBigDecimal;
                }
            } catch (NumberFormatException unused3) {
            }
            return createBigDecimal(str);
        }
        if (i5 > -1 && i5 < i4) {
            strSubstring2 = str.substring(iIndexOf2 + 2, i4);
        }
        String strSubstring3 = str.substring(0, i4);
        if (cCharAt2 != 'D') {
            if (cCharAt2 != 'F') {
                if (cCharAt2 != 'L') {
                    if (cCharAt2 == 'd') {
                        dCreateDouble = createDouble(str);
                        if (!dCreateDouble.isInfinite()) {
                            return dCreateDouble;
                        }
                        return createBigDecimal(strSubstring3);
                    }
                    if (cCharAt2 == 'f') {
                        fCreateFloat = createFloat(str);
                        if (!fCreateFloat.isInfinite()) {
                            return fCreateFloat;
                        }
                        dCreateDouble = createDouble(str);
                        if (!dCreateDouble.isInfinite()) {
                            return dCreateDouble;
                        }
                        return createBigDecimal(strSubstring3);
                    }
                }
                if (strSubstring != null || strSubstring2 != null || ((strSubstring3.isEmpty() || strSubstring3.charAt(0) != '-' || !isDigits(strSubstring3.substring(1))) && !isDigits(strSubstring3))) {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                try {
                    return createLong(strSubstring3);
                } catch (NumberFormatException unused4) {
                    return createBigInteger(strSubstring3);
                }
            }
            try {
                fCreateFloat = createFloat(str);
                if (!fCreateFloat.isInfinite() && (fCreateFloat.floatValue() != BitmapDescriptorFactory.HUE_RED || isZero(mantissa2, strSubstring))) {
                    return fCreateFloat;
                }
            } catch (NumberFormatException unused5) {
            }
            dCreateDouble = createDouble(str);
            if (!dCreateDouble.isInfinite()) {
                return dCreateDouble;
            }
            return createBigDecimal(strSubstring3);
        }
        try {
            dCreateDouble = createDouble(str);
            if (!dCreateDouble.isInfinite() && (dCreateDouble.doubleValue() != AudioStats.AUDIO_AMPLITUDE_NONE || isZero(mantissa2, strSubstring))) {
                return dCreateDouble;
            }
        } catch (NumberFormatException unused6) {
        }
        try {
            return createBigDecimal(strSubstring3);
        } catch (NumberFormatException unused7) {
        }
        throw new NumberFormatException(str + " is not a valid number.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    private static String getMantissa(String str, int i) {
        ?? IsSign = isSign(str.charAt(0));
        int length = str.length();
        if (length <= IsSign || length < i) {
            throw new NumberFormatException(str + " is not a valid number.");
        }
        return str.substring(IsSign != 0 ? 1 : 0, i);
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static boolean isCreatable(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        ?? IsSign = isSign(charArray[0]);
        int i = IsSign + 1;
        if (length > i && charArray[IsSign] == '0' && !StringUtils.contains(str, 46)) {
            char c = charArray[i];
            if (c == 'x' || c == 'X') {
                int i2 = IsSign + 2;
                if (i2 == length) {
                    return false;
                }
                while (i2 < charArray.length) {
                    if (!CharUtils.isHex(charArray[i2])) {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
            if (Character.isDigit(c)) {
                while (i < charArray.length) {
                    if (!CharUtils.isOctal(charArray[i])) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        int i3 = length - 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        ?? r3 = IsSign;
        while (true) {
            if (r3 < i3 || (r3 < length && z && !z2)) {
                if (CharUtils.isAsciiNumeric(charArray[r3])) {
                    z = false;
                    z2 = true;
                } else {
                    char c2 = charArray[r3];
                    if (c2 == '.') {
                        if (z4 || z3) {
                            break;
                        }
                        z4 = true;
                    } else if (c2 == 'e' || c2 == 'E') {
                        if (z3 || !z2) {
                            return false;
                        }
                        z = true;
                        z3 = true;
                    } else {
                        if (!isSign(c2) || !z) {
                            return false;
                        }
                        z = false;
                        z2 = false;
                    }
                }
                r3++;
            } else {
                if (r3 >= charArray.length) {
                    return !z && z2;
                }
                if (CharUtils.isAsciiNumeric(charArray[r3])) {
                    return true;
                }
                char c3 = charArray[r3];
                if (c3 == 'e' || c3 == 'E') {
                    return false;
                }
                if (c3 == '.') {
                    if (z4 || z3) {
                        return false;
                    }
                    return z2;
                }
                if (z || !(c3 == 'd' || c3 == 'D' || c3 == 'f' || c3 == 'F')) {
                    return (c3 == 'l' || c3 == 'L') && z2 && !z3 && !z4;
                }
                return z2;
            }
        }
        return false;
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            return withDecimalsParsing(str, 1);
        }
        return withDecimalsParsing(str, 0);
    }

    private static boolean isZero(String str, String str2) {
        return isAllZeros(str) && isAllZeros(str2);
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 < i) {
                i = i3;
            }
        }
        return i;
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 < j) {
                j = j2;
            }
        }
        return j;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        try {
            return Byte.parseByte(str);
        } catch (RuntimeException unused) {
            return b;
        }
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return toDouble(bigDecimal, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static double toDouble(BigDecimal bigDecimal, double d) {
        return bigDecimal == null ? d : bigDecimal.doubleValue();
    }

    public static double toDouble(String str) {
        return toDouble(str, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static double toDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (RuntimeException unused) {
            return d;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, BitmapDescriptorFactory.HUE_RED);
    }

    public static float toFloat(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (RuntimeException unused) {
            return f;
        }
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (RuntimeException unused) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static long toLong(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (RuntimeException unused) {
            return j;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return toScaledBigDecimal(bigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int i, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double d) {
        return toScaledBigDecimal(d, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Double d, int i, RoundingMode roundingMode) {
        if (d == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(d.doubleValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Float f) {
        return toScaledBigDecimal(f, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Float f, int i, RoundingMode roundingMode) {
        if (f == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(f.floatValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String str) {
        return toScaledBigDecimal(str, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(String str, int i, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(createBigDecimal(str), i, roundingMode);
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static short toShort(String str, short s) {
        try {
            return Short.parseShort(str);
        } catch (RuntimeException unused) {
            return s;
        }
    }

    private static void validateArray(Object obj) {
        Objects.requireNonNull(obj, "array");
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    private static boolean withDecimalsParsing(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            boolean z = cCharAt == '.';
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(cCharAt)) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Deprecated
    public NumberUtils() {
    }
}
