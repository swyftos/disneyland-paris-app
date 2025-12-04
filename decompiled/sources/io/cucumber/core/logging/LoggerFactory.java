package io.cucumber.core.logging;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes5.dex */
public final class LoggerFactory {
    private static final ConcurrentLinkedDeque listeners = new ConcurrentLinkedDeque();

    public static void addListener(LogRecordListener logRecordListener) {
        listeners.add(logRecordListener);
    }

    public static void removeListener(LogRecordListener logRecordListener) {
        listeners.remove(logRecordListener);
    }

    public static Logger getLogger(Class<?> cls) {
        Objects.requireNonNull(cls, "Class must not be null");
        return new DelegatingLogger(cls.getName());
    }

    private static final class DelegatingLogger implements Logger {
        private static final String THIS_LOGGER_CLASS = "io.cucumber.core.logging.LoggerFactory$DelegatingLogger";
        private final java.util.logging.Logger julLogger;
        private final String name;

        DelegatingLogger(String str) {
            this.name = str;
            this.julLogger = java.util.logging.Logger.getLogger(str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void error(String str) {
            log(Level.SEVERE, null, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void error(String str, Throwable th) {
            log(Level.SEVERE, th, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void warn(String str) {
            log(Level.WARNING, null, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void warn(String str, Throwable th) {
            log(Level.WARNING, th, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void info(String str) {
            log(Level.INFO, null, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void info(String str, Throwable th) {
            log(Level.INFO, th, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void config(String str) {
            log(Level.CONFIG, null, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void config(String str, Throwable th) {
            log(Level.CONFIG, th, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void debug(String str) {
            log(Level.FINE, null, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void debug(String str, Throwable th) {
            log(Level.FINE, th, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void trace(String str) {
            log(Level.FINER, null, str);
        }

        @Override // io.cucumber.core.logging.Logger
        public void trace(String str, Throwable th) {
            log(Level.FINER, th, str);
        }

        private void log(Level level, Throwable th, String str) {
            if (this.julLogger.isLoggable(level) || !LoggerFactory.listeners.isEmpty()) {
                LogRecord logRecordCreateLogRecord = createLogRecord(level, th, str);
                this.julLogger.log(logRecordCreateLogRecord);
                Iterator it = LoggerFactory.listeners.iterator();
                while (it.hasNext()) {
                    ((LogRecordListener) it.next()).logRecordSubmitted(logRecordCreateLogRecord);
                }
            }
        }

        private LogRecord createLogRecord(Level level, Throwable th, String str) {
            String className;
            String methodName;
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            boolean z = false;
            while (true) {
                if (i >= length) {
                    className = null;
                    methodName = null;
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                className = stackTraceElement.getClassName();
                if (THIS_LOGGER_CLASS.equals(className)) {
                    z = true;
                } else if (z) {
                    methodName = stackTraceElement.getMethodName();
                    break;
                }
                i++;
            }
            LogRecord logRecord = new LogRecord(level, str);
            logRecord.setLoggerName(this.name);
            logRecord.setThrown(th);
            logRecord.setSourceClassName(className);
            logRecord.setSourceMethodName(methodName);
            logRecord.setResourceBundleName(this.julLogger.getResourceBundleName());
            logRecord.setResourceBundle(this.julLogger.getResourceBundle());
            return logRecord;
        }
    }
}
