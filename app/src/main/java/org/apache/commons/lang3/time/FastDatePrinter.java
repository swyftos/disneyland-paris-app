package org.apache.commons.lang3.time;

import androidx.media3.extractor.p007ts.TsExtractor;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.disney.p026id.android.tracker.OneIDTracker;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: loaded from: classes6.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final long serialVersionUID = 1;
    private final Locale locale;
    private transient int maxLengthEstimate;
    private final String pattern;
    private transient Rule[] rules;
    private final TimeZone timeZone;
    private static final Rule[] EMPTY_RULE_ARRAY = new Rule[0];
    private static final ConcurrentMap timeZoneDisplayCache = new ConcurrentHashMap(7);

    private interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i);
    }

    private interface Rule {
        void appendTo(Appendable appendable, Calendar calendar);

        int estimateLength();
    }

    private static final class CharacterLiteral implements Rule {
        private final char value;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }

        CharacterLiteral(char c) {
            this.value = c;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.value);
        }
    }

    private static final class DayInWeekField implements NumberRule {
        private final NumberRule rule;

        DayInWeekField(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            int i = calendar.get(7);
            this.rule.appendTo(appendable, i != 1 ? i - 1 : 7);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }
    }

    private static final class Iso8601_Rule implements Rule {
        private final int length;
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        static Iso8601_Rule getRule(int i) {
            if (i == 1) {
                return ISO8601_HOURS;
            }
            if (i == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        Iso8601_Rule(int i) {
            this.length = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i == 0) {
                appendable.append("Z");
                return;
            }
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            int i3 = this.length;
            if (i3 < 5) {
                return;
            }
            if (i3 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC) - (i2 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    private static final class PaddedNumberField implements NumberRule {
        private final int field;
        private final int size;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.field = i;
            this.size = i2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.field));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i, this.size);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.size;
        }
    }

    private static final class StringLiteral implements Rule {
        private final String value;

        StringLiteral(String str) {
            this.value = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.value);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.value.length();
        }
    }

    private static final class TextField implements Rule {
        private final int field;
        private final String[] values;

        TextField(int i, String[] strArr) {
            this.field = i;
            this.values = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.values[calendar.get(this.field)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.values.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.values[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class TimeZoneDisplayKey {
        private final Locale locale;
        private final int style;
        private final TimeZone timeZone;

        TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.timeZone = timeZone;
            if (z) {
                this.style = Integer.MIN_VALUE | i;
            } else {
                this.style = i;
            }
            this.locale = LocaleUtils.toLocale(locale);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.timeZone.equals(timeZoneDisplayKey.timeZone) && this.style == timeZoneDisplayKey.style && this.locale.equals(timeZoneDisplayKey.locale);
        }

        public int hashCode() {
            return (((this.style * 31) + this.locale.hashCode()) * 31) + this.timeZone.hashCode();
        }
    }

    private static final class TimeZoneNameRule implements Rule {
        private final String daylight;
        private final Locale locale;
        private final String standard;
        private final int style;

        TimeZoneNameRule(TimeZone timeZone, Locale locale, int i) {
            this.locale = LocaleUtils.toLocale(locale);
            this.style = i;
            this.standard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i, locale);
            this.daylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(FastDatePrinter.getTimeZoneDisplay(calendar.getTimeZone(), calendar.get(16) != 0, this.style, this.locale));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.standard.length(), this.daylight.length());
        }
    }

    private static final class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        private final boolean colon;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }

        TimeZoneNumberRule(boolean z) {
            this.colon = z;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            if (this.colon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC) - (i2 * 60));
        }
    }

    private static final class TwelveHourField implements NumberRule {
        private final NumberRule rule;

        TwelveHourField(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.rule.appendTo(appendable, leastMaximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }
    }

    private static final class TwentyFourHourField implements NumberRule {
        private final NumberRule rule;

        TwentyFourHourField(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.rule.appendTo(appendable, maximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }
    }

    private static final class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        TwoDigitMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }
    }

    private static final class TwoDigitNumberField implements NumberRule {
        private final int field;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        TwoDigitNumberField(int i) {
            this.field = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.field));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 2);
            }
        }
    }

    private static final class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        TwoDigitYearField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i % 100);
        }
    }

    private static final class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        UnpaddedMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            if (i >= 10) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                appendable.append((char) (i + 48));
            }
        }
    }

    private static final class UnpaddedNumberField implements NumberRule {
        private final int field;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        UnpaddedNumberField(int i) {
            this.field = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.field));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 1);
            }
        }
    }

    private static final class WeekYear implements NumberRule {
        private final NumberRule rule;

        WeekYear(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.rule.appendTo(appendable, calendar.getWeekYear());
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i) throws IOException {
        appendable.append((char) ((i / 10) + 48));
        appendable.append((char) ((i % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i, int i2) throws IOException {
        int i3;
        if (i < 10000) {
            if (i >= 1000) {
                i3 = 4;
            } else if (i < 100) {
                i3 = i < 10 ? 1 : 2;
            } else {
                i3 = 3;
            }
            for (int i4 = i2 - i3; i4 > 0; i4--) {
                appendable.append('0');
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return;
                        }
                        appendable.append((char) ((i / 1000) + 48));
                        i %= 1000;
                    }
                    if (i >= 100) {
                        appendable.append((char) ((i / 100) + 48));
                        i %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i >= 10) {
                    appendable.append((char) ((i / 10) + 48));
                    i %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i + 48));
            return;
        }
        char[] cArr = new char[10];
        int i5 = 0;
        while (i != 0) {
            cArr[i5] = (char) ((i % 10) + 48);
            i /= 10;
            i5++;
        }
        while (i5 < i2) {
            appendable.append('0');
            i2--;
        }
        while (true) {
            i5--;
            if (i5 < 0) {
                return;
            } else {
                appendable.append(cArr[i5]);
            }
        }
    }

    static String getTimeZoneDisplay(final TimeZone timeZone, final boolean z, final int i, final Locale locale) {
        return (String) timeZoneDisplayCache.computeIfAbsent(new TimeZoneDisplayKey(timeZone, z, i, locale), new Function() { // from class: org.apache.commons.lang3.time.FastDatePrinter$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FastDatePrinter.lambda$getTimeZoneDisplay$0(timeZone, z, i, locale, (FastDatePrinter.TimeZoneDisplayKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getTimeZoneDisplay$0(TimeZone timeZone, boolean z, int i, Locale locale, TimeZoneDisplayKey timeZoneDisplayKey) {
        return timeZone.getDisplayName(z, i, locale);
    }

    protected FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = LocaleUtils.toLocale(locale);
        init();
    }

    private Appendable applyRules(Calendar calendar, Appendable appendable) {
        try {
            for (Rule rule : this.rules) {
                rule.appendTo(appendable, calendar);
            }
        } catch (IOException e) {
            ExceptionUtils.asRuntimeException(e);
        }
        return appendable;
    }

    @Deprecated
    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Appendable) stringBuffer);
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, new StringBuilder(this.maxLengthEstimate))).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.pattern.equals(fastDatePrinter.pattern) && this.timeZone.equals(fastDatePrinter.timeZone) && this.locale.equals(fastDatePrinter.locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, new StringBuilder(this.maxLengthEstimate))).toString();
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b) {
        if (!calendar.getTimeZone().equals(this.timeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.timeZone);
        }
        return (B) applyRules(calendar, b);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return applyRulesToString(calendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return (B) applyRules(calendarNewCalendar, b);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return (StringBuffer) applyRules(calendarNewCalendar, (Appendable) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j);
        return applyRulesToString(calendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j, B b) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j);
        return (B) applyRules(calendarNewCalendar, b);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j, StringBuffer stringBuffer) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j);
        return (StringBuffer) applyRules(calendarNewCalendar, (Appendable) stringBuffer);
    }

    String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        throw new IllegalArgumentException("Unknown class: " + ClassUtils.getName(obj, "<null>"));
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        throw new IllegalArgumentException("Unknown class: " + ClassUtils.getName(obj, "<null>"));
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    public int getMaxLengthEstimate() {
        return this.maxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    private void init() {
        Rule[] ruleArr = (Rule[]) parsePattern().toArray(EMPTY_RULE_ARRAY);
        this.rules = ruleArr;
        int length = ruleArr.length;
        int iEstimateLength = 0;
        while (true) {
            length--;
            if (length >= 0) {
                iEstimateLength += this.rules[length].estimateLength();
            } else {
                this.maxLengthEstimate = iEstimateLength;
                return;
            }
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.timeZone, this.locale);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:81:0x0147  */
    /* JADX WARN: Code duplicated, block: B:82:0x014a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0156  */
    protected List<Rule> parsePattern() {
        int i;
        Object stringLiteral;
        Object textField;
        NumberRule numberRuleSelectNumberRule;
        Object weekYear;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.locale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.pattern.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int[] iArr = {i3};
            String token = parseToken(this.pattern, iArr);
            int i4 = iArr[i2];
            int length2 = token.length();
            if (length2 == 0) {
                return arrayList;
            }
            char cCharAt = token.charAt(i2);
            if (cCharAt != '\'') {
                if (cCharAt == 'S') {
                    textField = selectNumberRule(14, length2);
                } else if (cCharAt == 'a') {
                    textField = new TextField(9, amPmStrings);
                } else if (cCharAt == 'd') {
                    textField = selectNumberRule(5, length2);
                } else if (cCharAt == 'h') {
                    textField = new TwelveHourField(selectNumberRule(10, length2));
                } else if (cCharAt == 'k') {
                    textField = new TwentyFourHourField(selectNumberRule(11, length2));
                } else if (cCharAt == 'm') {
                    textField = selectNumberRule(12, length2);
                } else if (cCharAt == 's') {
                    textField = selectNumberRule(13, length2);
                } else if (cCharAt == 'u') {
                    textField = new DayInWeekField(selectNumberRule(7, length2));
                } else if (cCharAt == 'w') {
                    textField = selectNumberRule(3, length2);
                } else if (cCharAt == 'y') {
                    if (length2 == 2) {
                        numberRuleSelectNumberRule = TwoDigitYearField.INSTANCE;
                    } else {
                        numberRuleSelectNumberRule = selectNumberRule(1, Math.max(length2, 4));
                    }
                    textField = numberRuleSelectNumberRule;
                    if (cCharAt == 'Y') {
                        weekYear = new WeekYear(numberRuleSelectNumberRule);
                        textField = weekYear;
                    }
                } else if (cCharAt != 'z') {
                    switch (cCharAt) {
                        case 'D':
                            textField = selectNumberRule(6, length2);
                            break;
                        case EACTags.DISPLAY_IMAGE /* 69 */:
                            textField = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                            break;
                        case 'F':
                            textField = selectNumberRule(8, length2);
                            break;
                        case 'G':
                            textField = new TextField(0, eras);
                            i = 0;
                            break;
                        case 'H':
                            textField = selectNumberRule(11, length2);
                            break;
                        default:
                            switch (cCharAt) {
                                case EACTags.DEPRECATED /* 75 */:
                                    textField = selectNumberRule(10, length2);
                                    break;
                                case 'L':
                                    if (length2 >= 4) {
                                        weekYear = new TextField(2, CalendarUtils.getInstance(this.locale).getStandaloneLongMonthNames());
                                    } else if (length2 == 3) {
                                        weekYear = new TextField(2, CalendarUtils.getInstance(this.locale).getStandaloneShortMonthNames());
                                    } else if (length2 == 2) {
                                        textField = TwoDigitMonthField.INSTANCE;
                                    } else {
                                        textField = UnpaddedMonthField.INSTANCE;
                                    }
                                    textField = weekYear;
                                    break;
                                case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                                    if (length2 >= 4) {
                                        weekYear = new TextField(2, months);
                                    } else if (length2 == 3) {
                                        weekYear = new TextField(2, shortMonths);
                                    } else if (length2 == 2) {
                                        textField = TwoDigitMonthField.INSTANCE;
                                    } else {
                                        textField = UnpaddedMonthField.INSTANCE;
                                    }
                                    textField = weekYear;
                                    break;
                                default:
                                    switch (cCharAt) {
                                        case 'W':
                                            textField = selectNumberRule(4, length2);
                                            break;
                                        case SyslogConstants.LOG_FTP /* 88 */:
                                            textField = Iso8601_Rule.getRule(length2);
                                            break;
                                        case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                                            if (length2 == 2) {
                                                numberRuleSelectNumberRule = TwoDigitYearField.INSTANCE;
                                            } else {
                                                numberRuleSelectNumberRule = selectNumberRule(1, Math.max(length2, 4));
                                            }
                                            textField = numberRuleSelectNumberRule;
                                            if (cCharAt == 'Y') {
                                                weekYear = new WeekYear(numberRuleSelectNumberRule);
                                                textField = weekYear;
                                            }
                                            break;
                                        case 'Z':
                                            if (length2 == 1) {
                                                textField = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                            } else if (length2 == 2) {
                                                textField = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                            } else {
                                                textField = TimeZoneNumberRule.INSTANCE_COLON;
                                            }
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Illegal pattern component: " + token);
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    textField = new TimeZoneNameRule(this.timeZone, this.locale, length2 >= 4 ? 1 : 0);
                }
                i = 0;
            } else {
                String strSubstring = token.substring(1);
                if (strSubstring.length() == 1) {
                    i = 0;
                    stringLiteral = new CharacterLiteral(strSubstring.charAt(0));
                } else {
                    i = 0;
                    stringLiteral = new StringLiteral(strSubstring);
                }
                textField = stringLiteral;
            }
            arrayList.add(textField);
            i3 = i4 + 1;
            i2 = i;
        }
        return arrayList;
    }

    protected String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i);
        if (CharUtils.isAsciiAlpha(cCharAt)) {
            sb.append(cCharAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != cCharAt) {
                    break;
                }
                sb.append(cCharAt);
                i = i2;
            }
        } else {
            sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
            boolean z = false;
            while (i < length) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '\'') {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(cCharAt2);
                        i = i3;
                    }
                } else {
                    if (!z && CharUtils.isAsciiAlpha(cCharAt2)) {
                        i--;
                        break;
                    }
                    sb.append(cCharAt2);
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    protected NumberRule selectNumberRule(int i, int i2) {
        if (i2 == 1) {
            return new UnpaddedNumberField(i);
        }
        if (i2 == 2) {
            return new TwoDigitNumberField(i);
        }
        return new PaddedNumberField(i, i2);
    }

    public String toString() {
        return "FastDatePrinter[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }
}
