package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.apache.commons.lang3.math.NumberUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BooleanUtils {
    private static final List BOOLEAN_LIST = Collections.unmodifiableList(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
    public static final String FALSE = "false";

    /* JADX INFO: renamed from: NO */
    public static final String f3980NO = "no";
    public static final String OFF = "off";

    /* JADX INFO: renamed from: ON */
    public static final String f3981ON = "on";
    public static final String TRUE = "true";
    public static final String YES = "yes";

    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static boolean toBoolean(int i) {
        return i != 0;
    }

    public static int toInteger(boolean z) {
        return z ? 1 : 0;
    }

    public static int toInteger(boolean z, int i, int i2) {
        return z ? i : i2;
    }

    public static Integer toIntegerObject(boolean z, Integer num, Integer num2) {
        return z ? num : num2;
    }

    public static String toString(boolean z, String str, String str2) {
        return z ? str : str2;
    }

    public static boolean and(boolean... zArr) {
        ObjectUtils.requireNonEmpty(zArr, "array");
        for (boolean z : zArr) {
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static Boolean and(Boolean... boolArr) {
        ObjectUtils.requireNonEmpty(boolArr, "array");
        return and(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Boolean[] booleanValues() {
        return new Boolean[]{Boolean.FALSE, Boolean.TRUE};
    }

    public static void forEach(Consumer<Boolean> consumer) {
        values().forEach(consumer);
    }

    public static boolean isFalse(Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    public static boolean isNotFalse(Boolean bool) {
        return !isFalse(bool);
    }

    public static boolean isNotTrue(Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isTrue(Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean oneHot(boolean... zArr) {
        ObjectUtils.requireNonEmpty(zArr, "array");
        boolean z = false;
        for (boolean z2 : zArr) {
            if (z2) {
                if (z) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }

    public static Boolean oneHot(Boolean... boolArr) {
        return Boolean.valueOf(oneHot(ArrayUtils.toPrimitive(boolArr)));
    }

    /* JADX INFO: renamed from: or */
    public static boolean m1940or(boolean... zArr) {
        ObjectUtils.requireNonEmpty(zArr, "array");
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: or */
    public static Boolean m1939or(Boolean... boolArr) {
        ObjectUtils.requireNonEmpty(boolArr, "array");
        return m1940or(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean[] primitiveValues() {
        return new boolean[]{false, true};
    }

    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static boolean toBoolean(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        if (i == i3) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else {
            if (num.equals(num2)) {
                return true;
            }
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static boolean toBoolean(String str) {
        return toBooleanObject(str) == Boolean.TRUE;
    }

    public static boolean toBoolean(String str, String str2, String str3) {
        if (str == str2) {
            return true;
        }
        if (str == str3) {
            return false;
        }
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static Boolean toBooleanObject(int i) {
        return i == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean toBooleanObject(int i, int i2, int i3, int i4) {
        if (i == i2) {
            return Boolean.TRUE;
        }
        if (i == i3) {
            return Boolean.FALSE;
        }
        if (i == i4) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Boolean toBooleanObject(Integer num) {
        if (num == null) {
            return null;
        }
        return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else {
            if (num.equals(num2)) {
                return Boolean.TRUE;
            }
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Boolean toBooleanObject(String str) {
        if (str == "true") {
            return Boolean.TRUE;
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 1) {
            char cCharAt = str.charAt(0);
            if (cCharAt == 'y' || cCharAt == 'Y' || cCharAt == 't' || cCharAt == 'T' || cCharAt == '1') {
                return Boolean.TRUE;
            }
            if (cCharAt == 'n' || cCharAt == 'N' || cCharAt == 'f' || cCharAt == 'F' || cCharAt == '0') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 2) {
            char cCharAt2 = str.charAt(0);
            char cCharAt3 = str.charAt(1);
            if ((cCharAt2 == 'o' || cCharAt2 == 'O') && (cCharAt3 == 'n' || cCharAt3 == 'N')) {
                return Boolean.TRUE;
            }
            if (cCharAt2 != 'n' && cCharAt2 != 'N') {
                return null;
            }
            if (cCharAt3 == 'o' || cCharAt3 == 'O') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 3) {
            char cCharAt4 = str.charAt(0);
            char cCharAt5 = str.charAt(1);
            char cCharAt6 = str.charAt(2);
            if ((cCharAt4 == 'y' || cCharAt4 == 'Y') && ((cCharAt5 == 'e' || cCharAt5 == 'E') && (cCharAt6 == 's' || cCharAt6 == 'S'))) {
                return Boolean.TRUE;
            }
            if (cCharAt4 != 'o' && cCharAt4 != 'O') {
                return null;
            }
            if (cCharAt5 != 'f' && cCharAt5 != 'F') {
                return null;
            }
            if (cCharAt6 == 'f' || cCharAt6 == 'F') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 4) {
            char cCharAt7 = str.charAt(0);
            char cCharAt8 = str.charAt(1);
            char cCharAt9 = str.charAt(2);
            char cCharAt10 = str.charAt(3);
            if (cCharAt7 != 't' && cCharAt7 != 'T') {
                return null;
            }
            if (cCharAt8 != 'r' && cCharAt8 != 'R') {
                return null;
            }
            if (cCharAt9 != 'u' && cCharAt9 != 'U') {
                return null;
            }
            if (cCharAt10 == 'e' || cCharAt10 == 'E') {
                return Boolean.TRUE;
            }
            return null;
        }
        if (length != 5) {
            return null;
        }
        char cCharAt11 = str.charAt(0);
        char cCharAt12 = str.charAt(1);
        char cCharAt13 = str.charAt(2);
        char cCharAt14 = str.charAt(3);
        char cCharAt15 = str.charAt(4);
        if (cCharAt11 != 'f' && cCharAt11 != 'F') {
            return null;
        }
        if (cCharAt12 != 'a' && cCharAt12 != 'A') {
            return null;
        }
        if (cCharAt13 != 'l' && cCharAt13 != 'L') {
            return null;
        }
        if (cCharAt14 != 's' && cCharAt14 != 'S') {
            return null;
        }
        if (cCharAt15 == 'e' || cCharAt15 == 'E') {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else {
            if (str.equals(str2)) {
                return Boolean.TRUE;
            }
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }

    public static int toInteger(Boolean bool, int i, int i2, int i3) {
        if (bool == null) {
            return i3;
        }
        return bool.booleanValue() ? i : i2;
    }

    public static Integer toIntegerObject(boolean z) {
        return z ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static Integer toIntegerObject(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        if (bool == null) {
            return num3;
        }
        return bool.booleanValue() ? num : num2;
    }

    public static String toString(Boolean bool, String str, String str2, String str3) {
        if (bool == null) {
            return str3;
        }
        return bool.booleanValue() ? str : str2;
    }

    public static String toStringOnOff(boolean z) {
        return toString(z, "on", "off");
    }

    public static String toStringOnOff(Boolean bool) {
        return toString(bool, "on", "off", null);
    }

    public static String toStringTrueFalse(boolean z) {
        return toString(z, "true", "false");
    }

    public static String toStringTrueFalse(Boolean bool) {
        return toString(bool, "true", "false", null);
    }

    public static String toStringYesNo(boolean z) {
        return toString(z, YES, f3980NO);
    }

    public static String toStringYesNo(Boolean bool) {
        return toString(bool, YES, f3980NO, null);
    }

    public static List<Boolean> values() {
        return BOOLEAN_LIST;
    }

    public static boolean xor(boolean... zArr) {
        ObjectUtils.requireNonEmpty(zArr, "array");
        boolean z = false;
        for (boolean z2 : zArr) {
            z ^= z2;
        }
        return z;
    }

    public static Boolean xor(Boolean... boolArr) {
        ObjectUtils.requireNonEmpty(boolArr, "array");
        return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Deprecated
    public BooleanUtils() {
    }
}
