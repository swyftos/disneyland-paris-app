package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.injectors.AbstractInjector;
import org.picocontainer.injectors.MethodInjector;

/* loaded from: classes6.dex */
public class Injector {
    public static ComponentAdapter constructor(Object obj, Class<?> cls, Parameter... parameterArr) {
        return new ConstructorInjector(obj, cls, parameterArr);
    }

    public static ComponentAdapter constructor(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
        return new ConstructorInjector(obj, cls, parameterArr, componentMonitor, z);
    }

    public static ComponentAdapter constructor(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z, boolean z2) throws AbstractInjector.NotConcreteRegistrationException {
        return new ConstructorInjector(obj, cls, parameterArr, componentMonitor, z, z2);
    }

    public static ComponentAdapter annotatedField(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, Class<? extends Annotation> cls2, boolean z) {
        return componentMonitor.newInjector(new AnnotatedFieldInjector(obj, cls, parameterArr, componentMonitor, cls2, z));
    }

    public static ComponentAdapter annotatedMethod(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, Class<? extends Annotation> cls2, boolean z) {
        return componentMonitor.newInjector(new AnnotatedMethodInjector(obj, cls, parameterArr, componentMonitor, cls2, z));
    }

    public static ComponentAdapter composite(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z, org.picocontainer.Injector... injectorArr) {
        return componentMonitor.newInjector(new CompositeInjector(obj, cls, parameterArr, componentMonitor, z, injectorArr));
    }

    public static ComponentAdapter method(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
        return componentMonitor.newInjector(new MethodInjector.ByMethodName(obj, cls, parameterArr, componentMonitor, new HashSet(Arrays.asList(str)), z));
    }

    public static ComponentAdapter multi(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str, boolean z) {
        return componentMonitor.newInjector(new MultiInjector(obj, cls, parameterArr, componentMonitor, str, z));
    }

    public static ComponentAdapter namedField(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str) {
        return componentMonitor.newInjector(new NamedFieldInjector(obj, cls, parameterArr, componentMonitor, str));
    }

    public static ComponentAdapter setter(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
        return componentMonitor.newInjector(new SetterInjector(obj, cls, parameterArr, componentMonitor, str, "", false, z));
    }

    public static ComponentAdapter typedField(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str) {
        return componentMonitor.newInjector(new TypedFieldInjector(obj, cls, parameterArr, componentMonitor, str));
    }
}
