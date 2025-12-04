package com.appdynamics.eumagent.runtime;

import java.util.Collection;

@DontObfuscate
/* loaded from: classes2.dex */
public interface CrashReportCallback {
    void onCrashesReported(Collection<CrashReportSummary> collection);
}
