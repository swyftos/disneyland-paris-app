package org.picocontainer.injectors;

import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.slf4j.Marker;

/* loaded from: classes6.dex */
public class CompositeInjector<T> extends AbstractInjector<T> {
    private final org.picocontainer.Injector[] injectors;

    public CompositeInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z, org.picocontainer.Injector... injectorArr) {
        super(obj, cls, parameterArr, componentMonitor, z);
        this.injectors = injectorArr;
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.adapters.AbstractAdapter, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer) throws PicoCompositionException {
        return getComponentInstance(picoContainer, ComponentAdapter.NOTHING.class);
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        T componentInstance = null;
        for (org.picocontainer.Injector injector : this.injectors) {
            if (componentInstance == null) {
                componentInstance = injector.getComponentInstance(picoContainer, ComponentAdapter.NOTHING.class);
            } else {
                injector.decorateComponentInstance(picoContainer, type, componentInstance);
            }
        }
        return componentInstance;
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.Injector
    public Object decorateComponentInstance(PicoContainer picoContainer, Type type, T t) {
        Object objDecorateComponentInstance = null;
        for (org.picocontainer.Injector injector : this.injectors) {
            objDecorateComponentInstance = injector.decorateComponentInstance(picoContainer, type, t);
        }
        return objDecorateComponentInstance;
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public void verify(PicoContainer picoContainer) throws PicoCompositionException {
        for (org.picocontainer.Injector injector : this.injectors) {
            injector.verify(picoContainer);
        }
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.adapters.AbstractAdapter, org.picocontainer.ComponentAdapter
    public final void accept(PicoVisitor picoVisitor) {
        super.accept(picoVisitor);
        for (org.picocontainer.Injector injector : this.injectors) {
            injector.accept(picoVisitor);
        }
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        StringBuilder sb = new StringBuilder("CompositeInjector(");
        for (org.picocontainer.Injector injector : this.injectors) {
            sb.append(injector.getDescriptor());
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString().replace("-", Marker.ANY_NON_NULL_MARKER) + ")-";
    }
}
