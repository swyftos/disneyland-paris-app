package cucumber.runtime.java;

import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.Utils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class MethodScanner {
    private final ClassFinder classFinder;

    public MethodScanner(ClassFinder classFinder) {
        this.classFinder = classFinder;
    }

    public void scan(JavaBackend javaBackend, List list) throws SecurityException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (Class superclass : this.classFinder.getDescendants(Object.class, (URI) it.next())) {
                while (superclass != null && superclass != Object.class && !Utils.isInstantiable(superclass)) {
                    superclass = superclass.getSuperclass();
                }
                if (superclass != null && superclass != Object.class) {
                    for (Method method : superclass.getMethods()) {
                        if (method.getDeclaringClass() != Object.class) {
                            scan(javaBackend, method, superclass);
                        }
                    }
                }
            }
        }
    }

    public void scan(JavaBackend javaBackend, Method method, Class cls) {
        for (Annotation annotation : method.getAnnotations()) {
            if (isHookAnnotation(annotation)) {
                validateMethod(method, cls);
                javaBackend.addHook(annotation, method);
            } else if (isStepdefAnnotation(annotation)) {
                validateMethod(method, cls);
                javaBackend.addStepDefinition(annotation, method);
            }
        }
    }

    private void validateMethod(Method method, Class cls) {
        if (!method.getDeclaringClass().isAssignableFrom(cls)) {
            throw new CucumberException(String.format("%s isn't assignable from %s", method.getDeclaringClass(), cls));
        }
        if (!cls.equals(method.getDeclaringClass())) {
            throw new CucumberException(String.format("You're not allowed to extend classes that define Step Definitions or hooks. %s extends %s", cls, method.getDeclaringClass()));
        }
    }

    private boolean isHookAnnotation(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        return clsAnnotationType.equals(Before.class) || clsAnnotationType.equals(After.class) || clsAnnotationType.equals(BeforeStep.class) || clsAnnotationType.equals(AfterStep.class) || clsAnnotationType.equals(io.cucumber.java.Before.class) || clsAnnotationType.equals(io.cucumber.java.After.class) || clsAnnotationType.equals(io.cucumber.java.BeforeStep.class) || clsAnnotationType.equals(io.cucumber.java.AfterStep.class);
    }

    private boolean isStepdefAnnotation(Annotation annotation) {
        return annotation.annotationType().getAnnotation(StepDefAnnotation.class) != null;
    }
}
