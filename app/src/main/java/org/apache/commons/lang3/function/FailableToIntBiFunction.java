package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableToIntBiFunction<T, U, E extends Throwable> {
    public static final FailableToIntBiFunction NOP = new FailableToIntBiFunction() { // from class: org.apache.commons.lang3.function.FailableToIntBiFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableToIntBiFunction
        public final int applyAsInt(Object obj, Object obj2) {
            return FailableToIntBiFunction.lambda$static$0(obj, obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(Object obj, Object obj2) {
        return 0;
    }

    int applyAsInt(T t, U u) throws Throwable;

    static <T, U, E extends Throwable> FailableToIntBiFunction<T, U, E> nop() {
        return NOP;
    }
}
