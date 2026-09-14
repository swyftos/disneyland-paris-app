package com.facebook.common.logging;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate == null) {
            throw new IllegalArgumentException();
        }
        sHandler = loggingDelegate;
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* JADX INFO: renamed from: v */
    public static void m1319v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(str, str2);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1320v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(str, formatString(str2, obj));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1321v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(str, formatString(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1322v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1323v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1311v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1312v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(getTag(cls), formatString(str, obj));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1313v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1314v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m1311v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1315v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1325v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1326v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1342v(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1317v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1341v(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1318v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1342v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1324v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1342v(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1316v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1342v(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1279d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1280d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(str, formatString(str2, obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1281d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(str, formatString(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1282d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1283d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1271d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1272d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(getTag(cls), formatString(str, obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1273d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1274d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1275d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1285d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m1279d(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1286d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m1284d(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1277d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1335d(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1278d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1336d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1284d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1336d(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1276d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1336d(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1303i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(str, str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1304i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(str, formatString(str2, obj));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1305i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(str, formatString(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1306i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1307i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1295i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1296i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(getTag(cls), formatString(str, obj));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1297i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1298i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1299i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1309i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1310i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1340i(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1301i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1339i(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1302i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo1340i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1308i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1340i(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1300i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1340i(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1331w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1343w(str, str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1327w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1343w(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1333w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1343w(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1334w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1344w(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1329w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1343w(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1330w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m1328w(cls, formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1332w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1344w(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1328w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1344w(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1291e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1337e(str, str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1287e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1337e(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1293e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1337e(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1294e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1338e(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1289e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1337e(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1290e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1338e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1292e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1338e(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1288e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1338e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String getTag(Class cls) {
        return cls.getSimpleName();
    }
}
