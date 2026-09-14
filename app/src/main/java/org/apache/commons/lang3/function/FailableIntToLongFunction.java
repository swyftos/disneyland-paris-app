package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableIntToLongFunction<E extends Throwable> {
    public static final FailableIntToLongFunction NOP = new FailableIntToLongFunction() { // from class: org.apache.commons.lang3.function.FailableIntToLongFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableIntToLongFunction
        public final long applyAsLong(int i) {
            return FailableIntToLongFunction.lambda$static$0(i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(int i) {
        return 0L;
    }

    long applyAsLong(int i) throws Throwable;

    static <E extends Throwable> FailableIntToLongFunction<E> nop() {
        return NOP;
    }
}
