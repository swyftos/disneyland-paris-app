package ch.qos.logback.core.rolling;

import ch.qos.logback.core.rolling.helper.ArchiveRemover;
import ch.qos.logback.core.spi.ContextAware;

/* loaded from: classes2.dex */
public interface TimeBasedFileNamingAndTriggeringPolicy<E> extends TriggeringPolicy<E>, ContextAware {
    ArchiveRemover getArchiveRemover();

    String getCurrentPeriodsFileNameWithoutCompressionSuffix();

    long getCurrentTime();

    String getElapsedPeriodsFileName();

    void setCurrentTime(long j);

    void setTimeBasedRollingPolicy(TimeBasedRollingPolicy<E> timeBasedRollingPolicy);
}
