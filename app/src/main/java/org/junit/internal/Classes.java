package org.junit.internal;

/* JADX INFO: loaded from: classes2.dex */
public class Classes {
    @Deprecated
    public Classes() {
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return getClass(str, Classes.class);
    }

    public static Class<?> getClass(String str, Class<?> cls) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = cls.getClassLoader();
        }
        return Class.forName(str, true, contextClassLoader);
    }
}
