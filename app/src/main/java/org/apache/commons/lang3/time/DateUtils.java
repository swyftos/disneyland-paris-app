package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.LocaleUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    private enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    static final class DateIterator implements Iterator {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        @Override // java.util.Iterator
        public Calendar next() {
            if (this.spot.equals(this.endFinal)) {
                throw new NoSuchElementException();
            }
            this.spot.add(5, 1);
            return (Calendar) this.spot.clone();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static Date add(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i, i2);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        Objects.requireNonNull(calendar, "calendar");
        return modify((Calendar) calendar.clone(), i, ModifyType.CEILING);
    }

    public static Date ceiling(Date date, int i) {
        return modify(toCalendar(date), i, ModifyType.CEILING).getTime();
    }

    public static Date ceiling(Object obj, int i) {
        Objects.requireNonNull(obj, "date");
        if (obj instanceof Date) {
            return ceiling((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return ceiling((Calendar) obj, i).getTime();
        }
        throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
    }

    private static long getFragment(Calendar calendar, int i, TimeUnit timeUnit) {
        long jConvert;
        Objects.requireNonNull(calendar, "calendar");
        TimeUnit timeUnit2 = TimeUnit.DAYS;
        int i2 = timeUnit == timeUnit2 ? 0 : 1;
        if (i == 1) {
            jConvert = timeUnit.convert(calendar.get(6) - i2, timeUnit2);
        } else {
            jConvert = i != 2 ? 0L : timeUnit.convert(calendar.get(5) - i2, timeUnit2);
        }
        if (i == 1 || i == 2 || i == 5 || i == 6) {
            jConvert += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
        } else {
            switch (i) {
                case 11:
                    break;
                case 12:
                    jConvert += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                case 13:
                    return jConvert + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                case 14:
                    return jConvert;
                default:
                    throw new IllegalArgumentException("The fragment " + i + " is not supported");
            }
        }
        jConvert += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
        jConvert += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
        return jConvert + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
    }

    private static long getFragment(Date date, int i, TimeUnit timeUnit) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFragment(calendar, i, timeUnit);
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.DAYS);
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.HOURS);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.SECONDS);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        Objects.requireNonNull(calendar, "cal1");
        Objects.requireNonNull(calendar2, "cal2");
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static boolean isSameDay(Date date, Date date2) {
        return isSameDay(toCalendar(date), toCalendar(date2));
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        Objects.requireNonNull(calendar, "cal1");
        Objects.requireNonNull(calendar2, "cal2");
        return calendar.getTime().getTime() == calendar2.getTime().getTime();
    }

    public static boolean isSameInstant(Date date, Date date2) {
        Objects.requireNonNull(date, "date1");
        Objects.requireNonNull(date2, "date2");
        return date.getTime() == date2.getTime();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        Objects.requireNonNull(calendar, "cal1");
        Objects.requireNonNull(calendar2, "cal2");
        return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006b  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:31:0x007f A[LOOP:0: B:29:0x0079->B:31:0x007f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0089 A[LOOP:1: B:32:0x0083->B:34:0x0089, LOOP_END] */
    public static Iterator<Calendar> iterator(Calendar calendar, int i) {
        Calendar calendarTruncate;
        Calendar calendarTruncate2;
        int i2;
        Objects.requireNonNull(calendar, "calendar");
        int i3 = 2;
        i3 = 1;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                calendarTruncate = truncate(calendar, 5);
                calendarTruncate2 = truncate(calendar, 5);
                if (i == 2) {
                    i2 = 1;
                } else if (i == 3) {
                    i3 = calendar.get(7);
                    i2 = i3 - 1;
                } else if (i != 4) {
                    i2 = 7;
                } else {
                    int i4 = calendar.get(7) - 3;
                    i2 = calendar.get(7) + 3;
                    i3 = i4;
                }
                if (i3 < 1) {
                    i3 += 7;
                }
                if (i3 > 7) {
                    i3 -= 7;
                }
                if (i2 < 1) {
                    i2 += 7;
                }
                if (i2 > 7) {
                    i2 -= 7;
                }
                while (calendarTruncate.get(7) != i3) {
                    calendarTruncate.add(5, -1);
                }
                while (calendarTruncate2.get(7) != i2) {
                    calendarTruncate2.add(5, 1);
                }
                return new DateIterator(calendarTruncate, calendarTruncate2);
            case 5:
            case 6:
                Calendar calendarTruncate3 = truncate(calendar, 2);
                Calendar calendar2 = (Calendar) calendarTruncate3.clone();
                calendar2.add(2, 1);
                calendar2.add(5, -1);
                if (i == 6) {
                    calendarTruncate2 = calendar2;
                    calendarTruncate = calendarTruncate3;
                    i2 = 1;
                    if (i3 < 1) {
                        i3 += 7;
                    }
                    if (i3 > 7) {
                        i3 -= 7;
                    }
                    if (i2 < 1) {
                        i2 += 7;
                    }
                    if (i2 > 7) {
                        i2 -= 7;
                    }
                    while (calendarTruncate.get(7) != i3) {
                        calendarTruncate.add(5, -1);
                    }
                    while (calendarTruncate2.get(7) != i2) {
                        calendarTruncate2.add(5, 1);
                    }
                    return new DateIterator(calendarTruncate, calendarTruncate2);
                }
                calendarTruncate2 = calendar2;
                calendarTruncate = calendarTruncate3;
                i2 = 7;
                if (i3 < 1) {
                    i3 += 7;
                }
                if (i3 > 7) {
                    i3 -= 7;
                }
                if (i2 < 1) {
                    i2 += 7;
                }
                if (i2 > 7) {
                    i2 -= 7;
                }
                while (calendarTruncate.get(7) != i3) {
                    calendarTruncate.add(5, -1);
                }
                while (calendarTruncate2.get(7) != i2) {
                    calendarTruncate2.add(5, 1);
                }
                return new DateIterator(calendarTruncate, calendarTruncate2);
            default:
                throw new IllegalArgumentException("The range style " + i + " is not valid.");
        }
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        return iterator(toCalendar(date), i);
    }

    public static Iterator<?> iterator(Object obj, int i) {
        Objects.requireNonNull(obj, "calendar");
        if (obj instanceof Date) {
            return iterator((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return iterator((Calendar) obj, i);
        }
        throw new ClassCastException("Could not iterate based on " + obj);
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00cb  */
    private static Calendar modify(Calendar calendar, int i, ModifyType modifyType) {
        char c;
        int i2;
        boolean z;
        char c2;
        if (calendar.get(1) > 280000000) {
            throw new ArithmeticException("Calendar value too large for accurate calculations");
        }
        if (i == 14) {
            return calendar;
        }
        Date time = calendar.getTime();
        long time2 = time.getTime();
        int i3 = calendar.get(14);
        ModifyType modifyType2 = ModifyType.TRUNCATE;
        if (modifyType2 == modifyType || i3 < 500) {
            time2 -= (long) i3;
        }
        boolean z2 = i == 13;
        int i4 = calendar.get(13);
        if (!z2 && (modifyType2 == modifyType || i4 < 30)) {
            time2 -= ((long) i4) * 1000;
        }
        if (i == 12) {
            z2 = true;
        }
        int i5 = calendar.get(12);
        if (!z2 && (modifyType2 == modifyType || i5 < 30)) {
            time2 -= ((long) i5) * 60000;
        }
        if (time.getTime() != time2) {
            time.setTime(time2);
            calendar.setTime(time);
        }
        boolean z3 = false;
        for (int[] iArr : fields) {
            for (int i6 : iArr) {
                if (i6 == i) {
                    if (modifyType == ModifyType.CEILING || (modifyType == ModifyType.ROUND && z3)) {
                        if (i == 1001) {
                            if (calendar.get(5) == 1) {
                                calendar.add(5, 15);
                            } else {
                                calendar.add(5, -15);
                                calendar.add(2, 1);
                            }
                        } else if (i == 9) {
                            if (calendar.get(11) == 0) {
                                calendar.add(11, 12);
                            } else {
                                calendar.add(11, -12);
                                calendar.add(5, 1);
                            }
                        } else {
                            calendar.add(iArr[0], 1);
                        }
                    }
                    return calendar;
                }
            }
            if (i != 9) {
                if (i == 1001 && iArr[0] == 5) {
                    int i7 = calendar.get(5);
                    int i8 = i7 - 1;
                    i2 = i8 >= 15 ? i7 - 16 : i8;
                    z3 = i2 > 7;
                    z = true;
                    c = '\f';
                } else {
                    c = '\f';
                    i2 = 0;
                    z = false;
                }
            } else if (iArr[0] == 11) {
                int i9 = calendar.get(11);
                c = '\f';
                if (i9 >= 12) {
                    i9 -= 12;
                }
                int i10 = i9;
                z3 = i10 >= 6;
                i2 = i10;
                z = true;
            } else {
                c = '\f';
                i2 = 0;
                z = false;
            }
            if (z) {
                c2 = 0;
            } else {
                c2 = 0;
                int actualMinimum = calendar.getActualMinimum(iArr[0]);
                int actualMaximum = calendar.getActualMaximum(iArr[0]);
                int i11 = calendar.get(iArr[0]) - actualMinimum;
                z3 = i11 > (actualMaximum - actualMinimum) / 2;
                i2 = i11;
            }
            if (i2 != 0) {
                int i12 = iArr[c2];
                calendar.set(i12, calendar.get(i12) - i2);
            }
        }
        throw new IllegalArgumentException("The field " + i + " is not supported");
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, null, strArr);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, false);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, null, strArr);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        Objects.requireNonNull(str, "str");
        Objects.requireNonNull(strArr, "parsePatterns");
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale2 = LocaleUtils.toLocale(locale);
        ParsePosition parsePosition = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance(timeZone, locale2);
        calendar.setLenient(z);
        for (String str2 : strArr) {
            FastDateParser fastDateParser = new FastDateParser(str2, timeZone, locale2);
            calendar.clear();
            try {
                if (fastDateParser.parse(str, parsePosition, calendar) && parsePosition.getIndex() == str.length()) {
                    return calendar.getTime();
                }
            } catch (IllegalArgumentException unused) {
            }
            parsePosition.setIndex(0);
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Calendar round(Calendar calendar, int i) {
        Objects.requireNonNull(calendar, "calendar");
        return modify((Calendar) calendar.clone(), i, ModifyType.ROUND);
    }

    public static Date round(Date date, int i) {
        return modify(toCalendar(date), i, ModifyType.ROUND).getTime();
    }

    public static Date round(Object obj, int i) {
        Objects.requireNonNull(obj, "date");
        if (obj instanceof Date) {
            return round((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return round((Calendar) obj, i).getTime();
        }
        throw new ClassCastException("Could not round " + obj);
    }

    private static Date set(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(i, i2);
        return calendar.getTime();
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        Objects.requireNonNull(date, "date");
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar toCalendar(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        Objects.requireNonNull(date, "date");
        calendar.setTime(date);
        return calendar;
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return toLocalDateTime(date, TimeZone.getDefault());
    }

    public static LocalDateTime toLocalDateTime(Date date, TimeZone timeZone) {
        return LocalDateTime.ofInstant(date.toInstant(), toZoneId(timeZone));
    }

    public static OffsetDateTime toOffsetDateTime(Date date) {
        return toOffsetDateTime(date, TimeZone.getDefault());
    }

    public static OffsetDateTime toOffsetDateTime(Date date, TimeZone timeZone) {
        return OffsetDateTime.ofInstant(date.toInstant(), toZoneId(timeZone));
    }

    public static ZonedDateTime toZonedDateTime(Date date) {
        return toZonedDateTime(date, TimeZone.getDefault());
    }

    public static ZonedDateTime toZonedDateTime(Date date, TimeZone timeZone) {
        return ZonedDateTime.ofInstant(date.toInstant(), toZoneId(timeZone));
    }

    private static ZoneId toZoneId(TimeZone timeZone) {
        return TimeZones.toTimeZone(timeZone).toZoneId();
    }

    public static Calendar truncate(Calendar calendar, int i) {
        Objects.requireNonNull(calendar, "date");
        return modify((Calendar) calendar.clone(), i, ModifyType.TRUNCATE);
    }

    public static Date truncate(Date date, int i) {
        return modify(toCalendar(date), i, ModifyType.TRUNCATE).getTime();
    }

    public static Date truncate(Object obj, int i) {
        Objects.requireNonNull(obj, "date");
        if (obj instanceof Date) {
            return truncate((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return truncate((Calendar) obj, i).getTime();
        }
        throw new ClassCastException("Could not truncate " + obj);
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }

    private static void validateDateNotNull(Date date) {
        Objects.requireNonNull(date, "date");
    }

    @Deprecated
    public DateUtils() {
    }
}
