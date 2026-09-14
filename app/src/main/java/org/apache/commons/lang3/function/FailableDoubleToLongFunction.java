package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableDoubleToLongFunction<E extends Throwable> {
    public static final FailableDoubleToLongFunction NOP = new FailableDoubleToLongFunction() { // from class: org.apache.commons.lang3.function.FailableDoubleToLongFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableDoubleToLongFunction
        public final int applyAsLong(double d) {
            return FailableDoubleToLongFunction.lambda$static$0(d);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(double d) {
        return 0;
    }

    int applyAsLong(double d) throws Throwable;

    static <E extends Throwable> FailableDoubleToLongFunction<E> nop() {
        return NOP;
    }
}
