package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LogFactory {
    private static final String TAG = "LogFactory";
    private static Level globalLogLevel;
    private static Map logMap = new HashMap();

    public static synchronized Log getLog(Class cls) {
        return getLog(getTruncatedLogTag(cls.getSimpleName()));
    }

    public static synchronized Log getLog(String str) {
        Log androidLog;
        Log apacheCommonsLogging;
        Exception e;
        String truncatedLogTag = getTruncatedLogTag(str);
        androidLog = (Log) logMap.get(truncatedLogTag);
        if (androidLog == null) {
            if (checkApacheCommonsLoggingExists()) {
                try {
                    apacheCommonsLogging = new ApacheCommonsLogging(truncatedLogTag);
                    try {
                        logMap.put(truncatedLogTag, apacheCommonsLogging);
                    } catch (Exception e2) {
                        e = e2;
                        android.util.Log.w(TAG, "Could not create log from org.apache.commons.logging.LogFactory", e);
                    }
                } catch (Exception e3) {
                    apacheCommonsLogging = androidLog;
                    e = e3;
                }
                androidLog = apacheCommonsLogging;
            }
            if (androidLog == null) {
                androidLog = new AndroidLog(truncatedLogTag);
                logMap.put(truncatedLogTag, androidLog);
            }
        }
        return androidLog;
    }

    public static void setLevel(Level level) {
        globalLogLevel = level;
    }

    public static Level getLevel() {
        return globalLogLevel;
    }

    private static boolean checkApacheCommonsLoggingExists() {
        try {
            Class.forName("org.apache.commons.logging.LogFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Exception e) {
            android.util.Log.e(TAG, e.getMessage());
            return false;
        }
    }

    private static String getTruncatedLogTag(String str) {
        if (str.length() <= 23) {
            return str;
        }
        if (checkApacheCommonsLoggingExists()) {
            new ApacheCommonsLogging(TAG).warn("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        } else {
            android.util.Log.w(TAG, "Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        }
        return str.substring(0, 23);
    }

    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(Integer.MAX_VALUE);

        private int value;

        public int getValue() {
            return this.value;
        }

        Level(int i) {
            this.value = i;
        }
    }
}
