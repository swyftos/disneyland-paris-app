package io.cucumber.core.logging;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.LogRecord;

/* loaded from: classes5.dex */
public final class LogRecordListener {
    private final ConcurrentLinkedDeque logRecords = new ConcurrentLinkedDeque();

    void logRecordSubmitted(LogRecord logRecord) {
        this.logRecords.add(logRecord);
    }

    public List<LogRecord> getLogRecords() {
        return Arrays.asList(this.logRecords.toArray(new LogRecord[0]));
    }
}
