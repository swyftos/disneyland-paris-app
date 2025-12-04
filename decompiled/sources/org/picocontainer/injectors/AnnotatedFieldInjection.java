package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.annotations.Inject;
import org.picocontainer.behaviors.AbstractBehaviorFactory;

/* loaded from: classes6.dex */
public class AnnotatedFieldInjection extends AbstractInjectionFactory {
    private final Class injectionAnnotation;

    public AnnotatedFieldInjection(Class<? extends Annotation> cls) {
        this.injectionAnnotation = cls;
    }

    public AnnotatedFieldInjection() {
        this(Inject.class);
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        return wrapLifeCycle(componentMonitor.newInjector(new AnnotatedFieldInjector(obj, cls, parameterArr, componentMonitor, this.injectionAnnotation, AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true))), lifecycleStrategy);
    }
}
