package org.picocontainer.paranamer;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.inject.Named;

/* loaded from: classes6.dex */
public class AnnotationParanamer implements Paranamer {
    public static final String __PARANAMER_DATA = "v1.0 \nlookupParameterNames java.lang.AccessibleObject methodOrConstructor \nlookupParameterNames java.lang.AccessibleObject,boolean methodOrCtor,throwExceptionIfMissing \n";
    private final Paranamer fallback;

    public AnnotationParanamer() {
        this(new NullParanamer());
    }

    public AnnotationParanamer(Paranamer paranamer) {
        this.fallback = paranamer;
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject) {
        return lookupParameterNames(accessibleObject, true);
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject, boolean z) {
        Class<?>[] parameterTypes;
        Class<?> declaringClass;
        Annotation[][] parameterAnnotations;
        String name;
        if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            parameterTypes = method.getParameterTypes();
            name = method.getName();
            declaringClass = method.getDeclaringClass();
            parameterAnnotations = method.getParameterAnnotations();
        } else {
            Constructor constructor = (Constructor) accessibleObject;
            parameterTypes = constructor.getParameterTypes();
            declaringClass = constructor.getDeclaringClass();
            parameterAnnotations = constructor.getParameterAnnotations();
            name = "<init>";
        }
        if (parameterTypes.length == 0) {
            return Paranamer.EMPTY_NAMES;
        }
        int length = parameterTypes.length;
        String[] strArr = new String[length];
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = true;
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            while (true) {
                Annotation[] annotationArr = parameterAnnotations[i];
                if (i2 >= annotationArr.length) {
                    break;
                }
                Annotation annotation = annotationArr[i2];
                if (isNamed(annotation)) {
                    strArr[i] = getNamedValue(annotation);
                    break;
                }
                i2++;
            }
            if (strArr[i] == null) {
                z4 = false;
            }
        }
        if (z4) {
            z3 = z4;
        } else {
            String[] strArrLookupParameterNames = this.fallback.lookupParameterNames(accessibleObject, false);
            if (strArrLookupParameterNames.length > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    if (strArr[i3] == null) {
                        String str = strArrLookupParameterNames[i3];
                        if (str != null) {
                            strArr[i3] = str;
                        } else {
                            z2 = false;
                        }
                    }
                }
                z3 = z2;
            }
        }
        if (z3) {
            return strArr;
        }
        if (z) {
            throw new ParameterNamesNotFoundException("One or more @Named annotations missing for class '" + declaringClass.getName() + "', methodOrCtor " + name + " and parameter types " + DefaultParanamer.getParameterTypeNamesCSV(parameterTypes));
        }
        return Paranamer.EMPTY_NAMES;
    }

    protected String getNamedValue(Annotation annotation) {
        if ("javax.inject.Named".equals(annotation.annotationType().getName())) {
            return Jsr330Helper.getNamedValue(annotation);
        }
        return null;
    }

    protected boolean isNamed(Annotation annotation) {
        if ("javax.inject.Named".equals(annotation.annotationType().getName())) {
            return Jsr330Helper.isNamed(annotation);
        }
        return false;
    }

    public static class Jsr330Helper {
        public static final String __PARANAMER_DATA = "";

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isNamed(Annotation annotation) {
            return annotation instanceof Named;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getNamedValue(Annotation annotation) {
            return ((Named) annotation).value();
        }
    }
}
