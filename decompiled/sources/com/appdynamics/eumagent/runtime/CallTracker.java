package com.appdynamics.eumagent.runtime;

@DontObfuscate
/* loaded from: classes2.dex */
public interface CallTracker {
    void reportCallEnded();

    void reportCallEndedWithException(Exception exc);

    void reportCallEndedWithReturnValue(Object obj);

    void setStartTime(long j);

    CallTracker withArguments(Object... objArr);
}
