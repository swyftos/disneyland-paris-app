package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableDoubleFunction<R, E extends Throwable> {
    public static final FailableDoubleFunction NOP = new FailableDoubleFunction() { // from class: org.apache.commons.lang3.function.FailableDoubleFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableDoubleFunction
        public final Object apply(double d) {
            return FailableDoubleFunction.lambda$static$0(d);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(double d) {
        return null;
    }

    R apply(double d) throws Throwable;

    static <R, E extends Throwable> FailableDoubleFunction<R, E> nop() {
        return NOP;
    }
}
