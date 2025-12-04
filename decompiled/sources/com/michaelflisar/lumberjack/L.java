package com.michaelflisar.lumberjack;

import android.util.Pair;
import com.michaelflisar.lumberjack.formatter.DefaultLogFormatter;
import com.michaelflisar.lumberjack.formatter.ILogClassFormatter;
import com.michaelflisar.lumberjack.formatter.ILogFormatter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import timber.log.Lumberjack;
import timber.log.Timber;

/* loaded from: classes4.dex */
public class L {
    private static HashMap mFormatters = new HashMap();
    private static ILogFormatter mLogFormatter;

    public static ILogFormatter getFormatter() {
        if (mLogFormatter == null) {
            mLogFormatter = new DefaultLogFormatter(5, true, true);
        }
        return mLogFormatter;
    }

    public static void setLogFormatter(ILogFormatter iLogFormatter) {
        mLogFormatter = iLogFormatter;
    }

    public static LogBuilder withGroup(String str) {
        return new LogBuilder().withGroup(str).withDecreaseCallStackCorrection();
    }

    public static LogBuilder withCallStackCorrection(int i) {
        return new LogBuilder().withCallStackCorrection(i).withDecreaseCallStackCorrection();
    }

    public static LogBuilder onlyIf(boolean z) {
        return new LogBuilder().withIf(z).withDecreaseCallStackCorrection();
    }

    public static void v(String str, Object... objArr) {
        new LogBuilder().v(str, objArr);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        new LogBuilder().v(th, str, objArr);
    }

    public static void v(Throwable th) {
        new LogBuilder().v(th);
    }

    public static void v(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().v(logLabelValuePairsBuilder);
    }

    public static void d(String str, Object... objArr) {
        new LogBuilder().d(str, objArr);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        new LogBuilder().d(th, str, objArr);
    }

    public static void d(Throwable th) {
        new LogBuilder().d(th);
    }

    public static void d(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().d(logLabelValuePairsBuilder);
    }

    public static void i(String str, Object... objArr) {
        new LogBuilder().i(str, objArr);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        new LogBuilder().i(th, str, objArr);
    }

    public static void i(Throwable th) {
        new LogBuilder().i(th);
    }

    public static void i(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().i(logLabelValuePairsBuilder);
    }

    public static void w(String str, Object... objArr) {
        new LogBuilder().w(str, objArr);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        new LogBuilder().w(th, str, objArr);
    }

    public static void w(Throwable th) {
        new LogBuilder().w(th);
    }

    public static void w(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().w(logLabelValuePairsBuilder);
    }

    public static void e(String str, Object... objArr) {
        new LogBuilder().e(str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        new LogBuilder().e(th, str, objArr);
    }

    public static void e(Throwable th) {
        new LogBuilder().e(th);
    }

    public static void e(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().e(logLabelValuePairsBuilder);
    }

    public static void log(int i, String str, Object... objArr) {
        new LogBuilder().log(i, str, objArr);
    }

    public static void log(int i, Throwable th, String str, Object... objArr) {
        new LogBuilder().log(i, th, str, objArr);
    }

    public static void log(int i, Throwable th) {
        new LogBuilder().log(i, th);
    }

    public static void log(int i, LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().log(i, "%s", logLabelValuePairsBuilder.prepareLog());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateTag(String str) {
        if (str == null) {
            Timber.tag(null);
        } else {
            Timber.tag(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateStackDepth(Integer num) {
        if (num == null) {
            Lumberjack.callStackCorrection(null);
        } else {
            Lumberjack.callStackCorrection(num);
        }
    }

    public static Object formatArg(Object obj) {
        if (obj instanceof Collection) {
            return getFormatter().format((Collection) obj, mFormatters);
        }
        if (obj instanceof Object[]) {
            return getFormatter().format((Object[]) obj, mFormatters);
        }
        if ((obj instanceof boolean[]) || (obj instanceof byte[]) || (obj instanceof short[]) || (obj instanceof char[]) || (obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof float[]) || (obj instanceof double[])) {
            Object[] objArr = new Object[Array.getLength(obj)];
            for (int i = 0; i < Array.getLength(obj); i++) {
                objArr[i] = Array.get(obj, i);
            }
            return getFormatter().format(objArr, mFormatters);
        }
        return getFormatter().format(obj, mFormatters, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] formatArgs(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return objArr;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            objArr2[i] = formatArg(objArr[i]);
        }
        return objArr2;
    }

    public static <T> void registerFormatter(Class<T> cls, ILogClassFormatter<T> iLogClassFormatter) {
        mFormatters.put(cls, iLogClassFormatter);
    }

    public static class LogBuilder {
        boolean enable = true;
        String group = null;
        Integer callStackCorrection = null;

        LogBuilder() {
        }

        public LogBuilder withGroup(String str) {
            this.group = str;
            return this;
        }

        public LogBuilder withIf(boolean z) {
            this.enable = z;
            return this;
        }

        public LogBuilder withCallStackCorrection(int i) {
            Integer num = this.callStackCorrection;
            if (num == null) {
                this.callStackCorrection = Integer.valueOf(i);
            } else {
                this.callStackCorrection = Integer.valueOf(num.intValue() + i);
            }
            return this;
        }

        public LogBuilder withOverwriteCallStackCorrection(int i) {
            this.callStackCorrection = Integer.valueOf(i);
            return this;
        }

        LogBuilder withDecreaseCallStackCorrection() {
            Integer num = this.callStackCorrection;
            if (num == null) {
                this.callStackCorrection = -1;
            } else {
                this.callStackCorrection = Integer.valueOf(num.intValue() + 1);
            }
            return this;
        }

        public void v(String str, Object... objArr) {
            log(2, str, objArr);
        }

        public void v(Throwable th, String str, Object... objArr) {
            log(2, th, str, objArr);
        }

        public void v(Throwable th) {
            log(2, th);
        }

        public void v(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(2, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        public void d(String str, Object... objArr) {
            log(3, str, objArr);
        }

        public void d(Throwable th, String str, Object... objArr) {
            log(3, th, str, objArr);
        }

        public void d(Throwable th) {
            log(3, th);
        }

        public void d(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(3, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        public void i(String str, Object... objArr) {
            log(4, str, objArr);
        }

        public void i(Throwable th, String str, Object... objArr) {
            log(4, th, str, objArr);
        }

        public void i(Throwable th) {
            log(4, th);
        }

        public void i(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(4, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        public void w(String str, Object... objArr) {
            log(5, str, objArr);
        }

        public void w(Throwable th, String str, Object... objArr) {
            log(5, th, str, objArr);
        }

        public void w(Throwable th) {
            log(5, th);
        }

        public void w(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(5, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        public void e(String str, Object... objArr) {
            log(6, str, objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            log(6, th, str, objArr);
        }

        public void e(Throwable th) {
            log(6, th);
        }

        public void e(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(6, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        public void log(int i, String str, Object... objArr) {
            if (this.enable) {
                L.updateTag(this.group);
                L.updateStackDepth(this.callStackCorrection);
                Timber.log(i, str, L.formatArgs(objArr));
            }
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            L.updateTag(this.group);
            L.updateStackDepth(this.callStackCorrection);
            Timber.log(i, th, str, L.formatArgs(objArr));
        }

        public void log(int i, Throwable th) {
            L.updateTag(this.group);
            L.updateStackDepth(this.callStackCorrection);
            Timber.log(i, th);
        }
    }

    public static LogLabelValuePairsBuilder labeledValueBuilder() {
        return new LogLabelValuePairsBuilder();
    }

    public static class LogLabelValuePairsBuilder {
        List pairs = new ArrayList();

        LogLabelValuePairsBuilder() {
        }

        public LogLabelValuePairsBuilder addPair(String str, Object obj) {
            if (str == null) {
                throw new RuntimeException("Labels can't be NULL, that makes no sense!");
            }
            this.pairs.add(new Pair(str, obj));
            return this;
        }

        String prepareLog() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.pairs.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append((String) ((Pair) this.pairs.get(i)).first);
                sb.append("=");
                if (L.mFormatters.size() == 0) {
                    sb.append(((Pair) this.pairs.get(i)).second);
                } else {
                    sb.append(L.formatArg(((Pair) this.pairs.get(i)).second));
                }
            }
            return sb.toString();
        }
    }
}
