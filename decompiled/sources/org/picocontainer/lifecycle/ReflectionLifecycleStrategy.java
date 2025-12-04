package org.picocontainer.lifecycle;

import com.facebook.react.uimanager.ViewProps;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.picocontainer.ComponentMonitor;

/* loaded from: classes6.dex */
public class ReflectionLifecycleStrategy extends AbstractMonitoringLifecycleStrategy {
    private final transient Map methodMap;
    private final String[] methodNames;

    public ReflectionLifecycleStrategy(ComponentMonitor componentMonitor) {
        this(componentMonitor, ViewProps.START, "stop", "dispose");
    }

    public ReflectionLifecycleStrategy(ComponentMonitor componentMonitor, String str, String str2, String str3) {
        super(componentMonitor);
        this.methodMap = new HashMap();
        this.methodNames = new String[]{str, str2, str3};
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        invokeMethod(obj, init(obj.getClass())[0]);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        invokeMethod(obj, init(obj.getClass())[1]);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        invokeMethod(obj, init(obj.getClass())[2]);
    }

    private void invokeMethod(Object obj, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj == null || method == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            currentMonitor().invoking(null, null, method, obj, new Object[0]);
            method.invoke(obj, new Object[0]);
            currentMonitor().invoked(null, null, method, obj, System.currentTimeMillis() - jCurrentTimeMillis, new Object[0], null);
        } catch (IllegalAccessException e) {
            monitorAndThrowReflectionLifecycleException(method, e, obj);
        } catch (InvocationTargetException e2) {
            monitorAndThrowReflectionLifecycleException(method, e2.getCause(), obj);
        }
    }

    protected void monitorAndThrowReflectionLifecycleException(Method method, Throwable th, Object obj) {
        RuntimeException runtimeException;
        if (th.getCause() instanceof RuntimeException) {
            runtimeException = (RuntimeException) th.getCause();
        } else {
            runtimeException = new RuntimeException("wrapper", th);
        }
        currentMonitor().lifecycleInvocationFailed(null, null, method, obj, runtimeException);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        for (Method method : init(cls)) {
            if (method != null) {
                return true;
            }
        }
        return false;
    }

    private Method[] init(Class cls) {
        Method[] methodArr;
        synchronized (this.methodMap) {
            methodArr = (Method[]) this.methodMap.get(cls);
            if (methodArr == null) {
                int length = this.methodNames.length;
                Method[] methodArr2 = new Method[length];
                for (int i = 0; i < length; i++) {
                    try {
                        String str = this.methodNames[i];
                        if (str != null) {
                            methodArr2[i] = cls.getMethod(str, new Class[0]);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
                this.methodMap.put(cls, methodArr2);
                methodArr = methodArr2;
            }
        }
        return methodArr;
    }
}
