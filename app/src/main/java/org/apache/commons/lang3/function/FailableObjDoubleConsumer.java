package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableObjDoubleConsumer<T, E extends Throwable> {
    public static final FailableObjDoubleConsumer NOP = new FailableObjDoubleConsumer() { // from class: org.apache.commons.lang3.function.FailableObjDoubleConsumer$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableObjDoubleConsumer
        public final void accept(Object obj, double d) {
            FailableObjDoubleConsumer.lambda$static$0(obj, d);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, double d) {
    }

    void accept(T t, double d) throws Throwable;

    static <T, E extends Throwable> FailableObjDoubleConsumer<T, E> nop() {
        return NOP;
    }
}
