package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.spi.ContextAware;
import java.util.Date;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public interface ArchiveRemover extends ContextAware {
    void clean(Date date);

    Future<?> cleanAsynchronously(Date date);

    void setMaxHistory(int i);

    void setTotalSizeCap(long j);
}
