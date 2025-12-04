package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;

/* loaded from: classes6.dex */
public class Locking extends AbstractBehaviorFactory {
    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_LOCK)) {
            return super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.LOCK);
        return componentMonitor.newBehavior(new Locked(super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr)));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_LOCK)) {
            return super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.LOCK);
        return componentMonitor.newBehavior(new Locked(super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter)));
    }
}
