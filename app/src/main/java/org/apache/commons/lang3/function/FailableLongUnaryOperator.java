package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public interface FailableLongUnaryOperator<E extends Throwable> {
    public static final FailableLongUnaryOperator NOP = new FailableLongUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableLongUnaryOperator$$ExternalSyntheticLambda2
        @Override // org.apache.commons.lang3.function.FailableLongUnaryOperator
        public final long applyAsLong(long j) {
            return FailableLongUnaryOperator.lambda$static$0(j);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$identity$0(long j) {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(long j) {
        return 0L;
    }

    long applyAsLong(long j) throws Throwable;

    static <E extends Throwable> FailableLongUnaryOperator<E> identity() {
        return new FailableLongUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableLongUnaryOperator$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.FailableLongUnaryOperator
            public final long applyAsLong(long j) {
                return FailableLongUnaryOperator.lambda$identity$0(j);
            }
        };
    }

    static <E extends Throwable> FailableLongUnaryOperator<E> nop() {
        return NOP;
    }

    default FailableLongUnaryOperator<E> andThen(final FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return new FailableLongUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableLongUnaryOperator$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.function.FailableLongUnaryOperator
            public final long applyAsLong(long j) {
                return this.f$0.lambda$andThen$0(failableLongUnaryOperator, j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default long lambda$andThen$0(FailableLongUnaryOperator failableLongUnaryOperator, long j) {
        return failableLongUnaryOperator.applyAsLong(applyAsLong(j));
    }

    default FailableLongUnaryOperator<E> compose(final FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return new FailableLongUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableLongUnaryOperator$$ExternalSyntheticLambda3
            @Override // org.apache.commons.lang3.function.FailableLongUnaryOperator
            public final long applyAsLong(long j) {
                return this.f$0.lambda$compose$0(failableLongUnaryOperator, j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default long lambda$compose$0(FailableLongUnaryOperator failableLongUnaryOperator, long j) {
        return applyAsLong(failableLongUnaryOperator.applyAsLong(j));
    }
}
