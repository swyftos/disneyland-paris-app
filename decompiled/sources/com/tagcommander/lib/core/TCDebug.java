package com.tagcommander.lib.core;

/* loaded from: classes4.dex */
public class TCDebug {
    private static boolean blockHits = false;
    private static int logLevel = 10;
    private static boolean prettyFormat = false;

    public static void setDebugLevel(int i) {
        logLevel = i;
    }

    public static void enablePrettyFormat(boolean z) {
        prettyFormat = z;
    }

    public static void setNotificationLog(Boolean bool) {
        TCLogger.getInstance().setLogNotification(bool);
    }

    public static void blockHits(Boolean bool) {
        blockHits = bool.booleanValue();
    }

    static int getLogLevel() {
        return logLevel;
    }

    static boolean isPrettyFormatEnabled() {
        return prettyFormat;
    }

    public static boolean areHitBlocked() {
        return blockHits;
    }
}
