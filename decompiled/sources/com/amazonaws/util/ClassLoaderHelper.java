package com.amazonaws.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes2.dex */
public enum ClassLoaderHelper {
    ;

    public static URL getResource(String str, Class<?>... clsArr) {
        return getResource(str, false, clsArr);
    }

    public static URL getResource(String str, boolean z, Class<?>... clsArr) {
        URL resourceViaContext;
        if (z) {
            resourceViaContext = getResourceViaClasses(str, clsArr);
            if (resourceViaContext == null) {
                resourceViaContext = getResourceViaContext(str);
            }
        } else {
            resourceViaContext = getResourceViaContext(str);
            if (resourceViaContext == null) {
                resourceViaContext = getResourceViaClasses(str, clsArr);
            }
        }
        return resourceViaContext == null ? ClassLoaderHelper.class.getResource(str) : resourceViaContext;
    }

    private static URL getResourceViaClasses(String str, Class[] clsArr) {
        if (clsArr == null) {
            return null;
        }
        for (Class cls : clsArr) {
            URL resource = cls.getResource(str);
            if (resource != null) {
                return resource;
            }
        }
        return null;
    }

    private static URL getResourceViaContext(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            return null;
        }
        return contextClassLoader.getResource(str);
    }

    private static Class loadClassViaClasses(String str, Class[] clsArr) {
        if (clsArr == null) {
            return null;
        }
        for (Class cls : clsArr) {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                try {
                    return classLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        return null;
    }

    private static Class loadClassViaContext(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            return null;
        }
        try {
            return contextClassLoader.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Class<?> loadClass(String str, Class<?>... clsArr) throws ClassNotFoundException {
        return loadClass(str, true, clsArr);
    }

    public static Class<?> loadClass(String str, boolean z, Class<?>... clsArr) throws ClassNotFoundException {
        Class<?> clsLoadClassViaContext;
        if (z) {
            clsLoadClassViaContext = loadClassViaClasses(str, clsArr);
            if (clsLoadClassViaContext == null) {
                clsLoadClassViaContext = loadClassViaContext(str);
            }
        } else {
            clsLoadClassViaContext = loadClassViaContext(str);
            if (clsLoadClassViaContext == null) {
                clsLoadClassViaContext = loadClassViaClasses(str, clsArr);
            }
        }
        return clsLoadClassViaContext == null ? Class.forName(str) : clsLoadClassViaContext;
    }

    public static InputStream getResourceAsStream(String str, Class<?>... clsArr) {
        return getResourceAsStream(str, false, clsArr);
    }

    public static InputStream getResourceAsStream(String str, boolean z, Class<?>... clsArr) {
        URL resource = getResource(str, z, clsArr);
        if (resource == null) {
            return null;
        }
        try {
            return resource.openStream();
        } catch (IOException unused) {
            return null;
        }
    }
}
