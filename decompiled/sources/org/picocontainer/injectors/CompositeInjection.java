package org.picocontainer.injectors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.InjectionFactory;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.behaviors.AbstractBehaviorFactory;

/* loaded from: classes6.dex */
public class CompositeInjection extends AbstractInjectionFactory {
    private final InjectionFactory[] injectionFactories;

    public CompositeInjection(InjectionFactory... injectionFactoryArr) {
        this.injectionFactories = injectionFactoryArr;
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        org.picocontainer.Injector[] injectorArr = new org.picocontainer.Injector[this.injectionFactories.length];
        int i = 0;
        while (true) {
            InjectionFactory[] injectionFactoryArr = this.injectionFactories;
            if (i < injectionFactoryArr.length) {
                injectorArr[i] = (org.picocontainer.Injector) injectionFactoryArr[i].createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
                i++;
            } else {
                return wrapLifeCycle(componentMonitor.newInjector(new CompositeInjector(obj, cls, parameterArr, componentMonitor, AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true), injectorArr)), lifecycleStrategy);
            }
        }
    }
}
