package com.appdynamics.eumagent.runtime;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@DontObfuscate
public interface CrashReportCallback {
    void onCrashesReported(Collection<CrashReportSummary> collection);
}
