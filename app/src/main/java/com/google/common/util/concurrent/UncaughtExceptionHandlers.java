package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.PrintStream;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
@J2ktIncompatible
@GwtIncompatible
public final class UncaughtExceptionHandlers {
    public static Thread.UncaughtExceptionHandler systemExit() {
        return new Exiter(Runtime.getRuntime());
    }

    static final class Exiter implements Thread.UncaughtExceptionHandler {
        private static final LazyLogger logger = new LazyLogger(Exiter.class);
        private final Runtime runtime;

        Exiter(Runtime runtime) {
            this.runtime = runtime;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                logger.get().log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
            } catch (Throwable th2) {
                try {
                    PrintStream printStream = System.err;
                    printStream.println(th.getMessage());
                    printStream.println(th2.getMessage());
                } finally {
                    this.runtime.exit(1);
                }
            }
        }
    }
}
