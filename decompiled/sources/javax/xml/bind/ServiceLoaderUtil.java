package javax.xml.bind;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
abstract class ServiceLoaderUtil {
    static Object firstByServiceLoader(Class cls, Logger logger, ExceptionHandler exceptionHandler) throws Exception {
        try {
            Iterator it = ServiceLoader.load(cls).iterator();
            if (!it.hasNext()) {
                return null;
            }
            Object next = it.next();
            logger.fine("ServiceProvider loading Facility used; returning object [" + next.getClass().getName() + "]");
            return next;
        } catch (Throwable th) {
            throw exceptionHandler.createException(th, "Error while searching for service [" + cls.getName() + "]");
        }
    }

    static Object lookupUsingOSGiServiceLoader(String str, Logger logger) throws ClassNotFoundException {
        try {
            Iterator it = ((Iterable) Class.forName("org.glassfish.hk2.osgiresourcelocator.ServiceLoader").getMethod("lookupProviderClasses", Class.class).invoke(null, Class.forName(str))).iterator();
            if (!it.hasNext()) {
                return null;
            }
            Object next = it.next();
            logger.fine("Found implementation using OSGi facility; returning object [" + next.getClass().getName() + "].");
            return next;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            logger.log(Level.FINE, "Unable to find from OSGi: [" + str + "]", e);
            return null;
        }
    }

    static void checkPackageAccess(String str) {
        int iLastIndexOf;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null || (iLastIndexOf = str.lastIndexOf(46)) == -1) {
            return;
        }
        securityManager.checkPackageAccess(str.substring(0, iLastIndexOf));
    }

    static Class nullSafeLoadClass(String str, ClassLoader classLoader) {
        if (classLoader == null) {
            return Class.forName(str);
        }
        return classLoader.loadClass(str);
    }

    static Class safeLoadClass(String str, String str2, ClassLoader classLoader) {
        try {
            checkPackageAccess(str);
            return nullSafeLoadClass(str, classLoader);
        } catch (SecurityException e) {
            if (str2 != null && str2.equals(str)) {
                return Class.forName(str);
            }
            throw e;
        }
    }

    static abstract class ExceptionHandler {
        public abstract Exception createException(Throwable th, String str);

        ExceptionHandler() {
        }
    }
}
