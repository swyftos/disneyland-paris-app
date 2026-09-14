package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableLongFunction<R, E extends Throwable> {
    public static final FailableLongFunction NOP = new FailableLongFunction() { // from class: org.apache.commons.lang3.function.FailableLongFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableLongFunction
        public final Object apply(long j) {
            return FailableLongFunction.lambda$static$0(j);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(long j) {
        return null;
    }

    R apply(long j) throws Throwable;

    static <R, E extends Throwable> FailableLongFunction<R, E> nop() {
        return NOP;
    }
}
