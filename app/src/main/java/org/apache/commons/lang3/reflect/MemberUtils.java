package org.apache.commons.lang3.reflect;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes6.dex */
abstract class MemberUtils {
    private static final Class[] WIDENING_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    static boolean isPackage(int i) {
        return (i & 7) == 0;
    }

    private static final class Executable {
        private final boolean isVarArgs;
        private final Class[] parameterTypes;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: of */
        public static Executable m1965of(Constructor constructor) {
            return new Executable(constructor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: of */
        public static Executable m1966of(Method method) {
            return new Executable(method);
        }

        private Executable(Constructor constructor) {
            this.parameterTypes = constructor.getParameterTypes();
            this.isVarArgs = constructor.isVarArgs();
        }

        private Executable(Method method) {
            this.parameterTypes = method.getParameterTypes();
            this.isVarArgs = method.isVarArgs();
        }

        public Class[] getParameterTypes() {
            return this.parameterTypes;
        }

        public boolean isVarArgs() {
            return this.isVarArgs;
        }
    }

    static int compareConstructorFit(Constructor constructor, Constructor constructor2, Class[] clsArr) {
        return compareParameterTypes(Executable.m1965of(constructor), Executable.m1965of(constructor2), clsArr);
    }

    static int compareMethodFit(Method method, Method method2, Class[] clsArr) {
        return compareParameterTypes(Executable.m1966of(method), Executable.m1966of(method2), clsArr);
    }

    private static int compareParameterTypes(Executable executable, Executable executable2, Class[] clsArr) {
        return Float.compare(getTotalTransformationCost(clsArr, executable), getTotalTransformationCost(clsArr, executable2));
    }

    private static float getObjectTransformationCost(Class cls, Class cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f = BitmapDescriptorFactory.HUE_RED;
        while (cls != null && !cls2.equals(cls)) {
            if (cls2.isInterface() && ClassUtils.isAssignable((Class<?>) cls, (Class<?>) cls2)) {
                f += 0.25f;
                break;
            }
            f += 1.0f;
            cls = cls.getSuperclass();
        }
        return cls == null ? f + 1.5f : f;
    }

    private static float getPrimitivePromotionCost(Class cls, Class cls2) {
        float f;
        if (cls == null) {
            return 1.5f;
        }
        if (cls.isPrimitive()) {
            f = BitmapDescriptorFactory.HUE_RED;
        } else {
            cls = ClassUtils.wrapperToPrimitive(cls);
            f = 0.1f;
        }
        int i = 0;
        while (cls != cls2) {
            Class[] clsArr = WIDENING_PRIMITIVE_TYPES;
            if (i >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i]) {
                f += 0.1f;
                if (i < clsArr.length - 1) {
                    cls = clsArr[i + 1];
                }
            }
            i++;
        }
        return f;
    }

    private static float getTotalTransformationCost(Class[] clsArr, Executable executable) {
        float objectTransformationCost;
        Class[] parameterTypes = executable.getParameterTypes();
        boolean zIsVarArgs = executable.isVarArgs();
        int length = parameterTypes.length;
        if (zIsVarArgs) {
            length--;
        }
        long j = length;
        if (clsArr.length < j) {
            return Float.MAX_VALUE;
        }
        boolean z = false;
        float objectTransformationCost2 = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < j; i++) {
            objectTransformationCost2 += getObjectTransformationCost(clsArr[i], parameterTypes[i]);
        }
        if (!zIsVarArgs) {
            return objectTransformationCost2;
        }
        boolean z2 = clsArr.length < parameterTypes.length;
        if (clsArr.length == parameterTypes.length && clsArr[clsArr.length - 1] != null && clsArr[clsArr.length - 1].isArray()) {
            z = true;
        }
        Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
        if (z2) {
            objectTransformationCost = getObjectTransformationCost(componentType, Object.class);
        } else if (z) {
            objectTransformationCost = getObjectTransformationCost(clsArr[clsArr.length - 1].getComponentType(), componentType);
        } else {
            for (int length2 = parameterTypes.length - 1; length2 < clsArr.length; length2++) {
                objectTransformationCost2 += getObjectTransformationCost(clsArr[length2], componentType) + 0.001f;
            }
            return objectTransformationCost2;
        }
        return objectTransformationCost2 + objectTransformationCost + 0.001f;
    }

    static boolean isAccessible(Member member) {
        return isPublic(member) && !member.isSynthetic();
    }

    static boolean isMatchingConstructor(Constructor constructor, Class[] clsArr) {
        return isMatchingExecutable(Executable.m1965of(constructor), clsArr);
    }

    private static boolean isMatchingExecutable(Executable executable, Class[] clsArr) {
        Class[] parameterTypes = executable.getParameterTypes();
        if (ClassUtils.isAssignable((Class<?>[]) clsArr, (Class<?>[]) parameterTypes, true)) {
            return true;
        }
        if (!executable.isVarArgs()) {
            return false;
        }
        int i = 0;
        while (i < parameterTypes.length - 1 && i < clsArr.length) {
            if (!ClassUtils.isAssignable((Class<?>) clsArr[i], (Class<?>) parameterTypes[i], true)) {
                return false;
            }
            i++;
        }
        Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
        while (i < clsArr.length) {
            if (!ClassUtils.isAssignable((Class<?>) clsArr[i], componentType, true)) {
                return false;
            }
            i++;
        }
        return true;
    }

    static boolean isMatchingMethod(Method method, Class[] clsArr) {
        return isMatchingExecutable(Executable.m1966of(method), clsArr);
    }

    static boolean isPublic(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers());
    }

    static boolean isStatic(Member member) {
        return member != null && Modifier.isStatic(member.getModifiers());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static AccessibleObject setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (AccessibleObjects.isAccessible(accessibleObject)) {
            return accessibleObject;
        }
        Member member = (Member) accessibleObject;
        if (isPublic(member) && isPackage(member.getDeclaringClass().getModifiers())) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException unused) {
            }
        }
        return accessibleObject;
    }
}
