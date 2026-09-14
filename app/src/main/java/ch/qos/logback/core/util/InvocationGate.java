package ch.qos.logback.core.util;

/* JADX INFO: loaded from: classes2.dex */
public interface InvocationGate {
    public static final long TIME_UNAVAILABLE = -1;

    boolean isTooSoon(long j);
}
