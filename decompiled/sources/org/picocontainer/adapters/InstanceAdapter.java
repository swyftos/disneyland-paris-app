package org.picocontainer.adapters;

import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentLifecycle;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.lifecycle.NullLifecycleStrategy;
import org.picocontainer.monitors.NullComponentMonitor;

/* loaded from: classes6.dex */
public final class InstanceAdapter<T> extends AbstractAdapter<T> implements ComponentLifecycle<T>, LifecycleStrategy {
    private final Object componentInstance;
    private final LifecycleStrategy lifecycleStrategy;
    private boolean started;

    @Override // org.picocontainer.ComponentAdapter
    public void verify(PicoContainer picoContainer) {
    }

    public InstanceAdapter(Object obj, T t, LifecycleStrategy lifecycleStrategy, ComponentMonitor componentMonitor) throws PicoCompositionException {
        super(obj, getInstanceClass(t), componentMonitor);
        this.componentInstance = t;
        this.lifecycleStrategy = lifecycleStrategy;
    }

    public InstanceAdapter(Object obj, T t) {
        this(obj, t, new NullLifecycleStrategy(), new NullComponentMonitor());
    }

    public InstanceAdapter(Object obj, T t, LifecycleStrategy lifecycleStrategy) {
        this(obj, t, lifecycleStrategy, new NullComponentMonitor());
    }

    public InstanceAdapter(Object obj, T t, ComponentMonitor componentMonitor) {
        this(obj, t, new NullLifecycleStrategy(), componentMonitor);
    }

    private static Class getInstanceClass(Object obj) {
        if (obj == null) {
            throw new NullPointerException("componentInstance cannot be null");
        }
        return obj.getClass();
    }

    @Override // org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) {
        return (T) this.componentInstance;
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Instance-";
    }

    @Override // org.picocontainer.adapters.AbstractAdapter
    public String toString() {
        Object componentKey = getComponentKey();
        if (componentKey instanceof Class) {
            componentKey = "of " + ((Class) componentKey).getName();
        }
        return getDescriptor() + componentKey;
    }

    @Override // org.picocontainer.ComponentLifecycle
    public void start(PicoContainer picoContainer) {
        start(this.componentInstance);
    }

    @Override // org.picocontainer.ComponentLifecycle
    public void stop(PicoContainer picoContainer) {
        stop(this.componentInstance);
    }

    @Override // org.picocontainer.ComponentLifecycle
    public void dispose(PicoContainer picoContainer) {
        dispose(this.componentInstance);
    }

    @Override // org.picocontainer.ComponentLifecycle
    public boolean componentHasLifecycle() {
        return hasLifecycle(this.componentInstance.getClass());
    }

    @Override // org.picocontainer.ComponentLifecycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) {
        this.lifecycleStrategy.start(this.componentInstance);
        this.started = true;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) {
        this.lifecycleStrategy.stop(this.componentInstance);
        this.started = false;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) {
        this.lifecycleStrategy.dispose(this.componentInstance);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        return this.lifecycleStrategy.hasLifecycle(cls);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean isLazy(ComponentAdapter<?> componentAdapter) {
        return this.lifecycleStrategy.isLazy(componentAdapter);
    }
}
