package org.picocontainer.security;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.util.Map;

/* loaded from: classes6.dex */
public class CustomPermissionsURLClassLoader extends URLClassLoader {
    private final Map permissionsMap;

    public CustomPermissionsURLClassLoader(URL[] urlArr, Map<URL, Permissions> map, ClassLoader classLoader) {
        super(urlArr, classLoader);
        this.permissionsMap = map;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        try {
            return super.loadClass(str);
        } catch (ClassNotFoundException e) {
            throw this.decorateException(str, e);
        }
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            return super.findClass(str);
        } catch (ClassNotFoundException e) {
            throw this.decorateException(str, e);
        }
    }

    private ClassNotFoundException decorateException(String str, ClassNotFoundException classNotFoundException) {
        if (str.startsWith("class ")) {
            return new ClassNotFoundException("Class '" + str + "' is not a classInstance.getName(). It's a classInstance.toString(). The clue is that it starts with 'class ', no classname contains a space.");
        }
        StringBuffer stringBuffer = new StringBuffer("'");
        stringBuffer.append(str);
        stringBuffer.append("' classloader stack [");
        final ClassLoader classLoader = this;
        while (classLoader != null) {
            stringBuffer.append(classLoader.toString());
            stringBuffer.append("\n");
            classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.security.CustomPermissionsURLClassLoader.1
                @Override // java.security.PrivilegedAction
                public ClassLoader run() {
                    return classLoader.getParent();
                }
            });
        }
        stringBuffer.append("]");
        return new ClassNotFoundException(stringBuffer.toString(), classNotFoundException);
    }

    public String toString() {
        String str = CustomPermissionsURLClassLoader.class.getName() + " " + System.identityHashCode(this) + ":";
        for (URL url : getURLs()) {
            str = str + "\n\t" + url.toString();
        }
        return str;
    }

    @Override // java.net.URLClassLoader, java.security.SecureClassLoader
    public PermissionCollection getPermissions(CodeSource codeSource) {
        return (Permissions) this.permissionsMap.get(codeSource.getLocation());
    }
}
