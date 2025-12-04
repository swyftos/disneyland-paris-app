package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.annotations.Bind;
import org.picocontainer.injectors.AbstractInjector;
import org.picocontainer.paranamer.AdaptiveParanamer;
import org.picocontainer.paranamer.AnnotationParanamer;
import org.picocontainer.paranamer.CachingParanamer;
import org.picocontainer.paranamer.Paranamer;

/* loaded from: classes6.dex */
public abstract class IterativeInjector<T> extends AbstractInjector<T> {
    private static final Object[] NONE = new Object[0];
    protected transient Annotation[] bindings;
    private volatile transient boolean initialized;
    protected transient List<AccessibleObject> injectionMembers;
    protected transient Type[] injectionTypes;
    private transient AbstractInjector.ThreadLocalCyclicDependencyGuard instantiationGuard;
    private transient Paranamer paranamer;

    protected String getName(Method method) {
        return null;
    }

    protected abstract Object injectIntoMember(AccessibleObject accessibleObject, Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException;

    protected boolean isInjectorMethod(Method method) {
        return false;
    }

    protected abstract Object memberInvocationReturn(Object obj, AccessibleObject accessibleObject, Object obj2);

    protected abstract void unsatisfiedDependencies(PicoContainer picoContainer, Set<Type> set, List<AccessibleObject> list);

    public IterativeInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
        super(obj, cls, parameterArr, componentMonitor, z);
    }

    protected Constructor getConstructor() {
        Object objDoPrivileged = AccessController.doPrivileged((PrivilegedAction<Object>) new PrivilegedAction() { // from class: org.picocontainer.injectors.IterativeInjector.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return IterativeInjector.this.getComponentImplementation().getConstructor(null);
                } catch (NoSuchMethodException e) {
                    return new PicoCompositionException(e);
                } catch (SecurityException e2) {
                    return new PicoCompositionException(e2);
                }
            }
        });
        if (objDoPrivileged instanceof Constructor) {
            return (Constructor) objDoPrivileged;
        }
        throw ((PicoCompositionException) objDoPrivileged);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Parameter[] getMatchingParameterListForSetters(PicoContainer picoContainer) {
        if (!this.initialized) {
            synchronized (this) {
                try {
                    if (!this.initialized) {
                        initializeInjectionMembersAndTypeLists();
                    }
                } finally {
                }
            }
        }
        ArrayList arrayList = new ArrayList(Collections.nCopies(this.injectionMembers.size(), null));
        Parameter[] parameterArrCreateDefaultParameters = this.parameters;
        if (parameterArrCreateDefaultParameters == null) {
            parameterArrCreateDefaultParameters = createDefaultParameters(this.injectionTypes.length);
        }
        Set setMatchParameters = matchParameters(picoContainer, arrayList, parameterArrCreateDefaultParameters);
        Set<Type> hashSet = new HashSet<>();
        List<AccessibleObject> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == null) {
                hashSet.add(this.injectionTypes[i]);
                arrayList2.add(this.injectionMembers.get(i));
            }
        }
        if (hashSet.size() > 0) {
            unsatisfiedDependencies(picoContainer, hashSet, arrayList2);
        } else if (setMatchParameters.size() > 0) {
            throw new PicoCompositionException("Following parameters do not match any of the injectionMembers for " + getComponentImplementation() + ": " + setMatchParameters.toString());
        }
        return (Parameter[]) arrayList.toArray(new Parameter[arrayList.size()]);
    }

    private Set matchParameters(PicoContainer picoContainer, List list, Parameter[] parameterArr) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < parameterArr.length; i++) {
            if (!matchParameter(picoContainer, list, parameterArr[i])) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        return hashSet;
    }

    private boolean matchParameter(PicoContainer picoContainer, List list, Parameter parameter) {
        for (int i = 0; i < this.injectionTypes.length; i++) {
            if (list.get(i) == null) {
                try {
                    if (parameter.resolve(picoContainer, this, null, this.injectionTypes[i], makeParameterNameImpl(this.injectionMembers.get(i)), useNames(), this.bindings[i]).isResolved()) {
                        list.set(i, parameter);
                        return true;
                    }
                } catch (AbstractInjector.AmbiguousComponentResolutionException e) {
                    e.setMember(this.injectionMembers.get(i));
                    throw e;
                }
            }
        }
        return false;
    }

    protected NameBinding makeParameterNameImpl(AccessibleObject accessibleObject) {
        if (this.paranamer == null) {
            this.paranamer = new CachingParanamer(new AnnotationParanamer(new AdaptiveParanamer()));
        }
        return new ParameterNameBinding(this.paranamer, accessibleObject, 0);
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public T getComponentInstance(final PicoContainer picoContainer, Type type) throws PicoCompositionException {
        final Constructor constructor = getConstructor();
        if (this.instantiationGuard == null) {
            this.instantiationGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.IterativeInjector.2
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) {
                    Parameter[] matchingParameterListForSetters = IterativeInjector.this.getMatchingParameterListForSetters(this.guardedContainer);
                    IterativeInjector iterativeInjector = IterativeInjector.this;
                    Object objMakeInstance = iterativeInjector.makeInstance(picoContainer, constructor, iterativeInjector.currentMonitor());
                    IterativeInjector iterativeInjector2 = IterativeInjector.this;
                    return iterativeInjector2.decorateComponentInstance(matchingParameterListForSetters, iterativeInjector2.currentMonitor(), objMakeInstance, picoContainer, this.guardedContainer);
                }
            };
        }
        this.instantiationGuard.setGuardedContainer(picoContainer);
        return (T) this.instantiationGuard.observe(getComponentImplementation(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.reflect.AccessibleObject] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.reflect.AccessibleObject] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public Object decorateComponentInstance(Parameter[] parameterArr, ComponentMonitor componentMonitor, Object obj, PicoContainer picoContainer, PicoContainer picoContainer2) {
        Object[] objArr = new Object[this.injectionMembers.size()];
        Object objInvoking = null;
        int i = 0;
        ?? r2 = 0;
        while (i < this.injectionMembers.size()) {
            try {
                AccessibleObject accessibleObject = this.injectionMembers.get(i);
                try {
                    Parameter parameter = parameterArr[i];
                    if (parameter != null) {
                        Object objResolveInstance = parameter.resolve(picoContainer2, this, null, this.injectionTypes[i], makeParameterNameImpl(this.injectionMembers.get(i)), useNames(), this.bindings[i]).resolveInstance();
                        objInvoking = componentMonitor.invoking(picoContainer, this, (Member) accessibleObject, obj, new Object[]{objResolveInstance});
                        if (objInvoking == ComponentMonitor.KEEP) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            Object objInjectIntoMember = injectIntoMember(accessibleObject, obj, objResolveInstance);
                            componentMonitor.invoked(picoContainer, this, (Member) accessibleObject, obj, System.currentTimeMillis() - jCurrentTimeMillis, new Object[]{objResolveInstance}, objInjectIntoMember);
                            objInvoking = objInjectIntoMember;
                        }
                        objArr[i] = objResolveInstance;
                    }
                    i++;
                    r2 = accessibleObject;
                } catch (IllegalAccessException e) {
                    e = e;
                    r2 = accessibleObject;
                    return caughtIllegalAccessException(componentMonitor, (Member) r2, obj, e);
                } catch (InvocationTargetException e2) {
                    e = e2;
                    r2 = accessibleObject;
                    return caughtInvocationTargetException(componentMonitor, (Member) r2, obj, e);
                }
            } catch (IllegalAccessException e3) {
                e = e3;
            } catch (InvocationTargetException e4) {
                e = e4;
            }
        }
        return memberInvocationReturn(objInvoking, r2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object makeInstance(PicoContainer picoContainer, Constructor constructor, ComponentMonitor componentMonitor) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Constructor<T> constructorInstantiating = componentMonitor.instantiating(picoContainer, this, constructor);
        try {
            Object objNewInstance = newInstance(constructorInstantiating, null);
            componentMonitor.instantiated(picoContainer, this, constructorInstantiating, objNewInstance, NONE, System.currentTimeMillis() - jCurrentTimeMillis);
            return objNewInstance;
        } catch (IllegalAccessException e) {
            return caughtIllegalAccessException(componentMonitor, constructor, e, picoContainer);
        } catch (InstantiationException e2) {
            return caughtInstantiationException(componentMonitor, constructor, e2, picoContainer);
        } catch (InvocationTargetException e3) {
            componentMonitor.instantiationFailed(picoContainer, this, constructorInstantiating, e3);
            if (e3.getTargetException() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getTargetException());
            }
            if (e3.getTargetException() instanceof Error) {
                throw ((Error) e3.getTargetException());
            }
            throw new PicoCompositionException(e3.getTargetException());
        }
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.Injector
    public Object decorateComponentInstance(final PicoContainer picoContainer, Type type, T t) {
        if (this.instantiationGuard == null) {
            this.instantiationGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.IterativeInjector.3
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) {
                    Parameter[] matchingParameterListForSetters = IterativeInjector.this.getMatchingParameterListForSetters(this.guardedContainer);
                    IterativeInjector iterativeInjector = IterativeInjector.this;
                    return iterativeInjector.decorateComponentInstance(matchingParameterListForSetters, iterativeInjector.currentMonitor(), obj, picoContainer, this.guardedContainer);
                }
            };
        }
        this.instantiationGuard.setGuardedContainer(picoContainer);
        return this.instantiationGuard.observe(getComponentImplementation(), t);
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public void verify(final PicoContainer picoContainer) throws PicoCompositionException {
        if (this.verifyingGuard == null) {
            this.verifyingGuard = new AbstractInjector.ThreadLocalCyclicDependencyGuard() { // from class: org.picocontainer.injectors.IterativeInjector.4
                @Override // org.picocontainer.injectors.AbstractInjector.ThreadLocalCyclicDependencyGuard
                public Object run(Object obj) {
                    Parameter[] matchingParameterListForSetters = IterativeInjector.this.getMatchingParameterListForSetters(this.guardedContainer);
                    for (int i = 0; i < matchingParameterListForSetters.length; i++) {
                        Parameter parameter = matchingParameterListForSetters[i];
                        PicoContainer picoContainer2 = picoContainer;
                        IterativeInjector iterativeInjector = IterativeInjector.this;
                        parameter.verify(picoContainer2, iterativeInjector, iterativeInjector.injectionTypes[i], iterativeInjector.makeParameterNameImpl(iterativeInjector.injectionMembers.get(i)), IterativeInjector.this.useNames(), IterativeInjector.this.bindings[i]);
                    }
                    return null;
                }
            };
        }
        this.verifyingGuard.setGuardedContainer(picoContainer);
        this.verifyingGuard.observe(getComponentImplementation(), null);
    }

    protected void initializeInjectionMembersAndTypeLists() {
        this.injectionMembers = new ArrayList();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Method method : getMethods()) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            fixGenericParameterTypes(method, genericParameterTypes);
            String strCrudeMethodSignature = crudeMethodSignature(method);
            if (genericParameterTypes.length == 1 && isInjectorMethod(method) && !hashSet.contains(strCrudeMethodSignature)) {
                this.injectionMembers.add(method);
                hashSet.add(strCrudeMethodSignature);
                arrayList2.add(getName(method));
                arrayList3.add(box(genericParameterTypes[0]));
                arrayList.add(getBindings(method, 0));
            }
        }
        this.injectionTypes = (Type[]) arrayList3.toArray(new Type[0]);
        this.bindings = (Annotation[]) arrayList.toArray(new Annotation[0]);
        this.initialized = true;
    }

    public static String crudeMethodSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getReturnType().getName());
        sb.append(method.getName());
        for (Class<?> cls : method.getParameterTypes()) {
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    private void fixGenericParameterTypes(Method method, Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            if (typeArr[i] instanceof TypeVariable) {
                typeArr[i] = method.getParameterTypes()[i];
            }
        }
    }

    private Annotation getBindings(Method method, int i) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations.length >= i + 1) {
            Annotation[] annotationArr = parameterAnnotations[i];
            for (Annotation annotation : annotationArr) {
                if (annotation.annotationType().getAnnotation(Bind.class) != null) {
                    return annotation;
                }
            }
        }
        return null;
    }

    private Method[] getMethods() {
        return (Method[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.injectors.IterativeInjector.5
            @Override // java.security.PrivilegedAction
            public Object run() {
                return IterativeInjector.this.getComponentImplementation().getMethods();
            }
        });
    }
}
