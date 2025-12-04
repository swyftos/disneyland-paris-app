package org.picocontainer.injectors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.behaviors.AbstractBehaviorFactory;

/* loaded from: classes6.dex */
public class ConstructorInjection extends AbstractInjectionFactory {
    private final boolean rememberChosenConstructor;

    public ConstructorInjection(boolean z) {
        this.rememberChosenConstructor = z;
    }

    public ConstructorInjection() {
        this(true);
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        ConstructorInjector constructorInjector = new ConstructorInjector(obj, cls, parameterArr, componentMonitor, AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true), this.rememberChosenConstructor);
        constructorInjector.enableEmjection(AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.EMJECTION_ENABLED));
        return wrapLifeCycle(componentMonitor.newInjector(constructorInjector), lifecycleStrategy);
    }
}
