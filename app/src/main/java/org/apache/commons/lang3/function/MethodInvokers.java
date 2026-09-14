package org.apache.commons.lang3.function;

import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleProxies;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.commons.lang3.exception.UncheckedIllegalAccessException;

/* JADX INFO: loaded from: classes6.dex */
public final class MethodInvokers {
    public static <T, U> BiConsumer<T, U> asBiConsumer(Method method) {
        return (BiConsumer) asInterfaceInstance(BiConsumer.class, method);
    }

    public static <T, U, R> BiFunction<T, U, R> asBiFunction(Method method) {
        return (BiFunction) asInterfaceInstance(BiFunction.class, method);
    }

    public static <T, U> FailableBiConsumer<T, U, Throwable> asFailableBiConsumer(Method method) {
        return (FailableBiConsumer) asInterfaceInstance(FailableBiConsumer.class, method);
    }

    public static <T, U, R> FailableBiFunction<T, U, R, Throwable> asFailableBiFunction(Method method) {
        return (FailableBiFunction) asInterfaceInstance(FailableBiFunction.class, method);
    }

    public static <T, R> FailableFunction<T, R, Throwable> asFailableFunction(Method method) {
        return (FailableFunction) asInterfaceInstance(FailableFunction.class, method);
    }

    public static <R> FailableSupplier<R, Throwable> asFailableSupplier(Method method) {
        return (FailableSupplier) asInterfaceInstance(FailableSupplier.class, method);
    }

    public static <T, R> Function<T, R> asFunction(Method method) {
        return (Function) asInterfaceInstance(Function.class, method);
    }

    public static <T> T asInterfaceInstance(Class<T> cls, Method method) {
        Objects.requireNonNull(cls, "interfaceClass");
        return (T) MethodHandleProxies.asInterfaceInstance(cls, unreflectUnchecked(method));
    }

    public static <R> Supplier<R> asSupplier(Method method) {
        return (Supplier) asInterfaceInstance(Supplier.class, method);
    }

    private static Method requireMethod(Method method) {
        Objects.requireNonNull(method, TCEventPropertiesNames.TCE_METHOD);
        return method;
    }

    private static MethodHandle unreflect(Method method) {
        return MethodHandles.lookup().unreflect(requireMethod(method));
    }

    private static MethodHandle unreflectUnchecked(Method method) {
        try {
            return unreflect(method);
        } catch (IllegalAccessException e) {
            throw new UncheckedIllegalAccessException(e);
        }
    }
}
