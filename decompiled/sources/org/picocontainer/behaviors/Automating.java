package org.picocontainer.behaviors;

import java.io.Serializable;
import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class Automating extends AbstractBehaviorFactory implements Serializable {
    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public ComponentAdapter createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class cls, Parameter... parameterArr) throws PicoCompositionException {
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.AUTOMATIC);
        return componentMonitor.newBehavior(new Automated(super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr)));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public ComponentAdapter addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter componentAdapter) {
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.AUTOMATIC);
        return componentMonitor.newBehavior(new Automated(super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter)));
    }
}
