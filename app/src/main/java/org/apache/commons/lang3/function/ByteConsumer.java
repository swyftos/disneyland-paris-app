package org.apache.commons.lang3.function;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface ByteConsumer {
    public static final ByteConsumer NOP = new ByteConsumer() { // from class: org.apache.commons.lang3.function.ByteConsumer$$ExternalSyntheticLambda1
        @Override // org.apache.commons.lang3.function.ByteConsumer
        public final void accept(byte b) {
            ByteConsumer.lambda$static$0(b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(byte b) {
    }

    void accept(byte b);

    static ByteConsumer nop() {
        return NOP;
    }

    default ByteConsumer andThen(final ByteConsumer byteConsumer) {
        Objects.requireNonNull(byteConsumer);
        return new ByteConsumer() { // from class: org.apache.commons.lang3.function.ByteConsumer$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.ByteConsumer
            public final void accept(byte b) {
                this.f$0.lambda$andThen$0(byteConsumer, b);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$0(ByteConsumer byteConsumer, byte b) {
        accept(b);
        byteConsumer.accept(b);
    }
}
