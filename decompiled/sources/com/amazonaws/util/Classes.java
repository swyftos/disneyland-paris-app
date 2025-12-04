package com.amazonaws.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarFile;

/* loaded from: classes2.dex */
public enum Classes {
    ;

    public static Class<?> childClassOf(Class<?> cls, Object obj) {
        if (obj == null || obj == Object.class) {
            return null;
        }
        if (cls != null && cls.isInterface()) {
            return null;
        }
        Class<?> cls2 = obj.getClass();
        while (true) {
            Class<? super Object> superclass = cls2.getSuperclass();
            if (superclass == cls) {
                return cls2;
            }
            if (superclass == null) {
                return null;
            }
            cls2 = superclass;
        }
    }

    public static JarFile jarFileOf(Class<?> cls) {
        URL resource = cls.getResource("/" + cls.getName().replace('.', '/') + ".class");
        if (resource == null) {
            return null;
        }
        String file = resource.getFile();
        int iIndexOf = file.indexOf("file:") + 5;
        int iIndexOf2 = file.indexOf(".jar!");
        if (iIndexOf2 == -1) {
            return null;
        }
        File file2 = new File(file.substring(iIndexOf, iIndexOf2 + 4));
        try {
            if (file2.exists()) {
                return new JarFile(file2);
            }
            return null;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
