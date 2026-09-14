package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableToBooleanFunction<T, E extends Throwable> {
    public static final FailableToBooleanFunction NOP = new FailableToBooleanFunction() { // from class: org.apache.commons.lang3.function.FailableToBooleanFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableToBooleanFunction
        public final boolean applyAsBoolean(Object obj) {
            return FailableToBooleanFunction.lambda$static$0(obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(Object obj) {
        return false;
    }

    boolean applyAsBoolean(T t) throws Throwable;

    static <T, E extends Throwable> FailableToBooleanFunction<T, E> nop() {
        return NOP;
    }
}
