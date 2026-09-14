package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableObjLongConsumer<T, E extends Throwable> {
    public static final FailableObjLongConsumer NOP = new FailableObjLongConsumer() { // from class: org.apache.commons.lang3.function.FailableObjLongConsumer$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableObjLongConsumer
        public final void accept(Object obj, long j) {
            FailableObjLongConsumer.lambda$static$0(obj, j);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, long j) {
    }

    void accept(T t, long j) throws Throwable;

    static <T, E extends Throwable> FailableObjLongConsumer<T, E> nop() {
        return NOP;
    }
}
