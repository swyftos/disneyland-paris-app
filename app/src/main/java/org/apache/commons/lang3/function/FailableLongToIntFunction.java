package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableLongToIntFunction<E extends Throwable> {
    public static final FailableLongToIntFunction NOP = new FailableLongToIntFunction() { // from class: org.apache.commons.lang3.function.FailableLongToIntFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableLongToIntFunction
        public final int applyAsInt(long j) {
            return FailableLongToIntFunction.lambda$static$0(j);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(long j) {
        return 0;
    }

    int applyAsInt(long j) throws Throwable;

    static <E extends Throwable> FailableLongToIntFunction<E> nop() {
        return NOP;
    }
}
