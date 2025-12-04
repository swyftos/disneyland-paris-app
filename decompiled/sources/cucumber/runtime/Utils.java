package cucumber.runtime;

import cucumber.runtime.Timeout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes5.dex */
public class Utils {
    public static boolean isInstantiable(Class<?> cls) {
        return (!Modifier.isPublic(cls.getModifiers()) || Modifier.isAbstract(cls.getModifiers()) || (!Modifier.isStatic(cls.getModifiers()) && cls.getEnclosingClass() != null)) ? false : true;
    }

    public static Object invoke(final Object obj, Method method, long j, final Object... objArr) throws Throwable {
        final Method methodTargetMethod = targetMethod(obj, method);
        return Timeout.timeout(new Timeout.Callback() { // from class: cucumber.runtime.Utils.1
            @Override // cucumber.runtime.Timeout.Callback
            public Object call() throws SecurityException {
                boolean zIsAccessible = methodTargetMethod.isAccessible();
                try {
                    try {
                        try {
                            methodTargetMethod.setAccessible(true);
                            return methodTargetMethod.invoke(obj, objArr);
                        } catch (IllegalAccessException e) {
                            throw new CucumberException("Failed to invoke " + MethodFormat.FULL.format(methodTargetMethod) + ", caused by " + e.getClass().getName() + ": " + e.getMessage(), e);
                        } catch (InvocationTargetException e2) {
                            throw e2.getTargetException();
                        }
                    } catch (IllegalArgumentException e3) {
                        throw new CucumberException("Failed to invoke " + MethodFormat.FULL.format(methodTargetMethod) + ", caused by " + e3.getClass().getName() + ": " + e3.getMessage(), e3);
                    }
                } finally {
                    methodTargetMethod.setAccessible(zIsAccessible);
                }
            }
        }, j);
    }

    private static Method targetMethod(Object obj, Method method) throws NoSuchMethodException {
        Class<?> superclass = obj.getClass();
        if (superclass.getClassLoader().equals(method.getDeclaringClass().getClassLoader())) {
            return method;
        }
        if (Modifier.isPublic(method.getModifiers())) {
            return superclass.getMethod(method.getName(), method.getParameterTypes());
        }
        while (superclass != Object.class) {
            try {
                return superclass.getDeclaredMethod(method.getName(), method.getParameterTypes());
            } catch (NoSuchMethodException unused) {
                superclass = superclass.getSuperclass();
            }
        }
        throw new NoSuchMethodException(String.valueOf(method));
    }

    public static URL toURL(String str) {
        try {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            if (str.matches("^(file|http|https):.*")) {
                return new URL(str);
            }
            return new URL("file:" + str);
        } catch (MalformedURLException e) {
            throw new CucumberException("Bad URL:" + str, e);
        }
    }

    public static String htmlEscape(String str) {
        return str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#x27;").replace("/", "&#x2F;");
    }

    public static String getUniqueTestNameForScenarioExample(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(includesBlank(str) ? " " : "_");
        sb.append(i);
        return sb.toString();
    }

    private static boolean includesBlank(String str) {
        return str.indexOf(32) != -1;
    }
}
