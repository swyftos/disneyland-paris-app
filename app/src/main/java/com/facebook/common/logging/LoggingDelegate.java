package com.facebook.common.logging;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface LoggingDelegate {
    /* JADX INFO: renamed from: d */
    void mo1335d(String str, String str2);

    /* JADX INFO: renamed from: d */
    void mo1336d(String str, String str2, Throwable th);

    /* JADX INFO: renamed from: e */
    void mo1337e(String str, String str2);

    /* JADX INFO: renamed from: e */
    void mo1338e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* JADX INFO: renamed from: i */
    void mo1339i(String str, String str2);

    /* JADX INFO: renamed from: i */
    void mo1340i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* JADX INFO: renamed from: v */
    void mo1341v(String str, String str2);

    /* JADX INFO: renamed from: v */
    void mo1342v(String str, String str2, Throwable th);

    /* JADX INFO: renamed from: w */
    void mo1343w(String str, String str2);

    /* JADX INFO: renamed from: w */
    void mo1344w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
