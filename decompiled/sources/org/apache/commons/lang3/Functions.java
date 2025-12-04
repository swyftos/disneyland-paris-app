package org.apache.commons.lang3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;

/* loaded from: classes6.dex */
public class Functions {

    @FunctionalInterface
    public interface FailableBiConsumer<O1, O2, T extends Throwable> {
        void accept(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    public interface FailableBiFunction<I1, I2, O, T extends Throwable> {
        O apply(I1 i1, I2 i2) throws Throwable;
    }

    @FunctionalInterface
    public interface FailableBiPredicate<O1, O2, T extends Throwable> {
        boolean test(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    public interface FailableCallable<O, T extends Throwable> {
        O call() throws Throwable;
    }

    @FunctionalInterface
    public interface FailableConsumer<O, T extends Throwable> {
        void accept(O o) throws Throwable;
    }

    @FunctionalInterface
    public interface FailableFunction<I, O, T extends Throwable> {
        O apply(I i) throws Throwable;
    }

    @FunctionalInterface
    public interface FailablePredicate<O, T extends Throwable> {
        boolean test(O o) throws Throwable;
    }

    @FunctionalInterface
    public interface FailableRunnable<T extends Throwable> {
        void run() throws Throwable;
    }

    public static <T extends Throwable> void run(FailableRunnable<T> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O, T extends Throwable> O call(FailableCallable<O, T> failableCallable) {
        try {
            return failableCallable.call();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O, T extends Throwable> void accept(FailableConsumer<O, T> failableConsumer, O o) {
        try {
            failableConsumer.accept(o);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> failableBiConsumer, O1 o1, O2 o2) {
        try {
            failableBiConsumer.accept(o1, o2);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> failableFunction, I i) {
        try {
            return failableFunction.apply(i);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <I1, I2, O, T extends Throwable> O apply(FailableBiFunction<I1, I2, O, T> failableBiFunction, I1 i1, I2 i2) {
        try {
            return failableBiFunction.apply(i1, i2);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> failablePredicate, O o) {
        try {
            return failablePredicate.test(o);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> failableBiPredicate, O1 o1, O2 o2) {
        try {
            return failableBiPredicate.test(o1, o2);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            failableConsumer = new FailableConsumer() { // from class: org.apache.commons.lang3.Functions$$ExternalSyntheticLambda0
                @Override // org.apache.commons.lang3.Functions.FailableConsumer
                public final void accept(Object obj) {
                    Functions.rethrow((Throwable) obj);
                }
            };
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable2 : failableRunnableArr) {
                if (failableRunnable2 == null) {
                    throw new NullPointerException("A resource action must not be null.");
                }
            }
        }
        try {
            failableRunnable.run();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable3 : failableRunnableArr) {
                try {
                    failableRunnable3.run();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
            }
        }
        if (th != null) {
            try {
                failableConsumer.accept(th);
            } catch (Throwable th3) {
                throw rethrow(th3);
            }
        }
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, null, failableRunnableArr);
    }

    public static RuntimeException rethrow(Throwable th) {
        if (th == null) {
            throw new NullPointerException("The Throwable must not be null.");
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (th instanceof IOException) {
            throw new UncheckedIOException((IOException) th);
        }
        throw new UndeclaredThrowableException(th);
    }
}
