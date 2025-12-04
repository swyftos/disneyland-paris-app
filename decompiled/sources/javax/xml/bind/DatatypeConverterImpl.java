package javax.xml.bind;

import com.disney.id.android.tracker.OneIDTracker;
import com.google.common.base.Ascii;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import okio.Utf8;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.picocontainer.Characteristics;

/* loaded from: classes5.dex */
final class DatatypeConverterImpl implements DatatypeConverterInterface {
    private static final DatatypeFactory datatypeFactory;
    public static final DatatypeConverterInterface theInstance = new DatatypeConverterImpl();
    private static final char[] hexCode = "0123456789ABCDEF".toCharArray();
    private static final byte[] decodeMap = initDecodeMap();
    private static final char[] encodeMap = initEncodeMap();

    private static int hexToBin(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        if ('A' <= c && c <= 'F') {
            return c - '7';
        }
        if ('a' > c || c > 'f') {
            return -1;
        }
        return c - 'W';
    }

    private static boolean isDigitOrPeriodOrSign(char c) {
        return ('0' <= c && c <= '9') || c == '+' || c == '-' || c == '.';
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String parseAnySimpleType(String str) {
        return str;
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String parseString(String str) {
        return str;
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printAnySimpleType(String str) {
        return str;
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printString(String str) {
        return str;
    }

    static {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new Error(e);
        }
    }

    protected DatatypeConverterImpl() {
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public BigInteger parseInteger(String str) {
        return _parseInteger(str);
    }

    public static BigInteger _parseInteger(CharSequence charSequence) {
        return new BigInteger(removeOptionalPlus(WhiteSpaceProcessor.trim(charSequence)).toString());
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printInteger(BigInteger bigInteger) {
        return _printInteger(bigInteger);
    }

    public static String _printInteger(BigInteger bigInteger) {
        return bigInteger.toString();
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public int parseInt(String str) {
        return _parseInt(str);
    }

    public static int _parseInt(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 1;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = charSequence.charAt(i3);
            if (!WhiteSpaceProcessor.isWhiteSpace(cCharAt)) {
                if ('0' <= cCharAt && cCharAt <= '9') {
                    i2 = (i2 * 10) + (cCharAt - '0');
                } else if (cCharAt == '-') {
                    i = -1;
                } else if (cCharAt != '+') {
                    throw new NumberFormatException("Not a number: " + ((Object) charSequence));
                }
            }
        }
        return i2 * i;
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public long parseLong(String str) {
        return _parseLong(str);
    }

    public static long _parseLong(CharSequence charSequence) {
        return Long.parseLong(removeOptionalPlus(WhiteSpaceProcessor.trim(charSequence)).toString());
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public short parseShort(String str) {
        return _parseShort(str);
    }

    public static short _parseShort(CharSequence charSequence) {
        return (short) _parseInt(charSequence);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printShort(short s) {
        return _printShort(s);
    }

    public static String _printShort(short s) {
        return String.valueOf((int) s);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public BigDecimal parseDecimal(String str) {
        return _parseDecimal(str);
    }

    public static BigDecimal _parseDecimal(CharSequence charSequence) {
        CharSequence charSequenceTrim = WhiteSpaceProcessor.trim(charSequence);
        if (charSequenceTrim.length() <= 0) {
            return null;
        }
        return new BigDecimal(charSequenceTrim.toString());
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public float parseFloat(String str) {
        return _parseFloat(str);
    }

    public static float _parseFloat(CharSequence charSequence) {
        String string = WhiteSpaceProcessor.trim(charSequence).toString();
        if (string.equals("NaN")) {
            return Float.NaN;
        }
        if (string.equals("INF")) {
            return Float.POSITIVE_INFINITY;
        }
        if (string.equals("-INF")) {
            return Float.NEGATIVE_INFINITY;
        }
        if (string.length() == 0 || !isDigitOrPeriodOrSign(string.charAt(0)) || !isDigitOrPeriodOrSign(string.charAt(string.length() - 1))) {
            throw new NumberFormatException();
        }
        return Float.parseFloat(string);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printFloat(float f) {
        return _printFloat(f);
    }

    public static String _printFloat(float f) {
        if (Float.isNaN(f)) {
            return "NaN";
        }
        if (f == Float.POSITIVE_INFINITY) {
            return "INF";
        }
        if (f == Float.NEGATIVE_INFINITY) {
            return "-INF";
        }
        return String.valueOf(f);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public double parseDouble(String str) {
        return _parseDouble(str);
    }

    public static double _parseDouble(CharSequence charSequence) {
        String string = WhiteSpaceProcessor.trim(charSequence).toString();
        if (string.equals("NaN")) {
            return Double.NaN;
        }
        if (string.equals("INF")) {
            return Double.POSITIVE_INFINITY;
        }
        if (string.equals("-INF")) {
            return Double.NEGATIVE_INFINITY;
        }
        if (string.length() == 0 || !isDigitOrPeriodOrSign(string.charAt(0)) || !isDigitOrPeriodOrSign(string.charAt(string.length() - 1))) {
            throw new NumberFormatException(string);
        }
        return Double.parseDouble(string);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public boolean parseBoolean(String str) {
        Boolean bool_parseBoolean = _parseBoolean(str);
        if (bool_parseBoolean == null) {
            return false;
        }
        return bool_parseBoolean.booleanValue();
    }

    public static Boolean _parseBoolean(CharSequence charSequence) {
        int i;
        char cCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (charSequence == null) {
            return null;
        }
        int length = charSequence.length();
        if (charSequence.length() <= 0) {
            return null;
        }
        boolean z = false;
        z = false;
        int i7 = 0;
        z = false;
        int i8 = 0;
        while (true) {
            i = i8 + 1;
            cCharAt = charSequence.charAt(i8);
            if (!WhiteSpaceProcessor.isWhiteSpace(cCharAt) || i >= length) {
                break;
            }
            i8 = i;
        }
        if (cCharAt != '0') {
            if (cCharAt == '1') {
                z = true;
            } else if (cCharAt == 'f') {
                int i9 = 0;
                while (true) {
                    i3 = i + 1;
                    i4 = i9 + 1;
                    if ("alse".charAt(i9) != charSequence.charAt(i) || i3 >= length || i4 >= 4) {
                        break;
                    }
                    i = i3;
                    i9 = i4;
                }
                if (i4 != 4) {
                    return Boolean.FALSE;
                }
                i = i3;
            } else if (cCharAt == 't') {
                while (true) {
                    i5 = i + 1;
                    i6 = i7 + 1;
                    if ("rue".charAt(i7) != charSequence.charAt(i) || i5 >= length || i6 >= 3) {
                        break;
                    }
                    i = i5;
                    i7 = i6;
                }
                if (i6 != 3) {
                    return Boolean.FALSE;
                }
                i = i5;
                z = true;
            }
        }
        if (i < length) {
            while (true) {
                i2 = i + 1;
                if (!WhiteSpaceProcessor.isWhiteSpace(charSequence.charAt(i)) || i2 >= length) {
                    break;
                }
                i = i2;
            }
            i = i2;
        }
        if (i == length) {
            return Boolean.valueOf(z);
        }
        return null;
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printBoolean(boolean z) {
        return z ? Characteristics.TRUE : "false";
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public byte parseByte(String str) {
        return _parseByte(str);
    }

    public static byte _parseByte(CharSequence charSequence) {
        return (byte) _parseInt(charSequence);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printByte(byte b) {
        return _printByte(b);
    }

    public static String _printByte(byte b) {
        return String.valueOf((int) b);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public QName parseQName(String str, NamespaceContext namespaceContext) {
        return _parseQName(str, namespaceContext);
    }

    public static QName _parseQName(CharSequence charSequence, NamespaceContext namespaceContext) {
        String string;
        String namespaceURI;
        String str;
        int length = charSequence.length();
        int i = 0;
        while (i < length && WhiteSpaceProcessor.isWhiteSpace(charSequence.charAt(i))) {
            i++;
        }
        while (length > i && WhiteSpaceProcessor.isWhiteSpace(charSequence.charAt(length - 1))) {
            length--;
        }
        if (length == i) {
            throw new IllegalArgumentException("input is empty");
        }
        int i2 = i + 1;
        while (i2 < length && charSequence.charAt(i2) != ':') {
            i2++;
        }
        if (i2 == length) {
            str = "";
            namespaceURI = namespaceContext.getNamespaceURI("");
            string = charSequence.subSequence(i, length).toString();
        } else {
            String string2 = charSequence.subSequence(i, i2).toString();
            string = charSequence.subSequence(i2 + 1, length).toString();
            namespaceURI = namespaceContext.getNamespaceURI(string2);
            if (namespaceURI == null || namespaceURI.length() == 0) {
                throw new IllegalArgumentException("prefix " + string2 + " is not bound to a namespace");
            }
            str = string2;
        }
        return new QName(namespaceURI, string, str);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public Calendar parseDateTime(String str) {
        return _parseDateTime(str);
    }

    public static GregorianCalendar _parseDateTime(CharSequence charSequence) {
        return datatypeFactory.newXMLGregorianCalendar(WhiteSpaceProcessor.trim(charSequence).toString()).toGregorianCalendar();
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printDateTime(Calendar calendar) {
        return _printDateTime(calendar);
    }

    public static String _printDateTime(Calendar calendar) {
        return CalendarFormatter.doFormat("%Y-%M-%DT%h:%m:%s%z", calendar);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public byte[] parseBase64Binary(String str) {
        return _parseBase64Binary(str);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public byte[] parseHexBinary(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("hexBinary needs to be even-length: " + str);
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            int iHexToBin = hexToBin(str.charAt(i));
            int iHexToBin2 = hexToBin(str.charAt(i + 1));
            if (iHexToBin == -1 || iHexToBin2 == -1) {
                throw new IllegalArgumentException("contains illegal character for hexBinary: " + str);
            }
            bArr[i / 2] = (byte) ((iHexToBin * 16) + iHexToBin2);
        }
        return bArr;
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printHexBinary(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = hexCode;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.SI]);
        }
        return sb.toString();
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public long parseUnsignedInt(String str) {
        return _parseLong(str);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printUnsignedInt(long j) {
        return _printLong(j);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public int parseUnsignedShort(String str) {
        return _parseInt(str);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public Calendar parseTime(String str) {
        return datatypeFactory.newXMLGregorianCalendar(str).toGregorianCalendar();
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printTime(Calendar calendar) {
        return CalendarFormatter.doFormat("%h:%m:%s%z", calendar);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public Calendar parseDate(String str) {
        return datatypeFactory.newXMLGregorianCalendar(str).toGregorianCalendar();
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printDate(Calendar calendar) {
        return _printDate(calendar);
    }

    public static String _printDate(Calendar calendar) {
        return CalendarFormatter.doFormat("%Y-%M-%D%z", calendar);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printInt(int i) {
        return _printInt(i);
    }

    public static String _printInt(int i) {
        return String.valueOf(i);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printLong(long j) {
        return _printLong(j);
    }

    public static String _printLong(long j) {
        return String.valueOf(j);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printDecimal(BigDecimal bigDecimal) {
        return _printDecimal(bigDecimal);
    }

    public static String _printDecimal(BigDecimal bigDecimal) {
        return bigDecimal.toPlainString();
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printDouble(double d) {
        return _printDouble(d);
    }

    public static String _printDouble(double d) {
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "INF";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-INF";
        }
        return String.valueOf(d);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printQName(QName qName, NamespaceContext namespaceContext) {
        return _printQName(qName, namespaceContext);
    }

    public static String _printQName(QName qName, NamespaceContext namespaceContext) {
        String prefix = namespaceContext.getPrefix(qName.getNamespaceURI());
        String localPart = qName.getLocalPart();
        if (prefix == null || prefix.length() == 0) {
            return localPart;
        }
        return prefix + ':' + localPart;
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printBase64Binary(byte[] bArr) {
        return _printBase64Binary(bArr);
    }

    @Override // javax.xml.bind.DatatypeConverterInterface
    public String printUnsignedShort(int i) {
        return String.valueOf(i);
    }

    private static byte[] initDecodeMap() {
        byte[] bArr = new byte[128];
        for (int i = 0; i < 128; i++) {
            bArr[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            bArr[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            bArr[i3] = (byte) (i3 - 71);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            bArr[i4] = (byte) (i4 + 4);
        }
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        bArr[61] = 127;
        return bArr;
    }

    private static int guessLength(String str) {
        int length = str.length();
        int i = length - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            byte b = decodeMap[str.charAt(i)];
            if (b == 127) {
                i--;
            } else if (b == -1) {
                return (str.length() / 4) * 3;
            }
        }
        int i2 = length - (i + 1);
        if (i2 > 2) {
            return (str.length() / 4) * 3;
        }
        return ((str.length() / 4) * 3) - i2;
    }

    public static byte[] _parseBase64Binary(String str) {
        int iGuessLength = guessLength(str);
        byte[] bArr = new byte[iGuessLength];
        int length = str.length();
        byte[] bArr2 = new byte[4];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte b = decodeMap[str.charAt(i3)];
            if (b != -1) {
                bArr2[i2] = b;
                i2++;
            }
            if (i2 == 4) {
                int i4 = i + 1;
                bArr[i] = (byte) ((bArr2[0] << 2) | (bArr2[1] >> 4));
                byte b2 = bArr2[2];
                if (b2 != 127) {
                    bArr[i4] = (byte) ((b2 >> 2) | (bArr2[1] << 4));
                    i4 = i + 2;
                }
                byte b3 = bArr2[3];
                if (b3 != 127) {
                    bArr[i4] = (byte) (b3 | (bArr2[2] << 6));
                    i = i4 + 1;
                } else {
                    i = i4;
                }
                i2 = 0;
            }
        }
        if (iGuessLength == i) {
            return bArr;
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr, 0, bArr3, 0, i);
        return bArr3;
    }

    private static char[] initEncodeMap() {
        int i;
        int i2;
        char[] cArr = new char[64];
        int i3 = 0;
        while (true) {
            i = 26;
            if (i3 >= 26) {
                break;
            }
            cArr[i3] = (char) (i3 + 65);
            i3++;
        }
        while (true) {
            if (i >= 52) {
                break;
            }
            cArr[i] = (char) (i + 71);
            i++;
        }
        for (i2 = 52; i2 < 62; i2++) {
            cArr[i2] = (char) (i2 - 4);
        }
        cArr[62] = '+';
        cArr[63] = '/';
        return cArr;
    }

    public static char encode(int i) {
        return encodeMap[i & 63];
    }

    public static String _printBase64Binary(byte[] bArr) {
        return _printBase64Binary(bArr, 0, bArr.length);
    }

    public static String _printBase64Binary(byte[] bArr, int i, int i2) {
        char[] cArr = new char[((i2 + 2) / 3) * 4];
        _printBase64Binary(bArr, i, i2, cArr, 0);
        return new String(cArr);
    }

    public static int _printBase64Binary(byte[] bArr, int i, int i2, char[] cArr, int i3) {
        while (i2 >= 3) {
            cArr[i3] = encode(bArr[i] >> 2);
            int i4 = i + 1;
            cArr[i3 + 1] = encode(((bArr[i] & 3) << 4) | ((bArr[i4] >> 4) & 15));
            int i5 = i3 + 3;
            int i6 = i + 2;
            cArr[i3 + 2] = encode((3 & (bArr[i6] >> 6)) | ((bArr[i4] & Ascii.SI) << 2));
            i3 += 4;
            cArr[i5] = encode(bArr[i6] & Utf8.REPLACEMENT_BYTE);
            i2 -= 3;
            i += 3;
        }
        if (i2 == 1) {
            cArr[i3] = encode(bArr[i] >> 2);
            cArr[i3 + 1] = encode((bArr[i] & 3) << 4);
            int i7 = i3 + 3;
            cArr[i3 + 2] = '=';
            i3 += 4;
            cArr[i7] = '=';
        }
        if (i2 != 2) {
            return i3;
        }
        cArr[i3] = encode(bArr[i] >> 2);
        int i8 = (3 & bArr[i]) << 4;
        int i9 = i + 1;
        cArr[i3 + 1] = encode(i8 | ((bArr[i9] >> 4) & 15));
        int i10 = i3 + 3;
        cArr[i3 + 2] = encode((bArr[i9] & Ascii.SI) << 2);
        int i11 = i3 + 4;
        cArr[i10] = '=';
        return i11;
    }

    private static CharSequence removeOptionalPlus(CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= 1 || charSequence.charAt(0) != '+') {
            return charSequence;
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(1, length);
        char cCharAt = charSequenceSubSequence.charAt(0);
        if (('0' > cCharAt || cCharAt > '9') && '.' != cCharAt) {
            throw new NumberFormatException();
        }
        return charSequenceSubSequence;
    }

    private static final class CalendarFormatter {
        public static String doFormat(String str, Calendar calendar) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                char cCharAt = str.charAt(i);
                if (cCharAt != '%') {
                    sb.append(cCharAt);
                    i = i2;
                } else {
                    i += 2;
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 == 'D') {
                        formatDays(calendar, sb);
                    } else if (cCharAt2 == 'M') {
                        formatMonth(calendar, sb);
                    } else if (cCharAt2 == 'Y') {
                        formatYear(calendar, sb);
                    } else if (cCharAt2 == 'h') {
                        formatHours(calendar, sb);
                    } else if (cCharAt2 == 'm') {
                        formatMinutes(calendar, sb);
                    } else if (cCharAt2 == 's') {
                        formatSeconds(calendar, sb);
                    } else if (cCharAt2 == 'z') {
                        formatTimeZone(calendar, sb);
                    } else {
                        throw new InternalError();
                    }
                }
            }
            return sb.toString();
        }

        private static void formatYear(Calendar calendar, StringBuilder sb) {
            String string;
            int i = calendar.get(1);
            if (i <= 0) {
                string = Integer.toString(1 - i);
            } else {
                string = Integer.toString(i);
            }
            while (string.length() < 4) {
                string = '0' + string;
            }
            if (i <= 0) {
                string = '-' + string;
            }
            sb.append(string);
        }

        private static void formatMonth(Calendar calendar, StringBuilder sb) {
            formatTwoDigits(calendar.get(2) + 1, sb);
        }

        private static void formatDays(Calendar calendar, StringBuilder sb) {
            formatTwoDigits(calendar.get(5), sb);
        }

        private static void formatHours(Calendar calendar, StringBuilder sb) {
            formatTwoDigits(calendar.get(11), sb);
        }

        private static void formatMinutes(Calendar calendar, StringBuilder sb) {
            formatTwoDigits(calendar.get(12), sb);
        }

        private static void formatSeconds(Calendar calendar, StringBuilder sb) {
            int i;
            formatTwoDigits(calendar.get(13), sb);
            if (!calendar.isSet(14) || (i = calendar.get(14)) == 0) {
                return;
            }
            String string = Integer.toString(i);
            while (string.length() < 3) {
                string = '0' + string;
            }
            sb.append('.');
            sb.append(string);
        }

        private static void formatTimeZone(Calendar calendar, StringBuilder sb) {
            TimeZone timeZone = calendar.getTimeZone();
            if (timeZone == null) {
                return;
            }
            int offset = timeZone.getOffset(calendar.getTime().getTime());
            if (offset == 0) {
                sb.append(Matrix.MATRIX_TYPE_ZERO);
                return;
            }
            if (offset >= 0) {
                sb.append('+');
            } else {
                sb.append('-');
                offset *= -1;
            }
            int i = offset / OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC;
            formatTwoDigits(i / 60, sb);
            sb.append(':');
            formatTwoDigits(i % 60, sb);
        }

        private static void formatTwoDigits(int i, StringBuilder sb) {
            if (i < 10) {
                sb.append('0');
            }
            sb.append(i);
        }
    }
}
