package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes2.dex */
public class LoggerContextAwareBase extends ContextAwareBase implements LoggerContextAware {
    public LoggerContext getLoggerContext() {
        return (LoggerContext) this.context;
    }

    @Override // ch.qos.logback.core.spi.ContextAwareBase, ch.qos.logback.core.spi.ContextAware
    public void setContext(Context context) {
        if (!(context instanceof LoggerContext) && context != null) {
            throw new IllegalArgumentException("LoggerContextAwareBase only accepts contexts of type c.l.classic.LoggerContext");
        }
        super.setContext(context);
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextAware
    public void setLoggerContext(LoggerContext loggerContext) {
        super.setContext(loggerContext);
    }
}
