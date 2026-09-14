package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Emjection;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.monitors.NullComponentMonitor;

/* JADX INFO: loaded from: classes5.dex */
public class ConstructorInjector<T> extends SingleMemberInjector<T> {
    private boolean allowNonPublicClasses;
    private transient CtorAndAdapters chosenConstructor;
    private boolean enableEmjection;
    private transient AbstractInjector.ThreadLocalCyclicDependencyGuard instantiationGuard;
    private boolean rememberChosenConstructor;
    private transient List sortedMatchingConstructors;

    public ConstructorInjector(Object obj, Class<?> cls, Parameter... parameterArr) {
        this(obj, cls, parameterArr, new NullComponentMonitor(), false);
    }

    public ConstructorInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
        super(obj, cls, parameterArr, componentMonitor, z);
        this.rememberChosenConstructor = true;
        this.enableEmjection = false;
        this.allowNonPublicClasses = false;
    }

    public ConstructorInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z, boolean z2) throws AbstractInjector.NotConcreteRegistrationException {
        super(obj, cls, parameterArr, componentMonitor, z);
        this.enableEmjection = false;
        this.allowNonPublicClasses = false;
        this.rememberChosenConstructor = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CtorAndAdapters getGreediestSatisfiableConstructor(PicoContainer picoContainer, Class cls) {
        ConstructorInjector<T>.CtorAndAdapters<T> greediestSatisfiableConstructor = this.chosenConstructor == null ? getGreediestSatisfiableConstructor(picoContainer) : null;
        if (!this.rememberChosenConstructor) {
            return greediestSatisfiableConstructor;
        }
        CtorAndAdapters ctorAndAdapters = this.chosenConstructor;
        if (ctorAndAdapters != null) {
            return ctorAndAdapters;
        }
        this.chosenConstructor = greediestSatisfiableConstructor;
        return greediestSatisfiableConstructor;
    }

    protected ConstructorInjector<T>.CtorAndAdapters<T> getGreediestSatisfiableConstructor(PicoContainer picoContainer) throws PicoCompositionException {
        Constructor constructor;
        Constructor constructor2;
        Parameter[] parameterArr;
        Type type;
        Type[] typeArr;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap map = new HashMap();
        if (this.sortedMatchingConstructors == null) {
            this.sortedMatchingConstructors = getSortedMatchingConstructors();
        }
        Iterator it = this.sortedMatchingConstructors.iterator();
        int length = -1;
        Type type2 = null;
        Constructor constructor3 = null;
        ComponentAdapter[] componentAdapterArr = null;
        Parameter[] parameterArr2 = null;
        Constructor constructor4 = null;
        while (it.hasNext()) {
            Constructor constructor5 = (Constructor) it.next();
            try {
                Type[] genericParameterTypes = constructor5.getGenericParameterTypes();
                fixGenericParameterTypes(constructor5, genericParameterTypes);
                Annotation[] bindings = getBindings(constructor5.getParameterAnnotations());
                Parameter[] parameterArrCreateDefaultParameters = this.parameters;
                if (parameterArrCreateDefaultParameters == null) {
                    parameterArrCreateDefaultParameters = createDefaultParameters(genericParameterTypes.length);
                }
                ComponentAdapter[] componentAdapterArr2 = new ComponentAdapter[parameterArrCreateDefaultParameters.length];
                Type typeBox = type2;
                Constructor constructor6 = constructor3;
                int i = 0;
                boolean z = false;
                while (i < parameterArrCreateDefaultParameters.length) {
                    try {
                        Type typeBox2 = box(genericParameterTypes[i]);
                        ComponentAdapter[] componentAdapterArr3 = componentAdapterArr2;
                        ParameterNameBinding parameterNameBinding = new ParameterNameBinding(getParanamer(), constructor5, i);
                        ResolverKey resolverKey = new ResolverKey(typeBox2, useNames() ? parameterNameBinding.getName() : null, useNames(), bindings[i], parameterArrCreateDefaultParameters[i]);
                        Parameter.Resolver resolver = (Parameter.Resolver) map.get(resolverKey);
                        if (resolver == null) {
                            type = typeBox2;
                            constructor2 = constructor5;
                            try {
                                Parameter.Resolver resolverResolve = parameterArrCreateDefaultParameters[i].resolve(picoContainer, this, null, type, parameterNameBinding, useNames(), bindings[i]);
                                map.put(resolverKey, resolverResolve);
                                resolver = resolverResolve;
                            } catch (AbstractInjector.AmbiguousComponentResolutionException e) {
                                e = e;
                                constructor = constructor2;
                                e.setMember(constructor);
                                throw e;
                            }
                        } else {
                            type = typeBox2;
                            constructor2 = constructor5;
                        }
                        if (resolver.isResolved()) {
                            componentAdapterArr3[i] = resolver.getComponentAdapter();
                            typeArr = genericParameterTypes;
                        } else {
                            hashSet2.add(type);
                            typeArr = genericParameterTypes;
                            typeBox = box(typeArr[i]);
                            z = true;
                            constructor6 = constructor2;
                        }
                        i++;
                        genericParameterTypes = typeArr;
                        componentAdapterArr = componentAdapterArr;
                        parameterArrCreateDefaultParameters = parameterArrCreateDefaultParameters;
                        componentAdapterArr2 = componentAdapterArr3;
                        it = it;
                        constructor5 = constructor2;
                        parameterArr2 = parameterArr2;
                    } catch (AbstractInjector.AmbiguousComponentResolutionException e2) {
                        e = e2;
                        constructor2 = constructor5;
                        constructor = constructor2;
                        e.setMember(constructor);
                        throw e;
                    }
                }
                Parameter[] parameterArr3 = parameterArrCreateDefaultParameters;
                ComponentAdapter[] componentAdapterArr4 = componentAdapterArr2;
                Type[] typeArr2 = genericParameterTypes;
                constructor2 = constructor5;
                ComponentAdapter[] componentAdapterArr5 = componentAdapterArr;
                Parameter[] parameterArr4 = parameterArr2;
                Iterator it2 = it;
                if (constructor4 != null && typeArr2.length != length) {
                    if (hashSet.isEmpty()) {
                        return new CtorAndAdapters<>(constructor4, parameterArr4, componentAdapterArr5);
                    }
                    constructor = constructor2;
                    parameterArr = parameterArr4;
                    try {
                        hashSet.add(constructor);
                    } catch (AbstractInjector.AmbiguousComponentResolutionException e3) {
                        e = e3;
                        e.setMember(constructor);
                        throw e;
                    }
                } else {
                    parameterArr = parameterArr4;
                    if (z || length != typeArr2.length) {
                        if (!z) {
                            length = typeArr2.length;
                            constructor4 = constructor2;
                            parameterArr2 = parameterArr3;
                            componentAdapterArr = componentAdapterArr4;
                        }
                        type2 = typeBox;
                        constructor3 = constructor6;
                        it = it2;
                    } else {
                        hashSet.add(constructor2);
                        hashSet.add(constructor4);
                    }
                }
                parameterArr2 = parameterArr;
                componentAdapterArr = componentAdapterArr5;
                type2 = typeBox;
                constructor3 = constructor6;
                it = it2;
            } catch (AbstractInjector.AmbiguousComponentResolutionException e4) {
                e = e4;
                constructor = constructor5;
            }
        }
        ComponentAdapter[] componentAdapterArr6 = componentAdapterArr;
        Parameter[] parameterArr5 = parameterArr2;
        if (!hashSet.isEmpty()) {
            throw new PicoCompositionException(hashSet.size() + " satisfiable constructors is too many for '" + getComponentImplementation() + "'. Constructor List:" + hashSet.toString().replace(getComponentImplementation().getName(), "<init>").replace("public <i", "<i"));
        }
        if (constructor4 == null && !hashSet2.isEmpty()) {
            throw new AbstractInjector.UnsatisfiableDependenciesException(getComponentImplementation().getName() + " has unsatisfied dependency '" + type2 + "' for constructor '" + constructor3 + "' from " + picoContainer);
        }
        if (constructor4 == null) {
            HashSet hashSet3 = new HashSet();
            for (Constructor constructor7 : getConstructors()) {
                hashSet3.add(constructor7);
            }
            throw new PicoCompositionException("Either the specified parameters do not match any of the following constructors: " + hashSet3.toString() + "; OR the constructors were not accessible for '" + getComponentImplementation().getName() + "'");
        }
        return new CtorAndAdapters<>(constructor4, parameterArr5, componentAdapterArr6);
    }

    public void enableEmjection(boolean z) {
        this.enableEmjection = z;
    }

    public ConstructorInjector<T> withNonPublicConstructors() {
        this.allowNonPublicClasses = true;
        return this;
    }

    private static final class ResolverKey {
        private final Annotation binding;
        private final Parameter currentParameter;
        private final Type expectedType;
        private final String pName;
        private final boolean useNames;

        private ResolverKey(Type type, String str, boolean z, Annotation annotation, Parameter parameter) {
            this.expectedType = type;
            this.pName = str;
            this.useNames = z;
            this.binding = annotation;
            this.currentParameter = parameter;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ResolverKey.class != obj.getClass()) {
                return false;
            }
            ResolverKey resolverKey = (ResolverKey) obj;
            if (this.useNames != resolverKey.useNames) {
                return false;
            }
            Annotation annotation = this.binding;
            if (annotation == null ? resolverKey.binding != null : !annotation.equals(resolverKey.binding)) {
                return false;
            }
            if (!this.currentParameter.equals(resolverKey.currentParameter) || !this.expectedType.equals(resolverKey.expectedType)) {
                return false;
            }
            String str = this.pName;
            return str == null ? resolverKey.pName == null : str.equals(resolverKey.pName);
        }

        public int hashCode() {
            int iHashCode = this.expectedType.hashCode() * 31;
            String str = this.pName;
            int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + (this.useNames ? 1 : 0)) * 31;
            Annotation annotation = this.binding;
            return ((iHashCode2 + (annotation != null ? annotation.hashCode() : 0)) * 31) + this.currentParameter.hashCode();
        }
    }

    private void fixGenericParameterTypes(Constructor constructor, Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            if (typeArr[i] instanceof TypeVariable) {
                typeArr[i] = constructor.getParameterTypes()[i];
            }
        }
    }

    protected class CtorAndAdapters<TYPE> {
        private final Parameter[] constructorParameters;
        private final Constructor ctor;
        private final ComponentAdapter[] injecteeAdapters;

        public CtorAndAdapters(Constructor<TYPE> constructor, Parameter[] parameterArr, ComponentAdapter[] componentAdapterArr) {
            this.ctor = constructor;
            this.constructorParameters = parameterArr;
            this.injecteeAdapters = componentAdapterArr;
        }

        public Constructor<TYPE> getConstructor() {
            return this.ctor;
        }

        public Object[] getParameterArguments(PicoContainer picoContainer) {
            Type[] genericParameterTypes = this.ctor.getGenericParameterTypes();
            int i = 0;
            for (int i2 = 0; i2 < genericParameterTypes.length; i2++) {
                if (genericParameterTypes[i2] instanceof TypeVariable) {
                    genericParameterTypes[i2] = this.ctor.getParameterTypes()[i2];
                }
            }
            ConstructorInjector.this.boxParameters(genericParameterTypes);
            Object[] objArr = new Object[this.constructorParameters.length];
            Annotation[] bindings = ConstructorInjector.this.getBindings(this.ctor.getParameterAnnotations());
            while (true) {
                Parameter[] parameterArr = this.constructorParameters;
                if (i >= parameterArr.length) {
                    return objArr;
                }
                objArr[i] = ConstructorInjector.this.getParameter(picoContainer, this.ctor, i, genericParameterTypes[i], bindings[i], parameterArr[i], this.injecteeAdapters[i]);
                i++;
            }
        }

        public ComponentAdapter[] getInjecteeAdapters() {
            return this.injecteeAdapters;
        }

        public Parameter[] getParameters() {
            return this.constructorParameters;
        }
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public T getComponentInstance(final PicoContainer picoContainer, Type type) throws PicoCompositionException {
        if (this.instantiationGuard == null) {
            this.instantiationGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.ConstructorInjector.1
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) {
                    InvocationTargetException e;
                    Constructor<T> constructorInstantiating;
                    InstantiationException e2;
                    IllegalAccessException e3;
                    ConstructorInjector constructorInjector = ConstructorInjector.this;
                    CtorAndAdapters greediestSatisfiableConstructor = constructorInjector.getGreediestSatisfiableConstructor(this.guardedContainer, constructorInjector.getComponentImplementation());
                    ComponentMonitor componentMonitorCurrentMonitor = ConstructorInjector.this.currentMonitor();
                    Constructor<T> constructor = greediestSatisfiableConstructor.getConstructor();
                    try {
                        Object[] parameterArguments = greediestSatisfiableConstructor.getParameterArguments(this.guardedContainer);
                        constructorInstantiating = componentMonitorCurrentMonitor.instantiating(picoContainer, ConstructorInjector.this, constructor);
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            T tNewInstance = ConstructorInjector.this.newInstance(constructorInstantiating, parameterArguments);
                            componentMonitorCurrentMonitor.instantiated(picoContainer, ConstructorInjector.this, constructorInstantiating, tNewInstance, parameterArguments, System.currentTimeMillis() - jCurrentTimeMillis);
                            return tNewInstance;
                        } catch (IllegalAccessException e4) {
                            e3 = e4;
                            return ConstructorInjector.this.caughtIllegalAccessException(componentMonitorCurrentMonitor, constructorInstantiating, e3, picoContainer);
                        } catch (InstantiationException e5) {
                            e2 = e5;
                            return ConstructorInjector.this.caughtInstantiationException(componentMonitorCurrentMonitor, constructorInstantiating, e2, picoContainer);
                        } catch (InvocationTargetException e6) {
                            e = e6;
                            componentMonitorCurrentMonitor.instantiationFailed(picoContainer, ConstructorInjector.this, constructorInstantiating, e);
                            if (e.getTargetException() instanceof RuntimeException) {
                                throw ((RuntimeException) e.getTargetException());
                            }
                            if (e.getTargetException() instanceof Error) {
                                throw ((Error) e.getTargetException());
                            }
                            throw new PicoCompositionException(e.getTargetException());
                        }
                    } catch (IllegalAccessException e7) {
                        e3 = e7;
                        constructorInstantiating = constructor;
                    } catch (InstantiationException e8) {
                        e2 = e8;
                        constructorInstantiating = constructor;
                    } catch (InvocationTargetException e9) {
                        e = e9;
                        constructorInstantiating = constructor;
                    }
                }
            };
        }
        this.instantiationGuard.setGuardedContainer(picoContainer);
        T t = (T) this.instantiationGuard.observe(getComponentImplementation(), null);
        decorate(t, picoContainer);
        return t;
    }

    private void decorate(Object obj, PicoContainer picoContainer) {
        if (this.enableEmjection) {
            Emjection.setupEmjection(obj, picoContainer);
        }
    }

    private List getSortedMatchingConstructors() {
        ArrayList arrayList = new ArrayList();
        for (Constructor constructor : getConstructors()) {
            int modifiers = constructor.getModifiers();
            if ((this.parameters == null || constructor.getParameterTypes().length == this.parameters.length) && (this.allowNonPublicClasses || (modifiers & 1) != 0)) {
                if ((modifiers & 1) == 0) {
                    constructor.setAccessible(true);
                }
                arrayList.add(constructor);
            }
        }
        if (this.parameters == null) {
            Collections.sort(arrayList, new Comparator() { // from class: org.picocontainer.injectors.ConstructorInjector.2
                @Override // java.util.Comparator
                public int compare(Constructor constructor2, Constructor constructor3) {
                    return constructor3.getParameterTypes().length - constructor2.getParameterTypes().length;
                }
            });
        }
        return arrayList;
    }

    private Constructor[] getConstructors() {
        return (Constructor[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.injectors.ConstructorInjector.3
            @Override // java.security.PrivilegedAction
            public Constructor[] run() {
                return ConstructorInjector.this.getComponentImplementation().getDeclaredConstructors();
            }
        });
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public void verify(final PicoContainer picoContainer) throws PicoCompositionException {
        if (this.verifyingGuard == null) {
            this.verifyingGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.ConstructorInjector.4
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) {
                    Constructor<T> constructor = ConstructorInjector.this.getGreediestSatisfiableConstructor(this.guardedContainer).getConstructor();
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    ConstructorInjector constructorInjector = ConstructorInjector.this;
                    Parameter[] parameterArrCreateDefaultParameters = constructorInjector.parameters;
                    if (parameterArrCreateDefaultParameters == null) {
                        parameterArrCreateDefaultParameters = constructorInjector.createDefaultParameters(parameterTypes.length);
                    }
                    for (int i = 0; i < parameterArrCreateDefaultParameters.length; i++) {
                        Parameter parameter = parameterArrCreateDefaultParameters[i];
                        PicoContainer picoContainer2 = picoContainer;
                        ConstructorInjector constructorInjector2 = ConstructorInjector.this;
                        parameter.verify(picoContainer2, constructorInjector2, constructorInjector2.box(parameterTypes[i]), new ParameterNameBinding(ConstructorInjector.this.getParanamer(), constructor, i), ConstructorInjector.this.useNames(), ConstructorInjector.this.getBindings(constructor.getParameterAnnotations())[i]);
                    }
                    return null;
                }
            };
        }
        this.verifyingGuard.setGuardedContainer(picoContainer);
        this.verifyingGuard.observe(getComponentImplementation(), null);
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "ConstructorInjector-";
    }
}
