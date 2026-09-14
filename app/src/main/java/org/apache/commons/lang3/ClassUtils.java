package org.apache.commons.lang3;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes6.dex */
public class ClassUtils {
    private static final Map ABBREVIATION_MAP;
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    private static final Map NAME_PRIMITIVE_MAP;
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final Map PRIMITIVE_WRAPPER_MAP;
    private static final Map REVERSE_ABBREVIATION_MAP;
    private static final Map WRAPPER_PRIMITIVE_MAP;
    private static final Comparator COMPARATOR = new Comparator() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ClassUtils.lambda$static$0((Class) obj, (Class) obj2);
        }
    };
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');

    public enum Interfaces {
        INCLUDE,
        EXCLUDE
    }

    private static boolean useFull(int i, int i2, int i3, int i4) {
        return i2 >= i3 || (i + i3) - i2 <= i4;
    }

    static {
        HashMap map = new HashMap();
        NAME_PRIMITIVE_MAP = map;
        Class cls = Boolean.TYPE;
        map.put(cls.getName(), cls);
        Class cls2 = Byte.TYPE;
        map.put(cls2.getName(), cls2);
        Class cls3 = Character.TYPE;
        map.put(cls3.getName(), cls3);
        Class cls4 = Double.TYPE;
        map.put(cls4.getName(), cls4);
        Class cls5 = Float.TYPE;
        map.put(cls5.getName(), cls5);
        Class cls6 = Integer.TYPE;
        map.put(cls6.getName(), cls6);
        Class cls7 = Long.TYPE;
        map.put(cls7.getName(), cls7);
        Class cls8 = Short.TYPE;
        map.put(cls8.getName(), cls8);
        Class cls9 = Void.TYPE;
        map.put(cls9.getName(), cls9);
        HashMap map2 = new HashMap();
        PRIMITIVE_WRAPPER_MAP = map2;
        map2.put(cls, Boolean.class);
        map2.put(cls2, Byte.class);
        map2.put(cls3, Character.class);
        map2.put(cls8, Short.class);
        map2.put(cls6, Integer.class);
        map2.put(cls7, Long.class);
        map2.put(cls4, Double.class);
        map2.put(cls5, Float.class);
        map2.put(cls9, cls9);
        WRAPPER_PRIMITIVE_MAP = new HashMap();
        map2.forEach(new BiConsumer() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ClassUtils.lambda$static$1((Class) obj, (Class) obj2);
            }
        });
        HashMap map3 = new HashMap();
        map3.put(cls6.getName(), "I");
        map3.put(cls.getName(), "Z");
        map3.put(cls5.getName(), "F");
        map3.put(cls7.getName(), "J");
        map3.put(cls8.getName(), ExifInterface.LATITUDE_SOUTH);
        map3.put(cls2.getName(), "B");
        map3.put(cls4.getName(), "D");
        map3.put(cls3.getName(), "C");
        ABBREVIATION_MAP = Collections.unmodifiableMap(map3);
        REVERSE_ABBREVIATION_MAP = Collections.unmodifiableMap((Map) map3.entrySet().stream().collect(Collectors.toMap(new Function() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getValue();
            }
        }, new Function() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getKey();
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Class cls, Class cls2) {
        return Objects.compare(getName((Class<?>) cls), getName((Class<?>) cls2), new Comparator() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda11
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((String) obj).compareTo((String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return;
        }
        WRAPPER_PRIMITIVE_MAP.put(cls2, cls);
    }

    public static Comparator<Class<?>> comparator() {
        return COMPARATOR;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        return (List) list.stream().map(new Function() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ClassUtils.lambda$convertClassesToClassNames$0((Class) obj);
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$convertClassesToClassNames$0(Class cls) {
        return getName((Class<?>) cls, (String) null);
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        final ArrayList arrayList = new ArrayList(list.size());
        list.forEach(new Consumer() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ClassUtils.lambda$convertClassNamesToClasses$0(arrayList, (String) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertClassNamesToClasses$0(List list, String str) {
        try {
            list.add(Class.forName(str));
        } catch (Exception unused) {
            list.add(null);
        }
    }

    public static String getAbbreviatedName(Class<?> cls, int i) {
        if (cls == null) {
            return "";
        }
        return getAbbreviatedName(cls.getName(), i);
    }

    public static String getAbbreviatedName(String str, int i) {
        char c;
        if (i <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        if (str == null) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i2 = 0;
        int i3 = 0;
        while (i2 < charArray.length) {
            int i4 = i3;
            while (i2 < charArray.length && (c = charArray[i2]) != '.') {
                i2++;
                charArray[i4] = c;
                i4++;
            }
            int i5 = i3 + 1;
            if (!useFull(i4, i2, charArray.length, i) && i5 <= i4) {
                i4 = i5;
            }
            if (i2 < charArray.length) {
                i3 = i4 + 1;
                charArray[i4] = charArray[i2];
                i2++;
            } else {
                i3 = i4;
            }
        }
        return new String(charArray, 0, i3);
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void getAllInterfaces(Class cls, HashSet hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    public static String getCanonicalName(Class<?> cls) {
        return getCanonicalName(cls, "");
    }

    public static String getCanonicalName(Class<?> cls, String str) {
        String canonicalName;
        return (cls == null || (canonicalName = cls.getCanonicalName()) == null) ? str : canonicalName;
    }

    public static String getCanonicalName(Object obj) {
        return getCanonicalName(obj, "");
    }

    public static String getCanonicalName(Object obj, String str) {
        String canonicalName;
        return (obj == null || (canonicalName = obj.getClass().getCanonicalName()) == null) ? str : canonicalName;
    }

    private static String getCanonicalName(String str) {
        String strSubstring;
        String strDeleteWhitespace = StringUtils.deleteWhitespace(str);
        if (strDeleteWhitespace == null) {
            return null;
        }
        int length = strDeleteWhitespace.length();
        int i = 0;
        while (i < length && strDeleteWhitespace.charAt(i) == '[') {
            i++;
            if (i > 255) {
                throw new IllegalArgumentException(String.format("Maximum array dimension %d exceeded", 255));
            }
        }
        if (i >= length) {
            throw new IllegalArgumentException(String.format("Invalid class name %s", str));
        }
        if (i < 1) {
            return strDeleteWhitespace;
        }
        String strSubstring2 = strDeleteWhitespace.substring(i);
        if (strSubstring2.startsWith("L")) {
            if (!strSubstring2.endsWith(";") || strSubstring2.length() < 3) {
                throw new IllegalArgumentException(String.format("Invalid class name %s", str));
            }
            strSubstring = strSubstring2.substring(1, strSubstring2.length() - 1);
        } else if (strSubstring2.length() == 1) {
            String str2 = (String) REVERSE_ABBREVIATION_MAP.get(strSubstring2.substring(0, 1));
            if (str2 == null) {
                throw new IllegalArgumentException(String.format("Invalid class name %s", str));
            }
            strSubstring = str2;
        } else {
            throw new IllegalArgumentException(String.format("Invalid class name %s", str));
        }
        StringBuilder sb = new StringBuilder(strSubstring.length() + (i * 2));
        sb.append(strSubstring);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return getClass(classLoader, str, true);
    }

    public static Class<?> getClass(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        int iLastIndexOf;
        do {
            try {
                Class<?> primitiveClass = getPrimitiveClass(str);
                if (primitiveClass == null) {
                    primitiveClass = Class.forName(toCanonicalName(str), z, classLoader);
                }
                return primitiveClass;
            } catch (ClassNotFoundException unused) {
                iLastIndexOf = str.lastIndexOf(46);
                if (iLastIndexOf != -1) {
                    str = str.substring(0, iLastIndexOf) + '$' + str.substring(iLastIndexOf + 1);
                }
            }
        } while (iLastIndexOf != -1);
        throw new ClassNotFoundException(str);
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return getClass(str, true);
    }

    public static Class<?> getClass(String str, boolean z) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return getClass(contextClassLoader, str, z);
    }

    public static <T> Class<T> getComponentType(Class<T[]> cls) {
        if (cls == null) {
            return null;
        }
        return (Class<T>) cls.getComponentType();
    }

    public static String getName(Class<?> cls) {
        return getName(cls, "");
    }

    public static String getName(Class<?> cls, String str) {
        return getName(cls, str, false);
    }

    static String getName(Class cls, String str, boolean z) {
        if (cls == null) {
            return str;
        }
        return z ? cls.getSimpleName() : cls.getName();
    }

    public static String getName(Object obj) {
        return getName(obj, "");
    }

    public static String getName(Object obj, String str) {
        return obj == null ? str : obj.getClass().getName();
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return getPackageCanonicalName(cls.getName());
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    public static String getPackageName(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return getPackageName(cls.getName());
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass());
    }

    public static String getPackageName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        int i = 0;
        while (str.charAt(i) == '[') {
            i++;
        }
        String strSubstring = str.substring(i);
        if (strSubstring.charAt(0) == 'L' && strSubstring.charAt(strSubstring.length() - 1) == ';') {
            strSubstring = strSubstring.substring(1);
        }
        int iLastIndexOf = strSubstring.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : strSubstring.substring(0, iLastIndexOf);
    }

    static Class getPrimitiveClass(String str) {
        return (Class) NAME_PRIMITIVE_MAP.get(str);
    }

    public static Method getPublicMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (isPublic(method.getDeclaringClass())) {
            return method;
        }
        ArrayList<Class> arrayList = new ArrayList(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        for (Class cls2 : arrayList) {
            if (isPublic(cls2)) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException unused) {
                    continue;
                }
            }
        }
        throw new NoSuchMethodException("Can't find a public method for " + str + " " + ArrayUtils.toString(clsArr));
    }

    public static String getShortCanonicalName(Class<?> cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getCanonicalName());
    }

    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass());
    }

    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    public static String getShortClassName(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return getShortClassName(cls.getName());
    }

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass());
    }

    public static String getShortClassName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            Map map = REVERSE_ABBREVIATION_MAP;
            if (map.containsKey(str)) {
                str = (String) map.get(str);
            }
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iIndexOf = str.indexOf(36, iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', '.');
        }
        return strSubstring + ((Object) sb);
    }

    public static String getSimpleName(Class<?> cls) {
        return getSimpleName(cls, "");
    }

    public static String getSimpleName(Class<?> cls, String str) {
        return cls == null ? str : cls.getSimpleName();
    }

    public static String getSimpleName(Object obj) {
        return getSimpleName(obj, "");
    }

    public static String getSimpleName(Object obj, String str) {
        return obj == null ? str : obj.getClass().getSimpleName();
    }

    public static Iterable<Class<?>> hierarchy(Class<?> cls) {
        return hierarchy(cls, Interfaces.EXCLUDE);
    }

    public static Iterable<Class<?>> hierarchy(final Class<?> cls, Interfaces interfaces) {
        final Iterable<Class<?>> iterable = new Iterable() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda5
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return ClassUtils.lambda$hierarchy$0(cls);
            }
        };
        return interfaces != Interfaces.INCLUDE ? iterable : new Iterable() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda6
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return ClassUtils.lambda$hierarchy$1(iterable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$hierarchy$0(Class cls) {
        final AtomicReference atomicReference = new AtomicReference(cls);
        return new Iterator() { // from class: org.apache.commons.lang3.ClassUtils.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return atomicReference.get() != null;
            }

            @Override // java.util.Iterator
            public Class next() {
                return (Class) atomicReference.getAndUpdate(new UnaryOperator() { // from class: org.apache.commons.lang3.ClassUtils$1$$ExternalSyntheticLambda0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((Class) obj).getSuperclass();
                    }
                });
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$hierarchy$1(Iterable iterable) {
        final HashSet hashSet = new HashSet();
        final Iterator it = iterable.iterator();
        return new Iterator() { // from class: org.apache.commons.lang3.ClassUtils.2
            Iterator interfaces = Collections.emptyIterator();

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.interfaces.hasNext() || it.hasNext();
            }

            @Override // java.util.Iterator
            public Class next() {
                if (this.interfaces.hasNext()) {
                    Class cls = (Class) this.interfaces.next();
                    hashSet.add(cls);
                    return cls;
                }
                Class cls2 = (Class) it.next();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                walkInterfaces(linkedHashSet, cls2);
                this.interfaces = linkedHashSet.iterator();
                return cls2;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            private void walkInterfaces(Set set, Class cls) {
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (!hashSet.contains(cls2)) {
                        set.add(cls2);
                    }
                    walkInterfaces(set, cls2);
                }
            }
        };
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        return isAssignable(cls, cls2, true);
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if (!cls2.isPrimitive()) {
                return false;
            }
            Class cls3 = Integer.TYPE;
            if (cls3.equals(cls)) {
                return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            Class cls4 = Long.TYPE;
            if (cls4.equals(cls)) {
                return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Boolean.TYPE.equals(cls)) {
                return false;
            }
            Class cls5 = Double.TYPE;
            if (cls5.equals(cls)) {
                return false;
            }
            Class cls6 = Float.TYPE;
            if (cls6.equals(cls)) {
                return cls5.equals(cls2);
            }
            if (!Character.TYPE.equals(cls)) {
                Class cls7 = Short.TYPE;
                if (!cls7.equals(cls)) {
                    if (Byte.TYPE.equals(cls)) {
                        return cls7.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
                    }
                    return false;
                }
            }
            return cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>... clsArr2) {
        return isAssignable(clsArr, clsArr2, true);
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!ArrayUtils.isSameLength((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Class<?>[] clsArrNullToEmpty2 = ArrayUtils.nullToEmpty(clsArr2);
        for (int i = 0; i < clsArrNullToEmpty.length; i++) {
            if (!isAssignable(clsArrNullToEmpty[i], clsArrNullToEmpty2[i], z)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInnerClass(Class<?> cls) {
        return (cls == null || cls.getEnclosingClass() == null) ? false : true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        return (cls != null && cls.isPrimitive()) || isPrimitiveWrapper(cls);
    }

    public static boolean isPrimitiveWrapper(Class<?> cls) {
        return WRAPPER_PRIMITIVE_MAP.containsKey(cls);
    }

    public static boolean isPublic(Class<?> cls) {
        return Modifier.isPublic(cls.getModifiers());
    }

    public static Class<?>[] primitivesToWrappers(final Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        return clsArr.length == 0 ? clsArr : (Class[]) ArrayUtils.setAll(new Class[clsArr.length], new IntFunction() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda10
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return ClassUtils.lambda$primitivesToWrappers$0(clsArr, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$primitivesToWrappers$0(Class[] clsArr, int i) {
        return primitiveToWrapper(clsArr[i]);
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : (Class) PRIMITIVE_WRAPPER_MAP.get(cls);
    }

    private static String toCanonicalName(String str) {
        String strDeleteWhitespace = StringUtils.deleteWhitespace(str);
        Objects.requireNonNull(strDeleteWhitespace, "className");
        if (!strDeleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return strDeleteWhitespace;
        }
        StringBuilder sb = new StringBuilder();
        while (strDeleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            strDeleteWhitespace = strDeleteWhitespace.substring(0, strDeleteWhitespace.length() - 2);
            sb.append("[");
        }
        String str2 = (String) ABBREVIATION_MAP.get(strDeleteWhitespace);
        if (str2 != null) {
            sb.append(str2);
        } else {
            sb.append("L");
            sb.append(strDeleteWhitespace);
            sb.append(";");
        }
        return sb.toString();
    }

    public static Class<?>[] toClass(final Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        return (Class[]) ArrayUtils.setAll(new Class[objArr.length], new IntFunction() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda8
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return ClassUtils.lambda$toClass$0(objArr, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$toClass$0(Object[] objArr, int i) {
        Object obj = objArr[i];
        if (obj == null) {
            return null;
        }
        return obj.getClass();
    }

    public static Class<?>[] wrappersToPrimitives(final Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        return clsArr.length == 0 ? clsArr : (Class[]) ArrayUtils.setAll(new Class[clsArr.length], new IntFunction() { // from class: org.apache.commons.lang3.ClassUtils$$ExternalSyntheticLambda9
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return ClassUtils.lambda$wrappersToPrimitives$0(clsArr, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$wrappersToPrimitives$0(Class[] clsArr, int i) {
        return wrapperToPrimitive(clsArr[i]);
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return (Class) WRAPPER_PRIMITIVE_MAP.get(cls);
    }

    @Deprecated
    public ClassUtils() {
    }
}
