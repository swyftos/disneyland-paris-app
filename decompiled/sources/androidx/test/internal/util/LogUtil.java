package androidx.test.internal.util;

import android.util.Log;
import androidx.test.internal.util.ProcSummary;

/* loaded from: classes2.dex */
public final class LogUtil {
    private static volatile String myProcName;

    interface Supplier<T> {
        Object get();
    }

    static final /* synthetic */ String lambda$logDebug$0$LogUtil(String str) {
        return str;
    }

    public static void logDebug(String str, final String str2, Object... objArr) {
        logDebug(str, new Supplier(str2) { // from class: androidx.test.internal.util.LogUtil$$Lambda$0
            private final String arg$1;

            {
                this.arg$1 = str2;
            }

            @Override // androidx.test.internal.util.LogUtil.Supplier
            public Object get() {
                return LogUtil.lambda$logDebug$0$LogUtil(this.arg$1);
            }
        }, objArr);
    }

    private static void logDebug(String str, Supplier supplier, Object... objArr) {
        if (isLoggable(str, 3)) {
            Log.d(str, String.format((String) supplier.get(), objArr));
        }
    }

    static final /* synthetic */ String lambda$logDebugWithProcess$1$LogUtil(String str) {
        String strProcName = procName();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(strProcName).length());
        sb.append(str);
        sb.append(" in ");
        sb.append(strProcName);
        return sb.toString();
    }

    public static void logDebugWithProcess(String str, final String str2, Object... objArr) {
        logDebug(str, new Supplier(str2) { // from class: androidx.test.internal.util.LogUtil$$Lambda$1
            private final String arg$1;

            {
                this.arg$1 = str2;
            }

            @Override // androidx.test.internal.util.LogUtil.Supplier
            public Object get() {
                return LogUtil.lambda$logDebugWithProcess$1$LogUtil(this.arg$1);
            }
        }, objArr);
    }

    private static final String procName() {
        String str;
        String str2 = myProcName;
        if (str2 != null) {
            return str2;
        }
        try {
            str = ProcSummary.summarize("self").cmdline;
        } catch (ProcSummary.SummaryException unused) {
            str = "unknown";
        }
        return (str.length() <= 64 || !str.contains("-classpath")) ? str : "robolectric";
    }

    private static boolean isLoggable(String str, int i) {
        if (str.length() > 23) {
            str = str.substring(0, 22);
        }
        return Log.isLoggable(str, i);
    }
}
