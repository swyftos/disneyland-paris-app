package org.apache.commons.lang3.function;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes6.dex */
public class Consumers {
    private static final Consumer NOP;

    static {
        final Function functionIdentity = Function.identity();
        Objects.requireNonNull(functionIdentity);
        NOP = new Consumer() { // from class: org.apache.commons.lang3.function.Consumers$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                functionIdentity.apply(obj);
            }
        };
    }

    public static <T> void accept(Consumer<T> consumer, T t) {
        if (consumer != null) {
            consumer.accept(t);
        }
    }

    public static <T> Consumer<T> nop() {
        return NOP;
    }
}
