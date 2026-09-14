package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableToLongFunction<T, E extends Throwable> {
    public static final FailableToLongFunction NOP = new FailableToLongFunction() { // from class: org.apache.commons.lang3.function.FailableToLongFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableToLongFunction
        public final long applyAsLong(Object obj) {
            return FailableToLongFunction.lambda$static$0(obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(Object obj) {
        return 0L;
    }

    long applyAsLong(T t) throws Throwable;

    static <T, E extends Throwable> FailableToLongFunction<T, E> nop() {
        return NOP;
    }
}
