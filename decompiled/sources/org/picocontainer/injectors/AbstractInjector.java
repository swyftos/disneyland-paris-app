package org.picocontainer.injectors;

import androidx.camera.core.CameraInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.adapters.AbstractAdapter;
import org.picocontainer.parameters.ComponentParameter;

/* loaded from: classes6.dex */
public abstract class AbstractInjector<T> extends AbstractAdapter<T> implements org.picocontainer.Injector<T> {
    protected transient Parameter[] parameters;
    private final boolean useNames;
    protected transient ThreadLocalCyclicDependencyGuard verifyingGuard;

    @Override // org.picocontainer.Injector
    public Object decorateComponentInstance(PicoContainer picoContainer, Type type, T t) {
        return null;
    }

    @Override // org.picocontainer.ComponentAdapter
    public abstract T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException;

    @Override // org.picocontainer.ComponentAdapter
    public void verify(PicoContainer picoContainer) throws PicoCompositionException {
    }

    protected AbstractInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z) {
        super(obj, cls, componentMonitor);
        this.useNames = z;
        checkConcrete();
        if (parameterArr != null) {
            for (int i = 0; i < parameterArr.length; i++) {
                if (parameterArr[i] == null) {
                    throw new NullPointerException("Parameter " + i + " is null");
                }
            }
        }
        this.parameters = parameterArr;
    }

    public boolean useNames() {
        return this.useNames;
    }

    private void checkConcrete() {
        boolean z = (getComponentImplementation().getModifiers() & 1024) == 1024;
        if (getComponentImplementation().isInterface() || z) {
            throw new NotConcreteRegistrationException(getComponentImplementation());
        }
    }

    protected Parameter[] createDefaultParameters(int i) {
        Parameter[] parameterArr = new Parameter[i];
        for (int i2 = 0; i2 < i; i2++) {
            parameterArr[i2] = ComponentParameter.DEFAULT;
        }
        return parameterArr;
    }

    @Override // org.picocontainer.adapters.AbstractAdapter, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer) throws PicoCompositionException {
        return getComponentInstance(picoContainer, ComponentAdapter.NOTHING.class);
    }

    @Override // org.picocontainer.adapters.AbstractAdapter, org.picocontainer.ComponentAdapter
    public void accept(PicoVisitor picoVisitor) {
        super.accept(picoVisitor);
        Parameter[] parameterArr = this.parameters;
        if (parameterArr != null) {
            for (Parameter parameter : parameterArr) {
                parameter.accept(picoVisitor);
            }
        }
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Asbtract Injector";
    }

    protected T newInstance(Constructor<T> constructor, Object[] objArr) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return constructor.newInstance(objArr);
    }

    protected T caughtInstantiationException(ComponentMonitor componentMonitor, Constructor<T> constructor, InstantiationException instantiationException, PicoContainer picoContainer) {
        componentMonitor.instantiationFailed(picoContainer, this, constructor, instantiationException);
        throw new PicoCompositionException("Should never get here");
    }

    protected T caughtIllegalAccessException(ComponentMonitor componentMonitor, Constructor<T> constructor, IllegalAccessException illegalAccessException, PicoContainer picoContainer) {
        componentMonitor.instantiationFailed(picoContainer, this, constructor, illegalAccessException);
        throw new PicoCompositionException(illegalAccessException);
    }

    protected T caughtInvocationTargetException(ComponentMonitor componentMonitor, Member member, Object obj, InvocationTargetException invocationTargetException) {
        componentMonitor.invocationFailed(member, obj, invocationTargetException);
        if (invocationTargetException.getTargetException() instanceof RuntimeException) {
            throw ((RuntimeException) invocationTargetException.getTargetException());
        }
        if (invocationTargetException.getTargetException() instanceof Error) {
            throw ((Error) invocationTargetException.getTargetException());
        }
        throw new PicoCompositionException(invocationTargetException.getTargetException());
    }

    protected Object caughtIllegalAccessException(ComponentMonitor componentMonitor, Member member, Object obj, IllegalAccessException illegalAccessException) {
        componentMonitor.invocationFailed(member, obj, illegalAccessException);
        throw new PicoCompositionException(illegalAccessException);
    }

    protected Type box(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isPrimitive()) {
                String name = cls.getName();
                if (name == "int") {
                    return Integer.class;
                }
                if (name == "boolean") {
                    return Boolean.class;
                }
                if (name == LongTypedProperty.TYPE) {
                    return Long.class;
                }
                if (name == TypedValues.Custom.S_FLOAT) {
                    return Float.class;
                }
                if (name == DoubleTypedProperty.TYPE) {
                    return Double.class;
                }
                if (name == "char") {
                    return Character.class;
                }
                if (name == "byte") {
                    return Byte.class;
                }
                if (name == "short") {
                    return Short.class;
                }
            }
        }
        return type;
    }

    static abstract class ThreadLocalCyclicDependencyGuard extends ThreadLocal {
        protected PicoContainer guardedContainer;

        public abstract Object run(Object obj);

        ThreadLocalCyclicDependencyGuard() {
        }

        public final Object observe(Class cls, Object obj) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(get())) {
                throw new CyclicDependencyException(cls);
            }
            try {
                try {
                    set(bool);
                    return run(obj);
                } catch (CyclicDependencyException e) {
                    e.push(cls);
                    throw e;
                }
            } finally {
                set(null);
            }
        }

        public void setGuardedContainer(PicoContainer picoContainer) {
            this.guardedContainer = picoContainer;
        }
    }

    public static class CyclicDependencyException extends PicoCompositionException {
        private final List stack;

        public CyclicDependencyException(Class<?> cls) {
            super((Throwable) null);
            this.stack = new LinkedList();
            push(cls);
        }

        public void push(Class<?> cls) {
            this.stack.add(cls);
        }

        public Class[] getDependencies() {
            List list = this.stack;
            return (Class[]) list.toArray(new Class[list.size()]);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Cyclic dependency: " + this.stack.toString();
        }
    }

    public static final class AmbiguousComponentResolutionException extends PicoCompositionException {
        private AccessibleObject accessibleObject;
        private final String[] ambiguousComponentKeys;
        private final Class ambiguousDependency;
        private String component;

        public AmbiguousComponentResolutionException(Class<?> cls, String[] strArr) {
            super("");
            this.ambiguousDependency = cls;
            this.ambiguousComponentKeys = strArr;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer();
            String str = this.component;
            if (str == null) {
                str = "<no-component>";
            }
            stringBuffer.append(str);
            stringBuffer.append(" needs a '");
            stringBuffer.append(this.ambiguousDependency.getName());
            stringBuffer.append("' injected via '");
            Object obj = this.accessibleObject;
            if (obj == null) {
                obj = CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
            }
            stringBuffer.append(obj);
            stringBuffer.append("', but there are too many choices to inject. These:");
            stringBuffer.append(Arrays.asList(getAmbiguousComponentKeys()));
            stringBuffer.append(", refer http://picocontainer.org/ambiguous-injectable-help.html");
            return stringBuffer.toString();
        }

        public String[] getAmbiguousComponentKeys() {
            return this.ambiguousComponentKeys;
        }

        public void setComponent(String str) {
            if (this.component == null) {
                this.component = str;
            }
        }

        public void setMember(AccessibleObject accessibleObject) {
            if (this.accessibleObject == null) {
                this.accessibleObject = accessibleObject;
            }
        }
    }

    public static class UnsatisfiableDependenciesException extends PicoCompositionException {
        public UnsatisfiableDependenciesException(String str) {
            super(str);
        }
    }

    public static class NotConcreteRegistrationException extends PicoCompositionException {
        private final Class componentImplementation;

        public NotConcreteRegistrationException(Class<?> cls) {
            super("Bad Access: '" + cls.getName() + "' is not instantiable");
            this.componentImplementation = cls;
        }

        public Class<?> getComponentImplementation() {
            return this.componentImplementation;
        }
    }
}
