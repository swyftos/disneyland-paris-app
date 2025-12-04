package ch.qos.logback.core.rolling.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class DateParser implements FilenameParser {
    private final SimpleDateFormat dateFormatter;
    private final Pattern pathPattern;

    DateParser(FileNamePattern fileNamePattern) {
        this.dateFormatter = getDateFormatter(fileNamePattern);
        this.pathPattern = Pattern.compile(fileNamePattern.toRegex(true, false));
    }

    private String findToken(String str) {
        Matcher matcher = this.pathPattern.matcher(str);
        return (!matcher.find() || matcher.groupCount() < 1) ? "" : matcher.group(1);
    }

    private SimpleDateFormat getDateFormatter(FileNamePattern fileNamePattern) {
        DateTokenConverter<Object> primaryDateTokenConverter = fileNamePattern.getPrimaryDateTokenConverter();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(primaryDateTokenConverter != null ? primaryDateTokenConverter.getDatePattern() : "yyyy-MM-dd", Locale.US);
        TimeZone timeZone = primaryDateTokenConverter != null ? primaryDateTokenConverter.getTimeZone() : TimeZone.getDefault();
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat;
    }

    Date parseDate(String str) {
        return this.dateFormatter.parse(str);
    }

    @Override // ch.qos.logback.core.rolling.helper.FilenameParser
    public Date parseFilename(String str) {
        try {
            return parseDate(findToken(str));
        } catch (ParseException unused) {
            return null;
        }
    }
}
