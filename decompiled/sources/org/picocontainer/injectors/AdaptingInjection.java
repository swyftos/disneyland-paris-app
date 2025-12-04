package org.picocontainer.injectors;

import java.lang.reflect.AccessibleObject;
import java.security.AccessController;
import java.security.PrivilegedAction;
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
public class AdaptingInjection extends AbstractInjectionFactory {
    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        ComponentAdapter<T> componentAdapterFieldAnnotatedInjectionAdapter = fieldAnnotatedInjectionAdapter(cls, componentMonitor, lifecycleStrategy, properties, obj, null, parameterArr);
        if (componentAdapterFieldAnnotatedInjectionAdapter != null) {
            return componentAdapterFieldAnnotatedInjectionAdapter;
        }
        ComponentAdapter<T> componentAdapterMethodAnnotatedInjectionAdapter = methodAnnotatedInjectionAdapter(cls, componentMonitor, lifecycleStrategy, properties, obj, componentAdapterFieldAnnotatedInjectionAdapter, parameterArr);
        if (componentAdapterMethodAnnotatedInjectionAdapter != null) {
            return componentAdapterMethodAnnotatedInjectionAdapter;
        }
        ComponentAdapter<T> componentAdapter = setterInjectionAdapter(properties, componentMonitor, lifecycleStrategy, obj, cls, componentAdapterMethodAnnotatedInjectionAdapter, parameterArr);
        if (componentAdapter != null) {
            return componentAdapter;
        }
        ComponentAdapter<T> componentAdapterMethodInjectionAdapter = methodInjectionAdapter(properties, componentMonitor, lifecycleStrategy, obj, cls, componentAdapter, parameterArr);
        return componentAdapterMethodInjectionAdapter != null ? componentAdapterMethodInjectionAdapter : defaultInjectionAdapter(properties, componentMonitor, lifecycleStrategy, obj, cls, parameterArr);
    }

    private ComponentAdapter defaultInjectionAdapter(Properties properties, ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Object obj, Class cls, Parameter... parameterArr) {
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.CDI);
        return new ConstructorInjection().createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
    }

    private ComponentAdapter setterInjectionAdapter(Properties properties, ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Object obj, Class cls, ComponentAdapter componentAdapter, Parameter... parameterArr) {
        return AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.SDI) ? new SetterInjection().createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr) : componentAdapter;
    }

    private ComponentAdapter methodInjectionAdapter(Properties properties, ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Object obj, Class cls, ComponentAdapter componentAdapter, Parameter... parameterArr) {
        return AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.METHOD_INJECTION) ? new MethodInjection().createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr) : componentAdapter;
    }

    private ComponentAdapter methodAnnotatedInjectionAdapter(Class cls, ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, ComponentAdapter componentAdapter, Parameter... parameterArr) {
        return injectionMethodAnnotated(cls) ? new AnnotatedMethodInjection().createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr) : componentAdapter;
    }

    private ComponentAdapter fieldAnnotatedInjectionAdapter(Class cls, ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, ComponentAdapter componentAdapter, Parameter... parameterArr) {
        return injectionFieldAnnotated(cls) ? new AnnotatedFieldInjection().createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr) : componentAdapter;
    }

    private boolean injectionMethodAnnotated(final Class cls) {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.injectors.AdaptingInjection.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return Boolean.valueOf(AdaptingInjection.this.injectionAnnotated(cls.getDeclaredMethods()));
            }
        })).booleanValue();
    }

    private boolean injectionFieldAnnotated(final Class cls) {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.injectors.AdaptingInjection.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                if (cls.isInterface()) {
                    return Boolean.FALSE;
                }
                for (Class superclass = cls; superclass != Object.class; superclass = superclass.getSuperclass()) {
                    if (AdaptingInjection.this.injectionAnnotated(superclass.getDeclaredFields())) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean injectionAnnotated(AccessibleObject[] accessibleObjectArr) {
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject.getAnnotation(Inject.class) != null) {
                return true;
            }
        }
        return false;
    }
}
