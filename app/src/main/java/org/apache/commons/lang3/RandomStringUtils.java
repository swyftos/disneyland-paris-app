package org.apache.commons.lang3;

import java.util.Random;
import java.util.function.Supplier;
import okhttp3.internal.p166ws.WebSocketProtocol;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes6.dex */
public class RandomStringUtils {
    private static final char[] ALPHANUMERICAL_CHARS;
    private static RandomStringUtils INSECURE;
    private static RandomStringUtils SECURE;
    private static RandomStringUtils SECURE_STRONG;
    private static final Supplier SECURE_SUPPLIER;
    private final Supplier random;

    static {
        Supplier supplier = new Supplier() { // from class: org.apache.commons.lang3.RandomStringUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return RandomUtils.secure();
            }
        };
        SECURE_SUPPLIER = supplier;
        INSECURE = new RandomStringUtils(new Supplier() { // from class: org.apache.commons.lang3.RandomStringUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return RandomUtils.insecure();
            }
        });
        SECURE = new RandomStringUtils(supplier);
        SECURE_STRONG = new RandomStringUtils(new Supplier() { // from class: org.apache.commons.lang3.RandomStringUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return RandomUtils.secureStrong();
            }
        });
        ALPHANUMERICAL_CHARS = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public static RandomStringUtils insecure() {
        return INSECURE;
    }

    @Deprecated
    public static String random(int i) {
        return secure().next(i);
    }

    @Deprecated
    public static String random(int i, boolean z, boolean z2) {
        return secure().next(i, z, z2);
    }

    @Deprecated
    public static String random(int i, char... cArr) {
        return secure().next(i, cArr);
    }

    @Deprecated
    public static String random(int i, int i2, int i3, boolean z, boolean z2) {
        return secure().next(i, i2, i3, z, z2);
    }

    @Deprecated
    public static String random(int i, int i2, int i3, boolean z, boolean z2, char... cArr) {
        return secure().next(i, i2, i3, z, z2, cArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String random(int i, int i2, int i3, boolean z, boolean z2, char[] cArr, Random random) {
        int i4 = i;
        int iMax = i2;
        int length = i3;
        if (i4 == 0) {
            return "";
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Requested random string length " + i + " is less than 0.");
        }
        if (cArr != 0 && cArr.length == 0) {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
        if (iMax == 0 && length == 0) {
            if (cArr != 0) {
                length = cArr.length;
            } else if (z || z2) {
                iMax = 32;
                length = 123;
            } else {
                length = 1114111;
            }
        } else {
            if (length <= iMax) {
                throw new IllegalArgumentException("Parameter end (" + i3 + ") must be greater than start (" + i2 + ")");
            }
            if (iMax < 0 || length < 0) {
                throw new IllegalArgumentException("Character positions MUST be >= 0");
            }
        }
        int iMin = length <= 1114111 ? length : 1114111;
        if (cArr == 0 && iMin <= 127) {
            if (z && z2 && iMax <= 48 && iMin >= 123) {
                return random(i, 0, 0, false, false, ALPHANUMERICAL_CHARS, random);
            }
            if ((z2 && iMin <= 48) || (z && iMin <= 65)) {
                throw new IllegalArgumentException("Parameter end (" + iMin + ") must be greater then (48) for generating digits or greater then (65) for generating letters.");
            }
            if (z && z2) {
                iMax = Math.max(48, iMax);
                iMin = Math.min(123, iMin);
            } else if (z2) {
                iMax = Math.max(48, iMax);
                iMin = Math.min(58, iMin);
            } else if (z) {
                iMax = Math.max(65, iMax);
                iMin = Math.min(123, iMin);
            }
        }
        StringBuilder sb = new StringBuilder(i);
        int iNumberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(iMin - iMax);
        CachedRandomBits cachedRandomBits = new CachedRandomBits((int) Math.min((((((long) i4) * ((long) iNumberOfLeadingZeros)) + 3) / 5) + 10, 429496739L), random);
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                char cNextBits = cachedRandomBits.nextBits(iNumberOfLeadingZeros) + iMax;
                if (cNextBits < iMin) {
                    if (cArr == 0) {
                        int type = Character.getType(cNextBits);
                        if (type == 0 || type == 18 || type == 19) {
                        }
                    } else {
                        cNextBits = cArr[cNextBits];
                    }
                    int iCharCount = Character.charCount(cNextBits);
                    if (i5 != 0 || iCharCount <= 1) {
                        if ((z && Character.isLetter(cNextBits)) || ((z2 && Character.isDigit(cNextBits)) || (!z && !z2))) {
                            sb.appendCodePoint(cNextBits);
                            i4 = iCharCount == 2 ? i4 - 2 : i5;
                        }
                    }
                }
            } else {
                return sb.toString();
            }
        }
    }

    @Deprecated
    public static String random(int i, String str) {
        return secure().next(i, str);
    }

    @Deprecated
    public static String randomAlphabetic(int i) {
        return secure().nextAlphabetic(i);
    }

    @Deprecated
    public static String randomAlphabetic(int i, int i2) {
        return secure().nextAlphabetic(i, i2);
    }

    @Deprecated
    public static String randomAlphanumeric(int i) {
        return secure().nextAlphanumeric(i);
    }

    @Deprecated
    public static String randomAlphanumeric(int i, int i2) {
        return secure().nextAlphanumeric(i, i2);
    }

    @Deprecated
    public static String randomAscii(int i) {
        return secure().nextAscii(i);
    }

    @Deprecated
    public static String randomAscii(int i, int i2) {
        return secure().nextAscii(i, i2);
    }

    @Deprecated
    public static String randomGraph(int i) {
        return secure().nextGraph(i);
    }

    @Deprecated
    public static String randomGraph(int i, int i2) {
        return secure().nextGraph(i, i2);
    }

    @Deprecated
    public static String randomNumeric(int i) {
        return secure().nextNumeric(i);
    }

    @Deprecated
    public static String randomNumeric(int i, int i2) {
        return secure().nextNumeric(i, i2);
    }

    @Deprecated
    public static String randomPrint(int i) {
        return secure().nextPrint(i);
    }

    @Deprecated
    public static String randomPrint(int i, int i2) {
        return secure().nextPrint(i, i2);
    }

    public static RandomStringUtils secure() {
        return SECURE;
    }

    public static RandomStringUtils secureStrong() {
        return SECURE_STRONG;
    }

    @Deprecated
    public RandomStringUtils() {
        this(SECURE_SUPPLIER);
    }

    private RandomStringUtils(Supplier supplier) {
        this.random = supplier;
    }

    public String next(int i) {
        return next(i, false, false);
    }

    public String next(int i, boolean z, boolean z2) {
        return next(i, 0, 0, z, z2);
    }

    public String next(int i, char... cArr) {
        if (cArr == null) {
            return random(i, 0, 0, false, false, null, random());
        }
        return random(i, 0, cArr.length, false, false, cArr, random());
    }

    public String next(int i, int i2, int i3, boolean z, boolean z2) {
        return random(i, i2, i3, z, z2, null, random());
    }

    public String next(int i, int i2, int i3, boolean z, boolean z2, char... cArr) {
        return random(i, i2, i3, z, z2, cArr, random());
    }

    public String next(int i, String str) {
        if (str == null) {
            return random(i, 0, 0, false, false, null, random());
        }
        return next(i, str.toCharArray());
    }

    public String nextAlphabetic(int i) {
        return next(i, true, false);
    }

    public String nextAlphabetic(int i, int i2) {
        return nextAlphabetic(randomUtils().randomInt(i, i2));
    }

    public String nextAlphanumeric(int i) {
        return next(i, true, true);
    }

    public String nextAlphanumeric(int i, int i2) {
        return nextAlphanumeric(randomUtils().randomInt(i, i2));
    }

    public String nextAscii(int i) {
        return next(i, 32, 127, false, false);
    }

    public String nextAscii(int i, int i2) {
        return nextAscii(randomUtils().randomInt(i, i2));
    }

    public String nextGraph(int i) {
        return next(i, 33, WebSocketProtocol.PAYLOAD_SHORT, false, false);
    }

    public String nextGraph(int i, int i2) {
        return nextGraph(randomUtils().randomInt(i, i2));
    }

    public String nextNumeric(int i) {
        return next(i, false, true);
    }

    public String nextNumeric(int i, int i2) {
        return nextNumeric(randomUtils().randomInt(i, i2));
    }

    public String nextPrint(int i) {
        return next(i, 32, WebSocketProtocol.PAYLOAD_SHORT, false, false);
    }

    public String nextPrint(int i, int i2) {
        return nextPrint(randomUtils().randomInt(i, i2));
    }

    private Random random() {
        return randomUtils().random();
    }

    private RandomUtils randomUtils() {
        return (RandomUtils) this.random.get();
    }

    public String toString() {
        return "RandomStringUtils [random=" + random() + "]";
    }
}
