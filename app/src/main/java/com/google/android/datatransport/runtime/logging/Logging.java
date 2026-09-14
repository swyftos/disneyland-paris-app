package com.google.android.datatransport.runtime.logging;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class Logging {
    private static String getTag(String str) {
        return "TransportRuntime." + str;
    }

    /* JADX INFO: renamed from: d */
    public static void m1430d(String str, String str2) {
        Log.d(getTag(str), str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m1431d(String str, String str2, Object obj) {
        Log.d(getTag(str), String.format(str2, obj));
    }

    /* JADX INFO: renamed from: d */
    public static void m1432d(String str, String str2, Object obj, Object obj2) {
        Log.d(getTag(str), String.format(str2, obj, obj2));
    }

    /* JADX INFO: renamed from: d */
    public static void m1433d(String str, String str2, Object... objArr) {
        Log.d(getTag(str), String.format(str2, objArr));
    }

    /* JADX INFO: renamed from: i */
    public static void m1435i(String str, String str2) {
        Log.i(getTag(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m1434e(String str, String str2, Throwable th) {
        Log.e(getTag(str), str2, th);
    }

    /* JADX INFO: renamed from: w */
    public static void m1436w(String str, String str2, Object obj) {
        Log.w(getTag(str), String.format(str2, obj));
    }
}
