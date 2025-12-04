package ch.qos.logback.core.rolling;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.helper.CompressionMode;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes2.dex */
public interface RollingPolicy extends LifeCycle {
    String getActiveFileName();

    CompressionMode getCompressionMode();

    void rollover() throws RolloverFailure;

    void setParent(FileAppender<?> fileAppender);
}
