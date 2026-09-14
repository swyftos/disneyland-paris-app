package ch.qos.logback.classic.spi;

/* JADX INFO: loaded from: classes2.dex */
public interface IThrowableProxy {
    IThrowableProxy getCause();

    String getClassName();

    int getCommonFrames();

    String getMessage();

    StackTraceElementProxy[] getStackTraceElementProxyArray();

    IThrowableProxy[] getSuppressed();
}
