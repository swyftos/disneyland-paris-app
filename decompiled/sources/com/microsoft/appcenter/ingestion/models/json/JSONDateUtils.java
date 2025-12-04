package com.microsoft.appcenter.ingestion.models.json;

import com.amazonaws.util.DateUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class JSONDateUtils {
    private static final ThreadLocal DATE_FORMAT = new ThreadLocal() { // from class: com.microsoft.appcenter.ingestion.models.json.JSONDateUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN, Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };

    private static void checkNull(Object obj) throws JSONException {
        if (obj == null) {
            throw new JSONException("date cannot be null");
        }
    }

    public static String toString(Date date) throws JSONException {
        checkNull(date);
        return ((DateFormat) DATE_FORMAT.get()).format(date);
    }

    public static Date toDate(String str) throws JSONException {
        checkNull(str);
        try {
            return ((DateFormat) DATE_FORMAT.get()).parse(str);
        } catch (ParseException e) {
            throw new JSONException(e.getMessage());
        }
    }
}
