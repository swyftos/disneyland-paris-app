package io.cucumber.junit;

import cucumber.runtime.CucumberException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
abstract class Assertions {
    static void assertNoCucumberAnnotatedMethods(Class cls) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation.annotationType().getName().startsWith("cucumber") || annotation.annotationType().getName().startsWith("io.cucumber")) {
                    throw new CucumberException("\n\nClasses annotated with @RunWith(Cucumber.class) must not define any\nStep Definition or Hook methods. Their sole purpose is to serve as\nan entry point for JUnit. Step Definitions and Hooks should be defined\nin their own classes. This allows them to be reused across features.\nOffending class: " + cls + "\n");
                }
            }
        }
    }
}
