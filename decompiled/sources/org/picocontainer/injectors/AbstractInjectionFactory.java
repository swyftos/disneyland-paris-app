package org.picocontainer.injectors;

import java.io.Serializable;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.ComponentMonitorStrategy;
import org.picocontainer.InjectionFactory;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.lifecycle.NullLifecycleStrategy;

/* loaded from: classes6.dex */
public abstract class AbstractInjectionFactory implements InjectionFactory, Serializable {
    @Override // org.picocontainer.ComponentFactory
    public void verify(PicoContainer picoContainer) {
    }

    @Override // org.picocontainer.ComponentFactory
    public final void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitComponentFactory(this);
    }

    protected ComponentAdapter wrapLifeCycle(org.picocontainer.Injector injector, LifecycleStrategy lifecycleStrategy) {
        return lifecycleStrategy instanceof NullLifecycleStrategy ? injector : new LifecycleAdapter(injector, lifecycleStrategy);
    }

    private static class LifecycleAdapter implements org.picocontainer.Injector, LifecycleStrategy, ComponentMonitorStrategy, Serializable {
        private final org.picocontainer.Injector delegate;
        private final LifecycleStrategy lifecycleStrategy;

        public LifecycleAdapter(org.picocontainer.Injector injector, LifecycleStrategy lifecycleStrategy) {
            this.delegate = injector;
            this.lifecycleStrategy = lifecycleStrategy;
        }

        @Override // org.picocontainer.ComponentAdapter
        public Object getComponentKey() {
            return this.delegate.getComponentKey();
        }

        @Override // org.picocontainer.ComponentAdapter
        public Class getComponentImplementation() {
            return this.delegate.getComponentImplementation();
        }

        @Override // org.picocontainer.ComponentAdapter
        public Object getComponentInstance(PicoContainer picoContainer) {
            return this.delegate.getComponentInstance(picoContainer);
        }

        @Override // org.picocontainer.ComponentAdapter
        public Object getComponentInstance(PicoContainer picoContainer, Type type) {
            return this.delegate.getComponentInstance(picoContainer, type);
        }

        @Override // org.picocontainer.ComponentAdapter
        public void verify(PicoContainer picoContainer) throws PicoCompositionException {
            this.delegate.verify(picoContainer);
        }

        @Override // org.picocontainer.ComponentAdapter
        public void accept(PicoVisitor picoVisitor) {
            this.delegate.accept(picoVisitor);
        }

        @Override // org.picocontainer.ComponentAdapter
        public ComponentAdapter getDelegate() {
            return this.delegate;
        }

        @Override // org.picocontainer.ComponentAdapter
        public ComponentAdapter findAdapterOfType(Class cls) {
            return this.delegate.findAdapterOfType(cls);
        }

        @Override // org.picocontainer.ComponentAdapter
        public String getDescriptor() {
            return "LifecycleAdapter";
        }

        public String toString() {
            return getDescriptor() + ":" + this.delegate.toString();
        }

        @Override // org.picocontainer.LifecycleStrategy
        public void start(Object obj) {
            this.lifecycleStrategy.start(obj);
        }

        @Override // org.picocontainer.LifecycleStrategy
        public void stop(Object obj) {
            this.lifecycleStrategy.stop(obj);
        }

        @Override // org.picocontainer.LifecycleStrategy
        public void dispose(Object obj) {
            this.lifecycleStrategy.dispose(obj);
        }

        @Override // org.picocontainer.LifecycleStrategy
        public boolean hasLifecycle(Class cls) {
            return this.lifecycleStrategy.hasLifecycle(cls);
        }

        @Override // org.picocontainer.LifecycleStrategy
        public boolean isLazy(ComponentAdapter componentAdapter) {
            return this.lifecycleStrategy.isLazy(componentAdapter);
        }

        @Override // org.picocontainer.ComponentMonitorStrategy
        public void changeMonitor(ComponentMonitor componentMonitor) {
            org.picocontainer.Injector injector = this.delegate;
            if (injector instanceof ComponentMonitorStrategy) {
                ((ComponentMonitorStrategy) injector).changeMonitor(componentMonitor);
            }
        }

        @Override // org.picocontainer.ComponentMonitorStrategy
        public ComponentMonitor currentMonitor() {
            org.picocontainer.Injector injector = this.delegate;
            if (injector instanceof ComponentMonitorStrategy) {
                return ((ComponentMonitorStrategy) injector).currentMonitor();
            }
            return null;
        }

        @Override // org.picocontainer.Injector
        public Object decorateComponentInstance(PicoContainer picoContainer, Type type, Object obj) {
            return this.delegate.decorateComponentInstance(picoContainer, type, obj);
        }
    }
}
