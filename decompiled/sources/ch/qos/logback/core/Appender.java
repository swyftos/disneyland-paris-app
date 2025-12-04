package ch.qos.logback.core;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.FilterAttachable;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes2.dex */
public interface Appender<E> extends LifeCycle, ContextAware, FilterAttachable<E> {
    void doAppend(E e) throws LogbackException;

    String getName();

    void setName(String str);
}
