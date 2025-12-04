package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class Guarding extends AbstractBehaviorFactory {
    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        String andRemovePropertiesIfPresentByKey = AbstractBehaviorFactory.getAndRemovePropertiesIfPresentByKey(properties, Characteristics.GUARD);
        ComponentAdapter<T> componentAdapterCreateComponentAdapter = super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
        return andRemovePropertiesIfPresentByKey == null ? componentAdapterCreateComponentAdapter : componentMonitor.newBehavior(new Guarded(componentAdapterCreateComponentAdapter, andRemovePropertiesIfPresentByKey));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter) {
        String andRemovePropertiesIfPresentByKey = AbstractBehaviorFactory.getAndRemovePropertiesIfPresentByKey(properties, Characteristics.GUARD);
        ComponentAdapter<T> componentAdapterAddComponentAdapter = super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
        return andRemovePropertiesIfPresentByKey == null ? componentAdapterAddComponentAdapter : componentMonitor.newBehavior(componentMonitor.newBehavior(new Guarded(componentAdapterAddComponentAdapter, andRemovePropertiesIfPresentByKey)));
    }
}
