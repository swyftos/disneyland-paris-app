package org.picocontainer.injectors;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.behaviors.AbstractBehaviorFactory;
import org.picocontainer.injectors.MethodInjector;

/* loaded from: classes6.dex */
public class MethodInjection extends AbstractInjectionFactory {
    private final AbstractInjectionFactory delegate;

    public MethodInjection(String str) {
        this.delegate = new MethodInjectionByName(str);
    }

    public MethodInjection(String... strArr) {
        this.delegate = new MethodInjectionByName(strArr);
    }

    public MethodInjection() {
        this("inject");
    }

    public MethodInjection(Method method) {
        this.delegate = new MethodInjectionByReflectionMethod(method);
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        return this.delegate.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
    }

    public class MethodInjectionByName extends AbstractInjectionFactory {
        private final Set injectionMethodNames;

        public MethodInjectionByName(String... strArr) {
            this.injectionMethodNames = new HashSet();
            for (String str : strArr) {
                this.injectionMethodNames.add(str);
            }
        }

        public MethodInjectionByName(String str) {
            HashSet hashSet = new HashSet();
            this.injectionMethodNames = hashSet;
            hashSet.add(str);
        }

        @Override // org.picocontainer.ComponentFactory
        public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
            return wrapLifeCycle(new MethodInjector.ByMethodName(obj, cls, parameterArr, componentMonitor, this.injectionMethodNames, AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true)), lifecycleStrategy);
        }
    }

    public class MethodInjectionByReflectionMethod extends AbstractInjectionFactory {
        private final Method injectionMethod;

        public MethodInjectionByReflectionMethod(Method method) {
            this.injectionMethod = method;
        }

        @Override // org.picocontainer.ComponentFactory
        public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
            boolean zArePropertiesPresent = AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true);
            if (this.injectionMethod.getDeclaringClass().isAssignableFrom(cls)) {
                return wrapLifeCycle(componentMonitor.newInjector(new MethodInjector.ByReflectionMethod(obj, cls, parameterArr, componentMonitor, this.injectionMethod, zArePropertiesPresent)), lifecycleStrategy);
            }
            throw new PicoCompositionException("method [" + this.injectionMethod + "] not on impl " + cls.getName());
        }
    }
}
