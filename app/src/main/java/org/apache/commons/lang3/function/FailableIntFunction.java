package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableIntFunction<R, E extends Throwable> {
    public static final FailableIntFunction NOP = new FailableIntFunction() { // from class: org.apache.commons.lang3.function.FailableIntFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableIntFunction
        public final Object apply(int i) {
            return FailableIntFunction.lambda$static$0(i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(int i) {
        return null;
    }

    R apply(int i) throws Throwable;

    static <R, E extends Throwable> FailableIntFunction<R, E> nop() {
        return NOP;
    }
}
