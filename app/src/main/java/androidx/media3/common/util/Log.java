package androidx.media3.common.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import ch.qos.logback.classic.net.SyslogAppender;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;
    private static final Object lock = new Object();
    private static Logger logger = Logger.DEFAULT;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: androidx.media3.common.util.Log.Logger.1
            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: d */
            public void mo232d(String str, String str2, Throwable th) {
                android.util.Log.d(str, Log.appendThrowableString(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: i */
            public void mo234i(String str, String str2, Throwable th) {
                android.util.Log.i(str, Log.appendThrowableString(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: w */
            public void mo235w(String str, String str2, Throwable th) {
                android.util.Log.w(str, Log.appendThrowableString(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: e */
            public void mo233e(String str, String str2, Throwable th) {
                android.util.Log.e(str, Log.appendThrowableString(str2, th));
            }
        };

        /* JADX INFO: renamed from: d */
        void mo232d(String str, String str2, @Nullable Throwable th);

        /* JADX INFO: renamed from: e */
        void mo233e(String str, String str2, @Nullable Throwable th);

        /* JADX INFO: renamed from: i */
        void mo234i(String str, String str2, @Nullable Throwable th);

        /* JADX INFO: renamed from: w */
        void mo235w(String str, String str2, @Nullable Throwable th);
    }

    @Pure
    public static int getLogLevel() {
        int i;
        synchronized (lock) {
            i = logLevel;
        }
        return i;
    }

    public static void setLogLevel(int i) {
        synchronized (lock) {
            logLevel = i;
        }
    }

    public static void setLogStackTraces(boolean z) {
        synchronized (lock) {
            logStackTraces = z;
        }
    }

    public static void setLogger(Logger logger2) {
        synchronized (lock) {
            logger = logger2;
        }
    }

    @Pure
    /* JADX INFO: renamed from: d */
    public static void m224d(@androidx.annotation.Size(max = 23) String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel == 0) {
                    logger.mo232d(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: d */
    public static void m225d(@androidx.annotation.Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel == 0) {
                    logger.mo232d(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: i */
    public static void m228i(@androidx.annotation.Size(max = 23) String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel <= 1) {
                    logger.mo234i(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: i */
    public static void m229i(@androidx.annotation.Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel <= 1) {
                    logger.mo234i(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: w */
    public static void m230w(@androidx.annotation.Size(max = 23) String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel <= 2) {
                    logger.mo235w(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: w */
    public static void m231w(@androidx.annotation.Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel <= 2) {
                    logger.mo235w(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: e */
    public static void m226e(@androidx.annotation.Size(max = 23) String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel <= 3) {
                    logger.mo233e(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: e */
    public static void m227e(@androidx.annotation.Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel <= 3) {
                    logger.mo233e(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    @Pure
    public static String getThrowableString(@Nullable Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (lock) {
            try {
                if (isCausedByUnknownHostException(th)) {
                    return "UnknownHostException (no network)";
                }
                if (!logStackTraces) {
                    return th.getMessage();
                }
                return android.util.Log.getStackTraceString(th).trim().replace(SyslogAppender.DEFAULT_STACKTRACE_PATTERN, "    ");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    public static String appendThrowableString(String str, @Nullable Throwable th) {
        String throwableString = getThrowableString(th);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        return str + "\n  " + throwableString.replace("\n", "\n  ") + '\n';
    }

    private static boolean isCausedByUnknownHostException(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }
}
