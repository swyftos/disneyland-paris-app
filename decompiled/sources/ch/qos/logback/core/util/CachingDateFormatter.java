package ch.qos.logback.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class CachingDateFormatter {
    String cachedStr;
    long lastTimestamp;
    final SimpleDateFormat sdf;

    public CachingDateFormatter(String str) {
        this(str, Locale.US);
    }

    public CachingDateFormatter(String str, Locale locale) {
        this.lastTimestamp = -1L;
        this.cachedStr = null;
        this.sdf = new SimpleDateFormat(str, locale);
    }

    public final String format(long j) {
        String str;
        synchronized (this) {
            try {
                if (j != this.lastTimestamp) {
                    this.lastTimestamp = j;
                    this.cachedStr = this.sdf.format(new Date(j));
                }
                str = this.cachedStr;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.sdf.setTimeZone(timeZone);
    }
}
