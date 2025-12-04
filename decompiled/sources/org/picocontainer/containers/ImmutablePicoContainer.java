package org.picocontainer.containers;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.Converters;
import org.picocontainer.Converting;
import org.picocontainer.NameBinding;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.converters.ConvertsNothing;

/* loaded from: classes6.dex */
public final class ImmutablePicoContainer implements PicoContainer, Converting, Serializable {
    private final PicoContainer delegate;

    public ImmutablePicoContainer(PicoContainer picoContainer) {
        picoContainer.getClass();
        this.delegate = picoContainer;
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj) {
        return this.delegate.getComponent(obj);
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj, Type type) {
        return this.delegate.getComponent(obj, type);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls) {
        return (T) this.delegate.getComponent((Class) cls);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls, Class<? extends Annotation> cls2) {
        return (T) this.delegate.getComponent((Class) cls, cls2);
    }

    @Override // org.picocontainer.PicoContainer
    public List getComponents() {
        return this.delegate.getComponents();
    }

    @Override // org.picocontainer.PicoContainer
    public PicoContainer getParent() {
        return this.delegate.getParent();
    }

    @Override // org.picocontainer.PicoContainer
    public ComponentAdapter<?> getComponentAdapter(Object obj) {
        return this.delegate.getComponentAdapter(obj);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, NameBinding nameBinding) {
        return this.delegate.getComponentAdapter(cls, nameBinding);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, Class<? extends Annotation> cls2) {
        return this.delegate.getComponentAdapter(cls, cls2);
    }

    @Override // org.picocontainer.PicoContainer
    public Collection<ComponentAdapter<?>> getComponentAdapters() {
        return this.delegate.getComponentAdapters();
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls) {
        return this.delegate.getComponentAdapters(cls);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls, Class<? extends Annotation> cls2) {
        return this.delegate.getComponentAdapters(cls, cls2);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<T> getComponents(Class<T> cls) {
        return this.delegate.getComponents(cls);
    }

    @Override // org.picocontainer.PicoContainer
    public final void accept(PicoVisitor picoVisitor) {
        this.delegate.accept(picoVisitor);
    }

    public boolean equals(Object obj) {
        return obj == this || (obj != null && obj == this.delegate) || ((obj instanceof ImmutablePicoContainer) && ((ImmutablePicoContainer) obj).delegate == this.delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return "[Immutable]:" + this.delegate.toString();
    }

    @Override // org.picocontainer.Converting
    public Converters getConverters() {
        PicoContainer picoContainer = this.delegate;
        if (picoContainer instanceof Converting) {
            return ((Converting) picoContainer).getConverters();
        }
        return new ConvertsNothing();
    }
}
