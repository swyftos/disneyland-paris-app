package ch.qos.logback.classic.selector;

import ch.qos.logback.classic.LoggerContext;
import java.util.List;

/* loaded from: classes2.dex */
public interface ContextSelector {
    LoggerContext detachLoggerContext(String str);

    List<String> getContextNames();

    LoggerContext getDefaultLoggerContext();

    LoggerContext getLoggerContext();

    LoggerContext getLoggerContext(String str);
}
