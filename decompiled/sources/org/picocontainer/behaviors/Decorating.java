package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.behaviors.Decorated;

/* loaded from: classes6.dex */
public abstract class Decorating extends AbstractBehaviorFactory implements Decorated.Decorator {
    @Override // org.picocontainer.behaviors.Decorated.Decorator
    public abstract /* synthetic */ void decorate(Object obj);

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public ComponentAdapter createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class cls, Parameter... parameterArr) throws PicoCompositionException {
        return componentMonitor.newBehavior(new Decorated(super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr), this));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public ComponentAdapter addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter componentAdapter) {
        return super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
    }
}
