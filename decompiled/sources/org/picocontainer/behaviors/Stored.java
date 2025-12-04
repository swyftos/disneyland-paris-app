package org.picocontainer.behaviors;

import java.io.Serializable;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentLifecycle;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.ObjectReference;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class Stored<T> extends AbstractBehavior<T> {
    private final ObjectReference instanceReference;
    private final ComponentLifecycle lifecycleDelegate;

    public Stored(ComponentAdapter<T> componentAdapter, ObjectReference<Instance<T>> objectReference) {
        super(componentAdapter);
        this.instanceReference = objectReference;
        this.lifecycleDelegate = hasLifecycle(componentAdapter) ? new RealComponentLifecycle() : new NoComponentLifecycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void guardInstRef() {
        if (this.instanceReference.get() == null) {
            this.instanceReference.set(new Instance());
        }
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentLifecycle
    public boolean componentHasLifecycle() {
        return this.lifecycleDelegate.componentHasLifecycle();
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentLifecycle
    public void dispose(PicoContainer picoContainer) {
        this.lifecycleDelegate.dispose(picoContainer);
    }

    public T getStoredObject() {
        guardInstRef();
        return (T) ((Instance) this.instanceReference.get()).instance;
    }

    public void flush() {
        Instance instance = (Instance) this.instanceReference.get();
        if (instance != null) {
            Object obj = instance.instance;
            if (obj != null && ((Instance) this.instanceReference.get()).started) {
                stop(obj);
                dispose(obj);
            }
            this.instanceReference.set(null);
        }
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        guardInstRef();
        T t = (T) ((Instance) this.instanceReference.get()).instance;
        if (t != null) {
            return t;
        }
        T t2 = (T) super.getComponentInstance(picoContainer, type);
        ((Instance) this.instanceReference.get()).instance = t2;
        return t2;
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Stored" + getLifecycleDescriptor();
    }

    protected String getLifecycleDescriptor() {
        return this.lifecycleDelegate.componentHasLifecycle() ? "+Lifecycle" : "";
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentLifecycle
    public void start(PicoContainer picoContainer) {
        this.lifecycleDelegate.start(picoContainer);
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentLifecycle
    public void stop(PicoContainer picoContainer) {
        this.lifecycleDelegate.stop(picoContainer);
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentLifecycle
    public boolean isStarted() {
        return this.lifecycleDelegate.isStarted();
    }

    private class RealComponentLifecycle implements ComponentLifecycle, Serializable {
        @Override // org.picocontainer.ComponentLifecycle
        public boolean componentHasLifecycle() {
            return true;
        }

        private RealComponentLifecycle() {
        }

        @Override // org.picocontainer.ComponentLifecycle
        public void start(PicoContainer picoContainer) {
            Stored.this.guardInstRef();
            guardAlreadyDisposed();
            guardStartState(true, "already started");
            Stored stored = Stored.this;
            stored.start(stored.getComponentInstance(picoContainer, ComponentAdapter.NOTHING.class));
            ((Instance) Stored.this.instanceReference.get()).started = true;
        }

        @Override // org.picocontainer.ComponentLifecycle
        public void stop(PicoContainer picoContainer) {
            Stored.this.guardInstRef();
            guardAlreadyDisposed();
            guardNotInstantiated();
            guardStartState(false, "not started");
            Stored stored = Stored.this;
            stored.stop(((Instance) stored.instanceReference.get()).instance);
            ((Instance) Stored.this.instanceReference.get()).started = false;
        }

        @Override // org.picocontainer.ComponentLifecycle
        public void dispose(PicoContainer picoContainer) {
            Stored.this.guardInstRef();
            Instance instance = (Instance) Stored.this.instanceReference.get();
            if (instance.instance != null) {
                guardAlreadyDisposed();
                Stored.this.dispose(instance.instance);
                instance.disposed = true;
            }
        }

        private void guardNotInstantiated() {
            if (((Instance) Stored.this.instanceReference.get()).instance != null) {
                return;
            }
            throw new IllegalStateException("'" + Stored.this.getComponentKey() + "' not instantiated");
        }

        private void guardStartState(boolean z, String str) {
            if (((Instance) Stored.this.instanceReference.get()).started != z) {
                return;
            }
            throw new IllegalStateException("'" + Stored.this.getComponentKey() + "' " + str);
        }

        private void guardAlreadyDisposed() {
            if (((Instance) Stored.this.instanceReference.get()).disposed) {
                throw new IllegalStateException("'" + Stored.this.getComponentKey() + "' already disposed");
            }
        }

        @Override // org.picocontainer.ComponentLifecycle
        public boolean isStarted() {
            Stored.this.guardInstRef();
            return ((Instance) Stored.this.instanceReference.get()).started;
        }
    }

    private static class NoComponentLifecycle implements ComponentLifecycle, Serializable {
        @Override // org.picocontainer.ComponentLifecycle
        public boolean componentHasLifecycle() {
            return false;
        }

        @Override // org.picocontainer.ComponentLifecycle
        public void dispose(PicoContainer picoContainer) {
        }

        @Override // org.picocontainer.ComponentLifecycle
        public boolean isStarted() {
            return false;
        }

        @Override // org.picocontainer.ComponentLifecycle
        public void start(PicoContainer picoContainer) {
        }

        @Override // org.picocontainer.ComponentLifecycle
        public void stop(PicoContainer picoContainer) {
        }

        private NoComponentLifecycle() {
        }
    }

    private static boolean hasLifecycle(ComponentAdapter componentAdapter) {
        return (componentAdapter instanceof LifecycleStrategy) && ((LifecycleStrategy) componentAdapter).hasLifecycle(componentAdapter.getComponentImplementation());
    }

    public static class Instance<T> implements Serializable {
        protected boolean disposed;
        private Object instance;
        protected boolean started;
    }
}
