package com.appdynamics.eumagent.runtime;

/* JADX INFO: loaded from: classes2.dex */
@DontObfuscate
public class CrashReportSummary {
    public final String crashId;
    public final String exceptionClass;
    public final String exceptionMessage;

    public CrashReportSummary(String str, String str2, String str3) {
        this.crashId = str;
        this.exceptionClass = str2;
        this.exceptionMessage = str3;
    }
}
