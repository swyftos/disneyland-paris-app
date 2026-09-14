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

/* JADX INFO: renamed from: com.michaelflisar.lumberjack.L */
/* JADX INFO: loaded from: classes4.dex */
public class C4425L {
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

    /* JADX INFO: renamed from: v */
    public static void m1701v(String str, Object... objArr) {
        new LogBuilder().m1721v(str, objArr);
    }

    /* JADX INFO: renamed from: v */
    public static void m1703v(Throwable th, String str, Object... objArr) {
        new LogBuilder().m1723v(th, str, objArr);
    }

    /* JADX INFO: renamed from: v */
    public static void m1702v(Throwable th) {
        new LogBuilder().m1722v(th);
    }

    /* JADX INFO: renamed from: v */
    public static void m1700v(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().m1720v(logLabelValuePairsBuilder);
    }

    /* JADX INFO: renamed from: d */
    public static void m1689d(String str, Object... objArr) {
        new LogBuilder().m1709d(str, objArr);
    }

    /* JADX INFO: renamed from: d */
    public static void m1691d(Throwable th, String str, Object... objArr) {
        new LogBuilder().m1711d(th, str, objArr);
    }

    /* JADX INFO: renamed from: d */
    public static void m1690d(Throwable th) {
        new LogBuilder().m1710d(th);
    }

    /* JADX INFO: renamed from: d */
    public static void m1688d(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().m1708d(logLabelValuePairsBuilder);
    }

    /* JADX INFO: renamed from: i */
    public static void m1697i(String str, Object... objArr) {
        new LogBuilder().m1717i(str, objArr);
    }

    /* JADX INFO: renamed from: i */
    public static void m1699i(Throwable th, String str, Object... objArr) {
        new LogBuilder().m1719i(th, str, objArr);
    }

    /* JADX INFO: renamed from: i */
    public static void m1698i(Throwable th) {
        new LogBuilder().m1718i(th);
    }

    /* JADX INFO: renamed from: i */
    public static void m1696i(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().m1716i(logLabelValuePairsBuilder);
    }

    /* JADX INFO: renamed from: w */
    public static void m1705w(String str, Object... objArr) {
        new LogBuilder().m1725w(str, objArr);
    }

    /* JADX INFO: renamed from: w */
    public static void m1707w(Throwable th, String str, Object... objArr) {
        new LogBuilder().m1727w(th, str, objArr);
    }

    /* JADX INFO: renamed from: w */
    public static void m1706w(Throwable th) {
        new LogBuilder().m1726w(th);
    }

    /* JADX INFO: renamed from: w */
    public static void m1704w(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().m1724w(logLabelValuePairsBuilder);
    }

    /* JADX INFO: renamed from: e */
    public static void m1693e(String str, Object... objArr) {
        new LogBuilder().m1713e(str, objArr);
    }

    /* JADX INFO: renamed from: e */
    public static void m1695e(Throwable th, String str, Object... objArr) {
        new LogBuilder().m1715e(th, str, objArr);
    }

    /* JADX INFO: renamed from: e */
    public static void m1694e(Throwable th) {
        new LogBuilder().m1714e(th);
    }

    /* JADX INFO: renamed from: e */
    public static void m1692e(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
        new LogBuilder().m1712e(logLabelValuePairsBuilder);
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

    /* JADX INFO: renamed from: com.michaelflisar.lumberjack.L$LogBuilder */
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

        /* JADX INFO: renamed from: v */
        public void m1721v(String str, Object... objArr) {
            log(2, str, objArr);
        }

        /* JADX INFO: renamed from: v */
        public void m1723v(Throwable th, String str, Object... objArr) {
            log(2, th, str, objArr);
        }

        /* JADX INFO: renamed from: v */
        public void m1722v(Throwable th) {
            log(2, th);
        }

        /* JADX INFO: renamed from: v */
        public void m1720v(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(2, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        /* JADX INFO: renamed from: d */
        public void m1709d(String str, Object... objArr) {
            log(3, str, objArr);
        }

        /* JADX INFO: renamed from: d */
        public void m1711d(Throwable th, String str, Object... objArr) {
            log(3, th, str, objArr);
        }

        /* JADX INFO: renamed from: d */
        public void m1710d(Throwable th) {
            log(3, th);
        }

        /* JADX INFO: renamed from: d */
        public void m1708d(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(3, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        /* JADX INFO: renamed from: i */
        public void m1717i(String str, Object... objArr) {
            log(4, str, objArr);
        }

        /* JADX INFO: renamed from: i */
        public void m1719i(Throwable th, String str, Object... objArr) {
            log(4, th, str, objArr);
        }

        /* JADX INFO: renamed from: i */
        public void m1718i(Throwable th) {
            log(4, th);
        }

        /* JADX INFO: renamed from: i */
        public void m1716i(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(4, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        /* JADX INFO: renamed from: w */
        public void m1725w(String str, Object... objArr) {
            log(5, str, objArr);
        }

        /* JADX INFO: renamed from: w */
        public void m1727w(Throwable th, String str, Object... objArr) {
            log(5, th, str, objArr);
        }

        /* JADX INFO: renamed from: w */
        public void m1726w(Throwable th) {
            log(5, th);
        }

        /* JADX INFO: renamed from: w */
        public void m1724w(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(5, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        /* JADX INFO: renamed from: e */
        public void m1713e(String str, Object... objArr) {
            log(6, str, objArr);
        }

        /* JADX INFO: renamed from: e */
        public void m1715e(Throwable th, String str, Object... objArr) {
            log(6, th, str, objArr);
        }

        /* JADX INFO: renamed from: e */
        public void m1714e(Throwable th) {
            log(6, th);
        }

        /* JADX INFO: renamed from: e */
        public void m1712e(LogLabelValuePairsBuilder logLabelValuePairsBuilder) {
            log(6, "%s", logLabelValuePairsBuilder.prepareLog());
        }

        public void log(int i, String str, Object... objArr) {
            if (this.enable) {
                C4425L.updateTag(this.group);
                C4425L.updateStackDepth(this.callStackCorrection);
                Timber.log(i, str, C4425L.formatArgs(objArr));
            }
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            C4425L.updateTag(this.group);
            C4425L.updateStackDepth(this.callStackCorrection);
            Timber.log(i, th, str, C4425L.formatArgs(objArr));
        }

        public void log(int i, Throwable th) {
            C4425L.updateTag(this.group);
            C4425L.updateStackDepth(this.callStackCorrection);
            Timber.log(i, th);
        }
    }

    public static LogLabelValuePairsBuilder labeledValueBuilder() {
        return new LogLabelValuePairsBuilder();
    }

    /* JADX INFO: renamed from: com.michaelflisar.lumberjack.L$LogLabelValuePairsBuilder */
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
                if (C4425L.mFormatters.size() == 0) {
                    sb.append(((Pair) this.pairs.get(i)).second);
                } else {
                    sb.append(C4425L.formatArg(((Pair) this.pairs.get(i)).second));
                }
            }
            return sb.toString();
        }
    }
}
