package com.amazonaws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes2.dex */
public class DateUtils {
    public static final String ALTERNATE_ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String COMPRESSED_DATE_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
    public static final String ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String RFC822_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    private static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone(TimeZones.GMT_ID);
    private static final Map SDF_MAP = new HashMap();

    private static ThreadLocal getSimpleDateFormat(final String str) {
        Map map = SDF_MAP;
        ThreadLocal<SimpleDateFormat> threadLocal = (ThreadLocal) map.get(str);
        if (threadLocal == null) {
            synchronized (map) {
                try {
                    threadLocal = (ThreadLocal) map.get(str);
                    if (threadLocal == null) {
                        threadLocal = new ThreadLocal<SimpleDateFormat>() { // from class: com.amazonaws.util.DateUtils.1
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // java.lang.ThreadLocal
                            public SimpleDateFormat initialValue() {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
                                simpleDateFormat.setTimeZone(DateUtils.GMT_TIMEZONE);
                                simpleDateFormat.setLenient(false);
                                return simpleDateFormat;
                            }
                        };
                        map.put(str, threadLocal);
                    }
                } finally {
                }
            }
        }
        return threadLocal;
    }

    public static Date parse(String str, String str2) {
        try {
            return ((SimpleDateFormat) getSimpleDateFormat(str).get()).parse(str2);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String format(String str, Date date) {
        return ((SimpleDateFormat) getSimpleDateFormat(str).get()).format(date);
    }

    public static Date parseISO8601Date(String str) {
        try {
            return parse(ISO8601_DATE_PATTERN, str);
        } catch (IllegalArgumentException unused) {
            return parse(ALTERNATE_ISO8601_DATE_PATTERN, str);
        }
    }

    public static String formatISO8601Date(Date date) {
        return format(ISO8601_DATE_PATTERN, date);
    }

    public static Date parseRFC822Date(String str) {
        return parse(RFC822_DATE_PATTERN, str);
    }

    public static String formatRFC822Date(Date date) {
        return format(RFC822_DATE_PATTERN, date);
    }

    public static Date parseCompressedISO8601Date(String str) {
        return parse(COMPRESSED_DATE_PATTERN, str);
    }

    public static Date cloneDate(Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }

    public static long numberOfDaysSinceEpoch(long j) {
        return TimeUnit.MILLISECONDS.toDays(j);
    }
}
