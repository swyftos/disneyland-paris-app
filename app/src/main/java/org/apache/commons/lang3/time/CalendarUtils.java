package org.apache.commons.lang3.time;

import com.facebook.hermes.intl.Constants;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes6.dex */
public class CalendarUtils {
    public static final CalendarUtils INSTANCE = getInstance();
    private final Calendar calendar;
    private final Locale locale;

    public static CalendarUtils getInstance() {
        return new CalendarUtils(Calendar.getInstance());
    }

    static CalendarUtils getInstance(Locale locale) {
        return new CalendarUtils(Calendar.getInstance(locale), locale);
    }

    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), toZoneId(calendar));
    }

    public static OffsetDateTime toOffsetDateTime(Calendar calendar) {
        return OffsetDateTime.ofInstant(calendar.toInstant(), toZoneId(calendar));
    }

    public static ZonedDateTime toZonedDateTime(Calendar calendar) {
        return ZonedDateTime.ofInstant(calendar.toInstant(), toZoneId(calendar));
    }

    private static ZoneId toZoneId(Calendar calendar) {
        return calendar.getTimeZone().toZoneId();
    }

    public CalendarUtils(Calendar calendar) {
        this(calendar, Locale.getDefault());
    }

    CalendarUtils(Calendar calendar, Locale locale) {
        Objects.requireNonNull(calendar, "calendar");
        this.calendar = calendar;
        Objects.requireNonNull(locale, Constants.LOCALE);
        this.locale = locale;
    }

    public int getDayOfMonth() {
        return this.calendar.get(5);
    }

    public int getDayOfYear() {
        return this.calendar.get(6);
    }

    public int getMonth() {
        return this.calendar.get(2);
    }

    String[] getMonthDisplayNames(int i) {
        Map<String, Integer> displayNames = this.calendar.getDisplayNames(2, i, this.locale);
        if (displayNames == null) {
            return null;
        }
        final String[] strArr = new String[displayNames.size()];
        displayNames.forEach(new BiConsumer() { // from class: org.apache.commons.lang3.time.CalendarUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CalendarUtils.lambda$getMonthDisplayNames$0(strArr, (String) obj, (Integer) obj2);
            }
        });
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMonthDisplayNames$0(String[] strArr, String str, Integer num) {
        strArr[num.intValue()] = str;
    }

    String[] getStandaloneLongMonthNames() {
        return getMonthDisplayNames(32770);
    }

    String[] getStandaloneShortMonthNames() {
        return getMonthDisplayNames(32769);
    }

    public int getYear() {
        return this.calendar.get(1);
    }

    public LocalDate toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        return toLocalDateTime(this.calendar);
    }

    public OffsetDateTime toOffsetDateTime() {
        return toOffsetDateTime(this.calendar);
    }

    public ZonedDateTime toZonedDateTime() {
        return toZonedDateTime(this.calendar);
    }
}
