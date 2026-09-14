package org.apache.commons.lang3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Functions {

    @FunctionalInterface
    @Deprecated
    public interface FailableBiConsumer<O1, O2, T extends Throwable> {
        void accept(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableBiFunction<O1, O2, R, T extends Throwable> {
        R apply(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableBiPredicate<O1, O2, T extends Throwable> {
        boolean test(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableCallable<R, T extends Throwable> {
        R call() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableConsumer<O, T extends Throwable> {
        void accept(O o) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableFunction<I, R, T extends Throwable> {
        R apply(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailablePredicate<I, T extends Throwable> {
        boolean test(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableRunnable<T extends Throwable> {
        void run() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableSupplier<R, T extends Throwable> {
        R get() throws Throwable;
    }

    public static <O1, O2, T extends Throwable> void accept(final FailableBiConsumer<O1, O2, T> failableBiConsumer, final O1 o1, final O2 o2) {
        run(new FailableRunnable() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda9
            @Override // org.apache.commons.lang3.Functions.FailableRunnable
            public final void run() throws Throwable {
                failableBiConsumer.accept(o1, o2);
            }
        });
    }

    public static <O, T extends Throwable> void accept(final FailableConsumer<O, T> failableConsumer, final O o) {
        run(new FailableRunnable() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda4
            @Override // org.apache.commons.lang3.Functions.FailableRunnable
            public final void run() throws Throwable {
                failableConsumer.accept(o);
            }
        });
    }

    public static <O1, O2, O, T extends Throwable> O apply(final FailableBiFunction<O1, O2, O, T> failableBiFunction, final O1 o1, final O2 o2) {
        return (O) get(new FailableSupplier() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda10
            @Override // org.apache.commons.lang3.Functions.FailableSupplier
            public final Object get() {
                return failableBiFunction.apply(o1, o2);
            }
        });
    }

    public static <I, O, T extends Throwable> O apply(final FailableFunction<I, O, T> failableFunction, final I i) {
        return (O) get(new FailableSupplier() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.Functions.FailableSupplier
            public final Object get() {
                return failableFunction.apply(i);
            }
        });
    }

    public static <O1, O2> BiConsumer<O1, O2> asBiConsumer(final FailableBiConsumer<O1, O2, ?> failableBiConsumer) {
        return new BiConsumer() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda16
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Functions.accept(failableBiConsumer, obj, obj2);
            }
        };
    }

    public static <O1, O2, O> BiFunction<O1, O2, O> asBiFunction(final FailableBiFunction<O1, O2, O, ?> failableBiFunction) {
        return new BiFunction() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Functions.apply(failableBiFunction, obj, obj2);
            }
        };
    }

    public static <O1, O2> BiPredicate<O1, O2> asBiPredicate(final FailableBiPredicate<O1, O2, ?> failableBiPredicate) {
        return new BiPredicate() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda12
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return Functions.test(failableBiPredicate, obj, obj2);
            }
        };
    }

    public static <O> Callable<O> asCallable(final FailableCallable<O, ?> failableCallable) {
        return new Callable() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda18
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Functions.call(failableCallable);
            }
        };
    }

    public static <I> Consumer<I> asConsumer(final FailableConsumer<I, ?> failableConsumer) {
        return new Consumer() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda14
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Functions.accept(failableConsumer, obj);
            }
        };
    }

    public static <I, O> Function<I, O> asFunction(final FailableFunction<I, O, ?> failableFunction) {
        return new Function() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Functions.apply(failableFunction, obj);
            }
        };
    }

    public static <I> Predicate<I> asPredicate(final FailablePredicate<I, ?> failablePredicate) {
        return new Predicate() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Functions.test(failablePredicate, obj);
            }
        };
    }

    public static Runnable asRunnable(final FailableRunnable<?> failableRunnable) {
        return new Runnable() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                Functions.run(failableRunnable);
            }
        };
    }

    public static <O> Supplier<O> asSupplier(final FailableSupplier<O, ?> failableSupplier) {
        return new Supplier() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return Functions.get(failableSupplier);
            }
        };
    }

    public static <O, T extends Throwable> O call(final FailableCallable<O, T> failableCallable) {
        Objects.requireNonNull(failableCallable);
        return (O) get(new FailableSupplier() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda17
            @Override // org.apache.commons.lang3.Functions.FailableSupplier
            public final Object get() {
                return failableCallable.call();
            }
        });
    }

    public static <O, T extends Throwable> O get(FailableSupplier<O, T> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    private static boolean getAsBoolean(FailableBooleanSupplier failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static RuntimeException rethrow(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        ExceptionUtils.throwUnchecked(th);
        if (th instanceof IOException) {
            throw new UncheckedIOException((IOException) th);
        }
        throw new UndeclaredThrowableException(th);
    }

    public static <T extends Throwable> void run(FailableRunnable<T> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O> Streams.FailableStream<O> stream(Collection<O> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <O> Streams.FailableStream<O> stream(Stream<O> stream) {
        return new Streams.FailableStream<>(stream);
    }

    public static <O1, O2, T extends Throwable> boolean test(final FailableBiPredicate<O1, O2, T> failableBiPredicate, final O1 o1, final O2 o2) {
        return getAsBoolean(new FailableBooleanSupplier() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda13
            @Override // org.apache.commons.lang3.function.FailableBooleanSupplier
            public final boolean getAsBoolean() {
                return failableBiPredicate.test(o1, o2);
            }
        });
    }

    public static <O, T extends Throwable> boolean test(final FailablePredicate<O, T> failablePredicate, final O o) {
        return getAsBoolean(new FailableBooleanSupplier() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda15
            @Override // org.apache.commons.lang3.function.FailableBooleanSupplier
            public final boolean getAsBoolean() {
                return failablePredicate.test(o);
            }
        });
    }

    @SafeVarargs
    public static void tryWithResources(final FailableRunnable<? extends Throwable> failableRunnable, final FailableConsumer<Throwable, ? extends Throwable> failableConsumer, final FailableRunnable<? extends Throwable>... failableRunnableArr) {
        org.apache.commons.lang3.function.FailableRunnable[] failableRunnableArr2 = new org.apache.commons.lang3.function.FailableRunnable[failableRunnableArr.length];
        Arrays.setAll(failableRunnableArr2, new IntFunction() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda6
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return Functions.lambda$tryWithResources$0(failableRunnableArr, i);
            }
        });
        Objects.requireNonNull(failableRunnable);
        Failable.tryWithResources(new org.apache.commons.lang3.function.FailableRunnable() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda7
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() throws Throwable {
                failableRunnable.run();
            }
        }, failableConsumer != null ? new org.apache.commons.lang3.function.FailableConsumer() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda8
            @Override // org.apache.commons.lang3.function.FailableConsumer
            public final void accept(Object obj) throws Throwable {
                failableConsumer.accept((Throwable) obj);
            }
        } : null, failableRunnableArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ org.apache.commons.lang3.function.FailableRunnable lambda$tryWithResources$0(final FailableRunnable[] failableRunnableArr, final int i) {
        return new org.apache.commons.lang3.function.FailableRunnable() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda19
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() throws Throwable {
                Functions.lambda$tryWithResources$1(failableRunnableArr, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$tryWithResources$1(FailableRunnable[] failableRunnableArr, int i) throws Throwable {
        failableRunnableArr[i].run();
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, null, failableRunnableArr);
    }
}
