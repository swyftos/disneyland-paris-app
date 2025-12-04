package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

/* loaded from: classes2.dex */
public interface LoggerContextListener {
    boolean isResetResistant();

    void onLevelChange(Logger logger, Level level);

    void onReset(LoggerContext loggerContext);

    void onStart(LoggerContext loggerContext);

    void onStop(LoggerContext loggerContext);
}
