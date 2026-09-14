package org.apache.commons.lang3.function;

import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);

    default <W> TriFunction<T, U, V, W> andThen(final Function<? super R, ? extends W> function) {
        Objects.requireNonNull(function);
        return new TriFunction() { // from class: org.apache.commons.lang3.function.TriFunction$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.TriFunction
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return this.f$0.lambda$andThen$0(function, obj, obj2, obj3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$andThen$0(Function function, Object obj, Object obj2, Object obj3) {
        return function.apply(apply(obj, obj2, obj3));
    }
}
