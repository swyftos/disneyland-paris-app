package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableToLongBiFunction<T, U, E extends Throwable> {
    public static final FailableToLongBiFunction NOP = new FailableToLongBiFunction() { // from class: org.apache.commons.lang3.function.FailableToLongBiFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableToLongBiFunction
        public final long applyAsLong(Object obj, Object obj2) {
            return FailableToLongBiFunction.lambda$static$0(obj, obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(Object obj, Object obj2) {
        return 0L;
    }

    long applyAsLong(T t, U u) throws Throwable;

    static <T, U, E extends Throwable> FailableToLongBiFunction<T, U, E> nop() {
        return NOP;
    }
}
