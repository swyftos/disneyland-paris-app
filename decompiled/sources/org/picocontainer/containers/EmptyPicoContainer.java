package org.picocontainer.containers;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.Converters;
import org.picocontainer.Converting;
import org.picocontainer.NameBinding;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.converters.ConvertsNothing;

/* loaded from: classes6.dex */
public class EmptyPicoContainer implements PicoContainer, Converting, Serializable {
    @Override // org.picocontainer.PicoContainer
    public void accept(PicoVisitor picoVisitor) {
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls, Class<? extends Annotation> cls2) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj, Type type) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, Class<? extends Annotation> cls2) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, NameBinding nameBinding) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public ComponentAdapter<?> getComponentAdapter(Object obj) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public PicoContainer getParent() {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public List getComponents() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.picocontainer.PicoContainer
    public Collection<ComponentAdapter<?>> getComponentAdapters() {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls) {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls, Class<? extends Annotation> cls2) {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<T> getComponents(Class<T> cls) {
        return Collections.emptyList();
    }

    public String toString() {
        return "(empty)";
    }

    @Override // org.picocontainer.Converting
    public Converters getConverters() {
        return new ConvertsNothing();
    }
}
