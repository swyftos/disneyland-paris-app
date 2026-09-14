package ch.qos.logback.core.sift;

import ch.qos.logback.core.spi.LifeCycle;

/* JADX INFO: loaded from: classes2.dex */
public interface Discriminator<E> extends LifeCycle {
    String getDiscriminatingValue(E e);

    String getKey();
}
