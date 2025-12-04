package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class ImplementationHiding extends AbstractBehaviorFactory {
    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public ComponentAdapter createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class cls, Parameter... parameterArr) throws PicoCompositionException {
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.ENABLE_CIRCULAR);
        ComponentAdapter componentAdapterCreateComponentAdapter = super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_HIDE_IMPL)) {
            return componentAdapterCreateComponentAdapter;
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.HIDE_IMPL);
        return componentMonitor.newBehavior(new HiddenImplementation(componentAdapterCreateComponentAdapter));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public ComponentAdapter addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter componentAdapter) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_HIDE_IMPL)) {
            return componentAdapter;
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.HIDE_IMPL);
        return componentMonitor.newBehavior(new HiddenImplementation(super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter)));
    }
}
