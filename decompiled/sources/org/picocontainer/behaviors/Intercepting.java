package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class Intercepting extends AbstractBehaviorFactory {
    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        return componentMonitor.newBehavior(new Intercepted(super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr)));
    }
}
