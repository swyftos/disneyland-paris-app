package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableFunction<T, R, E extends Throwable> {
    public static final FailableFunction NOP = new FailableFunction() { // from class: org.apache.commons.lang3.function.FailableFunction$$ExternalSyntheticLambda1
        @Override // org.apache.commons.lang3.function.FailableFunction
        public final Object apply(Object obj) {
            return FailableFunction.lambda$static$0(obj);
        }
    };

    static <T, R, E extends Throwable> FailableFunction<T, R, E> function(FailableFunction<T, R, E> failableFunction) {
        return failableFunction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$identity$0(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(Object obj) {
        return null;
    }

    R apply(T t) throws Throwable;

    static <T, E extends Throwable> FailableFunction<T, T, E> identity() {
        return new FailableFunction() { // from class: org.apache.commons.lang3.function.FailableFunction$$ExternalSyntheticLambda3
            @Override // org.apache.commons.lang3.function.FailableFunction
            public final Object apply(Object obj) {
                return FailableFunction.lambda$identity$0(obj);
            }
        };
    }

    static <T, R, E extends Throwable> FailableFunction<T, R, E> nop() {
        return NOP;
    }

    default <V> FailableFunction<T, V, E> andThen(final FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new FailableFunction() { // from class: org.apache.commons.lang3.function.FailableFunction$$ExternalSyntheticLambda2
            @Override // org.apache.commons.lang3.function.FailableFunction
            public final Object apply(Object obj) {
                return this.f$0.lambda$andThen$0(failableFunction, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$andThen$0(FailableFunction failableFunction, Object obj) {
        return failableFunction.apply(apply(obj));
    }

    default <V> FailableFunction<V, R, E> compose(final FailableFunction<? super V, ? extends T, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new FailableFunction() { // from class: org.apache.commons.lang3.function.FailableFunction$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.FailableFunction
            public final Object apply(Object obj) {
                return this.f$0.lambda$compose$0(failableFunction, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$compose$0(FailableFunction failableFunction, Object obj) {
        return apply(failableFunction.apply(obj));
    }
}
