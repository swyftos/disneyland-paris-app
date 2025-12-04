package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import org.picocontainer.InjectionFactory;

/* loaded from: classes6.dex */
public class Injectors {
    public static InjectionFactory adaptiveDI() {
        return new AdaptingInjection();
    }

    public static InjectionFactory SDI() {
        return new SetterInjection();
    }

    public static InjectionFactory CDI() {
        return new ConstructorInjection();
    }

    public static InjectionFactory namedMethod() {
        return new NamedMethodInjection();
    }

    public static InjectionFactory namedField() {
        return new NamedFieldInjection();
    }

    public static InjectionFactory annotatedMethodDI(Class<? extends Annotation> cls) {
        return new AnnotatedMethodInjection(cls, false);
    }

    public static InjectionFactory annotatedMethodDI() {
        return new AnnotatedMethodInjection();
    }

    public static InjectionFactory annotatedFieldDI(Class<? extends Annotation> cls) {
        return new AnnotatedFieldInjection(cls);
    }

    public static InjectionFactory annotatedFieldDI() {
        return new AnnotatedFieldInjection();
    }

    public static InjectionFactory typedFieldDI() {
        return new TypedFieldInjection();
    }
}
