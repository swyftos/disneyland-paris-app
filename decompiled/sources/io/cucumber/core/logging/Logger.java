package io.cucumber.core.logging;

/* loaded from: classes5.dex */
public interface Logger {
    void config(String str);

    void config(String str, Throwable th);

    void debug(String str);

    void debug(String str, Throwable th);

    void error(String str);

    void error(String str, Throwable th);

    void info(String str);

    void info(String str, Throwable th);

    void trace(String str);

    void trace(String str, Throwable th);

    void warn(String str);

    void warn(String str, Throwable th);
}
