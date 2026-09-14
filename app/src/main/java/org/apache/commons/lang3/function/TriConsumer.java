package org.apache.commons.lang3.function;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface TriConsumer<T, U, V> {
    void accept(T t, U u, V v);

    default TriConsumer<T, U, V> andThen(final TriConsumer<? super T, ? super U, ? super V> triConsumer) {
        Objects.requireNonNull(triConsumer);
        return new TriConsumer() { // from class: org.apache.commons.lang3.function.TriConsumer$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.TriConsumer
            public final void accept(Object obj, Object obj2, Object obj3) {
                this.f$0.lambda$andThen$0(triConsumer, obj, obj2, obj3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default void lambda$andThen$0(TriConsumer triConsumer, Object obj, Object obj2, Object obj3) {
        accept(obj, obj2, obj3);
        triConsumer.accept(obj, obj2, obj3);
    }
}
