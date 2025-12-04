package org.picocontainer.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.PicoLifecycleException;

/* loaded from: classes6.dex */
public final class JavaEE5LifecycleStrategy extends AbstractMonitoringLifecycleStrategy {
    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) {
    }

    public JavaEE5LifecycleStrategy(ComponentMonitor componentMonitor) {
        super(componentMonitor);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        doLifecycleMethod(obj, PostConstruct.class, true);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        doLifecycleMethod(obj, PreDestroy.class, false);
    }

    private void doLifecycleMethod(Object obj, Class cls, boolean z) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        doLifecycleMethod(obj, cls, obj.getClass(), z, new HashSet());
    }

    private void doLifecycleMethod(Object obj, Class cls, Class cls2, boolean z, Set set) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i;
        Method method;
        Class superclass = cls2.getSuperclass();
        if (z && superclass != Object.class) {
            doLifecycleMethod(obj, cls, superclass, z, set);
        }
        Method[] declaredMethods = cls2.getDeclaredMethods();
        int length = declaredMethods.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            Method method2 = declaredMethods[i3];
            String strSignature = signature(method2);
            if (!method2.isAnnotationPresent(cls) || set.contains(strSignature)) {
                i = i3;
            } else {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    currentMonitor().invoking(null, null, method2, obj, new Object[i2]);
                    method2.invoke(obj, new Object[i2]);
                    set.add(strSignature);
                    Object[] objArr = new Object[i2];
                    method = method2;
                    i = i3;
                    try {
                        currentMonitor().invoked(null, null, method2, obj, System.currentTimeMillis() - jCurrentTimeMillis, objArr, null);
                    } catch (IllegalAccessException e) {
                        e = e;
                        throw new PicoLifecycleException(method, obj, e);
                    } catch (InvocationTargetException e2) {
                        e = e2;
                        throw new PicoLifecycleException(method, obj, e);
                    }
                } catch (IllegalAccessException e3) {
                    e = e3;
                    method = method2;
                } catch (InvocationTargetException e4) {
                    e = e4;
                    method = method2;
                }
            }
            i3 = i + 1;
            i2 = 0;
        }
        if (z || superclass == Object.class) {
            return;
        }
        doLifecycleMethod(obj, cls, superclass, z, set);
    }

    private static String signature(Method method) {
        StringBuilder sb = new StringBuilder(method.getName());
        for (Class<?> cls : method.getParameterTypes()) {
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PreDestroy.class) || method.isAnnotationPresent(PostConstruct.class)) {
                return true;
            }
        }
        return false;
    }
}
