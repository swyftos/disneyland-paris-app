package org.picocontainer.injectors;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;
import org.picocontainer.injectors.AbstractInjector;

/* loaded from: classes6.dex */
public class SetterInjector<T> extends IterativeInjector<T> {
    private final String notThisOneThough;
    private final boolean optional;
    protected final String prefix;

    public SetterInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str, String str2, boolean z, boolean z2) throws AbstractInjector.NotConcreteRegistrationException {
        super(obj, cls, parameterArr, componentMonitor, z2);
        this.prefix = str;
        this.optional = z;
        this.notThisOneThough = str2 == null ? "" : str2;
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected Object memberInvocationReturn(Object obj, AccessibleObject accessibleObject, Object obj2) {
        return (accessibleObject == null || ((Method) accessibleObject).getReturnType() == Void.TYPE) ? obj2 : obj;
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected Object injectIntoMember(AccessibleObject accessibleObject, Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        return ((Method) accessibleObject).invoke(obj, obj2);
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected boolean isInjectorMethod(Method method) {
        String name = method.getName();
        return name.length() >= getInjectorPrefix().length() + 1 && name.startsWith(getInjectorPrefix()) && !name.equals(this.notThisOneThough) && Character.isUpperCase(name.charAt(getInjectorPrefix().length()));
    }

    protected String getInjectorPrefix() {
        return this.prefix;
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "SetterInjector-";
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected void unsatisfiedDependencies(PicoContainer picoContainer, Set<Type> set, List<AccessibleObject> list) {
        if (this.optional) {
            return;
        }
        throw new AbstractInjector.UnsatisfiableDependenciesException(getComponentImplementation().getName() + " has unsatisfied dependencies " + set + " for members " + list + " from " + picoContainer);
    }
}
