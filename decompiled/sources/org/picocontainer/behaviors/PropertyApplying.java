package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public final class PropertyApplying extends AbstractBehaviorFactory {
    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        ComponentAdapter<T> componentAdapterCreateComponentAdapter = super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.PROPERTY_APPLYING);
        return componentMonitor.newBehavior(new PropertyApplicator(componentAdapterCreateComponentAdapter));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter) {
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.PROPERTY_APPLYING);
        return componentMonitor.newBehavior(new PropertyApplicator(super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter)));
    }
}
