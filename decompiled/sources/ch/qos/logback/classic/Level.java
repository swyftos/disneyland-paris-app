package ch.qos.logback.classic;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class Level implements Serializable {
    public static final int ALL_INT = Integer.MIN_VALUE;
    public static final int DEBUG_INT = 10000;
    public static final int ERROR_INT = 40000;
    public static final int INFO_INT = 20000;
    public static final int OFF_INT = Integer.MAX_VALUE;
    public static final int TRACE_INT = 5000;
    public static final int WARN_INT = 30000;
    private static final long serialVersionUID = -814092767334282137L;
    public final int levelInt;
    public final String levelStr;
    public static final Integer OFF_INTEGER = Integer.MAX_VALUE;
    public static final Integer ERROR_INTEGER = 40000;
    public static final Integer WARN_INTEGER = 30000;
    public static final Integer INFO_INTEGER = 20000;
    public static final Integer DEBUG_INTEGER = 10000;
    public static final Integer TRACE_INTEGER = 5000;
    public static final Integer ALL_INTEGER = Integer.MIN_VALUE;
    public static final Level OFF = new Level(Integer.MAX_VALUE, "OFF");
    public static final Level ERROR = new Level(40000, "ERROR");
    public static final Level WARN = new Level(30000, "WARN");
    public static final Level INFO = new Level(20000, "INFO");
    public static final Level DEBUG = new Level(10000, "DEBUG");
    public static final Level TRACE = new Level(5000, "TRACE");
    public static final Level ALL = new Level(Integer.MIN_VALUE, "ALL");

    private Level(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }

    public static Level fromLocationAwareLoggerInteger(int i) {
        if (i == 0) {
            return TRACE;
        }
        if (i == 10) {
            return DEBUG;
        }
        if (i == 20) {
            return INFO;
        }
        if (i == 30) {
            return WARN;
        }
        if (i == 40) {
            return ERROR;
        }
        throw new IllegalArgumentException(i + " not a valid level value");
    }

    private Object readResolve() {
        return toLevel(this.levelInt);
    }

    public static Level toLevel(int i) {
        return toLevel(i, DEBUG);
    }

    public static Level toLevel(int i, Level level) {
        return i != Integer.MIN_VALUE ? i != 5000 ? i != 10000 ? i != 20000 ? i != 30000 ? i != 40000 ? i != Integer.MAX_VALUE ? level : OFF : ERROR : WARN : INFO : DEBUG : TRACE : ALL;
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        String strTrim = str.trim();
        return strTrim.equalsIgnoreCase("ALL") ? ALL : strTrim.equalsIgnoreCase("TRACE") ? TRACE : strTrim.equalsIgnoreCase("DEBUG") ? DEBUG : strTrim.equalsIgnoreCase("INFO") ? INFO : strTrim.equalsIgnoreCase("WARN") ? WARN : strTrim.equalsIgnoreCase("ERROR") ? ERROR : strTrim.equalsIgnoreCase("OFF") ? OFF : level;
    }

    public static int toLocationAwareLoggerInteger(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("null level parameter is not admitted");
        }
        int i = level.toInt();
        if (i == 5000) {
            return 0;
        }
        if (i == 10000) {
            return 10;
        }
        if (i == 20000) {
            return 20;
        }
        if (i == 30000) {
            return 30;
        }
        if (i == 40000) {
            return 40;
        }
        throw new IllegalArgumentException(level + " not a valid level value");
    }

    public static Level valueOf(String str) {
        return toLevel(str, DEBUG);
    }

    public boolean isGreaterOrEqual(Level level) {
        return this.levelInt >= level.levelInt;
    }

    public int toInt() {
        return this.levelInt;
    }

    public Integer toInteger() {
        int i = this.levelInt;
        if (i == Integer.MIN_VALUE) {
            return ALL_INTEGER;
        }
        if (i == 5000) {
            return TRACE_INTEGER;
        }
        if (i == 10000) {
            return DEBUG_INTEGER;
        }
        if (i == 20000) {
            return INFO_INTEGER;
        }
        if (i == 30000) {
            return WARN_INTEGER;
        }
        if (i == 40000) {
            return ERROR_INTEGER;
        }
        if (i == Integer.MAX_VALUE) {
            return OFF_INTEGER;
        }
        throw new IllegalStateException("Level " + this.levelStr + ", " + this.levelInt + " is unknown.");
    }

    public String toString() {
        return this.levelStr;
    }
}
