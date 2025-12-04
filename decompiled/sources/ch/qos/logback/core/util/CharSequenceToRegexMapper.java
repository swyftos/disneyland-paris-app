package ch.qos.logback.core.util;

import java.text.DateFormatSymbols;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;

/* loaded from: classes2.dex */
class CharSequenceToRegexMapper {
    DateFormatSymbols symbols = DateFormatSymbols.getInstance();

    CharSequenceToRegexMapper() {
    }

    static int[] findMinMaxLengthsInSymbols(String[] strArr) {
        int iMin = Integer.MAX_VALUE;
        int iMax = 0;
        for (String str : strArr) {
            int length = str.length();
            if (length != 0) {
                iMin = Math.min(iMin, length);
                iMax = Math.max(iMax, length);
            }
        }
        return new int[]{iMin, iMax};
    }

    private String getRegexForAmPms() {
        return symbolArrayToRegex(this.symbols.getAmPmStrings());
    }

    private String getRegexForLongDaysOfTheWeek() {
        return symbolArrayToRegex(this.symbols.getWeekdays());
    }

    private String getRegexForLongMonths() {
        return symbolArrayToRegex(this.symbols.getMonths());
    }

    private String getRegexForShortDaysOfTheWeek() {
        return symbolArrayToRegex(this.symbols.getShortWeekdays());
    }

    private String number(int i) {
        return "\\d{" + i + "}";
    }

    private String symbolArrayToRegex(String[] strArr) {
        int[] iArrFindMinMaxLengthsInSymbols = findMinMaxLengthsInSymbols(strArr);
        return ".{" + iArrFindMinMaxLengthsInSymbols[0] + "," + iArrFindMinMaxLengthsInSymbols[1] + "}";
    }

    String getRegexForShortMonths() {
        return symbolArrayToRegex(this.symbols.getShortMonths());
    }

    String toRegex(CharSequenceState charSequenceState) {
        StringBuilder sb;
        int i = charSequenceState.occurrences;
        char c = charSequenceState.c;
        if (c != 'y') {
            if (c == 'z') {
                return ".*";
            }
            switch (c) {
                case '\'':
                    if (i == 1) {
                        return "";
                    }
                    throw new IllegalStateException("Too many single quotes");
                case '.':
                    return "\\.";
                case EACTags.DEPRECATED /* 75 */:
                case 'S':
                case 'W':
                case 'd':
                case 'h':
                case PublicKeyAlgorithmTags.EXPERIMENTAL_8 /* 107 */:
                case 'm':
                case 's':
                case 'w':
                    break;
                case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                    return i <= 2 ? number(i) : i == 3 ? getRegexForShortMonths() : getRegexForLongMonths();
                case 'Z':
                    return "(\\+|-)\\d{4}";
                case '\\':
                    throw new IllegalStateException("Forward slashes are not allowed");
                case 'a':
                    return getRegexForAmPms();
                default:
                    switch (c) {
                        case 'D':
                        case 'F':
                        case 'H':
                            break;
                        case EACTags.DISPLAY_IMAGE /* 69 */:
                            return i >= 4 ? getRegexForLongDaysOfTheWeek() : getRegexForShortDaysOfTheWeek();
                        case 'G':
                            return ".*";
                        default:
                            if (i == 1) {
                                sb = new StringBuilder();
                                sb.append("");
                                sb.append(c);
                            } else {
                                sb = new StringBuilder();
                                sb.append(c);
                                sb.append("{");
                                sb.append(i);
                                sb.append("}");
                            }
                            return sb.toString();
                    }
            }
        }
        return number(i);
    }
}
