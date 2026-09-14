package com.appdynamics.eumagent.runtime;

/* JADX INFO: loaded from: classes2.dex */
@DontObfuscate
public interface CallTracker {
    void reportCallEnded();

    void reportCallEndedWithException(Exception exc);

    void reportCallEndedWithReturnValue(Object obj);

    void setStartTime(long j);

    CallTracker withArguments(Object... objArr);
}
