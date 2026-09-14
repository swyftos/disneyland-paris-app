package com.facebook.soloader;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class LogUtil {
    /* JADX INFO: renamed from: e */
    public static void m1406e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    /* JADX INFO: renamed from: e */
    public static void m1405e(String str, String str2) {
        Log.e(str, str2);
    }

    /* JADX INFO: renamed from: w */
    public static void m1412w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    /* JADX INFO: renamed from: w */
    public static void m1411w(String str, String str2) {
        Log.w(str, str2);
    }

    /* JADX INFO: renamed from: i */
    public static void m1408i(String str, String str2, Throwable th) {
        if (isLoggable(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1407i(String str, String str2) {
        if (isLoggable(str, 4)) {
            Log.i(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1404d(String str, String str2, Throwable th) {
        if (isLoggable(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1403d(String str, String str2) {
        if (isLoggable(str, 3)) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1410v(String str, String str2, Throwable th) {
        if (isLoggable(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1409v(String str, String str2) {
        if (isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    private static boolean isLoggable(String str, int i) {
        return Log.isLoggable(str, i);
    }
}
