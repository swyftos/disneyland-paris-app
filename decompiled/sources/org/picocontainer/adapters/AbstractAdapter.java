package org.picocontainer.adapters;

import java.io.Serializable;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.ComponentMonitorStrategy;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.injectors.Provider;
import org.picocontainer.injectors.ProviderAdapter;
import org.picocontainer.monitors.AbstractComponentMonitor;
import org.picocontainer.monitors.NullComponentMonitor;

/* loaded from: classes6.dex */
public abstract class AbstractAdapter<T> implements ComponentAdapter<T>, ComponentMonitorStrategy, Serializable {
    private Class componentImplementation;
    private Object componentKey;
    private ComponentMonitor componentMonitor;

    @Override // org.picocontainer.ComponentAdapter
    public final ComponentAdapter<T> getDelegate() {
        return null;
    }

    public AbstractAdapter(Object obj, Class cls) {
        this(obj, cls, new AbstractComponentMonitor());
        this.componentMonitor = new NullComponentMonitor();
    }

    public AbstractAdapter(Object obj, Class cls, ComponentMonitor componentMonitor) {
        if (componentMonitor == null) {
            throw new NullPointerException("ComponentMonitor==null");
        }
        this.componentMonitor = componentMonitor;
        if (cls == null) {
            throw new NullPointerException("componentImplementation");
        }
        this.componentKey = obj;
        this.componentImplementation = cls;
        checkTypeCompatibility();
    }

    @Override // org.picocontainer.ComponentAdapter
    public Object getComponentKey() {
        Object obj = this.componentKey;
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("componentKey");
    }

    @Override // org.picocontainer.ComponentAdapter
    public Class<? extends T> getComponentImplementation() {
        return this.componentImplementation;
    }

    protected void checkTypeCompatibility() {
        Object obj = this.componentKey;
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (Provider.class.isAssignableFrom(this.componentImplementation)) {
                if (!cls.isAssignableFrom(ProviderAdapter.getProvideMethod(this.componentImplementation).getReturnType())) {
                    throw newCCE(cls);
                }
            } else if (!cls.isAssignableFrom(this.componentImplementation)) {
                throw newCCE(cls);
            }
        }
    }

    private ClassCastException newCCE(Class cls) {
        return new ClassCastException(this.componentImplementation.getName() + " is not a " + cls.getName());
    }

    @Override // org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer) throws PicoCompositionException {
        return getComponentInstance(picoContainer, null);
    }

    public String toString() {
        return getDescriptor() + getComponentKey();
    }

    @Override // org.picocontainer.ComponentAdapter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitComponentAdapter(this);
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public void changeMonitor(ComponentMonitor componentMonitor) {
        this.componentMonitor = componentMonitor;
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public ComponentMonitor currentMonitor() {
        return this.componentMonitor;
    }

    @Override // org.picocontainer.ComponentAdapter
    public final <U extends ComponentAdapter> U findAdapterOfType(Class<U> cls) {
        if (cls.isAssignableFrom(getClass())) {
            return this;
        }
        if (getDelegate() != null) {
            return (U) getDelegate().findAdapterOfType(cls);
        }
        return null;
    }
}
