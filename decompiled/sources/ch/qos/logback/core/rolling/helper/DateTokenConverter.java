package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.pattern.DynamicConverter;
import ch.qos.logback.core.util.CachingDateFormatter;
import ch.qos.logback.core.util.DatePatternToRegexUtil;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DateTokenConverter<E> extends DynamicConverter<E> implements MonoTypedConverter {
    public static final String AUXILIARY_TOKEN = "AUX";
    public static final String CONVERTER_KEY = "d";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private CachingDateFormatter cdf;
    private String datePattern;
    private boolean primary = true;
    private TimeZone timeZone;

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null argument forbidden");
        }
        if (obj instanceof Date) {
            return convert((Date) obj);
        }
        throw new IllegalArgumentException("Cannot convert " + obj + " of type" + obj.getClass().getName());
    }

    public String convert(Date date) {
        return this.cdf.format(date.getTime());
    }

    public String getDatePattern() {
        return this.datePattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // ch.qos.logback.core.rolling.helper.MonoTypedConverter
    public boolean isApplicable(Object obj) {
        return obj instanceof Date;
    }

    public boolean isPrimary() {
        return this.primary;
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String firstOption = getFirstOption();
        this.datePattern = firstOption;
        if (firstOption == null) {
            this.datePattern = "yyyy-MM-dd";
        }
        List<String> optionList = getOptionList();
        if (optionList != null) {
            for (int i = 1; i < optionList.size(); i++) {
                String str = optionList.get(i);
                if (AUXILIARY_TOKEN.equalsIgnoreCase(str)) {
                    this.primary = false;
                } else {
                    this.timeZone = TimeZone.getTimeZone(str);
                }
            }
        }
        CachingDateFormatter cachingDateFormatter = new CachingDateFormatter(this.datePattern);
        this.cdf = cachingDateFormatter;
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            cachingDateFormatter.setTimeZone(timeZone);
        }
    }

    public String toRegex() {
        return new DatePatternToRegexUtil(this.datePattern).toRegex();
    }
}
