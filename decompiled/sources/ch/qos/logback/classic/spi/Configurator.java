package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.spi.ContextAware;

/* loaded from: classes2.dex */
public interface Configurator extends ContextAware {
    void configure(LoggerContext loggerContext);
}
