package org.picocontainer.injectors;

import java.lang.reflect.Type;
import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.InjectionFactory;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;
import org.picocontainer.behaviors.AbstractBehaviorFactory;

/* loaded from: classes6.dex */
public class Reinjection extends CompositeInjection {
    public Reinjection(InjectionFactory injectionFactory, final PicoContainer picoContainer) {
        super(new AbstractInjectionFactory() { // from class: org.picocontainer.injectors.Reinjection.1
            @Override // org.picocontainer.ComponentFactory
            public ComponentAdapter createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class cls, Parameter... parameterArr) {
                return new ReinjectionInjector(obj, cls, parameterArr, componentMonitor, picoContainer, AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true));
            }
        }, injectionFactory);
    }

    private static class ReinjectionInjector extends AbstractInjector {
        private final PicoContainer parent;

        public ReinjectionInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, PicoContainer picoContainer, boolean z) {
            super(obj, cls, parameterArr, componentMonitor, z);
            this.parent = picoContainer;
        }

        @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
        public Object getComponentInstance(PicoContainer picoContainer, Type type) {
            return this.parent.getComponent(getComponentKey());
        }
    }
}
