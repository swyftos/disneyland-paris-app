package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.util.Properties;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.annotations.Inject;

/* loaded from: classes6.dex */
public class AnnotatedMethodInjection extends AbstractInjectionFactory {
    private final Class injectionAnnotation;
    private final boolean useNames;

    public AnnotatedMethodInjection(Class<? extends Annotation> cls, boolean z) {
        this.injectionAnnotation = cls;
        this.useNames = z;
    }

    public AnnotatedMethodInjection() {
        this(Inject.class, false);
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        return wrapLifeCycle(componentMonitor.newInjector(new AnnotatedMethodInjector(obj, cls, parameterArr, componentMonitor, this.injectionAnnotation, this.useNames)), lifecycleStrategy);
    }
}
