package ch.qos.logback.core.encoder;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes2.dex */
public interface Encoder<E> extends ContextAware, LifeCycle {
    byte[] encode(E e);

    byte[] footerBytes();

    byte[] headerBytes();
}
