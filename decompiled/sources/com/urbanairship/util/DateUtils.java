package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes5.dex */
public class DateUtils {
    private static final SimpleDateFormat ALT_ISO_DATE_FORMAT;
    private static final SimpleDateFormat ISO_DATE_FORMAT;
    private static final Object lock;

    static {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale);
        ISO_DATE_FORMAT = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        ALT_ISO_DATE_FORMAT = simpleDateFormat2;
        lock = new Object();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static long parseIso8601(@Nullable String str) throws ParseException {
        long time;
        if (str == null) {
            throw new ParseException("Unable to parse null timestamp", -1);
        }
        try {
            synchronized (lock) {
                try {
                    try {
                        time = ISO_DATE_FORMAT.parse(str).getTime();
                    } catch (ParseException unused) {
                        return ALT_ISO_DATE_FORMAT.parse(str).getTime();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return time;
        } catch (Exception e) {
            throw new ParseException("Unexpected issue when attempting to parse " + str + " - " + e.getMessage(), -1);
        }
    }

    public static long parseIso8601(@NonNull String str, long j) {
        try {
            return parseIso8601(str);
        } catch (ParseException unused) {
            return j;
        }
    }

    @NonNull
    public static String createIso8601TimeStamp(long j) {
        String str;
        synchronized (lock) {
            str = ISO_DATE_FORMAT.format(new Date(j));
        }
        return str;
    }
}
