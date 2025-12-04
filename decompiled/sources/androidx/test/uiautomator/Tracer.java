package androidx.test.uiautomator;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class Tracer {
    private static Tracer mInstance;
    private File mOutputFile;
    private Mode mCurrentMode = Mode.NONE;
    private List mSinks = new ArrayList();

    public enum Mode {
        NONE,
        FILE,
        LOGCAT,
        ALL
    }

    private interface TracerSink {
        void close();

        void log(String str);
    }

    private class FileSink implements TracerSink {
        private SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        private PrintWriter mOut;

        public FileSink(File file) {
            this.mOut = new PrintWriter(file);
        }

        @Override // androidx.test.uiautomator.Tracer.TracerSink
        public void log(String str) {
            this.mOut.printf("%s %s\n", this.mDateFormat.format(new Date()), str);
        }

        @Override // androidx.test.uiautomator.Tracer.TracerSink
        public void close() {
            this.mOut.close();
        }
    }

    private class LogcatSink implements TracerSink {
        @Override // androidx.test.uiautomator.Tracer.TracerSink
        public void close() {
        }

        private LogcatSink() {
        }

        /* synthetic */ LogcatSink(Tracer tracer, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.test.uiautomator.Tracer.TracerSink
        public void log(String str) {
            Log.i("UiAutomatorTrace", str);
        }
    }

    public static Tracer getInstance() {
        if (mInstance == null) {
            mInstance = new Tracer();
        }
        return mInstance;
    }

    public void setOutputMode(Mode mode) {
        closeSinks();
        this.mCurrentMode = mode;
        try {
            int i = AnonymousClass1.$SwitchMap$android$support$test$uiautomator$Tracer$Mode[mode.ordinal()];
            if (i == 1) {
                File file = this.mOutputFile;
                if (file == null) {
                    throw new IllegalArgumentException("Please provide a filename before attempting write trace to a file");
                }
                this.mSinks.add(new FileSink(file));
                return;
            }
            AnonymousClass1 anonymousClass1 = null;
            if (i == 2) {
                this.mSinks.add(new LogcatSink(this, anonymousClass1));
                return;
            }
            if (i != 3) {
                return;
            }
            this.mSinks.add(new LogcatSink(this, anonymousClass1));
            File file2 = this.mOutputFile;
            if (file2 == null) {
                throw new IllegalArgumentException("Please provide a filename before attempting write trace to a file");
            }
            this.mSinks.add(new FileSink(file2));
        } catch (FileNotFoundException e) {
            Log.w("Tracer", "Could not open log file: " + e.getMessage());
        }
    }

    /* renamed from: androidx.test.uiautomator.Tracer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$support$test$uiautomator$Tracer$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$android$support$test$uiautomator$Tracer$Mode = iArr;
            try {
                iArr[Mode.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Tracer$Mode[Mode.LOGCAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Tracer$Mode[Mode.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void closeSinks() {
        Iterator it = this.mSinks.iterator();
        while (it.hasNext()) {
            ((TracerSink) it.next()).close();
        }
        this.mSinks.clear();
    }

    public void setOutputFilename(String str) {
        this.mOutputFile = new File(str);
    }

    private void doTrace(Object[] objArr) {
        String caller;
        if (this.mCurrentMode == Mode.NONE || (caller = getCaller()) == null) {
            return;
        }
        log(String.format("%s (%s)", caller, join(", ", objArr)));
    }

    private void log(String str) {
        Iterator it = this.mSinks.iterator();
        while (it.hasNext()) {
            ((TracerSink) it.next()).log(str);
        }
    }

    public boolean isTracingEnabled() {
        return this.mCurrentMode != Mode.NONE;
    }

    public static void trace(Object... objArr) {
        getInstance().doTrace(objArr);
    }

    private static String join(String str, Object[] objArr) {
        if (objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(objectToString(objArr[0]));
        for (int i = 1; i < objArr.length; i++) {
            sb.append(str);
            sb.append(objectToString(objArr[i]));
        }
        return sb.toString();
    }

    private static String objectToString(Object obj) {
        if (obj.getClass().isArray()) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            return "[...]";
        }
        return obj.toString();
    }

    private static String getCaller() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 7) {
            return "(unknown method)";
        }
        StackTraceElement stackTraceElement = stackTrace[5];
        StackTraceElement stackTraceElement2 = stackTrace[6];
        if (stackTraceElement2.getClassName().startsWith("androidx.test.uiautomator")) {
            return null;
        }
        int iLastIndexOf = stackTraceElement.getClassName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            iLastIndexOf = 0;
        }
        int i = iLastIndexOf + 1;
        return i >= stackTraceElement.getClassName().length() ? "(unknown method)" : String.format("%s.%s from %s() at %s:%d", stackTraceElement.getClassName().substring(i), stackTraceElement.getMethodName(), stackTraceElement2.getMethodName(), stackTraceElement2.getFileName(), Integer.valueOf(stackTraceElement2.getLineNumber()));
    }
}
