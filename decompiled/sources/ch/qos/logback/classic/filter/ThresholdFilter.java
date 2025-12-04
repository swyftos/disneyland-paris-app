package ch.qos.logback.classic.filter;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes2.dex */
public class ThresholdFilter extends Filter<ILoggingEvent> {
    Level level;

    @Override // ch.qos.logback.core.filter.Filter
    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (isStarted() && !iLoggingEvent.getLevel().isGreaterOrEqual(this.level)) {
            return FilterReply.DENY;
        }
        return FilterReply.NEUTRAL;
    }

    public void setLevel(String str) {
        this.level = Level.toLevel(str);
    }

    @Override // ch.qos.logback.core.filter.Filter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.level != null) {
            super.start();
        }
    }
}
