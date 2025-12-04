package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.annotations.Nullable;
import org.picocontainer.injectors.AbstractInjector;

/* loaded from: classes6.dex */
public abstract class MethodInjector<T> extends SingleMemberInjector<T> {
    private transient AbstractInjector.ThreadLocalCyclicDependencyGuard instantiationGuard;
    private final String methodName;

    protected abstract Method getInjectorMethod();

    public MethodInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
        super(obj, cls, parameterArr, componentMonitor, z);
        this.methodName = str;
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public T getComponentInstance(final PicoContainer picoContainer, Type type) throws PicoCompositionException {
        if (this.instantiationGuard == null) {
            this.instantiationGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.MethodInjector.1
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                    Object[] objArr;
                    Method injectorMethod = MethodInjector.this.getInjectorMethod();
                    ComponentMonitor componentMonitorCurrentMonitor = MethodInjector.this.currentMonitor();
                    T t = null;
                    try {
                        try {
                            componentMonitorCurrentMonitor.instantiating(picoContainer, MethodInjector.this, null);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            T tNewInstance = MethodInjector.this.getComponentImplementation().newInstance();
                            if (injectorMethod != null) {
                                try {
                                    Object[] memberArguments = MethodInjector.this.getMemberArguments(this.guardedContainer, injectorMethod);
                                    MethodInjector.this.invokeMethod(injectorMethod, memberArguments, tNewInstance, picoContainer);
                                    objArr = memberArguments;
                                } catch (IllegalAccessException e) {
                                    e = e;
                                    t = tNewInstance;
                                    return MethodInjector.this.caughtIllegalAccessException(componentMonitorCurrentMonitor, injectorMethod, t, e);
                                }
                            } else {
                                objArr = null;
                            }
                            componentMonitorCurrentMonitor.instantiated(picoContainer, MethodInjector.this, null, tNewInstance, objArr, System.currentTimeMillis() - jCurrentTimeMillis);
                            return tNewInstance;
                        } catch (InstantiationException e2) {
                            return MethodInjector.this.caughtInstantiationException(componentMonitorCurrentMonitor, null, e2, picoContainer);
                        }
                    } catch (IllegalAccessException e3) {
                        e = e3;
                    }
                }
            };
        }
        this.instantiationGuard.setGuardedContainer(picoContainer);
        return (T) this.instantiationGuard.observe(getComponentImplementation(), null);
    }

    protected Object[] getMemberArguments(PicoContainer picoContainer, Method method) {
        return super.getMemberArguments(picoContainer, method, method.getParameterTypes(), getBindings(method.getParameterAnnotations()));
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.Injector
    public Object decorateComponentInstance(final PicoContainer picoContainer, Type type, T t) {
        if (this.instantiationGuard == null) {
            this.instantiationGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.MethodInjector.2
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) {
                    Method injectorMethod = MethodInjector.this.getInjectorMethod();
                    if (injectorMethod == null || !injectorMethod.getDeclaringClass().isAssignableFrom(obj.getClass())) {
                        return null;
                    }
                    return MethodInjector.this.invokeMethod(injectorMethod, MethodInjector.this.getMemberArguments(this.guardedContainer, injectorMethod), obj, picoContainer);
                }
            };
        }
        this.instantiationGuard.setGuardedContainer(picoContainer);
        return this.instantiationGuard.observe(getComponentImplementation(), t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object invokeMethod(Method method, Object[] objArr, Object obj, PicoContainer picoContainer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoking = currentMonitor().invoking(picoContainer, this, method, obj, objArr);
            if (objInvoking != ComponentMonitor.KEEP) {
                return objInvoking;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object objInvoke = method.invoke(obj, objArr);
            currentMonitor().invoked(picoContainer, this, method, obj, System.currentTimeMillis() - jCurrentTimeMillis, objArr, objInvoke);
            return objInvoke;
        } catch (IllegalAccessException e) {
            return caughtIllegalAccessException(currentMonitor(), method, obj, e);
        } catch (InvocationTargetException e2) {
            currentMonitor().invocationFailed(method, obj, e2);
            if (e2.getTargetException() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getTargetException());
            }
            if (e2.getTargetException() instanceof Error) {
                throw ((Error) e2.getTargetException());
            }
            throw new PicoCompositionException(e2);
        }
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public void verify(final PicoContainer picoContainer) throws PicoCompositionException {
        if (this.verifyingGuard == null) {
            this.verifyingGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.MethodInjector.3
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) {
                    Method injectorMethod = MethodInjector.this.getInjectorMethod();
                    Class<?>[] parameterTypes = injectorMethod.getParameterTypes();
                    MethodInjector methodInjector = MethodInjector.this;
                    Parameter[] parameterArrCreateDefaultParameters = methodInjector.parameters;
                    if (parameterArrCreateDefaultParameters == null) {
                        parameterArrCreateDefaultParameters = methodInjector.createDefaultParameters(parameterTypes.length);
                    }
                    for (int i = 0; i < parameterArrCreateDefaultParameters.length; i++) {
                        Parameter parameter = parameterArrCreateDefaultParameters[i];
                        PicoContainer picoContainer2 = picoContainer;
                        MethodInjector methodInjector2 = MethodInjector.this;
                        parameter.verify(picoContainer2, methodInjector2, parameterTypes[i], new ParameterNameBinding(methodInjector2.getParanamer(), injectorMethod, i), MethodInjector.this.useNames(), MethodInjector.this.getBindings(injectorMethod.getParameterAnnotations())[i]);
                    }
                    return null;
                }
            };
        }
        this.verifyingGuard.setGuardedContainer(picoContainer);
        this.verifyingGuard.observe(getComponentImplementation(), null);
    }

    @Override // org.picocontainer.injectors.SingleMemberInjector
    protected boolean isNullParamAllowed(AccessibleObject accessibleObject, int i) {
        for (Annotation annotation : ((Method) accessibleObject).getParameterAnnotations()[i]) {
            if (annotation instanceof Nullable) {
                return true;
            }
        }
        return false;
    }

    public static class ByReflectionMethod extends MethodInjector {
        private final Method injectionMethod;

        public ByReflectionMethod(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, Method method, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
            super(obj, cls, parameterArr, componentMonitor, null, z);
            this.injectionMethod = method;
        }

        @Override // org.picocontainer.injectors.MethodInjector
        protected Method getInjectorMethod() {
            return this.injectionMethod;
        }

        @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
        public String getDescriptor() {
            return "MethodInjector.ByReflectionMethod[" + this.injectionMethod + "]-";
        }
    }

    public static class ByMethodName extends MethodInjector {
        private Set injectionMethodNames;

        public ByMethodName(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, Set<String> set, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
            super(obj, cls, parameterArr, componentMonitor, null, z);
            this.injectionMethodNames = set;
        }

        @Override // org.picocontainer.injectors.MethodInjector
        protected Method getInjectorMethod() throws SecurityException {
            for (Method method : super.getComponentImplementation().getMethods()) {
                if (this.injectionMethodNames.contains(method.getName())) {
                    return method;
                }
            }
            return null;
        }

        @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
        public String getDescriptor() {
            return "MethodInjector.ByMethodName" + this.injectionMethodNames + "-";
        }
    }
}
