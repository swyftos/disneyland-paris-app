package org.picocontainer;

import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public interface Injector<T> extends ComponentAdapter<T> {
    Object decorateComponentInstance(PicoContainer picoContainer, Type type, T t);
}
