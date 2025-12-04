package ch.qos.logback.core;

/* loaded from: classes2.dex */
public class LogbackException extends RuntimeException {
    private static final long serialVersionUID = -799956346239073266L;

    public LogbackException(String str) {
        super(str);
    }

    public LogbackException(String str, Throwable th) {
        super(str, th);
    }
}
