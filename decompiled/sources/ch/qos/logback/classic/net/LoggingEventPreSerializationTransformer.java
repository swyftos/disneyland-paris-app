package ch.qos.logback.classic.net;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.spi.LoggingEventVO;
import ch.qos.logback.core.spi.PreSerializationTransformer;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class LoggingEventPreSerializationTransformer implements PreSerializationTransformer<ILoggingEvent> {
    @Override // ch.qos.logback.core.spi.PreSerializationTransformer
    public Serializable transform(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent == null) {
            return null;
        }
        if (iLoggingEvent instanceof LoggingEvent) {
            return LoggingEventVO.build(iLoggingEvent);
        }
        if (iLoggingEvent instanceof LoggingEventVO) {
            return (LoggingEventVO) iLoggingEvent;
        }
        throw new IllegalArgumentException("Unsupported type " + iLoggingEvent.getClass().getName());
    }
}
