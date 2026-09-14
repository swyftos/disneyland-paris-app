package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.time.DurationUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ObjectUtils {
    public static final Null NULL = new Null();

    public static byte CONST(byte b) {
        return b;
    }

    public static char CONST(char c) {
        return c;
    }

    public static double CONST(double d) {
        return d;
    }

    public static float CONST(float f) {
        return f;
    }

    public static int CONST(int i) {
        return i;
    }

    public static long CONST(long j) {
        return j;
    }

    public static <T> T CONST(T t) {
        return t;
    }

    public static short CONST(short s) {
        return s;
    }

    public static boolean CONST(boolean z) {
        return z;
    }

    public static <T> T getIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static boolean allNotNull(Object... objArr) {
        return objArr != null && Stream.of(objArr).noneMatch(new Predicate() { // from class: org.apache.commons.lang3.ObjectUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.isNull(obj);
            }
        });
    }

    public static boolean allNull(Object... objArr) {
        return !anyNotNull(objArr);
    }

    public static boolean anyNotNull(Object... objArr) {
        return firstNonNull(objArr) != null;
    }

    public static boolean anyNull(Object... objArr) {
        return !allNotNull(objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T clone(T t) {
        if (!(t instanceof Cloneable)) {
            return null;
        }
        Class<?> cls = t.getClass();
        if (isArray(t)) {
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive()) {
                int length = Array.getLength(t);
                T t2 = (T) Array.newInstance(componentType, length);
                while (true) {
                    int i = length - 1;
                    if (length <= 0) {
                        return t2;
                    }
                    Array.set(t2, i, Array.get(t, i));
                    length = i;
                }
            } else {
                return (T) ((Object[]) t).clone();
            }
        } else {
            try {
                return (T) cls.getMethod("clone", new Class[0]).invoke(t, new Object[0]);
            } catch (ReflectiveOperationException e) {
                throw new CloneFailedException("Exception cloning Cloneable type " + cls.getName(), e);
            }
        }
    }

    public static <T> T cloneIfPossible(T t) {
        T t2 = (T) clone(t);
        return t2 == null ? t : t2;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2) {
        return compare(t, t2, false);
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2, boolean z) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return z ? 1 : -1;
        }
        if (t2 == null) {
            return z ? -1 : 1;
        }
        return t.compareTo(t2);
    }

    public static byte CONST_BYTE(int i) {
        if (i >= -128 && i <= 127) {
            return (byte) i;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + i + "]");
    }

    public static short CONST_SHORT(int i) {
        if (i >= -32768 && i <= 32767) {
            return (short) i;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + i + "]");
    }

    @Deprecated
    public static <T> T defaultIfNull(T t, T t2) {
        return (T) getIfNull(t, t2);
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @SafeVarargs
    public static <T> T firstNonNull(T... tArr) {
        return org.apache.commons.lang3.stream.Streams.m1973of(tArr).filter(new ObjectUtils$$ExternalSyntheticLambda0()).findFirst().orElse(null);
    }

    public static <T> Class<T> getClass(T t) {
        if (t == null) {
            return null;
        }
        return (Class<T>) t.getClass();
    }

    @SafeVarargs
    public static <T> T getFirstNonNull(Supplier<T>... supplierArr) {
        return org.apache.commons.lang3.stream.Streams.m1973of(supplierArr).filter(new Predicate() { // from class: org.apache.commons.lang3.ObjectUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((Supplier) obj);
            }
        }).map(new Function() { // from class: org.apache.commons.lang3.ObjectUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Supplier) obj).get();
            }
        }).filter(new ObjectUtils$$ExternalSyntheticLambda0()).findFirst().orElse(null);
    }

    public static <T> T getIfNull(T t, Supplier<T> supplier) {
        return t != null ? t : (T) Suppliers.get(supplier);
    }

    @Deprecated
    public static int hashCode(Object obj) {
        return Objects.hashCode(obj);
    }

    public static String hashCodeHex(Object obj) {
        return Integer.toHexString(Objects.hashCode(obj));
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int iHashCode = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                iHashCode = (iHashCode * 31) + Objects.hashCode(obj);
            }
        }
        return iHashCode;
    }

    public static String identityHashCodeHex(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        Objects.requireNonNull(obj, "object");
        appendable.append(obj.getClass().getName()).append('@').append(identityHashCodeHex(obj));
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        StringBuilder sb = new StringBuilder(name.length() + 1 + strIdentityHashCodeHex.length());
        sb.append(name);
        sb.append('@');
        sb.append(strIdentityHashCodeHex);
        return sb.toString();
    }

    @Deprecated
    public static void identityToString(StrBuilder strBuilder, Object obj) {
        Objects.requireNonNull(obj, "object");
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        strBuilder.ensureCapacity(strBuilder.length() + name.length() + 1 + strIdentityHashCodeHex.length());
        strBuilder.append(name).append('@').append(strIdentityHashCodeHex);
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Objects.requireNonNull(obj, "object");
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + strIdentityHashCodeHex.length());
        stringBuffer.append(name);
        stringBuffer.append('@');
        stringBuffer.append(strIdentityHashCodeHex);
    }

    public static void identityToString(StringBuilder sb, Object obj) {
        Objects.requireNonNull(obj, "object");
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        sb.ensureCapacity(sb.length() + name.length() + 1 + strIdentityHashCodeHex.length());
        sb.append(name);
        sb.append('@');
        sb.append(strIdentityHashCodeHex);
    }

    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (isArray(obj)) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Optional) {
            return !((Optional) obj).isPresent();
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, false) > 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Objects.requireNonNull(comparator, "comparator");
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, true) < 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap map = new HashMap(tArr.length);
        int i = 0;
        for (T t : tArr) {
            ArrayUtils.increment(map, t);
        }
        while (true) {
            T t2 = null;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((MutableInt) entry.getValue()).intValue();
                if (iIntValue != i) {
                    if (iIntValue > i) {
                        t2 = (T) entry.getKey();
                        i = iIntValue;
                    }
                }
            }
            return t2;
        }
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !Objects.equals(obj, obj2);
    }

    public static <T> T requireNonEmpty(T t) {
        return (T) requireNonEmpty(t, "object");
    }

    public static <T> T requireNonEmpty(T t, String str) {
        Objects.requireNonNull(t, str);
        if (isEmpty(t)) {
            throw new IllegalArgumentException(str);
        }
        return t;
    }

    public static String toString(Object obj) {
        return Objects.toString(obj, "");
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return Objects.toString(obj, str);
    }

    public static String toString(Supplier<Object> supplier, Supplier<String> supplier2) {
        return supplier == null ? (String) Suppliers.get(supplier2) : toString(supplier.get(), supplier2);
    }

    public static <T> String toString(T t, Supplier<String> supplier) {
        return t == null ? (String) Suppliers.get(supplier) : t.toString();
    }

    public static void wait(final Object obj, Duration duration) throws Throwable {
        Objects.requireNonNull(obj);
        DurationUtils.accept(new FailableBiConsumer() { // from class: org.apache.commons.lang3.ObjectUtils$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.function.FailableBiConsumer
            public final void accept(Object obj2, Object obj3) throws InterruptedException {
                obj.wait(((Long) obj2).longValue(), ((Integer) obj3).intValue());
            }
        }, DurationUtils.zeroIfNull(duration));
    }

    @Deprecated
    public ObjectUtils() {
    }
}
