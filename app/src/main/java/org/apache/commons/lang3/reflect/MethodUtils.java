package org.apache.commons.lang3.reflect;

import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

/* JADX INFO: loaded from: classes6.dex */
public class MethodUtils {
    private static final Comparator METHOD_BY_SIGNATURE = Comparator.comparing(new MethodUtils$$ExternalSyntheticLambda10());

    private static int distance(Class[] clsArr, Class[] clsArr2) {
        if (!ClassUtils.isAssignable((Class<?>[]) clsArr, (Class<?>[]) clsArr2, true)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            Class cls = clsArr[i2];
            Class cls2 = clsArr2[i2];
            if (cls != null && !cls.equals(cls2)) {
                i = (!ClassUtils.isAssignable((Class<?>) cls, (Class<?>) cls2, true) || ClassUtils.isAssignable((Class<?>) cls, (Class<?>) cls2, false)) ? i + 2 : i + 1;
            }
        }
        return i;
    }

    public static Method getAccessibleMethod(Class<?> cls, Method method) {
        if (!MemberUtils.isPublic(method)) {
            return null;
        }
        if (ClassUtils.isPublic(cls)) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls, name, parameterTypes);
        return accessibleMethodFromInterfaceNest != null ? accessibleMethodFromInterfaceNest : getAccessibleMethodFromSuperclass(cls, name, parameterTypes);
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        return getAccessibleMethod(getMethodObject(cls, str, clsArr));
    }

    public static Method getAccessibleMethod(Method method) {
        if (method != null) {
            return getAccessibleMethod(method.getDeclaringClass(), method);
        }
        return null;
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class cls, String str, Class... clsArr) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (ClassUtils.isPublic(cls2)) {
                    try {
                        return cls2.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls2, str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getAccessibleMethodFromSuperclass(Class cls, String str, Class... clsArr) {
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (ClassUtils.isPublic(superclass)) {
                return getMethodObject(superclass, str, clsArr);
            }
        }
        return null;
    }

    private static List getAllSuperclassesAndInterfaces(Class cls) {
        int i;
        Class<?> cls2;
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(cls);
        List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(cls);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= allInterfaces.size() && i3 >= allSuperclasses.size()) {
                return arrayList;
            }
            if (i2 >= allInterfaces.size() || (i3 < allSuperclasses.size() && i3 < i2)) {
                i = i2;
                cls2 = allSuperclasses.get(i3);
                i3++;
            } else {
                i = i2 + 1;
                cls2 = allInterfaces.get(i2);
            }
            arrayList.add(cls2);
            i2 = i;
        }
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls, boolean z, boolean z2) {
        Method matchingAccessibleMethod;
        Objects.requireNonNull(method, TCEventPropertiesNames.TCE_METHOD);
        Objects.requireNonNull(cls, "annotationCls");
        if (!z2 && !MemberUtils.isAccessible(method)) {
            return null;
        }
        A a2 = (A) method.getAnnotation(cls);
        if (a2 == null && z) {
            for (Class cls2 : getAllSuperclassesAndInterfaces(method.getDeclaringClass())) {
                if (z2) {
                    matchingAccessibleMethod = getMatchingMethod(cls2, method.getName(), method.getParameterTypes());
                } else {
                    matchingAccessibleMethod = getMatchingAccessibleMethod(cls2, method.getName(), method.getParameterTypes());
                }
                if (matchingAccessibleMethod != null && (a2 = (A) matchingAccessibleMethod.getAnnotation(cls)) != null) {
                    break;
                }
            }
        }
        return a2;
    }

    private static Method getInvokeMethod(boolean z, String str, Class[] clsArr, Class cls) {
        if (z) {
            Method matchingMethod = getMatchingMethod(cls, str, clsArr);
            AccessibleObjects.setAccessible(matchingMethod);
            return matchingMethod;
        }
        return getMatchingAccessibleMethod(cls, str, clsArr);
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, final String str, final Class<?>... clsArr) {
        Method methodObject = getMethodObject(cls, str, clsArr);
        if (methodObject != null) {
            return (Method) MemberUtils.setAccessibleWorkaround(methodObject);
        }
        List list = (List) Stream.of((Object[]) cls.getMethods()).filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda12
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodUtils.lambda$getMatchingAccessibleMethod$0(str, clsArr, (Method) obj);
            }
        }).collect(Collectors.toList());
        list.sort(METHOD_BY_SIGNATURE);
        Iterator it = list.iterator();
        Method method = null;
        while (it.hasNext()) {
            Method accessibleMethod = getAccessibleMethod((Method) it.next());
            if (accessibleMethod != null && (method == null || MemberUtils.compareMethodFit(accessibleMethod, method, clsArr) < 0)) {
                method = accessibleMethod;
            }
        }
        if (method != null) {
            MemberUtils.setAccessibleWorkaround(method);
            if (method.isVarArgs()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
                for (int length = parameterTypes.length - 1; length < clsArr.length; length++) {
                    if (!ClassUtils.isAssignable(clsArr[length], componentType, true)) {
                        return null;
                    }
                }
            }
        }
        return method;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingAccessibleMethod$0(String str, Class[] clsArr, Method method) {
        return method.getName().equals(str) && MemberUtils.isMatchingMethod(method, clsArr);
    }

    public static Method getMatchingMethod(Class<?> cls, final String str, final Class<?>... clsArr) {
        Objects.requireNonNull(cls, "cls");
        Validate.notEmpty(str, "methodName", new Object[0]);
        List<Method> list = (List) Stream.of((Object[]) cls.getDeclaredMethods()).filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodUtils.lambda$getMatchingMethod$0(str, (Method) obj);
            }
        }).collect(Collectors.toList());
        List allSuperclassesAndInterfaces = getAllSuperclassesAndInterfaces(cls);
        Collections.reverse(allSuperclassesAndInterfaces);
        Stream streamFilter = allSuperclassesAndInterfaces.stream().map(new Function() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Class) obj).getDeclaredMethods();
            }
        }).flatMap(new Function() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Stream.of((Object[]) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodUtils.lambda$getMatchingMethod$1(str, (Method) obj);
            }
        });
        Objects.requireNonNull(list);
        streamFilter.forEach(new MethodUtils$$ExternalSyntheticLambda6(list));
        for (Method method : list) {
            if (Arrays.deepEquals(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        final TreeMap treeMap = new TreeMap();
        list.stream().filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda7
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodUtils.lambda$getMatchingMethod$2(clsArr, (Method) obj);
            }
        }).forEach(new Consumer() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MethodUtils.lambda$getMatchingMethod$3(clsArr, treeMap, (Method) obj);
            }
        });
        if (treeMap.isEmpty()) {
            return null;
        }
        List list2 = (List) treeMap.values().iterator().next();
        if (list2.size() == 1 || !Objects.equals(((Method) list2.get(0)).getDeclaringClass(), ((Method) list2.get(1)).getDeclaringClass())) {
            return (Method) list2.get(0);
        }
        throw new IllegalStateException(String.format("Found multiple candidates for method %s on class %s : %s", str + ((String) Stream.of((Object[]) clsArr).map(new Function() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return String.valueOf((Class) obj);
            }
        }).collect(Collectors.joining(",", "(", ")"))), cls.getName(), list2.stream().map(new MethodUtils$$ExternalSyntheticLambda10()).collect(Collectors.joining(",", "[", "]"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingMethod$0(String str, Method method) {
        return method.getName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingMethod$1(String str, Method method) {
        return method.getName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingMethod$2(Class[] clsArr, Method method) {
        return ClassUtils.isAssignable((Class<?>[]) clsArr, method.getParameterTypes(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMatchingMethod$3(Class[] clsArr, TreeMap treeMap, Method method) {
        ((List) treeMap.computeIfAbsent(Integer.valueOf(distance(clsArr, method.getParameterTypes())), new Function() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MethodUtils.lambda$getMatchingMethod$4((Integer) obj);
            }
        })).add(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getMatchingMethod$4(Integer num) {
        return new ArrayList();
    }

    public static Method getMethodObject(Class<?> cls, String str, Class<?>... clsArr) {
        if (str == null || cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsListWithAnnotation(cls, cls2, false, false);
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, final Class<? extends Annotation> cls2, boolean z, final boolean z2) {
        Objects.requireNonNull(cls, "cls");
        Objects.requireNonNull(cls2, "annotationCls");
        List allSuperclassesAndInterfaces = z ? getAllSuperclassesAndInterfaces(cls) : new ArrayList();
        allSuperclassesAndInterfaces.add(0, cls);
        final ArrayList arrayList = new ArrayList();
        allSuperclassesAndInterfaces.forEach(new Consumer() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MethodUtils.lambda$getMethodsListWithAnnotation$0(z2, cls2, arrayList, (Class) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMethodsListWithAnnotation$0(boolean z, final Class cls, List list, Class cls2) {
        Stream streamFilter = Stream.of((Object[]) (z ? cls2.getDeclaredMethods() : cls2.getMethods())).filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda14
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodUtils.lambda$getMethodsListWithAnnotation$1(cls, (Method) obj);
            }
        });
        Objects.requireNonNull(list);
        streamFilter.forEachOrdered(new MethodUtils$$ExternalSyntheticLambda6(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMethodsListWithAnnotation$1(Class cls, Method method) {
        return method.isAnnotationPresent(cls);
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsWithAnnotation(cls, cls2, false, false);
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        return (Method[]) getMethodsListWithAnnotation(cls, cls2, z, z2).toArray(ArrayUtils.EMPTY_METHOD_ARRAY);
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Objects.requireNonNull(method, TCEventPropertiesNames.TCE_METHOD);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
        it.next();
        while (it.hasNext()) {
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(it.next(), method.getName(), parameterTypes);
            if (matchingAccessibleMethod != null) {
                if (Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                    linkedHashSet.add(matchingAccessibleMethod);
                } else {
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                    int i = 0;
                    while (true) {
                        if (i < parameterTypes.length) {
                            if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i]))) {
                                break;
                            }
                            i++;
                        } else {
                            linkedHashSet.add(matchingAccessibleMethod);
                            break;
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public static Object invokeExactMethod(Object obj, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeExactMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactMethod(obj, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Objects.requireNonNull(obj, "object");
        Class<?> cls = obj.getClass();
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArrNullToEmpty);
        requireNonNull(accessibleMethod, cls, str, clsArrNullToEmpty);
        return accessibleMethod.invoke(obj, ArrayUtils.nullToEmpty(objArr));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactStaticMethod(cls, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArrNullToEmpty));
        requireNonNull(accessibleMethod, cls, str, clsArrNullToEmpty);
        return accessibleMethod.invoke(null, ArrayUtils.nullToEmpty(objArr));
    }

    public static Object invokeMethod(Object obj, boolean z, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeMethod(obj, z, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, z, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Objects.requireNonNull(obj, "object");
        Class<?> cls = obj.getClass();
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Method invokeMethod = getInvokeMethod(z, str, clsArrNullToEmpty, cls);
        requireNonNull(invokeMethod, cls, str, clsArrNullToEmpty);
        return invokeMethod.invoke(obj, toVarArgs(invokeMethod, ArrayUtils.nullToEmpty(objArr)));
    }

    public static Object invokeMethod(Object obj, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[]) null);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeMethod(obj, false, str, objArr, clsArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArrNullToEmpty);
        requireNonNull(matchingAccessibleMethod, cls, str, clsArrNullToEmpty);
        return matchingAccessibleMethod.invoke(null, toVarArgs(matchingAccessibleMethod, ArrayUtils.nullToEmpty(objArr)));
    }

    private static Method requireNonNull(Method method, Class cls, String str, Class[] clsArr) throws NoSuchMethodException {
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodException(String.format("No method: %s.%s(%s)", ClassUtils.getName((Class<?>) cls), str, Streams.m1973of(clsArr).map(new Function() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ClassUtils.getName((Class<?>) obj);
            }
        }).collect(LangCollectors.joining(", "))));
    }

    static Object[] toVarArgs(Executable executable, Object[] objArr) {
        return executable.isVarArgs() ? toVarArgs(objArr, executable.getParameterTypes()) : objArr;
    }

    private static Object[] toVarArgs(Object[] objArr, Class[] clsArr) throws IllegalAccessException, InvocationTargetException {
        Object objNewInstance;
        Object obj;
        final int length = clsArr.length;
        if (objArr.length == length && ((obj = objArr[objArr.length - 1]) == null || obj.getClass().equals(clsArr[length - 1]))) {
            return objArr;
        }
        int i = length - 1;
        Object[] objArr2 = (Object[]) ArrayUtils.arraycopy(objArr, 0, 0, i, (Supplier<Object[]>) new Supplier() { // from class: org.apache.commons.lang3.reflect.MethodUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return MethodUtils.lambda$toVarArgs$0(length);
            }
        });
        Class<?> componentType = clsArr[i].getComponentType();
        Class<?> clsPrimitiveToWrapper = ClassUtils.primitiveToWrapper(componentType);
        int length2 = (objArr.length - length) + 1;
        Object objNewInstance2 = Array.newInstance(clsPrimitiveToWrapper, length2);
        boolean zIsPrimitiveOrWrapper = ClassUtils.isPrimitiveOrWrapper(clsPrimitiveToWrapper);
        for (int i2 = 0; i2 < length2; i2++) {
            Object obj2 = objArr[i + i2];
            if (zIsPrimitiveOrWrapper) {
                try {
                    objNewInstance = clsPrimitiveToWrapper.getConstructor(ClassUtils.wrapperToPrimitive(clsPrimitiveToWrapper)).newInstance(obj2);
                } catch (InstantiationException e) {
                    throw new IllegalArgumentException("Cannot convert vararg #" + i2, e);
                }
            } else {
                objNewInstance = clsPrimitiveToWrapper.cast(obj2);
            }
            Array.set(objNewInstance2, i2, objNewInstance);
        }
        if (componentType.isPrimitive()) {
            objNewInstance2 = ArrayUtils.toPrimitive(objNewInstance2);
        }
        objArr2[i] = objNewInstance2;
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$toVarArgs$0(int i) {
        return new Object[i];
    }

    @Deprecated
    public MethodUtils() {
    }
}
