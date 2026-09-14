package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableByteConsumer<E extends Throwable> {
    public static final FailableByteConsumer NOP = new FailableByteConsumer() { // from class: org.apache.commons.lang3.function.FailableByteConsumer$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableByteConsumer
        public final void accept(byte b) {
            FailableByteConsumer.lambda$static$0(b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(byte b) {
    }

    void accept(byte b) throws Throwable;

    static <E extends Throwable> FailableByteConsumer<E> nop() {
        return NOP;
    }

    default FailableByteConsumer<E> andThen(final FailableByteConsumer<E> failableByteConsumer) {
        Objects.requireNonNull(failableByteConsumer);
        return new FailableByteConsumer() { // from class: org.apache.commons.lang3.function.FailableByteConsumer$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.function.FailableByteConsumer
            public final void accept(byte b) throws Throwable {
                this.f$0.lambda$andThen$0(failableByteConsumer, b);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$0(FailableByteConsumer failableByteConsumer, byte b) throws Throwable {
        accept(b);
        failableByteConsumer.accept(b);
    }
}
