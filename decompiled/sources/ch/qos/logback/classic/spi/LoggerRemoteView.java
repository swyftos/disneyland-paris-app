package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.LoggerContext;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class LoggerRemoteView implements Serializable {
    private static final long serialVersionUID = 5028223666108713696L;
    final LoggerContextVO loggerContextView;
    final String name;

    public LoggerRemoteView(String str, LoggerContext loggerContext) {
        this.name = str;
        this.loggerContextView = loggerContext.getLoggerContextRemoteView();
    }

    public LoggerContextVO getLoggerContextView() {
        return this.loggerContextView;
    }

    public String getName() {
        return this.name;
    }
}
