package org.picocontainer;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class PicoLifecycleException extends PicoException {
    private final Object instance;
    private final Method method;

    public PicoLifecycleException(Method method, Object obj, Throwable th) {
        super(th);
        this.method = method;
        this.instance = obj;
    }

    public Method getMethod() {
        return this.method;
    }

    public Object getInstance() {
        return this.instance;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "PicoLifecycleException: method '" + this.method + "', instance '" + this.instance + ", " + super.getMessage();
    }
}
