package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;

/* loaded from: classes6.dex */
public class AnnotatedMethodInjector extends SetterInjector {
    private final Class injectionAnnotation;

    public AnnotatedMethodInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, Class<? extends Annotation> cls2, boolean z) {
        super(obj, cls, parameterArr, componentMonitor, "", "", false, z);
        this.injectionAnnotation = cls2;
    }

    @Override // org.picocontainer.injectors.SetterInjector, org.picocontainer.injectors.IterativeInjector
    protected Object injectIntoMember(AccessibleObject accessibleObject, Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        return ((Method) accessibleObject).invoke(obj, obj2);
    }

    @Override // org.picocontainer.injectors.SetterInjector, org.picocontainer.injectors.IterativeInjector
    protected final boolean isInjectorMethod(Method method) {
        return method.getAnnotation(this.injectionAnnotation) != null;
    }

    @Override // org.picocontainer.injectors.SetterInjector, org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "MethodInjection";
    }
}
