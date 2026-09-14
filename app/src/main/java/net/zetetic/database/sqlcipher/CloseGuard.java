package net.zetetic.database.sqlcipher;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public final class CloseGuard {
    private Throwable allocationSite;
    private static final CloseGuard NOOP = new CloseGuard();
    private static volatile boolean ENABLED = true;
    private static volatile Reporter REPORTER = new DefaultReporter();

    public interface Reporter {
        void report(String str, Throwable th);
    }

    public static CloseGuard get() {
        if (!ENABLED) {
            return NOOP;
        }
        return new CloseGuard();
    }

    public static void setEnabled(boolean z) {
        ENABLED = z;
    }

    public static void setReporter(Reporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }

    public static Reporter getReporter() {
        return REPORTER;
    }

    private CloseGuard() {
    }

    public void open(String str) {
        if (str == null) {
            throw new NullPointerException("closer == null");
        }
        if (this == NOOP || !ENABLED) {
            return;
        }
        this.allocationSite = new Throwable("Explicit termination method '" + str + "' not called");
    }

    public void close() {
        this.allocationSite = null;
    }

    public void warnIfOpen() {
        if (this.allocationSite == null || !ENABLED) {
            return;
        }
        REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
    }

    private static final class DefaultReporter implements Reporter {
        private DefaultReporter() {
        }

        @Override // net.zetetic.database.sqlcipher.CloseGuard.Reporter
        public void report(String str, Throwable th) {
            Log.w(str, th);
        }
    }
}
