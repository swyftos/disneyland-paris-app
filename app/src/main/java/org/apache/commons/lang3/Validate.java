package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class Validate {
    public static void exclusiveBetween(double d, double d2, double d3) {
        if (d3 <= d || d3 >= d2) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
        }
    }

    public static void exclusiveBetween(double d, double d2, double d3, String str) {
        if (d3 <= d || d3 >= d2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void exclusiveBetween(long j, long j2, long j3) {
        if (j3 <= j || j3 >= j2) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", Long.valueOf(j3), Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void exclusiveBetween(long j, long j2, long j3, String str) {
        if (j3 <= j || j3 >= j2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", comparable, t, t2));
        }
    }

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
    }

    public static void finite(double d) {
        finite(d, "The value is invalid: %f", Double.valueOf(d));
    }

    public static void finite(double d, String str, Object... objArr) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getMessage(String str, Object... objArr) {
        return ArrayUtils.isEmpty(objArr) ? str : String.format(str, objArr);
    }

    public static void inclusiveBetween(double d, double d2, double d3) {
        if (d3 < d || d3 > d2) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
        }
    }

    public static void inclusiveBetween(double d, double d2, double d3, String str) {
        if (d3 < d || d3 > d2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void inclusiveBetween(long j, long j2, long j3) {
        if (j3 < j || j3 > j2) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", Long.valueOf(j3), Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void inclusiveBetween(long j, long j2, long j3, String str) {
        if (j3 < j || j3 > j2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", comparable, t, t2));
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null || cls == null || !cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("Cannot assign a %s to a %s", ClassUtils.getName(cls2, "null type"), ClassUtils.getName(cls, "null type")));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format("Expected type: %s, actual: %s", cls.getName(), ClassUtils.getName(obj, "null")));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
    }

    public static void isTrue(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    public static void isTrue(boolean z, String str, double d) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, Double.valueOf(d)));
        }
    }

    public static void isTrue(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, Long.valueOf(j)));
        }
    }

    public static void isTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
    }

    public static void isTrue(boolean z, Supplier<String> supplier) {
        if (!z) {
            throw new IllegalArgumentException(supplier.get());
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format("The string %s does not match the pattern %s", charSequence, str));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(getMessage(str2, objArr));
        }
    }

    public static <T extends Iterable<?>> T noNullElements(T t) {
        return (T) noNullElements(t, "The validated collection contains null element at index: %d", new Object[0]);
    }

    public static <T extends Iterable<?>> T noNullElements(T t, final String str, final Object... objArr) {
        Objects.requireNonNull(t, "iterable");
        final AtomicInteger atomicInteger = new AtomicInteger();
        t.forEach(new Consumer() { // from class: org.apache.commons.lang3.Validate$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Validate.lambda$noNullElements$0(str, objArr, atomicInteger, obj);
            }
        });
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$noNullElements$0(String str, Object[] objArr, AtomicInteger atomicInteger, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(getMessage(str, ArrayUtils.addAll(objArr, Integer.valueOf(atomicInteger.getAndIncrement()))));
        }
    }

    public static <T> T[] noNullElements(T[] tArr) {
        return (T[]) noNullElements(tArr, "The validated array contains null element at index: %d", new Object[0]);
    }

    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        Objects.requireNonNull(tArr, "array");
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == null) {
                throw new IllegalArgumentException(getMessage(str, ArrayUtils.add((Integer[]) objArr, Integer.valueOf(i))));
            }
        }
        return tArr;
    }

    public static <T extends CharSequence> T notBlank(T t) {
        return (T) notBlank(t, "The validated character sequence is blank", new Object[0]);
    }

    public static <T extends CharSequence> T notBlank(T t, String str, Object... objArr) {
        Objects.requireNonNull(t, (Supplier<String>) toSupplier(str, objArr));
        if (StringUtils.isBlank(t)) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
        return t;
    }

    public static <T extends Collection<?>> T notEmpty(T t) {
        return (T) notEmpty(t, "The validated collection is empty", new Object[0]);
    }

    public static <T extends Map<?, ?>> T notEmpty(T t) {
        return (T) notEmpty(t, "The validated map is empty", new Object[0]);
    }

    public static <T extends CharSequence> T notEmpty(T t) {
        return (T) notEmpty(t, "The validated character sequence is empty", new Object[0]);
    }

    public static <T extends Collection<?>> T notEmpty(T t, String str, Object... objArr) {
        Objects.requireNonNull(t, (Supplier<String>) toSupplier(str, objArr));
        if (t.isEmpty()) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
        return t;
    }

    public static <T extends Map<?, ?>> T notEmpty(T t, String str, Object... objArr) {
        Objects.requireNonNull(t, (Supplier<String>) toSupplier(str, objArr));
        if (t.isEmpty()) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
        return t;
    }

    public static <T extends CharSequence> T notEmpty(T t, String str, Object... objArr) {
        Objects.requireNonNull(t, (Supplier<String>) toSupplier(str, objArr));
        if (t.length() != 0) {
            return t;
        }
        throw new IllegalArgumentException(getMessage(str, objArr));
    }

    public static <T> T[] notEmpty(T[] tArr) {
        return (T[]) notEmpty(tArr, "The validated array is empty", new Object[0]);
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        Objects.requireNonNull(tArr, (Supplier<String>) toSupplier(str, objArr));
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(getMessage(str, objArr));
    }

    public static void notNaN(double d) {
        notNaN(d, "The validated value is not a number", new Object[0]);
    }

    public static void notNaN(double d, String str, Object... objArr) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException(getMessage(str, objArr));
        }
    }

    @Deprecated
    public static <T> T notNull(T t) {
        return (T) notNull(t, "The validated object is null", new Object[0]);
    }

    public static <T> T notNull(T t, String str, Object... objArr) {
        Objects.requireNonNull(t, (Supplier<String>) toSupplier(str, objArr));
        return t;
    }

    private static Supplier toSupplier(final String str, final Object... objArr) {
        return new Supplier() { // from class: org.apache.commons.lang3.Validate$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Validate.getMessage(str, objArr);
            }
        };
    }

    public static <T extends Collection<?>> T validIndex(T t, int i) {
        return (T) validIndex(t, i, "The validated collection index is invalid: %d", Integer.valueOf(i));
    }

    public static <T extends CharSequence> T validIndex(T t, int i) {
        return (T) validIndex(t, i, "The validated character sequence index is invalid: %d", Integer.valueOf(i));
    }

    public static <T extends Collection<?>> T validIndex(T t, int i, String str, Object... objArr) {
        Objects.requireNonNull(t, "collection");
        if (i < 0 || i >= t.size()) {
            throw new IndexOutOfBoundsException(getMessage(str, objArr));
        }
        return t;
    }

    public static <T extends CharSequence> T validIndex(T t, int i, String str, Object... objArr) {
        Objects.requireNonNull(t, "chars");
        if (i < 0 || i >= t.length()) {
            throw new IndexOutOfBoundsException(getMessage(str, objArr));
        }
        return t;
    }

    public static <T> T[] validIndex(T[] tArr, int i) {
        return (T[]) validIndex(tArr, i, "The validated array index is invalid: %d", Integer.valueOf(i));
    }

    public static <T> T[] validIndex(T[] tArr, int i, String str, Object... objArr) {
        Objects.requireNonNull(tArr, "array");
        if (i < 0 || i >= tArr.length) {
            throw new IndexOutOfBoundsException(getMessage(str, objArr));
        }
        return tArr;
    }

    public static void validState(boolean z) {
        if (!z) {
            throw new IllegalStateException("The validated state is false");
        }
    }

    public static void validState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(getMessage(str, objArr));
        }
    }
}
