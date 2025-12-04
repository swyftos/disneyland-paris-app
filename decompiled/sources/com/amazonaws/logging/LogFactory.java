package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LogFactory {
    private static final String TAG = "LogFactory";
    private static Level globalLogLevel;
    private static Map logMap = new HashMap();

    public static synchronized Log getLog(Class cls) {
        return getLog(getTruncatedLogTag(cls.getSimpleName()));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0011, B:8:0x0017, B:9:0x001c, B:17:0x002b, B:19:0x0035), top: B:24:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.amazonaws.logging.Log getLog(java.lang.String r6) {
        /*
            java.lang.Class<com.amazonaws.logging.LogFactory> r0 = com.amazonaws.logging.LogFactory.class
            monitor-enter(r0)
            java.lang.String r6 = getTruncatedLogTag(r6)     // Catch: java.lang.Throwable -> L23
            java.util.Map r1 = com.amazonaws.logging.LogFactory.logMap     // Catch: java.lang.Throwable -> L23
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L23
            com.amazonaws.logging.Log r1 = (com.amazonaws.logging.Log) r1     // Catch: java.lang.Throwable -> L23
            if (r1 != 0) goto L3f
            boolean r2 = checkApacheCommonsLoggingExists()     // Catch: java.lang.Throwable -> L23
            if (r2 == 0) goto L33
            com.amazonaws.logging.ApacheCommonsLogging r2 = new com.amazonaws.logging.ApacheCommonsLogging     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.util.Map r1 = com.amazonaws.logging.LogFactory.logMap     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r1.put(r6, r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
        L21:
            r1 = r2
            goto L33
        L23:
            r6 = move-exception
            goto L41
        L25:
            r1 = move-exception
            goto L2b
        L27:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L2b:
            java.lang.String r3 = com.amazonaws.logging.LogFactory.TAG     // Catch: java.lang.Throwable -> L23
            java.lang.String r4 = "Could not create log from org.apache.commons.logging.LogFactory"
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L23
            goto L21
        L33:
            if (r1 != 0) goto L3f
            com.amazonaws.logging.AndroidLog r1 = new com.amazonaws.logging.AndroidLog     // Catch: java.lang.Throwable -> L23
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L23
            java.util.Map r2 = com.amazonaws.logging.LogFactory.logMap     // Catch: java.lang.Throwable -> L23
            r2.put(r6, r1)     // Catch: java.lang.Throwable -> L23
        L3f:
            monitor-exit(r0)
            return r1
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.logging.LogFactory.getLog(java.lang.String):com.amazonaws.logging.Log");
    }

    public static void setLevel(Level level) {
        globalLogLevel = level;
    }

    public static Level getLevel() {
        return globalLogLevel;
    }

    private static boolean checkApacheCommonsLoggingExists() throws ClassNotFoundException {
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
