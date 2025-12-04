package org.picocontainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/* loaded from: classes6.dex */
public interface PicoContainer {
    void accept(PicoVisitor picoVisitor);

    <T> T getComponent(Class<T> cls);

    <T> T getComponent(Class<T> cls, Class<? extends Annotation> cls2);

    Object getComponent(Object obj);

    Object getComponent(Object obj, Type type);

    <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, Class<? extends Annotation> cls2);

    <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, NameBinding nameBinding);

    ComponentAdapter<?> getComponentAdapter(Object obj);

    Collection<ComponentAdapter<?>> getComponentAdapters();

    <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls);

    <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls, Class<? extends Annotation> cls2);

    List<Object> getComponents();

    <T> List<T> getComponents(Class<T> cls);

    PicoContainer getParent();
}
