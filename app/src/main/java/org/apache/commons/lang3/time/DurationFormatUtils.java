package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes6.dex */
public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

    static final class Token {
        private static final Token[] EMPTY_ARRAY = new Token[0];
        private int count;
        private int optionalIndex;
        private final CharSequence value;

        static boolean containsTokenWithValue(Token[] tokenArr, final Object obj) {
            return Stream.of((Object[]) tokenArr).anyMatch(new Predicate() { // from class: org.apache.commons.lang3.time.DurationFormatUtils$Token$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    return DurationFormatUtils.Token.lambda$containsTokenWithValue$0(obj, (DurationFormatUtils.Token) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$containsTokenWithValue$0(Object obj, Token token) {
            return token.getValue() == obj;
        }

        Token(CharSequence charSequence, boolean z, int i) {
            this.optionalIndex = -1;
            Objects.requireNonNull(charSequence, "value");
            this.value = charSequence;
            this.count = 1;
            if (z) {
                this.optionalIndex = i;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            CharSequence charSequence = this.value;
            if (charSequence instanceof StringBuilder) {
                return charSequence.toString().equals(token.value.toString());
            }
            if (charSequence instanceof Number) {
                return charSequence.equals(token.value);
            }
            return charSequence == token.value;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0179 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x016a A[ADDED_TO_REGION] */
    static String format(Token[] tokenArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int length;
        boolean z2;
        boolean z3;
        Token[] tokenArr2 = tokenArr;
        StringBuilder sb = new StringBuilder();
        int length2 = tokenArr2.length;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i2 = -1;
        int i3 = -1;
        while (i < length2) {
            Token token = tokenArr2[i];
            Object value = token.getValue();
            int i4 = length2;
            boolean z8 = value instanceof StringBuilder;
            int i5 = i;
            int count = token.getCount();
            if (i2 == token.optionalIndex) {
                length = i3;
            } else {
                i2 = token.optionalIndex;
                if (i2 > -1) {
                    z5 = false;
                    z6 = false;
                    length = sb.length();
                    z4 = true;
                } else {
                    z4 = false;
                    length = i3;
                }
            }
            if (!z8) {
                if (value.equals("y")) {
                    z3 = j == 0;
                    if (!z4 || !z3) {
                        sb.append(paddedValue(j, z, count));
                    }
                } else if (value.equals("M")) {
                    z3 = j2 == 0;
                    if (!z4 || !z3) {
                        sb.append(paddedValue(j2, z, count));
                    }
                } else if (value.equals("d")) {
                    z3 = j3 == 0;
                    if (!z4 || !z3) {
                        sb.append(paddedValue(j3, z, count));
                    }
                } else if (value.equals("H")) {
                    z3 = j4 == 0;
                    if (!z4 || !z3) {
                        sb.append(paddedValue(j4, z, count));
                    }
                } else {
                    if (value.equals("m")) {
                        z3 = j5 == 0;
                        if (!z4 || !z3) {
                            sb.append(paddedValue(j5, z, count));
                        }
                    } else if (value.equals(CmcdData.Factory.STREAMING_FORMAT_SS)) {
                        boolean z9 = j6 == 0;
                        if (!z4 || !z9) {
                            sb.append(paddedValue(j6, z, count));
                        }
                        z5 = z9;
                        z2 = true;
                        z7 = true;
                    } else if (value.equals(ExifInterface.LATITUDE_SOUTH)) {
                        sb = sb;
                        boolean z10 = j7 == 0;
                        if (z4 && z10) {
                            z2 = true;
                        } else if (z7) {
                            sb.append(paddedValue(j7, true, z ? Math.max(3, count) : 3));
                            z2 = true;
                        } else {
                            z2 = true;
                            sb.append(paddedValue(j7, z, count));
                        }
                        z5 = z10;
                        z7 = false;
                    }
                    if (!z4 && !z8 && !z6) {
                        if (z5) {
                            sb.delete(length, sb.length());
                        }
                        z6 = z2;
                    }
                    i = i5 + 1;
                    tokenArr2 = tokenArr;
                    sb = sb;
                    i3 = length;
                    length2 = i4;
                }
                z5 = z3;
                z7 = false;
                z2 = true;
                if (!z4) {
                }
                i = i5 + 1;
                tokenArr2 = tokenArr;
                sb = sb;
                i3 = length;
                length2 = i4;
            } else if (!z4 || !z5) {
                sb.append(value.toString());
            }
            sb = sb;
            z2 = true;
            if (!z4) {
            }
            i = i5 + 1;
            tokenArr2 = tokenArr;
            sb = sb;
            i3 = length;
            length2 = i4;
        }
        return sb.toString();
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Validate.inclusiveBetween(0L, Long.MAX_VALUE, j, "durationMillis must not be negative");
        Token[] tokenArrLexx = lexx(str);
        if (Token.containsTokenWithValue(tokenArrLexx, "d")) {
            long j8 = j / 86400000;
            j2 = j - (86400000 * j8);
            j3 = j8;
        } else {
            j2 = j;
            j3 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, "H")) {
            long j9 = j2 / 3600000;
            j2 -= 3600000 * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, "m")) {
            long j10 = j2 / 60000;
            j2 -= 60000 * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, CmcdData.Factory.STREAMING_FORMAT_SS)) {
            long j11 = j2 / 1000;
            j7 = j2 - (1000 * j11);
            j6 = j11;
        } else {
            j6 = 0;
            j7 = j2;
        }
        return format(tokenArrLexx, 0L, 0L, j3, j4, j5, j6, j7, z);
    }

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String duration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            duration = " " + duration;
            Strings strings = Strings.f3987CS;
            String strReplaceOnce = strings.replaceOnce(duration, " 0 days", "");
            if (strReplaceOnce.length() != duration.length()) {
                String strReplaceOnce2 = strings.replaceOnce(strReplaceOnce, " 0 hours", "");
                duration = strReplaceOnce2.length() != strReplaceOnce.length() ? strings.replaceOnce(strReplaceOnce2, " 0 minutes", "") : strReplaceOnce;
            }
            if (!duration.isEmpty()) {
                duration = duration.substring(1);
            }
        }
        if (z2) {
            Strings strings2 = Strings.f3987CS;
            String strReplaceOnce3 = strings2.replaceOnce(duration, " 0 seconds", "");
            if (strReplaceOnce3.length() != duration.length()) {
                duration = strings2.replaceOnce(strReplaceOnce3, " 0 minutes", "");
                if (duration.length() != strReplaceOnce3.length()) {
                    String strReplaceOnce4 = strings2.replaceOnce(duration, " 0 hours", "");
                    if (strReplaceOnce4.length() != duration.length()) {
                        duration = strings2.replaceOnce(strReplaceOnce4, " 0 days", "");
                    }
                } else {
                    duration = strReplaceOnce3;
                }
            }
        }
        String str = " " + duration;
        Strings strings3 = Strings.f3987CS;
        return strings3.replaceOnce(strings3.replaceOnce(strings3.replaceOnce(strings3.replaceOnce(str, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        long j3;
        int i;
        Validate.isTrue(j <= j2, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] tokenArrLexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        long j4 = calendar2.get(14) - calendar.get(14);
        int i2 = calendar2.get(13) - calendar.get(13);
        int i3 = calendar2.get(12) - calendar.get(12);
        int i4 = calendar2.get(11) - calendar.get(11);
        int actualMaximum = calendar2.get(5) - calendar.get(5);
        int i5 = calendar2.get(2) - calendar.get(2);
        int i6 = calendar2.get(1) - calendar.get(1);
        while (j4 < 0) {
            j4 += 1000;
            i2--;
        }
        while (i2 < 0) {
            i2 += 60;
            i3--;
        }
        while (i3 < 0) {
            i3 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 24;
            actualMaximum--;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, "M")) {
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i5--;
                calendar.add(2, 1);
            }
            while (i5 < 0) {
                i5 += 12;
                i6--;
            }
            if (!Token.containsTokenWithValue(tokenArrLexx, "y") && i6 != 0) {
                while (i6 != 0) {
                    i5 += i6 * 12;
                    i6 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(tokenArrLexx, "y")) {
                int i7 = calendar2.get(1);
                if (i5 < 0) {
                    i7--;
                }
                while (calendar.get(1) != i7) {
                    int actualMaximum2 = actualMaximum + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum2++;
                    }
                    calendar.add(1, 1);
                    actualMaximum = actualMaximum2 + calendar.get(6);
                }
                i6 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                actualMaximum += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i5 = 0;
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i5--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, "d")) {
            i4 += actualMaximum * 24;
            actualMaximum = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, "H")) {
            i3 += i4 * 60;
            i4 = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, "m")) {
            i2 += i3 * 60;
            i3 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, CmcdData.Factory.STREAMING_FORMAT_SS)) {
            j3 = j4;
            i = i2;
        } else {
            j3 = j4 + (((long) i2) * 1000);
            i = 0;
        }
        return format(tokenArrLexx, i6, i5, actualMaximum, i4, i3, i, j3, z);
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    static Token[] lexx(String str) {
        String str2;
        ArrayList arrayList = new ArrayList(str.length());
        int i = -1;
        boolean z = false;
        boolean z2 = false;
        StringBuilder sb = null;
        Token token = null;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!z || cCharAt == '\'') {
                if (cCharAt != '\'') {
                    if (cCharAt == 'H') {
                        str2 = "H";
                    } else if (cCharAt == 'M') {
                        str2 = "M";
                    } else if (cCharAt == 'S') {
                        str2 = ExifInterface.LATITUDE_SOUTH;
                    } else if (cCharAt != '[') {
                        if (cCharAt == ']') {
                            if (!z2) {
                                throw new IllegalArgumentException("Attempting to close unopened optional block at index: " + i2);
                            }
                            z2 = false;
                        } else if (cCharAt == 'd') {
                            str2 = "d";
                        } else if (cCharAt == 'm') {
                            str2 = "m";
                        } else if (cCharAt == 's') {
                            str2 = CmcdData.Factory.STREAMING_FORMAT_SS;
                        } else if (cCharAt == 'y') {
                            str2 = "y";
                        } else {
                            if (sb == null) {
                                sb = new StringBuilder();
                                arrayList.add(new Token(sb, z2, i));
                            }
                            sb.append(cCharAt);
                        }
                        str2 = null;
                    } else {
                        if (z2) {
                            throw new IllegalArgumentException("Nested optional block at index: " + i2);
                        }
                        i++;
                        str2 = null;
                        z2 = true;
                    }
                } else if (z) {
                    z = false;
                    sb = null;
                    str2 = null;
                } else {
                    sb = new StringBuilder();
                    arrayList.add(new Token(sb, z2, i));
                    str2 = null;
                    z = true;
                }
                if (str2 != null) {
                    if (token != null && token.getValue().equals(str2)) {
                        token.increment();
                    } else {
                        token = new Token(str2, z2, i);
                        arrayList.add(token);
                    }
                    sb = null;
                }
            } else {
                sb.append(cCharAt);
            }
        }
        if (z) {
            throw new IllegalArgumentException("Unmatched quote in format: " + str);
        }
        if (!z2) {
            return (Token[]) arrayList.toArray(Token.EMPTY_ARRAY);
        }
        throw new IllegalArgumentException("Unmatched optional in format: " + str);
    }

    private static String paddedValue(long j, boolean z, int i) {
        String string = Long.toString(j);
        return z ? StringUtils.leftPad(string, i, '0') : string;
    }

    @Deprecated
    public DurationFormatUtils() {
    }
}
