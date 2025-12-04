package org.picocontainer.behaviors;

import java.io.Serializable;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.ComponentMonitorStrategy;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public abstract class AbstractBehavior<T> implements org.picocontainer.Behavior<T>, ComponentMonitorStrategy, LifecycleStrategy, Serializable {
    protected final ComponentAdapter<T> delegate;

    public AbstractBehavior(ComponentAdapter<T> componentAdapter) {
        this.delegate = componentAdapter;
    }

    @Override // org.picocontainer.ComponentAdapter
    public Object getComponentKey() {
        return this.delegate.getComponentKey();
    }

    @Override // org.picocontainer.ComponentAdapter
    public Class<? extends T> getComponentImplementation() {
        return this.delegate.getComponentImplementation();
    }

    @Override // org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer) throws PicoCompositionException {
        return getComponentInstance(picoContainer, ComponentAdapter.NOTHING.class);
    }

    @Override // org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        return this.delegate.getComponentInstance(picoContainer, type);
    }

    @Override // org.picocontainer.ComponentAdapter
    public void verify(PicoContainer picoContainer) throws PicoCompositionException {
        this.delegate.verify(picoContainer);
    }

    @Override // org.picocontainer.ComponentAdapter
    public final ComponentAdapter<T> getDelegate() {
        return this.delegate;
    }

    @Override // org.picocontainer.ComponentAdapter
    public final <U extends ComponentAdapter> U findAdapterOfType(Class<U> cls) {
        return cls.isAssignableFrom(getClass()) ? this : (U) this.delegate.findAdapterOfType(cls);
    }

    @Override // org.picocontainer.ComponentAdapter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitComponentAdapter(this);
        this.delegate.accept(picoVisitor);
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public void changeMonitor(ComponentMonitor componentMonitor) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof ComponentMonitorStrategy) {
            ((ComponentMonitorStrategy) componentAdapter).changeMonitor(componentMonitor);
        }
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public ComponentMonitor currentMonitor() {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof ComponentMonitorStrategy) {
            return ((ComponentMonitorStrategy) componentAdapter).currentMonitor();
        }
        throw new PicoCompositionException("No component monitor found in delegate");
    }

    @Override // org.picocontainer.ComponentLifecycle
    public void start(PicoContainer picoContainer) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof org.picocontainer.Behavior) {
            ((org.picocontainer.Behavior) componentAdapter).start(picoContainer);
        }
    }

    @Override // org.picocontainer.ComponentLifecycle
    public void stop(PicoContainer picoContainer) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof org.picocontainer.Behavior) {
            ((org.picocontainer.Behavior) componentAdapter).stop(picoContainer);
        }
    }

    @Override // org.picocontainer.ComponentLifecycle
    public void dispose(PicoContainer picoContainer) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof org.picocontainer.Behavior) {
            ((org.picocontainer.Behavior) componentAdapter).dispose(picoContainer);
        }
    }

    @Override // org.picocontainer.ComponentLifecycle
    public boolean componentHasLifecycle() {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof org.picocontainer.Behavior) {
            return ((org.picocontainer.Behavior) componentAdapter).componentHasLifecycle();
        }
        return false;
    }

    @Override // org.picocontainer.ComponentLifecycle
    public boolean isStarted() {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof org.picocontainer.Behavior) {
            return ((org.picocontainer.Behavior) componentAdapter).isStarted();
        }
        return false;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof LifecycleStrategy) {
            ((LifecycleStrategy) componentAdapter).start(obj);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof LifecycleStrategy) {
            ((LifecycleStrategy) componentAdapter).stop(obj);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        if (componentAdapter instanceof LifecycleStrategy) {
            ((LifecycleStrategy) componentAdapter).dispose(obj);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        ComponentAdapter<T> componentAdapter = this.delegate;
        return (componentAdapter instanceof LifecycleStrategy) && ((LifecycleStrategy) componentAdapter).hasLifecycle(cls);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean isLazy(ComponentAdapter<?> componentAdapter) {
        ComponentAdapter<T> componentAdapter2 = this.delegate;
        return (componentAdapter2 instanceof LifecycleStrategy) && ((LifecycleStrategy) componentAdapter2).isLazy(componentAdapter);
    }

    public String toString() {
        return getDescriptor() + ":" + this.delegate.toString();
    }
}
