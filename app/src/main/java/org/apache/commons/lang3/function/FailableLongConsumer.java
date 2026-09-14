package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableLongConsumer<E extends Throwable> {
    public static final FailableLongConsumer NOP = new FailableLongConsumer() { // from class: org.apache.commons.lang3.function.FailableLongConsumer$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableLongConsumer
        public final void accept(long j) {
            FailableLongConsumer.lambda$static$0(j);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(long j) {
    }

    void accept(long j) throws Throwable;

    static <E extends Throwable> FailableLongConsumer<E> nop() {
        return NOP;
    }

    default FailableLongConsumer<E> andThen(final FailableLongConsumer<E> failableLongConsumer) {
        Objects.requireNonNull(failableLongConsumer);
        return new FailableLongConsumer() { // from class: org.apache.commons.lang3.function.FailableLongConsumer$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.function.FailableLongConsumer
            public final void accept(long j) throws Throwable {
                this.f$0.lambda$andThen$0(failableLongConsumer, j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$0(FailableLongConsumer failableLongConsumer, long j) throws Throwable {
        accept(j);
        failableLongConsumer.accept(j);
    }
}
