package org.picocontainer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes5.dex */
public interface Injector<T> extends ComponentAdapter<T> {
    Object decorateComponentInstance(PicoContainer picoContainer, Type type, T t);
}
