package org.picocontainer;

import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public interface ComponentAdapter<T> {

    public static class NOTHING {
    }

    void accept(PicoVisitor picoVisitor);

    <U extends ComponentAdapter> U findAdapterOfType(Class<U> cls);

    Class<? extends T> getComponentImplementation();

    T getComponentInstance(PicoContainer picoContainer) throws PicoCompositionException;

    T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException;

    Object getComponentKey();

    ComponentAdapter<T> getDelegate();

    String getDescriptor();

    void verify(PicoContainer picoContainer) throws PicoCompositionException;
}
