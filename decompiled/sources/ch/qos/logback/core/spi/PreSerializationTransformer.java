package ch.qos.logback.core.spi;

import java.io.Serializable;

/* loaded from: classes2.dex */
public interface PreSerializationTransformer<E> {
    Serializable transform(E e);
}
