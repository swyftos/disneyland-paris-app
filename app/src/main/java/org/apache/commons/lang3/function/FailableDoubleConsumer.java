package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableDoubleConsumer<E extends Throwable> {
    public static final FailableDoubleConsumer NOP = new FailableDoubleConsumer() { // from class: org.apache.commons.lang3.function.FailableDoubleConsumer$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableDoubleConsumer
        public final void accept(double d) {
            FailableDoubleConsumer.lambda$static$0(d);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(double d) {
    }

    void accept(double d) throws Throwable;

    static <E extends Throwable> FailableDoubleConsumer<E> nop() {
        return NOP;
    }

    default FailableDoubleConsumer<E> andThen(final FailableDoubleConsumer<E> failableDoubleConsumer) {
        Objects.requireNonNull(failableDoubleConsumer);
        return new FailableDoubleConsumer() { // from class: org.apache.commons.lang3.function.FailableDoubleConsumer$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.function.FailableDoubleConsumer
            public final void accept(double d) throws Throwable {
                this.f$0.lambda$andThen$0(failableDoubleConsumer, d);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$0(FailableDoubleConsumer failableDoubleConsumer, double d) throws Throwable {
        accept(d);
        failableDoubleConsumer.accept(d);
    }
}
