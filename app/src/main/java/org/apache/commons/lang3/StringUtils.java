package org.apache.commons.lang3;

import androidx.camera.video.AudioStats;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes6.dex */
public class StringUtils {

    /* JADX INFO: renamed from: CR */
    public static final String f3984CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;

    /* JADX INFO: renamed from: LF */
    public static final String f3985LF = "\n";
    public static final String SPACE = " ";
    private static final Pattern STRIP_ACCENTS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static String abbreviate(String str, int i) {
        return abbreviate(str, "...", 0, i);
    }

    public static String abbreviate(String str, int i, int i2) {
        return abbreviate(str, "...", i, i2);
    }

    public static String abbreviate(String str, String str2, int i) {
        return abbreviate(str, str2, 0, i);
    }

    public static String abbreviate(String str, String str2, int i, int i2) {
        if (isNotEmpty(str) && "".equals(str2) && i2 > 0) {
            return substring(str, 0, i2);
        }
        if (isAnyEmpty(str, str2)) {
            return str;
        }
        int length = str2.length();
        int i3 = length + 1;
        int i4 = length + length + 1;
        if (i2 < i3) {
            throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", Integer.valueOf(i3)));
        }
        int length2 = str.length();
        if (length2 <= i2) {
            return str;
        }
        if (i > length2) {
            i = length2;
        }
        int i5 = i2 - length;
        if (length2 - i < i5) {
            i = length2 - i5;
        }
        if (i <= i3) {
            return str.substring(0, i5) + str2;
        }
        if (i2 < i4) {
            throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", Integer.valueOf(i4)));
        }
        if ((i2 + i) - length < length2) {
            return str2 + abbreviate(str.substring(i), str2, i5);
        }
        return str2 + str.substring(length2 - i5);
    }

    public static String abbreviateMiddle(String str, String str2, int i) {
        if (isAnyEmpty(str, str2) || i >= str.length() || i < str2.length() + 2) {
            return str;
        }
        int length = i - str2.length();
        int i2 = length / 2;
        return str.substring(0, (length % 2) + i2) + str2 + str.substring(str.length() - i2);
    }

    @Deprecated
    public static String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3987CS.appendIfMissing(str, charSequence, charSequenceArr);
    }

    @Deprecated
    public static String appendIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3986CI.appendIfMissing(str, charSequence, charSequenceArr);
    }

    public static String capitalize(String str) {
        int iCodePointAt;
        int titleCase;
        if (isEmpty(str) || iCodePointAt == (titleCase = Character.toTitleCase((iCodePointAt = str.codePointAt(0))))) {
            return str;
        }
        int[] array = str.codePoints().toArray();
        array[0] = titleCase;
        return new String(array, 0, array.length);
    }

    public static String center(String str, int i) {
        return center(str, i, ' ');
    }

    public static String center(String str, int i, char c) {
        int length;
        int length2;
        return (str == null || i <= 0 || (length2 = i - (length = str.length())) <= 0) ? str : rightPad(leftPad(str, length + (length2 / 2), c), i, c);
    }

    public static String center(String str, int i, String str2) {
        if (str == null || i <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str.length();
        int i2 = i - length;
        return i2 <= 0 ? str : rightPad(leftPad(str, length + (i2 / 2), str2), i, str2);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char cCharAt = str.charAt(0);
            return (cCharAt == '\r' || cCharAt == '\n') ? "" : str;
        }
        int length = str.length();
        int i = length - 1;
        char cCharAt2 = str.charAt(i);
        if (cCharAt2 == '\n') {
            if (str.charAt(length - 2) == '\r') {
                length -= 2;
            } else {
                length = i;
            }
        } else if (cCharAt2 == '\r') {
            length = i;
        }
        return str.substring(0, length);
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        return Strings.f3987CS.removeEnd(str, str2);
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i = length - 1;
        String strSubstring = str.substring(0, i);
        if (str.charAt(i) == '\n') {
            int i2 = length - 2;
            if (strSubstring.charAt(i2) == '\r') {
                return strSubstring.substring(0, i2);
            }
        }
        return strSubstring;
    }

    @Deprecated
    public static int compare(String str, String str2) {
        return Strings.f3987CS.compare(str, str2);
    }

    public static int compare(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z ? -1 : 1;
        }
        if (str2 == null) {
            return z ? 1 : -1;
        }
        return str.compareTo(str2);
    }

    @Deprecated
    public static int compareIgnoreCase(String str, String str2) {
        return Strings.f3986CI.compare(str, str2);
    }

    public static int compareIgnoreCase(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z ? -1 : 1;
        }
        if (str2 == null) {
            return z ? 1 : -1;
        }
        return str.compareToIgnoreCase(str2);
    }

    @Deprecated
    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3987CS.contains(charSequence, charSequence2);
    }

    public static boolean contains(CharSequence charSequence, int i) {
        return !isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i, 0) >= 0;
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i = length - 1;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == cCharAt) {
                        if (!Character.isHighSurrogate(cCharAt) || i4 == i2) {
                            return true;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    @Deprecated
    public static boolean containsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3987CS.containsAny(charSequence, charSequenceArr);
    }

    @Deprecated
    public static boolean containsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3986CI.containsAny(charSequence, charSequenceArr);
    }

    @Deprecated
    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3986CI.contains(charSequence, charSequence2);
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (charSequence != null && cArr != null) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == cCharAt && (!Character.isHighSurrogate(cCharAt) || i4 == i2 || (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        return cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1;
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static void convertRemainingAccentCharacters(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            char cCharAt = sb.charAt(i);
            if (cCharAt == 272) {
                sb.setCharAt(i, 'D');
            } else if (cCharAt == 273) {
                sb.setCharAt(i, 'd');
            } else if (cCharAt == 321) {
                sb.setCharAt(i, Matrix.MATRIX_TYPE_RANDOM_LT);
            } else if (cCharAt == 322) {
                sb.setCharAt(i, 'l');
            } else if (cCharAt == 358) {
                sb.setCharAt(i, 'T');
            } else if (cCharAt == 359) {
                sb.setCharAt(i, 't');
            } else if (cCharAt == 407) {
                sb.setCharAt(i, 'I');
            } else if (cCharAt == 580) {
                sb.setCharAt(i, Matrix.MATRIX_TYPE_RANDOM_UT);
            } else if (cCharAt == 616) {
                sb.setCharAt(i, 'i');
            } else if (cCharAt == 649) {
                sb.setCharAt(i, 'u');
            } else if (cCharAt == 7547) {
                sb.setCharAt(i, 'I');
            } else if (cCharAt == 7550) {
                sb.setCharAt(i, Matrix.MATRIX_TYPE_RANDOM_UT);
            } else if (cCharAt == 7588) {
                sb.setCharAt(i, 'i');
            } else if (cCharAt == 7591) {
                sb.setCharAt(i, 'I');
            } else if (cCharAt == 7606) {
                sb.setCharAt(i, 'u');
            }
        }
    }

    public static int countMatches(CharSequence charSequence, char c) {
        if (isEmpty(charSequence)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (c == charSequence.charAt(i2)) {
                i++;
            }
        }
        return i;
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int length = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i = 0;
        while (true) {
            int iIndexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, length);
            if (iIndexOf == -1) {
                return i;
            }
            i++;
            length = iIndexOf + charSequence2.length();
        }
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        return isBlank(t) ? t2 : t;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        return isEmpty(t) ? t2 : t;
    }

    public static String defaultString(String str) {
        return Objects.toString(str, "");
    }

    @Deprecated
    public static String defaultString(String str, String str2) {
        return Objects.toString(str, str2);
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        if (i == length) {
            return str;
        }
        if (i == 0) {
            return "";
        }
        return new String(cArr, 0, i);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int iIndexOfDifference = indexOfDifference(str, str2);
        if (iIndexOfDifference == -1) {
            return "";
        }
        return str2.substring(iIndexOfDifference);
    }

    @Deprecated
    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3987CS.endsWith(charSequence, charSequence2);
    }

    @Deprecated
    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3987CS.endsWithAny(charSequence, charSequenceArr);
    }

    @Deprecated
    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3986CI.endsWith(charSequence, charSequence2);
    }

    @Deprecated
    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3987CS.equals(charSequence, charSequence2);
    }

    @Deprecated
    public static boolean equalsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3987CS.equalsAny(charSequence, charSequenceArr);
    }

    @Deprecated
    public static boolean equalsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3986CI.equalsAny(charSequence, charSequenceArr);
    }

    @Deprecated
    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3986CI.equals(charSequence, charSequence2);
    }

    @SafeVarargs
    public static <T extends CharSequence> T firstNonBlank(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t : tArr) {
            if (isNotBlank(t)) {
                return t;
            }
        }
        return null;
    }

    @SafeVarargs
    public static <T extends CharSequence> T firstNonEmpty(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t : tArr) {
            if (isNotEmpty(t)) {
                return t;
            }
        }
        return null;
    }

    public static byte[] getBytes(String str, Charset charset) {
        return str == null ? ArrayUtils.EMPTY_BYTE_ARRAY : str.getBytes(Charsets.toCharset(charset));
    }

    public static byte[] getBytes(String str, String str2) throws UnsupportedEncodingException {
        return str == null ? ArrayUtils.EMPTY_BYTE_ARRAY : str.getBytes(Charsets.toCharsetName(str2));
    }

    public static String getCommonPrefix(String... strArr) {
        if (ArrayUtils.isEmpty(strArr)) {
            return "";
        }
        int iIndexOfDifference = indexOfDifference(strArr);
        if (iIndexOfDifference != -1) {
            return iIndexOfDifference == 0 ? "" : strArr[0].substring(0, iIndexOfDifference);
        }
        String str = strArr[0];
        return str == null ? "" : str;
    }

    public static String getDigits(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static int getFuzzyDistance(CharSequence charSequence, CharSequence charSequence2, Locale locale) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (locale == null) {
            throw new IllegalArgumentException("Locale must not be null");
        }
        String lowerCase = charSequence.toString().toLowerCase(locale);
        String lowerCase2 = charSequence2.toString().toLowerCase(locale);
        int i = Integer.MIN_VALUE;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < lowerCase2.length(); i4++) {
            char cCharAt = lowerCase2.charAt(i4);
            boolean z = false;
            while (i3 < lowerCase.length() && !z) {
                if (cCharAt == lowerCase.charAt(i3)) {
                    int i5 = i2 + 1;
                    if (i + 1 == i3) {
                        i5 = i2 + 3;
                    }
                    i2 = i5;
                    z = true;
                    i = i3;
                }
                i3++;
            }
        }
        return i2;
    }

    public static <T extends CharSequence> T getIfBlank(T t, Supplier<T> supplier) {
        return isBlank(t) ? (T) Suppliers.get(supplier) : t;
    }

    public static <T extends CharSequence> T getIfEmpty(T t, Supplier<T> supplier) {
        return isEmpty(t) ? (T) Suppliers.get(supplier) : t;
    }

    @Deprecated
    public static double getJaroWinklerDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int[] iArrMatches = matches(charSequence, charSequence2);
        double d = iArrMatches[0];
        if (d == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        double length = (((d / ((double) charSequence.length())) + (d / ((double) charSequence2.length()))) + ((d - ((double) iArrMatches[1])) / d)) / 3.0d;
        if (length >= 0.7d) {
            length += Math.min(0.1d, 1.0d / ((double) iArrMatches[3])) * ((double) iArrMatches[2]) * (1.0d - length);
        }
        return Math.round(length * 100.0d) / 100.0d;
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            length2 = charSequence.length();
            length = length2;
        } else {
            charSequence2 = charSequence;
            charSequence = charSequence2;
        }
        int[] iArr = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            iArr[i] = i;
        }
        for (int i2 = 1; i2 <= length2; i2++) {
            int i3 = iArr[0];
            char cCharAt = charSequence.charAt(i2 - 1);
            iArr[0] = i2;
            int i4 = 1;
            while (i4 <= length) {
                int i5 = iArr[i4];
                int i6 = i4 - 1;
                iArr[i4] = Math.min(Math.min(iArr[i6] + 1, iArr[i4] + 1), i3 + (charSequence2.charAt(i6) == cCharAt ? 0 : 1));
                i4++;
                i3 = i5;
            }
        }
        return iArr[length];
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        int length;
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        int length2 = charSequence.length();
        int length3 = charSequence2.length();
        if (length2 == 0) {
            if (length3 <= i) {
                return length3;
            }
            return -1;
        }
        if (length3 == 0) {
            if (length2 <= i) {
                return length2;
            }
            return -1;
        }
        if (Math.abs(length2 - length3) > i) {
            return -1;
        }
        if (length2 > length3) {
            length = charSequence.length();
            i2 = length3;
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            i2 = length2;
            length = length3;
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int i3 = i2 + 1;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        int iMin = Math.min(i2, i) + 1;
        char c = 0;
        for (int i4 = 0; i4 < iMin; i4++) {
            iArr[i4] = i4;
        }
        int i5 = Integer.MAX_VALUE;
        Arrays.fill(iArr, iMin, i3, Integer.MAX_VALUE);
        Arrays.fill(iArr2, Integer.MAX_VALUE);
        int i6 = 1;
        while (i6 <= length) {
            char cCharAt = charSequence4.charAt(i6 - 1);
            iArr2[c] = i6;
            int iMax = Math.max(1, i6 - i);
            int iMin2 = i6 > i5 - i ? i2 : Math.min(i2, i6 + i);
            if (iMax > iMin2) {
                return -1;
            }
            if (iMax > 1) {
                iArr2[iMax - 1] = i5;
            }
            while (iMax <= iMin2) {
                int i7 = iMax - 1;
                if (charSequence3.charAt(i7) == cCharAt) {
                    iArr2[iMax] = iArr[i7];
                } else {
                    iArr2[iMax] = Math.min(Math.min(iArr2[i7], iArr[iMax]), iArr[i7]) + 1;
                }
                iMax++;
            }
            i6++;
            c = 0;
            i5 = Integer.MAX_VALUE;
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
        int i8 = iArr[i2];
        if (i8 <= i) {
            return i8;
        }
        return -1;
    }

    @Deprecated
    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3987CS.indexOf(charSequence, charSequence2);
    }

    @Deprecated
    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return Strings.f3987CS.indexOf(charSequence, charSequence2, i);
    }

    public static int indexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, 0);
    }

    public static int indexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, i2);
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        return indexOfAny(charSequence, 0, cArr);
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int iIndexOf;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (charSequence2 != null && (iIndexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) != -1 && iIndexOf < i) {
                i = iIndexOf;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static int indexOfAny(CharSequence charSequence, int i, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i2 = length - 1;
            int length2 = cArr.length;
            int i3 = length2 - 1;
            while (i < length) {
                char cCharAt = charSequence.charAt(i);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == cCharAt && (i >= i2 || i4 >= i3 || !Character.isHighSurrogate(cCharAt) || cArr[i4 + 1] == charSequence.charAt(i + 1))) {
                        return i;
                    }
                }
                i++;
            }
        }
        return -1;
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(cArr)) {
            return -1;
        }
        return indexOfAnyBut(charSequence, CharBuffer.wrap(cArr));
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            Set set = (Set) charSequence2.codePoints().boxed().collect(Collectors.toSet());
            int iCharCount = 0;
            while (iCharCount < charSequence.length()) {
                int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                if (!set.contains(Integer.valueOf(iCodePointAt))) {
                    return iCharCount;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
        return -1;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        if (ArrayUtils.getLength(charSequenceArr) <= 1) {
            return -1;
        }
        int length = charSequenceArr.length;
        int iMin = Integer.MAX_VALUE;
        boolean z = true;
        int iMax = 0;
        boolean z2 = false;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence == null) {
                z2 = true;
                iMin = 0;
            } else {
                iMin = Math.min(charSequence.length(), iMin);
                iMax = Math.max(charSequence.length(), iMax);
                z = false;
            }
        }
        if (z || (iMax == 0 && !z2)) {
            return -1;
        }
        if (iMin == 0) {
            return 0;
        }
        int i = -1;
        for (int i2 = 0; i2 < iMin; i2++) {
            char cCharAt = charSequenceArr[0].charAt(i2);
            for (int i3 = 1; i3 < length; i3++) {
                if (charSequenceArr[i3].charAt(i2) != cCharAt) {
                    i = i2;
                    break;
                }
            }
            if (i != -1) {
                break;
            }
        }
        return (i != -1 || iMin == iMax) ? i : iMin;
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i = 0;
        if (charSequence != null && charSequence2 != null) {
            while (i < charSequence.length() && i < charSequence2.length() && charSequence.charAt(i) == charSequence2.charAt(i)) {
                i++;
            }
            if (i >= charSequence2.length() && i >= charSequence.length()) {
                return -1;
            }
        }
        return i;
    }

    @Deprecated
    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3986CI.indexOf(charSequence, charSequence2);
    }

    @Deprecated
    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        return Strings.f3986CI.indexOf(charSequence, charSequence2, i);
    }

    public static boolean isAllBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isNotBlank(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isNotEmpty(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLowerCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isUpperCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != ' ' && !Character.isLetterOrDigit(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != ' ' && !Character.isLetter(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isBlank(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isEmpty(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length = length(charSequence);
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isMixedCase(CharSequence charSequence) {
        if (!isEmpty(charSequence) && charSequence.length() != 1) {
            int length = charSequence.length();
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                char cCharAt = charSequence.charAt(i);
                if (Character.isUpperCase(cCharAt)) {
                    z = true;
                } else if (Character.isLowerCase(cCharAt)) {
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNoneBlank(CharSequence... charSequenceArr) {
        return !isAnyBlank(charSequenceArr);
    }

    public static boolean isNoneEmpty(CharSequence... charSequenceArr) {
        return !isAnyEmpty(charSequenceArr);
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != ' ' && !Character.isDigit(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String join(boolean[] zArr, char c) {
        if (zArr == null) {
            return null;
        }
        return join(zArr, c, 0, zArr.length);
    }

    public static String join(boolean[] zArr, char c, int i, int i2) {
        if (zArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(((zArr.length * 5) + zArr.length) - 1);
        while (i < i2) {
            sb.append(zArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String join(byte[] bArr, char c) {
        if (bArr == null) {
            return null;
        }
        return join(bArr, c, 0, bArr.length);
    }

    public static String join(byte[] bArr, char c, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append((int) bArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String join(char[] cArr, char c) {
        if (cArr == null) {
            return null;
        }
        return join(cArr, c, 0, cArr.length);
    }

    public static String join(char[] cArr, char c, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((cArr.length * 2) - 1);
        while (i < i2) {
            sb.append(cArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String join(double[] dArr, char c) {
        if (dArr == null) {
            return null;
        }
        return join(dArr, c, 0, dArr.length);
    }

    public static String join(double[] dArr, char c, int i, int i2) {
        if (dArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append(dArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String join(float[] fArr, char c) {
        if (fArr == null) {
            return null;
        }
        return join(fArr, c, 0, fArr.length);
    }

    public static String join(float[] fArr, char c, int i, int i2) {
        if (fArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append(fArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String join(int[] iArr, char c) {
        if (iArr == null) {
            return null;
        }
        return join(iArr, c, 0, iArr.length);
    }

    public static String join(int[] iArr, char c, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append(iArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String join(Iterable<?> iterable, char c) {
        if (iterable != null) {
            return join(iterable.iterator(), c);
        }
        return null;
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable != null) {
            return join(iterable.iterator(), str);
        }
        return null;
    }

    public static String join(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        return !it.hasNext() ? "" : (String) org.apache.commons.lang3.stream.Streams.m1971of(it).collect(LangCollectors.joining(ObjectUtils.toString(String.valueOf(c)), "", "", new StringUtils$$ExternalSyntheticLambda1()));
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        return !it.hasNext() ? "" : (String) org.apache.commons.lang3.stream.Streams.m1971of(it).collect(LangCollectors.joining(ObjectUtils.toString(str), "", "", new StringUtils$$ExternalSyntheticLambda1()));
    }

    public static String join(List<?> list, char c, int i, int i2) {
        if (list == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        return join(list.subList(i, i2).iterator(), c);
    }

    public static String join(List<?> list, String str, int i, int i2) {
        if (list == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        return join(list.subList(i, i2).iterator(), str);
    }

    public static String join(long[] jArr, char c) {
        if (jArr == null) {
            return null;
        }
        return join(jArr, c, 0, jArr.length);
    }

    public static String join(long[] jArr, char c, int i, int i2) {
        if (jArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append(jArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String join(Object[] objArr, char c) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c, 0, objArr.length);
    }

    public static String join(Object[] objArr, char c, int i, int i2) {
        return join(objArr, String.valueOf(c), i, i2);
    }

    public static String join(Object[] objArr, String str) {
        if (objArr != null) {
            return join(objArr, ObjectUtils.toString(str), 0, objArr.length);
        }
        return null;
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr != null) {
            return (String) org.apache.commons.lang3.stream.Streams.m1973of(objArr).skip(i).limit(Math.max(0, i2 - i)).collect(LangCollectors.joining(str, "", "", new StringUtils$$ExternalSyntheticLambda1()));
        }
        return null;
    }

    public static String join(short[] sArr, char c) {
        if (sArr == null) {
            return null;
        }
        return join(sArr, c, 0, sArr.length);
    }

    public static String join(short[] sArr, char c, int i, int i2) {
        if (sArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append((int) sArr[i]);
            sb.append(c);
            i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    @SafeVarargs
    public static <T> String join(T... tArr) {
        return join(tArr, (String) null);
    }

    public static String joinWith(String str, Object... objArr) {
        if (objArr == null) {
            throw new IllegalArgumentException("Object varargs must not be null");
        }
        return join(objArr, str);
    }

    @Deprecated
    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3987CS.lastIndexOf(charSequence, charSequence2);
    }

    @Deprecated
    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return Strings.f3987CS.lastIndexOf(charSequence, charSequence2, i);
    }

    public static int lastIndexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, charSequence.length());
    }

    public static int lastIndexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, i2);
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int iLastIndexOf;
        int i = -1;
        if (charSequence != null && charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (iLastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i) {
                    i = iLastIndexOf;
                }
            }
        }
        return i;
    }

    @Deprecated
    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3986CI.lastIndexOf(charSequence, charSequence2);
    }

    @Deprecated
    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        return Strings.f3986CI.lastIndexOf(charSequence, charSequence2, i);
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, true);
    }

    public static String left(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() <= i ? str : str.substring(0, i);
    }

    public static String leftPad(String str, int i) {
        return leftPad(str, i, ' ');
    }

    public static String leftPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i, String.valueOf(c));
        }
        return repeat(c, length).concat(str);
    }

    public static String leftPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(LocaleUtils.toLocale(locale));
    }

    private static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int iMax = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArrFill = ArrayFill.fill(new int[charSequence3.length()], -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i = 0;
        for (int i2 = 0; i2 < charSequence3.length(); i2++) {
            char cCharAt = charSequence3.charAt(i2);
            int iMin = Math.min(i2 + iMax + 1, charSequence4.length());
            for (int iMax2 = Math.max(i2 - iMax, 0); iMax2 < iMin; iMax2++) {
                if (!zArr[iMax2] && cCharAt == charSequence4.charAt(iMax2)) {
                    iArrFill[i2] = iMax2;
                    zArr[iMax2] = true;
                    i++;
                    break;
                }
            }
        }
        char[] cArr = new char[i];
        char[] cArr2 = new char[i];
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence3.length(); i4++) {
            if (iArrFill[i4] != -1) {
                cArr[i3] = charSequence3.charAt(i4);
                i3++;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < charSequence4.length(); i6++) {
            if (zArr[i6]) {
                cArr2[i5] = charSequence4.charAt(i6);
                i5++;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            if (cArr[i8] != cArr2[i8]) {
                i7++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < charSequence3.length() && charSequence.charAt(i10) == charSequence2.charAt(i10); i10++) {
            i9++;
        }
        return new int[]{i, i7 / 2, i9, charSequence4.length()};
    }

    public static String mid(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0 || i > str.length()) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        int i3 = i2 + i;
        if (str.length() <= i3) {
            return str.substring(i);
        }
        return str.substring(i, i3);
    }

    public static String normalizeSpace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isWhitespace(cCharAt)) {
                if (i2 == 0 && !z) {
                    cArr[i] = " ".charAt(0);
                    i++;
                }
                i2++;
            } else {
                int i4 = i + 1;
                if (cCharAt == 160) {
                    cCharAt = ' ';
                }
                cArr[i] = cCharAt;
                i2 = 0;
                i = i4;
                z = false;
            }
        }
        if (z) {
            return "";
        }
        return new String(cArr, 0, i - (i2 <= 0 ? 0 : 1)).trim();
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, false);
    }

    private static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        int length = -1;
        if (charSequence != null && charSequence2 != null && i > 0) {
            int i2 = 0;
            if (charSequence2.length() == 0) {
                if (z) {
                    return charSequence.length();
                }
                return 0;
            }
            length = z ? charSequence.length() : -1;
            do {
                if (z) {
                    length = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, length - 1);
                } else {
                    length = CharSequenceUtils.indexOf(charSequence, charSequence2, length + 1);
                }
                if (length < 0) {
                    return length;
                }
                i2++;
            } while (i2 < i);
        }
        return length;
    }

    public static String overlay(String str, String str2, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i < 0) {
            i = 0;
        }
        if (i > length) {
            i = length;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 <= length) {
            length = i2;
        }
        if (i > length) {
            int i3 = length;
            length = i;
            i = i3;
        }
        return str.substring(0, i) + str2 + str.substring(length);
    }

    @Deprecated
    public static String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3987CS.prependIfMissing(str, charSequence, charSequenceArr);
    }

    @Deprecated
    public static String prependIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3986CI.prependIfMissing(str, charSequence, charSequenceArr);
    }

    public static String remove(String str, char c) {
        if (isEmpty(str) || str.indexOf(c) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        for (char c2 : charArray) {
            if (c2 != c) {
                charArray[i] = c2;
                i++;
            }
        }
        return new String(charArray, 0, i);
    }

    @Deprecated
    public static String remove(String str, String str2) {
        return Strings.f3987CS.remove(str, str2);
    }

    @Deprecated
    public static String removeAll(String str, String str2) {
        return RegExUtils.removeAll(str, str2);
    }

    @Deprecated
    public static String removeEnd(String str, String str2) {
        return Strings.f3987CS.removeEnd(str, str2);
    }

    @Deprecated
    public static String removeEndIgnoreCase(String str, String str2) {
        return Strings.f3986CI.removeEnd(str, str2);
    }

    @Deprecated
    public static String removeFirst(String str, String str2) {
        return replaceFirst(str, str2, "");
    }

    @Deprecated
    public static String removeIgnoreCase(String str, String str2) {
        return Strings.f3986CI.remove(str, str2);
    }

    @Deprecated
    public static String removePattern(String str, String str2) {
        return RegExUtils.removePattern(str, str2);
    }

    public static String removeStart(String str, char c) {
        return (!isEmpty(str) && str.charAt(0) == c) ? str.substring(1) : str;
    }

    @Deprecated
    public static String removeStart(String str, String str2) {
        return Strings.f3987CS.removeStart(str, str2);
    }

    @Deprecated
    public static String removeStartIgnoreCase(String str, String str2) {
        return Strings.f3986CI.removeStart(str, str2);
    }

    public static String repeat(char c, int i) {
        if (i <= 0) {
            return "";
        }
        return new String(ArrayFill.fill(new char[i], c));
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return repeat(str.charAt(0), i);
        }
        int i2 = length * i;
        if (length == 1) {
            return repeat(str.charAt(0), i);
        }
        if (length == 2) {
            char cCharAt = str.charAt(0);
            char cCharAt2 = str.charAt(1);
            char[] cArr = new char[i2];
            for (int i3 = (i * 2) - 2; i3 >= 0; i3 -= 2) {
                cArr[i3] = cCharAt;
                cArr[i3 + 1] = cCharAt2;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(i2);
        for (int i4 = 0; i4 < i; i4++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String repeat(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return repeat(str, i);
        }
        return Strings.f3987CS.removeEnd(repeat(str + str2, i), str2);
    }

    @Deprecated
    public static String replace(String str, String str2, String str3) {
        return Strings.f3987CS.replace(str, str2, str3);
    }

    @Deprecated
    public static String replace(String str, String str2, String str3, int i) {
        return Strings.f3987CS.replace(str, str2, str3, i);
    }

    @Deprecated
    public static String replaceAll(String str, String str2, String str3) {
        return RegExUtils.replaceAll(str, str2, str3);
    }

    public static String replaceChars(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        return str.replace(c, c2);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        String string = ObjectUtils.toString(str3);
        int length = string.length();
        int length2 = str.length();
        StringBuilder sb = new StringBuilder(length2);
        boolean z = false;
        for (int i = 0; i < length2; i++) {
            char cCharAt = str.charAt(i);
            int iIndexOf = str2.indexOf(cCharAt);
            if (iIndexOf >= 0) {
                if (iIndexOf < length) {
                    sb.append(string.charAt(iIndexOf));
                }
                z = true;
            } else {
                sb.append(cCharAt);
            }
        }
        return z ? sb.toString() : str;
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        String str2;
        int length;
        if (isEmpty(str) || ArrayUtils.isEmpty(strArr) || ArrayUtils.isEmpty(strArr2)) {
            return str;
        }
        if (i < 0) {
            throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
        }
        int length2 = strArr.length;
        int length3 = strArr2.length;
        if (length2 != length3) {
            throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        boolean[] zArr = new boolean[length2];
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < length2; i4++) {
            if (!zArr[i4] && !isEmpty(strArr[i4]) && strArr2[i4] != null) {
                int iIndexOf = str.indexOf(strArr[i4]);
                if (iIndexOf == -1) {
                    zArr[i4] = true;
                } else if (i2 == -1 || iIndexOf < i2) {
                    i3 = i4;
                    i2 = iIndexOf;
                }
            }
        }
        if (i2 == -1) {
            return str;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (strArr[i6] != null && (str2 = strArr2[i6]) != null && (length = str2.length() - strArr[i6].length()) > 0) {
                i5 += length * 3;
            }
        }
        StringBuilder sb = new StringBuilder(str.length() + Math.min(i5, str.length() / 5));
        int length4 = 0;
        while (i2 != -1) {
            while (length4 < i2) {
                sb.append(str.charAt(length4));
                length4++;
            }
            sb.append(strArr2[i3]);
            length4 = strArr[i3].length() + i2;
            i2 = -1;
            i3 = -1;
            for (int i7 = 0; i7 < length2; i7++) {
                if (!zArr[i7] && !isEmpty(strArr[i7]) && strArr2[i7] != null) {
                    int iIndexOf2 = str.indexOf(strArr[i7], length4);
                    if (iIndexOf2 == -1) {
                        zArr[i7] = true;
                    } else if (i2 == -1 || iIndexOf2 < i2) {
                        i3 = i7;
                        i2 = iIndexOf2;
                    }
                }
            }
        }
        int length5 = str.length();
        while (length4 < length5) {
            sb.append(str.charAt(length4));
            length4++;
        }
        String string = sb.toString();
        return !z ? string : replaceEach(string, strArr, strArr2, z, i - 1);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, true, Math.max(ArrayUtils.getLength(strArr), 5));
    }

    @Deprecated
    public static String replaceFirst(String str, String str2, String str3) {
        return RegExUtils.replaceFirst(str, str2, str3);
    }

    @Deprecated
    public static String replaceIgnoreCase(String str, String str2, String str3) {
        return Strings.f3986CI.replace(str, str2, str3);
    }

    @Deprecated
    public static String replaceIgnoreCase(String str, String str2, String str3, int i) {
        return Strings.f3986CI.replace(str, str2, str3, i);
    }

    @Deprecated
    public static String replaceOnce(String str, String str2, String str3) {
        return Strings.f3987CS.replaceOnce(str, str2, str3);
    }

    @Deprecated
    public static String replaceOnceIgnoreCase(String str, String str2, String str3) {
        return Strings.f3986CI.replaceOnce(str, str2, str3);
    }

    @Deprecated
    public static String replacePattern(String str, String str2, String str3) {
        return RegExUtils.replacePattern(str, str2, str3);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c) {
        String[] strArrSplit = split(str, c);
        ArrayUtils.reverse(strArrSplit);
        return join(strArrSplit, c);
    }

    public static String right(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() <= i ? str : str.substring(str.length() - i);
    }

    public static String rightPad(String str, int i) {
        return rightPad(str, i, ' ');
    }

    public static String rightPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i, String.valueOf(c));
        }
        return str.concat(repeat(c, length));
    }

    public static String rightPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String rotate(String str, int i) {
        int i2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (i == 0 || length == 0 || (i2 = i % length) == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(length);
        int i3 = -i2;
        sb.append(substring(str, i3));
        sb.append(substring(str, 0, i3));
        return sb.toString();
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] split(String str, char c) {
        return splitWorker(str, c, false);
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] split(String str, String str2, int i) {
        return splitWorker(str, str2, i, false);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    private static String[] splitByCharacterType(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int type = Character.getType(charArray[0]);
        for (int i2 = 1; i2 < charArray.length; i2++) {
            int type2 = Character.getType(charArray[i2]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i3 = i2 - 1;
                    if (i3 != i) {
                        arrayList.add(new String(charArray, i, i3 - i));
                        i = i3;
                    }
                } else {
                    arrayList.add(new String(charArray, i, i2 - i));
                    i = i2;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, null, i, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int iIndexOf = 0;
        int i2 = 0;
        int i3 = 0;
        while (iIndexOf < length) {
            iIndexOf = str.indexOf(str2, i2);
            if (iIndexOf > -1) {
                if (iIndexOf > i2) {
                    i3++;
                    if (i3 == i) {
                        arrayList.add(str.substring(i2));
                    } else {
                        arrayList.add(str.substring(i2, iIndexOf));
                    }
                } else if (z) {
                    i3++;
                    if (i3 == i) {
                        arrayList.add(str.substring(i2));
                        iIndexOf = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i2 = iIndexOf + length2;
            } else {
                arrayList.add(str.substring(i2));
            }
            iIndexOf = length;
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, null, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c) {
        return splitWorker(str, c, true);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i) {
        return splitWorker(str, str2, i, true);
    }

    private static String[] splitWorker(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i < length) {
            if (str.charAt(i) == c) {
                if (z2 || z) {
                    arrayList.add(str.substring(i2, i));
                    z2 = false;
                    z3 = true;
                }
                i2 = i + 1;
                i = i2;
            } else {
                i++;
                z3 = false;
                z2 = true;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i2, i));
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    private static String[] splitWorker(String str, String str2, int i, boolean z) {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i4 = 0;
            z4 = false;
            z5 = false;
            i5 = 0;
            int i6 = 1;
            while (i4 < length) {
                if (Character.isWhitespace(str.charAt(i4))) {
                    if (z4 || z) {
                        int i7 = i6 + 1;
                        if (i6 == i) {
                            i4 = length;
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        arrayList.add(str.substring(i5, i4));
                        i6 = i7;
                        z4 = false;
                    }
                    i5 = i4 + 1;
                    i4 = i5;
                } else {
                    i4++;
                    z5 = false;
                    z4 = true;
                }
            }
        } else {
            if (str2.length() == 1) {
                char cCharAt = str2.charAt(0);
                i2 = 0;
                z2 = false;
                z3 = false;
                i3 = 0;
                int i8 = 1;
                while (i2 < length) {
                    if (str.charAt(i2) == cCharAt) {
                        if (z2 || z) {
                            int i9 = i8 + 1;
                            if (i8 == i) {
                                i2 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i3, i2));
                            i8 = i9;
                            z2 = false;
                        }
                        i3 = i2 + 1;
                        i2 = i3;
                    } else {
                        i2++;
                        z3 = false;
                        z2 = true;
                    }
                }
            } else {
                i2 = 0;
                z2 = false;
                z3 = false;
                i3 = 0;
                int i10 = 1;
                while (i2 < length) {
                    if (str2.indexOf(str.charAt(i2)) >= 0) {
                        if (z2 || z) {
                            int i11 = i10 + 1;
                            if (i10 == i) {
                                i2 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i3, i2));
                            i10 = i11;
                            z2 = false;
                        }
                        i3 = i2 + 1;
                        i2 = i3;
                    } else {
                        i2++;
                        z3 = false;
                        z2 = true;
                    }
                }
            }
            i4 = i2;
            z4 = z2;
            z5 = z3;
            i5 = i3;
        }
        if (z4 || (z && z5)) {
            arrayList.add(str.substring(i5, i4));
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    @Deprecated
    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3987CS.startsWith(charSequence, charSequence2);
    }

    @Deprecated
    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        return Strings.f3987CS.startsWithAny(charSequence, charSequenceArr);
    }

    @Deprecated
    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return Strings.f3986CI.startsWith(charSequence, charSequence2);
    }

    public static String strip(String str) {
        return strip(str, null);
    }

    public static String strip(String str, String str2) {
        return stripEnd(stripStart(str, str2), str2);
    }

    public static String stripAccents(String str) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(Normalizer.normalize(str, Normalizer.Form.NFKD));
        convertRemainingAccentCharacters(sb);
        return STRIP_ACCENTS_PATTERN.matcher(sb).replaceAll("");
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, null);
    }

    public static String[] stripAll(final String[] strArr, final String str) {
        int length = ArrayUtils.getLength(strArr);
        return length == 0 ? strArr : (String[]) ArrayUtils.setAll(new String[length], new IntFunction() { // from class: org.apache.commons.lang3.StringUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return StringUtils.lambda$stripAll$0(strArr, str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$stripAll$0(String[] strArr, String str, int i) {
        return strip(strArr[i], str);
    }

    public static String stripEnd(String str, String str2) {
        int length = length(str);
        if (length == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String stripStart(String str, String str2) {
        int length = length(str);
        if (length == 0) {
            return str;
        }
        int i = 0;
        if (str2 == null) {
            while (i != length && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (i != length && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
        }
        return str.substring(i);
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strStrip = strip(str, null);
        if (strStrip.isEmpty()) {
            return null;
        }
        return strStrip;
    }

    public static String substring(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            i += str.length();
        }
        if (i < 0) {
            i = 0;
        }
        if (i > str.length()) {
            return "";
        }
        return str.substring(i);
    }

    public static String substring(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i < 0) {
            i += str.length();
        }
        if (i2 > str.length()) {
            i2 = str.length();
        }
        if (i > i2) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return str.substring(i, i2);
    }

    public static String substringAfter(String str, int i) {
        if (isEmpty(str)) {
            return str;
        }
        int iIndexOf = str.indexOf(i);
        if (iIndexOf == -1) {
            return "";
        }
        return str.substring(iIndexOf + 1);
    }

    public static String substringAfter(String str, String str2) {
        int iIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null || (iIndexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(iIndexOf + str2.length());
    }

    public static String substringAfterLast(String str, int i) {
        if (isEmpty(str)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(i);
        if (iLastIndexOf == -1 || iLastIndexOf == str.length() - 1) {
            return "";
        }
        return str.substring(iLastIndexOf + 1);
    }

    public static String substringAfterLast(String str, String str2) {
        int iLastIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        return (isEmpty(str2) || (iLastIndexOf = str.lastIndexOf(str2)) == -1 || iLastIndexOf == str.length() - str2.length()) ? "" : str.substring(iLastIndexOf + str2.length());
    }

    public static String substringBefore(String str, int i) {
        int iIndexOf;
        return (isEmpty(str) || (iIndexOf = str.indexOf(i)) == -1) ? str : str.substring(0, iIndexOf);
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.isEmpty()) {
            return "";
        }
        int iIndexOf = str.indexOf(str2);
        return iIndexOf == -1 ? str : str.substring(0, iIndexOf);
    }

    public static String substringBeforeLast(String str, String str2) {
        int iLastIndexOf;
        return (isEmpty(str) || isEmpty(str2) || (iLastIndexOf = str.lastIndexOf(str2)) == -1) ? str : str.substring(0, iLastIndexOf);
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String substringBetween(String str, String str2, String str3) {
        int iIndexOf;
        int iIndexOf2;
        if (!ObjectUtils.allNotNull(str, str2, str3) || (iIndexOf = str.indexOf(str2)) == -1 || (iIndexOf2 = str.indexOf(str3, str2.length() + iIndexOf)) == -1) {
            return null;
        }
        return str.substring(iIndexOf + str2.length(), iIndexOf2);
    }

    public static String[] substringsBetween(String str, String str2, String str3) {
        int iIndexOf;
        int i;
        int iIndexOf2;
        if (str == null || isEmpty(str2) || isEmpty(str3)) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        int length2 = str3.length();
        int length3 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < length - length2 && (iIndexOf = str.indexOf(str2, i2)) >= 0 && (iIndexOf2 = str.indexOf(str3, (i = iIndexOf + length3))) >= 0) {
            arrayList.add(str.substring(i, iIndexOf2));
            i2 = iIndexOf2 + length2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        int iCharCount = 0;
        int i = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (Character.isUpperCase(iCodePointAt) || Character.isTitleCase(iCodePointAt)) {
                iCodePointAt = Character.toLowerCase(iCodePointAt);
            } else if (Character.isLowerCase(iCodePointAt)) {
                iCodePointAt = Character.toUpperCase(iCodePointAt);
            }
            iArr[i] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i++;
        }
        return new String(iArr, 0, i);
    }

    public static int[] toCodePoints(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence.length() == 0) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return charSequence.toString().codePoints().toArray();
    }

    public static String toEncodedString(byte[] bArr, Charset charset) {
        return new String(bArr, Charsets.toCharset(charset));
    }

    public static String toRootLowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.ROOT);
    }

    public static String toRootUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.ROOT);
    }

    @Deprecated
    public static String toString(byte[] bArr, String str) {
        return new String(bArr, Charsets.toCharset(str));
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trimToNull(String str) {
        String strTrim = trim(str);
        if (isEmpty(strTrim)) {
            return null;
        }
        return strTrim;
    }

    public static String truncate(String str, int i) {
        return truncate(str, 0, i);
    }

    public static String truncate(String str, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("maxWidth cannot be negative");
        }
        if (str == null) {
            return null;
        }
        if (i > str.length()) {
            return "";
        }
        if (str.length() > i2) {
            return str.substring(i, Math.min(i2 + i, str.length()));
        }
        return str.substring(i);
    }

    public static String uncapitalize(String str) {
        int iCodePointAt;
        int lowerCase;
        if (length(str) == 0 || iCodePointAt == (lowerCase = Character.toLowerCase((iCodePointAt = str.codePointAt(0))))) {
            return str;
        }
        int[] array = str.codePoints().toArray();
        array[0] = lowerCase;
        return new String(array, 0, array.length);
    }

    public static String unwrap(String str, char c) {
        return (isEmpty(str) || c == 0 || str.length() == 1 || str.charAt(0) != c || str.charAt(str.length() - 1) != c) ? str : str.substring(1, str.length() - 1);
    }

    public static String unwrap(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || str.length() < str2.length() * 2) {
            return str;
        }
        Strings strings = Strings.f3987CS;
        return (strings.startsWith(str, str2) && strings.endsWith(str, str2)) ? str.substring(str2.length(), str.lastIndexOf(str2)) : str;
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(LocaleUtils.toLocale(locale));
    }

    public static String valueOf(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return String.valueOf(cArr);
    }

    public static String wrap(String str, char c) {
        if (isEmpty(str) || c == 0) {
            return str;
        }
        return c + str + c;
    }

    public static String wrap(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : str2.concat(str).concat(str2);
    }

    public static String wrapIfMissing(String str, char c) {
        if (isEmpty(str) || c == 0) {
            return str;
        }
        boolean z = str.charAt(0) != c;
        boolean z2 = str.charAt(str.length() - 1) != c;
        if (!z && !z2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        if (z) {
            sb.append(c);
        }
        sb.append(str);
        if (z2) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String wrapIfMissing(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        boolean zStartsWith = str.startsWith(str2);
        boolean zEndsWith = str.endsWith(str2);
        if (zStartsWith && zEndsWith) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + str2.length());
        if (!zStartsWith) {
            sb.append(str2);
        }
        sb.append(str);
        if (!zEndsWith) {
            sb.append(str2);
        }
        return sb.toString();
    }

    @Deprecated
    public StringUtils() {
    }
}
