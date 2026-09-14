package ch.qos.logback.core;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;

/* JADX INFO: loaded from: classes2.dex */
public interface Layout<E> extends ContextAware, LifeCycle {
    String doLayout(E e);

    String getContentType();

    String getFileFooter();

    String getFileHeader();

    String getPresentationFooter();

    String getPresentationHeader();
}
