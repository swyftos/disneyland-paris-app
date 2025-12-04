package org.picocontainer.behaviors;

import java.util.Properties;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.behaviors.FieldDecorated;

/* loaded from: classes6.dex */
public abstract class FieldDecorating extends AbstractBehaviorFactory implements FieldDecorated.Decorator {
    private final Class fieldClass;

    public FieldDecorating(Class<?> cls) {
        this.fieldClass = cls;
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public ComponentAdapter createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class cls, Parameter... parameterArr) throws PicoCompositionException {
        return componentMonitor.newBehavior(new FieldDecorated(super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr), this.fieldClass, this));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public ComponentAdapter addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter componentAdapter) {
        return super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
    }
}
