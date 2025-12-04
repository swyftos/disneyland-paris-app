package ch.qos.logback.core.joran.util;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class MethodDescriptor {
    private Method method;
    private String name;

    public MethodDescriptor(String str, Method method) {
        this.name = str;
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }
}
