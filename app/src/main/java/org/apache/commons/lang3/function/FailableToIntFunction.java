package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableToIntFunction<T, E extends Throwable> {
    public static final FailableToIntFunction NOP = new FailableToIntFunction() { // from class: org.apache.commons.lang3.function.FailableToIntFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableToIntFunction
        public final int applyAsInt(Object obj) {
            return FailableToIntFunction.lambda$static$0(obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(Object obj) {
        return 0;
    }

    int applyAsInt(T t) throws Throwable;

    static <T, E extends Throwable> FailableToIntFunction<T, E> nop() {
        return NOP;
    }
}
