package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class ThreadCaching extends AbstractBehaviorFactory {
    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_CACHE)) {
            return super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.CACHE);
        return componentMonitor.newBehavior(new ThreadCached(super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr)));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_CACHE)) {
            return super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.CACHE);
        return componentMonitor.newBehavior(new ThreadCached(super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter)));
    }
}
