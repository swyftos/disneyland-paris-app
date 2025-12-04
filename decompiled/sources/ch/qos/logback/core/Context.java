package ch.qos.logback.core;

import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.status.StatusManager;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes2.dex */
public interface Context extends PropertyContainer {
    void addScheduledFuture(ScheduledFuture<?> scheduledFuture);

    long getBirthTime();

    Object getConfigurationLock();

    @Override // ch.qos.logback.core.spi.PropertyContainer
    Map<String, String> getCopyOfPropertyMap();

    ExecutorService getExecutorService();

    String getName();

    Object getObject(String str);

    @Override // ch.qos.logback.core.spi.PropertyContainer
    String getProperty(String str);

    ScheduledExecutorService getScheduledExecutorService();

    StatusManager getStatusManager();

    void putObject(String str, Object obj);

    void putProperty(String str, String str2);

    void register(LifeCycle lifeCycle);

    void setName(String str);
}
